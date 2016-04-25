package ar.com.cristal.creditos.client.ui.sucursales;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ProcesosAdminPlace extends Place {


	/**
	 * Sample property (stores token). 
	 */
	private String token;

	public ProcesosAdminPlace(String token) {
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
	public static class Tokenizer implements PlaceTokenizer<ProcesosAdminPlace> {

		public String getToken(ProcesosAdminPlace place) {
			return place.getToken();
		}

		public ProcesosAdminPlace getPlace(String token) {
			return new ProcesosAdminPlace(token);
		}

	}

}
