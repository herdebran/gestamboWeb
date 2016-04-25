package ar.com.cristal.creditos.servicios.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.cristal.creditos.common.Constantes;
import ar.com.cristal.creditos.common.CristalProperties;
import ar.com.cristal.creditos.common.EstadoClienteEnum;
import ar.com.cristal.creditos.common.EstadoCreditoEnum;
import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.entity.commons.Empresa;
import ar.com.cristal.creditos.entity.commons.Tablas;
import ar.com.cristal.creditos.entity.creditos.Cheque;
import ar.com.cristal.creditos.entity.creditos.Cliente;
import ar.com.cristal.creditos.entity.creditos.ComportamientoPago;
import ar.com.cristal.creditos.entity.creditos.Credito;
import ar.com.cristal.creditos.entity.creditos.CuotaSocial;
import ar.com.cristal.creditos.entity.creditos.MorosidadPagoCliente;
import ar.com.cristal.creditos.entity.login.Usuario;
import ar.com.cristal.creditos.localidad.Localidad;
import ar.com.cristal.creditos.localidad.Reparticion;
import ar.com.cristal.creditos.servicios.ComunesService;
import ar.com.cristal.creditos.servicios.CreditosService;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.servicios.impl.ConsultaVerazImpl.VerazException;
import ar.com.cristal.creditos.util.CristalModelException;
import ar.com.cristal.creditos.util.DateUtil;
import ar.com.cristal.creditos.util.LogearUsuario;
import ar.com.cristal.creditos.util.MathUtil;

@Service("creditosService")
public class CreditosServiceImpl implements CreditosService {

	private static final String NUMERO_RECIBO = "numero_recibo";

	private static final int CANTIDAD_MAXIMA_DIAS_PARA_ANULAR = 7;

	public static final int UMBRAL_CAMBIO_MES_TOPE_SUPERIOR = 20;

	public static final int TOPE_SUPERIOR_DIA_REALIZACION_TAREA = 10;

	public static final int TOPE_INFERIOR_DIA_REALIZACION_TAREA = 28;

	private Logger log = Logger.getLogger(CreditosServiceImpl.class);

	@Autowired
	protected GenericDao genericDao;

	@Autowired
	private ConsultaVerazImpl consultaVerazService;

	@Autowired
	private ReporteService reporteService;

	@Autowired
	private ServiceFacade serviceFacade;

	private CristalProperties cristalProperties = CristalProperties
			.getInstance();

	private Integer cuotasMinimas = null;
	private Integer cuotasMinimasParalelo = null;

	public Integer getCuotasMinimasParalelo() throws Exception {
		if (cuotasMinimasParalelo == null)
			cuotasMinimasParalelo = Integer.valueOf(serviceFacade
					.getProperty(Constantes.CUOTAS_MINIMAS_PARALELO));
		return cuotasMinimasParalelo;
	}

	public Integer getCuotasMinimas() throws Exception {
		if (cuotasMinimas == null)
			cuotasMinimas = Integer.valueOf(serviceFacade
					.getProperty(Constantes.CUOTAS_MINIMAS_REFINANCIACION));
		return cuotasMinimas;
	}

	private static Object aprobarRechazarSincronizado = new Object();
	private static Object consultaVerazSincronizado = new Object();

	/***
	 * Query renovación 17/10/2012
	 */
	private final String queryRenovacion = "select * from Cliente cli where cli.estado in ('ACTIVO','BAJA') "
			+ "and not exists (select * from Credito where cliente_id = cli.id and estado = 'ACTIVO') "
			+ "and 0 < (select count(*) from Credito where cliente_id = cli.id) ";

