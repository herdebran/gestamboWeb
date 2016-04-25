package ar.com.cristal.creditos.client.dto;

import java.io.Serializable;

import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

/**
 * @author hernan.marzullo
 *
 */
public enum TipoLineaMovimientoEnumDTO implements Serializable, ListBoxItem {
	GASTO, TRANSFERENCIA_ENTRANTE, TRANSFERENCIA_SALIENTE, APORTE, RETIRO, CREDITO;

	@Override
	public String getItemText() {
		return this.name();
	}

	@Override
	public String getItemValue() {
		return this.name();
	}
}