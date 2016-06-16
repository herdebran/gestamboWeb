package ar.com.cristal.creditos.client.service;

import java.util.List;

import ar.com.cristal.creditos.client.accesibilidad.ComponenteDePantallaDto;
import ar.com.cristal.creditos.client.accesibilidad.PerfilesDto;
import ar.com.cristal.creditos.client.dto.EstablecimientoDTO;
import ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO;
import ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface UsuarioRPCServiceAsync {

	

	void obtenerPerfiles(AsyncCallback<List<PerfilesDto>> callback);

	void borrarPerfil(int id,AsyncCallback<Void> callback);
	void guardarPerfil(PerfilesDto p, AsyncCallback<PerfilesDto> asyncCallback );

	void obtenerUsario(Long id, AsyncCallback<UsuarioDTO> asyncCallback);
	
	void obtenerUsarios(AsyncCallback<List<UsuarioDTO>> asyncCallback);

	void persistirUsuario(UsuarioDTO usuarioActual,
			AsyncCallback<UsuarioDTO> asyncCallback);
	

	void obtenerComponentes(AsyncCallback<List<ComponenteDePantallaDto>> callback);

	/**
	 * Valida que no tenga duplicados el nombre de usuario
	 * @param usuarioActual
	 * @param asyncCallback
	 */
	void validarNombreUsuario(UsuarioDTO usuarioActual, AsyncCallback<Boolean> asyncCallback);

	void borrarUsuario(Long id, AsyncCallback<Void> asyncCallback);

	/***
	 * Devuelve true si el usuario logueado tiene acceso al componente dado
	 * @param componente
	 * @param asyncCallback
	 */
	void tienePermisoAcceso(String componente,AsyncCallback<Boolean> asyncCallback);

	void obtenerListadoOperadoresCallCenter(
			AsyncCallback<List<UsuarioDTO>> asyncCallback);

	void obtenerComponente(String gestionCausasLegalesEscritura,
			AsyncCallback<String> asyncCallback);

	void obtenerUsariosComercializadores(
			AsyncCallback<List<UsuarioDTO>> asyncCallback);

	void cambiarPasswordUsuario(String password, String nuevaPassword,
			String nuevaPassword2, AsyncCallback<Boolean> callback);

	void obtenerListadoOperadoresMoraTardia(
			AsyncCallback<List<UsuarioDTO>> asyncCallback);

	void tienePermisoAprobacionFinanciacionDirecta(
			AsyncCallback<Boolean> asyncCallback);

	void tienePermisoAltaReparticion(AsyncCallback<Boolean> callback);

	void obtenerUsuarioPorNombreUsuario(String nombreUsuario,
			AsyncCallback<UsuarioDTO> asyncCallback);

	void obtenerUsuarios(boolean incluirBorrados,
			AsyncCallback<List<UsuarioDTO>> callback);

	void obtenerUsuarioLogueado(AsyncCallback<UsuarioLogueadoDTO> callback);

	void obtenerEstablecimientosUsuarioLogueadoRPC(
			AsyncCallback<List<EstablecimientoDTO>> callback);

	void obtenerEstablecimientoRPC(Long id,
			AsyncCallback<EstablecimientoDTO> callback);

	void setearEstablecimientoXUsuarioRPC(long usuarioId,
			long establecimientoId, AsyncCallback<UsuarioDTO> callback);



}
