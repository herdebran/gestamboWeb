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
package ar.com.cristal.creditos.client.clientes.busqueda.detalle;

import ar.com.cristal.creditos.client.clientes.alta.ClientePlace;
import ar.com.cristal.creditos.client.dto.ClienteDTO;
import ar.com.cristal.creditos.client.widget.RadioButtonId;
import ar.com.snoop.gwt.commons.client.widget.ListBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * View base interface.
 * Extends IsWidget so a view impl can easily provide its container widget.
 */
public class OperacionesHistorialCreditosClienteView extends Composite implements IsWidget {
  
	public static final int COLUMNA_ESTADO = 9;
	public static final int COLUMNA_TIPO = 11;
	
	private int filaSeleccionada = -1;
	
	

	public int getFilaSeleccionada() {
		return filaSeleccionada;
	}


	public void setFilaSeleccionada(int filaSeleccionada) {
		this.filaSeleccionada = filaSeleccionada;
	}

	public interface Presenter {
		/**
		 * Navigate to a new Place in the browser.
		 */
		void goTo(Place place);
		void goToLegales(String token);
		void inicializarTabla(Long idCliente,FlexTable tabla);
		
		void inicializarInfoCliente(Long idCliente);

		DatosOperacionesHistorialCreditosClienteDTO getDatosCliente();
		String obtenerIdCliente();

		void irAPantallaBusquedaCliente();

		
		void onOperaciones();
		

		
		ClienteDTO getClienteActual();
		
		void onCuotaBonificacionReintegroClick(int row);
		void irASeguimientoManual(Place seguimientoManual);
		void anularCredito(String obtenerIdSeleccionado);
		void cambiarEstadoPagoVoluntario(String obtenerIdSeleccionado);
		
		void anularConvenio(String idString);
		void validarYRedireccionar(Place place, String clienteId);
		void validarAdelantoSueldo();
		void onTableClick(RadioButtonId radio);
		void modificarCredito(String obtenerIdSeleccionado);
		void puedeRefinanciar(Place newPlace, String idSeleccionado);
			
	}
	
	
	interface Binder extends UiBinder<Widget, OperacionesHistorialCreditosClienteView> {
	}
	
	private static final Binder binder = GWT.create(Binder.class);

	private Presenter listener;
	
	public Integer opcionElegida=0;  //TODO: sacar esto cuando tenga los nombres de los places
			
	@UiField(provided=true)
	FlexTable listadoHistorialCliente = new FlexTable();
	
	@UiField(provided=true)
	FlexTable listadoCuotas = new FlexTable();
	
	@UiField
	HTMLPanel panelCuotas;
	
	@UiField
	HTMLPanel avisoOperacionesPanel;
	
	@UiField
	Button button;
	
	@UiField
	Button buttonSolicitud;
	
	@UiField
	Button buttonRefinanciacion;
	
	@UiField
	Button buttonFinanciacion;
	
	@UiField
	Button buttonParalelo;
				
	@UiField
	TextBox cuitCliente;
	
	@UiField
	TextBox cuotasSocialesDeuda;
	
	@UiField
	Label diasUltimoPago;

	@UiField
	Label creditoSeleccionado;
	
	@UiField
	TextBox condicionMorosidad;
	
	@UiField
	Button buttonPagar;

	@UiField
	Button agendarLlamada;
	
	
	@UiField
	Button buttonBonificacionReintegro;
	
	@UiField
	Anchor anchorDatosOperaciones;
	
	@UiField
	Anchor anchorDatosPersonales;
	@UiField
	Anchor anchorDatosAnexos;
	@UiField
	Anchor anchorReferidos;
	@UiField
	Anchor anchorGarantes;
	@UiField
	Anchor anchorSeguimiento;
	@UiField
	Anchor anchorLegales;
	
	@UiField
	Anchor anchorLlamadasEnCurso;
	
	@UiField
	Button btnRegistrarSeguimiento;
	
	
	@UiField
	DivElement clienteDiv;
	
	@UiField
	Label	convenioExtrajudical;
	
	@UiField
	DivElement divTablaCreditos;
	
	@UiField
	ListBox comportamientoPago;
	
	@UiField
	Label mensaje;
	
	@UiField
	Button buttonAdelantoSueldo;
	
	
	@UiField
	Button buttonCambiarPagoVoluntario;
	
	@UiField
	Button buttonPagarCuotaSocial;
	
	@UiField
	Button buttonModificarCredito;


