package ar.com.cristal.creditos.client.ui.establecimientos;

import ar.com.cristal.creditos.client.ui.util.InicializarCombos;
import ar.com.snoop.gwt.commons.client.widget.ListBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

public class SeleccionEstablecimientoView extends Composite {

	private static SeleccionEstablecimientoViewUiBinder uiBinder = GWT
			.create(SeleccionEstablecimientoViewUiBinder.class);

	interface SeleccionEstablecimientoViewUiBinder extends UiBinder<Widget, SeleccionEstablecimientoView> {
	}
	
	interface Presenter {
		void goTo(Place place);
		void seleccionar();
		void cerrar();
	}


	Presenter presenter;
	
	@UiField
	Button btnCerrar;
	
	@UiField
	Button btnSeleccionar;
	
	@UiField
	ListBox cmbEstablecimiento;
	
	@UiField
	DivElement containerPopUp;

	
	public SeleccionEstablecimientoView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public SeleccionEstablecimientoView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	
	}
	
	
	@UiHandler(value="btnCerrar")
	public void onClickCerrar(ClickEvent event){
		presenter.cerrar();
	}
	
	
	@UiHandler(value="btnSeleccionar")
	public void onClickSeleccionar(ClickEvent event){
		presenter.seleccionar();
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public void inicializarCombos() {
		InicializarCombos.inicializarComboEstablecimientosUsuarioLogueado("",cmbEstablecimiento);
		
	}

	public void showPopUp(boolean show){
		btnCerrar.setVisible(show);
		btnSeleccionar.setVisible(show);
		if (show)
			UIObject.setStyleName(containerPopUp, "popUPContainer");
		else
			UIObject.setStyleName(containerPopUp, "");
		
	}
}
