package ar.com.cristal.creditos.client.ui.event;

import de.novanic.eventservice.client.event.Event;
import de.novanic.eventservice.client.event.listener.RemoteEventListener;

public class DocumentoGeneradoEventListener  implements RemoteEventListener  {
		

	/**
	 * This function gets called by EventService
	 */
	public void apply(Event anEvent) {
		
		
		
		/**
		 * Check if the incoming Event is from the type MyEvent and if so, call the corresponding function
		 */
		if(anEvent instanceof DocumentoGeneradoEvent)			
			onDocumentoGeneradoEventListener((DocumentoGeneradoEvent)anEvent);
		
	}

	/**
	 * This function gets called when the incomming Event is from the Type MyEvent
	 *
	 * @param event
	 */
	public void onDocumentoGeneradoEventListener(DocumentoGeneradoEvent  event){}

}
