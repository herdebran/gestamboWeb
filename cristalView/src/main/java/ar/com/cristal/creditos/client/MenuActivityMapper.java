package ar.com.cristal.creditos.client;

import ar.com.cristal.creditos.client.ui.MenuActivity;
import ar.com.cristal.creditos.client.ui.MenuPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class MenuActivityMapper implements ActivityMapper {
    private ClientFactory clientFactory;
    
    private Activity currentActivity;

    public MenuActivityMapper(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }

    
    public Activity getActivity(Place place) {    	
    	
        if (place instanceof MenuPlace)
            currentActivity = new MenuActivity((MenuPlace) place, clientFactory);
       
       
//        if (place instanceof RealizarLlamadoPlace)
//        	currentActivity = new RealizarLlamadoActivity((RealizarLlamadoPlace)place, clientFactory);
//        else
        if (currentActivity == null) {
        	place = new MenuPlace("");
        	currentActivity = new MenuActivity((MenuPlace) place, clientFactory);
        }
        
        
        return currentActivity;
        
    }
}