	//En esta pantalla el token tiene el id de cliente!!
	private String token;

	public String getToken() {
		return token;
	}


	public OperacionesHistorialCreditosClienteView() {
		initWidget(binder.createAndBindUi(this));
		avisoOperacionesPanel.setStyleName("avisoOperaciones", true);
		avisoOperacionesPanel.setVisible(false);
		buttonPagarCuotaSocial.setVisible(true);
	}


	public void setPresenter(Presenter listener) {
		this.listener = listener;
	
	}

	@UiHandler("button")
	void onButtonClick(ClickEvent event) {
		
		listener.irAPantallaBusquedaCliente();
	}
	

	

	
	@UiHandler("listadoCuotas")
	void onLineaPagoCuotaBonificacionReintegroClick(ClickEvent event){
		Cell cellSelected =  listadoCuotas.getCellForEvent(event);
        int row = cellSelected.getRowIndex();
        if (row > 0) {
        	listener.onCuotaBonificacionReintegroClick(row);
        }
        
		
	}
	

	
	
	@UiHandler("buttonAdelantoSueldo")
	void onAdelantoSueldoClick(ClickEvent event){
		
		listener.validarAdelantoSueldo();
	}

	
	/***
	 * Devuelve el id del crédito seleccionado o un string vacío
	 * @return
	 */
	public String obtenerIdSeleccionado() {
		for (int i = 1;i<listadoHistorialCliente.getRowCount();i++){
			RadioButtonId radio = (RadioButtonId) listadoHistorialCliente.getWidget(i, 0);
			if (radio.getValue()) return listadoHistorialCliente.getText(i, 1);
		}
		return "";
	}
	
	public Boolean isActiveIdSeleccionado() {
		for (int i = 1;i<listadoHistorialCliente.getRowCount();i++){
			RadioButtonId radio = (RadioButtonId) listadoHistorialCliente.getWidget(i, 0);
			if (radio.getValue()) return ("ACTIVO".equalsIgnoreCase(listadoHistorialCliente.getText(i, COLUMNA_ESTADO)));
		}
		return false;
	}


	public boolean isSeleccionadoUnCredito() {
		for (int i = 1;i<listadoHistorialCliente.getRowCount();i++){
			RadioButtonId radio = (RadioButtonId) listadoHistorialCliente.getWidget(i, 0);
			if (radio.getValue()) return true;
		}
		return false;
	}
	
	void initTable(){
		
		listadoHistorialCliente.removeAllRows();
		listadoHistorialCliente.setWidget(0, 0,null);
		listadoHistorialCliente.setHTML(0,1,"Id");
		listadoHistorialCliente.setHTML(0,2,"F. Solicitud");
		listadoHistorialCliente.setHTML(0,3,"F. Aprobación");
		listadoHistorialCliente.setHTML(0,4,"Finalización");
		listadoHistorialCliente.setHTML(0,5,"Monto Solicitado");
		listadoHistorialCliente.setText(0,6,"Ctas Pagas");
		listadoHistorialCliente.setText(0,7,"Ctas");
		listadoHistorialCliente.setText(0,8,"Sucursal");
		listadoHistorialCliente.setText(0,COLUMNA_ESTADO,"Estado");
		listadoHistorialCliente.setText(0,10,"Vendedor");
		listadoHistorialCliente.setText(0,COLUMNA_TIPO,"Tipo");
		listadoHistorialCliente.setText(0,12,"Empresa");
		listadoHistorialCliente.setText(0,13,"Pago. Vol.");
		listadoHistorialCliente.setText(0,14,"Desc Crédito");
		listadoHistorialCliente.setText(0,15,"Forma Entrega");
		listadoHistorialCliente.setText(0,16,"Medio Contacto");

		listadoHistorialCliente.setCellPadding(0);
		listadoHistorialCliente.setCellSpacing(0);
		listadoHistorialCliente.getRowFormatter().addStyleName(0, "header");
		
	
		
		
	}


	public void setToken(String t) {
		token = t;
		
	}


	
	public void inicializarControlesDatosCliente() {
		
		cuotasSocialesDeuda.setText("");
		cuitCliente.setText("");
		convenioExtrajudical.setText("");
		condicionMorosidad.setText("");
		diasUltimoPago.setText("");
		
	}


	
	@UiHandler("anchorDatosPersonales")
	void onDatosPersonalesClick(ClickEvent event){
		Place newPlace = new ClientePlace(token);
		listener.goTo(newPlace);
	}
	

