package ar.com.cristal.creditos.client.tambo.dto;

import java.util.Date;

import ar.com.cristal.creditos.client.dto.DTO;
import ar.com.cristal.creditos.client.dto.EstablecimientoDTO;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;


@SuppressWarnings("serial")
public class ProductoDTO  extends DTO implements ListBoxItem{
	private Long id;
	private String nombreProducto;
	private TipoProductoEnumDTO tipo;
	private ProductoUnidadEnumDTO unidad;
	private double stock=0.0;
	private double precioUnitario=0.0;
	private Boolean activo=true;
	private Boolean cuentaStock=true;
	private Date fechaAlta;
	private Date fechaBaja;
	private EstablecimientoDTO establecimiento;
	private Long usuarioAlta;
	private Long usuarioBajaId;
	
	
	
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
	public TipoProductoEnumDTO getTipo() {
		return tipo;
	}
	public void setTipo(TipoProductoEnumDTO tipo) {
		this.tipo = tipo;
	}
	public ProductoUnidadEnumDTO getUnidad() {
		return unidad;
	}
	public void setUnidad(ProductoUnidadEnumDTO unidad) {
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
	public EstablecimientoDTO getEstablecimiento() {
		return establecimiento;
	}
	public void setEstablecimiento(EstablecimientoDTO establecimiento) {
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
	@Override
	public String getItemText() {
		return this.nombreProducto;
	}
	@Override
	public String getItemValue() {
		return this.id.toString();
	}
	
	

}
