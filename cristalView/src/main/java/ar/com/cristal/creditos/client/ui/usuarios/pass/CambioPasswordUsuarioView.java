package ar.com.cristal.creditos.client.ui.usuarios.pass;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.Widget;

public class CambioPasswordUsuarioView extends Composite  {

	public interface Presenter {
		public void guardar();
		public void volver();
		
	}
	
	@UiField
	PasswordTextBox password;
	
	@UiField
	PasswordTextBox nuevaPassword;
	
	@UiField
	PasswordTextBox confirmacionNuevaPassword;
	
	private Presenter presenter;
	
	
	private static final Binder uiBinder = GWT.create(Binder.class);


	interface Binder extends UiBinder<Widget, CambioPasswordUsuarioView> {
	}

	public CambioPasswordUsuarioView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	
	public CambioPasswordUsuarioView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler(value="guardar")
	public void onGuardarClick(ClickEvent click){
		presenter.guardar();
	}
	
	@UiHandler(value="cancelar")
	public void onVolverClick(ClickEvent click){
		presenter.volver();
	}


	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	private String getText(String texto){
		if (!"".equals(texto))
			return texto.trim();
		return null;
	}
	
	public String getPassword(){
		return getText(password.getText());
	}
	
	public String getNuevaPassword(){
		return getText(nuevaPassword.getText());
	}
	
	public String getConfirmacionNuevaPassword(){
		return getText(confirmacionNuevaPassword.getText());
	}


	public void clean() {
		password.setText("");
		nuevaPassword.setText("");
		confirmacionNuevaPassword.setText("");
		
	}
}
