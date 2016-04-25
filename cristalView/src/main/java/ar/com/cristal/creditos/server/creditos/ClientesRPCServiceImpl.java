package ar.com.cristal.creditos.server.creditos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.dozer.MappingException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ar.com.cristal.creditos.client.dto.ClienteDTO;
import ar.com.cristal.creditos.client.dto.DatoAnexoDTO;
import ar.com.cristal.creditos.client.service.ClientesRPCService;
import ar.com.cristal.creditos.common.TipoDocAnexoEnum;
import ar.com.cristal.creditos.entity.cliente.DatoAnexo;
import ar.com.cristal.creditos.entity.creditos.Cliente;
import ar.com.cristal.creditos.entity.login.Usuario;
import ar.com.cristal.creditos.server.util.MapperExtended;
import ar.com.cristal.creditos.servicios.CreditosService;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.servicios.impl.ClienteService;
import ar.com.cristal.creditos.servicios.impl.UsuarioServiceImpl;
import de.novanic.eventservice.service.RemoteEventServiceServlet;

@SuppressWarnings("serial")
public class ClientesRPCServiceImpl extends RemoteEventServiceServlet implements ClientesRPCService{
	
	private WebApplicationContext context;
	private ClienteService clienteService;
	private UsuarioServiceImpl  usuarioService;
	private MapperExtended mapper;
	private CreditosService creditosService;

	private ServiceFacade serviceFacade;
	
	private Logger log = Logger.getLogger(ClientesRPCServiceImpl.class);	
	
	@Override
	public void init() throws ServletException {
		super.init();
		context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		clienteService = (ClienteService) context.getBean("clienteService");
		usuarioService = (UsuarioServiceImpl) context.getBean("usuarioService");
		creditosService = (CreditosService) context.getBean("creditosService");
		serviceFacade = (ServiceFacade) context.getBean("serviceFacade");
		mapper = (MapperExtended) context.getBean("dozerMapper");
	}

	public List<ClienteDTO> obtenerClientesByParam(String param) throws Exception {
		try {
			long tiempo = new Date().getTime(); 
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " inicio ");
			List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
			List<Cliente> busqueda= clienteService.obtenerClientesByParam(param);
			for (Cliente cli : busqueda){
				ClienteDTO c = new ClienteDTO();
				c.setId(cli.getId());
				c.setNombre(cli.getNombre());
				c.setApellido(cli.getApellido());
				c.setTelefono(cli.getTelefono());
				c.setCaracteristica(cli.getCaracteristica());
				c.setTelefono(cli.getTelefono1());
				c.setCaracteristica(cli.getCaracteristica1());
				c.setDni(cli.getDni());
				c.setEstado(cli.getEstado().name());
				c.setNroCuenta(cli.getNroCuenta());
				c.setCondicionMorosidad(cli.getCondicionMorosidad());
				clientes.add(c);
				
			}
			
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Tiempo de búsqueda y conversión de clientes a DTO [ms] : " + (new Date().getTime() - tiempo) + ". Cantidad de resultados: " + clientes.size());
			
			return clientes;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - Se produjo un error al obtener los clientes." + e.getMessage(), e);
			throw new Exception("Se produjo un error al obtener los clientes.");
		}
	}

	public ClienteDTO obtenerClienteById(Long id) throws Exception {
		try {
			Cliente c = clienteService.obtenerClienteById(id);
			
			ClienteDTO result = null;
			if (c != null)
				result = mapper.map(c, ClienteDTO.class);
			
			return result;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - obtenerClienteById(): " + id,e);
			throw new Exception("Se produjo un error al intentar obtener los datos del cliente nro: " + id);
		}
	}

	
	public Boolean poseeMasDeUnCreditoActivo(Long idCliente){
		return clienteService.poseeMasDeUnCreditoActivo(idCliente);
	}
	
	public void crearCliente(ClienteDTO cliente) throws MappingException, Exception{
		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - Crear Cliente");
		clienteService.crearCliente(mapper.map(cliente, Cliente.class));
	}
	
	public void eliminarCliente(ClienteDTO cliente) throws MappingException, Exception{
		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - Eliminar Cliente");
		clienteService.eliminarCliente(mapper.map(cliente, Cliente.class));
	}
	
