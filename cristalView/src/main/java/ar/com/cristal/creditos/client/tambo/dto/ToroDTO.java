package ar.com.cristal.creditos.client.tambo.dto;

import java.util.Date;

import ar.com.cristal.creditos.client.dto.DTO;
import ar.com.cristal.creditos.client.dto.EstablecimientoDTO;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;


@SuppressWarnings("serial")
public class ToroDTO  extends DTO implements ListBoxItem{
	private Long id;
	private String rp;
	private String hba;
	private String nombre;
	private String nombreCompleto;
	private Long raza_id;
	private Long serviciosCampo;
	private Long preniecesCampo;
	private Long partosNormalesCampo;
	private ToroProbadoAventuraEnumDTO probadoAventura;
	private String observaciones;
	private Date fechaAlta;
	private Date fechaBaja;
	private Boolean animalVivo;
	private Boolean eliminado;
	private EstablecimientoDTO establecimiento;
	private ProductoDTO producto;
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
	public ToroProbadoAventuraEnumDTO getProbadoAventura() {
		return probadoAventura;
	}
	public void setProbadoAventura(ToroProbadoAventuraEnumDTO probadoAventura) {
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
	public EstablecimientoDTO getEstablecimiento() {
		return establecimiento;
	}
	public void setEstablecimiento(EstablecimientoDTO establecimiento) {
		this.establecimiento = establecimiento;
	}
	
	public ProductoDTO getProducto() {
		return producto;
	}
	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
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
		return this.nombre;
	}
	@Override
	public String getItemValue() {
		return this.id.toString();
	}
	
	

}
