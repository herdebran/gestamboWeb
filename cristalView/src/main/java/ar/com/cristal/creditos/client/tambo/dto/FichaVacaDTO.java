/**
 * Es un DTO especifico pensado para llenar la Ficha de la vaca
 */

package ar.com.cristal.creditos.client.tambo.dto;

import java.util.Date;
import ar.com.cristal.creditos.client.dto.DTO;
import ar.com.cristal.creditos.client.dto.EstablecimientoDTO;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;


@SuppressWarnings("serial")
public class FichaVacaDTO  extends DTO implements ListBoxItem{
	private Long id;
	private String rp;
	private String rc;
	private String rodeo;
	private String categoria;
	private Date fechaNacimiento;
	private String raza;
	private String nombrePadre;
	private String hbaPadre;
	private String rpMadre;
	private String rcMadre;
	private String categoriaMadre;
	private EstadoProductivoEnumDTO estadoProductivo;
	private EstadoReproductivoEnumDTO estadoReproductivo;
	private EstadoSanitarioEnumDTO estadoSanitario;
	private int lactancia;
	private double grasa=0.0;
	private double proteina=0.0;
	private double solidosTotales=0.0;
	private double somaticas=0.0;
	private double produccionVitalicia=0.0;
	private double litrosPromedio=0.0;
	private Date fechaUltimoServicio;
	private String nombreToroUS;
	private int nroUS;
	private int serviciosDados=0;
	private int preniecesConfirmadas=0;
	private Date fechaUltimoParto;
	private Boolean paraVender;
	private String observaciones;
	private Date fechaAlta;
	private Date fechaBaja;
	private Boolean eliminado;
	private byte[] imagen;
	private EstablecimientoDTO establecimiento;
	private Long usuarioAlta;
	private Long usuarioBajaId;
	
	
	
	public FichaVacaDTO() {
		super();
		this.id = 0L;
		this.rp = "";
		this.rc = "";
		this.rodeo = "";
		this.categoria = "";
		this.fechaNacimiento = null;
		this.raza = "";
		this.nombrePadre = "";
		this.hbaPadre = "";
		this.rpMadre = "";
		this.rcMadre = "";
		this.categoriaMadre ="";
		this.estadoProductivo = null;
		this.estadoReproductivo = null;
		this.estadoSanitario = null;
		this.lactancia =0;
		this.grasa = 0.0;
		this.proteina = 0.0;
		this.solidosTotales = 0.0;
		this.somaticas = 0.0;
		this.produccionVitalicia = 0.0;
		this.litrosPromedio = 0.0;
		this.fechaUltimoServicio = null;
		this.nombreToroUS = "";
		this.nroUS = 0;
		this.serviciosDados = 0;
		this.preniecesConfirmadas = 0;
		this.fechaUltimoParto = null;
		this.paraVender = false;
		this.observaciones = "";
		this.fechaAlta = null;
		this.fechaBaja = null;
		this.eliminado = false;
		this.imagen = null;
		this.establecimiento = null;
		this.usuarioAlta = null;
		this.usuarioBajaId = null;
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
	public String getRodeo() {
		return rodeo;
	}
	public void setRodeo(String rodeo) {
		this.rodeo = rodeo;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getNombrePadre() {
		return nombrePadre;
	}
	public void setNombrePadre(String nombrePadre) {
		this.nombrePadre = nombrePadre;
	}
	public String getHbaPadre() {
		return hbaPadre;
	}
	public void setHbaPadre(String hbaPadre) {
		this.hbaPadre = hbaPadre;
	}
	public String getNombreToroUS() {
		return nombreToroUS;
	}
	public void setNombreToroUS(String nombreToroUS) {
		this.nombreToroUS = nombreToroUS;
	}
	public int getNroUS() {
		return nroUS;
	}
	public void setNroUS(int nroUS) {
		this.nroUS = nroUS;
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
