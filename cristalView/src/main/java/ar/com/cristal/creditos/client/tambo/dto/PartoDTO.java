package ar.com.cristal.creditos.client.tambo.dto;

import java.util.Date;

import ar.com.cristal.creditos.client.dto.DTO;
import ar.com.cristal.creditos.client.dto.EstablecimientoDTO;
import ar.com.cristal.creditos.client.dto.EstadoCriaEnumDTO;
import ar.com.cristal.creditos.client.dto.SexoAnimalEnumDTO;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;


@SuppressWarnings("serial")
public class PartoDTO  extends DTO implements ListBoxItem{
	private Long id;
	private Date fecha;
	private TipoPartoDTO tipoParto;	
	private int nroParto;
	private VacaDTO vaca;	
	private ToroDTO padre;	
	private String rpCria1;
	SexoAnimalEnumDTO sexoCria1;
	private String rpCria2;
	SexoAnimalEnumDTO sexoCria2;
	EstadoCriaEnumDTO estadoCria1;
	EstadoCriaEnumDTO estadoCria2;
	boolean mellizos=false;
	private String observaciones;
	private Boolean eliminado=false;
	private EstablecimientoDTO establecimiento;
	private Date fechaAlta;
	private Long usuarioAlta;
	private Date fechaBaja;
	private Long usuarioBaja;
	
	

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
	public TipoPartoDTO getTipoParto() {
		return tipoParto;
	}
	public void setTipoParto(TipoPartoDTO tipoParto) {
		this.tipoParto = tipoParto;
	}
	public int getNroParto() {
		return nroParto;
	}
	public void setNroParto(int nroParto) {
		this.nroParto = nroParto;
	}
	public VacaDTO getVaca() {
		return vaca;
	}
	public void setVaca(VacaDTO vaca) {
		this.vaca = vaca;
	}
	public ToroDTO getPadre() {
		return padre;
	}
	public void setPadre(ToroDTO padre) {
		this.padre = padre;
	}
	public String getRpCria1() {
		return rpCria1;
	}
	public void setRpCria1(String rpCria1) {
		this.rpCria1 = rpCria1;
	}
	public SexoAnimalEnumDTO getSexoCria1() {
		return sexoCria1;
	}
	public void setSexoCria1(SexoAnimalEnumDTO sexoCria1) {
		this.sexoCria1 = sexoCria1;
	}
	public String getRpCria2() {
		return rpCria2;
	}
	public void setRpCria2(String rpCria2) {
		this.rpCria2 = rpCria2;
	}
	public SexoAnimalEnumDTO getSexoCria2() {
		return sexoCria2;
	}
	public void setSexoCria2(SexoAnimalEnumDTO sexoCria2) {
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
	public EstablecimientoDTO getEstablecimiento() {
		return establecimiento;
	}
	public void setEstablecimiento(EstablecimientoDTO establecimiento) {
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
	@Override
	public String getItemText() {
		return this.getVaca().getRp() + " - " + this.getFecha();
	}
	@Override
	public String getItemValue() {
		return this.id.toString();
	}
	public EstadoCriaEnumDTO getEstadoCria1() {
		return estadoCria1;
	}
	public void setEstadoCria1(EstadoCriaEnumDTO estadoCria1) {
		this.estadoCria1 = estadoCria1;
	}
	public EstadoCriaEnumDTO getEstadoCria2() {
		return estadoCria2;
	}
	public void setEstadoCria2(EstadoCriaEnumDTO estadoCria2) {
		this.estadoCria2 = estadoCria2;
	}
	
	

}
