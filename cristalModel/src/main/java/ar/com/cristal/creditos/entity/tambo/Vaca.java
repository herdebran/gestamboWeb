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

import ar.com.cristal.creditos.common.EstadoProductivoEnum;
import ar.com.cristal.creditos.common.EstadoReproductivoEnum;
import ar.com.cristal.creditos.common.EstadoSanitarioEnum;
import ar.com.cristal.creditos.entity.login.Establecimiento;

@Entity
@Table
public class Vaca {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	@Column
	private String rp;
	@Column
	private String rc;
	@Column
	private Long rodeo_id;
	@Column
	private String categoria;
	@Column
	private Date fechaNacimiento;
	@Column
	private Long raza_id;
	@Column
	private Long padre_id;
	@Column
	private String rpMadre;
	@Column
	private String rcMadre;
	@Column
	private String categoriaMadre;
	@Enumerated(EnumType.STRING)
	private EstadoProductivoEnum estadoProductivo;
	@Enumerated(EnumType.STRING)
	private EstadoReproductivoEnum estadoReproductivo;
	@Enumerated(EnumType.STRING)
	private EstadoSanitarioEnum estadoSanitario;
	@Column
	private Long resultadoTacto_id;
	@Column
	private int lactancia;
	@Column
	private double grasa=0.0;
	@Column
	private double proteina=0.0;
	@Column
	private double solidosTotales=0.0;
	@Column
	private double somaticas=0.0;
	@Column
	private double produccionVitalicia=0.0;
	@Column
	private double litrosPromedio=0.0;
	@Column
	private Date fechaUltimoServicio;
	@Column
	private int serviciosDados=0;
	@Column
	private int preniecesConfirmadas=0;
	@Column
	private Date fechaUltimoParto;
	@Column
	private Boolean paraVender;
	@Column(length=500)
	private String observaciones;
	@Column
	private Date fechaAlta;
	@Column
	private Date fechaBaja;
	@Column
	private Boolean eliminado;
	@Column(length=10000000*10*10)
	private byte[] imagen;
	@ManyToOne
	private Establecimiento establecimiento;
	@Column
	private Long usuarioAlta;
	@Column
	private Long usuarioBajaId;
	

	public Vaca(){
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


	public String getRc() {
		return rc;
	}


	public void setRc(String rc) {
		this.rc = rc;
	}


	public Long getRodeo_id() {
		return rodeo_id;
	}


	public void setRodeo_id(Long rodeo_id) {
		this.rodeo_id = rodeo_id;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public Long getRaza_id() {
		return raza_id;
	}


	public void setRaza_id(Long raza_id) {
		this.raza_id = raza_id;
	}


	public Long getPadre_id() {
		return padre_id;
	}


	public void setPadre_id(Long padre_id) {
		this.padre_id = padre_id;
	}


	public String getRpMadre() {
		return rpMadre;
	}


	public void setRpMadre(String rpMadre) {
		this.rpMadre = rpMadre;
	}


	public String getRcMadre() {
		return rcMadre;
	}


	public void setRcMadre(String rcMadre) {
		this.rcMadre = rcMadre;
	}


	public String getCategoriaMadre() {
		return categoriaMadre;
	}


	public void setCategoriaMadre(String categoriaMadre) {
		this.categoriaMadre = categoriaMadre;
	}


	public EstadoProductivoEnum getEstadoProductivo() {
		return estadoProductivo;
	}


	public void setEstadoProductivo(EstadoProductivoEnum estadoProductivo) {
		this.estadoProductivo = estadoProductivo;
	}


	public EstadoReproductivoEnum getEstadoReproductivo() {
		return estadoReproductivo;
	}


	public void setEstadoReproductivo(EstadoReproductivoEnum estadoReproductivo) {
		this.estadoReproductivo = estadoReproductivo;
	}


	public EstadoSanitarioEnum getEstadoSanitario() {
		return estadoSanitario;
	}


	public void setEstadoSanitario(EstadoSanitarioEnum estadoSanitario) {
		this.estadoSanitario = estadoSanitario;
	}


	public Long getResultadoTacto_id() {
		return resultadoTacto_id;
	}


	public void setResultadoTacto_id(Long resultadoTacto_id) {
		this.resultadoTacto_id = resultadoTacto_id;
	}


	public int getLactancia() {
		return lactancia;
	}


	public void setLactancia(int lactancia) {
		this.lactancia = lactancia;
	}


	public double getGrasa() {
		return grasa;
	}


	public void setGrasa(double grasa) {
		this.grasa = grasa;
	}


	public double getProteina() {
		return proteina;
	}


	public void setProteina(double proteina) {
		this.proteina = proteina;
	}


	public double getSolidosTotales() {
		return solidosTotales;
	}


	public void setSolidosTotales(double solidosTotales) {
		this.solidosTotales = solidosTotales;
	}


	public double getSomaticas() {
		return somaticas;
	}


	public void setSomaticas(double somaticas) {
		this.somaticas = somaticas;
	}


	public double getProduccionVitalicia() {
		return produccionVitalicia;
	}


	public void setProduccionVitalicia(double produccionVitalicia) {
		this.produccionVitalicia = produccionVitalicia;
	}


	public double getLitrosPromedio() {
		return litrosPromedio;
	}


	public void setLitrosPromedio(double litrosPromedio) {
		this.litrosPromedio = litrosPromedio;
	}


	public Boolean getParaVender() {
		return paraVender;
	}


	public void setParaVender(Boolean paraVender) {
		this.paraVender = paraVender;
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

	

	public Date getFechaUltimoServicio() {
		return fechaUltimoServicio;
	}


	public void setFechaUltimoServicio(Date fechaUltimoServicio) {
		this.fechaUltimoServicio = fechaUltimoServicio;
	}


	public int getServiciosDados() {
		return serviciosDados;
	}


	public void setServiciosDados(int serviciosDados) {
		this.serviciosDados = serviciosDados;
	}


	public int getPreniecesConfirmadas() {
		return preniecesConfirmadas;
	}


	public void setPreniecesConfirmadas(int preniecesConfirmadas) {
		this.preniecesConfirmadas = preniecesConfirmadas;
	}


	public Date getFechaUltimoParto() {
		return fechaUltimoParto;
	}


	public void setFechaUltimoParto(Date fechaUltimoParto) {
		this.fechaUltimoParto = fechaUltimoParto;
	}


	public Boolean getEliminado() {
		return eliminado;
	}


	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}


	public byte[] getImagen() {
		return imagen;
	}


	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
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


