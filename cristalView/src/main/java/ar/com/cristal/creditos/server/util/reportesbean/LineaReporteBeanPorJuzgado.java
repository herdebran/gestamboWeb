package ar.com.cristal.creditos.server.util.reportesbean;

/**
 * Bean que represanta un línea en la impresión de reporte con jaspers
 * 
 * @author Martín Mantovani
 *
 */
public class LineaReporteBeanPorJuzgado {
	
	private String cliente;
	
	private String nroCuenta;
	
	private String observaciones;

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	
}
