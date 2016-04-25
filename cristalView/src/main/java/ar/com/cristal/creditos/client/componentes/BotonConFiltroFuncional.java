package ar.com.cristal.creditos.client.componentes;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.ClientFactoryImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

public class BotonConFiltroFuncional  extends Composite { 
//implements HasText, HasClickHandlers, ClickHandler{
	

	
	
	@UiField(provided=true)
	Label label = new Label("", true) ;
	
	public BotonConFiltroFuncional() {
		super();
		super.initWidget(this);

	}
	
	
//	public BotonConFiltroFuncional(String id) {
//		super();
//		initWidget(this);
//		obtenerPermisos(id);
//		//"BTN_MODIFICAR_CLIENTE"
//		
//	}


	private void obtenerPermisos(String id) {
		ClientFactory cf = GWT.create(ClientFactoryImpl.class);
		cf.getUsuarioService().tienePermisoAcceso(id, new AsyncCallback<Boolean>() {
			
			public void onSuccess(Boolean result) {
				ocultarMostrarBoton(result);
				
			}
			
			

			public void onFailure(Throwable caught) {
				// TODO agregar manejo
				
			}
		});
	}
	
	
	public void inicializar(String id){
		obtenerPermisos(id);
	}
	
	
	private void ocultarMostrarBoton(Boolean result) {
//		this.setEnabled(result);
		
	}
	
	public HandlerRegistration addClickHandler(ClickHandler handler) {
	return addHandler(handler, ClickEvent.getType());
	}
	
	public void onClick(ClickEvent event) {

	this.fireEvent(event);
	
	}
	
	public String getText() {
		return label.getText();
	}
	

	public void setText(String text) {
		label.setText(text);
	}
	
	}


	
	
	
	
	