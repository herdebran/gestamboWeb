package ar.com.cristal.creditos.client.dto;

import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

@SuppressWarnings("serial")
public class EmpresaDTO extends DTO implements ListBoxItem{
	
	private String id;
	
	private String nombre;
	
	private String cuil;
	
	private String domicilio;
	
	private Double participacionDirecta;
	
	private Double participacionIndirecta;
	
	private boolean cobraCuotaSocial = false;

	private boolean permiteRapipago = false;

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public String getItemText() {
		return nombre;
	}

	public String getItemValue() {
		return id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Double getParticipacionDirecta() {
		return participacionDirecta;
	}

	public void setParticipacionDirecta(Double participacionDirecta) {
		this.participacionDirecta = participacionDirecta;
	}

	public Double getParticipacionIndirecta() {
		return participacionIndirecta;
	}

	public void setParticipacionIndirecta(Double participacionIndirecta) {
		this.participacionIndirecta = participacionIndirecta;
	}	
	
	public boolean getCobraCuotaSocial() {
		return cobraCuotaSocial;
	}

	public void setCobraCuotaSocial(boolean cobraCuotaSocial) {
		this.cobraCuotaSocial = cobraCuotaSocial;
	}

	public boolean getPermiteRapipago() {
		return permiteRapipago;
	}

	public void setPermiteRapipago(boolean permiteRapipago) {
		this.permiteRapipago = permiteRapipago;
	}	
	
}
