package ar.com.cristal.creditos.client.tambo.rodeos.ui;

import java.util.ArrayList;
import java.util.List;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.event.SelectedItemEvent;
import ar.com.cristal.creditos.client.tambo.dto.RodeoDTO;
import ar.com.cristal.creditos.client.tambo.dto.TipoRodeoEnumDTO;
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

public class BusquedaRodeosActivity extends CustomAbstractActivity implements BusquedaRodeosView.Presenter {
	
	private ClientFactory clientFactory;
	private PopUpInfo popUpInfo;
	private BusquedaRodeosView view;
	private RodeoDTO rodeoEditDTO = null;
	private Integer rowEdit=null;
	private List<RodeoDTO> rodeos = new ArrayList<RodeoDTO>();
	
	public BusquedaRodeosActivity(BusquedaRodeosPlace place, ClientFactory cf) {
		clientFactory = cf;
		popUpInfo = clientFactory.getPopUp();
	}
	
	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus) {
		super.start(container, eventBus, "ABM_LOCALIDAD");
		view = clientFactory.getBusquedaRodeosView();
		container.setWidget(view.asWidget());

	}

	@Override
	public void inicializarActivity() {
		view.setPresenter(this);
		view.initTable();
		InicializarCombos.inicializarComboTipoRodeo("", view.tipo);
	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);		
	}
	
	public void startInPopUp() {
		view = clientFactory.getBusquedaRodeosView();
		startInPopUp(view);
		view.showPopUp(true);
	}
	

	@Override
	public void buscar() {
		popUpInfo.mostrarMensaje("Buscando rodeos... espere un momento por favor.");
		clientFactory.getVacasService().buscarRodeoPorNombre(view.rodeoBusqueda.getText(), new AsyncCallback<List<RodeoDTO>>() {
			@Override
			public void onSuccess(List<RodeoDTO> rodeosDTO) {
				popUpInfo.ocultar();
				cargarDetalle(rodeosDTO);
			}
			
			@Override
			public void onFailure(Throwable arg0) {
				popUpInfo.mostrarMensaje("Error: ", arg0.getMessage());
			}
		});
		
	}
	
	private RodeoDTO buildDTO(boolean buscar) {
		RodeoDTO rodeoDTO = new RodeoDTO();
		if (buscar){
			rodeoDTO.setNombre(view.getRodeoBusqueda());
		}
		else{
			//Aca llenar los campos del DTO con los elementos de la pantalla
			rodeoDTO.setNombre(view.nombre.getText());
			rodeoDTO.setTipoRodeo(TipoRodeoEnumDTO.valueOf(view.tipo.getSelectedItemText()));
		}
		return rodeoDTO;

	}
	
	private void cargarDetalle(List<RodeoDTO> rodeosDTOs){
		this.rodeos = rodeosDTOs;
		view.limpiar();
		view.initTable();
		int i = 1;
		for (RodeoDTO rDTO : rodeos) {
			cargarDetalle(rDTO, i,true);
			i++;
		}
		rowEdit = null;
	}
	
	private void cargarDetalle(RodeoDTO rodeoDTO,Integer row,boolean esCreacion){
		if (esCreacion){
			RadioButton chk = new RadioButton("id_rodeo");
			chk.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					Cell cellEdit =  view.getDetalle().getCellForEvent(event);
					Integer rowEdit = cellEdit.getRowIndex();
					seleccionarRodeo(rodeos.get(rowEdit-1),rowEdit);					
				}
			});
			view.getDetalle().setWidget(row, 0,chk);
		}		
		view.getDetalle().setText(row, 1,rodeoDTO.getNombre());
		view.getDetalle().setText(row, 2,rodeoDTO.getTipoRodeo().getItemText());
		if (row % 2 == 0) {
			view.getDetalle().getRowFormatter().addStyleName(row, ConstantesView.ESTILO_FILA1_PUNTERO);
		} else {				
			view.getDetalle().getRowFormatter().addStyleName(row, ConstantesView.ESTILO_FILA2_PUNTERO);
		}
	}
	
	private void seleccionarRodeo(RodeoDTO rodeoDTO,Integer rowEdit){
		rodeoEditDTO = rodeoDTO;
		rowEdit = rowEdit;
		
		//Aca llenar los elementos de la vista con Datos
		view.nombre.setText(rodeoDTO.getNombre());
		view.tipo.selectByValue(rodeoDTO.getTipoRodeo().getItemValue());
	}

	@Override
	public void guardar() {
		RodeoDTO rodeoDTO = buildDTO(false);
		if (validarGuardar(rodeoDTO)){
			if (rodeoEditDTO!= null)
				rodeoDTO.setId(rodeoEditDTO.getId());
			
			popUpInfo.mostrarMensaje("Guardando Rodeo... espere un momento por favor.");
			clientFactory.getVacasService().guardarRodeoRPC(rodeoDTO, new AsyncCallback<RodeoDTO>(){

				@Override
				public void onFailure(Throwable arg) {
					popUpInfo.mostrarMensaje("Error: ", arg.getMessage());
					
				}

				@Override
				public void onSuccess(RodeoDTO rodeoGuardadoDTO) {
					popUpInfo.ocultar();
					//Actualizar detalle o agregar nuevo Row
					Integer row = view.getDetalle().getRowCount();
					if (rodeoEditDTO!= null){
						rodeoEditDTO.setId(rodeoGuardadoDTO.getId());
						rodeoEditDTO.setNombre(rodeoGuardadoDTO.getNombre());
						rodeoEditDTO.setTipoRodeo(rodeoGuardadoDTO.getTipoRodeo());
						row = rowEdit;
					} else{
						rodeos.add(rodeoGuardadoDTO);
					}
					cargarDetalle(rodeoGuardadoDTO,row,rodeoEditDTO == null);
					crear();
				}
				
			});

		}
		else{
			popUpInfo.mostrarMensaje("Debe completar los campos obligatorios del rodeo.");
		}
		
	}
	
	private boolean validarGuardar(RodeoDTO rodeoDTO){
		return rodeoDTO.getNombre() != null && 
				rodeoDTO.getTipoRodeo()!=null;
	}
	

	@Override
	public void crear() {
		if (rowEdit != null)
			view.disabledRadioButton(rowEdit);
		view.limpiarCrear();
		rodeoEditDTO =null;
		rowEdit = null;	
	}

	@Override
	public void limpiar() {
		rodeoEditDTO = null;
		rowEdit = null;
		view.limpiar();		
	}

	@Override
	public void cerrar() {
		cerrar(null);	
		
	}

	@Override
	public void seleccionar() {
		cerrar(rodeoEditDTO);		
	}
	
	private void cerrar(ListBoxItem item){
		hidePopUp();
		limpiar();
		view.showPopUp(false);
		clientFactory.getEventBus().fireEvent(new SelectedItemEvent(item));
	}

}
