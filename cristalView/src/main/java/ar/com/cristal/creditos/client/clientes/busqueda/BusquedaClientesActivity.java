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
import ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClientePlace;
import ar.com.cristal.creditos.client.tambo.animales.alta.AltaAnimalesPlace;
import ar.com.cristal.creditos.client.tambo.dto.VacaDTO;
import ar.com.cristal.creditos.client.ui.util.ClientContext;
import ar.com.cristal.creditos.client.ui.util.ConstantesView;
import ar.com.cristal.creditos.client.ui.util.CustomAbstractActivity;
import ar.com.cristal.creditos.client.ui.util.InicializarCombos;
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
			popup.mostrarMensaje("No se ha seleccionado ningún animal de la lista");
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
	public void buscarVacas(final FlexTable tabla){
		String param = "";
		if (view.rpAnimal.getText() == "" && view.rcAnimal.getText() == "" && view.cmbRodeo.getSelectedItemText().equals("")){
			popup.mostrarMensaje("No se ha ingresado ningún dato para la búsqueda de Animales.");
		}else{
			if (! view.rpAnimal.getText().isEmpty()){
				param = "rp_"+view.rpAnimal.getText();
			}else if(! view.rcAnimal.getText().isEmpty()){
				param = "rc_"+view.rcAnimal.getText();
			}else if (! view.cmbRodeo.getSelectedItemId().isEmpty()){
				param = "rodeo_"+view.cmbRodeo.getSelectedItemId();
			}
		}
		
		
		Log.debug(getClientContext().getUsuarioLogueadoDTO().getNombreUsuarioSessionId() +  " - Boton Buscar: " + param);
		
		popup.mostrarMensaje("Buscando Animales... espere un momento por favor.");
			//TODO: llamar al servicio que te levanta todo
		final Long tiempoOriginal = new Date().getTime();
		view.buttonBuscar.setEnabled(false);
		clientFactory.getVacasService().obtenerVacasByParam(param, new AsyncCallback<List<VacaDTO>>(){
			
				public void onSuccess(List<VacaDTO> vacas) {
					Log.debug(getClientContext().getUsuarioLogueadoDTO().getNombreUsuarioSessionId() +  " - Boton Buscar: respuesta ok " + (new Date().getTime() - tiempoOriginal) / 1000);
					long tiempoActual = new Date().getTime();
					popup.ocultar();
					mostrarVacas(tabla, vacas);
					view.buttonBuscar.setEnabled(true);
					Log.debug(getClientContext().getUsuarioLogueadoDTO().getNombreUsuarioSessionId() +  " - Tiempo tomado para mostrar los resultados [s]: " +  (new Date().getTime() - tiempoActual)/1000);
					
				}
	
				
				
				public void onFailure(Throwable arg) {
					popup.mostrarMensaje("Error: ", arg.getMessage());
					view.buttonBuscar.setEnabled(true);
				}
	
			});
	}
	
	
		
	private void mostrarVacas(final FlexTable tabla,
			List<VacaDTO> vacas) {
		int i=0;
		view.initTable();
		if (vacas.isEmpty()){
			popup.mostrarMensaje("No se encontró ningún animal con la búsqueda ingresada.");
		} 
		
		if (vacas.size() > 5){
			view.divTabla.setAttribute("class", "divScroll");
 		} else {
 			view.divTabla.setAttribute("class", "divNoScroll");
 		}
		
		for (VacaDTO v : vacas){
			
			final RadioButton radio = new RadioButton("busquedaClientesGroup");
			radio.addClickHandler(new ClickHandler() {		
				public void onClick(ClickEvent e) {
					String idCli =  view.obtenerIdSeleccionado();

				}			
			});
			
		    tabla.setWidget(i+1,0, radio);
		    tabla.setText(i+1,1, v.getRp());
		    tabla.setText(i+1,2, v.getRc());
		    tabla.setText(i+1,3, v.getRodeo_id().toString());			
			tabla.setText(i+1,4, v.getEstadoReproductivo().name());
			tabla.setText(i+1,5, v.getEstadoProductivo().name());
			tabla.setText(i+1,6, "Ultimo parto!");
			tabla.setText(i+1,7, "Ultimom Servicio!");
			tabla.setText(i+1,8, v.getId().toString());
			tabla.getCellFormatter().setVisible(i+1, 8, false);

			if (i % 2 == 0) {
				tabla.getRowFormatter().addStyleName(i+1, ConstantesView.ESTILO_FILA1_PUNTERO);
			} else {				
				tabla.getRowFormatter().addStyleName(i+1, ConstantesView.ESTILO_FILA2_PUNTERO);
			}
			
			i++;
		}
		
		/*
		if (vacas.size() == 1){
			view.seleccionarUnicoCliente();
		}
		*/
	}



	private void habilitarBotones(boolean b){
		view.buttonModificar.setEnabled(b);
	}

	public void irAbmAnimal(String idVaca) {
		view.limpiarTabla();
		view.limpiarDatosCliente();
		view.initTable();
		view.resetBotones(true);
		Place p = new AltaAnimalesPlace(idVaca);
		clientFactory.getPlaceController().goTo(p);
	}


	@Override
	public void inicializarActivity() {
		clientContext.setUsuarioLogueadoDTO(getClientContext().getUsuarioLogueadoDTO());
		InicializarCombos.inicializarComboRodeos("", view.cmbRodeo);
		view.cmbRodeo.addItem("","");
		view.cmbRodeo.selectByText("");
	}
 

	@Override
	public void irFichaVaca(String idString) {
		popup.mostrarMensaje("Sin implementar","Te llevaria a la ficha del animal "+ idString);
		
	}

	
	
}
