package ar.com.cristal.creditos.client.localidad.ui;

import java.util.List;

import ar.com.cristal.creditos.client.localidad.ProvinciaDTO;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;
import ar.com.snoop.gwt.commons.client.widget.ListBox;
import ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

public class BusquedaLocalidadView extends Composite  {
	

	public interface Presenter {
		void goTo(Place place);
		void buscar();
		void guardar();
		void crear();
		void limpiar();
		void cerrar();
		void seleccionar();
	}

	private Presenter presenter;
	
	@UiField
	TextBox localidadBusqueda;
	
	@UiField
	Button botonBuscar;
	
	@UiField
	Button botonLimpiar;
	
	@UiField
	Button botonGuardar;
	
	@UiField
	Button botonCrear;
	
	@UiField
	Button botonCerrar;
	
	@UiField
	Button botonSeleccionar;
	
	@UiField
	FlexTable detalle;
	
	@UiField
	ListBox provincia = new ListBox();
	
	@UiField
	TextBox localidad;
	
	@UiField
	RegExpTextBoxImpl codigoPostal;
	
		
	@UiField
	DivElement containerPopUp;
	
	
	private static BusquedaLocalidadViewUiBinder uiBinder = GWT
			.create(BusquedaLocalidadViewUiBinder.class);

	interface BusquedaLocalidadViewUiBinder extends
			UiBinder<Widget, BusquedaLocalidadView> {
	}

	public BusquedaLocalidadView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void initTable(){
		detalle.removeAllRows();
		detalle.setCellPadding(0);
		detalle.setCellSpacing(0);
		detalle.getRowFormatter().addStyleName(0, "header");
		detalle.setHTML(0, 0, "&nbsp");
		detalle.setText(0, 1,"CP");
		detalle.setText(0, 2,"Localidad");
		detalle.setText(0, 3,"Provincia");
	}
	

	public BusquedaLocalidadView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public String getLocalidadBusqueda(){
		return getText(localidadBusqueda.getText());
	}
	
	public String getLocalidad(){
		return getText(localidad.getText());
	}
	
	public void setLocalidad(String text){
		localidad.setText(text);
	}
	
	public String getCodigoPostal(){
		return getText(codigoPostal.getText());
	}
	
	public void setCodigoPostal(String text){
		codigoPostal.setText(text);
	}
	
	public ListBoxItem getProvincia(){
		return provincia.getSelectedItem();
	}
	
	public void setProvincia(ListBoxItem item){
		provincia.setSelectedItem(item);
	}
	
	
	
	private String getText(String texto){
		if (!"".equals(texto))
			return texto.trim();
		return null;
	}

	@UiHandler(value="botonLimpiar")
	public void onClickLimpiar(ClickEvent event){
		presenter.limpiar();
	}
	
	@UiHandler(value="botonBuscar")
	public void onClickBuscar(ClickEvent event){
		presenter.buscar();
	}
	
	@UiHandler(value="botonGuardar")
	public void onClickGuardar(ClickEvent event){
		presenter.guardar();
	}
	
	@UiHandler(value="botonCrear")
	public void onClickCrear(ClickEvent event){
		presenter.crear();
	}
	
	@UiHandler(value="botonCerrar")
	public void onClickCerrar(ClickEvent event){
		presenter.cerrar();
	}
	
	
	@UiHandler(value="botonSeleccionar")
	public void onClickSeleccionar(ClickEvent event){
		presenter.seleccionar();
	}

	public void limpiar(){
		limpiarBuscar(false);
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public void showPopUp(boolean show){
		botonCerrar.setVisible(show);
		botonSeleccionar.setVisible(show);
		if (show) {
			UIObject.setStyleName(containerPopUp, "popUPContainer");
		}
		else{
			UIObject.setStyleName(containerPopUp, "");
		}			
	}

	public void disabledRadioButton(Integer row) {
		((RadioButton)detalle.getWidget(row, 0)).setValue(false);
	}

	public void limpiarCrear() {
		setLocalidad("");
		setProvincia(null);
		setCodigoPostal("");
	}
	
	public void limpiarBuscar(boolean esBuscar) {
		limpiarCrear();
		if (!esBuscar)
			localidadBusqueda.setText("");
		int row = detalle.getRowCount();
		for (int i = 1; i < row; i++) {
			detalle.removeRow(1);
		}	
	}

	public FlexTable getDetalle() {
		return detalle;
	}

	public void setProvincias(List<ProvinciaDTO> provinciasDTO) {
		provincia.clear();
		provincia.addAllItems(provinciasDTO);
	}


}
