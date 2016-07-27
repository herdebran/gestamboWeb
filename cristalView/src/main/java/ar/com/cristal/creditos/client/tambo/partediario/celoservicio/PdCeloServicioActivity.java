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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.dto.TipoCeloServicioEnumDTO;
import ar.com.cristal.creditos.client.tambo.dto.CeloServicioDTO;
import ar.com.cristal.creditos.client.tambo.dto.InseminadorDTO;
import ar.com.cristal.creditos.client.tambo.dto.TipoServicioDTO;
import ar.com.cristal.creditos.client.tambo.dto.ToroDTO;
import ar.com.cristal.creditos.client.tambo.dto.VacaDTO;
import ar.com.cristal.creditos.client.ui.home.HomePlace;
import ar.com.cristal.creditos.client.ui.util.ClientContext;
import ar.com.cristal.creditos.client.ui.util.ConstantesView;
import ar.com.cristal.creditos.client.ui.util.CustomAbstractActivity;
import ar.com.cristal.creditos.client.ui.util.InicializarCombos;
import ar.com.cristal.creditos.client.ui.util.PopUpInfo;
import ar.com.cristal.creditos.client.widget.CustomSiNoDialogBox;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTMLTable.Cell;

/**
 * Activities are started and stopped by an ActivityManager associated with a container Widget.
 */
public class PdCeloServicioActivity extends CustomAbstractActivity implements PdCeloServicioView.Presenter {

	
	private ClientFactory clientFactory;
	public PopUpInfo popup=null;
	private PdCeloServicioView view;
	private String token;
	private Place place = null;
	private HandlerRegistration handlerRegistrationAdd;
	private final String ID_COMPONENTE_ACTIVITY = "PD_CELOSYSERVICIOS";
	private long tiempo = new Date().getTime();
	private Date fechaParteDiario;
	
