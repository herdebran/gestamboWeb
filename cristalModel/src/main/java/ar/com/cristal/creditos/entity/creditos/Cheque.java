package ar.com.cristal.creditos.entity.creditos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Cheque {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
	@Column
	private String numero;
	
	@Column(nullable=true)
	private String descripcion;
	
	@Column
	private Boolean usado;
	
	@Column
	private String usuarioCreacion;
	
	@Column
	private Date fechaCreacion;
	
	@Column (nullable=true)
	private String usuarioEntrega;

	@Column (nullable=true)
	private Date fechaEntrega;
	
	public Boolean getUsado() {
		return usado;
	}

	public void setUsado(Boolean usado) {
		this.usado = usado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioEntrega() {
		return usuarioEntrega;
	}

	public void setUsuarioEntrega(String usuarioEntrega) {
		this.usuarioEntrega = usuarioEntrega;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}




	

	
	
}
