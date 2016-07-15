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
import ar.com.cristal.creditos.client.dto.ClienteDTO;
import ar.com.cristal.creditos.client.ui.home.HomePlace;
import ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO;
import ar.com.cristal.creditos.client.ui.util.ClientContext;
import ar.com.cristal.creditos.client.ui.util.ConstantesView;
import ar.com.cristal.creditos.client.ui.util.CustomAbstractActivity;
import ar.com.cristal.creditos.client.ui.util.GwtValidationUtils;
import ar.com.cristal.creditos.client.ui.util.InicializarCombos;
import ar.com.cristal.creditos.client.ui.util.OperacionesDocumentos;
import ar.com.cristal.creditos.client.ui.util.PopUpInfo;
import ar.com.cristal.creditos.common.TipoCeloServicioEnum;
import ar.com.cristal.creditos.entity.tambo.TipoServicio;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FlexTable;

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
			inicializarCombos();
			view.visibilizarControlesParaServicio(false);
			
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

	/***
	 * Carga Inicial para los Celos Servicios ya cargados esa fecha
	 */
	public void inicializarTabla(final FlexTable tabla,Date fecha){
		
		//LLAMAR UN METODO QUE OBTIENE CELOS Y SERVICIOS PARA ESA FECHA
		//clientFactory.getUsuarioService().obtenerUsarios(new AsyncCallback<List<UsuarioDTO>>() {
			
			
/*
		public void onSuccess(List<UsuarioDTO> usuarios) {
				
				METODO QUE AGREGA EN TABLA
			}
			
			public void onFailure(Throwable arg) {
				popup.mostrarMensaje("Error: ", arg.getMessage());
				
			}
		});
		
*/
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
			agregarDatosPantallaATabla();
			view.limpiarControles();
		} else {
			popup.mostrarMensaje("Error", errores);
		}
	}
	
	private void agregarDatosPantallaATabla() {
		agregarCeloServicioATabla(view.cmbVaca.getSelectedItemText(),
				view.nroCeloServicio.getText(), view.nroLactancia.getText(), view.cmbTipo.getSelectedItemText(), 
				view.cmbToro.getSelectedItemText(),view.cmbTipoServicio.getSelectedItemText() , view.cmbInseminador.getSelectedItemText());
		
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

	private void agregarCeloServicioATabla(String rp,String nro,String lact,String evento,String toro,String tipoServ,String inseminador) {
		int i= view.lstCelosServicios.getRowCount()-1;
		
		view.lstCelosServicios.setText(i+1, 0, "");
		view.lstCelosServicios.setText(i+1, 1, rp);
		view.lstCelosServicios.setText(i+1, 2, nro);
		view.lstCelosServicios.setText(i+1, 3, lact);
		view.lstCelosServicios.setText(i+1, 4, evento);
		view.lstCelosServicios.setText(i+1, 5, toro);
		view.lstCelosServicios.setText(i+1, 6, tipoServ);
		view.lstCelosServicios.setText(i+1, 7, inseminador);
		
		
		if (i % 2 == 0) {
			view.lstCelosServicios.getRowFormatter().addStyleName(i+1, "TableRow1Pointer");
		} else {				
			view.lstCelosServicios.getRowFormatter().addStyleName(i+1, "TableRow2Pointer");
		}

	}
	
}
