package ar.com.cristal.creditos.server.util.reportesbean;

/**
* Bean que represanta un línea en la impresión de reporte con jaspers
* 
* @author Martín Mantovani
*
*/
public class LineaReporteBeanCallCenter {

	private String fecha;
	
	private String cliente;
	
	private String operador;
	
	private String detalle;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	
}
