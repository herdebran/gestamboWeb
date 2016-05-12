package ar.com.cristal.creditos.client.tambo.toros.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class BusquedaTorosPlace extends Place {
	/**
	 * Sample property (stores token). 
	 */
	private String name;

	public BusquedaTorosPlace(String token) {
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
	public static class Tokenizer implements PlaceTokenizer<BusquedaTorosPlace> {

		public String getToken(BusquedaTorosPlace place) {
			return place.getName();
		}

		public BusquedaTorosPlace getPlace(String token) {
			return new BusquedaTorosPlace(token);
		}

	}
}
