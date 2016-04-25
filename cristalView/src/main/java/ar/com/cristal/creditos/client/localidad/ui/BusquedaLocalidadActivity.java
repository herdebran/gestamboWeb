package ar.com.cristal.creditos.client.localidad.ui;

import java.util.ArrayList;
import java.util.List;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.LocalidadFactoryImpl;
import ar.com.cristal.creditos.client.event.SelectedItemEvent;
import ar.com.cristal.creditos.client.localidad.LocalidadDTO;
import ar.com.cristal.creditos.client.localidad.ProvinciaDTO;
import ar.com.cristal.creditos.client.ui.util.ConstantesView;
import ar.com.cristal.creditos.client.ui.util.CustomAbstractActivity;
import ar.com.cristal.creditos.client.ui.util.PopUpInfo;
import ar.com.cristal.creditos.client.ui.util.RegularExpressionConstants;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.RadioButton;

public class BusquedaLocalidadActivity extends CustomAbstractActivity implements BusquedaLocalidadView.Presenter {
	
	private ClientFactory clientFactory;
	private PopUpInfo popUpInfo;
	private BusquedaLocalidadView view;
	private LocalidadDTO localidadEditDTO = null;
	private Integer rowEditLocalidad=null;
	private List<LocalidadDTO> localidades = new ArrayList<LocalidadDTO>();
	
