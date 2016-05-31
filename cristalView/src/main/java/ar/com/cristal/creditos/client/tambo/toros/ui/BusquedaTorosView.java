package ar.com.cristal.creditos.client.tambo.toros.ui;

import ar.com.cristal.creditos.client.ui.util.RegularExpressionConstants;
import ar.com.snoop.gwt.commons.client.widget.ListBox;
import ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

public class BusquedaTorosView extends Composite  {
	

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
	TextBox toroBusqueda;
	
	@UiField
	Button btnBuscar;
	
	@UiField
	Button btnLimpiar;
	
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
	ListBox raza = new ListBox();
	
	@UiField
	TextBox nombre;
	
	@UiField
	RegExpTextBoxImpl hba;
	

	@UiField
	CheckBox animalVivo;
	
	@UiField
	DivElement containerPopUp;
	
	
	private static BusquedaLocalidadViewUiBinder uiBinder = GWT
			.create(BusquedaLocalidadViewUiBinder.class);

	interface BusquedaLocalidadViewUiBinder extends
			UiBinder<Widget, BusquedaTorosView> {
	}

	public BusquedaTorosView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void initTable(){
		detalle.removeAllRows();
		detalle.setCellPadding(0);
		detalle.setCellSpacing(0);
		detalle.getRowFormatter().addStyleName(0, "header");
		detalle.setHTML(0, 0, "&nbsp");
		detalle.setText(0, 1,"Nombre");
		detalle.setText(0, 2,"HBA");
	}
	

	public BusquedaTorosView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		inicializarValidadores();
	}
	
	public String getToroBusqueda(){
		return getText(toroBusqueda.getText());
	}
	
	private void inicializarValidadores() {
		hba.setExpresionRegular(RegularExpressionConstants.numeroLetrasEspacioGuion);
	}

	
	private String getText(String texto){
		if (!"".equals(texto))
			return texto.trim();
		return null;
	}

	@UiHandler(value="btnLimpiar")
	public void onClickLimpiar(ClickEvent event){
		presenter.limpiar();
	}
	
	@UiHandler(value="btnBuscar")
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

	@UiHandler(value="toroBusqueda")
	public void onKeyDown(KeyDownEvent event){
		if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER)
			presenter.buscar();
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
		nombre.setText("");
		hba.setValue("");
		animalVivo.setValue(false);
		raza.selectByText("");
	}
	
	public void limpiarBuscar(boolean esBuscar) {
		limpiarCrear();
		if (!esBuscar)
			toroBusqueda.setText("");
		int row = detalle.getRowCount();
		for (int i = 1; i < row; i++) {
			detalle.removeRow(1);
		}	
	}

	public FlexTable getDetalle() {
		return detalle;
	}


}
