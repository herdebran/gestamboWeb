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
package ar.com.cristal.creditos.client.ui.usuarios.abm;

import ar.com.cristal.creditos.client.ui.util.RegularExpressionConstants;
import ar.com.snoop.gwt.commons.client.widget.ListBox;
import ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * View base interface.
 * Extends IsWidget so a view impl can easily provide its container widget.
 */
public class AltaEdicionUsuarioView extends Composite implements IsWidget {
  
	

	public interface Presenter {
		/**
		 * Navigate to a new Place in the browser.
		 */
		void goTo(Place place);
				

		void onPersistirUsuario();


		void onCancelar();


		void onPasswordModificado();


		void onBorrar();
		
	}
	
	
	interface Binder extends UiBinder<Widget, AltaEdicionUsuarioView> {
	}
	
	private static final Binder binder = GWT.create(Binder.class);

	private Presenter listener;
	
	
	
	@UiField
	RegExpTextBoxImpl apellido;
	
	@UiField
	RegExpTextBoxImpl nombre;
	
	@UiField
	RegExpTextBoxImpl nombreUsuario;
	
	@UiField
	ListBox perfiles;
	
	
	@UiField
	ListBox sucursales;
	
	
		
	@UiField
	PasswordTextBox password;
	
	@UiField
	PasswordTextBox confirmacionPassword;
	
	@UiField
	CheckBox supervisor;
	
	@UiField
	CheckBox administrador;
	
	@UiField
	Button guardar;
	@UiField
	Button cancelar;
	@UiField
	Button borrar;
	
	
	@UiField
	Label lblModificacion;
	
	public AltaEdicionUsuarioView() {
		
		initWidget(binder.createAndBindUi(this));
		inicializarValidadores();
		
	}

	private void inicializarValidadores() {
		apellido.setExpresionRegular(RegularExpressionConstants.letras);
		nombre.setExpresionRegular(RegularExpressionConstants.letras);
		nombreUsuario.setExpresionRegular(RegularExpressionConstants.password(8));		
		
	}

	

	public void setPresenter(Presenter listener) {
		this.listener = listener;
	
	}

	@UiHandler("cancelar")
	void onButtonClick(ClickEvent event) {
		listener.onCancelar();
	}

	@UiHandler("guardar")
	void onGuardarClick(ClickEvent event) {
		listener.onPersistirUsuario();
	}
	
	@UiHandler("borrar")
	void onBorrarClick(ClickEvent event) {
		listener.onBorrar();
	}
	
	
	@UiHandler("password")
	void onPasswordModificado(ChangeEvent event) {
		listener.onPasswordModificado();
	}

	public void limpiarControles() {
		apellido.setText("");
		nombre.setText("");
		password.setText("");
		confirmacionPassword.setText("");
		sucursales.selectByText("");
		perfiles.clear();
		sucursales.clear();
		perfiles.selectByText("");
		nombreUsuario.setText("");
		supervisor.setValue(false);
		administrador.setValue(false);
		
		
		
	}

	
	

		
	
	

	
}
