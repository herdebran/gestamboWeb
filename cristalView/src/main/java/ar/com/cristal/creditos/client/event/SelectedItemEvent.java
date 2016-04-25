package ar.com.cristal.creditos.client.event;

import ar.com.cristal.creditos.client.handler.SelectedItemEventHandler;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

import com.google.gwt.event.shared.GwtEvent;

public class SelectedItemEvent extends GwtEvent<SelectedItemEventHandler> {

	 private ListBoxItem listBoxItem; 
	 
	 public SelectedItemEvent(ListBoxItem listBoxItem) {
		 this.listBoxItem = listBoxItem;
	 }
	
	 public static Type<SelectedItemEventHandler> TYPE = new Type<SelectedItemEventHandler>();
	  
	  @Override
	  public Type<SelectedItemEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(SelectedItemEventHandler handler) {
	    handler.onSelectItem(this);
	  }

	  public ListBoxItem getListBoxItem() {
		  return listBoxItem;
	  }
		 
	  
}
