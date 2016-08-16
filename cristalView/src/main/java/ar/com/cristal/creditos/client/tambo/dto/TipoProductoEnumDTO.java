package ar.com.cristal.creditos.client.tambo.dto;

import java.io.Serializable;

import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

/**
 * @author hernan.marzullo
 *
 */
public enum TipoProductoEnumDTO implements Serializable, ListBoxItem {
	INGRESO,EGRESO;

	@Override
	public String getItemText() {
		return this.name();
	}

	@Override
	public String getItemValue() {
		return this.name();
	}
}