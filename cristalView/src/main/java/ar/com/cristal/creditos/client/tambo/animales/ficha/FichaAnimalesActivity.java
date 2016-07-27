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

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.clientes.alta.ClienteView;
import ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesPlace;
import ar.com.cristal.creditos.client.tambo.dto.FichaVacaDTO;
import ar.com.cristal.creditos.client.tambo.dto.VacaDTO;
import ar.com.cristal.creditos.client.ui.util.ConstantesView;
import ar.com.cristal.creditos.client.ui.util.CustomAbstractActivity;
import ar.com.cristal.creditos.client.ui.util.PopUpInfo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Activities are started and stopped by an ActivityManager associated with a container Widget.
 */
public class FichaAnimalesActivity extends CustomAbstractActivity implements FichaAnimalesView.Presenter {

	
	private ClientFactory clientFactory;
	public PopUpInfo popup=null;
	private FichaAnimalesView view;
	private String token;
	private FichaVacaDTO fichaActual = null;
	private Place place = null;
	private HandlerRegistration handlerRegistrationAdd;
	private final String ID_COMPONENTE_ACTIVITY = "ABM_ANIMALES";

	private long tiempo = new Date().getTime();
	
	public FichaAnimalesActivity(FichaAnimalesPlace place, ClientFactory cf) {
		clientFactory = cf;
		popup = clientFactory.getPopUp();				
		view = clientFactory.getFichaAnimalesView();
		view.limpiarControles();
		view.setWidth(ConstantesView.maxPanelWidthPixels);
		token = place.getToken();
		this.place = place;
	}

	
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		
		super.start(containerWidget, eventBus, ID_COMPONENTE_ACTIVITY);
		view.setPresenter(this);

		view.clienteDiv.setInnerText("Ficha Animal");
		
		containerWidget.setWidget(view.asWidget());
		
	}


	@Override
	public String mayStop() {
		return null;
	}

	private void inicializarControles() {
		try {
			view.limpiarControles();	
			inicializarCombos();
			
			if (token == null || token.isEmpty() || token.equalsIgnoreCase("null")){
				popup.mostrarMensaje("Atención","No seleccionó ningún animal.");				

			} else {
				
				if (token != null && !token.isEmpty()){
						popup.mostrarMensaje("Espere","Cargando datos del animal...");
						clientFactory.getVacasService().armarFichaDTOPorIdVaca(Long.valueOf(token), new AsyncCallback<FichaVacaDTO>() {
							public void onSuccess(FichaVacaDTO c) {
								fichaActual = c;
								cargarDatosVaca(c);
							}
							
							

							public void onFailure(Throwable e) {
								popup.mostrarMensaje("Error", "Error al intentar obtener el animal: "  + e.getMessage());
							}
						});
					}
					
				}
		} catch (Exception e) {
			popup.mostrarMensaje("Error", "No se pudieron inicializar los controles");
		}
		
		
	}

	
	private void inicializarCombos() {
		//Inicializo combos
	}


	private void cargarDatosVaca(FichaVacaDTO c) {
		
		try {
			view.clienteDiv.setInnerText("Ficha Animal RP " + c.getRp());
			
			//Campos de texto
			view.rp.setText(c.getRp());
			view.lblRaza.setText(c.getRaza());
			view.lblPadre.setText(c.getNombrePadre());
			view.lblMadre.setText(c.getRpMadre());
			view.lblFNacim.setText(c.getFechaNacimiento().toString());
			view.lblRodeo.setText(c.getRodeo());
			view.lblEstadoProductivo.setText(c.getEstadoProductivo().name());
			view.lblEstadoReproductivo.setText(c.getEstadoReproductivo().name());
			view.lblEstadoSanitario.setText(c.getEstadoSanitario().name());
			view.lblDiasLactancia.setText("!");
			view.lblIntPartoPreniez.setText("!");
			view.lblIntPartoParto.setText("!");
			view.lblPrenieces1Serv.setText("!");
			view.lblServiciosPreniez.setText("!");
			view.lblFechaUS.setText(c.getFechaUltimoServicio().toString());
			view.lblToroUS.setText(c.getNombreToroUS());
			view.lblNroUS.setText(String.valueOf(c.getNroUS()));

			
			
			
		} catch (Exception e) {
			popup.mostrarMensaje("Error", "No se pudo cargar los datos del animal.");
		}
	}
	
	
	
	/**
	 * El goTo place es cambiado para dar el comportamiento deseado por la pantalla:
	 * Primero se ubica la operación que se esta tratando de hacer para luego verificar si el cliente y/o el credito
	 * cumplen con las precondiciones. Luego se redirige en caso positivo o se muestra un mensaje de error en caso contrario.
	 * 
	 * @author lucas.napoli
	 * @see ClienteView.Presenter#goTo(Place)
	 */
	public void goTo(final Place place) {
		
			clientFactory.getPlaceController().goTo(place);
	}




	public void onCerrar() {
		//TODO: Ver a donde dirigir cdo cierra
		fichaActual = null;
		Place place = new BusquedaClientesPlace("");
		clientFactory.getPlaceController().goTo(place);
		
	}


	@Override
	public void inicializarActivity() {
		popup.mostrarMensaje("Espere","Inicializando pantalla...");
		System.out.println("Tiempo de validación de permisos y usuario [ms]: " + (new Date().getTime() - tiempo));
		tiempo = new Date().getTime();
		inicializarControles();
		//view.anchorDatosPersonales.getElement().getStyle().setBackgroundColor("#006AA4");
		popup.ocultar();
	}



}