	public BusquedaLocalidadActivity(BusquedaLocalidadPlace place, ClientFactory cf) {
		clientFactory = cf;
		popUpInfo = clientFactory.getPopUp();
	}
	
	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus) {
		super.start(container, eventBus, "ABM_LOCALIDAD");
		view = clientFactory.getBusquedaLocaliadView();
		view.codigoPostal.setExpresionRegular(RegularExpressionConstants.numeros);
		container.setWidget(view.asWidget());

	}

	@Override
	public void inicializarActivity() {
		view.setPresenter(this);
		view.initTable();
		inicializarComboProvincia();
	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);		
	}
	
	public void startInPopUp() {
		view = clientFactory.getBusquedaLocaliadView();
		view.codigoPostal.setExpresionRegular(RegularExpressionConstants.numeros);
		startInPopUp(view);
		view.showPopUp(true);
	}
	
	private void inicializarComboProvincia(){
		try {
			LocalidadFactoryImpl.getClientFactoryImpl().getLocalidadService().obtenerProvincias(new AsyncCallback<List<ProvinciaDTO>>() {
				public void onFailure(Throwable caught) {
					popUpInfo.mostrarMensaje("Error", "No se pudo inicializar el combo provincia");
				}

				public void onSuccess(List<ProvinciaDTO> provincias) {
					view.setProvincias(provincias);
				}

			});
		} catch (Exception e) {
			popUpInfo.mostrarMensaje("Error", "No se pudo inicializar el combo provincia");
		}
	}
	

	@Override
	public void buscar() {
		popUpInfo.mostrarMensaje("Buscando Localidades... espere un momento por favor.");
		clientFactory.getComunesService().buscarLocalidad(buildDTO(true), new AsyncCallback<List<LocalidadDTO>>() {
			@Override
			public void onSuccess(List<LocalidadDTO> localidadesDTO) {
				popUpInfo.ocultar();
				cargarDetalle(localidadesDTO);
			}
			
			@Override
			public void onFailure(Throwable arg0) {
				popUpInfo.mostrarMensaje("Error: ", arg0.getMessage());
			}
		});
		
	}
	
	private LocalidadDTO buildDTO(boolean buscar) {
		LocalidadDTO localidadDTO = new LocalidadDTO();
		if (buscar){
			localidadDTO.setNombre(view.getLocalidadBusqueda());
		}
		else{
			if (view.getCodigoPostal()!=null)
				localidadDTO.setCodigo(new Integer(view.getCodigoPostal()));
			localidadDTO.setNombre(view.getLocalidad());
			localidadDTO.setProvincia((ProvinciaDTO)view.getProvincia());
		}
		return localidadDTO;

	}
	
	private void cargarDetalle(List<LocalidadDTO> localidadDTOs){
		this.localidades = localidadDTOs;
		view.limpiar();
		view.initTable();
		int i = 1;
		for (LocalidadDTO localidadDTO : localidades) {
			cargarDetalle(localidadDTO, i,true);
			i++;
		}
		rowEditLocalidad = null;
	}
	
	private void cargarDetalle(LocalidadDTO localidadDTO,Integer row,boolean esCreacion){
		if (esCreacion){
			RadioButton chk = new RadioButton("id_reparticion");
			chk.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					Cell cellEdit =  view.getDetalle().getCellForEvent(event);
					Integer rowEdit = cellEdit.getRowIndex();
					seleccionarReparticion(localidades.get(rowEdit-1),rowEdit);					
				}
			});
			view.getDetalle().setWidget(row, 0,chk);
		}		
		view.getDetalle().setText(row, 1,""+localidadDTO.getCodigo());
		view.getDetalle().setText(row, 2,localidadDTO.getNombre());
		view.getDetalle().setText(row, 3,localidadDTO.getProvincia().getNombre());
		if (row % 2 == 0) {
			view.getDetalle().getRowFormatter().addStyleName(row, ConstantesView.ESTILO_FILA1_PUNTERO);
		} else {				
			view.getDetalle().getRowFormatter().addStyleName(row, ConstantesView.ESTILO_FILA2_PUNTERO);
		}
	}
	
	private void seleccionarReparticion(LocalidadDTO localidadDTO,Integer rowEdit){
		localidadEditDTO = localidadDTO;
		rowEditLocalidad = rowEdit;
		view.setCodigoPostal(""+localidadDTO.getCodigo());
		view.setLocalidad(localidadDTO.getNombre());
		view.setProvincia(localidadDTO.getProvincia());
	}

	@Override
	public void guardar() {
		LocalidadDTO localidadDTO = buildDTO(false);
		if (validarGuardar(localidadDTO)){
			if (localidadEditDTO!= null)
				localidadDTO.setId(localidadEditDTO.getId());
			
			popUpInfo.mostrarMensaje("Guardando Localidad... espere un momento por favor.");
			
			clientFactory.getComunesService().guardarCrearLocalidad(localidadDTO,new AsyncCallback<LocalidadDTO>() {

				@Override
				public void onFailure(Throwable arg) {
					popUpInfo.mostrarMensaje("Error: ", arg.getMessage());
				}

				@Override
				public void onSuccess(LocalidadDTO localidadGuardadoDTO) {
					popUpInfo.ocultar();
					//Actualizar detalle o agregar nuevo Row
					Integer row = view.getDetalle().getRowCount();
					if (localidadEditDTO!= null){
						localidadEditDTO.setCodigo(localidadGuardadoDTO.getCodigo());
						localidadEditDTO.setNombre(localidadGuardadoDTO.getNombre());
						localidadEditDTO.setProvincia(localidadGuardadoDTO.getProvincia());
						row = rowEditLocalidad;
					}
					else{
						localidades.add(localidadGuardadoDTO);
					}
					cargarDetalle(localidadGuardadoDTO,row,localidadEditDTO == null);
					crear();
				}				
			});

		}
		else{
			popUpInfo.mostrarMensaje("Debe completar los campos obligatorios de localidad");
		}
		
	}
	
	private boolean validarGuardar(LocalidadDTO localidadDTO){
		return localidadDTO.getNombre() != null && localidadDTO.getProvincia() != null && localidadDTO.getCodigo()!=null;
	}
	

	@Override
	public void crear() {
		if (rowEditLocalidad != null)
			view.disabledRadioButton(rowEditLocalidad);
		view.limpiarCrear();
		localidadEditDTO =null;
		rowEditLocalidad = null;	
	}

	@Override
	public void limpiar() {
		localidadEditDTO = null;
		rowEditLocalidad = null;
		view.limpiar();		
	}

	@Override
	public void cerrar() {
		cerrar(null);	
		
	}

	@Override
	public void seleccionar() {
		cerrar(localidadEditDTO);		
	}
	
	private void cerrar(ListBoxItem item){
		hidePopUp();
		limpiar();
		view.showPopUp(false);
		clientFactory.getEventBus().fireEvent(new SelectedItemEvent(item));
	}

}
