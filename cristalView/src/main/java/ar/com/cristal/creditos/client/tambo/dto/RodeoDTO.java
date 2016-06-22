package ar.com.cristal.creditos.client.tambo.dto;

import java.util.Date;

import ar.com.cristal.creditos.client.dto.DTO;
import ar.com.cristal.creditos.client.dto.EstablecimientoDTO;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;


@SuppressWarnings("serial")
public class RodeoDTO  extends DTO implements ListBoxItem{
	private Long id;
	private String nombre;
	private TipoRodeoEnumDTO tipoRodeo;
	private Date fechaAlta;
	private Boolean eliminado;
	private EstablecimientoDTO establecimiento;
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
	public TipoRodeoEnumDTO getTipoRodeo() {
		return tipoRodeo;
	}
	public void setTipoRodeo(TipoRodeoEnumDTO tipoRodeo) {
		this.tipoRodeo = tipoRodeo;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Boolean getEliminado() {
		return eliminado;
	}
	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}
	public EstablecimientoDTO getEstablecimiento() {
		return establecimiento;
	}
	public void setEstablecimiento(EstablecimientoDTO establecimiento) {
		this.establecimiento = establecimiento;
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
