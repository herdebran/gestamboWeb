package ar.com.cristal.creditos.client.tambo.dto;

import java.util.Date;

import ar.com.cristal.creditos.client.dto.DTO;
import ar.com.cristal.creditos.client.dto.EstablecimientoDTO;
import ar.com.cristal.creditos.entity.login.Establecimiento;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;


@SuppressWarnings("serial")
public class InseminadorDTO  extends DTO implements ListBoxItem{
	private Long id;
	private String apellido;
	private String nombre;
	private Date fechaAlta;
	private Date fechaBaja;
	private Boolean eliminado=false;
	private EstablecimientoDTO establecimiento;
	private Long usuarioAlta;
	private Long usuarioBajaId;

	
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
	public Boolean getEliminado() {
		return eliminado;
	}
	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
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
		String result="";
		
		if (this.apellido!= null)
			result=this.apellido;
		if (this.nombre != null){
			if (result.equals(""))
				result = this.nombre;
			else
				result += ", " + this.nombre;
		}
		return result;
	}
	@Override
	public String getItemValue() {
		return this.id.toString();
	}
	
	

}
