package ar.com.cristal.creditos.client.dto;

import java.util.HashMap;


@SuppressWarnings("serial")
public class ReporteDTO  extends DTO {

	private Long id;
	
	private String rutaOrigenTemplate;

	private String rutaDestino;
	
	private String nombre;
	
	private String formato;
	
	private String url;
	
	private TipoReporteDTO tipoReporte;
	
	private HashMap<Object, Object> values = new HashMap<Object,Object>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRutaOrigenTemplate() {
		return rutaOrigenTemplate;
	}

	public void setRutaOrigenTemplate(String rutaOrigenTemplate) {
		this.rutaOrigenTemplate = rutaOrigenTemplate;
	}

	public String getRutaDestino() {
		return rutaDestino;
	}

	public void setRutaDestino(String rutaDestino) {
		this.rutaDestino = rutaDestino;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public HashMap<Object, Object> getValues() {
		return values;
	}

	public void setValues(HashMap<Object, Object> values) {
		this.values = values;
	}

	public TipoReporteDTO getTipoReporte() {
		return tipoReporte;
	}

	public void setTipoReporte(TipoReporteDTO tipoReporte) {
		this.tipoReporte = tipoReporte;
	}
	

}
