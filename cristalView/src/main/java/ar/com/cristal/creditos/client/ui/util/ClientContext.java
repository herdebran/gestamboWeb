package ar.com.cristal.creditos.client.ui.util;

import java.io.Serializable;
import java.util.HashMap;

import ar.com.cristal.creditos.client.dto.EstablecimientoDTO;
import ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO;


/**
 * 
 * @author daniel.madera
 *
 */
@SuppressWarnings("serial")
public class ClientContext implements Serializable {

	/***
	 * Se deja siempre en false para que no sugiera el cambio de sucursal
	 * El día que cambien de opinion bastará con setear esta variable en true
	 */
	private boolean sugerirCambioSucursal = false;
	
	private boolean elegirEstablecimientoAlInicio = true;

	private static ClientContext instance;
	
	private UsuarioLogueadoDTO usuarioLogueadoDTO = new UsuarioLogueadoDTO();
	
	private HashMap<Object,Object> values = new HashMap<Object,Object>();
	
	private ClientContext() {
	}

	public static ClientContext getInstance() {
		if (instance == null) {
			instance = new ClientContext();
		}
		return instance;
	}
	
	public UsuarioLogueadoDTO getUsuarioLogueadoDTO() {
		return usuarioLogueadoDTO;
	}
	
	public void setUsuarioLogueadoDTO(UsuarioLogueadoDTO usuarioLogueadoDTO) {
		this.usuarioLogueadoDTO = usuarioLogueadoDTO;
	}
	
	public boolean isComercializador(){		
		UsuarioLogueadoDTO u = getInstance().getUsuarioLogueadoDTO();
		String nombrePerfilComer = u.getPerfil().getNombre().toUpperCase();
		return nombrePerfilComer.contains("COMERCIALIZADOR");
		
	}

	public HashMap<Object, Object> getValues() {
		return values;
	}
	
	
	public void cambioDeSucursalSugerido(){
		sugerirCambioSucursal = false;
	}

	public boolean sugerirCambioSucursal() {
		return sugerirCambioSucursal;
	}


	public boolean ElegirEstablecimientoAlInicio() {
		return elegirEstablecimientoAlInicio;
	}
}