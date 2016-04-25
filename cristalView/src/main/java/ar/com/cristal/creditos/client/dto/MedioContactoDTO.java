package ar.com.cristal.creditos.client.dto;

import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;


/**
 * Medio por el cual un cliente se acerca a sacar un crédito a la empresa
 * 
 * @author daniel.madera
 *
 */
public class MedioContactoDTO  extends DTO implements ListBoxItem {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String descripcion="";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	public String getItemText() {
		return getDescripcion().trim();
	}

	
	public String getItemValue() {
		return String.valueOf(id);
	}
			
	
	

 
}
