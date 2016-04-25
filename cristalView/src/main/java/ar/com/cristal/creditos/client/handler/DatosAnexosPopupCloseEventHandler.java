package ar.com.cristal.creditos.client.handler;

import ar.com.cristal.creditos.client.event.DatosAnexosPopupCloseEvent;

import com.google.gwt.event.shared.EventHandler;

public interface DatosAnexosPopupCloseEventHandler extends EventHandler {
	void onClose(DatosAnexosPopupCloseEvent event);
}
