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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.dto.EstadoCriaEnumDTO;
import ar.com.cristal.creditos.client.dto.SexoAnimalEnumDTO;
import ar.com.cristal.creditos.client.tambo.dto.CeloServicioDTO;
import ar.com.cristal.creditos.client.tambo.dto.PartoDTO;
import ar.com.cristal.creditos.client.tambo.dto.TipoPartoDTO;
import ar.com.cristal.creditos.client.tambo.dto.ToroDTO;
import ar.com.cristal.creditos.client.tambo.dto.VacaDTO;
import ar.com.cristal.creditos.client.tambo.partediario.celoservicio.PdCeloServicioPlace;
import ar.com.cristal.creditos.client.tambo.partediario.celoservicio.PdCeloServicioView;
import ar.com.cristal.creditos.client.ui.home.HomePlace;
import ar.com.cristal.creditos.client.ui.util.ClientContext;
import ar.com.cristal.creditos.client.ui.util.ConstantesView;
import ar.com.cristal.creditos.client.ui.util.CustomAbstractActivity;
import ar.com.cristal.creditos.client.ui.util.InicializarCombos;
import ar.com.cristal.creditos.client.ui.util.PopUpInfo;
import ar.com.cristal.creditos.client.widget.CustomSiNoDialogBox;
import ar.com.cristal.creditos.common.EstadoCriaEnum;

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
public class PdPartoActivity extends CustomAbstractActivity implements PdPartoView.Presenter {

	
	private ClientFactory clientFactory;
	public PopUpInfo popup=null;
	private PdPartoView view;
	private String token;
	private Place place = null;
	private HandlerRegistration handlerRegistrationAdd;
	private final String ID_COMPONENTE_ACTIVITY = "PD_CELOSYSERVICIOS";
	private long tiempo = new Date().getTime();
	private Date fechaParteDiario;
	
