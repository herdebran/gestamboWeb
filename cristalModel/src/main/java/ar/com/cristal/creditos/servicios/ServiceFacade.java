package ar.com.cristal.creditos.servicios;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;

import ar.com.cristal.creditos.documentos.util.Template;
import ar.com.cristal.creditos.entity.commons.Empresa;
import ar.com.cristal.creditos.entity.commons.Tablas;
import ar.com.cristal.creditos.entity.creditos.Cliente;
import ar.com.cristal.creditos.entity.login.Perfil;
import ar.com.cristal.creditos.entity.login.Usuario;
import ar.com.cristal.creditos.entity.sucursales.Sucursal;
import ar.com.cristal.creditos.servicios.impl.ClienteService;
import ar.com.cristal.creditos.servicios.impl.ReporteService;
import ar.com.cristal.creditos.servicios.impl.UsuarioServiceImpl;


public interface ServiceFacade {

	String getProperty(String key) throws Exception;
	
	public void generarReporte(Template template)  throws Exception;
	
	public List<Template> obtenerTemplates();	
	
	public List<Cliente> obtenerClientes();
	
	
	List<String> obtenerTiposEmpleo();

	List<String> obtenerSituacionesBCRA();
	
	List<String> obtenerPermiteParalelo();

	/***
	 * Devuelve un usuario de la base por nombre o null si no lo encuentra
	 * @param nombreUsuario
	 * @return Usuario o null
	 * @throws Exception 
	 */
	Usuario obtenerUsuarioPorNombreUsuario(String nombreUsuario) throws Exception;
	
	
	Usuario obtenerUsuario(Long id);
	
	List<Usuario> obtenerUsuarios();

	void persistirUsuario(Usuario u) throws Exception;

	List<Perfil> obtenerPerfiles();

	void eliminarUsuario(Long id);
	

	Usuario obtenerUsuarioLogueado() throws Exception;
	
	List<Tablas> obtenerTablaByTipo(String tipo) throws Exception;

	List<Empresa> obtenerEmpresas() throws Exception;

	Cliente obtenerClienteById(Long id);

	Empresa obtenerEmpresasPorId(Long valueOf);

	ClienteService getClienteService();

	CreditosService getCreditosService();


	ComunesService getComunesService();
	
	String obtenerNombreSesionUsuarioUsuarioLogueado();
	
	Boolean cambiarPasswordUsuario(String password,String nuevaPassword) throws Exception;

	SQLQuery createSQLQuery(String sqlQuery);

	ReporteService getReporteService();
	
	ImpresionService getImpresionService();

	TemplateManagerService getTemplateManagerService();

	/***
	 * Puede devolver null si no encuentra el usuario logueado
	 * @return
	 */
	Long obtenerUsuarioLogueadoId();

	boolean isNullOrEmpty(String caracteristica);

	Date getFechaActual();

	Calendar getUltimoDiaMesActual();

	/***
	 * Devuelve true cuando está activo el modo debug de tareas
	 * @return
	 */
	boolean isTareasDebugActivo();


	String obtenerTelefonosDeCliente(Cliente cliente);

	/***
	 * Devuelve el último día del mes. Modifica el valor del parámetro pasado
	 * @param cal
	 * @return
	 */
	Calendar getUltimoDiaMes(Calendar cal);

	UsuarioServiceImpl getUsuarioService();


	String obtenerMaximoCorrelativo() throws Exception;
	
	

}
