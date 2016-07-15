package ar.com.cristal.creditos.client.dto;

import java.io.Serializable;

import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

/**
 * @author hernan.marzullo
 *
 */
public enum TipoCeloServicioEnumDTO implements Serializable, ListBoxItem {
	CELO_SIN_SERVICIO("Celo sin servicio"),SERVICIO("Servicio");

	private String descripcion; 

	private TipoCeloServicioEnumDTO(String desc) {
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