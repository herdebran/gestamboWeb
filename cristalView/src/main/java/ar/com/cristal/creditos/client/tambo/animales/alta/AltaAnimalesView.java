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
package ar.com.cristal.creditos.client.tambo.animales.alta;

import java.util.Date;

import ar.com.cristal.creditos.client.tambo.dto.VacaDTO;
import ar.com.cristal.creditos.client.ui.util.RegularExpressionConstants;
import ar.com.snoop.gwt.commons.client.widget.ListBox;
import ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl;
import ar.com.snoop.gwt.commons.client.widget.datepicker.FullDatePicker;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

/**
 * View base interface.
 * Extends IsWidget so a view impl can easily provide its container widget.
 */
public class AltaAnimalesView extends Composite implements IsWidget {
  
	
	

	public interface Presenter {
		/**
		 * Navigate to a new Place in the browser.
		 */
		void goTo(Place place);

		void onAplicar(Place place);

		void onCerrar();

		VacaDTO getVacaActual();

		void cargarCategoriasXRaza(String selectedItemId);

		void buscarPadre();
		
		void buscarRodeo();

		void verificarSiExisteRP();
	}
	
		
	
	interface Binder extends UiBinder<Widget, AltaAnimalesView> {
	}
	
	private static final Binder binder = GWT.create(Binder.class);

	private Presenter listener;
	
	@UiField
	RegExpTextBoxImpl rp;
	@UiField
	RegExpTextBoxImpl rc;
	@UiField
	RegExpTextBoxImpl rpMadre;
	@UiField
	RegExpTextBoxImpl rcMadre;
	@UiField
	RegExpTextBoxImpl lactancia;
	@UiField
	RegExpTextBoxImpl grasa;
	@UiField
	RegExpTextBoxImpl proteina;
	@UiField
	RegExpTextBoxImpl solTot;
	@UiField
	RegExpTextBoxImpl celSom;
	@UiField
	RegExpTextBoxImpl prodVitalicia;
	@UiField
	RegExpTextBoxImpl ltsPromedio;

	@UiField
	ListBox cmbRaza;
	@UiField
	ListBox cmbCategoria;
	@UiField
	ListBox cmbPadre;
	@UiField
	ListBox cmbCategMadre;
	@UiField
	ListBox cmbRodeo;
	@UiField
	ListBox cmbEstadoProd;
	@UiField
	ListBox cmbEstadoReprod;
	@UiField
	ListBox cmbEstadoSanitario;
	@UiField
	ListBox cmbResultadoUltTacto;

	@UiField(provided=true)
	FullDatePicker fechaNacimientoDatePicker = new FullDatePicker("");

	@UiField
	CheckBox paraVender;



	
	@UiField
	TextArea observaciones;
	
	
	
	
	@UiField
	DivElement clienteDiv;
	
	
	@UiField
	Button aplicar;
	@UiField
	Button btnBuscarPadre;
	@UiField
	Button btnBuscarRodeo;

	@UiHandler("cerrar")
	void onButtonClick(ClickEvent event) {
		listener.onCerrar();
	}

	@UiHandler("aplicar")
	void onSolicitarAprobacionClick(ClickEvent event) {
		listener.onAplicar(null);
			
	}
	
	@UiHandler("btnBuscarPadre")
	public void onClickBuscarPadre(ClickEvent event){
		listener.buscarPadre();
	}

	@UiHandler("btnBuscarRodeo")
	public void onClickBuscarRodeo(ClickEvent event){
		listener.buscarRodeo();
	}
	
	
	@UiHandler("rp")
	void onRPLostFocus(BlurEvent event){
		listener.verificarSiExisteRP();
	}

	
	public AltaAnimalesView() {
		initWidget(binder.createAndBindUi(this));
		inicializarValidadores();
		
		cmbRaza.addBlurHandler(new BlurHandler() {
			
			public void onBlur(BlurEvent arg0) {
				if (cmbRaza.getSelectedItem() != null)
					
					listener.cargarCategoriasXRaza(cmbRaza.getSelectedItemId());
				
			}
		});
		
	
		
	}
	

	public void setPresenter(Presenter listener) {
		this.listener = listener;
	
	}

	private void inicializarValidadores() {
		rp.setExpresionRegular(RegularExpressionConstants.numeroLetrasEspacioGuion);
		rc.setExpresionRegular(RegularExpressionConstants.numeros);
		rpMadre.setExpresionRegular(RegularExpressionConstants.numeroLetrasEspacioGuion);
		rcMadre.setExpresionRegular(RegularExpressionConstants.numeros);
		lactancia.setExpresionRegular(RegularExpressionConstants.numeros);
		grasa.setExpresionRegular(RegularExpressionConstants.numerosYPunto);
		proteina.setExpresionRegular(RegularExpressionConstants.numerosYPunto);
		solTot.setExpresionRegular(RegularExpressionConstants.numerosYPunto);
		celSom.setExpresionRegular(RegularExpressionConstants.numerosYPunto);
		prodVitalicia.setExpresionRegular(RegularExpressionConstants.numerosYPunto);
		ltsPromedio.setExpresionRegular(RegularExpressionConstants.numerosYPunto);
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
		rpMadre.setText("");
		rcMadre.setText("");
		lactancia.setText("");
		grasa.setText("");
		proteina.setText("");
		solTot.setText("");
		celSom.setText("");
		prodVitalicia.setText("");
		prodVitalicia.setTitle("Es el total de litros producidos por el animal. Se irá incrementando automáticamente.");
		ltsPromedio.setText("");
		ltsPromedio.setTitle("Coloque el promedio diario vitalicio del animal.");
		
		//Limpieza combos
		cmbRaza.setSelectedIndex(0);
		cmbCategoria.setSelectedIndex(0);
		cmbPadre.setSelectedIndex(0);
		cmbCategMadre.setSelectedIndex(0);
		cmbRodeo.setSelectedIndex(0);
		cmbEstadoProd.setSelectedIndex(0);
		cmbEstadoReprod.setSelectedIndex(0);
		cmbEstadoSanitario.setSelectedIndex(0);
		cmbResultadoUltTacto.setSelectedIndex(0);

		//Limpieza DatePicker
		fechaNacimientoDatePicker.setSelectedDate(new Date());
		fechaNacimientoDatePicker.setSaturdaySelectable(true);
		fechaNacimientoDatePicker.setSundaySelectable(true);
		
		//Limpieza Observaciones
		observaciones.setText("");
		
		//Checkboxes
		paraVender.setValue(false);
		paraVender.setTitle("Utilice esta marca si el animal está para vender.");
		
		//InicializarCombos.inicializarComboMasculinoFemenino(sexo, "");
		
	}
	
	
	public VacaDTO getVacaActual(){
		return listener.getVacaActual();
	}
	
	public void habilitarBotonGuardar(Boolean habilitar) {
		aplicar.setEnabled(habilitar);
		
	}
	
	
	
}
