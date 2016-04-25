package ar.com.cristal.creditos.util;

import java.io.FileOutputStream;

import ar.com.cristal.creditos.common.LinkInfoPopup;


/**
 * Este bean tiene los datos de acceso a un reprote durante su creacion.
 * Responde con el fullpath a donde leer el template, donde dejarlo al reprote geneerado y
 * La ruta necesaria para poder abrir el archivo mediante la url del app server.
 * @author Guillermo
 *
 */
public class DescriptorDeAccesoTemplate {
	
	private FileOutputStream reporteAGenerarseStream;
	private LinkInfoPopup linkInfoPopup;
	private String rutaDondeEstaGuardadoElTemplate;
	private String rutaDondeSeGuardaraElArchivo;
	private String nombreBaseDelArchivodeSalida;
	private String nombreArchivo;
	private String rutaDondeSeGuardaElArchivoSinNombreArchivo;
	

	
	public String getRutaDondeSeGuardaraElArchivo() {
		return rutaDondeSeGuardaraElArchivo;
	}
	public void setRutaDondeSeGuardaraElArchivo(String rutaDondeSeGuardaraElArchivo) {
		this.rutaDondeSeGuardaraElArchivo = rutaDondeSeGuardaraElArchivo;
	}

	/**
	 * retorna el outputStream relacionado con el lugar del fs dnode guardará el reporte
	 * @return
	 */
	public FileOutputStream getReporteAGenerarseStream() {
		return reporteAGenerarseStream;
	}
	public void setReporteAGenerarseStream(FileOutputStream reporteAGenerarseStream) {
		this.reporteAGenerarseStream = reporteAGenerarseStream;
	}
	public LinkInfoPopup getLinkInfoPopup() {
		return linkInfoPopup;
	}
	public void setLinkInfoPopup(LinkInfoPopup linkInfoPopup) {
		this.linkInfoPopup = linkInfoPopup;
	}
	public String getRutaDondeEstaGuardadoElTemplate() {
		return rutaDondeEstaGuardadoElTemplate;
	}
	public void setRutaDondeEstaGuardadoElTemplate(
			String rutaDondeEstaGuardadoElTemplate) {
		this.rutaDondeEstaGuardadoElTemplate = rutaDondeEstaGuardadoElTemplate;
	}	

	public String getNombreBaseDelArchivodeSalida() {
		return nombreBaseDelArchivodeSalida;
	}
	public void setNombreDelArchivodeSalida(String nombreBaseDelArchivodeSalida) {
		this.nombreBaseDelArchivodeSalida = nombreBaseDelArchivodeSalida;
	}
	public String getRutaDondeSeGuardaElArchivoSinNombreArchivo() {
		return rutaDondeSeGuardaElArchivoSinNombreArchivo;
	}
	public void setRutaDondeSeGuardaElArchivoSinNombreArchivo(
			String rutaDondeSeGuardaElArchivoSinNombreArchivo) {
		this.rutaDondeSeGuardaElArchivoSinNombreArchivo = rutaDondeSeGuardaElArchivoSinNombreArchivo;
	}
	
	/***
	 * Se forma con un prefijo por ejemplo CobranzasMoroso2Coop <br/>
	 * luego un guión bajo _ <br/>  
	 * luego un timestamp por ejemplo 1349982394023 <br/>
	 * por último la extensión .pdf
	 * @return
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	
	
	/***
	 * Se forma con un prefijo por ejemplo CobranzasMoroso2Coop <br/>
	 * luego un guión bajo _ <br/>  
	 * luego un timestamp por ejemplo 1349982394023 <br/>
	 * por último la extensión .pdf
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}	
}
