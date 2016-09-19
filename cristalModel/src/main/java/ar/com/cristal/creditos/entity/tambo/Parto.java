package ar.com.cristal.creditos.entity.tambo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

import ar.com.cristal.creditos.common.EstadoCriaEnum;
import ar.com.cristal.creditos.common.SexoAnimalEnum;
import ar.com.cristal.creditos.entity.login.Establecimiento;

@Entity
@Table
public class Parto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	@Column
	private Date fecha;
	@ManyToOne
	private TipoParto tipoParto;	
	@Column
	private int nroParto;
	@ManyToOne
	@NotNull
	private Vaca vaca;	
	@ManyToOne
	private Toro padre;	
	@Column
	private String rpCria1;
	@Column
	SexoAnimalEnum sexoCria1;
	@Column
	private String rpCria2;
	@Column
	SexoAnimalEnum sexoCria2;
	@Column
	EstadoCriaEnum estadoCria1;
	@Column
	EstadoCriaEnum estadoCria2;
	@Column
	boolean mellizos=false;
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
	

	public Parto(){
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


	public TipoParto getTipoParto() {
		return tipoParto;
	}


	public void setTipoParto(TipoParto tipoParto) {
		this.tipoParto = tipoParto;
	}


	public int getNroParto() {
		return nroParto;
	}


	public void setNroParto(int nroParto) {
		this.nroParto = nroParto;
	}


	public Vaca getVaca() {
		return vaca;
	}


	public void setVaca(Vaca vaca) {
		this.vaca = vaca;
	}


	public Toro getPadre() {
		return padre;
	}


	public void setPadre(Toro padre) {
		this.padre = padre;
	}


	public String getRpCria1() {
		return rpCria1;
	}


	public void setRpCria1(String rpCria1) {
		this.rpCria1 = rpCria1;
	}


	public SexoAnimalEnum getSexoCria1() {
		return sexoCria1;
	}


	public void setSexoCria1(SexoAnimalEnum sexoCria1) {
		this.sexoCria1 = sexoCria1;
	}


	public String getRpCria2() {
		return rpCria2;
	}


	public void setRpCria2(String rpCria2) {
		this.rpCria2 = rpCria2;
	}


	public SexoAnimalEnum getSexoCria2() {
		return sexoCria2;
	}


	public void setSexoCria2(SexoAnimalEnum sexoCria2) {
		this.sexoCria2 = sexoCria2;
	}


	public boolean isMellizos() {
		return mellizos;
	}


	public void setMellizos(boolean mellizos) {
		this.mellizos = mellizos;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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


	public Date getFechaAlta() {
		return fechaAlta;
	}


	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
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


	public EstadoCriaEnum getEstadoCria1() {
		return estadoCria1;
	}


	public void setEstadoCria1(EstadoCriaEnum estadoCria1) {
		this.estadoCria1 = estadoCria1;
	}


	public EstadoCriaEnum getEstadoCria2() {
		return estadoCria2;
	}


	public void setEstadoCria2(EstadoCriaEnum estadoCria2) {
		this.estadoCria2 = estadoCria2;
	}

	
	
}


