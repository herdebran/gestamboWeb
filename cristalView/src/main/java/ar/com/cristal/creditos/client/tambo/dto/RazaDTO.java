package ar.com.cristal.creditos.client.tambo.dto;

import ar.com.cristal.creditos.client.dto.DTO;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;


@SuppressWarnings("serial")
public class RazaDTO  extends DTO implements ListBoxItem{
	private Long id;
	private String nombre;

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
	@Override
	public String getItemText() {
		return this.nombre;
	}
	@Override
	public String getItemValue() {
		return this.id.toString();
	}

}
