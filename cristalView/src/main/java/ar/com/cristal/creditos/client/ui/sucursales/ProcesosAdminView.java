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
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

public class ProcesosAdminView extends Composite {

	private static ProcesosAdminViewUiBinder uiBinder = GWT
			.create(ProcesosAdminViewUiBinder.class);

	interface ProcesosAdminViewUiBinder extends UiBinder<Widget, ProcesosAdminView> {
	}
	
	interface Presenter {
		void goTo(Place place);
		void leerRdoPago();
		void escribirRdoPago();
		void cerrar();
	}


	Presenter presenter;
	
	@UiField
	Button botonEscribirRdoPago;
	
	@UiField
	Button botonLeerRdoPago;
	
	@UiField
	Button botonCerrar;
	
	@UiField
	DivElement containerPopUp;
	
	
	
	public ProcesosAdminView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public ProcesosAdminView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	
	}
	
	protected String getText(String texto){
		if (!"".equals(texto))
			return texto.trim();
		return null;
	}

	@UiHandler(value="botonCerrar")
	public void onClickCerrar(ClickEvent event){
		presenter.cerrar();
	}
	
	
	@UiHandler(value="botonLeerRdoPago")
	public void onClickLeerRdoPago(ClickEvent event){
		presenter.leerRdoPago();
	}

	@UiHandler(value="botonEscribirRdoPago")
	public void onClickEscribirRdoPago(ClickEvent event){
		presenter.escribirRdoPago();
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public void showPopUp(boolean show){
		botonCerrar.setVisible(show);
		if (show) {
			UIObject.setStyleName(containerPopUp, "popUPContainer");
		}
		else{
			UIObject.setStyleName(containerPopUp, "");
		}			
	}
}