	public PdCeloServicioActivity(PdCeloServicioPlace place, ClientFactory cf) {
		clientFactory = cf;
		popup = clientFactory.getPopUp();				
		view = clientFactory.getPdCeloServicioView();
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
			view.initTable();
			cargarCelosServicios(fechaParteDiario);
			inicializarCombos();
			view.visibilizarControlesParaServicio(false);
			
			//if (token == null || token.isEmpty() || token.equalsIgnoreCase("null")){
	
		} catch (Exception e) {
			popup.mostrarMensaje("Error", "No se pudo inicializar los controles");
		}
		
		
	}

	/**
	 * Recupera los celos y servicios de la fecha y los muestra en la grilla
	 * @param date
	 */
	private void cargarCelosServicios(Date fecha) {
		popup.mostrarMensaje("Espere", "Obteniendo celos y servicios...");
		clientFactory.getVacasService().obtenerCelosServiciosPorFechaRPC(fecha, 
				new AsyncCallback<List<CeloServicioDTO>>(){

					@Override
					public void onFailure(Throwable e) {
						popup.mostrarMensaje("Atencion", "Ha ocurrido un error: " + e.getMessage());
						
					}

					@Override
					public void onSuccess(List<CeloServicioDTO> lista) {
						view.initTable();
						for (CeloServicioDTO c:lista){
							agregarCeloServicioATabla(c);							
						}
						popup.ocultar();
						
					}
			
		});
		
		
	}


	/**
	 * El goTo place es cambiado para dar el comportamiento deseado por la pantalla:
	 * Primero se ubica la operación que se esta tratando de hacer para luego verificar si el cliente y/o el credito
	 * cumplen con las precondiciones. Luego se redirige en caso positivo o se muestra un mensaje de error en caso contrario.
	 * 
	 * @author lucas.napoli
	 * @see PdCeloServicioView.Presenter#goTo(Place)
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
		fechaParteDiario=new Date();
		tiempo = new Date().getTime();
		inicializarControles();
		view.anchorCelosServicios.getElement().getStyle().setBackgroundColor("#006AA4");
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


	@Override
	public void onGuardar() {
		// TODO Auto-generated method stub
		
	}

	private void inicializarCombos() {
		InicializarCombos.inicializarComboVacas(null, view.cmbVaca);
		InicializarCombos.inicializarComboToros(null, view.cmbToro);
		InicializarCombos.InicializarComboTipoCeloServicio(view.cmbTipo);
		InicializarCombos.inicializarComboInseminadores(null, view.cmbInseminador);
		InicializarCombos.inicializarComboTiposServicio(null, view.cmbTipoServicio);
	}

	@Override
	public void onAgregarCeloServicio() {
		List<String> errores = new ArrayList<String>();
		boolean datosValidos=validarDatos(errores);
		if (datosValidos){
			CeloServicioDTO csDTO=armarCeloServicioDTO();
			popup.mostrarMensaje("Espere", "Insertando novedad...");
			clientFactory.getVacasService().insertarCeloServicioRPC(csDTO,true, new AsyncCallback<CeloServicioDTO>() {

				@Override
				public void onFailure(Throwable e) {
					popup.mostrarMensaje("Ha ocurrido un error: " + e.getMessage());
				}

				@Override
				public void onSuccess(CeloServicioDTO r) {
					view.limpiarControles();
					cargarCelosServicios(fechaParteDiario);
				}
				
			});
			
		} else {
			popup.mostrarMensaje("Error", errores);
		}
	}
	



	/**
	 * Devuelve el DTO armado con los datos de la pantalla
	 * @return
	 */
	private CeloServicioDTO armarCeloServicioDTO() {
		CeloServicioDTO result= new CeloServicioDTO();

		result.setEliminado(false);
		result.setFecha(fechaParteDiario);
		result.setEstablecimiento(ClientContext.getInstance().getUsuarioLogueadoDTO().getEstablecimientoActual());
		result.setInseminador((view.cmbInseminador.isVisible() && view.cmbInseminador.getSelectedItem()!=null)?(InseminadorDTO) view.cmbInseminador.getSelectedItem():null);
		result.setLactancia(Integer.valueOf(view.nroLactancia.getText()));
		result.setNroCeloServicio(Integer.valueOf(view.nroCeloServicio.getText()));
		result.setObservaciones("");
		result.setTipo((TipoCeloServicioEnumDTO) view.cmbTipo.getSelectedItem());
		result.setTipoServicio(view.cmbTipoServicio.isVisible()?(TipoServicioDTO) view.cmbTipoServicio.getSelectedItem():null);
		result.setToro((view.cmbToro.isVisible() && view.cmbToro.getSelectedItem()!=null)?(ToroDTO) view.cmbToro.getSelectedItem():null);
		result.setVaca((VacaDTO) view.cmbVaca.getSelectedItem());
		
		return result;
	}


	private boolean validarDatos(List<String> mensajeError) {
		boolean result = true;
		try {

			mensajeError.clear();

			// valida RP
			if (view.cmbVaca.getSelectedItemText().length() == 0) {
				result = false;
				mensajeError.add("El RP es un campo obligatorio.");
			}

			// valida Nro
			if (view.nroCeloServicio.getText().isEmpty()) {
				result = false;
				mensajeError.add("El Nro es un campo obligatorio.");
			
			}

			// valida Lactancia
			if (view.nroLactancia.getText().isEmpty()) {
				result = false;
				mensajeError.add("Lactancia es un campo obligatorio.");
			}

			// valida Evento
			if (view.cmbTipo.getSelectedItemText().length() == 0) {
				result = false;
				mensajeError.add("El evento es un campo obligatorio.");
			}

			// Si es Servicio, valida Toro
			if (view.cmbToro.isVisible() && view.cmbToro.getSelectedItemText().length() == 0) {
				result = false;
				mensajeError.add("El Toro es un campo obligatorio para cargar un servicio.");
			}
			
		} catch (Exception e) {
			mensajeError.add("Error: " + e.getMessage());
			result = false;
		}

		return result;
	}

	private void agregarCeloServicioATabla(CeloServicioDTO c) {
		int i= view.lstCelosServicios.getRowCount()-1;
		
		view.lstCelosServicios.setText(i+1, 0, String.valueOf(c.getId()));
		view.lstCelosServicios.setText(i+1, 1, c.getVaca().getRp());
		view.lstCelosServicios.setText(i+1, 2, String.valueOf(c.getNroCeloServicio()));
		view.lstCelosServicios.setText(i+1, 3, String.valueOf(c.getLactancia()));
		view.lstCelosServicios.setText(i+1, 4, c.getTipo().getItemText());
		view.lstCelosServicios.setText(i+1, 5, (c.getToro()!=null)?c.getToro().getNombre():"");
		view.lstCelosServicios.setText(i+1, 6, (c.getTipoServicio() != null)?c.getTipoServicio().getDescripcion(): "");
		view.lstCelosServicios.setText(i+1, 7, (c.getInseminador()!=null)?c.getInseminador().getItemText():"");
		
		//Boton Elimimnar
		Button cmdEliminarCeloServicio=new Button("Eliminar");
		cmdEliminarCeloServicio.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Cell cellSelected =  view.lstCelosServicios.getCellForEvent(event);
				int rowSelected=cellSelected.getRowIndex();
				Long idCeloServicio= Long.valueOf(view.lstCelosServicios.getText(rowSelected, 0));
				eliminarCeloServicio (idCeloServicio);
			}
		});
		view.lstCelosServicios.setWidget(i+1, 8, cmdEliminarCeloServicio);
		
		
		if (i % 2 == 0) {
			view.lstCelosServicios.getRowFormatter().addStyleName(i+1, "TableRow1Pointer");
		} else {				
			view.lstCelosServicios.getRowFormatter().addStyleName(i+1, "TableRow2Pointer");
		}

	}

	/**
	 * Llama al RPC que borra el servicio y refresca la grilla 
	 */
	  
	private void eliminarCeloServicio(final Long idCeloServicio) {
		final DialogBox dialogbox = CustomSiNoDialogBox.dialogBox("Atención", "¿Está seguro de eliminar el evento?");
		ClickHandler listenerNo = new ClickHandler() {
			
			public void onClick(ClickEvent arg0) {
				dialogbox.hide();		
			}
		};
		
		ClickHandler listenerSi = new ClickHandler() {
			
			public void onClick(ClickEvent arg0) {
				dialogbox.hide();
				popup.mostrarMensaje("Espere","Eliminando el evento...");
				clientFactory.getVacasService().eliminarCeloServicioPorIdRPC(idCeloServicio,true,new AsyncCallback<CeloServicioDTO>() {

					@Override
					public void onFailure(Throwable e) {
						popup.mostrarMensaje("Atención","Ha ocurrido un error al eliminar el evento.");
					}

					@Override
					public void onSuccess(CeloServicioDTO result) {
						popup.ocultar();
						cargarCelosServicios(fechaParteDiario);
					}
				});
			}
		};
	
		CustomSiNoDialogBox.setHandlers(listenerSi, listenerNo);
		
	}
	
}
