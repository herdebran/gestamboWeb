package ar.com.cristal.creditos.client.widget;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * A place object representing a particular state of the UI. A Place can be converted to and from a
 * URL history token by defining a {@link PlaceTokenizer} for each {@link Place}, and the 
 * {@link PlaceHistoryHandler} automatically updates the browser URL corresponding to each 
 * {@link Place} in your app.
 */
public class PopUpInfoPlace extends Place {
  
	/**
	 * Sample property (stores token). 
	 */
	private String name;

	public PopUpInfoPlace(String token) {
		this.name = token;
	}

	public String getName() {
		return name;
	}
	


	/**
	 * PlaceTokenizer knows how to serialize the Place's state to a URL token.
	 */
	public static class Tokenizer implements PlaceTokenizer<PopUpInfoPlace> {

		
		public String getToken(PopUpInfoPlace place) {
			return place.getName();
		}

		
		public PopUpInfoPlace getPlace(String token) {
			return new PopUpInfoPlace(token);
		}

	}
}
