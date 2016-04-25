package ar.com.cristal.creditos.client.dto;

import java.util.Date;

import ar.com.cristal.creditos.client.localidad.LocalidadDTO;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

/**
 * Dto pantalla cliente
 * @author Guillermo Tonello
 *
 */

public class ClienteDTO extends DTO implements ListBoxItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String apellido;
	private String nombre;
	private String telefono;
	private String telefono1;
	private String telefono2;
	private String telefono3;
	private String tipoDocumento;
	private String dni;
	private String CBU;
	private String CUIL;
	private Date fechaAlta;
	private Date fechaNacimiento;
	private Date fechaModificacion;
	private String nombreUsuario;
	private String caracteristica;
	private String caracteristica1;
	private String caracteristica2;
	private String caracteristica3;
	
	private Boolean pagoVoluntario;
	private String nro;
	private String piso;
	private String dpto;
	private String cp;
	private String calle;
	
	private Double sueldo;
	private String observaciones;
	
	private String email;
	private Boolean tarjetaBeneficios;
	private Boolean antecedentesJuridicos;
	private LocalidadDTO localidad;
	
	private Date fechaEnvioCartaMoroso2;	
	private Date fechaEnvioCartaPrejudicial;
	
	
	private Long nroCuenta;
	
	
	
	//modificacion x acceso a info cuando loguea el comercializador
	//tambien x liquidaciones
	private Long idComercializador;

	private String condicionMorosidad = "";
		

	public Long getIdComercializador() {
		return idComercializador;
	}
	public void setIdComercializador(Long idComercializador) {
		this.idComercializador = idComercializador;
	}
	private String estado;
	private String sexo;
	

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
	public String getDpto() {
		return dpto;
	}
	public void setDpto(String dpto) {
		this.dpto = dpto;
	}

	public String getCUIL() {
		return CUIL;
	}
	public void setCUIL(String cUIL) {
		CUIL = cUIL;
	}
	public String getCBU() {
		return CBU;
	}
	public void setCBU(String cBU) {
		CBU = cBU;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getTelefono1() {
		return telefono1;
	}
	public void setTelefono1(String telefono) {
		this.telefono1 = telefono;
	}
	
	
	public String getItemText() {
		
		return apellido + ", " + nombre;
	}
	public String getItemValue() {
		
		return id.toString();
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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
	public Boolean getPagoVoluntario() {
		return pagoVoluntario;
	}
	public void setPagoVoluntario(Boolean pagoVoluntario) {
		this.pagoVoluntario = pagoVoluntario;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Double getSueldo() {
		return sueldo;
	}
	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getTarjetaBeneficios() {
		return tarjetaBeneficios;
	}
	public void setTarjetaBeneficios(Boolean tarjetaBeneficios) {
		this.tarjetaBeneficios = tarjetaBeneficios;
	}
	public Boolean getAntecedentesJuridicos() {
		return antecedentesJuridicos;
	}
	public void setAntecedentesJuridicos(Boolean antecedentesJuridicos) {
		this.antecedentesJuridicos = antecedentesJuridicos;
	}

	public LocalidadDTO getLocalidad() {
		return localidad;
	}
	public void setLocalidad(LocalidadDTO localidad) {
		this.localidad = localidad;
	}

	public Long getNroCuenta() {
		return nroCuenta;
	}
	public void setNroCuenta(Long nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getCondicionMorosidad() {
		return condicionMorosidad;
	}
	public void setCondicionMorosidad(String condicionMorosidad) {
		this.condicionMorosidad = condicionMorosidad;
	}
	
	public String getSexoInicial() {
		if (sexo != null && !sexo.isEmpty())			
			return sexo.substring(0,1).toUpperCase();
		else
			return "";
	}
	public String getApellidoNombreId() {
		String result = getApellido() + ", " + getNombre() + " (" + getId() + ")";
		
		return result.toUpperCase();
				
	}
	public Date getFechaEnvioCartaMoroso2() {
		return fechaEnvioCartaMoroso2;
	}
	public void setFechaEnvioCartaMoroso2(Date fechaEnvioCartaMoroso2) {
		this.fechaEnvioCartaMoroso2 = fechaEnvioCartaMoroso2;
	}
	public Date getFechaEnvioCartaPrejudicial() {
		return fechaEnvioCartaPrejudicial;
	}
	public void setFechaEnvioCartaPrejudicial(Date fechaEnvioCartaPrejudicial) {
		this.fechaEnvioCartaPrejudicial = fechaEnvioCartaPrejudicial;
	}

	
}
