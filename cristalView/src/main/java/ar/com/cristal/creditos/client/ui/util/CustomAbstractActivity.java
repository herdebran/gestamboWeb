package ar.com.cristal.creditos.client.ui.util;

import java.util.Date;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.ClientFactoryImpl;
import ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Widget;

public abstract class CustomAbstractActivity extends AbstractActivity {
	
	private PopUpInfo popup = null;
	private DialogBox dialogBoxstartInPopUp =null;
	
	final ClientContext clientContext = ClientContext.getInstance();
	final ClientFactory clientFactory = ClientFactoryImpl.getClientFactoryImpl();
	

	public void start(AcceptsOneWidget containerWidget, EventBus eventBus, final String componente){
		
		
		
		Log.debug("Inicialización genérica");
		
		
		final long tiempoInicializacion = new Date().getTime(); 
		
		if (popup == null)
			popup = new PopUpInfo(clientFactory);
		
		
		
		if (!componente.equals("")){
			clientFactory.getUsuarioService().obtenerUsuarioLogueado(new AsyncCallback<UsuarioLogueadoDTO>() {
	
				public void onFailure(Throwable e) {
					
					cerrarSesion();
					
				}
	
				public void onSuccess(final UsuarioLogueadoDTO u) {
					if (u == null || u.getId() <= 0){
						cerrarSesion();
					} else {
						clientContext.setUsuarioLogueadoDTO(u);		
						
						clientFactory.getUsuarioService().tienePermisoAcceso(componente, new AsyncCallback<Boolean>() {
							
							public void onSuccess(Boolean tienePermisos) {
								
								if (!tienePermisos){
									popup.mostrarMensaje("No tiene permisos de acceso.");
									Place p = clientFactory.getHomePlace();
									clientFactory.getPlaceController().goTo(p);
																	
								} else {
									Log.info(u.getNombreUsuarioSessionId() + " CustomAbstractActivity - Fin de inicializacion Ativity genérico: tiene permisos de acceso: " + (new Date().getTime() - tiempoInicializacion));
									inicializarActivity();	
								}
								
							}
							public void onFailure(Throwable e) {
								cerrarSesion();
								
							};
							
						});
						
						
						
						
					}
					
				}

			
			});
		} else {
			clientFactory.getUsuarioService().obtenerUsuarioLogueado(new AsyncCallback<UsuarioLogueadoDTO>() {

				public void onFailure(Throwable e) {
					cerrarSesion();
					
				}

				
				public void onSuccess(UsuarioLogueadoDTO u) {
					clientContext.setUsuarioLogueadoDTO(u);		
					Log.info(u.getNombreUsuarioSessionId() + " Fin de inicializacion Ativity genérico: logueo de usuario: " + (new Date().getTime() - tiempoInicializacion));
					inicializarActivity();		
				}
			});
		}
		
				
		
		
		
	}
	
	
	
	/***
	 * Da lugar a que pueda inicializar todos los controles de la vista. Es el punto de entrada de cada pantalla <br/>
	 * luego de asegurarse de que el usuario está logueado.
	 */
	public abstract void inicializarActivity();


	
	public ClientContext getClientContext(){
		return clientContext;
	}
	
	public void startInPopUp(Widget view) {
		dialogBoxstartInPopUp = new DialogBox();
		dialogBoxstartInPopUp.add(view);
		dialogBoxstartInPopUp.setModal(true);
		dialogBoxstartInPopUp.setAutoHideEnabled(false);
		dialogBoxstartInPopUp.center();
		dialogBoxstartInPopUp.show();
		inicializarActivity();		
	}
	
	public void hidePopUp(){
		if (dialogBoxstartInPopUp != null)
			dialogBoxstartInPopUp.hide();
	}
	
	
	
	public void cerrarSesion(){
		
		com.google.gwt.user.client.Window.open(clientFactory.getURLBase() + "../j_spring_security_logout", "_self", "");
		
		
		
	}


	
}
