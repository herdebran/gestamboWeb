package ar.com.cristal.creditos.client.service;

import java.util.List;

import ar.com.cristal.creditos.client.dto.ClienteDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("clientesService")
public interface ClientesRPCService extends RemoteService {

	List<ClienteDTO> obtenerClientesByParam(String param) throws Exception;
	
	ClienteDTO obtenerClienteById(Long id) throws Exception;

	Boolean poseeMasDeUnCreditoActivo(Long idCliente);
	
	void crearCliente(ClienteDTO cliente) throws Exception;
	
	void eliminarCliente(ClienteDTO cliente) throws  Exception;
	
//	void modificarCliente(ClienteDTO cliente) throws Exception;


	List<ClienteDTO> obtenerClientes(boolean activo);

	ClienteDTO persistir(ClienteDTO clienteActual) throws Exception;

	boolean existeCliente(ClienteDTO clienteActual);
		
	List<String> obtenerTiposDocs();

	ClienteDTO modificar(ClienteDTO clienteActual) throws Exception;


	List<ClienteDTO> obtenerClientesByDNICuil(String dni, String cuil) throws Exception;

	/***
	 * Devuelve una lista de ids de créditos a una cuota por finalizar
	 * @param idCliente
	 * @return
	 * @throws Exception 
	 */
	List<Long> obtenerCreditosPorFinalizar(Long idCliente) throws Exception;
	
	String obtenerCondicionMorosidad(Long id) throws Exception;
	
}
