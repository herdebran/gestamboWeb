package ar.com.cristal.creditos.client.ui.util;

import ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO;
import ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent;

public class MensajeriaServerPush {

	public static boolean tratarEvento(AprobacionRechazoEvent event, UsuarioLogueadoDTO usuarioLogueado) {
		boolean result = false;
		
		//Valida que no se trate la respuesta para el mismo usuario que la está realizando
		if (event.getUsuarioRespuesta().equals(usuarioLogueado.getNombreUsuario())) 
			result = false;
		else
			
				//Valida que si no es supervisor se le informe qué sucede siempre y cuando tenga que ver con la 
				//consulta realizada por él
				if (usuarioLogueado.getNombreUsuario().equals(event.getUsuarioSolicitante())){
					result = true;
				} else {
					result = false;
				}

				
		
		return result;
	}

}
