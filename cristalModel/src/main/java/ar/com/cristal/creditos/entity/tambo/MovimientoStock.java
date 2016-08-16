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

import org.hibernate.validator.NotNull;

import ar.com.cristal.creditos.common.ProductoUnidadEnum;
import ar.com.cristal.creditos.common.TipoMovStockEnum;
import ar.com.cristal.creditos.entity.login.Establecimiento;

@Entity
@Table
public class MovimientoStock {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	@ManyToOne
	@NotNull
	private Producto producto;
	@Enumerated(EnumType.STRING)
	private TipoMovStockEnum tipoMov;
	@Column
	private double cantidadEntra=0.0;
	@Column
	private double cantidadSale=0.0;
	@Enumerated(EnumType.STRING)
	private ProductoUnidadEnum unidad;
	@Column
	private double precioUnitario=0.0;
	@Column
	private Boolean eliminado=false;
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
	

	public MovimientoStock(){
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public TipoMovStockEnum getTipoMov() {
		return tipoMov;
	}


	public void setTipoMov(TipoMovStockEnum tipoMov) {
		this.tipoMov = tipoMov;
	}


	public double getCantidadEntra() {
		return cantidadEntra;
	}


	public void setCantidadEntra(double cantidadEntra) {
		this.cantidadEntra = cantidadEntra;
	}


	public double getCantidadSale() {
		return cantidadSale;
	}


	public void setCantidadSale(double cantidadSale) {
		this.cantidadSale = cantidadSale;
	}


	public ProductoUnidadEnum getUnidad() {
		return unidad;
	}


	public void setUnidad(ProductoUnidadEnum unidad) {
		this.unidad = unidad;
	}


	public double getPrecioUnitario() {
		return precioUnitario;
	}


	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}




	public Boolean getEliminado() {
		return eliminado;
	}


	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
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


