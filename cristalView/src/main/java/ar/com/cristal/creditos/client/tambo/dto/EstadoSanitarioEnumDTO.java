package ar.com.cristal.creditos.client.tambo.dto;

import java.io.Serializable;

import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

public enum EstadoSanitarioEnumDTO implements Serializable, ListBoxItem {
	SANA, PROBLEMA;
	
	@Override
	public String getItemText() {
		return this.name();
	}

	@Override
	public String getItemValue() {
		return this.name();
	}
}
