/**
 * Entidad que guarda el historico de datos de un cliente.
 * Cada vez que se modifica un dato en el cliente, se escribe un registro con los datos viejos.
 */

package ar.com.cristal.creditos.entity.creditos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ar.com.cristal.creditos.localidad.Localidad;
import ar.com.cristal.creditos.localidad.Reparticion;

@Entity
@Table
public class ClienteHistorialDatos {
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public String getCaracteristica1() {
		return caracteristica1;
	}

	public void setCaracteristica1(String caracteristica1) {
		this.caracteristica1 = caracteristica1;
	}

	public String getCaracteristica2() {
		return caracteristica2;
	}

	public void setCaracteristica2(String caracteristica2) {
		this.caracteristica2 = caracteristica2;
	}

	public String getCaracteristica3() {
		return caracteristica3;
	}

	public void setCaracteristica3(String caracteristica3) {
		this.caracteristica3 = caracteristica3;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getTelefono3() {
		return telefono3;
	}

	public void setTelefono3(String telefono3) {
		this.telefono3 = telefono3;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getDpto() {
		return dpto;
	}

	public void setDpto(String dpto) {
		this.dpto = dpto;
	}

	public String getNro() {
		return nro;
	}

	public void setNro(String nro) {
		this.nro = nro;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Reparticion getReparticion() {
		return reparticion;
	}

	public void setReparticion(Reparticion reparticion) {
		this.reparticion = reparticion;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Long getIdComercializador() {
		return idComercializador;
	}

	public void setIdComercializador(Long idComercializador) {
		this.idComercializador = idComercializador;
	}

	public Long getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(Long usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
	@ManyToOne
	private Cliente cliente;
	
	@Column
	private String apellido;
	
	@Column
	private String nombre;
	
	@Column 
	private String cuit;
	
	@Column 
	private String cuil;
	
	@Column 
	private String telefono;
	
	@Column 
	private String telefono1;
	
	@Column 
	private String caracteristica;
	
	@Column 
	private String caracteristica1;
	
	@Column 
	private String caracteristica2;
	
	@Column 
	private String caracteristica3;
	
	@Column 
	private String telefono2;
	
	@Column 
	private String telefono3;
	
	@Column
	private String dni;
	
	@Column
	private Date fechaNacimiento;
	
	@Column
	private Date fechaModificacion;
	
	@Column
	private String cp;
	
	@Column
	private String dpto;
	
	@Column
	private String nro;
	
	@Column
	private String piso;
	
	@Column
	private String calle;
	
	@Column
	private String email;
	
	@ManyToOne
	private Reparticion reparticion;
	
	@ManyToOne
	private Localidad localidad;

	@Column
	private Long idComercializador;
	
	
	@Column
	private Long usuarioModificacion;
	
	@Column
	private String tipoDocumento;
	
	@Column(length=500)
	private String observaciones;

	
}


