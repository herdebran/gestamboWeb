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

import org.hibernate.validator.NotNull;

import ar.com.cristal.creditos.common.TipoCeloServicioEnum;
import ar.com.cristal.creditos.entity.login.Establecimiento;

@Entity
@Table
public class CeloServicio {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	@Column
	private Date fecha;
	@Enumerated(EnumType.STRING)
	private TipoCeloServicioEnum tipo;
	@Column
	private int nroCeloServicio;
	@Column
	private int lactancia;
	@ManyToOne
	@NotNull
	private Vaca vaca;	
	@ManyToOne
	private Toro toro;	
	@ManyToOne
	private TipoServicio tipoServicio;	
	@ManyToOne
	private Inseminador inseminador;	
	@Column
	private double precio=0.0;
	@Column(length=50)
	private String observaciones;
	@Column
	private Boolean eliminado=false;
	@ManyToOne
	private Establecimiento establecimiento;
	@Column
	private Date fechaAlta;
	@Column
	private Long usuarioAlta;
	@Column
	private Date fechaBaja;
	@Column
	private Long usuarioBaja;
	

	public CeloServicio(){
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public TipoCeloServicioEnum getTipo() {
		return tipo;
	}


	public void setTipo(TipoCeloServicioEnum tipo) {
		this.tipo = tipo;
	}


	public int getNroCeloServicio() {
		return nroCeloServicio;
	}


	public void setNroCeloServicio(int nroCeloServicio) {
		this.nroCeloServicio = nroCeloServicio;
	}


	public int getLactancia() {
		return lactancia;
	}


	public void setLactancia(int lactancia) {
		this.lactancia = lactancia;
	}


	public Vaca getVaca() {
		return vaca;
	}


	public void setVaca(Vaca vaca) {
		this.vaca = vaca;
	}


	public Toro getToro() {
		return toro;
	}


	public void setToro(Toro toro) {
		this.toro = toro;
	}


	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}


	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}


	public Inseminador getInseminador() {
		return inseminador;
	}


	public void setInseminador(Inseminador inseminador) {
		this.inseminador = inseminador;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	
	
	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public Boolean getEliminado() {
		return eliminado;
	}


	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}


	public Date getFechaAlta() {
		return fechaAlta;
	}


	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
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


	public Date getFechaBaja() {
		return fechaBaja;
	}


	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}


	public Long getUsuarioBaja() {
		return usuarioBaja;
	}


	public void setUsuarioBaja(Long usuarioBaja) {
		this.usuarioBaja = usuarioBaja;
	}




	
	
}


