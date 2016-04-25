package ar.com.cristal.creditos.client.dto;

import java.util.HashMap;
import java.util.Map;

import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

public class TemplateDTO extends DTO implements ListBoxItem{

	
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private Map<String, DTO> valores = new HashMap<String, DTO>();
	private String descripcion;
	private String nombreTemplate;
	private String nombreSalida;
	private boolean permiteMultipleEnvio = false;
	

	public Map<String, DTO> getValores() {
		return valores;
	}

	public void setValores(Map<String, DTO> valores) {
		this.valores = valores;
	}

	public String getNombreTemplate() {
		return nombreTemplate;
	}

	public void setNombreTemplate(String nombreTemplate) {
		this.nombreTemplate = nombreTemplate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreSalida() {
		return nombreSalida;
	}

	public void setNombreSalida(String nombreSalida) {
		this.nombreSalida = nombreSalida;
	}

	public boolean isPermiteMultipleEnvio() {
		return permiteMultipleEnvio;
	}

	public void setPermiteMultipleEnvio(boolean permiteMultipleEnvio) {
		this.permiteMultipleEnvio = permiteMultipleEnvio;
	}

	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	public String getItemText() {
		return descripcion;
		
	}

	public String getItemValue() {
		return id.toString();
	}
	
	
	
}
