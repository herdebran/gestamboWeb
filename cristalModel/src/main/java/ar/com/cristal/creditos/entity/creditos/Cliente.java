package ar.com.cristal.creditos.entity.creditos;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ar.com.cristal.creditos.common.EstadoClienteEnum;
import ar.com.cristal.creditos.entity.cliente.DatoAnexo;
import ar.com.cristal.creditos.localidad.Localidad;

@Entity
@Table
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
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
	
	@Enumerated(EnumType.STRING)
	private EstadoClienteEnum estado;
	
	@Column
	private Date fechaAlta;
	
	@Column
	private Date fechaNacimiento;
	
	@Column
	private Date fechaBaja;
	
	@Column
	private Boolean eliminado;
		
	@Column
	private Boolean pagoVoluntario;
	
	@Column
	private String cp;
	
	@Column
	private String dpto;
	
	@Column
	private String nro;
	
	@Column
	private String piso;
	
	@Column(length=500)
	private String observaciones;
	
	@Column
	private String calle;
	
	@Column
	private Double sueldo; 
	
	@Column
	private String email;
	
	@Column
	private Boolean tarjetaBeneficios;
	
	@Column
	private String CBU;
	
	@Column
	private Boolean antecedentesJuridicos;
	
	
	@Column
	private Date fechaEnvioCartaMoroso2;
	
	@Column
	private Date fechaEnvioCartaPrejudicial;
	
	
	@Column
	private String condicionMorosidad = "";
	
	@OneToMany(mappedBy="cliente")
	@JoinColumn(name="cliente_id")
	private List<DatoAnexo> datosAnexos;
	
	@ManyToOne
	private Localidad localidad;

	@Column
	private Long nroCuenta;
	
	@Column
	private String sexo;
	
	@Column
	private Long usuarioAlta;
	
	@Column
	private Long usuarioBajaId;
	
	
	@Column
	private String tipoDocumento;
	
	public Long getUsuarioBajaId() {
		return usuarioBajaId;
	}

	public void setUsuarioBajaId(Long usuarioBaja) {
		this.usuarioBajaId = usuarioBaja;
	}
	@Column
	private Long usuarioModificacion;

	public Cliente(){
		super();
	}

	public Cliente(String apellido, String nombre) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public EstadoClienteEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoClienteEnum estado) {
		this.estado = estado;
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
	
	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public Boolean getEliminado() {
		return eliminado;
	}

	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
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


	public List<DatoAnexo> getDatosAnexos() {
		return datosAnexos;
	}

	public void setDatosAnexos(List<DatoAnexo> datosAnexos) {
		this.datosAnexos = datosAnexos;
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

	public Long getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(Long nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	
	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public String getCBU() {
		return CBU;
	}

	public void setCBU(String cBU) {
		CBU = cBU;
	}
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public String getCondicionMorosidad() {
		return condicionMorosidad;
	}

	public void setCondicionMorosidad(String condicionMorosidad) {
		this.condicionMorosidad = condicionMorosidad;
	}



	public Long getUsuarioAlta() {
		return usuarioAlta;
	}

	public void setUsuarioAlta(Long usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}

	public Long getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(Long usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public boolean esMoroso() {
		if (condicionMorosidad == null)
			return false;
		else
			return !"".equals(condicionMorosidad);		
	}
	
	
}


