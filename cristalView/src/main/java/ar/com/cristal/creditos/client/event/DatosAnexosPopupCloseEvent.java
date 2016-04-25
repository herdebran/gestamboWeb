package ar.com.cristal.creditos.client.event;

import java.util.List;

import ar.com.cristal.creditos.client.dto.DatoAnexoDTO;
import ar.com.cristal.creditos.client.handler.DatosAnexosPopupCloseEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class DatosAnexosPopupCloseEvent extends GwtEvent<DatosAnexosPopupCloseEventHandler> {

	 private List<DatoAnexoDTO> datosAnexos; 
	 
	 public DatosAnexosPopupCloseEvent(List<DatoAnexoDTO> mov) {
		 this.datosAnexos = mov;
	 }
	
	 public static Type<DatosAnexosPopupCloseEventHandler> TYPE = new Type<DatosAnexosPopupCloseEventHandler>();
	  
	  @Override
	  public Type<DatosAnexosPopupCloseEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(DatosAnexosPopupCloseEventHandler handler) {
	    handler.onClose(this);
	  }

	  public List<DatoAnexoDTO> getDatosAnexos() {
		  return datosAnexos;
	  }
		 
	  
}
