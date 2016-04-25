package ar.com.cristal.creditos.client.ui.sucursales;

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

public class ABMSucursalView extends Composite {

	private static ABMSucursalViewUiBinder uiBinder = GWT
			.create(ABMSucursalViewUiBinder.class);

	interface ABMSucursalViewUiBinder extends UiBinder<Widget, ABMSucursalView> {
	}
	
	interface Presenter {
		void goTo(Place place);
		void buscar();
		void guardar();
		void crear();
		void limpiar();
		void seleccionar();
		void cerrar();
	}


	Presenter presenter;
	
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
	DivElement containerPopUp;
	
	
	@UiField
	TextBox sucursalBusqueda;
	
	@UiField
	TextBox nombre;
	
	public ABMSucursalView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public ABMSucursalView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	
	}
	
	public void initTable(){
		detalle.removeAllRows();
		detalle.setCellPadding(0);
		detalle.setCellSpacing(0);
		detalle.getRowFormatter().addStyleName(0, "header");
		setHeaderDetail(detalle);
	}
	
	protected String getText(String texto){
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

	
	public void limpiarBuscar(boolean esBuscar) {
		limpiarCrear();
		limpiarCampoBuscar(esBuscar);
		int row = detalle.getRowCount();
		for (int i = 1; i < row; i++) {
			detalle.removeRow(1);
		}	
	}

	public FlexTable getDetalle() {
		return detalle;
	}

	private void setHeaderDetail(FlexTable detalle) {
		detalle.setHTML(0, 0, "&nbsp");
		detalle.setText(0, 1,"Nombre");
	}

	public void limpiarCrear() {
		setNombre("");
	}
	
	public String getNombre(){
		return getText(nombre.getText());
	}
	
	public void setNombre(String nombre){
		this.nombre.setText(nombre);
	}

	
	public void limpiarCampoBuscar(boolean esBuscar) {
		if (!esBuscar){
			sucursalBusqueda.setText("");
		}
	}
	
	public String getDatoBusqueda(){
		return getText(sucursalBusqueda.getText());
	}
}
