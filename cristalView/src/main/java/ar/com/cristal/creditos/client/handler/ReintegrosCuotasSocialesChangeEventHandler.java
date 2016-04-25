package ar.com.cristal.creditos.client.handler;

import ar.com.cristal.creditos.client.event.ReintegroCuotaSocialChangeEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReintegrosCuotasSocialesChangeEventHandler extends EventHandler {
	void onChange(ReintegroCuotaSocialChangeEvent event);
}
