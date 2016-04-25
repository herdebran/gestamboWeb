package ar.com.cristal.creditos.localidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Reparticion {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
	
	
	@Column
	private Boolean tipoPrivado;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getTipoPrivado() {
		return tipoPrivado;
	}

	public void setTipoPrivado(Boolean b) {
		tipoPrivado = b;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	

	
	
}
