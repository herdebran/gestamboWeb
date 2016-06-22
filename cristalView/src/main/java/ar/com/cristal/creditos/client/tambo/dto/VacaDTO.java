package ar.com.cristal.creditos.client.tambo.dto;

import java.util.Date;

import ar.com.cristal.creditos.client.dto.DTO;
import ar.com.cristal.creditos.client.dto.EstablecimientoDTO;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;


@SuppressWarnings("serial")
public class VacaDTO  extends DTO implements ListBoxItem{
	private Long id;
	private String rp;
	private String rc;
	private Long rodeo_id;
	private String categoria;
	private Date fechaNacimiento;
	private Long raza_id;
	private Long padre_id;
	private String rpMadre;
	private String rcMadre;
	private String categoriaMadre;
	private EstadoProductivoEnumDTO estadoProductivo;
	private EstadoReproductivoEnumDTO estadoReproductivo;
	private EstadoSanitarioEnumDTO estadoSanitario;
	private Long resultadoTacto_id;
	private int lactancia;
	private double grasa=0.0;
	private double proteina=0.0;
	private double solidosTotales=0.0;
	private double somaticas=0.0;
	private double produccionVitalicia=0.0;
	private double litrosPromedio=0.0;
	private Boolean paraVender;
	private String observaciones;
	private Date fechaAlta;
	private Date fechaBaja;
	private Boolean eliminado;
	private byte[] imagen;
	private EstablecimientoDTO establecimiento;
	private Long usuarioAlta;
	private Long usuarioBajaId;
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
	public EstadoProductivoEnumDTO getEstadoProductivo() {
		return estadoProductivo;
	}
	public void setEstadoProductivo(EstadoProductivoEnumDTO estadoProductivo) {
		this.estadoProductivo = estadoProductivo;
	}
	public EstadoReproductivoEnumDTO getEstadoReproductivo() {
		return estadoReproductivo;
	}
	public void setEstadoReproductivo(EstadoReproductivoEnumDTO estadoReproductivo) {
		this.estadoReproductivo = estadoReproductivo;
	}
	public EstadoSanitarioEnumDTO getEstadoSanitario() {
		return estadoSanitario;
	}
	public void setEstadoSanitario(EstadoSanitarioEnumDTO estadoSanitario) {
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
	public EstablecimientoDTO getEstablecimiento() {
		return establecimiento;
	}
	public void setEstablecimiento(EstablecimientoDTO establecimiento) {
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
	@Override
	public String getItemText() {
		return this.rp;
	}
	@Override
	public String getItemValue() {
		return this.id.toString();
	}
	
	

}
