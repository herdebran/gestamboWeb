package ar.com.cristal.creditos.client.ui.util;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;

public class OperacionesDocumentos {

	public static String autocompletarCuit(KeyUpEvent keyup, String cuilParcial){
		if (keyup.getNativeKeyCode() != KeyCodes.KEY_BACKSPACE)
			if (cuilParcial.length() == 2 || cuilParcial.length() == 11){
				cuilParcial = cuilParcial + "-";
			}
		
		return cuilParcial;
	}
	
	
	/***
	 * Compara el valor del cuil. Se espera el siguiente formato de cuil xx-xxxxxxxx-x
	 * @param cuil
	 * @param documento
	 * @return
	 */
	public static boolean validarCuilDocumento(String cuil, String documento){
		boolean result = false;
		String[] cuilPartes = cuil.split("-");
		
		if (cuilPartes.length == 3){
			String documentoCuil = cuilPartes[1].replaceAll("-", "");
			result = documentoCuil.equals(documento);
		}
		
		return result;
	}
}
