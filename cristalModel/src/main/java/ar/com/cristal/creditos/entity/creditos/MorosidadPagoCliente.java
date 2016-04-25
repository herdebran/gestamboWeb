package ar.com.cristal.creditos.entity.creditos;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MorosidadPagoCliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
	@Column
	private Date fechaEvaluacion = Calendar.getInstance().getTime();
	
	@Column
	private Date fechaProcesamiento;
		
	@Column
	private Double deuda; 
	
	@Column
	private Double deudaAGestionar; 
	
	@Column
	private Date fechaVencimientoCuotaAntigua;
	
	
	@Column
	private Double pago; 
	
	@Column
	private Date fechaPago;
	
	@Column
	private Long operadorId; 
	
	@Column
	private Long empresaId; 
	
	@Column
	private Long clienteId;
	
	@Column
	private String condicionMorosidad = "";
	
	@Column
	private Long creditoId;
	
	
	@Column
	private Long llamadoId;
	
	@Column
	private String medioPago = "";
	
	
	public MorosidadPagoCliente(){
		super();
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Date getFechaEvaluacion() {
		return fechaEvaluacion;
	}


	public void setFechaEvaluacion(Date fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}


	public Double getDeuda() {
		return deuda;
	}


	public void setDeuda(Double deuda) {
		this.deuda = deuda;
	}


	public Double getPago() {
		return pago;
	}


	public void setPago(Double pago) {
		this.pago = pago;
	}


	public Long getEmpresa() {
		return empresaId;
	}


	public void setEmpresa(Long empresa) {
		this.empresaId = empresa;
	}


	public Long getClienteId() {
		return clienteId;
	}


	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}


	public String getCondicionMorosidad() {
		return condicionMorosidad;
	}


	public void setCondicionMorosidad(String condicionMorosidad) {
		this.condicionMorosidad = condicionMorosidad;
	}


	public Date getFechaPago() {
		return fechaPago;
	}


	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}


	public Long getOperadorId() {
		return operadorId;
	}


	public void setOperadorId(Long operadorId) {
		this.operadorId = operadorId;
	}


	public Date getFechaVencimientoCuotaAntigua() {
		return fechaVencimientoCuotaAntigua;
	}


	public void setFechaVencimientoCuotaAntigua(Date fechaVencimientoCuotaAntigua) {
		this.fechaVencimientoCuotaAntigua = fechaVencimientoCuotaAntigua;
	}


	public Long getEmpresaId() {
		return empresaId;
	}


	public void setEmpresaId(Long empresaId) {
		this.empresaId = empresaId;
	}


	public Long getCreditoId() {
		return creditoId;
	}


	public void setCreditoId(Long creditoId) {
		this.creditoId = creditoId;
	}


	public String getMedioPago() {
		return medioPago;
	}


	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}


	public Double getDeudaAGestionar() {
		return deudaAGestionar;
	}


	public void setDeudaAGestionar(Double deudaAGestionar) {
		this.deudaAGestionar = deudaAGestionar;
	}


	public Date getFechaProcesamiento() {
		return fechaProcesamiento;
	}


	public void setFechaProcesamiento(Date fechaProcesamiento) {
		this.fechaProcesamiento = fechaProcesamiento;
	}


	public Long getLlamadoId() {
		return llamadoId;
	}


	public void setLlamadoId(Long llamadoId) {
		this.llamadoId = llamadoId;
	}

	
	
	
	

}