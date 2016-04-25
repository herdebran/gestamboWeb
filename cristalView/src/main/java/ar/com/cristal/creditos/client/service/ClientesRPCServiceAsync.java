package ar.com.cristal.creditos.client.service;

import java.util.List;

import ar.com.cristal.creditos.client.dto.ClienteDTO;
import ar.com.cristal.creditos.client.dto.DatoAnexoDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ClientesRPCServiceAsync {

	void obtenerClientesByParam(String param, AsyncCallback<List<ClienteDTO>> callback);

	void obtenerClienteById(Long id, AsyncCallback<ClienteDTO> callback);
	
	void poseeMasDeUnCreditoActivo(Long idCliente,AsyncCallback<Boolean> callback);

	void crearCliente(ClienteDTO cliente, AsyncCallback<Void> callback);

	void eliminarCliente(ClienteDTO cliente, AsyncCallback<Void> callback);

//	void modificarCliente(ClienteDTO cliente, AsyncCallback<Void> callback);

	void obtenerClientes(boolean activo,
			AsyncCallback<List<ClienteDTO>> asyncCallback);

	void persistir(ClienteDTO clienteActual, AsyncCallback<ClienteDTO> asyncCallback);
	
	void modificar(ClienteDTO clienteActual, AsyncCallback<ClienteDTO> asyncCallback);

	void existeCliente(ClienteDTO clienteActual,
			AsyncCallback<Boolean> asyncCallback);

	void obtenerTiposDocs(AsyncCallback<List<String>> asyncCallback);

	void obtenerClientesByDNICuil(String dni, String cuil,
			AsyncCallback<List<ClienteDTO>> callback);

	void obtenerCreditosPorFinalizar(Long idCliente,
			AsyncCallback<List<Long>> asyncCallback);
	
	void obtenerCondicionMorosidad(Long id, AsyncCallback<String> asyncCallback);




}