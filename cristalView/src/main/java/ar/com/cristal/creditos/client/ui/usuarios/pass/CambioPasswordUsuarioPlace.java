package ar.com.cristal.creditos.client.ui.usuarios.pass;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class CambioPasswordUsuarioPlace extends Place {

	/**
	 * Sample property (stores token). 
	 */
	private String token;

	public CambioPasswordUsuarioPlace(String token) {
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
	public static class Tokenizer implements PlaceTokenizer<CambioPasswordUsuarioPlace> {

		public String getToken(CambioPasswordUsuarioPlace place) {
			return place.getToken();
		}

		public CambioPasswordUsuarioPlace getPlace(String token) {
			return new CambioPasswordUsuarioPlace(token);
		}

	}
}
