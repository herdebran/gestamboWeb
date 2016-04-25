package ar.com.cristal.creditos.client.widget;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * Sample implementation of {@link PopUpInfoView}.
 */
public class PopUpInfoView extends DialogBox implements IsWidget {

	private static final int UMBRAL_SCROLL_PARA_LISTA = 7;

	private static final int UMBRAL_SCROLL_PARA_TEXTO = 600;

	interface Binder extends UiBinder<Widget, PopUpInfoView> {
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
	Label informacion;
	
	@UiField
	Label titulo;
	
	
	@UiField
	DivElement informacionDiv;
	
	@UiField
	FlexTable tablaInformacion;

	public PopUpInfoView() {
		setModal(false);
		setAutoHideEnabled(false);
		setWidget(binder.createAndBindUi(this));
		setAnimationEnabled(false);
		setGlassEnabled(false);
		
		center();
		
		this.setPopupPosition(getPopupLeft(), getPopupTop()+50);
		
//		show();		
	}

	
	public void setTitulo(String titulo){
		informacionDiv.setAttribute("class", "popupDivNoScroll");
		this.titulo.setText(titulo);
		
		
	}
	
	
	public void setInformacion(String informacion){
		informacionDiv.setAttribute("class", "popupDivNoScroll");
		this.informacion.setText(informacion);	
		if (informacion.length() > UMBRAL_SCROLL_PARA_TEXTO)
			informacionDiv.setAttribute("class", "popupDiv");
	}
	
	
	public void setInfo(String titulo, String informacion){
		informacionDiv.setAttribute("class", "popupDivNoScroll");
		this.titulo.setText(titulo);
		this.informacion.setText(informacion);		
		if (informacion.length() > UMBRAL_SCROLL_PARA_TEXTO)
			informacionDiv.setAttribute("class", "popupDiv");
	}
	
	public void setPresenter(Presenter listener) {
		this.listener = listener;
	}

	@UiHandler("aceptar")
	void onButtonClick(ClickEvent event) {
		
		hide();
		
	}


	public void setInformacion(List<String> info) {
		informacionDiv.setAttribute("class", "popupDivNoScroll");
		tablaInformacion.setVisible(true);
		informacion.setVisible(false);
		
		tablaInformacion.removeAllRows();
		
		int i = 0;
		for (String str : info) {
			tablaInformacion.setWidget(0, i, new HTML(str));
			i++;
		}
		
		
		if (info.size() > UMBRAL_SCROLL_PARA_LISTA){
			informacionDiv.setAttribute("class", "popupDiv");
		}
	}
	
	
	public void setInformacion(String titulo, List<String> info) {
		informacionDiv.setAttribute("class", "popupDivNoScroll");
		this.titulo.setText(titulo);
		tablaInformacion.setVisible(true);
		informacion.setVisible(false);
		
		tablaInformacion.removeAllRows();
		
		int i = 0;
		for (String str : info) {
			tablaInformacion.setWidget(i, 0, new HTML(str));
			i++;
		}
		
		if (info.size() > UMBRAL_SCROLL_PARA_LISTA){
			informacionDiv.setAttribute("class", "popupDiv");
		}
	}
	
	/**
	 * Lista la informacion en la tabla donde cada linea de la tabla es un link
	 * @param titulo
	 * @param info
	 */
	
	public void setInformacionListadaConLink(String titulo, List<LinkInfoPopupDTO> lista) {
		this.titulo.setText(titulo);
		tablaInformacion.setVisible(true);
		informacion.setVisible(false);
		this.setModal(false);
		
		informacionDiv.setAttribute("class", "popupDivNoScroll");
		
		tablaInformacion.removeAllRows();
		
		int i = 0;
		for (LinkInfoPopupDTO dto : lista) {
			tablaInformacion.setWidget(i, 0, new Anchor(dto.getTextoDelLink(), dto.getUtl(), "_blank"));
			i++;
		}
		
		if (lista.size() > UMBRAL_SCROLL_PARA_LISTA){
			informacionDiv.setAttribute("class", "popupDiv");
		}
		
	}
	
	
	
}
