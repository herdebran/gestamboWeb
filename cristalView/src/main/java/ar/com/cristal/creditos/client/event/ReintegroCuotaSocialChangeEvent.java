package ar.com.cristal.creditos.client.event;

import ar.com.cristal.creditos.client.handler.ReintegrosCuotasSocialesChangeEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class ReintegroCuotaSocialChangeEvent extends GwtEvent<ReintegrosCuotasSocialesChangeEventHandler> {
	 
	private Boolean confirmoOk; 
	 
	 public Boolean getConfirmoOk() {
		return confirmoOk;
	}

	public void setConfirmoOk(Boolean confirmoOk) {
		this.confirmoOk = confirmoOk;
	}

	public ReintegroCuotaSocialChangeEvent(Boolean b) {
		 this.confirmoOk=b;
	 }
	
	 public static Type<ReintegrosCuotasSocialesChangeEventHandler> TYPE = new Type<ReintegrosCuotasSocialesChangeEventHandler>();
	  
	  @Override
	  public Type<ReintegrosCuotasSocialesChangeEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(ReintegrosCuotasSocialesChangeEventHandler handler) {
	    handler.onChange(this);
	  }

		 
	  
	  
}
