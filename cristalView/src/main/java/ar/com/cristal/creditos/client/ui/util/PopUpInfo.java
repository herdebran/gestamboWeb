package ar.com.cristal.creditos.client.ui.util;

import java.util.List;

import com.google.gwt.core.client.GWT;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.ui.home.HomePlace;
import ar.com.cristal.creditos.client.widget.LinkInfoPopupDTO;
import ar.com.cristal.creditos.client.widget.PopUpInfoActivity;
import ar.com.cristal.creditos.client.widget.PopUpInfoPlace;


/***
 * Dibuja un popup para mostrar información.
 * 
 * @author daniel.madera
 *
 */
public class PopUpInfo {

	private ClientFactory clientFactory = null;
	
	
	public PopUpInfo(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		
	}
	
	
	
	public void mostrarMensaje(String titulo, String informacion){
		informacion = validarMensaje(informacion);
		
		if (informacion != null){
		
			new PopUpInfoActivity(new PopUpInfoPlace(titulo), clientFactory).start(null,clientFactory.getEventBus());
			clientFactory.getPopUpInfoView().setTitulo(titulo);
	    	clientFactory.getPopUpInfoView().setInformacion(informacion);
	    	clientFactory.getPopUpInfoView().center();    	
	    	
		} else 
			com.google.gwt.user.client.Window.open(GWT.getModuleBaseURL()+"../j_spring_security_logout", "_self", "");
    		
    	
    	
	}
	
	
	private String validarMensaje(String informacion) {
		informacion = informacion == null ? "Se produjo un error al intentar realizar la operación" : informacion;
		if (informacion.trim().equalsIgnoreCase("0") || informacion.contains("<html>")){
    		clientFactory.getPlaceController().goTo(new HomePlace(""));		
    		return null;
    		
		}
		return informacion;
	}



	public void mostrarMensaje(String informacion){
		
		
		informacion = validarMensaje(informacion);
		if (informacion != null){
			new PopUpInfoActivity(new PopUpInfoPlace("Informacion"), clientFactory).start(null,clientFactory.getEventBus());
			clientFactory.getPopUpInfoView().setTitulo("Información");
	    	clientFactory.getPopUpInfoView().setInformacion(informacion);
	    	clientFactory.getPopUpInfoView().center();
		} else 
			com.google.gwt.user.client.Window.open(GWT.getModuleBaseURL()+"../j_spring_security_logout", "_self", "");
		 
    	
	}
	
	public void mostrarMensaje(List<String> informacion){		

    	new PopUpInfoActivity(new PopUpInfoPlace("Informacion"), clientFactory).start(null,clientFactory.getEventBus());
    	clientFactory.getPopUpInfoView().setTitulo("Información");
    	clientFactory.getPopUpInfoView().setInformacion(informacion);
    	clientFactory.getPopUpInfoView().center();
	}
	
	public void mostrarMensaje(String titulo, List<String> informacion){    	
    	new PopUpInfoActivity(new PopUpInfoPlace(titulo), clientFactory).start(null,clientFactory.getEventBus());
    	clientFactory.getPopUpInfoView().setInformacion(titulo, informacion);
    	clientFactory.getPopUpInfoView().center();
	}

	public void mostrarMensajeYListaDeLinks(String titulo, List<LinkInfoPopupDTO> informacion){    	
    	new PopUpInfoActivity(new PopUpInfoPlace(titulo), clientFactory).start(null,clientFactory.getEventBus());
    	clientFactory.getPopUpInfoView().setInformacionListadaConLink(titulo, informacion);
    	clientFactory.getPopUpInfoView().center();
	}

	public void ocultar() {
		clientFactory.getPopUpInfoView().hide();
		
	}



	public void mostrarMensajeError(String info) {
		mostrarMensaje("Error", info);
	}

	public void mostrarMensajeError(List<String> info) {
		mostrarMensaje("Error", info);
	}




}
