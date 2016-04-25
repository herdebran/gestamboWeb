package ar.com.cristal.creditos.common;

import java.util.Date;

public class ItemRecibo {

	private Double monto = 0.0;
	private Integer nroCuota;
	private Date fecha;
	
	private Double capital;
	private Double interes;

	



	public Double getMonto() {
		return monto;
	}


	public void setMonto(Double monto) {
		this.monto = monto;
	}


	public String getConceptoPago() {
		return nroCuota.toString();
	}
	


	public Integer getNroCuota() {
		return nroCuota;
	}


	public void setNroCuota(Integer nroCuota) {
		this.nroCuota = nroCuota;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Double getCapital() {
		return capital;
	}


	public void setCapital(Double capital) {
		this.capital = capital;
	}


	public Double getInteres() {
		return interes;
	}


	public void setInteres(Double interes) {
		this.interes = interes;
	}
	

	
	
	
}
