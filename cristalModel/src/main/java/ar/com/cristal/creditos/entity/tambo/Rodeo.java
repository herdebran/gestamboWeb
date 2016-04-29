package ar.com.cristal.creditos.entity.tambo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ar.com.cristal.creditos.entity.login.Establecimiento;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.tambo.enums.TipoRodeoEnum;

@Entity
@Table
public class Rodeo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	@Column
	private String nombre;
	@Enumerated(EnumType.STRING)
	private TipoRodeoEnum tipoRodeo;
	@Column
	private Date fechaAlta;
	@Column
	private Boolean eliminado=false;
	@ManyToOne
	private Establecimiento establecimiento;
	

	public Rodeo(){
		super();
	}


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


	public TipoRodeoEnum getTipoRodeo() {
		return tipoRodeo;
	}


	public void setTipoRodeo(TipoRodeoEnum tipoRodeo) {
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


	public Establecimiento getEstablecimiento() {
		return establecimiento;
	}


	public void setEstablecimiento(Establecimiento establecimiento) {
		this.establecimiento = establecimiento;
	}

	
	
}


