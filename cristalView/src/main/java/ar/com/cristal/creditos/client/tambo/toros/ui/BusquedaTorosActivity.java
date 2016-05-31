package ar.com.cristal.creditos.client.tambo.toros.ui;

import java.util.ArrayList;
import java.util.List;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.event.SelectedItemEvent;
import ar.com.cristal.creditos.client.tambo.dto.ToroDTO;
import ar.com.cristal.creditos.client.ui.util.ConstantesView;
import ar.com.cristal.creditos.client.ui.util.CustomAbstractActivity;
import ar.com.cristal.creditos.client.ui.util.InicializarCombos;
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

public class BusquedaTorosActivity extends CustomAbstractActivity implements BusquedaTorosView.Presenter {
	
	private ClientFactory clientFactory;
	private PopUpInfo popUpInfo;
	private BusquedaTorosView view;
	private ToroDTO toroEditDTO = null;
	private Integer rowEdit=null;
	private List<ToroDTO> toros = new ArrayList<ToroDTO>();
	
	public BusquedaTorosActivity(BusquedaTorosPlace place, ClientFactory cf) {
		clientFactory = cf;
		popUpInfo = clientFactory.getPopUp();
	}
	
	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus) {
		super.start(container, eventBus, "ABM_LOCALIDAD");
		view = clientFactory.getBusquedaTorosView();
		container.setWidget(view.asWidget());

	}

	@Override
	public void inicializarActivity() {
		view.setPresenter(this);
		view.initTable();
		InicializarCombos.inicializarComboRaza("", view.raza);
	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);		
	}
	
	public void startInPopUp() {
		view = clientFactory.getBusquedaTorosView();
		startInPopUp(view);
		view.showPopUp(true);
	}
	

	@Override
	public void buscar() {
		popUpInfo.mostrarMensaje("Buscando toros... espere un momento por favor.");
		clientFactory.getVacasService().buscarToroPorNombre(view.toroBusqueda.getText(), new AsyncCallback<List<ToroDTO>>() {
			@Override
			public void onSuccess(List<ToroDTO> torosDTO) {
				popUpInfo.ocultar();
				cargarDetalle(torosDTO);
			}
			
			@Override
			public void onFailure(Throwable arg0) {
				popUpInfo.mostrarMensaje("Error: ", arg0.getMessage());
			}
		});
		
	}
	
	private ToroDTO buildDTO(boolean buscar) {
		ToroDTO toroDTO = new ToroDTO();
		if (buscar){
			toroDTO.setNombre(view.getToroBusqueda());
		}
		else{
			//Aca llenar los campos del DTO con los elementos de la pantalla
			toroDTO.setNombre(view.nombre.getText());
			toroDTO.setHba(view.hba.getValue());
			toroDTO.setRaza_id(Long.valueOf(view.raza.getSelectedItemId()));
			toroDTO.setAnimalVivo(view.animalVivo.getValue());
		}
		return toroDTO;

	}
	
	private void cargarDetalle(List<ToroDTO> toroDTOs){
		this.toros = toroDTOs;
		view.limpiar();
		view.initTable();
		int i = 1;
		for (ToroDTO toroDTO : toros) {
			cargarDetalle(toroDTO, i,true);
			i++;
		}
		rowEdit = null;
	}
	
	private void cargarDetalle(ToroDTO toroDTO,Integer row,boolean esCreacion){
		if (esCreacion){
			RadioButton chk = new RadioButton("id_reparticion");
			chk.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					Cell cellEdit =  view.getDetalle().getCellForEvent(event);
					Integer rowEdit = cellEdit.getRowIndex();
					seleccionarToro(toros.get(rowEdit-1),rowEdit);					
				}
			});
			view.getDetalle().setWidget(row, 0,chk);
		}		
		view.getDetalle().setText(row, 1,toroDTO.getNombre());
		view.getDetalle().setText(row, 2,toroDTO.getHba());
		if (row % 2 == 0) {
			view.getDetalle().getRowFormatter().addStyleName(row, ConstantesView.ESTILO_FILA1_PUNTERO);
		} else {				
			view.getDetalle().getRowFormatter().addStyleName(row, ConstantesView.ESTILO_FILA2_PUNTERO);
		}
	}
	
	private void seleccionarToro(ToroDTO toroDTO,Integer rowEdit){
		toroEditDTO = toroDTO;
		rowEdit = rowEdit;
		
		//Aca llenar los elementos de la vista con Datos
		view.nombre.setText(toroDTO.getNombre());
		view.hba.setText(toroDTO.getHba());
		view.raza.selectByValue(toroDTO.getRaza_id().toString());
		view.animalVivo.setValue(toroDTO.getAnimalVivo());
	}

	@Override
	public void guardar() {
		ToroDTO toroDTO = buildDTO(false);
		if (validarGuardar(toroDTO)){
			if (toroEditDTO!= null)
				toroDTO.setId(toroEditDTO.getId());
			
			popUpInfo.mostrarMensaje("Guardando Toro... espere un momento por favor.");
			clientFactory.getVacasService().persistirToroRPC(toroDTO, new AsyncCallback<ToroDTO>(){

				@Override
				public void onFailure(Throwable arg) {
					popUpInfo.mostrarMensaje("Error: ", arg.getMessage());
					
				}

				@Override
				public void onSuccess(ToroDTO toroGuardadoDTO) {
					popUpInfo.ocultar();
					//Actualizar detalle o agregar nuevo Row
					Integer row = view.getDetalle().getRowCount();
					if (toroEditDTO!= null){
						toroEditDTO.setId(toroGuardadoDTO.getId());
						toroEditDTO.setNombre(toroGuardadoDTO.getNombre());
						toroEditDTO.setHba(toroGuardadoDTO.getHba());
						toroEditDTO.setRaza_id(toroGuardadoDTO.getRaza_id());
						toroEditDTO.setAnimalVivo(toroGuardadoDTO.getAnimalVivo());
						row = rowEdit;
					} else{
						toros.add(toroGuardadoDTO);
					}
					cargarDetalle(toroGuardadoDTO,row,toroEditDTO == null);
					crear();
				}
				
			});

		}
		else{
			popUpInfo.mostrarMensaje("Debe completar los campos obligatorios del toro.");
		}
		
	}
	
	private boolean validarGuardar(ToroDTO toroDTO){
		return toroDTO.getNombre() != null && 
				toroDTO.getRaza_id() != null && 
				toroDTO.getHba()!=null;
	}
	

	@Override
	public void crear() {
		if (rowEdit != null)
			view.disabledRadioButton(rowEdit);
		view.limpiarCrear();
		toroEditDTO =null;
		rowEdit = null;	
	}

	@Override
	public void limpiar() {
		toroEditDTO = null;
		rowEdit = null;
		view.limpiar();		
	}

	@Override
	public void cerrar() {
		cerrar(null);	
		
	}

	@Override
	public void seleccionar() {
		cerrar(toroEditDTO);		
	}
	
	private void cerrar(ListBoxItem item){
		hidePopUp();
		limpiar();
		view.showPopUp(false);
		clientFactory.getEventBus().fireEvent(new SelectedItemEvent(item));
	}

}
