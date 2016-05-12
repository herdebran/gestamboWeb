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
package ar.com.cristal.creditos.client.tambo.animales.alta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.clientes.alta.ClienteView;
import ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesPlace;
import ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO;
import ar.com.cristal.creditos.client.event.SelectedItemEvent;
import ar.com.cristal.creditos.client.handler.SelectedItemEventHandler;
import ar.com.cristal.creditos.client.localidad.LocalidadDTO;
import ar.com.cristal.creditos.client.localidad.ui.BusquedaLocalidadActivity;
import ar.com.cristal.creditos.client.localidad.ui.BusquedaLocalidadPlace;
import ar.com.cristal.creditos.client.tambo.dto.CategoriaDTO;
import ar.com.cristal.creditos.client.tambo.dto.EstadoProductivoEnumDTO;
import ar.com.cristal.creditos.client.tambo.dto.EstadoReproductivoEnumDTO;
import ar.com.cristal.creditos.client.tambo.dto.EstadoSanitarioEnumDTO;
import ar.com.cristal.creditos.client.tambo.dto.RazaDTO;
import ar.com.cristal.creditos.client.tambo.dto.VacaDTO;
import ar.com.cristal.creditos.client.tambo.toros.ui.BusquedaTorosActivity;
import ar.com.cristal.creditos.client.tambo.toros.ui.BusquedaTorosPlace;
import ar.com.cristal.creditos.client.ui.util.ConstantesView;
import ar.com.cristal.creditos.client.ui.util.CustomAbstractActivity;
import ar.com.cristal.creditos.client.ui.util.InicializarCombos;
import ar.com.cristal.creditos.client.ui.util.PopUpInfo;
import ar.com.cristal.creditos.client.widget.CustomSiNoDialogBox;
import ar.com.snoop.gwt.commons.client.widget.ListBox;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Activities are started and stopped by an ActivityManager associated with a container Widget.
 */
public class AltaAnimalesActivity extends CustomAbstractActivity implements AltaAnimalesView.Presenter {

	
	private ClientFactory clientFactory;
	public PopUpInfo popup=null;
	private AltaAnimalesView view;
	private String token;
	private VacaDTO vacaActual = null;
	private Place place = null;
	private String estadoVaca = "";
	private HandlerRegistration handlerRegistrationAdd;
	private final String ID_COMPONENTE_ACTIVITY = "ALTA_EDICION_CLIENTE";

	private long tiempo = new Date().getTime();
	
	public AltaAnimalesActivity(AltaAnimalesPlace place, ClientFactory cf) {
		clientFactory = cf;
		popup = clientFactory.getPopUp();				
		view = clientFactory.getAltaAnimalesView();
		view.limpiarControles();
		view.setWidth(ConstantesView.maxPanelWidthPixels);
		token = place.getToken();
		this.place = place;
	}

	
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		
		super.start(containerWidget, eventBus, ID_COMPONENTE_ACTIVITY);
		view.setPresenter(this);

		view.clienteDiv.setInnerText("ABM Animales");
		
