package ar.com.cristal.creditos.servicios;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import ar.com.cristal.creditos.common.EstadoCreditoEnum;
import ar.com.cristal.creditos.entity.commons.Empresa;
import ar.com.cristal.creditos.entity.creditos.Cheque;
import ar.com.cristal.creditos.entity.creditos.Cliente;
import ar.com.cristal.creditos.entity.creditos.ComportamientoPago;
import ar.com.cristal.creditos.entity.creditos.Credito;
import ar.com.cristal.creditos.entity.creditos.CuotaSocial;
import ar.com.cristal.creditos.entity.login.Usuario;
import ar.com.cristal.creditos.localidad.Localidad;
import ar.com.cristal.creditos.localidad.Reparticion;


public interface CreditosService {

	String obtenerListadoPendientesDeposito();

	/***
	 * Devuelve todos los créditos del cliente sin importar el estado o tipo
	 * @param idCliente
	 * @return
	 * @throws Exception
	 */
	List<Credito> obtenerCreditosByClientId(Long idCliente) throws Exception;
	
	
	
	/***
	 * Devuelve la lista de créditos del usuario con un estado determinado
	 * @param idCliente
	 * @param estado
	 * @return
	 * @throws Exception
	 */
	List<Credito> obtenerCreditosByClientId(Long idCliente, String estado) throws Exception;
	
	
	Boolean isRefinanciarAvailable(Long idCredito, List<String> motivos) throws Exception;

	public Cliente obtenerClientePorID(Long idCliente);
	
	public Credito obtenerCreditoPorID(Long idCredito);
	
	void guardarCredito(Credito cred) throws Exception;

	void eliminar(Credito credito) throws Exception;

	List<Empresa> obtenerListadoEmpresas();

	/***
	 * Devuelve todos los clientes que pueden sacar creditos originales
	 * @return
	 */
	List<Cliente> obtenerClientesAptosParaOriginal();

	/***
	 * Devuelve todos los clientes con posibilidad potencial para realizar una refinanciación de crédito. <br/>
	 * Son aquellos clientes que tengan entre 1 y 2 créditos activo y uno de los créditos pertenezca a una linea <br/>
	 * con posibilidad de refinanciación. <br/>
	 * 
	 * Los clientes no pueden estar en condición de moroso o prejudicial (además de no poder ser fallecido o estar en legales)
	 * 
	 * No es responsable de determinar qué porcentaje del crédito pago tiene cumplido 
	 * @return
	 * @throws Exception 
	 */
	List<Cliente> obtenerClientesPotencialesParaRefinanciacion() throws Exception;

	/***
	 * Devuelve true si puede obtener un crédito original
	 * @param cliente
	 * @return 
	 * @throws Exception 
	 */
	boolean esClientesAptoParaOriginal(Cliente cliente) throws Exception;

	/***
	 * Devuelve true si puede obtener un crédito paralelo
	 * @param cliente
	 * @return 
	 * @throws Exception 
	 */	
	boolean esClientesAptoParaParalelo(Cliente cliente) throws Exception;
	boolean anularCredito(long id);


	Integer obtenerCantidadCuotasImpagasParaLegales(Credito c);

	void cambiarEstadoACreditosYCuotas(Long idCliente) throws Exception;

	/***
	 * Devuelve el primer crédito que encuentre para el Estado para el Cliente dado
	 * @param estado
	 * @param id
	 * @return
	 */
	Credito obtenerCredito(EstadoCreditoEnum estado, Long id);

	Credito obtenerUltimoCredito(Long idCliente) throws Exception;

	/***
	 * Devuelve el monto de la deuda del cliente a la fecha considerando solamente el crédito por el cual el cliente es moroso.
	 * @param cliente
	 * @return
	 * @throws Exception 
	 */
	Double obtenerDeuda(Cliente cliente) throws Exception;

	Date obtenerFechaVencimientoCuotaMasAntiguaNoPaga(Long creditoId);


	/***
	 *
	 * Calcula la deuda de clientes. Si debugMode es true entonces limitará la generación de datos a unos pocos.
	 *
	 * @param debugMode
	 * @throws Exception
	 */
	void calcularDeudaClientesMorosos(boolean debugMode) throws Exception;

	/***
	 * Por cada cliente en MorosidadPagoCliente se buscan llamados y pagos realizados en el mes en evaluación.<br/>
	 * Se asume que la fecha representa el último día del mes a evaluar.
	 * Puede modificar la fecha a evaluar para ajustarla al último día del mes anterior si es que se tuvo que ejecutar la tarea 
	 * los primeros días del mes siguiente
	 * @param fecha
	 * @throws Exception
	 */
	void registrarPagosLlamadosClientesMorosos(Calendar fechaAEvaluar) throws Exception;

	/***
	 * Se encarga de realizar toda la lógica necesara para la tarea en questión
	 */
	void realizarTareaMarcarDeudaClientesMorosos();

	/***
	 * Se encarga de realizar toda la lógica necesara para la tarea en questión
	 */
	void realizarTareaRegistrarPagosLlamadosClientesMorosos();

	/***
	 * Busca entre los créditos activos del cliente una financiación de deuda
	 * @param clienteId
	 * @return
	 */
	boolean tieneFinanciacionDeDeudaActivo(Long clienteId);

	/***
	 * Devuelve true si tiene cuotas vencidas
	 * @param id
	 * @return
	 */
	boolean tieneCuotasVencidas(Long id);

	/***
	 * Según el nivel de morosidad de espera gestionar 1,2 o 3 cuotas
	 * @param cliente
	 * @return
	 * @throws Exception
	 */
	Double obtenerDeudaVencidaAGestionar(Cliente cliente) throws Exception;

	/***
	 * Devuelve el monto de la deuda en cuotas vencidas. Asume que el cliente se encuentra en condición de morosidad y 
	 * tiene asociado un crédito por el cual es moroso
	 * @param cliente
	 * @return
	 * @throws Exception
	 */
	Double obtenerDeudaVencida(Cliente cliente) throws Exception;

	List<ComportamientoPago> obtenerComportamientoPagoEfectivo(Long clienteId);
}