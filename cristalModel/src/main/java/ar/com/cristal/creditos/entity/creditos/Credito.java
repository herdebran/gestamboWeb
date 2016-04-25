package ar.com.cristal.creditos.entity.creditos;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

import ar.com.cristal.creditos.common.EstadoCreditoEnum;
import ar.com.cristal.creditos.entity.commons.Empresa;

@Entity
@Table
public class Credito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
	@Column
	private Date fechaCreacion = Calendar.getInstance().getTime();
	
	
	@Column
	private Date fechaCancelacion = null;
	
	@Column
	private Double montoFinal; 
	
	@Column
	private String usuario;
	
	@ManyToOne
	private Empresa empresa; 
	
	@Column
	@Enumerated(EnumType.STRING)
	private EstadoCreditoEnum estado;
	
	
	
	public void setMontoFinal(Double montoFinal) {
		this.montoFinal = montoFinal;
	}


	@ManyToOne
	@NotNull
	private Cliente cliente;
	
	@Column
	private Long idComercializador = null;

	@Column
	private Double comisionComercializador;	

	@Column
	private Double gastosAdministrativos; 
	
	

	@Column 	
	private Double descuentoRefinanciacion;
	
	
	@Column
	private String condicionMorosidad = "";
	
	@Column
	private Boolean pagoVoluntario = false;
	
	public Credito(){
		super();
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public EstadoCreditoEnum getEstado() {
		return estado;
	}


	public void setEstado(EstadoCreditoEnum estado) {
		this.estado = estado;
	}


	public double getMontoFinal() {
		return montoFinal;
	}


	public void setMontoFinal(double montoFinal) {
		this.montoFinal = montoFinal;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public Double getComisionComercializador() {
		return comisionComercializador;
	}


	public void setComisionComercializador(Double comisionComercializador) {
		this.comisionComercializador = comisionComercializador;
	}


	public Double getGastosAdministrativos() {
		return gastosAdministrativos;
	}


	public void setGastosAdministrativos(Double gastosAdministrativos) {
		this.gastosAdministrativos = gastosAdministrativos;
	}


	public Long getIdComercializador() {
		return idComercializador;
	}


	public void setIdComercializador(Long idComercializador) {
		this.idComercializador = idComercializador;
	}



	/***
	 * Es el valor que se descuenta del monto solicitado cuando se realiza una refinanciación
	 * @return
	 */
	public Double getDescuentoRefinanciacion() {
		return descuentoRefinanciacion;
	}


	public void setDescuentoRefinanciacion(Double descuentoRefinanciacion) {
		this.descuentoRefinanciacion = descuentoRefinanciacion;
	}


	public String getCondicionMorosidad() {
		return condicionMorosidad;
	}


	public void setCondicionMorosidad(String condicionMorosidad) {
		this.condicionMorosidad = condicionMorosidad;
	}

	

	
	public Boolean getPagoVoluntario() {
		return pagoVoluntario;
	}

	public void setPagoVoluntario(Boolean pagoVoluntario) {
		this.pagoVoluntario = pagoVoluntario;
	}


	public Date getFechaCancelacion() {
		return fechaCancelacion;
	}


	public void setFechaCancelacion(Date fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}

}


