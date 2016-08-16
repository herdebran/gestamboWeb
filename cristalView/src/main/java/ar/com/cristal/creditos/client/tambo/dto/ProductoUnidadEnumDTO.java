package ar.com.cristal.creditos.client.tambo.dto;

import java.io.Serializable;

import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

/**
 * @author hernan.marzullo
 *
 */
public enum ProductoUnidadEnumDTO implements Serializable, ListBoxItem {
	UNIDADES,KG, LTS, HS, M2, M3, MM;

	@Override
	public String getItemText() {
		return this.name();
	}

	@Override
	public String getItemValue() {
		return this.name();
	}
}