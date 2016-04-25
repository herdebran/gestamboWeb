package ar.com.cristal.creditos.documentos.util;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

	/**
	 * Identifica los nombres de los archivos, ubicacion del template y ubicacion del destino para los templates usados
	 * en la aplicacion. Se filtrarán por Area de negocios: LEGALES, COBRANZAS, PAGOS.
	 * @author Guillermo
	 *
	 */

public class Template {


	private Long id;
	
	private Long idEmpresa;	
	
	private String nombreAplicacion;
		
	//codigo que identifica el area en que se usa el template:LEGALES, COBRANZAS, PAGOS
	private String codigoArea;
	
	private String codigoReporte;
	
	
	private String nombreTemplate = "";
	
	//de que directorio se tomará el archivo	
	private String pathOrigen = "";

	private String nombreSalida = "";
	
	//en que directorio se dejará el archivo generado
	private String pathDestino= "";
	
	
	private String descripcion = "";
	
	
	private boolean permiteMultipleEnvio = false;
	
	private String realPathDocumentos="";

	
    //nombre del context root de la aplicacion
	@Column
	private String contextRootName= "";

	
	public String getContextRootName() {
		return contextRootName;
	}
	public void setContextRootName(String contextRootName) {
		this.contextRootName = contextRootName;
	}
	public String getRealPathDocumentos() {
		return realPathDocumentos;
	}
	public void setRealPathDocumentos(String realPathDocumentos) {
		this.realPathDocumentos = realPathDocumentos;
	}
	public String getNombreTemplate() {
		return nombreTemplate;
	}
	public void setNombreTemplate(String nombreTemplate) {
		this.nombreTemplate = nombreTemplate;
	}
	public String getNombreSalida() {
		return nombreSalida;
	}
	public void setNombreSalida(String nombreSalida) {
		this.nombreSalida = nombreSalida;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public boolean isPermiteMultipleEnvio() {
		return permiteMultipleEnvio;
	}

	public void setPermiteMultipleEnvio(boolean permiteMultipleEnvio) {
		this.permiteMultipleEnvio = permiteMultipleEnvio;
	}
	
	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	
	public String getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}

	public String getPathOrigen() {
		return pathOrigen;
	}

	public void setPathOrigen(String pathOrigen) {
		this.pathOrigen = pathOrigen;
	}

	public String getPathDestino() {
		return pathDestino;
	}

	public void setPathDestino(String pathDestino) {
		this.pathDestino = pathDestino;
	}
	

	public String getCodigoReporte() {
		return codigoReporte;
	}

	public void setCodigoReporte(String codigoReporte) {
		this.codigoReporte = codigoReporte;
	}

	
	
	
	private Map<String, Object> valores = new HashMap<String, Object>();

	
	public Map<String, Object> valoresTemplate() {
		return valores;
	}

	public void setValores(Map<String, Object> valores) {
		this.valores = valores;
	}

	

	public Template() {
		super();
	}
	public Template(Map<String, Object> valores, String nombreTemplate,
			String nombreSalida, String descripcion) {
		super();
		this.valores = valores;
		nombreTemplate = nombreTemplate;
		nombreSalida = nombreSalida;
		descripcion = descripcion;
	}
	public String getNombreAplicacion() {
		return nombreAplicacion;
	}
	public void setNombreAplicacion(String nombreAplicacion) {
		this.nombreAplicacion = nombreAplicacion;
	}
	
	
}
