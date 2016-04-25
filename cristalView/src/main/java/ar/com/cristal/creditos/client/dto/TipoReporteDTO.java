package ar.com.cristal.creditos.client.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

@SuppressWarnings("serial")
public class TipoReporteDTO  extends DTO implements ListBoxItem{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private String codigoReporte;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public String getItemText() {
		return nombre;
	}

	@Override
	public String getItemValue() {
		return id.toString();
	}

	public String getCodigoReporte() {
		return codigoReporte;
	}

	public void setCodigoReporte(String codigoReporte) {
		this.codigoReporte = codigoReporte;
	}

}
