package ar.com.cristal.creditos.client.ui.sucursales;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ABMSucursalPlace extends Place {


	/**
	 * Sample property (stores token). 
	 */
	private String token;

	public ABMSucursalPlace(String token) {
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
	public static class Tokenizer implements PlaceTokenizer<ABMSucursalPlace> {

		public String getToken(ABMSucursalPlace place) {
			return place.getToken();
		}

		public ABMSucursalPlace getPlace(String token) {
			return new ABMSucursalPlace(token);
		}

	}

}
