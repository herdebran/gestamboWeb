package ar.com.cristal.creditos.server.event;

import org.apache.log4j.Logger;

import ar.com.cristal.creditos.client.service.event.DefaultRemoteEventService;
import ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent;
import ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent;
import de.novanic.eventservice.client.event.Event;
import de.novanic.eventservice.client.event.domain.Domain;
import de.novanic.eventservice.client.event.domain.DomainFactory;
import de.novanic.eventservice.service.RemoteEventServiceServlet;

public class DefaultRemoteEventServiceImpl extends RemoteEventServiceServlet implements DefaultRemoteEventService {

	private Logger log = Logger.getLogger(DefaultRemoteEventServiceImpl.class);

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	* The Domain that this Service sends Events to.
	*/
	private static final Domain DOMAIN = DomainFactory.getDomain("documentoGenerado");
	
	
	/**
	 * A normal function that gets called when a client sends a message to the server.
	 */
	public void enviarMensaje(String message) {
		/**
		 * We dont save the incomming messages on the server. We just send an MyEvent to all
		 * registered Listeners on the Domain.
		 */
		
		
		log.info("Envía mensaje de evento producido: Evento - dominio: " + DOMAIN.getName());
		this.addEvent(DOMAIN, new DocumentoGeneradoEvent(message));		
	}

	
	
	/**
	 * A normal function that gets called when a client sends a message to the server.
	 */
	public void enviarMensaje(String dominio, String message) {
		/**
		 * We dont save the incomming messages on the server. We just send an MyEvent to all
		 * registered Listeners on the Domain.
		 */
		
		Domain domain = DomainFactory.getDomain(dominio);
		
		log.info("Envía mensaje de evento producido: Evento - dominio: " + domain.getName());
		this.addEvent(domain, new AprobacionRechazoEvent(message));
	}
	
	
	
	/***
	 * Mensaje genérico para cualquier tipo de evento y dominio.
	 */
	public void enviarMensaje(String dominio, Event evento) {
		/**
		 * We dont save the incomming messages on the server. We just send an MyEvent to all
		 * registered Listeners on the Domain.
		 */
		
			Domain domain = DomainFactory.getDomain(dominio);
			
			log.info("Envía mensaje de evento producido: Evento - dominio: " + domain.getName() + " - Evento: " + evento.toString());		
			this.addEvent(domain, evento);
		
	}
	
	
	
	
	
}