	public PdPartoActivity(PdPartoPlace place, ClientFactory cf) {
		clientFactory = cf;
		popup = clientFactory.getPopUp();				
		view = clientFactory.getPdPartoView();
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
			if (token != null && !token.isEmpty() && !token.equalsIgnoreCase("null")){
				fechaParteDiario=new Date (Long.valueOf(token));
				System.out.println(fechaParteDiario);
			}
			
			view.limpiarControles();	
			view.initTable();
			cargarPartos(fechaParteDiario);
			inicializarCombos();
			view.visibilizarControlesParto(false);
			
	
		} catch (Exception e) {
			popup.mostrarMensaje("Error", "No se pudo inicializar los controles");
		}
		
		
	}

	/**
	 * Recupera los partos de la fecha y los muestra en la grilla
	 * @param date
	 */
	private void cargarPartos(Date fecha) {
		popup.mostrarMensaje("Espere", "Obteniendo partos...");
		clientFactory.getVacasService().obtenerPartosPorFechaRPC(fecha, 
				new AsyncCallback<List<PartoDTO>>(){

					@Override
					public void onFailure(Throwable e) {
						popup.mostrarMensaje("Atencion", "Ha ocurrido un error: " + e.getMessage());
						
					}

					@Override
					public void onSuccess(List<PartoDTO> lista) {
						view.initTable();
						for (PartoDTO c:lista){
							agregarPartoATabla(c);							
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
		//fechaParteDiario=new Date();
		tiempo = new Date().getTime();
		inicializarControles();
		view.anchorPartos.getElement().getStyle().setBackgroundColor("#006AA4");
	}


	@Override
	public void irCelosServicios() {
		String fechaParam=String.valueOf(fechaParteDiario.getTime());
		Place place = new PdCeloServicioPlace(fechaParam);
		clientFactory.getPlaceController().goTo(place);	
	}


	@Override
	public void irPartos() {
		popup.mostrarMensaje("Atención","Ud. se encuentra en la solapa Partos.");
		
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
		InicializarCombos.inicializarComboToros(null, view.cmbPadre);
		InicializarCombos.inicializarComboTiposParto(null, view.cmbTipoParto);
		InicializarCombos.inicializarComboSexoAnimal(null,view.cmbSexoCria1);
		InicializarCombos.inicializarComboSexoAnimal(null,view.cmbSexoCria2);
		InicializarCombos.inicializarComboEstadoCria(null, view.cmbEstadoCria1);
		InicializarCombos.inicializarComboEstadoCria(null, view.cmbEstadoCria2);
		
	}

	@Override
	public void onAgregarParto() {
		List<String> errores = new ArrayList<String>();
		boolean datosValidos=validarDatos(errores);
		if (datosValidos){
			PartoDTO parto=armarPartoDTO();
			popup.mostrarMensaje("Espere", "Insertando novedad...");
			clientFactory.getVacasService().insertarPartoRPC(parto, true,new AsyncCallback<PartoDTO>() { 

				@Override
				public void onFailure(Throwable e) {
					popup.mostrarMensaje("Ha ocurrido un error: " + e.getMessage());
				}

				@Override
				public void onSuccess(PartoDTO r) {
					view.limpiarControles();
					cargarPartos(fechaParteDiario);
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
	private PartoDTO armarPartoDTO() {
		PartoDTO result= new PartoDTO();

		result.setEliminado(false);
		result.setFecha(fechaParteDiario);
		result.setEstablecimiento(ClientContext.getInstance().getUsuarioLogueadoDTO().getEstablecimientoActual());
		if (view.cmbEstadoCria1.getSelectedItem()!=null)
			result.setEstadoCria1((EstadoCriaEnumDTO) view.cmbEstadoCria1.getSelectedItem());
		if (view.cmbEstadoCria2.getSelectedItem()!=null)
			result.setEstadoCria2((EstadoCriaEnumDTO) view.cmbEstadoCria2.getSelectedItem());
		result.setMellizos(view.chkMellizos.getValue());
		result.setNroParto(Integer.valueOf(view.nroParto.getText()));
		result.setObservaciones("");
		result.setPadre((view.cmbPadre.getSelectedItem()!=null)?(ToroDTO) view.cmbPadre.getSelectedItem():null);
		result.setRpCria1(view.rpCria1.getText()!=null?view.rpCria1.getText():"");
		result.setRpCria1(view.rpCria2.getText()!=null?view.rpCria2.getText():"");
		if (view.cmbSexoCria1.getSelectedItem() != null)
			result.setSexoCria1((SexoAnimalEnumDTO)view.cmbSexoCria1.getSelectedItem());
		if (view.cmbSexoCria2.getSelectedItem() != null)
			result.setSexoCria2((SexoAnimalEnumDTO)view.cmbSexoCria2.getSelectedItem());
		result.setTipoParto((TipoPartoDTO) view.cmbTipoParto.getSelectedItem());
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
			if (view.nroParto.getText().isEmpty()) {
				result = false;
				mensajeError.add("El Nro de parto es un campo obligatorio.");
			}

			// valida Tipo Parto
			if (view.cmbTipoParto.getSelectedItemText().length() == 0) {
				result = false;
				mensajeError.add("El tipo de parto es un campo obligatorio.");
			}
			// valida Estado de la cria 1
			if (view.cmbEstadoCria1.getSelectedItemText().length() == 0) {
				result = false;
				mensajeError.add("El estado de la cria 1 es un campo obligatorio.");
			} else {
				if (view.cmbEstadoCria1.getSelectedItemText().equals(EstadoCriaEnumDTO.VIVO.name())){
					if (view.cmbSexoCria1.getSelectedItemText().length() == 0) {
						result = false;
						mensajeError.add("Debe elegir un sexo para la cria 1.");
					}
				}
			}
			
			// valida Estado de la cria 2 (solo si es mellizos
			if (view.chkMellizos.getValue()){
				if (view.cmbEstadoCria2.getSelectedItemText().length() == 0) {
					result = false;
					mensajeError.add("El estado de la cria 2 es un campo obligatorio para un parto de mellizos.");
				} else {
					if (view.cmbEstadoCria2.getSelectedItemText().equals(EstadoCriaEnum.VIVO.name())){
						if (view.cmbSexoCria2.getSelectedItemText().length() == 0) {
							result = false;
							mensajeError.add("Debe elegir un sexo para la cria 2.");
						}
					}
				}
			}
		
		
		} catch (Exception e) {
			mensajeError.add("Error: " + e.getMessage());
			result = false;
		}

		return result;
	}

	private void agregarPartoATabla(PartoDTO c) {
		int i= view.lstCelosServicios.getRowCount()-1;
		
		view.lstCelosServicios.setText(i+1, 0, String.valueOf(c.getId()));
		view.lstCelosServicios.setText(i+1, 1, c.getVaca().getRp());
		view.lstCelosServicios.setText(i+1, 2, c.getPadre().getNombre());
		view.lstCelosServicios.setText(i+1, 3, String.valueOf(c.getNroParto()));
		view.lstCelosServicios.setText(i+1, 4, c.getTipoParto().getItemText());
		view.lstCelosServicios.setText(i+1, 5, (c.getSexoCria1()!=null)?c.getSexoCria1().getItemText():"");
		view.lstCelosServicios.setText(i+1, 6, (c.getEstadoCria1()!=null)?c.getEstadoCria1().getItemText():"");
		view.lstCelosServicios.setText(i+1, 7, (c.getSexoCria2()!=null)?c.getSexoCria2().getItemText():"");
		view.lstCelosServicios.setText(i+1, 8, (c.getEstadoCria2()!=null)?c.getEstadoCria2().getItemText():"");
		view.lstCelosServicios.setText(i+1, 9, (c.isMellizos())?"SI": "NO");
		
		//Boton Elimimnar
		Button cmdEliminarParto=new Button("Eliminar");
		cmdEliminarParto.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Cell cellSelected =  view.lstCelosServicios.getCellForEvent(event);
				int rowSelected=cellSelected.getRowIndex();
				Long idCeloServicio= Long.valueOf(view.lstCelosServicios.getText(rowSelected, 0));
				//eliminarCeloServicio (idCeloServicio);
				popup.mostrarMensaje("Falta implementar");
			}
		});
		view.lstCelosServicios.setWidget(i+1, 10, cmdEliminarParto);
		
		
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
						cargarPartos(fechaParteDiario);
					}
				});
			}
		};
	
		CustomSiNoDialogBox.setHandlers(listenerSi, listenerNo);
		
	}


	@Override
	public void cargarUltimoServicioVaca(String rpVaca) {
		popup.mostrarMensaje("Espere","Obteniendo datos de ultimo servicio...");
		clientFactory.getVacasService().obtenerVacaDTOPorRP(rpVaca,new AsyncCallback<VacaDTO>() {

			@Override
			public void onFailure(Throwable caught) {
				popup.mostrarMensaje("Atencion","Ha ocurrido un error al tratar de obtener ultimo servicio.");
				
			}

			@Override
			public void onSuccess(VacaDTO v) {
				view.txtFechaUS.setText(v.getFechaUltimoServicio()!=null?new SimpleDateFormat("dd/MM/yyyy").format(v.getFechaUltimoServicio()):"SIN SERVICIO");
				view.cmbPadre.selectByText(v.getToroUltimoServicio()!=null?v.getToroUltimoServicio().getNombre():"");
				popup.ocultar();
			}
			
		});
		
	}
	
}
