package ar.com.cristal.creditos.documentos.util;

import java.util.Date;

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

@Entity
public class DatosTemplate  {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
	@Column
	private String descripcion;
	
	@Column
	private Long idEmpresa;
	
	@Column
	private String codigoArea;
	
	@Column
	private String codigoReporte;
		
	@Column
	private String pathBasicoDocumentos = "";

	@Column	
	private String directorioOrigen = "";

	
	@Column	
	private String nombreTemplate = "";
	
	
	@Column
	private String directorioDestino= "";
	
	@Column
	private String nombreArchivoSalida = "";
	
	
	@Column
	private String contextRootDirFullpath= "";

	@Column
	private String extencionDefault;
	
	
	

	/**
	 * retorna el fullpath desde la raiz hasta el context-root de la aplicacion. Se usa para abrir los documentos
	 * ej: retorna /home/glassfish/glassfish3/domains/domains1/application/cristalTest 
	 * si se deploya en ese lugar y como cristalTest
	 * @return
	 */
	public String getContextRootDirFullpath() {
		return contextRootDirFullpath;
	}
	public void setContextRootDirFullpath(String contextRootDirFullpath) {
		this.contextRootDirFullpath = contextRootDirFullpath;
	}
	
	public String getNombreTemplate() {
		return nombreTemplate;
	}
	public void setNombreTemplate(String nombreTemplate) {
		this.nombreTemplate = nombreTemplate;
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
	

	public String getCodigoReporte() {
		return codigoReporte;
	}

	public void setCodigoReporte(String codigoReporte) {
		this.codigoReporte = codigoReporte;
	}
	
	public String getDirectorioOrigen() {
		return directorioOrigen;
	}
	public void setDirectorioOrigen(String directorioOrigen) {
		this.directorioOrigen = directorioOrigen;
	}
	/** 
	 * El directorio donde se dejo el archivo/reporte generado.
	 * dentro del contexto de la aplicacion, se usará para completar la ruta de lectura.
	 * ej:  COBRANZAS/REPORTES_GENERADOS/
	 */
	public String getDirectorioDestino() {
		return directorioDestino;
	}
	public void setDirectorioDestino(String directorioDestino) {
		this.directorioDestino = directorioDestino;
	}
	public String getNombreArchivoSalida() {
		return nombreArchivoSalida;
	}
	public void setNombreArchivoSalida(String nombreArchivoSalida) {
		this.nombreArchivoSalida = nombreArchivoSalida;
	}
	public String getExtencionDefault() {
		return extencionDefault;
	}
	public void setExtencionDefault(String extencionDefault) {
		this.extencionDefault = extencionDefault;
	}
	
	/**
	 * path que especifica desde la raiz del fs y hasta donde comienzan los demas directorios específicos de la aplicación.
	 * De este path se obtendran los templates de los reportes. ej: /opt/Documentos_cristal/)
	 * @return
	 */
	public String getPathBasicoDocumentos() {
		return pathBasicoDocumentos;
	}
	public void setPathBasicoDocumentos(String pathBasicoDocumentos) {
		this.pathBasicoDocumentos = pathBasicoDocumentos;
	}

	
}