	@UiHandler("anchorLegales")
	//"idCli=1&idCausa=1";
	void onLegales(ClickEvent event) {
		listener.goToLegales("idCli="+token+"&idCausa=");
	}
	

	public Long getIdCreditoActivoSeleccionado() {
		for (int i = 1;i<listadoHistorialCliente.getRowCount();i++){
			RadioButtonId radio = (RadioButtonId) listadoHistorialCliente.getWidget(i, 0);
			if (radio.getValue() && ("ACTIVO".equalsIgnoreCase(listadoHistorialCliente.getText(i, COLUMNA_ESTADO)))) 
					return Long.valueOf(listadoHistorialCliente.getText(i, 1));
		}
		return null;
	}
	
	
	public boolean puedeSeleccionadoMostrarCuotas(){
		boolean resultado = false;
		if (listadoHistorialCliente.getRowCount() == 0) 
			return false;
		else 
			
			for (int i = 1;i<listadoHistorialCliente.getRowCount();i++){
				RadioButtonId radio = (RadioButtonId) listadoHistorialCliente.getWidget(i, 0);
				if (radio.getValue() && 
						(("ACTIVO".equalsIgnoreCase(listadoHistorialCliente.getText(i, COLUMNA_ESTADO))) || 
								"REFINANCIADO".equalsIgnoreCase(listadoHistorialCliente.getText(i, COLUMNA_ESTADO)) || 
								"FINANCIADO".equalsIgnoreCase(listadoHistorialCliente.getText(i, COLUMNA_ESTADO)) || 
								"LEGALES".equalsIgnoreCase(listadoHistorialCliente.getText(i, COLUMNA_ESTADO)) || 
						  "CANCELADO".equalsIgnoreCase(listadoHistorialCliente.getText(i, COLUMNA_ESTADO)))	
								){
					resultado = true;
					break;
				}
						
			}
		
		return resultado;
	}

	@UiHandler("anchorDatosOperaciones")
	void onDatosOperaciones(ClickEvent event) {
		listener.onOperaciones();
	}

	
	
	@UiHandler("buttonAnular")
	void onAnularCredito(ClickEvent event) {
		int i = getFilaSeleccionada();
		
		if (i >= 0)
			if ("CREDITO".equals(listadoHistorialCliente.getText(i, COLUMNA_TIPO)))
				listener.anularCredito(obtenerIdSeleccionado());
			else 
				listener.anularCredito("");
	}

	@UiHandler("listadoHistorialCliente")
	void onTableClick(ClickEvent event) {
		Cell cellSelected =  listadoHistorialCliente.getCellForEvent(event);
        int row = cellSelected.getRowIndex();
        if (row > 0) {
        	RadioButtonId radio = (RadioButtonId) listadoHistorialCliente.getWidget(row, 0);
        	radio.setValue(true);
        	listener.onTableClick(radio); 
        }
	}
	
	@UiHandler("buttonCambiarPagoVoluntario")
	void onCambiarPagoVoluntario(ClickEvent event) {
		int i = getFilaSeleccionada();
		
		if (i >= 0)
			if ("CREDITO".equals(listadoHistorialCliente.getText(i, COLUMNA_TIPO))
					&& ("ACTIVO".equalsIgnoreCase(listadoHistorialCliente.getText(i, COLUMNA_ESTADO))))
				listener.cambiarEstadoPagoVoluntario(obtenerIdSeleccionado());
			else
				listener.cambiarEstadoPagoVoluntario(null);
			
	}
	
	
	@UiHandler("buttonAnularConvenio")
	void onAnularConvenio(ClickEvent event) {
		int i = getFilaSeleccionada();
		
		if (i >= 0)
		
			if ("CONVENIO".equals(listadoHistorialCliente.getText(i, COLUMNA_TIPO)))
				listener.anularConvenio(obtenerIdSeleccionado());
			else 
				listener.anularConvenio(null);
		
		
			
	}
	
	
	@UiHandler("buttonModificarCredito")
	void onModificarCredito(ClickEvent event) {
		int i = getFilaSeleccionada();
		
		if (i >= 0)
			if ("CREDITO".equals(listadoHistorialCliente.getText(i, COLUMNA_TIPO))
					&& ("ACTIVO".equalsIgnoreCase(listadoHistorialCliente.getText(i, COLUMNA_ESTADO))))
				listener.modificarCredito(obtenerIdSeleccionado());
			else
				listener.modificarCredito(null);
		
		
			
	}
	
	
}
