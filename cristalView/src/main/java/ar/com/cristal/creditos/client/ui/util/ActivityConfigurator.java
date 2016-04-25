package ar.com.cristal.creditos.client.ui.util;

import ar.com.cristal.creditos.client.ClientFactory;

import com.google.gwt.place.shared.Place;

public class ActivityConfigurator {

	
	
	public static void cambioDePestaña(ClientFactory clientFactory, final Place place){
		if (place != null)
			clientFactory.getPlaceController().goTo(place);

	}
}
