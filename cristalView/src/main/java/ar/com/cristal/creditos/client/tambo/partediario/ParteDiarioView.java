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
package ar.com.cristal.creditos.client.tambo.partediario;

import ar.com.cristal.creditos.client.dto.ClienteDTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * View base interface.
 * Extends IsWidget so a view impl can easily provide its container widget.
 */
public class ParteDiarioView extends Composite implements IsWidget {
  
	@UiField
	Anchor anchorCelosServicios;
	

	public interface Presenter {
		/**
		 * Navigate to a new Place in the browser.
		 */
		void goTo(Place place);

		void onCerrar();

		ClienteDTO getClienteActual();

		void irCelosServicios();

		void irPartos();

		void irIngresosSecadas();

		void irSuplementacion();

		void irSanidad();

		void irBajas();
	}
	
		
	
	interface Binder extends UiBinder<Widget, ParteDiarioView> {
	}
	
	private static final Binder binder = GWT.create(Binder.class);

	private Presenter listener;
	
	
	@UiField
	DivElement clienteDiv;
	
	
	
	@UiHandler("cerrar")
	void onButtonClick(ClickEvent event) {
		listener.onCerrar();
	}

	

	@UiHandler("anchorCelosServicios")
	void onCelosServicios(ClickEvent event) {
		listener.irCelosServicios();
	}
	
	@UiHandler("anchorPartos")
	void onPartos(ClickEvent event) {
		listener.irPartos();
	}
	
	@UiHandler("anchorIngresosSecadas")
	void onIngresosSecadas(ClickEvent event) {
		listener.irIngresosSecadas();
	}
	@UiHandler("anchorSuplementacion")
	void onSuplementacion(ClickEvent event) {
		listener.irSuplementacion();
	}
	@UiHandler("anchorSanidad")
	void onSanidad(ClickEvent event) {
		listener.irSanidad();
	}
	@UiHandler("anchorBajas")
	void onBajas(ClickEvent event) {
		listener.irBajas();
	}

	public ParteDiarioView() {
		initWidget(binder.createAndBindUi(this));
		inicializarValidadores();
		
	}

	
	public void setPresenter(Presenter listener) {
		this.listener = listener;
	
	}

	private void inicializarValidadores() {
//		cuil.setExpresionRegular(RegularExpressionConstants.cuilCuit);
	}
	
	
	

	
	public void limpiarControles() {
//		apellido.setText("");
		
	}
	
	
	public ClienteDTO getClienteActual(){
		return listener.getClienteActual();
	}
	
}
