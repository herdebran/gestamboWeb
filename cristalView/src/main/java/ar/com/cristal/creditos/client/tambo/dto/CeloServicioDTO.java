package ar.com.cristal.creditos.client.tambo.dto;

import java.util.Date;

import ar.com.cristal.creditos.client.dto.DTO;
import ar.com.cristal.creditos.client.dto.EstablecimientoDTO;
import ar.com.cristal.creditos.client.dto.TipoCeloServicioEnumDTO;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;


@SuppressWarnings("serial")
public class CeloServicioDTO  extends DTO implements ListBoxItem{
	private Long id;
	private Date fecha;
	private TipoCeloServicioEnumDTO tipo;
	private int nroCeloServicio;
	private int lactancia;
	private VacaDTO vaca;	
	private ToroDTO toro;	
	private TipoServicioDTO tipoServicio;	
	private InseminadorDTO inseminador;	
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
	public TipoCeloServicioEnumDTO getTipo() {
		return tipo;
	}
	public void setTipo(TipoCeloServicioEnumDTO tipo) {
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
	public VacaDTO getVaca() {
		return vaca;
	}
	public void setVaca(VacaDTO vaca) {
		this.vaca = vaca;
	}
	public ToroDTO getToro() {
		return toro;
	}
	public void setToro(ToroDTO toro) {
		this.toro = toro;
	}
	public TipoServicioDTO getTipoServicio() {
		return tipoServicio;
	}
	public void setTipoServicio(TipoServicioDTO tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	public InseminadorDTO getInseminador() {
		return inseminador;
	}
	public void setInseminador(InseminadorDTO inseminador) {
		this.inseminador = inseminador;
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
	
	

}
