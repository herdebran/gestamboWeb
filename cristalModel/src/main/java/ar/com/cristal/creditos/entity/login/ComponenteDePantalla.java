package ar.com.cristal.creditos.entity.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta clase modela un componente de pantalla, este es cualquiera de los widgets que el 
 * usuario quiera tener controlado el acceso. Un componente de pantalla puede ser: boton
 * grilla, combo, incluso una pantalla, etc.
 * @author Guillermo Tonello
 */

@Entity
@Table
public class ComponenteDePantalla {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	int id = 0;
	
//	@Column
//	Long idPerfil;
	

	@Column
	String nombre = "";
	
	@Column
	String descripcion = "";
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

//	public Long getIdPerfil() {
//		return idPerfil;
//	}
//	public void setIdPerfil(Long idPerfil) {
//		this.idPerfil = idPerfil;
//	}
}
