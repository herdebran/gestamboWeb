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
package ar.com.cristal.creditos.client.ui;


import ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDPlace;
import ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesPlace;
import ar.com.cristal.creditos.client.tambo.animales.alta.AltaAnimalesPlace;
import ar.com.cristal.creditos.client.ui.establecimientos.SeleccionEstablecimientoActivity;
import ar.com.cristal.creditos.client.ui.establecimientos.SeleccionEstablecimientoPlace;
import ar.com.cristal.creditos.client.ui.sucursales.ABMSucursalPlace;
import ar.com.cristal.creditos.client.ui.sucursales.ProcesosAdminPlace;
import ar.com.cristal.creditos.client.ui.usuarios.listado.ListadoUsuariosPlace;
import ar.com.cristal.creditos.client.ui.usuarios.pass.CambioPasswordUsuarioPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.core.client.GWT;
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
public class MenuView extends Composite  implements IsWidget {
  
	interface Binder extends UiBinder<Widget, MenuView> {
	}
	
	public interface Presenter {
		/**
		 * Navigate to a new Place in the bro.
		 */
		void goTo(Place place);

		void mostarSeelccionEstablecimiento();
	}
	
		
	
	private static final Binder binder = GWT.create(Binder.class);

	private Presenter listener;	
	
	
	
	@UiField
	Anchor mensajes;
	
	
	 
	 
	
	@UiField
	Anchor anchorUsuarioLogueado;
	
	@UiField	
	Anchor anchorEstablecimientoActual;
	
	private Long idSolicitudMensaje = null;

	public MenuView() {
		initWidget(binder.createAndBindUi(this));
		mensajes.addStyleName("mensajeEvento");
	}

	
	public void setName(String name) {
//		button.setHTML(name);
	}

	public void setPresenter(Presenter listener) {
		this.listener = listener;
	}

	
	@UiHandler("perfilesABM")
	void onABMPerfilesClick(ClickEvent event) {
		Place newPlace = new PerfilesCRUDPlace(null);
		listener.goTo(newPlace);
	}
	
	
	
	public Anchor getMensajes(){
		
		return mensajes;
		
	}
	
	/*   MENU TAMBO                        */
	@UiHandler("mnuAltaAnimales")
	void onAltaAnimalesClick(ClickEvent event) {
		Place newPlace = new AltaAnimalesPlace(null);
		listener.goTo(newPlace);
	}
	

	@UiHandler("anchorUsuarios")
	void onUsuariosClick(ClickEvent event) {
		Place newPlace = new ListadoUsuariosPlace(null);
		listener.goTo(newPlace);
	}
	
	
	@UiHandler("anchorBusquedaClientes")
	void onBusquedaClientesClick(ClickEvent event){
		Place newPlace = new BusquedaClientesPlace("");
		listener.goTo(newPlace);
	}

	
	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitudMensaje = idSolicitud;	
	}
	
	@UiHandler("cambioPassword")
	void onCambioPassword(ClickEvent event) {
		Place newPlace = new CambioPasswordUsuarioPlace("");
		listener.goTo(newPlace);
	}

	
	
	@UiHandler("anchorSucursales")
	void onClickSucursales(ClickEvent event) {
		Place newPlace = new ABMSucursalPlace("");
		listener.goTo(newPlace);
	}

	@UiHandler("anchorProcesos")
	void onClickProcesos(ClickEvent event) {
		Place newPlace = new ProcesosAdminPlace("");
		listener.goTo(newPlace);
	}

	@UiHandler("anchorEstablecimientoActual")
	void onClickAnchorEstablecimientoActual(ClickEvent event) {
		listener.mostarSeelccionEstablecimiento();
	}


	
	public Anchor getAnchorEstablecimientoActual(){
		return anchorEstablecimientoActual;
	}
}
