package ar.com.cristal.creditos.client.localidad.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class BusquedaLocalidadPlace extends Place {
	/**
	 * Sample property (stores token). 
	 */
	private String name;

	public BusquedaLocalidadPlace(String token) {
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
	public static class Tokenizer implements PlaceTokenizer<BusquedaLocalidadPlace> {

		public String getToken(BusquedaLocalidadPlace place) {
			return place.getName();
		}

		public BusquedaLocalidadPlace getPlace(String token) {
			return new BusquedaLocalidadPlace(token);
		}

	}
}
