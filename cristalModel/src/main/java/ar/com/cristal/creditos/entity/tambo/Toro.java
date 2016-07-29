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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ar.com.cristal.creditos.common.ToroProbadoAventuraEnum;
import ar.com.cristal.creditos.entity.login.Establecimiento;

@Entity
@Table
public class Toro {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	@Column
	private String rp;
	@Column
	private String hba;
	@Column
	private String nombre;
	@Column
	private String nombreCompleto;
	@Column
	private Long raza_id;
	@Column
	private Long serviciosCampo;
	@Column
	private Long preniecesCampo;
	@Column
	private Long partosNormalesCampo;
	@Enumerated(EnumType.STRING)
	private ToroProbadoAventuraEnum probadoAventura;
	@Column(length=500)
	private String observaciones;
	@Column
	private Date fechaAlta;
	@Column
	private Date fechaBaja;
	@Column
	private Boolean animalVivo;
	@Column
	private Boolean eliminado=false;
	@ManyToOne
	private Establecimiento establecimiento;
	@OneToOne
	private Producto producto;
	@Column
	private Long usuarioAlta;
	@Column
	private Long usuarioBajaId;
	

	public Toro(){
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRp() {
		return rp;
	}


	public void setRp(String rp) {
		this.rp = rp;
	}


	public String getHba() {
		return hba;
	}


	public void setHba(String hba) {
		this.hba = hba;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getNombreCompleto() {
		return nombreCompleto;
	}


	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	public Long getRaza_id() {
		return raza_id;
	}


	public void setRaza_id(Long raza_id) {
		this.raza_id = raza_id;
	}


	public Long getServiciosCampo() {
		return serviciosCampo;
	}


	public void setServiciosCampo(Long serviciosCampo) {
		this.serviciosCampo = serviciosCampo;
	}


	public Long getPreniecesCampo() {
		return preniecesCampo;
	}


	public void setPreniecesCampo(Long preniecesCampo) {
		this.preniecesCampo = preniecesCampo;
	}


	public Long getPartosNormalesCampo() {
		return partosNormalesCampo;
	}


	public void setPartosNormalesCampo(Long partosNormalesCampo) {
		this.partosNormalesCampo = partosNormalesCampo;
	}


	public ToroProbadoAventuraEnum getProbadoAventura() {
		return probadoAventura;
	}


	public void setProbadoAventura(ToroProbadoAventuraEnum probadoAventura) {
		this.probadoAventura = probadoAventura;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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


	public Boolean getAnimalVivo() {
		return animalVivo;
	}


	public void setAnimalVivo(Boolean animalVivo) {
		this.animalVivo = animalVivo;
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


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	
	
}


