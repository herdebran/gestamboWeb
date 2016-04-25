package ar.com.cristal.creditos.client.ui.event;

import ar.com.cristal.creditos.client.ui.event.handler.AddClientEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class AddClientEvent extends GwtEvent<AddClientEventHandler> {

	private String nameClient;
	
	 public AddClientEvent(String name) {
		 nameClient =name;
	 }
	
	 public static Type<AddClientEventHandler> TYPE = new Type<AddClientEventHandler>();
	  
	  @Override
	  public Type<AddClientEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(AddClientEventHandler handler) {
	    handler.onAddClient(this);
	  }

	  public String getNameClient() {
		return nameClient;
	  }
	  
	  
	  
}