	/***
	 * Query Refinanciacion
	 */
	// Nueva query refinanciacion (28/09/2012)
	private final String queryRefinanicacion = " select cred.* from Credito AS cred "
			+ "INNER JOIN Cliente as cli on cred.cliente_id = cli.id "
			+ "INNER JOIN SolicitudAprobacionCredito as sol on sol.id = cred.solicitudAprobacionCredito_id "
			+ "INNER JOIN PlanFinanciacion pf on pf.id = sol.idPlanFinanciacionOptimo "
			+ "INNER JOIN Reparticion rep on rep.id = cli.reparticion_id "
			+ "WHERE cred.estado = 'ACTIVO' "
			+ "AND cli.estado = 'ACTIVO' "
			+ "AND porcentajeRefinanciacion < 100 "
			+ "AND tipoSolicitud <> 'FINANCIACION' "
			+ "AND (porcentajeRefinanciacion/100) < ((select count(*) from Cuota where credito_id = cred.id and estado = 'PAGA') / cantidadCuotasSolicitadas) "
			+ "AND (cli.condicionMorosidad = '' or cli.condicionMorosidad is null) "
			+ "AND rep.tipoPrivado = 0 " + // solo los de reparticion pública
											// pueden refinanciar
			"AND cantidadCuotasSolicitadas >= :cantidadCuotasMinima ";

	/**
	 * Query paralelo
	 */
	private final String queryParalelo = "select cli.* "
			+ "from Credito AS cre  "
			+ "INNER JOIN Cliente as cli on cre.cliente_id = cli.id "
			+ "INNER JOIN SolicitudAprobacionCredito as s on cre.solicitudAprobacionCredito_id = s.id "
			+ "INNER JOIN PlanFinanciacion as p on s.idPlanFinanciacionOptimo = p.id "
			+ "INNER JOIN  Reparticion as rep on rep.id = cli.reparticion_id "
			+ "INNER JOIN  Localidad as loc on loc.id = cli.localidad_id "
			+ "WHERE cre.estado = 'ACTIVO' "
			+ "AND cli.estado = 'ACTIVO' "
			+ "AND permitePlanParalelo = 1 "
			+ "AND not exists (SELECT * from Cuota c where c.credito_id = cre.id and c.estado in ('VENCIDA', 'VENCIDA_INTENCIONAL')) "
			+ "AND (cli.condicionMorosidad = '' or cli.condicionMorosidad is null) "
			+ "GROUP BY cli.id HAVING count(*) = 1";

	private final String queryCreditosOtorgadosEfectivo = "select cre.* "
			+ "from Credito AS cre  "
			+ "INNER JOIN SolicitudAprobacionCredito as s on cre.solicitudAprobacionCredito_id = s.id "
			+ "WHERE cre.estado = 'ACTIVO' "
			+ "and tipoMedioEntregaEnum = 'EFECTIVO' "
			+ "and date(fechaCreacion) between date(:fechaDesde) and date(:fechaHasta) "
			+ "and sucursal = :nombreSucursal ";

	public String getQueryParalelo() {
		return queryParalelo;
	}

	@Override
	public String obtenerListadoPendientesDeposito() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Credito> obtenerCreditosByClientId(Long idCliente)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Credito> obtenerCreditosByClientId(Long idCliente, String estado)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isRefinanciarAvailable(Long idCredito, List<String> motivos)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente obtenerClientePorID(Long idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Credito obtenerCreditoPorID(Long idCredito) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarCredito(Credito cred) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Credito credito) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Empresa> obtenerListadoEmpresas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> obtenerClientesAptosParaOriginal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> obtenerClientesPotencialesParaRefinanciacion()
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean esClientesAptoParaOriginal(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean esClientesAptoParaParalelo(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean anularCredito(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer obtenerCantidadCuotasImpagasParaLegales(Credito c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cambiarEstadoACreditosYCuotas(Long idCliente) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Credito obtenerCredito(EstadoCreditoEnum estado, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Credito obtenerUltimoCredito(Long idCliente) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double obtenerDeuda(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date obtenerFechaVencimientoCuotaMasAntiguaNoPaga(Long creditoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void calcularDeudaClientesMorosos(boolean debugMode)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarPagosLlamadosClientesMorosos(Calendar fechaAEvaluar)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void realizarTareaMarcarDeudaClientesMorosos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void realizarTareaRegistrarPagosLlamadosClientesMorosos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean tieneFinanciacionDeDeudaActivo(Long clienteId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tieneCuotasVencidas(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Double obtenerDeudaVencidaAGestionar(Cliente cliente)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double obtenerDeudaVencida(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ComportamientoPago> obtenerComportamientoPagoEfectivo(
			Long clienteId) {
		// TODO Auto-generated method stub
		return null;
	}


}
