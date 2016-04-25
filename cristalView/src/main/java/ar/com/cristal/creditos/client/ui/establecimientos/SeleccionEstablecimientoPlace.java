package ar.com.cristal.creditos.client.ui.establecimientos;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class SeleccionEstablecimientoPlace extends Place {


	/**
	 * Sample property (stores token). 
	 */
	private String token;

	public SeleccionEstablecimientoPlace(String token) {
		this.token = token;
	}

	public void setToken(String t){
		token = t;
	}
	

	public String getToken() {
		return token;
	}

	/**
	 * PlaceTokenizer knows how to serialize the Place's state to a URL token.
	 */
	public static class Tokenizer implements PlaceTokenizer<SeleccionEstablecimientoPlace> {

		public String getToken(SeleccionEstablecimientoPlace place) {
			return place.getToken();
		}

		public SeleccionEstablecimientoPlace getPlace(String token) {
			return new SeleccionEstablecimientoPlace(token);
		}

	}

}
