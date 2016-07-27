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
package ar.com.cristal.creditos.client.tambo.animales.ficha;

import ar.com.cristal.creditos.client.tambo.dto.VacaDTO;
import ar.com.cristal.creditos.client.ui.util.RegularExpressionConstants;
import ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * View base interface.
 * Extends IsWidget so a view impl can easily provide its container widget.
 */
public class FichaAnimalesView extends Composite implements IsWidget {
  
	
	

	public interface Presenter {
		/**
		 * Navigate to a new Place in the browser.
		 */
		void goTo(Place place);

		void onCerrar();
	}
	
		
	
	interface Binder extends UiBinder<Widget, FichaAnimalesView> {
	}
	
	private static final Binder binder = GWT.create(Binder.class);

	private Presenter listener;
	
	@UiField
	RegExpTextBoxImpl rp;

	@UiField
	Label lblRaza;
	@UiField
	Label lblPadre;
	@UiField
	Label lblMadre;
	@UiField
	Label lblFNacim;
	@UiField
	Label lblRodeo;
	@UiField
	Label lblEstadoProductivo;
	@UiField
	Label lblEstadoReproductivo;
	@UiField
	Label lblEstadoSanitario;
	@UiField
	Label lblDiasLactancia;
	@UiField
	Label lblIntPartoPreniez;
	@UiField
	Label lblIntPartoParto;
	@UiField
	Label lblPrenieces1Serv;
	@UiField
	Label lblServiciosPreniez;
	@UiField
	Label lblFechaUS;
	@UiField
	Label lblToroUS;
	@UiField
	Label lblNroUS;

	
	@UiField
	DivElement clienteDiv;
	
	@UiHandler("cerrar")
	void onButtonClick(ClickEvent event) {
		listener.onCerrar();
	}

	public FichaAnimalesView() {
		initWidget(binder.createAndBindUi(this));
		inicializarValidadores();
		
	}
	

	public void setPresenter(Presenter listener) {
		this.listener = listener;
	
	}

	private void inicializarValidadores() {
		rp.setExpresionRegular(RegularExpressionConstants.numeroLetrasEspacioGuion);

	}
	

	public void limpiarControles() {
		//Limpieza cuadros de texto
		rp.setText("");
		lblRaza.setText("");
		lblPadre.setText("");
		lblMadre.setText("");
		lblFNacim.setText("");
		lblRodeo.setText("");
		lblEstadoProductivo.setText("");
		lblEstadoReproductivo.setText("");
		lblEstadoSanitario.setText("");
		lblDiasLactancia.setText("");
		lblIntPartoPreniez.setText("");
		lblIntPartoParto.setText("");
		lblPrenieces1Serv.setText("");
		lblServiciosPreniez.setText("");
		lblFechaUS.setText("");
		lblToroUS.setText("");
		lblNroUS.setText("");
	}
	
}
