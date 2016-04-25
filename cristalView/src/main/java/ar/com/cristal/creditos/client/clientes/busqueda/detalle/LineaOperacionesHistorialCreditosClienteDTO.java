package ar.com.cristal.creditos.client.clientes.busqueda.detalle;

import ar.com.cristal.creditos.client.dto.DTO;

@SuppressWarnings("serial")
public class LineaOperacionesHistorialCreditosClienteDTO extends DTO {
	
	private long idCredito;
	private String fechaCreacionCredito;
	private Double montoCredito;
	private String usuario;
	private String estadoCredito;
	private String sucursal;
	private int cuotasPagas;
	private int cuotasTotal;
	private String fechaVencimiento;
	private String tipoComprobante;
	private String empresa;
	private String pagoVoluntario;
	private String descTipoCredito;
	private String fechaSolicitudCredito;
	private String tipoMedioEntregaDinero;
	private String medioDeContacto;
	
	public String getMedioDeContacto() {
		return medioDeContacto;
	}
	public void setMedioDeContacto(String medioDeContacto) {
		this.medioDeContacto = medioDeContacto;
	}
	public long getIdCredito() {
		return idCredito;
	}
	public void setIdCredito(long idCredito) {
		this.idCredito = idCredito;
	}
	public String getFechaCreacionCredito() {
		return fechaCreacionCredito;
	}
	public void setFechaCreacionCredito(String fechaCreacionCredito) {
		this.fechaCreacionCredito = fechaCreacionCredito;
	}
	public Double getMontoCredito() {
		return montoCredito;
	}
	public void setMontoCredito(Double montoCredito) {
		this.montoCredito = montoCredito;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEstadoCredito() {
		return estadoCredito;
	}
	public void setEstadoCredito(String estadoCredito) {
		this.estadoCredito = estadoCredito;
	}
	public int getCuotasPagas() {
		return cuotasPagas;
	}
	public void setCuotasPagas(int cuotasPagas) {
		this.cuotasPagas = cuotasPagas;
	}
	public int getCuotasTotal() {
		return cuotasTotal;
	}
	public void setCuotasTotal(int cuotasTotal) {
		this.cuotasTotal = cuotasTotal;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getSucursal() {
		return sucursal;
	}
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	public String getTipoComprobante() {
		return tipoComprobante;
	}
	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getPagoVoluntario() {
		return pagoVoluntario == null ? "" : pagoVoluntario;
	}
	
	public String setPagoVoluntario(String pv) {
		return pagoVoluntario = pv;
	}
	public String getDescTipoCredito() {
		return descTipoCredito;
	}
	public void setDescTipoCredito(String descTipoCredito) {
		this.descTipoCredito = descTipoCredito;
	}
	public String getFechaSolicitudCredito() {
		return fechaSolicitudCredito;
	}
	public void setFechaSolicitudCredito(String fechaSolicitudCredito) {
		this.fechaSolicitudCredito = fechaSolicitudCredito;
	}
	public String getTipoMedioEntregaDinero() {
		return tipoMedioEntregaDinero;
	}
	public void setTipoMedioEntregaDinero(String tipoMedioEntregaDinero) {
		this.tipoMedioEntregaDinero = tipoMedioEntregaDinero;
	}
	
	
}
