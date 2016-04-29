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
import ar.com.cristal.creditos.client.LocalidadFactory;
import ar.com.cristal.creditos.client.LocalidadFactoryImpl;
import ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesPlace;
import ar.com.cristal.creditos.client.dto.ClienteDTO;
import ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO;
import ar.com.cristal.creditos.client.enums.TipoDocumento;
import ar.com.cristal.creditos.client.event.SelectedItemEvent;
import ar.com.cristal.creditos.client.handler.SelectedItemEventHandler;
import ar.com.cristal.creditos.client.localidad.LocalidadDTO;
import ar.com.cristal.creditos.client.localidad.ProvinciaDTO;
import ar.com.cristal.creditos.client.localidad.ui.BusquedaLocalidadActivity;
import ar.com.cristal.creditos.client.localidad.ui.BusquedaLocalidadPlace;
import ar.com.cristal.creditos.client.tambo.dto.VacaDTO;
import ar.com.cristal.creditos.client.ui.util.CalculadorCuil;
import ar.com.cristal.creditos.client.ui.util.ClientContext;
import ar.com.cristal.creditos.client.ui.util.ConstantesView;
import ar.com.cristal.creditos.client.ui.util.CustomAbstractActivity;
import ar.com.cristal.creditos.client.ui.util.GwtValidationUtils;
import ar.com.cristal.creditos.client.ui.util.OperacionesDocumentos;
import ar.com.cristal.creditos.client.ui.util.PopUpInfo;
import ar.com.cristal.creditos.client.widget.CustomSiNoDialogBox;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DialogBox;

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
	private HandlerRegistration handlerRegistrationAdd;
	private String estadoVaca = "";
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

		view.clienteDiv.setInnerText("Cliente");
		
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
							
								clientFactory.getVacasService().
								clientFactory.getClientesService().persistir(clienteActual, new AsyncCallback<ClienteDTO>() {
		
									public void onFailure(Throwable e) {
										popup.mostrarMensaje("Error", e.getMessage());
										
									}
		
									public void onSuccess(ClienteDTO cliente) {
										estadoCliente = cliente.getEstado();
										clienteActual = cliente;
										popup.mostrarMensaje("Los datos han sido guardados con éxito.");
										
									}
								});
							
							}
						}
						
					}

					private boolean esCambioEstado(ClienteDTO clienteActual, String estadoCliente) {
						if (estadoCliente.equalsIgnoreCase(clienteActual.getEstado()))
							return false;
						else
							return true;
							
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
		if(this.validarPermisosFuncionales()){
			datosValidos = validarDatos(errores);
			if (datosValidos){
				
					
				
						generarDto();
						
						clienteActual.setNombreUsuario(getClientContext().getUsuarioLogueadoDTO().getNombreUsuario());
						clienteActual.setFechaModificacion(new Date());
						
						CustomSiNoDialogBox.dialogBox("Atención!", "Está seguro que desea aplicar los cambios?");
						CustomSiNoDialogBox.inicializarTamBotones();
						CustomSiNoDialogBox.setHandlers(siHandler, noHandler);
						
						
					} else {
						popup.mostrarMensaje("Error", errores);
					}
		}
	}


	private void modificarClienteActual() {
		popup.mostrarMensaje("Guardando datos... espere un momento.");
		clientFactory.getClientesService().modificar(clienteActual, new AsyncCallback<ClienteDTO>() {
			
			public void onFailure(Throwable e) {
				popup.mostrarMensaje("Error", e.getMessage());
				
			}

			public void onSuccess(ClienteDTO cliente) {
				estadoCliente = cliente.getEstado();
				clienteActual = cliente;
				popup.mostrarMensaje("Los datos han sido guardados con éxito.");

				
			}
		});
	}
	
	private void generarDto() {
		clienteActual.setApellido(view.apellido.getText());
		clienteActual.setNombre(view.nombre.getText());
		clienteActual.setFechaNacimiento(view.fechaNacimientoDatePicker.getSelectedDate());
		clienteActual.setTelefono(view.telefono.getText());
		clienteActual.setTelefono1(view.telefono1.getText());		
		clienteActual.setTelefono2(view.telefono2.getText());
		clienteActual.setTelefono3(view.telefono3.getText());
		
		clienteActual.setCaracteristica(view.caracteristica.getText());
		clienteActual.setCaracteristica1(view.caracteristica1.getText());		
		clienteActual.setCaracteristica2(view.caracteristica2.getText());
		clienteActual.setCaracteristica3(view.caracteristica3.getText());
		
		clienteActual.setCp(view.cp.getText());
		clienteActual.setNro(view.nro.getText());
		clienteActual.setPiso(view.piso.getText());
		clienteActual.setDpto(view.dpto.getText());
		clienteActual.setCalle(view.calle.getText());		
		
		
		clienteActual.setCBU(view.cbu.getText());
		clienteActual.setCUIL(view.cuil.getText());
		clienteActual.setDni(view.dni.getText());
		clienteActual.setTipoDocumento(view.tipoDoc.getSelectedItemText());
		clienteActual.setEstado(view.estadoCliente.getSelectedItemText());
		clienteActual.setSueldo(0.0);
		clienteActual.setTarjetaBeneficios(view.tarjetaBeneficios.getValue());
		clienteActual.setAntecedentesJuridicos(view.antecedentesJuridicos.getValue());
		clienteActual.setEmail(view.email.getText());
		clienteActual.setLocalidad(localidadActualDTO);
		clienteActual.setObservaciones(view.observaciones.getText());
		clienteActual.setPagoVoluntario(view.checkPagoVoluntario.getValue());
		clienteActual.setSexo(view.sexo.getSelectedItemText());		
	}


	private boolean validarDatos(List<String> mensajeError) {
		boolean result = true;
		try {

			mensajeError.clear();

			// valida apellido y nombre
			if (view.apellido.getText().length() == 0) {
				result = false;
				mensajeError.add("El apellido es un campo obligatorio.");

			}

			// valida apellido y nombre
			if (view.nombre.getText().length() == 0) {
				result = false;
				mensajeError.add("El nombre es un campo obligatorio.");

			}

			// valida dni
			if (view.dni.getText().length() == 0) {
				result = false;
				mensajeError.add("El documento es un campo obligatorio.");
				
			} else {
				if (!view.dni.getText().equals(view.verificadorDni.getText())) {
					result = false;
					mensajeError.add("El dni y el verificador no coinciden.");
				}
			}

			
			// valida fecha
			Date now = new Date();
			Date selectedDate = view.fechaNacimientoDatePicker
					.getSelectedDate();

			if (selectedDate != null) {
				long time = now.getTime() - selectedDate.getTime();

				// TODO: validar mayoría de edad y extrema longevidad (esto
				// puede no ir a este nivel y sí al momento
				// de validar el plan de financiación a otorgar
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
			
			//valida selección de sexo
			if (view.sexo.getSelectedItemText().equals("")) {
					result = false;
					mensajeError.add("El sexo es un campo obligatorio.");
				
			
			}

			// valida cuil solo si es ingresado
			if (view.cuil.getText().length() != 0) {
				boolean cuilValido = GwtValidationUtils.validateCuil(view.cuil.getText());
				if (!cuilValido) {
					result = false;
					mensajeError.add("El cuil no es válido.");
				}
				
				cuilValido = OperacionesDocumentos.validarCuilDocumento(view.cuil.getText(), view.dni.getText());
				
				if (!cuilValido) {
					result = false;
					mensajeError.add("El cuil y el documento no coinciden.");
				}
			}

			
			
			
			// valida CBU
			if (!view.cbu.getText().isEmpty()) {
				if (!view.cbu.getText().equals(view.verificadorCBU.getText())) {
					result = false;
					mensajeError.add("El cbu y el verificador no coinciden.");
				}
			
			}
			
			// valida que el CBU tenga exactamente 22 digitos.
			if (!view.cbu.getText().isEmpty()) {
				if (view.cbu.getText().length() != 22){
					result = false;
					mensajeError.add("El CBU debe tener 22 dígitos");
					
				}
			}
			
			// validar mail
			   clientFactory.getComunesService().validarEMail(view.email.getText(), new AsyncCallback<Boolean>() {

				public void onFailure(Throwable e) {
					popup.mostrarMensaje("Error", e.getMessage());
				}

				public void onSuccess(Boolean r) {
					if(!r){
						popup.mostrarMensaje("El formato de email es incorrecto");
						
					}
					
				}
				   
			   });
				
			   
			   
			// valida localidad
				if (view.localidad.getText().length() == 0) {
					result = false;
					mensajeError.add("La localidad es un campo obligatorio.");

				}
				
				if (view.reparticion.getText().length() == 0) {
					result = false;
					mensajeError.add("La repartición es un campo obligatorio.");

				}
				
				//Valida Reparticion
				if (view.reparticion.getText().length() == 0) {
					result = false;
					mensajeError.add("La repartición es un campo obligatorio.");

				}

				// valida caracteristica celular
				if (view.caracteristica1.getText().length() > 0) {
					if (view.caracteristica1.getText().startsWith("0")) {
						result = false;
						mensajeError.add("Ingrese la caracteristica del celular sin el 0.");
					}
				}

				// valida telefono celular
				if (view.telefono1.getText().length() > 0) {
					if (view.telefono1.getText().startsWith("15")) {
						result = false;
						mensajeError.add("Ingrese el celular sin el 15.");
					}
				}
				
				
						
						
		} catch (Exception e) {
			mensajeError.add("Error: " + e.getMessage());
			result = false;
		}

		return result;
	}


	public void onCerrar() {
		clienteActual = null;
		Place place = new BusquedaClientesPlace("");
		clientFactory.getPlaceController().goTo(place);
		
	}




	public ClienteDTO getClienteActual() {
		return clienteActual;
		
	}


	
	public void onOperaciones() {
		
		if (clienteActual != null && clienteActual.getId() != null ){
			Place place = clientFactory.getOperacionesHistorialCreditosClientePlace(clienteActual.getId().toString());
					
			cambioDePestaña(place);
		}
	}

	public void cambioDePestaña(final Place place){
		if (place != null)
			clientFactory.getPlaceController().goTo(place);
 
	}
	
	
	
	
	/**
	 * Verifica si es supervisor al momento de la modificacion
	 * Solo los supervisores pueden modificar y eliminar datos.
	 */
	public boolean validarPermisosFuncionales(){

			if( !esSupervisor()){
				if(estaModificando()){
					popup.mostrarMensaje("Información", "Los datos solo son modificables por los supervisores");	
					return false;
				}
			}
			return true;
				
	}
	
	
	
	/*
	 * true si esta modificando
	 */
	private boolean estaModificando(){
		return clienteActual.getId() != null;
	}

	/*
	 * true si es supervisor
	 */
	private boolean esSupervisor(){
		UsuarioLogueadoDTO u = getClientContext().getUsuarioLogueadoDTO();
		return u.isSupervisor();
	}



	public void calcularCuil() {
		
		if (view.dni.getText().length() == 0 || view.sexo.getSelectedItemText().equals("")){
			
			popup.mostrarMensaje("Información", "Debe completar el dni y el sexo para obtener el cuil");
		} else {
			String dni = view.dni.getText();
			String cuil = CalculadorCuil.obtenerCuil(dni, view.sexo.getSelectedItemText());
			view.cuil.setText(cuil);
			popup.mostrarMensaje("Buscando clientes con dni o cuil existentes");
			clientFactory.getClientesService().obtenerClientesByDNICuil(dni, cuil, new AsyncCallback<List<ClienteDTO>>() {
				
				@Override
				public void onSuccess(List<ClienteDTO> clientes) {
					List<String> items = new ArrayList<String>();
					for (ClienteDTO clienteDTO : clientes) {
						String item = clienteDTO.getApellidoNombreId();
						items.add(item);
					}
					
					if (items.size() > 0) { 
						
						informeClienteExistente(items);
					}
					else 
					{
						view.habilitarBotonGuardar(true); //habilita el control de guardar siempre que no exista 
						popup.ocultar();
					}
					
				}
				

				@Override
				public void onFailure(Throwable e) {
					
					popup.mostrarMensaje("Error", e.getMessage()); 
				}
			});
		}
		
	}
	
	
	public void irACausaLegal() {
		
		clientFactory.getUsuarioService().obtenerComponente(ConstantesView.GESTION_CAUSAS_LEGALES_ESCRITURA, new AsyncCallback<String>() {
			public void onFailure(Throwable arg0) {
				popup.mostrarMensaje("Información", "No se logró obtener el id de componente para el acceso a Legales.");
			}
			public void onSuccess(String id) {
				idGestionCausaLegalEscritura = id;
				String token = "idCli=" + clienteActual.getId() + "&idCausa=";
				Place causaLegal = clientFactory.getCausaLegalPlace(getClientContext().getUsuarioLogueadoDTO(), 
						idGestionCausaLegalEscritura, token);
				
				goTo(causaLegal);
			}
		});
		
		
	}


	@Override
	public void inicializarActivity() {
		System.out.println("Tiempo de validación de permisos y usuario [ms]: " + (new Date().getTime() - tiempo));
		tiempo = new Date().getTime();
		inicializarControles();
		view.anchorDatosPersonales.getElement().getStyle().setBackgroundColor("#006AA4");		
	}
	


	@Override
	public void buscarLocalidad() {
		 handlerRegistrationAdd = clientFactory.getEventBus().addHandler(SelectedItemEvent.TYPE, new SelectedItemEventHandler() {
				@Override
				public void onSelectItem(SelectedItemEvent event) {
					handlerRegistrationAdd.removeHandler();
					inicializarComboLocalidad((LocalidadDTO)event.getListBoxItem(),false);
				}
			 });
			BusquedaLocalidadActivity rep = new BusquedaLocalidadActivity(new BusquedaLocalidadPlace(""), clientFactory);
			rep.startInPopUp();			
	}	
	

	
	
	private void informeClienteExistente(List<String> clientes) {
		String mensaje = "";
		if (ClientContext.getInstance().isComercializador())
		{
			mensaje = " No podrá guardar los datos del cliente, utilice el número de cliente para realizar una solicitud";
			view.habilitarBotonGuardar(false);
			
		}
		clientes.add(0,mensaje);
		popup.mostrarMensaje("Clientes encontrados con igual cuil o dni", clientes);
		
	}


	@Override
	public void onLlamadaEnCurso() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void buscarReparticion() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void buscarComercializador() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onGarantes() {
		// TODO Auto-generated method stub
		
	}

}
