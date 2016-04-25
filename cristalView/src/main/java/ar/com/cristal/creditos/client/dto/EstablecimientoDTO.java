package ar.com.cristal.creditos.client.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO;
import ar.com.cristal.creditos.entity.login.Usuario;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

@SuppressWarnings("serial")
public class EstablecimientoDTO extends DTO implements ListBoxItem{
	
	private String id;
	private String nombre;
	private String cuil;
	private String domicilio;
	private String cuidad;
	private String provincia;
	private UsuarioDTO usuario;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getItemText() {
		return nombre;
	}

	@Override
	public String getItemValue() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getCuidad() {
		return cuidad;
	}

	public void setCuidad(String cuidad) {
		this.cuidad = cuidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
	

}
