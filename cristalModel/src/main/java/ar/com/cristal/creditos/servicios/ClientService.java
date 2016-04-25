package ar.com.cristal.creditos.servicios;

import ar.com.cristal.creditos.entity.creditos.Cliente;



public interface ClientService {

	public Cliente obtenerClienteById(Long id) throws Exception; 
	
}
