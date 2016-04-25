
package ar.com.cristal.creditos.entity.sucursales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ar.com.cristal.creditos.common.Constantes;

@Entity
@Table
public class Sucursal {
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
	@Column
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
	
	public boolean esCasaCentral(){
		return Constantes.SUCURSAL_LAPLATA_CENTRAL.equalsIgnoreCase(getNombre());
	}
	
}
