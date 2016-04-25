package ar.com.cristal.creditos.client.dto;

import java.io.Serializable;

import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

public class SucursalDTO implements Serializable, ListBoxItem  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1408371680964921370L;
	private Long id;
	private String nombre = "";
	
	
	public String getItemText() {
		return nombre;
	}
	public String getItemValue() {
		String result = id == null? "" : id.toString(); 
		return result;
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
