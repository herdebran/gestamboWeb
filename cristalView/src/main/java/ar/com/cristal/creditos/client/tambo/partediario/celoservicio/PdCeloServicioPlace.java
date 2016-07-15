/*
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ar.com.cristal.creditos.client.tambo.partediario.celoservicio;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * A place object representing a particular state of the UI. A Place can be converted to and from a
 * URL history token by defining a {@link PlaceTokenizer} for each {@link Place}, and the 
 * {@link PlaceHistoryHandler} automatically updates the browser URL corresponding to each 
 * {@link Place} in your app.
 */
public class PdCeloServicioPlace extends Place {
  
	/**
	 * Sample property (stores token). 
	 */
	private String name;

	public PdCeloServicioPlace(String token) {
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
	public static class Tokenizer implements PlaceTokenizer<PdCeloServicioPlace> {

		public String getToken(PdCeloServicioPlace place) {
			return place.getName();
		}

		public PdCeloServicioPlace getPlace(String token) {
			return new PdCeloServicioPlace(token);
		}

	}
}
