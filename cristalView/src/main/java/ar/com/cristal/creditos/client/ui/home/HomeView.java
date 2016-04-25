package ar.com.cristal.creditos.client.ui.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * View base interface.
 * Extends IsWidget so a view impl can easily provide its container widget.
 */
public class HomeView extends Composite implements IsWidget {
  
	
	public interface Presenter {
		/**
		 * Navigate to a new Place in the browser.
		 */
		void goTo(Place place);

	}
	
	
	interface Binder extends UiBinder<Widget, HomeView> {
	}
	
	private static final Binder binder = GWT.create(Binder.class);

	private Presenter listener;
	
	
	
	@UiField Label usuarioLogueado;

	public HomeView() {
		initWidget(binder.createAndBindUi(this));
	}

	
	

	
	public void setPresenter(Presenter listener) {
		this.listener = listener;
	}

	
	
	
}
