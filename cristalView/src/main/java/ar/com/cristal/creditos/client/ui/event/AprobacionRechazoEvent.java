package ar.com.cristal.creditos.client.ui.event;

import ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO;

import com.google.gwt.core.client.GWT;

import de.novanic.eventservice.client.event.Event;


/***
 * Evento para informar que existen reportes nuevo
 * @author daniel.madera
 *
 */
public class AprobacionRechazoEvent implements Event{


	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static AprobacionRechazoEvent instance;
		
		public static AprobacionRechazoEvent getInstance(){
			if (instance == null) {
				instance = GWT.create(AprobacionRechazoEvent.class);
			}
			return instance;
		}
		
		
		
	}
	
	/**
	 * 
	 */
	
	public String message;
	private String sucursalSolicitante;
	private String usuarioSolicitante;
	private String usuarioRespuesta;
	private Long idSolicitud;
	
	/***
	 * El tipo de solicitud determina si el mensaje debe ser mostrado al aprobador o al vendedor. <br/>
	 * Si es PREGUNTA debe ser visto por los aprobadores, si es RESPUESTA deberá ser visto por el vendedor que <br/>
	 * indique usuarioSolicitante
	 *  
	 * PREGUNTA | RESPUESTA
	 */
	private String tipoSolicitudPreguntaRespuesta;
	

	public AprobacionRechazoEvent(){}

	public AprobacionRechazoEvent(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSucursalSolicitante() {
		return sucursalSolicitante;
	}

	public void setSucursalSolicitante(String sucursalSolicitante) {
		this.sucursalSolicitante = sucursalSolicitante;
	}

	public String getUsuarioSolicitante() {
		return usuarioSolicitante;
	}

	public void setUsuarioSolicitante(String usuarioSolicitante) {
		this.usuarioSolicitante = usuarioSolicitante;
	}

	public String getTipoSolicitudPreguntaRespuesta() {
		return tipoSolicitudPreguntaRespuesta;
	}

	public void setTipoSolicitudPreguntaRespuesta(
			String tipoSolicitudPreguntaRespuesta) {
		this.tipoSolicitudPreguntaRespuesta = tipoSolicitudPreguntaRespuesta;
	}

	public String getUsuarioRespuesta() {
		return usuarioRespuesta;
	}

	public void setUsuarioRespuesta(String nombreUsuarioLogueado) {
		this.usuarioRespuesta = nombreUsuarioLogueado;
	}

	public Long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	
	
}
