package ar.com.cristal.creditos.client.widget;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.ui.event.AddClientEvent;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Activities are started and stopped by an ActivityManager associated with a container Widget.
 */
public class PopUpInfoActivity extends AbstractActivity implements PopUpInfoView.Presenter {

	
	 private ClientFactory clientFactory;
	 private PopUpInfoView view;


	public PopUpInfoActivity(PopUpInfoPlace place) {
		
	}
	
	public PopUpInfoActivity(PopUpInfoPlace place,ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	

	
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		view = clientFactory.getPopUpInfoView();		
		view.setPresenter(this);		
		view.informacion.setVisible(true);
		view.tablaInformacion.setVisible(false);
		view.show();

		
	}
	
	

	@Override
	public String mayStop() {
		return null;
	}

	/**
	 * @see PopUpInfoView.Presenter#goTo(Place)
	 */
	public void goTo(Place place) {
	}

	public void addClient(String name) {
		clientFactory.getEventBus().fireEvent(new AddClientEvent(name));		
	}
}
