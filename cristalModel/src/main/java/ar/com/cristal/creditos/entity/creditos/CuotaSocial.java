package ar.com.cristal.creditos.entity.creditos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table
public class CuotaSocial {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Long cliente_id) {
		this.cliente_id = cliente_id;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	
	

	@Column
	private Long cliente_id;
	
	@Column
	private Date mes;
	
	@Column
	private Double monto = 0.0;
	
	@Column
	private Long usuarioPagoId;
	
	@Column
	private Date fechaRegistroSistema;

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	@Column
	private Date fechaPago;
	
	@Column
	private String detalle;
	

	@Column
	private String estado;
	
	@Column
	private String medioDePago;
	
	@Column
	private Long idEmpresa;
	
	
	@Column(name="sucursal_id")
	private Long sucursalId;
	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Date getMes() {
		return mes;
	}

	public void setMes(Date mes) {
		this.mes = mes;
	}

	public String getMedioDePago() {
		return medioDePago;
	}

	public void setMedioDePago(String medioDePago) {
		this.medioDePago = medioDePago;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Long getUsuarioPagoId() {
		return usuarioPagoId;
	}

	public void setUsuarioPagoId(Long usuarioPagoId) {
		this.usuarioPagoId = usuarioPagoId;
	}
	
	public Long getSucursalId() {
		return sucursalId;
	}

	public void setSucursalId(Long sucursalId) {
		this.sucursalId = sucursalId;
	}

	public Date getFechaRegistroSitema() {
		return fechaRegistroSistema;
	}

	public void setFechaRegistroSitema(Date fechaRegistroSitema) {
		this.fechaRegistroSistema = fechaRegistroSitema;
	}


	
	
	
}