//	public void modificarCliente(ClienteDTO cliente) throws MappingException, Exception{
//		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - Modificar Cliente");
//		clienteService.modificarCliente(mapper.map(cliente, Cliente.class));
//	}

	public List<ClienteDTO> obtenerClientes(boolean activo) {
		List<Cliente> clientes = clienteService.obtenerClientes();
		List<ClienteDTO> result = mapper.convertList(clientes, ClienteDTO.class);
		return  result;
	}

	public ClienteDTO persistir(ClienteDTO clienteActual) throws Exception {
		try {
			
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - Crear Cliente");
			
			Cliente c = mapper.map(clienteActual, Cliente.class);
			
			clienteService.crearCliente(c);
			
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - Fin Crear Cliente");
			
			return mapper.map(c, ClienteDTO.class);
			
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - persistir()", e);
			throw new Exception("Error al intentar guardar el cliente");
		}
		
		
	}

	public boolean existeCliente(ClienteDTO clienteActual) {
		Cliente c = mapper.map(clienteActual, Cliente.class);
		return clienteService.clienteExiste(c);
	}

	public ClienteDTO modificar(ClienteDTO clienteActual) throws Exception {
		try {
			
			Usuario u = usuarioService.obtenerUsuarioLogueado();
		
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - Modifica Cliente");
			
			clienteActual.setNombreUsuario(u.getNombreUsuario());
			clienteActual.setFechaModificacion(new Date());
			
			Cliente c = mapper.map(clienteActual, Cliente.class);
			Cliente clienteAnterior = clienteService.obtenerClienteById(c.getId());
			
			
			clienteService.modificarCliente(c);
			
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - Fin Modifica Cliente");

			
			return mapper.map(c, ClienteDTO.class);
			
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - Modificar", e);
			throw new Exception("Error al modificar cliente");
		}
		
	}




	public List<String> obtenerTiposDocs() {
		List<String> result = new ArrayList<String>();
		
		TipoDocAnexoEnum allValues[] = TipoDocAnexoEnum.values(); 
	    for(TipoDocAnexoEnum a : allValues) result.add(a.toString());
	    
	    return result;
	}

	public DatoAnexoDTO obtenerDocAnexoById(String idSeleccionado) {
		DatoAnexo doc = clienteService.obtenerAnexoById(idSeleccionado);
		DatoAnexoDTO result = mapper.map(doc,DatoAnexoDTO.class);
		//result.setFile(getDocData(doc.getFileContent(),result.getMimeType()));
		if (result.getUsuarioId() != null)
			result.setNombreUsuario(serviceFacade.obtenerUsuario(result.getUsuarioId()).getNombreUsuario());
	
		return result;
	}
	
	public String getDocData(byte[] imageByteArray, String mimeType){
		String base64 = com.google.gwt.user.server.Base64Utils.toBase64(imageByteArray);
		base64 = "data:"+mimeType+";base64,"+base64; 
		return base64;
	}


	@Override
	public List<ClienteDTO> obtenerClientesByDNICuil(String dni, String cuil) throws Exception {
		try {
			List<Cliente> clientes = clienteService.obtenerClientes(dni, cuil);
			return mapper.convertList(clientes, ClienteDTO.class);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Long> obtenerCreditosPorFinalizar(Long idCliente) throws Exception{
		try {
			return clienteService.creditosPorFinalizar(idCliente);
		} catch (Exception e) {
			log.error(e);
			throw new Exception("Se produjo un error al intentar obtener información acerca si el cliente está por finalizar un crédito");
		}
	}


	@Override
	public String obtenerCondicionMorosidad(Long id) throws Exception {
		try {
			Cliente c = serviceFacade.getClienteService().obtenerClienteById(id);
			return c.getCondicionMorosidad();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception("Se produjo un error al intentar obtener la condición de morosidad del cliente: " + id);
		}
	}	

}