		containerWidget.setWidget(view.asWidget());
		
	}


	@Override
	public String mayStop() {
		return null;
	}

	private void inicializarControles() {
		try {
			view.limpiarControles();	
			view.habilitarBotonGuardar(true);
			
			if (token == null || token.isEmpty() || token.equalsIgnoreCase("null")){
				vacaActual = new VacaDTO();
				vacaActual.setFechaAlta(new Date());
				
				//Inicializo combos
				inicializarComboRaza(null);
				InicializarCombos.inicializarComboEstadoProductivo(view.cmbEstadoProd, null);
				InicializarCombos.inicializarComboEstadoReproductivo(view.cmbEstadoReprod, null);
				InicializarCombos.inicializarComboEstadoSanitario(view.cmbEstadoSanitario, null);
				InicializarCombos.inicializarComboRodeos(null, view.cmbRodeo);
				InicializarCombos.inicializarComboProblemasTacto(view.cmbResultadoUltTacto,null);
				InicializarCombos.inicializarComboToros(null, view.cmbPadre);
				//inicializarTipoDocumento(null);
				//inicializarComboProvincia(null);
				//inicializarComboLocalidad(null,true);
				//view.buscarToro.setEnabled(true);
				

			} else {
				
				if (token != null && !token.isEmpty()){
						clientFactory.getVacasService().obtenerVacaById(Long.valueOf(token), new AsyncCallback<VacaDTO>() {
						
							public void onSuccess(VacaDTO c) {
								vacaActual = c;
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

	

//	private void inicializarTipoDocumento(String tipoDocumento) {
//		try {
//			TipoDocumento[] tiposDocumentoArray = TipoDocumento.values();
//			List<String> tiposDocumento = new ArrayList<String>();
//			
//			tiposDocumento.clear();
//			for (int i = 0; i < tiposDocumentoArray.length ; i++){
//					tiposDocumento.add(tiposDocumentoArray[i].name());
//			}
//
//			view.inicializarComboTipoDoc(tiposDocumento);
//			if (tipoDocumento != null){
//				view.tipoDoc.selectByText(tipoDocumento);
//			}
//		} catch (Exception e) {
//			popup.mostrarMensaje("Error", "No se pudo inicializar el combo tipo documento");
//		}
//		
//	}
//
	
	
//	private void inicializarComboProvincia(final String nombreProvincia){
//		try {
//			final long tiempoCargaProvincia = new Date().getTime();
//			localidadFactory.getLocalidadService().obtenerProvincias(new AsyncCallback<List<ProvinciaDTO>>() {
//
//				public void onFailure(Throwable caught) {
//					popup.mostrarMensaje("Error", "No se pudo inicializar el combo provincia");
//					
//				}
//
//				public void onSuccess(List<ProvinciaDTO> provincias) {
//					view.provincia.clear();
//					for (ProvinciaDTO provinciaDTO : provincias) {
//						view.provincia.addItem(provinciaDTO);
//					}
//					if (provincias!= null) view.provincia.selectByText(nombreProvincia);
//					
//					System.out.println("inicializarComboProvincia Tiempo de carga de las provincias: " + (new Date().getTime() - tiempoCargaProvincia));
//				}
//
//			});
//		} catch (Exception e) {
//			popup.mostrarMensaje("Error", "No se pudo inicializar el combo provincia");
//		}
//	}
//	
//

	private void cargarDatosVaca(VacaDTO c) {
		
		try {
			view.clienteDiv.setInnerText(c.getRp());
			//Campos de texto
			view.rp.setText(c.getRp());
			view.rc.setText(c.getRc());
			view.rpMadre.setText(c.getRpMadre());
			view.rcMadre.setText(c.getRcMadre());
			view.lactancia.setText(String.valueOf(c.getLactancia()));
			view.grasa.setText(String.valueOf(c.getGrasa()));
			view.proteina.setText(String.valueOf(c.getProteina()));
			view.solTot.setText(String.valueOf(c.getSolidosTotales()));
			view.celSom.setText(String.valueOf(c.getSomaticas()));
			view.prodVitalicia.setText(String.valueOf(c.getProduccionVitalicia()));
			view.ltsPromedio.setText(String.valueOf(c.getLitrosPromedio()));
			view.observaciones.setText(c.getObservaciones());
			
			//Combos USAR inicializarTipoDocumento(c.getTipoDocumento());
			//cmbRaza.setSelectedIndex(0);
			//cmbCategoria.setSelectedIndex(0);
			//cmbPadre.setSelectedIndex(0);
			//cmbCategMadre.setSelectedIndex(0);
			//cmbRodeo.setSelectedIndex(0);
			//cmbEstadoProd.setSelectedIndex(0);
			//cmbEstadoReprod.setSelectedIndex(0);
			//cmbEstadoSanitario.setSelectedIndex(0);
			//cmbResultadoUltTacto.setSelectedIndex(0);

			//DatePicker
			view.fechaNacimientoDatePicker.setSelectedDate(c.getFechaNacimiento());			
			
			//Checkboxes
			view.paraVender.setValue(c.getParaVender()==null ? false: c.getParaVender());

			
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


	public void onAplicar(final Place place) {
		
		boolean datosValidos = true;
		
		List<String> errores = new ArrayList<String>();
		
		ClickHandler siHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				CustomSiNoDialogBox.ocultar();
				
				
				clientFactory.getVacasService().existeVacaRPC(vacaActual.getRp(), new AsyncCallback<Boolean>() {
				
					
					public void onFailure(Throwable e) {
						popup.mostrarMensaje("Error", e.getMessage());
						
					}
	
					public void onSuccess(Boolean existe) {
						if (existe)
							popup.mostrarMensaje("Información", "Ya existe un animal con el RP.");
						else {
							
							if (vacaActual.getId() != null) {
								
									//ACA MODIFICARIA EL ANIMAL ACTUAL
								
								
								
							} else {
							
								clientFactory.getVacasService().guardarVacaRPC(vacaActual, new AsyncCallback<VacaDTO>() {
		
									public void onFailure(Throwable e) {
										popup.mostrarMensaje("Error", e.getMessage());
										
									}
		
									public void onSuccess(VacaDTO vaca) {
										vacaActual = vaca;
										popup.mostrarMensaje("Los datos han sido guardados con éxito.");
										
									}
								});
							
							}
						}
						
					}
					
				});
				
			}
		};

		ClickHandler noHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				CustomSiNoDialogBox.ocultar();
				
			}
		};

		datosValidos = validarDatos(errores);
		if (datosValidos){
			generarDto();
			CustomSiNoDialogBox.dialogBox("Atención!", "Está seguro que desea aplicar los cambios?");
			CustomSiNoDialogBox.inicializarTamBotones();
			CustomSiNoDialogBox.setHandlers(siHandler, noHandler);
				
			} else {
				popup.mostrarMensaje("Error", errores);
			}
	}


	private void generarDto() {
		vacaActual.setCategoria(view.cmbCategoria.getSelectedItemText());
		vacaActual.setCategoriaMadre(view.cmbCategMadre.getSelectedItemText());
		vacaActual.setEliminado(false);
		vacaActual.setEstadoProductivo(EstadoProductivoEnumDTO.valueOf(view.cmbEstadoProd.getSelectedItemText()));
		vacaActual.setEstadoReproductivo(EstadoReproductivoEnumDTO.valueOf(view.cmbEstadoReprod.getSelectedItemText()));
		vacaActual.setEstadoSanitario(EstadoSanitarioEnumDTO.valueOf(view.cmbEstadoSanitario.getSelectedItemText()));
		vacaActual.setFechaNacimiento(view.fechaNacimientoDatePicker.getSelectedDate());
		vacaActual.setGrasa(view.grasa.getText().length() == 0 ? 0D : Double.valueOf(view.grasa.getText()));
		vacaActual.setLactancia(view.lactancia.getText().length() == 0 ? 0 : Integer.valueOf(view.lactancia.getText()));
		vacaActual.setLitrosPromedio(view.ltsPromedio.getText().length() == 0 ? 0D: Double.valueOf(view.ltsPromedio.getText()));
		vacaActual.setObservaciones(view.observaciones.getText());
		vacaActual.setPadre_id(view.cmbPadre.getSelectedItemId()==null? 0L : Long.valueOf(view.cmbPadre.getSelectedItemId()));
		vacaActual.setParaVender(view.paraVender.getValue());
		vacaActual.setProduccionVitalicia(view.prodVitalicia.getText().length() == 0 ? 0D : Double.valueOf(view.prodVitalicia.getText()));
		vacaActual.setProteina(view.proteina.getText().length() == 0 ? 0D : Double.valueOf(view.proteina.getText()));
		vacaActual.setRaza_id(Long.valueOf(view.cmbRaza.getSelectedItemId()));
		vacaActual.setRc(view.rc.getText());
		vacaActual.setRcMadre(view.rcMadre.getText());
		vacaActual.setResultadoTacto_id(view.cmbResultadoUltTacto.getSelectedItemId()==null ? 0L :Long.valueOf(view.cmbResultadoUltTacto.getSelectedItemId()));
		vacaActual.setRodeo_id(Long.valueOf(view.cmbRodeo.getSelectedItemId()));
		vacaActual.setRp(view.rp.getText());
		vacaActual.setRpMadre(view.rpMadre.getText());
		vacaActual.setSolidosTotales(view.solTot.getText().length() == 0 ? 0D : Double.valueOf(view.solTot.getText()));
		vacaActual.setSomaticas(view.celSom.getText().length() == 0 ? 0D : Double.valueOf(view.celSom.getText()));

		// FALTA AGREGAR LA IMAGEN
		//vacaActual.setImagen(imagen)
		
	}


	private boolean validarDatos(List<String> mensajeError) {
		boolean result = true;
		try {

			mensajeError.clear();

			// RP
			if (view.rp.getText().length() == 0) {
				result = false;
				mensajeError.add("El RP es un campo obligatorio.");

			}


			// valida fecha Nacimiento
			Date now = new Date();
			Date selectedDate = view.fechaNacimientoDatePicker
					.getSelectedDate();


			if (selectedDate != null) {
				long time = now.getTime() - selectedDate.getTime();

				if (time < 0) {
					result = false;
					mensajeError
							.add("La fecha de nacimiento no puede ser posterior a la fecha actual.");
				}
			} else {
				result = false;
				mensajeError
						.add("La fecha de nacimiento es un campo obligatorio.");
			}
			
			
			//valida selección de rodeo
			if (view.cmbRodeo.getSelectedItemText().equals("")) {
					result = false;
					mensajeError.add("El rodeo es un campo obligatorio.");
			}

			//valida estado productivo
			if (view.cmbEstadoProd.getSelectedItemText().equals("")) {
					result = false;
					mensajeError.add("El estado productivo es un campo obligatorio.");
			}

			//valida estado reproductivo
			if (view.cmbEstadoReprod.getSelectedItemText().equals("")) {
					result = false;
					mensajeError.add("El estado reproductivo es un campo obligatorio.");
			}
				
			//valida estado sanitario
			if (view.cmbEstadoSanitario.getSelectedItemText().equals("")) {
					result = false;
					mensajeError.add("El estado sanitario es un campo obligatorio.");
			}

			//Valida Lactancia Actual
			if (view.lactancia.getText().length() == 0) {
				result = false;
				mensajeError.add("El nro. de lactancia es un campo obligatorio.");

			}

			//TODO: Validar que no exista el RP ya
						
						
		} catch (Exception e) {
			mensajeError.add("Error: " + e.getMessage());
			result = false;
		}

		return result;
	}


	public void onCerrar() {
		//TODO: Ver a donde dirigir cdo cierra
		vacaActual = null;
		Place place = new BusquedaClientesPlace("");
		clientFactory.getPlaceController().goTo(place);
		
	}




	public VacaDTO getVacaActual() {
		return vacaActual;
		
	}


	/*
	 * true si esta modificando
	 */
	private boolean estaModificando(){
		return vacaActual.getId() != null;
	}

	/*
	 * true si es supervisor
	 */
	private boolean esSupervisor(){
		UsuarioLogueadoDTO u = getClientContext().getUsuarioLogueadoDTO();
		return u.isSupervisor();
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
	


	@Override
	public void cargarCategoriasXRaza(String razaId) {
		if (razaId != null) {
			popup.mostrarMensaje("Espere...","Cargando categorias...");
			clientFactory.getVacasService().obtenerCategoriasRPC(Long.valueOf(razaId), new AsyncCallback<List<CategoriaDTO>>(){

				@Override
				public void onFailure(Throwable caught) {
					popup.mostrarMensaje("Atencion","Ha ocurrido un error al cargar las categorias");
					
				}

				@Override
				public void onSuccess(List<CategoriaDTO> result) {
					inicializarComboCategorias(view.cmbCategoria,result);
					popup.ocultar();					
				}

			});
		}
		
	}

	private void inicializarComboRaza(final String raza) {
		try {
			final long tiempoCarga = new Date().getTime();
			clientFactory.getVacasService().obtenerRazasRPC(new AsyncCallback<List<RazaDTO>>() {
			
				public void onFailure(Throwable caught) {
					popup.mostrarMensaje("Error", "No se pudo inicializar el combo Razas");
					
				}

				public void onSuccess(List<RazaDTO> razas) {
					view.cmbRaza.clear();
					view.cmbRaza.addItem("","");
					for (RazaDTO razaDTO : razas) {
						view.cmbRaza.addItem(razaDTO);
					}
					if (raza!= null) view.cmbRaza.selectByText(raza);
					
					System.out.println("inicializarComboXRaza Tiempo de carga: " + (new Date().getTime() - tiempoCarga));
				}

			});
		} catch (Exception e) {
			popup.mostrarMensaje("Error", "No se pudo inicializar el combo de razas.");
		}
	}


	private void inicializarComboCategorias(ListBox cmbCategoria,
			List<CategoriaDTO> result) {
		cmbCategoria.clear();
		
		for (CategoriaDTO c:result){
			cmbCategoria.addItem(c);
		}
	}


	/**
	 * Abre popUp para seleccionar un Toro como padre.
	 */
	@Override
	public void buscarPadre() {
		 handlerRegistrationAdd = clientFactory.getEventBus().addHandler(SelectedItemEvent.TYPE, new SelectedItemEventHandler() {
				@Override
				public void onSelectItem(SelectedItemEvent event) {
					handlerRegistrationAdd.removeHandler();
					if (event.getListBoxItem() != null)
						InicializarCombos.inicializarComboToros(event.getListBoxItem().getItemText(), view.cmbPadre);
				}
			 });
			BusquedaTorosActivity toroActivity = new BusquedaTorosActivity(new BusquedaTorosPlace(""), clientFactory);
			toroActivity.startInPopUp();			
		
	}




}
