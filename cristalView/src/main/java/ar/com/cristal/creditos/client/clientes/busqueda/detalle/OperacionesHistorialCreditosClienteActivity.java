
package ar.com.cristal.creditos.client.clientes.busqueda.detalle;

import java.util.ArrayList;
import java.util.List;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesPlace;
import ar.com.cristal.creditos.client.dto.ClienteDTO;
import ar.com.cristal.creditos.client.ui.util.ConstantesView;
import ar.com.cristal.creditos.client.ui.util.CustomAbstractActivity;
import ar.com.cristal.creditos.client.ui.util.PopUpInfo;
import ar.com.cristal.creditos.client.widget.RadioButtonId;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;

/**
 * Activities are started and stopped by an ActivityManager associated with a container Widget.
 */
public class OperacionesHistorialCreditosClienteActivity extends CustomAbstractActivity implements OperacionesHistorialCreditosClienteView.Presenter {

	private static final String SIN_CONVENIO_ACTIVO_LABEL = "No tiene convenio Activo";

	private static final String CONVENIO_ACTIVO_LABEL = "Atención, el cliente tiene un Convenio ACTIVO";

	private static final String BONIFICACION = "id_cuota_bonificacion";

	private static final String CONCEPTO = "concepto";

	private static final String SELECCIONE_UN_CREDITO_ACTIVO_PARA_OPERAR = "Seleccione un crédito activo para realizar la operación";

	private static final int COLUMNA_TIPO_OPERACION = 11;
	private static final int COLUMNA_ESTADO = OperacionesHistorialCreditosClienteView.COLUMNA_ESTADO;

	private static final String SELECCIONE_UN_CREDITO_PARA_PODER_PAGAR = "Seleccione un crédito ACTIVO para poder pagar";

	protected static final int LINEAS_PARA_SCROLL = 3;
	
	ClientFactory clientFactory;
	
	public PopUpInfo popup=null;
	
	private OperacionesHistorialCreditosClienteView view;
	
	private String token;
	
	private Integer cantCreditosActivos = 0;
	
	private DatosOperacionesHistorialCreditosClienteDTO datosCliente = new DatosOperacionesHistorialCreditosClienteDTO();
	
	private List<LineaOperacionesHistorialCreditosClienteDTO> datosTabla = new ArrayList<LineaOperacionesHistorialCreditosClienteDTO>();  
	
	String idGestionCausaLegalEscritura;
	
	private ClienteDTO clienteActual = null;
	private Long creditoConvenioSolicitudIdSeleccionado = null;

	
	private HandlerRegistration handlerRegistrationAdd;
	private HandlerRegistration handlerCondicionMorosidadRegistrationAdd;
	
	public OperacionesHistorialCreditosClienteActivity(OperacionesHistorialCreditosClientePlace place, ClientFactory cf) {
		clientFactory = cf;
		popup = clientFactory.getPopUp();		
		token = place.getToken();
	}

	
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		
		
		this.view = clientFactory.getOperacionesHistorialCreditosClienteView();		
		view.setWidth(ConstantesView.maxPanelWidthPixels);
		
		view.setPresenter(this);
		super.start(containerWidget, eventBus, "");
		clienteActual = null;
		
		view.panelCuotas.setVisible(false);
		
		containerWidget.setWidget(view.asWidget());
		
		view.clienteDiv.setInnerText("Cliente");
		
