package ar.com.cristal.creditos.client.ui.establecimientos;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.dto.EstablecimientoDTO;
import ar.com.cristal.creditos.client.event.SelectedItemEvent;
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
	private EstablecimientoDTO establecimientoActualDTO = null;
	
	public SeleccionEstablecimientoActivity(SeleccionEstablecimientoPlace place,ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		popUpInfo = clientFactory.getPopUp();
	}
	
	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus) {
		super.start(container, eventBus, "ABM_LINEA_CREDITO");
		view = clientFactory.getSeleccionEstablecimientoView();
		container.setWidget(view.asWidget());
	}

	@Override
	public void inicializarActivity() {
		view.setPresenter(this);
		view.inicializarCombos();
	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);	
	}




	@Override
	public void seleccionar() {
		popUpInfo.mostrarMensaje("Espere","Seleccionando establecimiento...");
		clientFactory.getUsuarioService().setearEstablecimientoXUsuarioRPC(ClientContext.getInstance().getUsuarioLogueadoDTO().getId(), Long.valueOf(view.cmbEstablecimiento.getSelectedItemId()),
				new AsyncCallback<Void>(){

					@Override
					public void onFailure(Throwable caught) {
						popUpInfo.mostrarMensaje("Atencion","Ocurrió algún problema seleccionando el establecimiento.");
						
					}

					@Override
					public void onSuccess(Void result) {
						popUpInfo.ocultar();
						cerrar();
						
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

}
