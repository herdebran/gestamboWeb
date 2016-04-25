package ar.com.cristal.creditos.client.ui.event.handler;

import ar.com.cristal.creditos.client.ui.event.AddClientEvent;

import com.google.gwt.event.shared.EventHandler;

public interface AddClientEventHandler extends EventHandler {
	void onAddClient(AddClientEvent event);
}
