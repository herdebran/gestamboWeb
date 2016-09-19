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
package ar.com.cristal.creditos.client.tambo.partediario.parto;

import ar.com.cristal.creditos.client.ui.util.ConstantesView;
import ar.com.cristal.creditos.client.ui.util.RegularExpressionConstants;
import ar.com.snoop.gwt.commons.client.widget.ListBox;
import ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * View base interface.
 * Extends IsWidget so a view impl can easily provide its container widget.
 */
public class PdPartoView extends Composite implements IsWidget {
  
	@UiField
	Anchor anchorPartos;
	

	public interface Presenter {
		/**
		 * Navigate to a new Place in the browser.
		 */
		void goTo(Place place);

		void onCerrar();

		void irCelosServicios();

		void irPartos();

		void irIngresosSecadas();

		void irSuplementacion();

		void irSanidad();

		void irBajas();

		void onGuardar();
		
		void onAgregarParto();

		void cargarUltimoServicioVaca(String selectedItemText);
	}
	
		
	
	interface Binder extends UiBinder<Widget, PdPartoView> {
	}
	
	private static final Binder binder = GWT.create(Binder.class);

	private Presenter listener;
	
	
	@UiField
	DivElement clienteDiv;
	
	@UiField
	ListBox cmbVaca;
	@UiField
	CheckBox chkMellizos;

	@UiField
	RegExpTextBoxImpl nroParto;
	@UiField
	ListBox cmbPadre;
	@UiField
	ListBox cmbSexoCria1;
	@UiField
	ListBox cmbSexoCria2;
	@UiField
	ListBox cmbTipoParto;
	@UiField
	ListBox cmbEstadoCria1;
	@UiField
	ListBox cmbEstadoCria2;
	@UiField(provided=true)
	FlexTable lstCelosServicios = new FlexTable();
	@UiField
	Label lblSexoCria1;
	@UiField
	Label lblEstadoCria1;
	@UiField
	Label lblRpCria1;
	@UiField
	Label lblMellizos;
	@UiField
	RegExpTextBoxImpl txtFechaUS;
	@UiField
	RegExpTextBoxImpl rpCria1;
	@UiField
	RegExpTextBoxImpl rpCria2;


	@UiHandler("cmdAgregarParto")
	void onCmdAgregarPartoClick(ClickEvent event) {
		listener.onAgregarParto();
	}

	@UiHandler("cmdCerrar")
	void onCmdCerrarClick(ClickEvent event) {
		listener.onCerrar();
	}

	@UiHandler("cmdGuardar")
	void onCmdGuardarClick(ClickEvent event) {
		listener.onGuardar();
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

	public PdPartoView() {
		initWidget(binder.createAndBindUi(this));
		inicializarValidadores();
		
		cmbTipoParto.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				if (cmbTipoParto.getSelectedItemId() != null) {
					visibilizarControlesParto(!cmbTipoParto.getSelectedItemText().equals(ConstantesView.ABORTO));
				}
				
			}
		});
		
		chkMellizos.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				visibilizarControles2daCria(chkMellizos.getValue());
				
			}
		});
		
		cmbVaca.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				if (cmbVaca.getSelectedItemId() != null) {
					listener.cargarUltimoServicioVaca(cmbVaca.getSelectedItemText());
				}
				
			}

		});
	}

	
	public void setPresenter(Presenter listener) {
		this.listener = listener;
	
	}

	private void inicializarValidadores() {
		nroParto.setExpresionRegular(RegularExpressionConstants.numeros);
		rpCria1.setExpresionRegular(RegularExpressionConstants.numeroLetrasEspacioGuion);
		rpCria2.setExpresionRegular(RegularExpressionConstants.numeroLetrasEspacioGuion);
	}
	
	
	public void limpiarControles() {
		nroParto.setText("");
		rpCria1.setText("");
		rpCria2.setText("");
		txtFechaUS.setText("");
		
		cmbVaca.setSelectedIndex(0);
		cmbTipoParto.setSelectedIndex(0);
		cmbPadre.setSelectedIndex(0);
		cmbSexoCria1.setSelectedIndex(0);
		cmbEstadoCria1.setSelectedIndex(0);
		cmbSexoCria2.setSelectedIndex(0);
		cmbEstadoCria2.setSelectedIndex(0);
		
		chkMellizos.setValue(false);
	}
	
	void initTable(){
		lstCelosServicios.removeAllRows();
		
		lstCelosServicios.setHTML(0,0,"Id");
		lstCelosServicios.setText(0, 1, "RP");
		lstCelosServicios.setText(0, 2, "Padre");
		lstCelosServicios.setText(0, 3, "Parto Nº");
		lstCelosServicios.setText(0, 4, "Tipo");
		lstCelosServicios.setText(0, 5, "Sexo cria");
		lstCelosServicios.setText(0, 6, "Estado cria");
		lstCelosServicios.setText(0, 7, "Sexo cria 2");
		lstCelosServicios.setText(0, 8, "Estado cria 2");
		lstCelosServicios.setText(0, 9, "Mellizos");
		lstCelosServicios.setText(0, 10, "Accion");

		lstCelosServicios.setCellPadding(0);
		lstCelosServicios.setCellSpacing(0);
		lstCelosServicios.getRowFormatter().addStyleName(0, "header");
		
		
	}

	public void visibilizarControlesParto(boolean b) {
		// Hace visible o invisible los controles para detalle de partos
		lblSexoCria1.setVisible(b);
		cmbSexoCria1.setVisible(b);
		lblEstadoCria1.setVisible(b);
		cmbEstadoCria1.setVisible(b);
		lblRpCria1.setVisible(b);
		rpCria1.setVisible(b);
		lblMellizos.setVisible(b);
		chkMellizos.setVisible(b);
		
	}

	public void visibilizarControles2daCria(boolean b) {
		// Hace visible o invisible los controles para carga mellizos
		cmbSexoCria2.setVisible(b);
		cmbEstadoCria2.setVisible(b);
		rpCria2.setVisible(b);
	}
	
}
