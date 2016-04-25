package ar.com.cristal.creditos.client.dto;

import java.io.Serializable;

import javax.persistence.Column;

public class ItemGastoSucursalDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String descripcion;
	
	private Long codigo;	
	
	public Boolean getSuma() {
		return suma;
	}

	public void setSuma(Boolean suma) {
		this.suma = suma;
	}

	public Boolean getEsAporte() {
		return esAporte;
	}

	public void setEsAporte(Boolean esAporte) {
		this.esAporte = esAporte;
	}

	public Boolean getEsRetiro() {
		return esRetiro;
	}

	public void setEsRetiro(Boolean esRetiro) {
		this.esRetiro = esRetiro;
	}

	private Boolean suma;
	
	private Boolean esAporte;

	private Boolean esRetiro;	
	
	private Boolean directorio;
	
	public Boolean getDirectorio() {
		return directorio;
	}

	public void setDirectorio(Boolean directorio) {
		this.directorio = directorio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


}
