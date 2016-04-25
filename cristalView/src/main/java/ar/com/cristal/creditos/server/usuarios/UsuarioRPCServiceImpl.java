package ar.com.cristal.creditos.server.usuarios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.log4j.Logger;
import org.dozer.MappingException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ar.com.cristal.creditos.client.accesibilidad.ComponenteDePantallaDto;
import ar.com.cristal.creditos.client.accesibilidad.PerfilesDto;
import ar.com.cristal.creditos.client.dto.EstablecimientoDTO;
import ar.com.cristal.creditos.client.dto.SucursalDTO;
import ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO;
import ar.com.cristal.creditos.client.service.UsuarioRPCService;
import ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO;
import ar.com.cristal.creditos.common.Constantes;
import ar.com.cristal.creditos.entity.login.ComponenteDePantalla;
import ar.com.cristal.creditos.entity.login.Establecimiento;
import ar.com.cristal.creditos.entity.login.Perfil;
import ar.com.cristal.creditos.entity.login.Usuario;
import ar.com.cristal.creditos.entity.sucursales.Sucursal;
import ar.com.cristal.creditos.server.util.MapperExtended;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.servicios.impl.UsuarioServiceImpl;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class UsuarioRPCServiceImpl extends RemoteServiceServlet implements
		UsuarioRPCService {
	
	private WebApplicationContext context;
	private ServiceFacade serviceFacade;
	private MapperExtended mapper;
	private UsuarioServiceImpl usuarioService;

	private Logger log = Logger.getLogger(UsuarioRPCServiceImpl.class);	
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		serviceFacade = (ServiceFacade) context.getBean("serviceFacade");
		mapper = (MapperExtended) context.getBean("dozerMapper");
		usuarioService = (UsuarioServiceImpl) context.getBean("usuarioService");
		
	}

	public UsuarioLogueadoDTO obtenerUsuarioLogueado() throws Exception {
		
		UsuarioLogueadoDTO result = null;
		try {
			Usuario u  =  usuarioService.obtenerUsuarioLogueado();
			result = mapper.map(u, UsuarioLogueadoDTO.class);
		} catch (MappingException e) {
			log.error(e.getMessage(), e);
			throw new Exception("Sesión no válida");		
		} catch (Exception e) {
			log.error("Error en logueo de usuario: " + e.getMessage(), e);
			throw new Exception("Sesión no válida");
		}
            
		
		return result;
	}

	
	
	
	/**
	 * obtiene la lista completa de perfiles.
	 */
	public List<PerfilesDto> obtenerPerfiles() throws Exception {
		try{
				List<Perfil> ps =usuarioService.obtenerPerfiles();
				List<PerfilesDto> perfilesDto = new ArrayList<PerfilesDto>();
				
				for(Perfil p : (List<Perfil>)ps){
					perfilesDto.add(mapper.map(p, PerfilesDto.class));
				}
				return perfilesDto;
	} catch (Exception e) {
		log.error("Error al obtener obtenerPerfiles: " + e.getMessage(), e);
		throw new Exception("Se produjo un error al obtener los perfiles del usuario logueado");
	}
	}

	public void borrarPerfil(int id) {		
		try {
			log.info("borarndo perfil...");
			this.usuarioService.borrarPerfil(id);
		} catch (Exception e) {
			log.error("borrarPerfil : " + e.getMessage(), e);
			
		}

		log.info("borrarPerfil: servicio ok, datos borrados");
	
	}

	public PerfilesDto guardarPerfil(PerfilesDto pdto) throws Exception {
		
		try {
			log.info("guardar  perfil...");
			Perfil p = mapper.map(pdto, Perfil.class);
			if(p.getId() != null && p.getId() == 0 ) p.setId(null);
			this.usuarioService.guardarPerfil(p);
			
			PerfilesDto perfil = mapper.map(p, PerfilesDto.class);
			return perfil;
		} catch (Exception e) {
			log.error("guardarPerfil : " + e.getMessage(), e);
			throw new Exception("Se produjo un error al guardar el perfil");
		}	
		
	}

	
	

	public List<UsuarioDTO> obtenerUsarios() {
		log.info("obtenerUsuarios()");
		return obtenerUsuarios(false);
	}

	@Override
	public List<UsuarioDTO> obtenerUsuarios(boolean incluirBorrados) {
		log.info("obtenerUsuarios(incluirBorrados): " + incluirBorrados);
		List<Usuario> usuarios = serviceFacade.getUsuarioService().obtenerUsuarios(incluirBorrados);
		
		List<UsuarioDTO> result = new ArrayList<UsuarioDTO>();
		
		if (usuarios != null && !usuarios.isEmpty()){
			result = mapper.convertList(usuarios, UsuarioDTO.class);
		}
		return result;
	}
	
	
	
	public UsuarioDTO obtenerUsario(Long id) {
		
		Usuario u = serviceFacade.obtenerUsuario(id);
		UsuarioDTO result = null;
		
		if (u != null) result = mapper.map(u, UsuarioDTO.class);
		
		return result;
	}

	public UsuarioDTO persistirUsuario(UsuarioDTO usuarioActual) throws Exception {
		UsuarioDTO result = null;
		
		Usuario u = mapper.map(usuarioActual, Usuario.class);
		
		try {
			serviceFacade.persistirUsuario(u);
			result = mapper.map(u, UsuarioDTO.class);
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado()  + " - persistirUsuario() " + e.getMessage(), e);
			throw new Exception("Se produjo un error al intentar guardar los datos del usuario");
		}
		
		return result;
	}



	public boolean validarNombreUsuario(UsuarioDTO usuarioActual) throws Exception {
		try {
			Usuario u = serviceFacade.obtenerUsuarioPorNombreUsuario(usuarioActual.getNombreUsuario());
			boolean result = false;
			if (u == null) { 
				result = true;
			} else {
				if (u.getId().equals(usuarioActual.getId()))
					result = true; //en este caso estoy comparando con el mismo usuario por eso se puede devolver como válido
				else
					result = false;
				
			}
			
			return result;
		} catch (Exception e) {
			log.error("Error al validar nombre de usuario", e);
			throw new Exception("Error al validar nombre de usuario");
		}
	}
	
	
	
	/**
	 * Llama al servicio que obtiene todos los componentes
	 * Retorna una lista de List<ComponenteDePantallaDto>
	 */
	public List<ComponenteDePantallaDto> obtenerComponentes() throws Exception  {
		
		List<ComponenteDePantallaDto> componentes = new ArrayList<ComponenteDePantallaDto>();
		try{
				List<ComponenteDePantalla> comps = usuarioService.obtenerComponentes();
				for(ComponenteDePantalla c : (List<ComponenteDePantalla>)comps){
						componentes.add(mapper.map(c, ComponenteDePantallaDto.class));
				}
			}
			catch(Exception e){
				log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - obtenerComponentes: " + e.getMessage(), e);
				throw new Exception("Se produjo un error al obtener los componentes.");
			}
			return componentes;
			}
		

	

	public void borrarUsuario(Long id) {
		serviceFacade.eliminarUsuario(id);
		
	}

	public boolean tienePermisoAcceso(String componente) throws Exception {
		long tiempo = new Date().getTime();
		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - Inicio tiene permiso");
		UsuarioLogueadoDTO u = obtenerUsuarioLogueado();
		
		boolean tienePermisos = false;
		if (u == null)
			return false;
		else {
			
			if (u.getPerfil() == null || u.getPerfil().getListaComponentes() == null
					|| u.getPerfil().getListaComponentes().isEmpty()) {
			
					return false;
					
			} else {
					String componentesCsv = u.getPerfil().getListaComponentes();
					
					String[] componentes = componentesCsv.split(",");
					int i = 0;
					String componenteID = usuarioService.obtenerComponenteID(componente);
							
					if (componenteID == null){
						log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - No existe el componente, revisar nombre del componente dado.");
						return false;
					}
					else 
					{
						
						while (!tienePermisos  && i < componentes.length) {
							if (componentes[i].trim().equals(componenteID)){
								tienePermisos = true;
								break;
							}
							i++;
						}
						log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - Tiene Permisos para " + componente +" id: " + componenteID + " - " + tienePermisos + " tiempo [ms]: " + (new Date().getTime() - tiempo));
						return tienePermisos;
					}
			}
		}		
	}

	@SuppressWarnings("unchecked")
	public List<UsuarioDTO> obtenerListadoOperadoresCallCenter() {
		List<Usuario> usuarios = null;
//		final String perfilesCallCenter = Constantes.PERFILES_CALLCENTER;
		usuarios = (List<Usuario>) CollectionUtils.select(usuarioService.obtenerUsuarios(false), new Predicate() {
			
			public boolean evaluate(Object u) {
				Usuario usuario = (Usuario) u;
				return usuario.getPerfil().getNombre().toUpperCase().contains(Constantes.CALLCENTER);
			}
		});
		
		
		List<UsuarioDTO> result = mapper.convertList(usuarios, UsuarioDTO.class);
				
		return result;
	}

	public String obtenerComponente(String idComponente) {
			return	usuarioService.obtenerComponenteID(idComponente);
		
	}

	public List<UsuarioDTO> obtenerUsariosComercializadores() {
		return mapper.convertList(usuarioService.obtenerUsuariosComercializadores(), UsuarioDTO.class);
		
	}

	@Override
	public Boolean cambiarPasswordUsuario(String password,	String nuevaPassword, String nuevaPassword2) {
		try {
			boolean cambioCorrecto = usuarioService.cambiarPasswordUsuario(password, nuevaPassword);
			return cambioCorrecto;
		} catch (Exception e) {
			log.error("Error cambio de password",e);
			return false;
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioDTO> obtenerListadoOperadoresMoraTardia() {
		List<Usuario> usuarios = null;
		usuarios = (List<Usuario>) CollectionUtils.select(usuarioService.obtenerUsuarios(false), new Predicate() {
			
			public boolean evaluate(Object u) {
				Usuario usuario = (Usuario) u;
				return usuario.getPerfil().getNombre().toUpperCase().contains(Constantes.MORA_TARDIA);
			}
		});
		
		
		List<UsuarioDTO> result = mapper.convertList(usuarios, UsuarioDTO.class);
				
		return result;
	}

	@Override
	public boolean tienePermisoAprobacionFinanciacionDirecta() throws Exception{
		try {
			String aprobacionDirecta = serviceFacade.getProperty(Constantes.USUARIOS_FINANCIACION_APROBACION_DIRECTA);
			return usuarioService.existeUsuarioEnListaString(aprobacionDirecta);
		} catch (Exception e) {
			log.error(e);
			throw new Exception("Se produjo un error al intentar determinar los permisos de financiación");
		}
		
	}
	
	@Override
	public boolean tienePermisoAltaReparticion() throws Exception{
		try {
			return serviceFacade.getUsuarioService().tienePermisoAltaReparticion();
		} catch (Exception e) {
			log.error(e);
			throw new Exception("Se produjo un error al intentar determinar los permisos de financiación");
		}
		
	}

	@Override
	public UsuarioDTO obtenerUsuarioPorNombreUsuario(String nombreUsuario) throws Exception {
		UsuarioDTO result = null;
		try {
			Usuario u  =  usuarioService.obtenerUsuarioPorNombreUsuario(nombreUsuario);
			if (u != null)
				result = mapper.map(u, UsuarioDTO.class);
			else
			{
				result = new UsuarioDTO();
				result.setId(-1L);
				result.setPerfil(new PerfilesDto());
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new Exception("Erro al obtener usuario por nombre de usuario");
		}
            
		
		return result;
	}

	/**
	 * Devuelve la lista de Establecimientos del Usuario Logueado.
	 * @return
	 */
	@Override
	public List<EstablecimientoDTO> obtenerEstablecimientosUsuarioLogueadoRPC () {
		return mapper.convertList(serviceFacade.getUsuarioService().obtenerEstablecimientosUsuarioLogueado(),EstablecimientoDTO.class);
	}
	
	@Override
	public EstablecimientoDTO obtenerEstablecimientoRPC(Long id) {
		
		Establecimiento e = usuarioService.obtenerEstablecimiento(id);
		EstablecimientoDTO result = null;
		
		if (e != null) result = mapper.map(e, EstablecimientoDTO.class);
		
		return result;
	}
	
	@Override
	public void setearEstablecimientoXUsuarioRPC (long usuarioId,long establecimientoId){
		usuarioService.setearEstablecimientoXUsuario(usuarioId, establecimientoId);
	}

}
	
	




