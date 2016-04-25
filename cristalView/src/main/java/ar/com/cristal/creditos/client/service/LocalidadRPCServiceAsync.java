package ar.com.cristal.creditos.client.service;

import java.util.List;

import ar.com.cristal.creditos.client.localidad.LocalidadDTO;
import ar.com.cristal.creditos.client.localidad.ProvinciaDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LocalidadRPCServiceAsync {

	void obtenerLocalidad(Long cliente_id, AsyncCallback<LocalidadDTO> callback);

	void obtenerProvincias(AsyncCallback<List<ProvinciaDTO>> callback);

	void obtenerLocalidades(AsyncCallback<List<LocalidadDTO>> callback);

}
