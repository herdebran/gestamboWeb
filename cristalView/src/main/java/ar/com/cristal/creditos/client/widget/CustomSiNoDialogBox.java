package ar.com.cristal.creditos.client.widget;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CustomSiNoDialogBox  {
	private static DialogBox dialogbox = null;
	private static Button btnSi = null; 
    private static Button btnNo = null; 
	
	public static DialogBox dialogBox(String titulo, String preguntaSiNo) {
	
		dialogbox = new DialogBox(false);
		btnNo = new Button("No");
		btnSi = new Button("Si");
		
	    VerticalPanel dialogBoxContents = new VerticalPanel();	    
	    dialogbox.setText(titulo);
	    dialogbox.setStyleName("popupTitulo");
	    
	    
	    
	    HTML message = new HTML(preguntaSiNo);	    
	    message.setStyleName("popupContenido");
	    message.setWidth("400px");
	    		
		btnSi.setWidth("195px");
	    btnNo.setWidth("195px");
	    
	    btnSi.setVisible(true);
	    btnNo.setVisible(true);
	    
	    HorizontalPanel holder = new HorizontalPanel();
	    
	    holder.setStyleName("popupContenido");
	    	
	    holder.add(btnSi);
	    holder.add(btnNo);
	    
	    btnNo.setTabIndex(0);
	    
	    dialogBoxContents.add(message);
	    dialogBoxContents.add(holder);
	    dialogbox.setWidget(dialogBoxContents);
	    
	    dialogbox.center();
		dialogbox.show();
		
		return dialogbox;
	}
	
	
	public static void setHandlers(ClickHandler clickHandlerSi, ClickHandler clickHandlerNo){
		btnSi.addClickHandler(clickHandlerSi);
	    btnNo.addClickHandler(clickHandlerNo);
	}
	
	public static void hideBtn(String siNo){
		if (siNo.equalsIgnoreCase("si")){
//			btnSi.setWidth("0px");
//			btnNo.setWidth("200px");
   		    btnSi.setText(" ");
   		    btnNo.setText("No");
		} else {
//			btnNo.setWidth("0px");
//			btnSi.setWidth("200px");
			btnSi.setText("Si");
			btnNo.setText(" ");
		}
	}
	
	public static void showBtn(String siNo){
		if (siNo.equalsIgnoreCase("si")){
			btnSi.setVisible(true);
		} else {
			btnNo.setVisible(true);
		}
	}
	
	public static void inicializarTamBotones(){
//		btnNo.setWidth("100px");
//		btnSi.setWidth("100px");
		
		 btnSi.setVisible(true);
		 btnNo.setVisible(true);
		 
		 btnSi.setText("Si");
		 btnNo.setText("No");
		 
	}
	
	public static void ocultar(){
		if (dialogbox != null)
			dialogbox.hide();
	}
	
}
