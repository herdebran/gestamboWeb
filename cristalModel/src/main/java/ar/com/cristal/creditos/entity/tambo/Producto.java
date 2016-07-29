package ar.com.cristal.creditos.entity.tambo;
/**
 * Representa los Productos del Establecimiento. Sirve para mantener el Stock y Precio
 */

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

import ar.com.cristal.creditos.common.ProductoUnidadEnum;
import ar.com.cristal.creditos.common.TipoProductoEnum;
import ar.com.cristal.creditos.entity.login.Establecimiento;

@Entity
@Table
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	@Column
	private String nombreProducto;
	@Enumerated(EnumType.STRING)
	private TipoProductoEnum tipo;
	@Enumerated(EnumType.STRING)
	private ProductoUnidadEnum unidad;
	@Column
	private double stock=0.0;
	@Column
	private double precioUnitario=0.0;
	@Column
	private Boolean activo=true;
	@Column
	private Boolean cuentaStock=true;
	@Column
	private Date fechaAlta;
	@Column
	private Date fechaBaja;
	@ManyToOne
	private Establecimiento establecimiento;
	@Column
	private Long usuarioAlta;
	@Column
	private Long usuarioBajaId;
	

	public Producto(){
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombreProducto() {
		return nombreProducto;
	}


	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}


	public TipoProductoEnum getTipo() {
		return tipo;
	}


	public void setTipo(TipoProductoEnum tipo) {
		this.tipo = tipo;
	}


	public ProductoUnidadEnum getUnidad() {
		return unidad;
	}


	public void setUnidad(ProductoUnidadEnum unidad) {
		this.unidad = unidad;
	}


	public double getStock() {
		return stock;
	}


	public void setStock(double stock) {
		this.stock = stock;
	}


	public double getPrecioUnitario() {
		return precioUnitario;
	}


	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}


	public Boolean getActivo() {
		return activo;
	}


	public void setActivo(Boolean activo) {
		this.activo = activo;
	}


	public Boolean getCuentaStock() {
		return cuentaStock;
	}


	public void setCuentaStock(Boolean cuentaStock) {
		this.cuentaStock = cuentaStock;
	}


	public Date getFechaAlta() {
		return fechaAlta;
	}


	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	public Date getFechaBaja() {
		return fechaBaja;
	}


	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}


	public Establecimiento getEstablecimiento() {
		return establecimiento;
	}


	public void setEstablecimiento(Establecimiento establecimiento) {
		this.establecimiento = establecimiento;
	}


	public Long getUsuarioAlta() {
		return usuarioAlta;
	}


	public void setUsuarioAlta(Long usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}


	public Long getUsuarioBajaId() {
		return usuarioBajaId;
	}


	public void setUsuarioBajaId(Long usuarioBajaId) {
		this.usuarioBajaId = usuarioBajaId;
	}

	
	
	
}


