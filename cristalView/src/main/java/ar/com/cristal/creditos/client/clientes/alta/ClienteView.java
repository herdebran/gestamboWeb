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

import java.util.Date;
import java.util.List;

import ar.com.cristal.creditos.client.dto.ClienteDTO;
import ar.com.cristal.creditos.client.dto.EmpresaDTO;
import ar.com.cristal.creditos.client.ui.util.InicializarCombos;
import ar.com.cristal.creditos.client.ui.util.OperacionesDocumentos;
import ar.com.cristal.creditos.client.ui.util.RegularExpressionConstants;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;
import ar.com.snoop.gwt.commons.client.widget.ListBox;
import ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl;
import ar.com.snoop.gwt.commons.client.widget.datepicker.FullDatePicker;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * View base interface.
 * Extends IsWidget so a view impl can easily provide its container widget.
 */
public class ClienteView extends Composite implements IsWidget {
  
	
	

	public interface Presenter {
		/**
		 * Navigate to a new Place in the browser.
		 */
		void goTo(Place place);

		void onAplicar(Place place);

		void onCerrar();

		ClienteDTO getClienteActual();

		void calcularCuil();

		void irACausaLegal();
		
		void onLlamadaEnCurso();		
		
		void buscarReparticion();
		
		void buscarLocalidad();
		
		void buscarComercializador();
		
		void onGarantes();
			
	}
	
		
	
	interface Binder extends UiBinder<Widget, ClienteView> {
	}
	
	private static final Binder binder = GWT.create(Binder.class);

	private Presenter listener;
	
	@UiField
	RegExpTextBoxImpl apellido;
	
	@UiField
	RegExpTextBoxImpl nombre;
	
	@UiField
	RegExpTextBoxImpl dni;
	
	@UiField
	RegExpTextBoxImpl verificadorDni;
	
	
	@UiField
	RegExpTextBoxImpl cuil;
	

	@UiField
	ListBox banco;

	@UiField
	ListBox estadoCliente;

	@UiField
	RegExpTextBoxImpl cbu;
	
	@UiField
	RegExpTextBoxImpl verificadorCBU;
	
	@UiField
	RegExpTextBoxImpl nroCuenta;
	

	@UiField
	Anchor anchorLlamadasEnCurso;

	@UiField
	Anchor anchorLegales;
	
	/***
	 * Domicilio
	 */
	@UiField
	RegExpTextBoxImpl cp;
	
	@UiField
	RegExpTextBoxImpl calle;
	
	
	@UiField
	RegExpTextBoxImpl telefono;
	
	@UiField
	RegExpTextBoxImpl telefono1;
	
	@UiField
	RegExpTextBoxImpl telefono2;
	
	@UiField
	RegExpTextBoxImpl telefono3;
	
	
	@UiField
	RegExpTextBoxImpl caracteristica;
	
	@UiField
	RegExpTextBoxImpl caracteristica1;
	
	@UiField
	RegExpTextBoxImpl caracteristica2;
	
	@UiField
	RegExpTextBoxImpl caracteristica3;
	
	
	@UiField
	RegExpTextBoxImpl piso;
	
	@UiField
	RegExpTextBoxImpl dpto;
	
	
	@UiField
	RegExpTextBoxImpl nro;
	
	@UiField
	TextArea observaciones;
	
	@UiField
	TextBox reparticion;
	
	
	@UiField(provided=true)
	FullDatePicker fechaNacimientoDatePicker = new FullDatePicker("");
	

	@UiField
	ListBox tipoDoc;
	
	@UiField
	ListBox provincia;
	
//	@UiField
//	ListBox localidad;
	
	@UiField
	TextBox localidad;
	
	@UiField
	CheckBox tarjetaBeneficios;
	
	@UiField
	CheckBox antecedentesJuridicos;
	
	@UiField
	RegExpTextBoxImpl email;
	
	@UiField
	CheckBox checkPagoVoluntario;
	
	@UiField
	ListBox sexo;
	
	@UiField
	TextBox comercializador;
	
	@UiField
	Anchor anchorDatosPersonales;
	
	
	@UiField
	DivElement clienteDiv;
	
	
	@UiField
	Button buscarComercializador;
	
	
	@UiField
	Button aplicar;
	
	
	@UiHandler("cerrar")
	void onButtonClick(ClickEvent event) {
		listener.onCerrar();
	}

	

	@UiHandler("anchorGarantes")
	void onGarantes(ClickEvent event) {
		listener.onGarantes();
	}


	@UiHandler("aplicar")
	void onSolicitarAprobacionClick(ClickEvent event) {
		listener.onAplicar(null);
			
	}
	
	
	@UiHandler("cuil")
	void onCuilChange(KeyUpEvent event){
		cuil.setText(OperacionesDocumentos.autocompletarCuit(event, cuil.getText()));
	}

	public ClienteView() {
		initWidget(binder.createAndBindUi(this));
		inicializarValidadores();
		dni.addBlurHandler(new BlurHandler() {
			
			public void onBlur(BlurEvent arg0) {
				listener.calcularCuil();
				
			}
		});
		
		sexo.addBlurHandler(new BlurHandler() {
			
			public void onBlur(BlurEvent arg0) {
				if (dni.getText().length() > 0)
					listener.calcularCuil();
				
			}
		});
		
	
		
	}

	
	
	
	
