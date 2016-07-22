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

import java.util.Date;

import ar.com.cristal.creditos.client.tambo.dto.VacaDTO;
import ar.com.cristal.creditos.client.ui.util.RegularExpressionConstants;
import ar.com.snoop.gwt.commons.client.widget.ListBox;
import ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl;
import ar.com.snoop.gwt.commons.client.widget.datepicker.FullDatePicker;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextArea;
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

		VacaDTO getVacaActual();

	}
	
		
	
	interface Binder extends UiBinder<Widget, FichaAnimalesView> {
	}
	
	private static final Binder binder = GWT.create(Binder.class);

	private Presenter listener;
	
	@UiField
	RegExpTextBoxImpl rp;
	@UiField
	RegExpTextBoxImpl rc;
	@UiField
	ListBox cmbRaza;
	@UiField
	ListBox cmbCategoria;
	
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
		rc.setExpresionRegular(RegularExpressionConstants.numeros);
	}
	

	
/*	public void inicializarComboTipoDoc(List<String> tipoDocumento){
		tipoDoc.clear();
		
		for (final String tp : tipoDocumento) {
		tipoDoc.addItem(new ListBoxItem() {
			
			public String getItemValue() {

				return tp;
			}
			
			public String getItemText() {
				return tp;
			}
		});
		}
	}

*/
	
	public void limpiarControles() {
		//Limpieza cuadros de texto
		rp.setText("");
		rc.setText("");
		
		//Limpieza combos
		cmbRaza.setSelectedIndex(0);
		cmbCategoria.setSelectedIndex(0);

	}
	
	
	public VacaDTO getVacaActual(){
		return listener.getVacaActual();
	}
	
	
}
