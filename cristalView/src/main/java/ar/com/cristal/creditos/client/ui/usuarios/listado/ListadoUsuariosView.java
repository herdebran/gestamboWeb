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
package ar.com.cristal.creditos.client.ui.usuarios.listado;

import ar.com.cristal.creditos.client.ui.home.HomePlace;
import ar.com.cristal.creditos.client.ui.usuarios.abm.AltaEdicionUsuarioPlace;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * View base interface.
 * Extends IsWidget so a view impl can easily provide its container widget.
 */
public class ListadoUsuariosView extends Composite implements IsWidget {
  
	

	public interface Presenter {
		/**
		 * Navigate to a new Place in the browser.
		 */
		void goTo(Place place);
		
		void inicializarTabla(FlexTable tabla);

		void onTableClick(String text);
		
	}
	
	
	interface Binder extends UiBinder<Widget, ListadoUsuariosView> {
	}
	
	private static final Binder binder = GWT.create(Binder.class);

	private Presenter listener;
	
	
	@UiField(provided=true)
	FlexTable listadoUsuarios = new FlexTable();
	
	@UiField
	Button button;
	
	
	public ListadoUsuariosView() {
		initWidget(binder.createAndBindUi(this));
		
		
	}

	public void setName(String name) {
		
	}

	public void setPresenter(Presenter listener) {
		this.listener = listener;
	
	}

	@UiHandler("button")
	void onButtonClick(ClickEvent event) {
		Place newPlace = new HomePlace("Home");
		// TODO
		listener.goTo(newPlace);
	}

	


	void initTable(){
		listadoUsuarios.removeAllRows();
		
		listadoUsuarios.setHTML(0,0,"ID");
		listadoUsuarios.setHTML(0,1,"Apellido");
		listadoUsuarios.setHTML(0,2,"Nombre");
		listadoUsuarios.setHTML(0,3,"Nombre Usuario");
		listadoUsuarios.setText(0,4,"Perfil");
		listadoUsuarios.setText(0,5,"Sucursal");
		listadoUsuarios.setText(0,6,"Supervisor");
//		listadoUsuarios.setText(0,7,"Administrador");

		listadoUsuarios.setCellPadding(0);
		listadoUsuarios.setCellSpacing(0);
		listadoUsuarios.getRowFormatter().addStyleName(0, "header");
		
		listener.inicializarTabla(listadoUsuarios);
		
		
		
	}
	
	
	@UiHandler("listadoUsuarios")
	void onTableClick(ClickEvent event) {
		Cell cellSelected =  listadoUsuarios.getCellForEvent(event);
        int row = cellSelected.getRowIndex();
        if (row > 0) {
        	listener.onTableClick(listadoUsuarios.getText(row, 0));
        }
	}

	
	@UiHandler("nuevo")
	void onNuevoClick(ClickEvent event) {
		Place newPlace = new AltaEdicionUsuarioPlace(null);
		listener.goTo(newPlace);
	}
	
}
