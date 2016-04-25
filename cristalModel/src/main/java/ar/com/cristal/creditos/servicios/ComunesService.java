package ar.com.cristal.creditos.servicios;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.cristal.creditos.documentos.util.DatosTemplate;
import ar.com.cristal.creditos.entity.commons.Empresa;
import ar.com.cristal.creditos.entity.commons.MedioContacto;
import ar.com.cristal.creditos.entity.commons.Tablas;
import ar.com.cristal.creditos.entity.creditos.Cliente;
import ar.com.cristal.creditos.entity.creditos.Credito;
import ar.com.cristal.creditos.entity.reportes.TipoReporte;
import ar.com.cristal.creditos.entity.sucursales.Sucursal;
import ar.com.cristal.creditos.localidad.Localidad;
import ar.com.cristal.creditos.localidad.Reparticion;


/**
 * servico que da acceso a datos de la aplicacion.
 * @author Guillermo
 *
 */
@Service
public interface ComunesService {
	/**
	 * obtiene todas las empresas registradas
	 * @return
	 * @throws Exception
	 */
	public List<Empresa> obtenerEmpresas() throws Exception;
	
	public List<Tablas> obtenerTablaByTipo(String tipo) throws Exception;
	
	/**
	 * obtienen los datos del template x Empresa, Area y codigo.
	 * X ej Esto seria: LA luisina, COBRANZAS, MOROSO_2
	 * @param idEmp
	 * @param area
	 * @param codArea
	 * @return
	 * @throws Exception
	 */
	public DatosTemplate obtenerNombreTemplateByIdEmpresaAreaYCodigoReporte(String idEmp, String area , String codigo) throws Exception;

	public DatosTemplate obtenerDatosTemplateByNombreTemplateYExtencion(String fn, String ext) throws Exception;
	
	public DatosTemplate obtenerDatosTemplateByNombreArchivoYExtencionEIdEmpresa(String fn, String ext, String idemp) throws Exception;
	
	public DatosTemplate obtenerDatosTemplateByNombreTemplateCodigoAreaCodigoReporte(String nombreReporte, String codigoArea, String codigoReporte) throws Exception;
	
	public Empresa obtenerEmpresaPorId(Long id);
	
	public boolean validarEMail(String email);
	
	
	
	/***
	 * Cambia el estado de los créditos y sus cuotas a LEGALES
	 * @param idsCreditos
	 * @throws Exception
	 */
	public void cambiarEstadoACreditosYSusCuotas(List<Long> idsCreditos) throws Exception;	
	
	public Double obtenerPunitoriosCredito(Credito credito);
	
	public Tablas obtenerTablaByCodigoYTipo(String codigo, String tipo) throws Exception;
	
	public List<TipoReporte> obtenerTiposReporte() throws Exception;

	public List<MedioContacto> obtenerMediosContacto();
	
	public List<Reparticion> buscarReparticion(Reparticion reparticion);

	public void guardarCrearReparticion(Reparticion reparticion);
	
	public List<Localidad> buscarLocalidad(Localidad localidad);
	
	public void guardarCrearLocalidad(Localidad localidad);
	
	public void guardarCrearEmpresa(Empresa empresa);

	public List<Empresa> buscarEmpresa(Empresa empresa);

	public void guardarCrearSucursal(Sucursal sucursal);

	public List<Sucursal> buscarSucursal(Sucursal sucursal);

	
	/***
	 * Registra el inicio de una acción
	 * @param accion
	 * @return
	 * @throws Exception
	 */
	Long registrarInicioTarea(String accion) throws Exception;
	
	/***
	 * Registra el final de una acción
	 * @param registro
	 * @throws Exception
	 */
	void registrarFinTarea(Long id) throws Exception;
	
	
	/***
	 * Registra el final de una acción
	 * @param registro
	 * @param observacion
	 * @throws Exception
	 */
	void registrarFinTarea(Long id, String observacion) throws Exception;
	
	
	/***
	 * Registra la falla de una acción
	 * @param registro
	 * @throws Exception
	 */
	void registrarFalla(Long id, String error) throws Exception;
	
	/***
	 * Devuelve true, si se generaron las cuotas sociales para el período pasado. <br/>
	 * Debe ser transaccional para que pueda ser utilizado en el job de creación de cuotas sociales <br/>
	 * 1: enero
	 * 12: diciembre
	 * @param periodo
	 * @param año 
	 * @return
	 */
	boolean cuotaSocialGenerada(int periodo, int año);

	/***
	 * Devuelve true si encuentra una tarea en ejecución
	 * @param fecha
	 * @param tarea
	 * @return
	 */
	boolean tareaEnEjecucion(Date fecha, String tarea);
	
	
	/***
	 * Ubicación del directorio compartido donde se guardan las cartas
	 * @return
	 * @throws Exception
	 */
	String getUbicacionCartasSambaShare() throws Exception;

	/***
	 * Deja aquellas cuotas sociales con más de 12 meses de antigüedad con estado NO PAGA como INVALIDA
	 */
	public void invalidarCuotasSociales();

	/***
	 * Devuevle true, si se registrò una tarea realizada con éxito
	 * @param nombreTareaRegistrada
	 * @param fechaEvaluacion
	 * @return
	 */
	boolean tareaMensualRealizada(String nombreTareaRegistrada,
			Calendar fechaEvaluacion);

	boolean tareaRealizada(String nombreTareaRegistrada, Calendar fechaInicio,
			Calendar fechaTope);

	public boolean isVerazOnlineActivo();

	public List<Tablas> obtenerListadoLlamadasDepartamentosCall();

	/***
	 * Invalida cuotas sociales para un cliente dado
	 * @param clienteId
	 */
	void invalidarCuotasSociales(Long clienteId, String detalle);

	public Integer getScoreVerazOffline();

	Object getPropiedadConfiguracionSistema(String propiedad);

	/***
	 * Dado un nombre de sucursal devuelve la Sucursal o null en caso de no encontrarla
	 * @param nombreSucursal
	 * @return
	 */
	Sucursal buscarSucursal(String nombreSucursal);

	void registrarSeguimiento(String mensaje, Cliente cliente) throws Exception;

	
}
