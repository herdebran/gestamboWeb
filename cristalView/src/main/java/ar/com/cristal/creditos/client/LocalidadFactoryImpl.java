package ar.com.cristal.creditos.client;

import ar.com.cristal.creditos.client.service.LocalidadRPCService;
import ar.com.cristal.creditos.client.service.LocalidadRPCServiceAsync;

import com.google.gwt.core.client.GWT;

public class LocalidadFactoryImpl implements LocalidadFactory{
	private LocalidadRPCServiceAsync localidadService;
	
private static LocalidadFactoryImpl instance = null; 
	
	public static final LocalidadFactoryImpl getClientFactoryImpl(){
		if (instance == null) instance = GWT.create(LocalidadFactoryImpl.class);
		return instance;
	}
	
	public LocalidadRPCServiceAsync getLocalidadService() {
	if(localidadService == null) localidadService = GWT.create(LocalidadRPCService.class);
		return localidadService;
	}
	
}
