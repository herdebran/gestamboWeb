package ar.com.cristal.creditos.client.clientes.busqueda.detalle;

import ar.com.cristal.creditos.client.dto.DTO;


/**
 * representa los datos que llenan los campos de la pantalla de operaciones e historial de credito de un cliente
 * @author lucas.napoli
 *
 */
public class DatosOperacionesHistorialCreditosClienteDTO extends DTO {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private int row;	//solo vista
		private int idCliente;

		private String apellido;
		private String nombre;
		private String estadoCliente;
		private String cuilCliente;
		private String dniCliente;
		private long nroAsociado;
		private int cuotasSocialesDeuda;
		private double montoCuotasSocialesDeuda;
		private Long idComercializador;
		private String condicionMorosidad;
		private String descTipoCredito;
		private Long diasDesdeUltimoPago;
		
		public Long getDiasDesdeUltimoPago() {
			return diasDesdeUltimoPago;
		}
		public void setDiasDesdeUltimoPago(Long diasDesdeUltimoPago) {
			this.diasDesdeUltimoPago = diasDesdeUltimoPago;
		}
		public Long getIdComercializador() {
			return idComercializador;
		}
		public void setIdComercializador(Long idComercializador) {
			this.idComercializador = idComercializador;
		}
		public int getRow() {
			return row;
		}
		public void setRow(int row) {
			this.row = row;
		}
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getEstadoCliente() {
			return estadoCliente;
		}
		public void setEstadoCliente(String estadoCliente) {
			this.estadoCliente = estadoCliente;
		}
		public String getCuilCliente() {
			return cuilCliente;
		}
		public void setCuilCliente(String cuitCliente) {
			this.cuilCliente = cuitCliente;
		}
		public String getDniCliente() {
			return dniCliente;
		}
		public void setDniCliente(String dniCliente) {
			this.dniCliente = dniCliente;
		}
		public long getNroAsociado() {
			return nroAsociado;
		}
		public void setNroAsociado(long nroAsociado) {
			this.nroAsociado = nroAsociado;
		}
		public int getCuotasSocialesDeuda() {
			return cuotasSocialesDeuda;
		}
		public void setCuotasSocialesDeuda(int cuotasSocialesDeuda) {
			this.cuotasSocialesDeuda = cuotasSocialesDeuda;
		}
		public int getIdCliente() {
			return idCliente;
		}
		public void setIdCliente(int idCliente) {
			this.idCliente = idCliente;
		}
		public String getCondicionMorosidad() {
			return condicionMorosidad;
		}
		
		public void setCondicionMorosidad(String condicionMorosidad) {
			this.condicionMorosidad = condicionMorosidad;
		}
		public double getMontoCuotasSocialesDeuda() {
			return montoCuotasSocialesDeuda;
		}
		public void setMontoCuotasSocialesDeuda(double montoCuotasSocialesDeuda) {
			this.montoCuotasSocialesDeuda = montoCuotasSocialesDeuda;
		}
		public String getDescTipoCredito() {
			return descTipoCredito;
		}
		public void setDescTipoCredito(String descTipoCredito) {
			this.descTipoCredito = descTipoCredito;
		}
		
		
}
