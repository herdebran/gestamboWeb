package ar.com.cristal.creditos.client.ui.establecimientos;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO;
import ar.com.cristal.creditos.client.event.SelectedItemEvent;
import ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO;
import ar.com.cristal.creditos.client.ui.util.ClientContext;
import ar.com.cristal.creditos.client.ui.util.CustomAbstractActivity;
import ar.com.cristal.creditos.client.ui.util.PopUpInfo;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class SeleccionEstablecimientoActivity extends CustomAbstractActivity implements SeleccionEstablecimientoView.Presenter{

	private ClientFactory clientFactory;
	private PopUpInfo popUpInfo;
	private SeleccionEstablecimientoView view;
	private static final String COMPONENTE_ID = "ABM_SELECCION_ESTABLECIMIENTO";
	private UsuarioLogueadoDTO usuarioLogueado=null;
	
	public SeleccionEstablecimientoActivity(SeleccionEstablecimientoPlace place,ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		popUpInfo = clientFactory.getPopUp();
	}
	
	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus) {
		super.start(container, eventBus, COMPONENTE_ID);
		view = clientFactory.getSeleccionEstablecimientoView();
		container.setWidget(view.asWidget());
	}

	@Override
	public void inicializarActivity() {
		view.setPresenter(this);
		view.inicializarCombos();
		view.showPopUp(true);
	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);	
	}




	@Override
	public void seleccionar() {
		popUpInfo.mostrarMensaje("Espere","Seleccionando establecimiento...");
		usuarioLogueado=ClientContext.getInstance().getUsuarioLogueadoDTO();
		clientFactory.getUsuarioService().setearEstablecimientoXUsuarioRPC(usuarioLogueado.getId(), Long.valueOf(view.cmbEstablecimiento.getSelectedItemId()),
				new AsyncCallback<UsuarioDTO>(){

					@Override
					public void onFailure(Throwable caught) {
						popUpInfo.mostrarMensaje("Atencion","Ocurrió algún problema seleccionando el establecimiento.");
					}

					@Override
					public void onSuccess(UsuarioDTO usuarioModificado) {
						usuarioLogueado.setEstablecimientoActual(usuarioModificado.getEstablecimientoActual());
						ClientContext.getInstance().setUsuarioLogueadoDTO(usuarioLogueado);						popUpInfo.ocultar();
						cerrar(view.cmbEstablecimiento.getSelectedItem());
						
					}

		});
	}

	@Override
	public void cerrar() {
		cerrar(null);			
	}
	
	private void cerrar(ListBoxItem item){
		hidePopUp();
		view.showPopUp(false);
		clientFactory.getEventBus().fireEvent(new SelectedItemEvent(item));
	}
	
	public void startInPopUp() {
		view = clientFactory.getSeleccionEstablecimientoView();
		view.setPresenter(this);
		startInPopUp(view);
		
		clientFactory.getUsuarioService().tienePermisoAcceso(COMPONENTE_ID, new AsyncCallback<Boolean>() {
			
			public void onSuccess(Boolean tienePermisos) {
				
				if (!tienePermisos){
					popUpInfo.mostrarMensaje("No tiene permisos de acceso.");
					cerrar();			
				}
				
			}
			public void onFailure(Throwable e) {
				cerrarSesion();
				
			};
			
		});

	}


}
