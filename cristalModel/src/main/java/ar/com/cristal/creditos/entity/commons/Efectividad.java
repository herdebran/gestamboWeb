package ar.com.cristal.creditos.entity.commons;

/**
 * Efectividad para reporte por sucursal.
 * 
 * @author mmanto
 *
 */
public class Efectividad {
	
 /***
  * Apellido y nombre del operador
  */
 private String nombre;
 
 private String sucursal;
 
 //MOROSIDAD
 private Long cantidadClientesMorosidad = 0L;

 private Long cantidadLlamadasMorosidad = 0L;
 
 private Long cantidadLlamadasMorosidadEfectiva = 0L;
 
 private Double  porcentajeMorosidad = 0.0;
 
 //COLOCACION
 private Long cantidadClientesColocacion = 0L;
 
 private Long cantidadLlamadasColocacion = 0L;
 
 private Long cantidadLlamadasColocacionEfectiva = 0L;
 
 private Double  porcentajeColocacion = 0.0;
 

 //PREJUDICIAL
 private Long cantidadClientesPrejudicial = 0L;
 
 private Long cantidadLlamadasPrejudicial = 0L;
 
 private Long cantidadLlamadasPrejudicialEfectiva = 0L;
 
 private Double  porcentajePrejudicial = 0.0;
 

 
 public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public Long getCantidadLlamadasMorosidad() {
	return cantidadLlamadasMorosidad;
}

public void setCantidadLlamadasMorosidad(Long cantidadLlamadasMorosidad) {
	this.cantidadLlamadasMorosidad = cantidadLlamadasMorosidad;
}

public Long getCantidadLlamadasMorosidadEfectiva() {
	return cantidadLlamadasMorosidadEfectiva;
}

public void setCantidadLlamadasMorosidadEfectiva(
		Long cantidadLlamadasMorosidadEfectiva) {
	this.cantidadLlamadasMorosidadEfectiva = cantidadLlamadasMorosidadEfectiva;
}

public Double getPorcentajeMorosidad() {
	return porcentajeMorosidad;
}

public void setPorcentajeMorosidad(Double porcentajeMorosidad) {
	this.porcentajeMorosidad = porcentajeMorosidad;
}

public Long getCantidadLlamadasColocacion() {
	return cantidadLlamadasColocacion;
}

public void setCantidadLlamadasColocacion(Long cantidadLlamadasColocacion) {
	this.cantidadLlamadasColocacion = cantidadLlamadasColocacion;
}

public Long getCantidadLlamadasColocacionEfectiva() {
	return cantidadLlamadasColocacionEfectiva;
}

public void setCantidadLlamadasColocacionEfectiva(
		Long cantidadLlamadasColocacionEfectiva) {
	this.cantidadLlamadasColocacionEfectiva = cantidadLlamadasColocacionEfectiva;
}

public Double getPorcentajeColocacion() {
	return porcentajeColocacion;
}

public void setPorcentajeColocacion(Double porcentajeColocacion) {
	this.porcentajeColocacion = porcentajeColocacion;
}

public Long getCantidadClientesMorosidad() {
	return cantidadClientesMorosidad;
}

public void setCantidadClientesMorosidad(Long cantidadClientesMorosidad) {
	this.cantidadClientesMorosidad = cantidadClientesMorosidad;
}

public Long getCantidadClientesColocacion() {
	return cantidadClientesColocacion;
}

public void setCantidadClientesColocacion(Long cantidadClientesColocacion) {
	this.cantidadClientesColocacion = cantidadClientesColocacion;
}

public Long getCantidadClientesPrejudicial() {
	return cantidadClientesPrejudicial;
}

public void setCantidadClientesPrejudicial(Long cantidadClientesPrejudicial) {
	this.cantidadClientesPrejudicial = cantidadClientesPrejudicial;
}

public Long getCantidadLlamadasPrejudicial() {
	return cantidadLlamadasPrejudicial;
}

public void setCantidadLlamadasPrejudicial(Long cantidadLlamadasPrejudicial) {
	this.cantidadLlamadasPrejudicial = cantidadLlamadasPrejudicial;
}

public Long getCantidadLlamadasPrejudicialEfectiva() {
	return cantidadLlamadasPrejudicialEfectiva;
}

public void setCantidadLlamadasPrejudicialEfectiva(
		Long cantidadLlamadasPrejudicialEfectiva) {
	this.cantidadLlamadasPrejudicialEfectiva = cantidadLlamadasPrejudicialEfectiva;
}

public Double getPorcentajePrejudicial() {
	return porcentajePrejudicial;
}

public void setPorcentajePrejudicial(Double porcentajePrejudicial) {
	this.porcentajePrejudicial = porcentajePrejudicial;
}

public String getSucursal() {
	return sucursal;
}

public void setSucursal(String sucursal) {
	this.sucursal = sucursal;
}


 
}
