package ar.com.cristal.creditos.client.service;

import java.util.List;

import ar.com.cristal.creditos.client.accesibilidad.ComponenteDePantallaDto;
import ar.com.cristal.creditos.client.accesibilidad.PerfilesDto;
import ar.com.cristal.creditos.client.dto.EstablecimientoDTO;
import ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO;
import ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("usuarioService")
public interface UsuarioRPCService extends RemoteService {

	UsuarioLogueadoDTO obtenerUsuarioLogueado() throws Exception;
	List<PerfilesDto> obtenerPerfiles() throws Exception;;
	void borrarPerfil(int id);
	PerfilesDto guardarPerfil(PerfilesDto p) throws Exception;
	

	UsuarioDTO obtenerUsario(Long id);

	
	UsuarioDTO persistirUsuario(UsuarioDTO usuarioActual) throws Exception;

	List<UsuarioDTO> obtenerUsarios();
	
	boolean validarNombreUsuario(UsuarioDTO usuarioActual) throws Exception;
	
	void borrarUsuario(Long id);

	List<ComponenteDePantallaDto> obtenerComponentes()  throws Exception;
	
	boolean tienePermisoAcceso(String componente) throws Exception;
	List<UsuarioDTO> obtenerListadoOperadoresCallCenter();
	String obtenerComponente(String gestionCausasLegalesEscritura);
	List<UsuarioDTO> obtenerUsariosComercializadores();
	
	public Boolean cambiarPasswordUsuario(String password,String nuevaPassword,String nuevaPassword2);
	List<UsuarioDTO> obtenerListadoOperadoresMoraTardia();
	boolean tienePermisoAprobacionFinanciacionDirecta() throws Exception;
	
	boolean tienePermisoAltaReparticion() throws Exception;
	UsuarioDTO obtenerUsuarioPorNombreUsuario(String nombreUsuario) throws Exception;
	
	/***
	 * Devuelve todos los usuarios de johnny con la opción de incluir los borrados
	 * @param incluirBorrados
	 * @return
	 */
	List<UsuarioDTO> obtenerUsuarios(boolean incluirBorrados);
	List<EstablecimientoDTO> obtenerEstablecimientosUsuarioLogueadoRPC();
	EstablecimientoDTO obtenerEstablecimientoRPC(Long id);
	void setearEstablecimientoXUsuarioRPC(long usuarioId,
			long establecimientoId);

}
