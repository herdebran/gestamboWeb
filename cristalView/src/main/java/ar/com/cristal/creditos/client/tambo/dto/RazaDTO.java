package ar.com.cristal.creditos.client.tambo.dto;

import ar.com.cristal.creditos.client.dto.DTO;


@SuppressWarnings("serial")
public class RazaDTO  extends DTO {
	private Long id;
	private String nombre;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
