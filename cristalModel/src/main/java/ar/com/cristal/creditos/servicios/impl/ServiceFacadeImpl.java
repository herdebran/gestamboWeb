package ar.com.cristal.creditos.servicios.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.cristal.creditos.common.Constantes;
import ar.com.cristal.creditos.common.CristalProperties;
import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.documentos.util.Template;
import ar.com.cristal.creditos.entity.commons.Empresa;
import ar.com.cristal.creditos.entity.commons.Tablas;
import ar.com.cristal.creditos.entity.creditos.Cliente;
import ar.com.cristal.creditos.entity.login.Establecimiento;
import ar.com.cristal.creditos.entity.login.Perfil;
import ar.com.cristal.creditos.entity.login.Usuario;
import ar.com.cristal.creditos.entity.sucursales.Sucursal;
import ar.com.cristal.creditos.servicios.ComunesService;
import ar.com.cristal.creditos.servicios.CreditosService;
import ar.com.cristal.creditos.servicios.ImpresionService;
import ar.com.cristal.creditos.servicios.RubrosProductosService;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.servicios.TemplateManagerService;
import ar.com.cristal.creditos.servicios.VacasService;
import ar.com.cristal.creditos.util.DateUtil;

@Service("serviceFacade")
public class ServiceFacadeImpl implements ServiceFacade {
	
	private Logger log = Logger.getLogger(ServiceFacadeImpl.class);

	@Resource
	private  ClienteService clienteService;
	
	@Resource
	private  VacasService vacasService;
	
	@Resource
	private  RubrosProductosService rubrosProductosService;

	@Resource
	private CreditosService creditosService;

	
	@Resource
	private CristalProperties cristalPropertes;
	
	@Resource
	private ReporteService reporteService;
	
	@Resource
	private TemplateService templateService;
	
	@Resource
	private UsuarioServiceImpl usuarioService;
	
	@Autowired(required=true)
	private ComunesService comunesService;
	
	
	@Resource 
	private TemplateManagerService templateManagerService;
	
	
	@Resource 
	private ImpresionService impresionService;
	
	@Resource
	private GenericDao genericDao;
	
	
	
	public String getProperty(String key) throws Exception {
		return cristalPropertes.getValue(key);
	}

	public void generarReporte(Template template) throws Exception {
		reporteService.generarReporte(template);
	}

	public List<Template> obtenerTemplates() {
		return templateService.obtenerTemplates();		
	}

	public List<Cliente> obtenerClientes() {
		return clienteService.obtenerClientes();
	}
	
	
	
	/***
	 * Devuelve un usuario de la base de datos
	 * @param nombre
	 * @throws Exception 
	 */
	public Usuario obtenerUsuarioPorNombreUsuario(String nombreUsuario) throws Exception{
		
		try {
			return usuarioService.obtenerUsuarioPorNombreUsuario(nombreUsuario);
		} catch (Exception e) {
			throw e;
		}
		
		
	}

	

	public Usuario obtenerUsuario(Long id) {
		return usuarioService.obtenerUsuario(id);
		 
	}

	public List<Sucursal> obtenerSucursales() {
		return usuarioService.obtenerSucursales();
	}

	public Sucursal obtenerSucursal(Long id) {
		return usuarioService.obtenerSucursal(id);
	}

	public void persistirUsuario(Usuario u) throws Exception {
		usuarioService.persistirUsuario(u);
		
	}

	public List<Usuario> obtenerUsuarios() {
		return usuarioService.obtenerUsuarios();
	}

	public List<Perfil> obtenerPerfiles() {
		return usuarioService.obtenerPerfiles();
	}

	public void eliminarUsuario(Long id) {
		usuarioService.borrarUsuario(id);
		
	}

	public Usuario obtenerUsuarioLogueado() throws Exception {
		return usuarioService.obtenerUsuarioLogueado();
	}
	
	public List<Tablas> obtenerTablaByTipo(String tipo) throws Exception {
		
		return comunesService.obtenerTablaByTipo(tipo);
	}

	public List<Empresa> obtenerEmpresas() throws Exception {
		return comunesService.obtenerEmpresas();
	}

	public Cliente obtenerClienteById(Long id) {
		return clienteService.obtenerClienteById(id);
	}

	public Empresa obtenerEmpresasPorId(Long id) {
		return comunesService.obtenerEmpresaPorId(id); 
	}

	public ClienteService getClienteService() {
		return clienteService;
	}

	public VacasService getVacasService() {
		return vacasService;
	}
	
	public RubrosProductosService getRubrosProductosService() {
		return rubrosProductosService;
	}

	public CreditosService getCreditosService() {
		return creditosService;
	}


	public ComunesService getComunesService(){
		return comunesService;
	}

	@Override
	public String obtenerNombreSesionUsuarioUsuarioLogueado() {
		Usuario u = null;
		try {
			u = obtenerUsuarioLogueado();
		} catch (Exception e) {
			//Intencionalmente no se propaga el error.
			log.error("Error al obtener nombre de usuario");
			//Intencionalmente no se propaga el error.
		}
		return u == null ? "Usuario Sin Login" : u.getNombreUsuario() + "_" + u.getSessionId();
	}
	
