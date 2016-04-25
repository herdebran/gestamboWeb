package ar.com.cristal.creditos.client.ui.usuarios.pass;


import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.ui.home.HomePlace;
import ar.com.cristal.creditos.client.ui.util.CustomAbstractActivity;
import ar.com.cristal.creditos.client.ui.util.MD5;
import ar.com.cristal.creditos.client.ui.util.PopUpInfo;
import ar.com.cristal.creditos.client.widget.CustomSiNoDialogBox;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DialogBox;

public class CambioPasswordUsuarioActivity extends CustomAbstractActivity implements CambioPasswordUsuarioView.Presenter {

	private static final String ID_COMPONENTE_ACTIVITY = "";
	private ClientFactory clientFactory;
	private CambioPasswordUsuarioView view;
	private PopUpInfo popUpInfo;
	
	public CambioPasswordUsuarioActivity(CambioPasswordUsuarioPlace place,ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		view = clientFactory.getCambioPasswordUsuarioView();
		popUpInfo = clientFactory.getPopUp();
	}
	
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		super.start(containerWidget, eventBus, ID_COMPONENTE_ACTIVITY);
		containerWidget.setWidget(view.asWidget());
		Log.debug("HostPageURL: " + GWT.getHostPageBaseURL());
		Log.debug("Module Base: " + GWT.getModuleBaseURL());
		Log.debug("ModulName: " + GWT.getModuleName());
		view.setPresenter(this);
	}

	@Override
	public void inicializarActivity() {
		view.clean();
	}

	@Override
	public void guardar() {
		if (validar()){
			confirmarCambio();			
		}
		
	}
	
	private void cambiarClave(){
		String pass = MD5.md5(view.getPassword());
		String nuevaPass = MD5.md5(view.getNuevaPassword());
		String nuevaPass2 = MD5.md5(view.getConfirmacionNuevaPassword());
		
		

		clientFactory.getUsuarioService().cambiarPasswordUsuario(pass,nuevaPass, nuevaPass2, new AsyncCallback<Boolean>() {
			@Override
			public void onFailure(Throwable arg0) {
				popUpInfo.mostrarMensaje("Error: ", arg0.getMessage());
				
				
			}

			@Override
			public void onSuccess(Boolean cambioCorrecto) {
				if (cambioCorrecto){
					//popUpInfo.mostrarMensaje("Se cambio Correctamente la clave. Debe volver ingresar al sistema");
					com.google.gwt.user.client.Window.open(clientFactory.getURLBase() + "../j_spring_security_logout", "_self", "");
				}
				else{
					popUpInfo.mostrarMensaje("La Clave Ingresada en Incorrecta");
				}
			}
		
		});
	}

	private void confirmarCambio() {
		
		final DialogBox dialogbox = CustomSiNoDialogBox.dialogBox("Información", "Luego de cambiar la clave <br /> debera volver ingresar al sistema,<br /> esta seguro?");
			ClickHandler listenerNo = new ClickHandler() {
				public void onClick(ClickEvent arg0) {
					dialogbox.hide();
				}
			};
			ClickHandler listenerSi = new ClickHandler() {
				public void onClick(ClickEvent arg0) {
					dialogbox.hide();
					cambiarClave();
				}
			};
			CustomSiNoDialogBox.setHandlers(listenerSi, listenerNo);
		
	}

	
	private boolean validar(){
		boolean ok =  view.getPassword() != null && view.getNuevaPassword()!=null && view.getConfirmacionNuevaPassword()!=null;
		if (ok){
			//Debe contener minomo 4 caracteres
			if (view.getNuevaPassword().length()<4){
				popUpInfo.mostrarMensaje("La contraseña debe contener como mínimo 4 caracteres.");
				return false;
			}
			
			//Las claves deben coincidir
			if (!view.getNuevaPassword().equals(view.getConfirmacionNuevaPassword())){
				popUpInfo.mostrarMensaje("Las contraseñas no coinciden.");
				return false;
			}
		}
		else{
			//Debe Ingresar todos los datos
			popUpInfo.mostrarMensaje("Debe completar todos los campos");
		}
		return ok;
	}
	@Override
	public void volver() {
		Place place = new HomePlace("");
		clientFactory.getPlaceController().goTo(place);
		
	}

}
