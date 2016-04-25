package ar.com.cristal.creditos.entity.reportes;

import java.util.Date;

public class ReportePrejudicialesBean {
	
	private String nroCliente;
	
	private String nombreCliente;
	
	private Date fechaCredito;
	
	private Double montoCredito;
	
	private Integer cuotas;
	
	private Double montoCuota;
	
	private Integer cantCuotasPagas;
	
	private Double montoInteresesImpagos;
	
	private Double montoCuotasSocialesImpagas;
	
	private Date fechaUltimoPagoCuota;

	private String comportamiento;
	
	private Integer cantCreditosAnteriores;
	
	private String comercializador;
	
	private String reparticion;
	
	private String empresa;
	
	private Double gastoCarta;
	
	private String telefonos;
	
	private Date fechaUltimoEnvioCarta; 
	
	public String getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(String nroCliente) {
		this.nroCliente = nroCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public Date getFechaCredito() {
		return fechaCredito;
	}

	public void setFechaCredito(Date fechaCredito) {
		this.fechaCredito = fechaCredito;
	}

	public Double getMontoCredito() {
		return montoCredito;
	}

	public void setMontoCredito(Double montoCredito) {
		this.montoCredito = montoCredito;
	}

	public Integer getCuotas() {
		return cuotas;
	}

	public void setCuotas(Integer cuotas) {
		this.cuotas = cuotas;
	}

	public Double getMontoCuota() {
		return montoCuota;
	}

	public void setMontoCuota(Double montoCuota) {
		this.montoCuota = montoCuota;
	}

	public Integer getCantCuotasPagas() {
		return cantCuotasPagas;
	}

	public void setCantCuotasPagas(Integer cantCuotasPagas) {
		this.cantCuotasPagas = cantCuotasPagas;
	}

	public Double getMontoInteresesImpagos() {
		return montoInteresesImpagos;
	}

	public void setMontoInteresesImpagos(Double montoInteresesImpagos) {
		this.montoInteresesImpagos = montoInteresesImpagos;
	}

	public Double getMontoCuotasSocialesImpagas() {
		return montoCuotasSocialesImpagas;
	}

	public void setMontoCuotasSocialesImpagas(Double montoCuotasSocialesImpagas) {
		this.montoCuotasSocialesImpagas = montoCuotasSocialesImpagas;
	}

	public Date getFechaUltimoPagoCuota() {
		return fechaUltimoPagoCuota;
	}

	public void setFechaUltimoPagoCuota(Date fechaUltimoPagoCuota) {
		this.fechaUltimoPagoCuota = fechaUltimoPagoCuota;
	}

	public String getComportamiento() {
		return comportamiento;
	}

	public void setComportamiento(String comportamiento) {
		this.comportamiento = comportamiento;
	}

	public Integer getCantCreditosAnteriores() {
		return cantCreditosAnteriores;
	}

	public void setCantCreditosAnteriores(Integer cantCreditosAnteriores) {
		this.cantCreditosAnteriores = cantCreditosAnteriores;
	}

	public String getComercializador() {
		return comercializador;
	}

	public void setComercializador(String comercializador) {
		this.comercializador = comercializador;
	}

	public String getReparticion() {
		return reparticion;
	}

	public void setReparticion(String reparticion) {
		this.reparticion = reparticion;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Double getGastoCarta() {
		return gastoCarta;
	}

	public void setGastoCarta(Double gastoCarta) {
		this.gastoCarta = gastoCarta;
	}

	public String getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(String telefono) {
		this.telefonos = telefono;
	}

	public Date getFechaUltimoEnvioCarta() {
		return fechaUltimoEnvioCarta;
	}

	public void setFechaUltimoEnvioCarta(Date fechaUltimoEnvioCarta) {
		this.fechaUltimoEnvioCarta = fechaUltimoEnvioCarta;
	}

}