	public Boolean cambiarPasswordUsuario(String password,String nuevaPassword) throws Exception{
		return usuarioService.cambiarPasswordUsuario(password, nuevaPassword);
	}

	@Override
	public SQLQuery createSQLQuery(String sqlQuery) {
//		log.info(obtenerNombreSesionUsuarioUsuarioLogueado() + " sql Query " + sqlQuery);
		return genericDao.getSessionFactory().getCurrentSession().createSQLQuery(sqlQuery);
		 
	}

	@Override
	public ReporteService getReporteService() {
		return reporteService;
	}



	@Override
	public Long obtenerUsuarioLogueadoId() {
		try {
			Usuario u = obtenerUsuarioLogueado();			
			return u.getId();
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean isNullOrEmpty(String str) {
		return str == null || str.isEmpty();
	}

	@Override
	public ImpresionService getImpresionService() {
		return impresionService;
	}

	@Override
	public Date getFechaActual() {
		Date fechaSistema = new Date();
		
		if (isFechaActualManualActivo()) {
			try {
				log.warn("Fecha Actual Manual: ACTIVO");
				Calendar fechaActual = Calendar.getInstance();
				int dia = Integer.parseInt(getProperty("fecha.actual.dia"));
				int mes = Integer.parseInt(getProperty("fecha.actual.mes")) - 1;
				int anio = Integer.parseInt(getProperty("fecha.actual.anio"));
				fechaActual.set(anio, mes, dia);
				log.warn("Fecha Actual Modificada: " + DateUtil.getString(fechaActual.getTime()));
				fechaSistema = fechaActual.getTime();
			} catch (NumberFormatException e) {
				log.error(e);
			} catch (Exception e) {
				log.error(e);
			}
		}
		
		return fechaSistema;
	}
	
	private boolean isFechaActualManualActivo(){
		try {
			boolean result = "1".equals(getProperty("fecha.actual.manual"));			
			return result;
		} catch (Exception e) {
			//Se decide no hacer nada más que mostrar el error y devolver false
			log.error("Mensaje error: " + e.getMessage(), e);
			return false;
			
		}
	}

	@Override
	public Calendar getUltimoDiaMesActual() {
		Date lastDate = DateUtil.getFinalDateOfMonth(getFechaActual());
		
		Calendar ultimoDiaMes = DateUtil.createCalendar(lastDate);
		
		ultimoDiaMes.set(Calendar.HOUR_OF_DAY, 0);
		ultimoDiaMes.set(Calendar.MINUTE, 0);
		
		return ultimoDiaMes;
	}
	
	@Override
	public Calendar getUltimoDiaMes(Calendar cal) {
		Date lastDate = DateUtil.getFinalDateOfMonth(getFechaActual());
		
		cal = DateUtil.createCalendar(lastDate);
		
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		
		return cal;
	}

	@Override
	public boolean isTareasDebugActivo() {
		
		try {
			boolean result = Constantes.TAREA_DEBUG_ACTIVO.equals(getProperty(Constantes.TAREAS_DEBUG));
			log.warn("Tarea Debug Modo: " + (result ? "ACTIVO" : "NO ACTIVO"));
			return result;
		} catch (Exception e) {
			//Se decide no hacer nada más que mostrar el error y devolver false
			log.error("Mensaje error: " + e.getMessage(), e);
			return false;
			
		}
	}

	@Override
	public String obtenerTelefonosDeCliente(Cliente cliente) {
		String result = "";
		if (cliente != null) {
			String telefono = "";
			String telefono1 = "";
			String telefono2 = "";
			String telefono3 = "";
			telefono += cliente.getCaracteristica()== null ? "" : (cliente.getCaracteristica() + " ");
			telefono += cliente.getTelefono() == null ? "" : cliente.getTelefono();
			telefono = telefono.trim();
			
			telefono = getTelefono(cliente.getCaracteristica(),  cliente.getTelefono());
			telefono1 = getTelefono(cliente.getCaracteristica1(),  cliente.getTelefono1());
			telefono2 = getTelefono(cliente.getCaracteristica2(),  cliente.getTelefono2());
			telefono3 = getTelefono(cliente.getCaracteristica3(),  cliente.getTelefono3());
					
			result += telefono.isEmpty() ? "" : (telefono + " - ");
			result += telefono1.isEmpty() ? "" : (telefono1 + " - ");
			result += telefono2.isEmpty() ? "" : (telefono2 + " - ");
			result += telefono3.isEmpty() ? "" : (telefono3);
		}
		
		return result;
	}
	
	private String getTelefono(String car, String telefono){
		String result = "";
		result += car == null ? "" : (car + " ");
		result += telefono  == null ? "" : telefono;
		result = result.trim();
		
		return result;
	}
	
	
	
	@Override
	public UsuarioServiceImpl getUsuarioService(){
		return usuarioService;
	}

	@Override
	public List<String> obtenerTiposEmpleo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> obtenerSituacionesBCRA() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> obtenerPermiteParalelo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TemplateManagerService getTemplateManagerService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String obtenerMaximoCorrelativo() throws Exception {
		// TODO Auto-generated method stub
		return null;

	}
	
	@Override
	public Establecimiento obtenerEstablecimientoLogueado() throws Exception {
		return usuarioService.obtenerUsuarioLogueado().getEstablecimientoActual();
	}
	
}
