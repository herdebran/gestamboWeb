package ar.com.cristal.creditos.client.ui.event;

import com.google.gwt.core.client.GWT;

import de.novanic.eventservice.client.event.Event;


/***
 * Evento para informar que existen reportes nuevo
 * @author daniel.madera
 *
 */
public class DocumentoGeneradoEvent implements Event{


	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static DocumentoGeneradoEvent instance;
		
		public static DocumentoGeneradoEvent getInstance(){
			if (instance == null) {
				instance = GWT.create(DocumentoGeneradoEvent.class);
			}
			return instance;
		}
		
		
		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String message;

	public DocumentoGeneradoEvent(){}

	public DocumentoGeneradoEvent(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