	@UiHandler("anchorLegales")
	void onCausaLegalClick(ClickEvent event){		
		listener.irACausaLegal();
	}
	

	public void setPresenter(Presenter listener) {
		this.listener = listener;
	
	}

	private void inicializarValidadores() {
		cuil.setExpresionRegular(RegularExpressionConstants.cuilCuit);
		cbu.setExpresionRegular(RegularExpressionConstants.numeros);
		verificadorCBU.setExpresionRegular(RegularExpressionConstants.numeros);
		dni.setExpresionRegular(RegularExpressionConstants.dni);
		verificadorDni.setExpresionRegular(RegularExpressionConstants.dni);
		apellido.setExpresionRegular(RegularExpressionConstants.letras);
		nombre.setExpresionRegular(RegularExpressionConstants.letras);
//		sueldo.setExpresionRegular(RegularExpressionConstants.importeSeparadorDecimalPunto);
		banco.setEnabled(true);
		nroCuenta.setExpresionRegular(RegularExpressionConstants.numeros);		
		telefono.setExpresionRegular(RegularExpressionConstants.numeros);
		telefono1.setExpresionRegular(RegularExpressionConstants.numeros);
		telefono2.setExpresionRegular(RegularExpressionConstants.numeros);
		telefono3.setExpresionRegular(RegularExpressionConstants.numeros);
		
		caracteristica.setExpresionRegular(RegularExpressionConstants.numeros);
		caracteristica1.setExpresionRegular(RegularExpressionConstants.numeros);
		caracteristica2.setExpresionRegular(RegularExpressionConstants.numeros);
		caracteristica3.setExpresionRegular(RegularExpressionConstants.numeros);
		
		piso.setExpresionRegular(RegularExpressionConstants.numeroLetrasEspacioGuion);
		nro.setExpresionRegular(RegularExpressionConstants.numeroLetrasEspacioGuion);
		dpto.setExpresionRegular(RegularExpressionConstants.numeroLetrasEspacioGuion);
		
		calle.setExpresionRegular(RegularExpressionConstants.numeroLetrasEspacioGuion);
		
		email.setExpresionRegular(RegularExpressionConstants.lazyEmail);
		cuil.setTitle("Ingrese el cuil con el siguiente formato: xx-xxxxxxxx-x");
		cp.setExpresionRegular(RegularExpressionConstants.numeroLetrasEspacioGuion);
	}
	

//public void inicializarComboLocalidad(List<LocalidadDTO> localidad){
//		
//	}


	public void inicializarComboEmpresa(List<EmpresaDTO> empresas){
		
	}
	
	
	public void inicializarComboTipoDoc(List<String> tipoDocumento){
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


	
	public void limpiarControles() {
		apellido.setText("");
		nombre.setText("");
		dni.setText("");
		verificadorDni.setText("");
		verificadorCBU.setText("");
		cuil.setText("");
		cbu.setText("");
		
		telefono.setText("");
		telefono1.setText("");
		telefono2.setText("");
		telefono3.setText("");
		
		caracteristica.setText("");
		caracteristica1.setText("");
		caracteristica2.setText("");
		caracteristica3.setText("");

		
		banco.setSelectedIndex(0);
		tipoDoc.setSelectedIndex(0);
		
		fechaNacimientoDatePicker.setSelectedDate(new Date());
		fechaNacimientoDatePicker.setSaturdaySelectable(true);
		fechaNacimientoDatePicker.setSundaySelectable(true);
		
		calle.setText("");
		cp.setText("");
		
		piso.setText("");
		nro.setText("");
		dpto.setText("");
		
		observaciones.setText("");
		
		localidad.setText("");
		provincia.setSelectedIndex(0);
		
		checkPagoVoluntario.setValue(false);
		checkPagoVoluntario.setEnabled(false);
		checkPagoVoluntario.setTitle("Esta marca es informativa. El pago voluntario lo determina el crédito y no puede ser modifcada desde esta pantalla.");
		
		tarjetaBeneficios.setValue(Boolean.FALSE);
		antecedentesJuridicos.setValue(Boolean.FALSE);
		
		reparticion.setText("");
		
		email.setText("");
		
		nroCuenta.setText("");
		
		InicializarCombos.inicializarComboMasculinoFemenino(sexo, "");
		
	}
	
	
	public ClienteDTO getClienteActual(){
		return listener.getClienteActual();
	}
	
	@UiHandler("anchorLlamadasEnCurso")
	void onLlamadaEnCurso(ClickEvent event) {
		listener.onLlamadaEnCurso();
	}
	
	@UiHandler("buscarReparticion")
	public void onClickBuscarReparticion(ClickEvent event){
		listener.buscarReparticion();
	}
	
	@UiHandler("buscarLocalidad")
	public void onClickBuscarLocalidad(ClickEvent event){
		listener.buscarLocalidad();
	}
	
	
	@UiHandler("buscarComercializador")
	public void onClickBuscarComercializador(ClickEvent event){
		listener.buscarComercializador();
	}



	public void habilitarBotonGuardar(Boolean habilitar) {
		aplicar.setEnabled(habilitar);
		
	}
	
	
	
}
