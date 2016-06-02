package ar.com.cristal.creditos.client.tambo.rodeos.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class BusquedaRodeosPlace extends Place {
	/**
	 * Sample property (stores token). 
	 */
	private String name;

	public BusquedaRodeosPlace(String token) {
		this.name = token;
	}

	public String getName() {
		return name;
	}
	
	public void setToken(String t){
		name = t;
	}
	

	public String getToken() {
		return name;
	}

	/**
	 * PlaceTokenizer knows how to serialize the Place's state to a URL token.
	 */
	public static class Tokenizer implements PlaceTokenizer<BusquedaRodeosPlace> {

		public String getToken(BusquedaRodeosPlace place) {
			return place.getName();
		}

		public BusquedaRodeosPlace getPlace(String token) {
			return new BusquedaRodeosPlace(token);
		}

	}
}
