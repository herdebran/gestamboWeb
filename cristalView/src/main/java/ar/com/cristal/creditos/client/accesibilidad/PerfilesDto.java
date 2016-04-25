package ar.com.cristal.creditos.client.accesibilidad;

import java.io.Serializable;

import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

public class PerfilesDto implements Serializable ,ListBoxItem {


	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	boolean checked = false;
	String nombre="";
	String Descripcion="";
	private String listaComponentes="";
	
	public String getListaComponentes() {
		return listaComponentes;
	}
	public void setListaComponentes(String listaComponentes) {
		this.listaComponentes = listaComponentes;
	}
	public String getItemText() {
		return nombre;
	}
	public String getItemValue() {
		return "" + id;
	}
	
	public void agregarComponente(String idcomp){
		String idC = (this.getListaComponentes() == null || this.getListaComponentes().length() == 0)? idcomp : "," + idcomp;
		listaComponentes= listaComponentes + idC.trim();
	}
	
	
	public  void sacoComponente(String idcomp){
		idcomp = idcomp +",";
		listaComponentes = listaComponentes.replaceAll(idcomp,"");
	}
	
	
	
	
	
	
	
	
	
}
