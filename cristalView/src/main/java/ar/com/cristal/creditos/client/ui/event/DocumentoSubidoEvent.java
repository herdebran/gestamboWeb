package ar.com.cristal.creditos.client.ui.event;

import com.google.gwt.core.client.GWT;

import de.novanic.eventservice.client.event.Event;


/***
 * Evento para informar que existen reportes nuevo
 * @author daniel.madera
 *
 */
public class DocumentoSubidoEvent implements Event{


	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static DocumentoSubidoEvent instance;
		
		public static DocumentoSubidoEvent getInstance(){
			if (instance == null) {
				instance = GWT.create(DocumentoSubidoEvent.class);
			}
			return instance;
		}
		
		
		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String message;
	public boolean exito = true;

	public boolean getExito() {
		return exito;
	}

	public void setExito(boolean exito) {
		this.exito = exito;
	}

	public DocumentoSubidoEvent(){
		exito = true;
	}

	public DocumentoSubidoEvent(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
