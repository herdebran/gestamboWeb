package ar.com.cristal.creditos.client.tambo.dto;

import ar.com.cristal.creditos.client.dto.DTO;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;


@SuppressWarnings("serial")
public class TipoServicioDTO  extends DTO implements ListBoxItem{
	private Long id;
	private String descripcion;
	private Boolean activo=true;

	
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
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	@Override
	public String getItemText() {
		return this.descripcion;
	}
	@Override
	public String getItemValue() {
		return this.id.toString();
	}
	
	

}
