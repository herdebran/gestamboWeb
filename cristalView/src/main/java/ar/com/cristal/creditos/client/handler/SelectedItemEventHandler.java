package ar.com.cristal.creditos.client.handler;

import ar.com.cristal.creditos.client.event.SelectedItemEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SelectedItemEventHandler extends EventHandler {
	void onSelectItem(SelectedItemEvent event);
}
