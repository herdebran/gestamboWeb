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
package ar.com.cristal.creditos.client.clientes.alta;

import ar.com.cristal.creditos.client.dto.ClienteDTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * View base interface.
 * Extends IsWidget so a view impl can easily provide its container widget.
 */
public class ClienteTabsView extends Composite implements IsWidget {
  
	
	

	public interface Presenter {
		

		void onReferidos();

		void onDatosAnexos();

		void onDatosPersonales();
		
		void onOperaciones();
			
	}
	
		
	
	interface Binder extends UiBinder<Widget, ClienteTabsView> {
	}
	
	private static final Binder binder = GWT.create(Binder.class);

	private Presenter listener;
	
	

	@UiHandler("anchorReferidos")
	void onReferidos(ClickEvent event) {
		listener.onReferidos();
	}

	@UiHandler("anchorDatosAnexos")
	void onDatosAnexos(ClickEvent event) {
		listener.onDatosAnexos();
	}
	
	@UiHandler("anchorDatosPersonales")
	void onDatosPersonales(ClickEvent event) {
		listener.onDatosPersonales();
	}
	
	@UiHandler("anchorDatosOperaciones")
	void onDatosOperaciones(ClickEvent event) {
		listener.onOperaciones();
	}
	

	public ClienteTabsView() {
		initWidget(binder.createAndBindUi(this));
	}


	public void setPresenter(Presenter listener) {
		this.listener = listener;
	
	}

	
	
}
