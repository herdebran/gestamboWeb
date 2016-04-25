
package ar.com.cristal.creditos.entity.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
	@Column
	private String apellido;
	
	@Column
	private String nombre;
	
	@Column
	private String nombreUsuario;
	
	
	@Column
	private String password;
	
	
	@Column
	private boolean supervisor;
	
	@Column
	private boolean admin;
	
	@Column
	private boolean borrado = false;
	
	@ManyToOne(optional=false)
	@JoinColumn	
	private Perfil perfil;

	@Column
	private Long establecimientoActual;
	
	
	@Transient
	private String sessionId;
	
	public String getApellido() {
		return apellido;
	}

	
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Usuario() {
		super();
	}
	
	

	public Usuario(String name) {
		this.nombre = name;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isSupervisor() {
		return supervisor;
	}

	public void setSupervisor(boolean supervisor) {
		this.supervisor = supervisor;
	}




	public void setBorrado(boolean b) {
		borrado = b;
		
	}
	
	public boolean isBorrado() {
		return borrado;
	}



	public Perfil getPerfil() {
		return perfil;
	}



	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
		
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}



	public Long getEstablecimientoActual() {
		return establecimientoActual;
	}



	public void setEstablecimientoActual(Long establecimientoActual) {
		this.establecimientoActual = establecimientoActual;
	}
	

}
