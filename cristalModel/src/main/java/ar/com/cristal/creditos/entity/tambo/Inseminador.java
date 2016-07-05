package ar.com.cristal.creditos.entity.tambo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ar.com.cristal.creditos.entity.login.Establecimiento;

@Entity
@Table
public class Inseminador {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	@Column
	private String apellido;
	@Column
	private String nombre;
	@Column
	private Date fechaAlta;
	@Column
	private Date fechaBaja;
	@Column
	private Boolean eliminado=false;
	@ManyToOne
	private Establecimiento establecimiento;
	@Column
	private Long usuarioAlta;
	@Column
	private Long usuarioBajaId;
	

	public Inseminador(){
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Date getFechaAlta() {
		return fechaAlta;
	}


	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	public Date getFechaBaja() {
		return fechaBaja;
	}


	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}


	public Boolean getEliminado() {
		return eliminado;
	}


	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}


	public Establecimiento getEstablecimiento() {
		return establecimiento;
	}


	public void setEstablecimiento(Establecimiento establecimiento) {
		this.establecimiento = establecimiento;
	}


	public Long getUsuarioAlta() {
		return usuarioAlta;
	}


	public void setUsuarioAlta(Long usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}


	public Long getUsuarioBajaId() {
		return usuarioBajaId;
	}


	public void setUsuarioBajaId(Long usuarioBajaId) {
		this.usuarioBajaId = usuarioBajaId;
	}




	
	
}


