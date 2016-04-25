package ar.com.cristal.creditos.client.dto;

import java.io.Serializable;

import ar.com.cristal.creditos.client.accesibilidad.PerfilesDto;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;


public class UsuarioLogueadoDTO implements Serializable, ListBoxItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String nombreUsuario = "";
	private String nombre = "";
	private String apellido = "";
	private boolean supervisor = false;
	private boolean admin = false;
	private PerfilesDto perfil;
	private String sessionId = "";
	private Long establecimientoActual;

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getApellido() {
		return apellido;
	}



	public void setNombreUsuario(String userName) {
		this.nombreUsuario = userName;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getItemText() {
		String username = nombreUsuario;
		
		if (isSupervisor()) 
			username += " (S)";
		else 
			username += " (V)";
		return username;
	}

	public String getItemValue() {
		return id + "";
	}

	public boolean isSupervisor() {
		return supervisor;
	}

	public void setSupervisor(boolean supervisor) {
		this.supervisor = supervisor;
	}


	public boolean isAdmin() {
		if (perfil != null){
			admin = "administrador".equalsIgnoreCase(perfil.getNombre());
		}
			
		return admin;
	}

	

	public PerfilesDto getPerfil() {
		return perfil;
	}
	

	public void setPerfil(PerfilesDto perfil) {
		this.perfil = perfil;
	}

	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	
	public String getNombreUsuarioSessionId(){
		return nombreUsuario + "_" + sessionId;
	}

	public Long getEstablecimientoActual() {
		return establecimientoActual;
	}

	public void setEstablecimientoActual(Long establecimientoActual) {
		this.establecimientoActual = establecimientoActual;
	}
	
	
	
	}
