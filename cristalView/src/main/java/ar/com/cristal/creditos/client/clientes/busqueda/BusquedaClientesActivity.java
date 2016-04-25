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

import java.util.Date;
import java.util.List;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.clientes.alta.ClientePlace;
import ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClientePlace;
import ar.com.cristal.creditos.client.dto.ClienteDTO;
import ar.com.cristal.creditos.client.ui.util.ClientContext;
import ar.com.cristal.creditos.client.ui.util.ConstantesView;
import ar.com.cristal.creditos.client.ui.util.CustomAbstractActivity;
import ar.com.cristal.creditos.client.ui.util.PopUpInfo;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RadioButton;


/**
 * Activities are started and stopped by an ActivityManager associated with a container Widget.
 */
public class BusquedaClientesActivity extends CustomAbstractActivity implements BusquedaClientesView.Presenter {

	
	private ClientFactory clientFactory;
	public PopUpInfo popup=null;
	private ClientContext clientContext = ClientContext.getInstance();
	BusquedaClientesView view;

	
	private final String ID_COMPONENTE_ACTIVITY = "BUSQUEDA_CLIENTES";

	public BusquedaClientesActivity(BusquedaClientesPlace place, ClientFactory cf) {
		Log.info("Inicio BusquedaClientesActivity");
		clientFactory = cf;
		popup = clientFactory.getPopUp();		
		view = clientFactory.getBusquedaClientesView();
		view.inicializarControles();
		
	}

	
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		
		super.start(containerWidget, eventBus, ID_COMPONENTE_ACTIVITY);
		view.setPresenter(this);
		containerWidget.setWidget(view.asWidget());
		view.limpiarTabla();
		view.limpiarDatosCliente();
		view.initTable();
		view.resetBotones(true);
	}

	@Override
	public String mayStop() {
		return null;
	}

	
	/**
	 * El goTo place es cambiado para dar el comportamiento deseado por la pantalla:
	 * Primero se ubica la operación que se esta tratando de hacer para luego verificar si el cliente y/o el credito
	 * cumplen con las precondiciones. Luego se redirige en caso positivo o se muestra un mensaje de error en caso contrario.
	 * 
	 * @author lucas.napoli
	 * @see BusquedaClientesView.Presenter#goTo(Place)
	 */
	public void goTo(final Place place) {
		if (place instanceof OperacionesHistorialCreditosClientePlace && view.obtenerIdSeleccionado() == ""){
			popup.mostrarMensaje("No se ha seleccionado ningún cliente de la lista");
		}else{
			clientFactory.getPlaceController().goTo(place);
		}
		
	}

	
	public void irAOperaciones(String idCliente){
		Place operaciones = new OperacionesHistorialCreditosClientePlace(idCliente);
		clientFactory.getPlaceController().goTo(operaciones);
	}
	
	
	/***
	 * Carga inicial de la tabla de creditos del cliente
	 */
	public void buscarClientes(final FlexTable tabla){
		
		
		
		//IF Todos los campos vacios
		//view.setVisible(false);
		String param = "";
		if (view.rpAnimal.getText() == "" && view.rcAnimal.getText() == "" ){
			popup.mostrarMensaje("No se ha ingresado ningún dato para la búsqueda de Animales.");
		}else{
			if (! view.rpAnimal.getText().isEmpty()){
				param = "rp_"+view.rpAnimal.getText();
			}else if(! view.rcAnimal.getText().isEmpty()){
				param = "rc_"+view.rcAnimal.getText();
			}
			}
		
		
		Log.debug(getClientContext().getUsuarioLogueadoDTO().getNombreUsuarioSessionId() +  " - Boton Buscar: " + param);
		
		popup.mostrarMensaje("Buscando Animales... espere un momento por favor.");
			//TODO: llamar al servicio que te levanta todo
		final Long tiempoOriginal = new Date().getTime();
		view.buttonBuscar.setEnabled(false);
			clientFactory.getClientesService().obtenerClientesByParam(param,new AsyncCallback<List<ClienteDTO>>() {
				
				public void onSuccess(List<ClienteDTO> clientes) {
					Log.debug(getClientContext().getUsuarioLogueadoDTO().getNombreUsuarioSessionId() +  " - Boton Buscar: respuesta ok " + (new Date().getTime() - tiempoOriginal) / 1000);
					long tiempoActual = new Date().getTime();
					//popup.mostrarMensaje("Tiempo consumido al obtener clientes asincrono: " + tiempoActual );
					//view.setVisible(true);
					popup.ocultar();
					mostrarClientes(tabla, clientes);
					view.buttonBuscar.setEnabled(true);
					Log.debug(getClientContext().getUsuarioLogueadoDTO().getNombreUsuarioSessionId() +  " - Tiempo tomado para mostrar los resultados [s]: " +  (new Date().getTime() - tiempoActual)/1000);
					
				}
	
				
				
				public void onFailure(Throwable arg) {
					popup.mostrarMensaje("Error: ", arg.getMessage());
					view.buttonBuscar.setEnabled(true);
				}
	
			});
	}
	
	
		
	private void mostrarClientes(final FlexTable tabla,
			List<ClienteDTO> clientes) {
		int i=0;
		view.initTable();
		if (clientes.isEmpty()){
			popup.mostrarMensaje("No se encontró ningún cliente con la búsqueda ingresada.");
		} 
		
		if (clientes.size() > 5){
			view.divTabla.setAttribute("class", "divScroll");
 		} else {
 			view.divTabla.setAttribute("class", "divNoScroll");
 		}
		
		for (ClienteDTO cli : clientes){
			
			final RadioButton radio = new RadioButton("busquedaClientesGroup");
			radio.addClickHandler(new ClickHandler() {		
				public void onClick(ClickEvent e) {
					String idCli =  view.obtenerIdSeleccionado();

				}			
			});
			
		    tabla.setWidget(i+1,0, radio);
		    tabla.setText(i+1,1, cli.getId().toString());
		    tabla.setText(i+1,2, cli.getApellido());
		    tabla.setText(i+1,3, cli.getNombre());			
			tabla.setText(i+1,4, cli.getDni());
			tabla.setText(i+1,5, cli.getTelefono() == null ? "" : cli.getCaracteristica() == null ? "" : cli.getCaracteristica() + cli.getTelefono());
			tabla.setText(i+1,6, cli.getEstado());
			tabla.setText(i+1,7, cli.getNroCuenta() == null ? "" : cli.getNroCuenta().toString());
			tabla.setText(i+1,8, cli.getCondicionMorosidad() == null ? "" : cli.getCondicionMorosidad());
								
			if (i % 2 == 0) {
				tabla.getRowFormatter().addStyleName(i+1, ConstantesView.ESTILO_FILA1_PUNTERO);
			} else {				
				tabla.getRowFormatter().addStyleName(i+1, ConstantesView.ESTILO_FILA2_PUNTERO);
			}
			
			i++;
		}
		
		
		if (clientes.size() == 1){
			view.seleccionarUnicoCliente();
		}
		
	}



	private void habilitarBotones(boolean b){
//		view.buttonSeleccionar.setEnabled(b);
		view.buttonModificar.setEnabled(b);
	}

	public void irACliente(String idCliente) {
		view.limpiarTabla();
		view.limpiarDatosCliente();
		view.initTable();
		view.resetBotones(true);
		Place p = new ClientePlace(idCliente);
		clientFactory.getPlaceController().goTo(p);
		
	}


	@Override
	public void inicializarActivity() {
		//BusquedaClientesView view = clientFactory.getBusquedaClientesView();
		
		clientContext.setUsuarioLogueadoDTO(getClientContext().getUsuarioLogueadoDTO());
		
	}

	
	
}
