package ar.com.cristal.creditos.reportes.beans.cajas;


public class LineaReporteMovimientoCajaBean{

	
	/**
	 * usado para el reporte de movimientos de caja entre dos fechas
	***/

	public LineaReporteMovimientoCajaBean(String f, String c, Double e, Double s, String co, String es, String su, String u){
		fecha=f;
		concepto=c;
		entrada = e;
		salida = s;
		comprobante = co;
		estado = es;
		sucursal = su;
		usuario = u;
	}

	String fecha="una fecha";
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public Double getEntrada() {
		return entrada;
	}
	public void setEntrada(Double entrada) {
		this.entrada = entrada;
	}
	public Double getSalida() {
		return salida;
	}
	public void setSalida(Double salida) {
		this.salida = salida;
	}
	public String getComprobante() {
		return comprobante;
	}
	public void setComprobante(String comprobante) {
		this.comprobante = comprobante;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getSucursal() {
		return sucursal;
	}
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	String concepto="un concepto";
	Double entrada = 0D;
	Double salida = 0D;
	String comprobante = "comp";
	String estado = "un estado";
	String sucursal = "Una sucu";
	String usuario = "us";
	

}
