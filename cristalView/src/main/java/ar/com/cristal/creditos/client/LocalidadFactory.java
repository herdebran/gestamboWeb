package ar.com.cristal.creditos.client;

import ar.com.cristal.creditos.client.service.LocalidadRPCServiceAsync;

public interface LocalidadFactory {
	LocalidadRPCServiceAsync getLocalidadService();
}
