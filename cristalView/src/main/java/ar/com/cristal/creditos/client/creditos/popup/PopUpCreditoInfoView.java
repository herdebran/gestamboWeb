package ar.com.cristal.creditos.client.creditos.popup;

import java.util.List;

import ar.com.snoop.gwt.commons.client.widget.ListBox;
import ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * Sample implementation of {@link PopUpCreditoInfoView}.
 */
public class PopUpCreditoInfoView extends DialogBox implements IsWidget {

	interface Binder extends UiBinder<Widget, PopUpCreditoInfoView> {
	}
	
	private static final Binder binder = GWT.create(Binder.class);
	
	public interface Presenter {
		/**
		 * Navigate to a new Place in the browser.
		 */
		void goTo(Place place);
		
		void addClient(String name);
	}

	private Presenter listener;
	
	@UiField
	Button aceptar;
	

	@UiField
	Label titulo;
	
		
	
	@UiField
	Label nombreLineaCredito;
	
		
	@UiField
	TextBox montoPrestamo;
	
	
	@UiField
	TextBox cuotasPagas;
	
	@UiField
	TextBox cuotasImpagas;
	
	@UiField
	TextBox cuotasRestantes;
	
	@UiField
	TextBox valorCuota;
	
	@UiField
	TextBox montoDeuda;
	
	
	@UiField
	TextBox gastoCarta;
	
	
	public PopUpCreditoInfoView() {
		setModal(true);
		setAutoHideEnabled(false);
		setWidget(binder.createAndBindUi(this));
		center();	
		
		show();		
	}

	
	public void setTitulo(String titulo){
		this.titulo.setText(titulo);
		
	}
	
	
	
	public void setPresenter(Presenter listener) {
		this.listener = listener;
	}

	@UiHandler("aceptar")
	void onButtonClick(ClickEvent event) {
		
		hide();
		
	}


	


	public void inicalizarControles() {
		nombreLineaCredito.setText("");
		montoPrestamo.setText("");
		cuotasPagas.setText("");
		cuotasImpagas.setText("");
		montoDeuda.setText("");
		valorCuota.setText("");
		
	}
}
