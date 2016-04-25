package ar.com.cristal.creditos.client.ui.sucursales;

import java.util.ArrayList;
import java.util.List;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.dto.SucursalDTO;
import ar.com.cristal.creditos.client.event.SelectedItemEvent;
import ar.com.cristal.creditos.client.ui.util.ConstantesView;
import ar.com.cristal.creditos.client.ui.util.CustomAbstractActivity;
import ar.com.cristal.creditos.client.ui.util.PopUpInfo;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.RadioButton;

public class ABMSucursalActivity extends CustomAbstractActivity implements ABMSucursalView.Presenter{

	private ClientFactory clientFactory;
	private PopUpInfo popUpInfo;
	private ABMSucursalView view;
	private SucursalDTO sucursalEditDTO = null;
	private Integer rowEditSucursal=null;
	private List<SucursalDTO> sucursales = new ArrayList<SucursalDTO>();
	
	public ABMSucursalActivity(ABMSucursalPlace place,ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		popUpInfo = clientFactory.getPopUp();
	}
	
	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus) {
		super.start(container, eventBus, "ABM_SUCURSAL");
		view = clientFactory.getABMSucursalView();
		container.setWidget(view.asWidget());
	}

	@Override
	public void inicializarActivity() {
		view.setPresenter(this);
		view.initTable();
		buscar();
	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);	
	}

	@Override
	public void buscar() {
		popUpInfo.mostrarMensaje("Buscando Sucursales... espere un momento por favor.");
		clientFactory.getComunesService().buscarSucursal(buildDTO(true), new AsyncCallback<List<SucursalDTO>>() {
			@Override
			public void onSuccess(List<SucursalDTO> sucursalesDTO) {
				popUpInfo.ocultar();
				cargarDetalle(sucursalesDTO);
			}
			
			@Override
			public void onFailure(Throwable arg0) {
				popUpInfo.mostrarMensaje("Error: ", arg0.getMessage());
			}
		});
		
	}

	protected void cargarDetalle(List<SucursalDTO> sucursalesDTO) {
		this.sucursales = sucursalesDTO;
		view.limpiar();
		view.initTable();
		int i = 1;
		for (SucursalDTO sucursalDTO : sucursales) {
			cargarDetalle(sucursalDTO, i,true);
			i++;
		}
		rowEditSucursal= null;		
	}

	@Override
	public void guardar() {
		if (validarGuardar()){
			SucursalDTO sucursalDTO = buildDTO(false);
			if (sucursalEditDTO!= null)
				sucursalDTO.setId(sucursalEditDTO.getId());
			
				popUpInfo.mostrarMensaje("Guardando Sucursal... espere un momento por favor.");

				clientFactory.getComunesService().guardarCrearSucursal(sucursalDTO,new AsyncCallback<SucursalDTO>() {

				@Override
				public void onFailure(Throwable arg) {
					popUpInfo.mostrarMensaje("Error: ", arg.getMessage());
				}

				@Override
				public void onSuccess(SucursalDTO sucursalGuardadaDTO) {
					popUpInfo.ocultar();
					//Actualizar detalle o agregar nuevo Row
					Integer row = view.getDetalle().getRowCount();
					if (sucursalEditDTO!= null){
						sucursalEditDTO.setId(sucursalGuardadaDTO.getId());
						sucursalEditDTO.setNombre(sucursalGuardadaDTO.getNombre());
						row = rowEditSucursal;
					}
					else{
						sucursales.add(sucursalGuardadaDTO);
					}
					cargarDetalle(sucursalGuardadaDTO,row,sucursalEditDTO == null);
					crear();
				}				
			});

		}
		else{
			popUpInfo.mostrarMensaje("Debe completar los campos obligatorios de la sucursal");
		}
	}

	protected void cargarDetalle(SucursalDTO sucursalDTO, Integer row,	boolean esCreacion) {
		if (esCreacion){
			RadioButton chk = new RadioButton("id_reparticion");
			chk.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					Cell cellEdit =  view.getDetalle().getCellForEvent(event);
					Integer rowEdit = cellEdit.getRowIndex();
					seleccionar(sucursales.get(rowEdit-1),rowEdit);					
				}
			});
			view.getDetalle().setWidget(row, 0,chk);
		}		
		view.getDetalle().setText(row, 1,sucursalDTO.getNombre());
		if (row % 2 == 0) {
			view.getDetalle().getRowFormatter().addStyleName(row, ConstantesView.ESTILO_FILA1_PUNTERO);
		} else {				
			view.getDetalle().getRowFormatter().addStyleName(row, ConstantesView.ESTILO_FILA2_PUNTERO);
		}		
	}

	protected void seleccionar(SucursalDTO sucursalDTO, Integer rowEdit) {
		sucursalEditDTO = sucursalDTO;
		rowEditSucursal= rowEdit;
		view.setNombre(sucursalDTO.getNombre());
	}

	private SucursalDTO buildDTO(boolean buscar) {
		SucursalDTO sucursalDTO = new SucursalDTO();
		if (buscar){
			sucursalDTO.setNombre(view.getDatoBusqueda());
		}
		else{
			sucursalDTO.setNombre(view.getNombre());
		}
		return sucursalDTO;
	}

	private boolean validarGuardar() {
		return view.getNombre()!= null;
	}

	@Override
	public void crear() {
		if (rowEditSucursal != null)
			view.disabledRadioButton(rowEditSucursal);
		view.limpiarCrear();
		sucursalEditDTO =null;
		rowEditSucursal = null;			
	}

	@Override
	public void limpiar() {
		sucursalEditDTO = null;
		rowEditSucursal = null;
		view.limpiar();			
	}
	
	@Override
	public void seleccionar() {
		cerrar(sucursalEditDTO);			
	}

	@Override
	public void cerrar() {
		cerrar(null);			
	}
	
	private void cerrar(ListBoxItem item){
		hidePopUp();
		limpiar();
		view.showPopUp(false);
		clientFactory.getEventBus().fireEvent(new SelectedItemEvent(item));
	}

}
