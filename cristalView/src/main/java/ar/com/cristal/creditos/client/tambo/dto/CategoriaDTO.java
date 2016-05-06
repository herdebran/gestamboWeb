package ar.com.cristal.creditos.client.tambo.dto;

import ar.com.cristal.creditos.client.dto.DTO;
import ar.com.cristal.creditos.entity.tambo.Raza;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;


@SuppressWarnings("serial")
public class CategoriaDTO  extends DTO implements ListBoxItem{
	private Long id;
	private String categoria;
	private Boolean eliminado;
	private RazaDTO raza;
	private Long categoriaSiguienteId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Boolean getEliminado() {
		return eliminado;
	}
	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}
	public RazaDTO getRaza() {
		return raza;
	}
	public void setRaza(RazaDTO raza) {
		this.raza = raza;
	}
	public Long getCategoriaSiguienteId() {
		return categoriaSiguienteId;
	}
	public void setCategoriaSiguienteId(Long categoriaSiguienteId) {
		this.categoriaSiguienteId = categoriaSiguienteId;
	}
	@Override
	public String getItemText() {
		return this.categoria;
	}
	
	@Override
	public String getItemValue() {
		return this.id.toString();
	}
	
	
}
