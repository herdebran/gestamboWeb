package ar.com.cristal.creditos.client.creditos.popup;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * A place object representing a particular state of the UI. A Place can be converted to and from a
 * URL history token by defining a {@link PlaceTokenizer} for each {@link Place}, and the 
 * {@link PlaceHistoryHandler} automatically updates the browser URL corresponding to each 
 * {@link Place} in your app.
 */
public class PopUpCreditoInfoPlace extends Place {
  
	/**
	 * Sample property (stores token). 
	 */
	private String token;

	public PopUpCreditoInfoPlace(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}
	


	/**
	 * PlaceTokenizer knows how to serialize the Place's state to a URL token.
	 */
	public static class Tokenizer implements PlaceTokenizer<PopUpCreditoInfoPlace> {

		
		public String getToken(PopUpCreditoInfoPlace place) {
			return place.getToken();
		}

		
		public PopUpCreditoInfoPlace getPlace(String token) {
			return new PopUpCreditoInfoPlace(token);
		}

	}
}
