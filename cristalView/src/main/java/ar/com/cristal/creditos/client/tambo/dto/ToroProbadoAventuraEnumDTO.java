package ar.com.cristal.creditos.client.tambo.dto;

import java.io.Serializable;

import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

/**
 * @author hernan.marzullo
 *
 */
public enum ToroProbadoAventuraEnumDTO implements Serializable, ListBoxItem {
	P("PROBADO"),A("AVENTURA");

	private String descripcion; 

	ToroProbadoAventuraEnumDTO(String desc){
		descripcion = desc;
	}
	@Override
	public String getItemText() {
		return this.descripcion;
	}

	@Override
	public String getItemValue() {
		return this.name();
	}
}