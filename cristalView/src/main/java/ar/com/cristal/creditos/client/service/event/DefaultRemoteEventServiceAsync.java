package ar.com.cristal.creditos.client.service.event;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.novanic.eventservice.client.event.Event;

public interface DefaultRemoteEventServiceAsync {

	void enviarMensaje(String message, AsyncCallback<Void> callback);

	
	void enviarMensaje(String domain, String message, AsyncCallback<Void> callback);


	void enviarMensaje(String dominio, Event evento, AsyncCallback<Void> callback);
	
}
