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
package ar.com.cristal.creditos.client.partediario;

import java.util.Date;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.dto.ClienteDTO;
import ar.com.cristal.creditos.client.ui.home.HomePlace;
import ar.com.cristal.creditos.client.ui.util.ClientContext;
import ar.com.cristal.creditos.client.ui.util.ConstantesView;
import ar.com.cristal.creditos.client.ui.util.CustomAbstractActivity;
import ar.com.cristal.creditos.client.ui.util.PopUpInfo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Activities are started and stopped by an ActivityManager associated with a container Widget.
 */
public class ParteDiarioActivity extends CustomAbstractActivity implements ParteDiarioView.Presenter {

	
	private ClientFactory clientFactory;
	public PopUpInfo popup=null;
	private ParteDiarioView view;
	private String token;
	private Place place = null;
	private HandlerRegistration handlerRegistrationAdd;
	private final String ID_COMPONENTE_ACTIVITY = "PARTE_DIARIO";
	private long tiempo = new Date().getTime();
	
	public ParteDiarioActivity(ParteDiarioPlace place, ClientFactory cf) {
		clientFactory = cf;
		popup = clientFactory.getPopUp();				
		view = clientFactory.getParteDiarioView();
		view.limpiarControles();
		view.setWidth(ConstantesView.maxPanelWidthPixels);
		token = place.getToken();
		this.place = place;
	}

	
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		
		super.start(containerWidget, eventBus, ID_COMPONENTE_ACTIVITY);
		view.setPresenter(this);

		view.clienteDiv.setInnerText("Carga de parte diario");
		
		containerWidget.setWidget(view.asWidget());
		
	}


	@Override
	public String mayStop() {
		return null;
	}

	private void inicializarControles() {
		try {
			view.limpiarControles();	
	
			
			//if (token == null || token.isEmpty() || token.equalsIgnoreCase("null")){
	
		} catch (Exception e) {
			popup.mostrarMensaje("Error", "No se pudo inicializar los controles");
		}
		
		
	}

	
	/**
	 * El goTo place es cambiado para dar el comportamiento deseado por la pantalla:
	 * Primero se ubica la operación que se esta tratando de hacer para luego verificar si el cliente y/o el credito
	 * cumplen con las precondiciones. Luego se redirige en caso positivo o se muestra un mensaje de error en caso contrario.
	 * 
	 * @author lucas.napoli
	 * @see ParteDiarioView.Presenter#goTo(Place)
	 */
	public void goTo(final Place place) {
		
			clientFactory.getPlaceController().goTo(place);
		
	}


	public void onCerrar() {
		Place place = new HomePlace("");
		clientFactory.getPlaceController().goTo(place);
		
	}





	
	public void cambioDePestaña(final Place place){
		if (place != null)
			clientFactory.getPlaceController().goTo(place);
 
	}
	
	
	
	
	
	@Override
	public void inicializarActivity() {
		System.out.println("Tiempo de validación de permisos y usuario [ms]: " + (new Date().getTime() - tiempo));
		tiempo = new Date().getTime();
		inicializarControles();
		view.anchorCelosServicios.getElement().getStyle().setBackgroundColor("#006AA4");		
	}


	@Override
	public ClienteDTO getClienteActual() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void irCelosServicios() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void irPartos() {
		popup.mostrarMensaje("Ir a Partos");
		
	}


	@Override
	public void irIngresosSecadas() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void irSuplementacion() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void irSanidad() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void irBajas() {
		// TODO Auto-generated method stub
		
	}


}
