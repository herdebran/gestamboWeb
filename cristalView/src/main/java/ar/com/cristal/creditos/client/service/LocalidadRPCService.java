package ar.com.cristal.creditos.client.service;

import java.util.List;

import ar.com.cristal.creditos.client.localidad.LocalidadDTO;
import ar.com.cristal.creditos.client.localidad.ProvinciaDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("localidadService")
public interface LocalidadRPCService extends RemoteService {
	
	public LocalidadDTO obtenerLocalidad(Long cliente_id);
	
	public List<ProvinciaDTO> obtenerProvincias();
	
	public List<LocalidadDTO> obtenerLocalidades();
}
