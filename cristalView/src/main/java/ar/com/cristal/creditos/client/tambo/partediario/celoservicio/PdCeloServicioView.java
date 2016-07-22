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

import java.util.Date;

import ar.com.cristal.creditos.client.dto.TipoCeloServicioEnumDTO;
import ar.com.cristal.creditos.client.ui.util.RegularExpressionConstants;
import ar.com.snoop.gwt.commons.client.widget.ListBox;
import ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * View base interface.
 * Extends IsWidget so a view impl can easily provide its container widget.
 */
public class PdCeloServicioView extends Composite implements IsWidget {
  
	@UiField
	Anchor anchorCelosServicios;
	

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
		
		void onAgregarCeloServicio();
	}
	
		
	
	interface Binder extends UiBinder<Widget, PdCeloServicioView> {
	}
	
	private static final Binder binder = GWT.create(Binder.class);

	private Presenter listener;
	
	
	@UiField
	DivElement clienteDiv;
	
	@UiField
	ListBox cmbVaca;
	@UiField
	RegExpTextBoxImpl nroCeloServicio;
	@UiField
	RegExpTextBoxImpl nroLactancia;
	@UiField
	ListBox cmbTipo;
	@UiField
	ListBox cmbToro;
	@UiField
	ListBox cmbTipoServicio;
	@UiField
	ListBox cmbInseminador;
	@UiField(provided=true)
	FlexTable lstCelosServicios = new FlexTable();
	@UiField
	Label lblToro;
	@UiField
	Label lblTipoServicio;
	@UiField
	Label lblInseminador;

	@UiHandler("cmdAgregarCeloServicio")
	void onCmdAgregarCeloServicioClick(ClickEvent event) {
		listener.onAgregarCeloServicio();
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

	public PdCeloServicioView() {
		initWidget(binder.createAndBindUi(this));
		inicializarValidadores();
		
		cmbTipo.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				if (cmbTipo.getSelectedItemId() != null) {
					visibilizarControlesParaServicio(cmbTipo.getSelectedItemId().equals(TipoCeloServicioEnumDTO.SERVICIO.name()));
				}
				
			}
		});
		
		
	}

	
	public void setPresenter(Presenter listener) {
		this.listener = listener;
	
	}

	private void inicializarValidadores() {
		nroCeloServicio.setExpresionRegular(RegularExpressionConstants.numeros);
		nroLactancia.setExpresionRegular(RegularExpressionConstants.numeros);
	}
	
	
	public void limpiarControles() {
		nroCeloServicio.setText("");
		nroLactancia.setText("");
		
		cmbVaca.setSelectedIndex(0);
		cmbTipo.setSelectedIndex(0);
		cmbToro.setSelectedIndex(0);
		cmbTipoServicio.setSelectedIndex(0);
		cmbInseminador.setSelectedIndex(0);
		
	}
	
	void initTable(){
		lstCelosServicios.removeAllRows();
		
		lstCelosServicios.setHTML(0,0,"Id");
		lstCelosServicios.setText(0, 1, "RP");
		lstCelosServicios.setText(0, 2, "Nro");
		lstCelosServicios.setText(0, 3, "Lact");
		lstCelosServicios.setText(0, 4, "Evento");
		lstCelosServicios.setText(0, 5, "Toro");
		lstCelosServicios.setText(0, 6, "Tipo Serv.");
		lstCelosServicios.setText(0, 7, "Inseminador");
		lstCelosServicios.setText(0, 8, "Accion");

		lstCelosServicios.setCellPadding(0);
		lstCelosServicios.setCellSpacing(0);
		lstCelosServicios.getRowFormatter().addStyleName(0, "header");
		
		//Ver de llamar con la fecha en cuestion.
		//listener.inicializarCelosServicios(lstCelosServicios, fecha);
		
		
		
	}

	public void visibilizarControlesParaServicio(boolean b) {
		// Hace visible o invisible los controles especificos de carga de servicio
		lblToro.setVisible(b);
		cmbToro.setVisible(b);
		lblTipoServicio.setVisible(b);
		cmbTipoServicio.setVisible(b);
		lblInseminador.setVisible(b);
		cmbInseminador.setVisible(b);
		
	}

	
}
