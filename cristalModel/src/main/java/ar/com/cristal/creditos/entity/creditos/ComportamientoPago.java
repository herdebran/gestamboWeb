package ar.com.cristal.creditos.entity.creditos;

import java.util.Date;

public class ComportamientoPago {
	private Long clienteId;
	private Date fechaEnvio;
	private String concepto;
	private String codigoRespuesta;
	private Long cuotaId;
	private String datoCuota;
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public Date getFechaEnvio() {
		return fechaEnvio;
	}
	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}
	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}
	public Long getCuotaId() {
		return cuotaId;
	}
	public void setCuotaId(Long cuotaId) {
		this.cuotaId = cuotaId;
	}
	public String getDatoCuota() {
		return datoCuota;
	}
	public void setDatoCuota(String datoCuota) {
		this.datoCuota = datoCuota;
	}
	
	
	
	
}
