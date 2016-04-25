package ar.com.cristal.creditos.client.localidad;

import ar.com.cristal.creditos.client.dto.DTO;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

@SuppressWarnings("serial")
public class ProvinciaDTO extends DTO implements ListBoxItem {

	private Long id;
	
	private String nombre;
	

	public String getItemText() {
		return nombre;
	}

	public String getItemValue() {
		return id.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}
