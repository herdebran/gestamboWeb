package ar.com.cristal.creditos.documentos;

import java.util.Date;


public class ReciboDoc extends Documento {
	
	private String numeroRecibo;
	private String montoTotal;
	private String montoCuota;
	private String montoCuotaEnLetras;
	private String concepto;
	private Date fecha;

	
	public ReciboDoc(String titulo, String clausula) {
		super(titulo,clausula);
		//super.dia = Calendar.getInstance(TimeZone.getTimeZone("GMT-3")).getTime().toString();
	}
	
	public String getNumeroRecibo() {
		return numeroRecibo;
	}

	public void setNumeroRecibo(String numeroRecibo) {
		this.numeroRecibo = numeroRecibo;
	}

	public String getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(String montoTotal) {
		this.montoTotal = montoTotal;
	}

	public String getMontoCuota() {
		return montoCuota;
	}

	public void setMontoCuota(String montoCuota) {
		this.montoCuota = montoCuota;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getMontoCuotaEnLetras() {
		return montoCuotaEnLetras;
	}

	public void setMontoCuotaEnLetras(String montoCuotaEnLetras) {
		this.montoCuotaEnLetras = montoCuotaEnLetras;
	}
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
}
