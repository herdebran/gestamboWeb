package ar.com.cristal.creditos.client.ui.home;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO;
import ar.com.cristal.creditos.client.event.SelectedItemEvent;
import ar.com.cristal.creditos.client.handler.SelectedItemEventHandler;
import ar.com.cristal.creditos.client.ui.MenuView;
import ar.com.cristal.creditos.client.ui.establecimientos.SeleccionEstablecimientoActivity;
import ar.com.cristal.creditos.client.ui.establecimientos.SeleccionEstablecimientoPlace;
import ar.com.cristal.creditos.client.ui.util.ClientContext;
import ar.com.cristal.creditos.client.ui.util.CustomAbstractActivity;
import ar.com.cristal.creditos.client.ui.util.InicializarCombos;
import ar.com.cristal.creditos.client.ui.util.PopUpInfo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Activities are started and stopped by an ActivityManager associated with a container Widget.
 */
public class HomeActivity extends CustomAbstractActivity implements HomeView.Presenter {

	private ClientFactory clientFactory;
	HomeView view;
	private PopUpInfo popup = null;
	private HandlerRegistration handler;

	public HomeActivity(HomePlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		popup = clientFactory.getPopUp();
		
	}

	
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus){
		
		view = clientFactory.getHomeView();
		view.setPresenter(this);
		containerWidget.setWidget(view.asWidget());
		
		cargarUsuarioLogueado();
		
	}
	
	
	
	
	private void cargarUsuarioLogueado() {
		
		clientFactory.getUsuarioService().obtenerUsuarioLogueado(new AsyncCallback<UsuarioLogueadoDTO>() {
			
			public void onSuccess(UsuarioLogueadoDTO u) {
				ClientContext.getInstance().setUsuarioLogueadoDTO(u);
				
				view.usuarioLogueado.setText(u.getNombreUsuario());
				view.establecimientoActual.setText("Establecimiento: " + u.getEstablecimientoActual().getNombre());
				//if (u.isSupervisor()) view.usuarioLogueado.setText(view.usuarioLogueado.getText() + " (Supervisor)");
			}
			
			public void onFailure(Throwable arg0) {
				popup.mostrarMensaje("Error", arg0.getMessage());
				
			}
		});
		
		
		
	}


	@Override
	public String mayStop() {
		return null;
	}

	/**
	 * @see HomeView.Presenter#goTo(Place)
	 */
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}


	@Override
	public void inicializarActivity() {
		
	}


	@Override
	public void onCambiarEstablecimiento() {
		SeleccionEstablecimientoPlace newPlace = new SeleccionEstablecimientoPlace("");

		handler = clientFactory.getEventBus()
				.addHandler(SelectedItemEvent.TYPE, new SelectedItemEventHandler() {
					@Override
					public void onSelectItem(SelectedItemEvent event) {
						handler.removeHandler();
						if (event.getListBoxItem() != null){
							view.establecimientoActual.setText("Establecimiento: " + event.getListBoxItem().getItemText());
							MenuView mv=clientFactory.getMenuView();
							mv.getAnchorEstablecimientoActual().setText(" - " + ClientContext.getInstance().getUsuarioLogueadoDTO().getEstablecimientoActual().getNombre());
						}
							
					}
				 });
		
		
		SeleccionEstablecimientoActivity newAct=new SeleccionEstablecimientoActivity(newPlace, clientFactory);
		newAct.startInPopUp();
	}


	


	
}
