package ar.com.cristal.creditos.client.creditos.popup;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.ui.event.AddClientEvent;
import ar.com.cristal.creditos.client.ui.util.PopUpInfo;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Activities are started and stopped by an ActivityManager associated with a container Widget.
 */
public class PopUpCreditoInfoActivity extends AbstractActivity implements PopUpCreditoInfoView.Presenter {

	
	 private ClientFactory clientFactory;
	 private PopUpCreditoInfoView view;
	 private String creditoId = "";
	 private PopUpInfo popup = null;


	
	
	public PopUpCreditoInfoActivity(PopUpCreditoInfoPlace place,ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		creditoId = place.getToken();
		popup = clientFactory.getPopUp();
	}
	
	

	
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		view = new PopUpCreditoInfoView();		
		view.setPresenter(this);		
		view.show();

		inicializarContorles();
		
	}
	
	

	private void inicializarContorles() {
		view.inicalizarControles();
		
	}

	@Override
	public String mayStop() {
		return null;
	}

	/**
	 * @see PopUpCreditoInfoView.Presenter#goTo(Place)
	 */
	public void goTo(Place place) {
	}

	public void addClient(String name) {
		clientFactory.getEventBus().fireEvent(new AddClientEvent(name));		
	}
}
