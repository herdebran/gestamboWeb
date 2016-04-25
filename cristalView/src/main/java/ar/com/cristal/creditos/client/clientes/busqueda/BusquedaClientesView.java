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
package ar.com.cristal.creditos.client.clientes.busqueda;

import ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClientePlace;
import ar.com.cristal.creditos.client.ui.util.RegularExpressionConstants;
import ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;

/**
 * View base interface.
 * Extends IsWidget so a view impl can easily provide its container widget.
 */
public class BusquedaClientesView extends Composite implements IsWidget{
  
	

	public interface Presenter {
		/**
		 * Navigate to a new Place in the browser.
		 */
		void goTo(Place place);
		
		void buscarClientes(FlexTable tabla);

		void irACliente(String idCliente);
		
		void irAOperaciones(String idCliente);

	}
	
	
	interface Binder extends UiBinder<Widget, BusquedaClientesView> {
	}
	
	private static final Binder binder = GWT.create(Binder.class);

	private static final int COLUMNA_RP_ANIMAL = 1;

	private Presenter listener;
	
	public Integer opcionElegida=0;  //TODO: sacar esto cuando tenga los nombres de los places
			
	@UiField(provided=true)
	FlexTable listadoAnimales = new FlexTable();
	
	
	@UiField
	Button buttonBuscar;
	
	@UiField
	Button buttonBorrar;
	
	@UiField
	Button buttonNuevo;
	
	@UiField
	RegExpTextBoxImpl rpAnimal;
	
	@UiField
	RegExpTextBoxImpl rcAnimal;
	
	@UiField
	Button buttonModificar;
	
	@UiField
	DivElement divTabla;
	
	@UiField
	Button buttonFichaVaca;

	public BusquedaClientesView() {
		initWidget(binder.createAndBindUi(this));
	
	}


	public void setPresenter(Presenter listener) {
		this.listener = listener;
	
	}

	
	
	@UiHandler("buttonNuevo")
	void onButtonNuevo(ClickEvent event) {
		listener.irACliente(null);
	}
	
	@UiHandler("buttonBuscar")
	void onButtonBuscarClick(ClickEvent event) {
		listener.buscarClientes(listadoAnimales);
	}
	
	
	@UiHandler("buttonModificar")
	void onButtonModificarClick(ClickEvent event) {
		String idString = obtenerIdSeleccionado();
		if (idString != null && !idString.isEmpty())
			listener.irACliente(idString);
		
	}
	
	public String obtenerIdSeleccionado() {
		for (int i = 1;i<listadoAnimales.getRowCount();i++){
			RadioButton radio = (RadioButton) listadoAnimales.getWidget(i, 0);
			if (radio.getValue()) return listadoAnimales.getText(i,COLUMNA_RP_ANIMAL);
		}
		return "";
	}

	public void limpiarDatosCliente(){
		rpAnimal.setText("");
		rcAnimal.setText("");
	}
	
	void initTable(){
		listadoAnimales.removeAllRows();
		
		listadoAnimales.setWidget(0, 0,null);
		listadoAnimales.setHTML(0,COLUMNA_RP_ANIMAL,"RP");
		listadoAnimales.getCellFormatter().setWidth(0, COLUMNA_RP_ANIMAL, "80");
		listadoAnimales.setHTML(0,2,"RC");
		listadoAnimales.setHTML(0,3,"Rodeo");		
		listadoAnimales.setHTML(0,4,"Estado Reprod.");
		listadoAnimales.setText(0,5,"Estado Prod.");
		listadoAnimales.setText(0,6,"Ult. Parto");
		listadoAnimales.setText(0,7,"Ult. Servicio");
		
		listadoAnimales.setCellPadding(0);
		listadoAnimales.setCellSpacing(0);
		listadoAnimales.getRowFormatter().addStyleName(0, "header");
	}
	
	public void limpiarTabla() {
		for (int i = 0;i<listadoAnimales.getRowCount();i++){
			listadoAnimales.removeRow(i);
		}
	}

	public void resetBotones(boolean b){
		buttonModificar.setEnabled(b);
		buttonNuevo.setEnabled(b);
	}
	
	public void inicializarControles() {
		rpAnimal.setExpresionRegular(RegularExpressionConstants.letras);
		rcAnimal.setExpresionRegular(RegularExpressionConstants.letras);		
	}
	
	
	public void seleccionarUnicoCliente(){
		if (listadoAnimales.getRowCount() > 1){
			RadioButton radio = (RadioButton) listadoAnimales.getWidget(1, 0);
			radio.setValue(true);
			
			String idSeleccionado = obtenerIdSeleccionado();
			Place newPlace = new OperacionesHistorialCreditosClientePlace(idSeleccionado);
			listener.goTo(newPlace);
		}
	}
	
	
	@UiHandler("rpAnimal")
	void onRpKeyPress(KeyUpEvent event){
		if (KeyCodes.KEY_ENTER == event.getNativeKeyCode())
			listener.buscarClientes(listadoAnimales);
	}
	
	
	@UiHandler("rcAnimal")
	void onRcKeyPress(KeyUpEvent event){
		if (KeyCodes.KEY_ENTER == event.getNativeKeyCode())
			listener.buscarClientes(listadoAnimales);
	}
	
	
	@UiHandler("listadoAnimales")
	void onTableClick(ClickEvent event) {
		Cell cellSelected =  listadoAnimales.getCellForEvent(event);
        int row = cellSelected.getRowIndex();
        if (row > 0) {
        	RadioButton radio = (RadioButton) listadoAnimales.getWidget(row, 0);
			radio.setValue(true); 
        }
	}
}
