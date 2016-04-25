package ar.com.cristal.creditos.client.accesibilidad;

import java.io.Serializable;

public class ComponenteDePantallaDto implements Serializable {

	boolean checked = false;
	int id = 0;
	String nombre = "";
	String descripcion = "";
	
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
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

	
	
	
	
}
