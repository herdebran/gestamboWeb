package ar.com.cristal.creditos.client.service.event;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.novanic.eventservice.client.event.Event;

@RemoteServiceRelativePath("DefaultRemoteEventService")
public interface DefaultRemoteEventService extends RemoteService {
	
	
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static DefaultRemoteEventServiceAsync instance;
		
		public static DefaultRemoteEventServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(DefaultRemoteEventService.class);
			}
			return instance;
		}
		
		
		
	}
	
	
	void enviarMensaje(String message);
	
	void enviarMensaje(String dominio, String message);
	
	void enviarMensaje(String dominio, Event evento);
	
}
