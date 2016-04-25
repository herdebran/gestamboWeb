package ar.com.cristal.creditos.client.dto;

import java.io.Serializable;

import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

/**
 * @author hernan.marzullo
 *
 */
public enum EstadoLineaMovimientoEnumDTO implements Serializable, ListBoxItem {
	CONFIRMADO, PENDIENTE_CONFIRMACION, RECHAZADO, CANCELADO;

	@Override
	public String getItemText() {
		return this.name();
	}

	@Override
	public String getItemValue() {
		return this.name();
	}
}