		view.setFilaSeleccionada(-1);
		
		
		

	}

	

	private void habilitarOpcionesComercializador(boolean b) {
		
				
					view.buttonPagar.setEnabled(false);
					view.agendarLlamada.setEnabled(false);
//					view.buttonSolicitud.setEnabled(b); se habilita de otra forma
					
					//No se debe hacer nada con refinanciación, paralelo
					view.anchorDatosOperaciones.setEnabled(b);
					view.anchorDatosPersonales.setVisible(b);
					view.anchorDatosAnexos.setVisible(b);
					view.anchorReferidos.setVisible(b);
					view.anchorSeguimiento.setVisible(b);
					//view.anchorLegales.setVisible(b);
					view.buttonPagarCuotaSocial.setVisible(false);
					view.buttonCambiarPagoVoluntario.setEnabled(false);
				
	}			


	@Override
	public String mayStop() {
		return null;
	}
	

	
	
	private void onRowHistorialRadioButtonClick(RadioButtonId r) {
		view.panelCuotas.setVisible(false);		
		view.setFilaSeleccionada(r.getNroFila());
		creditoConvenioSolicitudIdSeleccionado = r.getId();
		mostrarOperacionesDelCreditoConvenio(r.getId());	
		
	}
	

	protected void inicializarBotones() {
		//Inicializo botones falso
		view.buttonSolicitud.setEnabled(false);		
		view.buttonFinanciacion.setEnabled(false);
		view.buttonParalelo.setEnabled(false);
		view.buttonRefinanciacion.setEnabled(false);
		view.buttonPagar.setEnabled(true);
		view.buttonBonificacionReintegro.setEnabled(false);
		
				
	}


	/***
	 * Muestra las cuotas, bonificaciones y reintegros asociados a un crédito
	 * @param idCredito
	 */
	private void mostrarOperacionesDelCreditoConvenio(Long idCredito) {
		
		if (view.puedeSeleccionadoMostrarCuotas()){
			
			view.panelCuotas.setVisible(true);
			view.creditoSeleccionado.setText("Cuotas del crédito seleccionado: " + idCredito.toString());
			limpiarTablaCuotas(view.listadoCuotas);
			popup.mostrarMensaje("Información", "Obteniendo cuotas... espere por favor");
			

		}
		
		
	}

	
	protected void limpiarTablaCuotas(FlexTable tabla) {
		try{
			
			tabla.removeAllRows();
			
			int i = 0;
			tabla.setHTML(0,++i,"Concepto");
			tabla.setHTML(0,++i,"Fecha");
			
			Label importe = new Label("Importe");
			importe.setTitle("Valor de la cuota o monto del reintegro.");
			tabla.setWidget(0,++i,importe);		

			Label punitorios = new Label("Punitorios");
			punitorios.setTitle("Punitorios calculados desde la última fecha de Pago (si la cuota no está PAGA) o Monto registrado en concepto de punitorios si la cuota está PAGA.");
			tabla.setWidget(0,++i,punitorios);		
//			tabla.setText(0,++i,"Punitorios");
			
			tabla.setText(0,++i,"Estado");
			tabla.setText(0,++i,"Fecha Pago");
			
			Label registrado = new Label("Registrado");
			registrado.setTitle("Monto total registrado en concepto de pagos (punitorio y de cuota)");
			tabla.setWidget(0,++i,registrado);		
			
			Label adeudado = new Label("Adeudado");
			adeudado.setTitle("Monto total adeudado para cancelar la cuota (No considera gastos de carta)");
			tabla.setWidget(0,++i,adeudado);			
			
			Label accion = new Label("Acción");
			tabla.setWidget(0,++i,accion);
					
			tabla.setCellPadding(0);
			tabla.setCellSpacing(0);
			tabla.getRowFormatter().addStyleName(0, "header");
			
		}catch(Throwable e){
			popup.mostrarMensaje("Error", e.getMessage());
		}
	}
	
	
	
	/***
	 * Carga inicial de la tabla de creditos del cliente
	 */
	public void inicializarInfoCliente(final Long idCliente){

		if (clienteActual == null){
			clientFactory.getClientesService().obtenerClienteById(idCliente, new AsyncCallback<ClienteDTO>() {
	
				@Override
				public void onFailure(Throwable e) {
					popup.mostrarMensaje(e.getMessage());
					
				}
	
				@Override
				public void onSuccess(ClienteDTO cliente) {
					clienteActual = cliente;
					
				}
			});
		}

		


	}





	/***
	 * Muestra qué créditos están a una cuota de ser finalizados
	 * @param idCliente
	 */
	private void informarSobreFinalizacionCreditos(Long idCliente) {
		clientFactory.getClientesService().obtenerCreditosPorFinalizar(idCliente, new AsyncCallback<List<Long>>() {

			@Override
			public void onFailure(Throwable arg) {
				popup.mostrarMensaje("Error", arg.getMessage());
				
			}

			@Override
			public void onSuccess(List<Long> result) {
				if (result.size()>0){ 
					view.avisoOperacionesPanel.setVisible(true);
					if (result.size()==1)
						view.mensaje.setText("El cliente está por finalizar el crédito " + result.get(0));
					else
					{
						String creditos = "";
						for (Long credId : result) {
							creditos += credId.toString() + " | ";
						}
						view.mensaje.setText("El cliente está por finalizar los siguientes créditos " + creditos);
					}
				}
				
			}
		});
		
	}


	public String obtenerIdCliente() {
		//el token tiene el id de cliente que viene de la pantalla buscar
		return token;
	}


	public DatosOperacionesHistorialCreditosClienteDTO getDatosCliente() {
		
		return null;
	}


	public void irAPantallaBusquedaCliente() {
		Place newPlace = new BusquedaClientesPlace("");
		clientFactory.getPlaceController().goTo(newPlace);
		
	}





	public void goToLegales(final String token) {
		
		clientFactory.getUsuarioService().obtenerComponente(ConstantesView.GESTION_CAUSAS_LEGALES_ESCRITURA, new AsyncCallback<String>() {

			public void onFailure(Throwable arg0) {
				popup.mostrarMensaje("informacion", "No se logró obtener el id de componente para el acceso al módulo Legales");
			}

			public void onSuccess(String id) {
				idGestionCausaLegalEscritura = id;
				Place p = clientFactory.getCausaLegalPlace(getClientContext().getUsuarioLogueadoDTO(), idGestionCausaLegalEscritura, token);
				goTo(p);
			}
		});
		
		
		
	}


	@Override
	public void inicializarActivity() {
		view.setVisible(false);
	
		view.setVisible(true);
		view.setToken(token);
		view.avisoOperacionesPanel.setVisible(false);
		view.avisoOperacionesPanel.setStyleName("avisoOperaciones");
		view.inicializarControlesDatosCliente();
		view.initTable();
		view.buttonCambiarPagoVoluntario.setEnabled(true);
									
		if(token == null || token.isEmpty()){
			popup.mostrarMensaje("Error: No se seleccionó ningún Cliente");
		} else {
			inicializarInfoCliente(new Long(token));
		}
		
		view.anchorDatosOperaciones.getElement().getStyle().setBackgroundColor("#006AA4");

				
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

	public ClienteDTO getClienteActual(){
		return clienteActual;
	}
	
	
	
	
		
	


	
	
	private RadioButtonId obtenerRadioButtonSeleccionado(){
		RadioButtonId r = null;
		for (int i = 1; i < view.listadoHistorialCliente.getRowCount(); i++) {
			r= (RadioButtonId) view.listadoHistorialCliente.getWidget(i, 0);
			
			if (r.getValue()) break;
		}
		
		if (r != null && r.getValue()) 
			return r;
		else 
			return null;
	}



	

	@Override
	public void irASeguimientoManual(Place seguimientoManual) {
		clientFactory.getPlaceController().goTo(seguimientoManual);
		
	}

	public void onTableClick(RadioButtonId r) {
		//Manejador de clic en la Grilla de datos anexos
		onRowHistorialRadioButtonClick(r);
	}


	@Override
	public void goTo(Place place) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void inicializarTabla(Long idCliente, FlexTable tabla) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void anularCredito(String obtenerIdSeleccionado) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void cambiarEstadoPagoVoluntario(String obtenerIdSeleccionado) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void anularConvenio(String idString) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void validarYRedireccionar(Place place, String clienteId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void validarAdelantoSueldo() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void modificarCredito(String obtenerIdSeleccionado) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void puedeRefinanciar(Place newPlace, String idSeleccionado) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onCuotaBonificacionReintegroClick(int row) {
		// TODO Auto-generated method stub
		
	}



	}
