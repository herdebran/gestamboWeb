package ar.com.cristal.creditos.client.ui.usuarios.dto;

import java.io.Serializable;

import ar.com.cristal.creditos.client.accesibilidad.PerfilesDto;
import ar.com.cristal.creditos.client.dto.EstablecimientoDTO;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

public class UsuarioDTO implements Serializable, ListBoxItem {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1408371680964921370L;
	private Long id;
	private String password = "";
	private String nombreUsuario = "";
	private String nombre = "";
	private String apellido = "";
	private boolean supervisor = false;
	private boolean admin = false;
	private PerfilesDto perfil = null;
	private String sessionId = "";
	private EstablecimientoDTO establecimientoActual;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public boolean isSupervisor() {
		return supervisor;
	}
	public void setSupervisor(boolean supervisor) {
		this.supervisor = supervisor;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public PerfilesDto getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilesDto perfil) {
		this.perfil = perfil;
	}
	public String getItemText() {
		String text = this.getApellido() + ", " + this.getNombre();
		return text;
	}
	public String getItemValue() {
		return id.toString();
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public EstablecimientoDTO getEstablecimientoActual() {
		return establecimientoActual;
	}
	public void setEstablecimientoActual(EstablecimientoDTO establecimientoActual) {
		this.establecimientoActual = establecimientoActual;
	}
	
	
	
}
