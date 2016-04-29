package ar.com.cristal.creditos.client.tambo.dto;

import java.io.Serializable;

import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

/**
 * @author hernan.marzullo
 *
 */
public enum TipoRodeoEnumDTO implements Serializable, ListBoxItem {
	GUACHERA, RECRIA, VAQUILLONAS, TAMBO_GENERAL, TAMBO_PUNTA, TAMBO_COLA, SECAS, BAJAS;

	@Override
	public String getItemText() {
		return this.name();
	}

	@Override
	public String getItemValue() {
		return this.name();
	}
}