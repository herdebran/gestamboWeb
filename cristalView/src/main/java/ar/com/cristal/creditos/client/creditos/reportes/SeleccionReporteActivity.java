
package ar.com.cristal.creditos.client.creditos.reportes;

import java.util.Date;
import java.util.List;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.dto.ClienteDTO;
import ar.com.cristal.creditos.client.dto.TipoReporteDTO;
import ar.com.cristal.creditos.client.ui.util.ClientContext;
import ar.com.cristal.creditos.client.ui.util.CustomAbstractActivity;
import ar.com.cristal.creditos.client.ui.util.InicializarCombos;
import ar.com.cristal.creditos.client.ui.util.PopUpInfo;
import ar.com.cristal.creditos.client.widget.LinkInfoPopupDTO;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Activities are started and stopped by an ActivityManager associated with a container Widget.
 */
public class SeleccionReporteActivity extends CustomAbstractActivity implements SeleccionReporteView.Presenter {

	
	private ClientFactory clientFactory;
	public PopUpInfo popup=null;
	private ClientContext clientContext = ClientContext.getInstance();
	SeleccionReporteView view;
	//el token contiene el id de usuario
	private String token;
	private ClienteDTO clienteDto = null;

	private final String ID_COMPONENTE_ACTIVITY = "REPORTES";

	public SeleccionReporteActivity(SeleccionReportePlace place, ClientFactory cf) {
		clientFactory = cf;		
		view = clientFactory.getSeleccionReporteView();
		popup = clientFactory.getPopUp();		
		token = place.getToken();
		
	}

	
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		super.start(containerWidget, eventBus, ID_COMPONENTE_ACTIVITY);
		view.setPresenter(this);
		containerWidget.setWidget(view.asWidget());
		
		
	}
		
	private void inicializarCombos(){
		InicializarCombos.inicializarComboTipoReporte(null, view.tipoReporte, clientFactory);	
	}
	
	@Override
	public String mayStop() {
		return null;
	}
	
	public ClienteDTO getClienteDto() {
		return clienteDto;
	}


	public void setClienteDto(ClienteDTO clienteDto) {
		this.clienteDto = clienteDto;
	}


	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
		
	}


	private boolean validarCampos() {
		if (view.fechaDesde.getSelectedDate() == null || view.fechaHasta.getSelectedDate() == null){
			popup.mostrarMensaje("Las fechas son obligatorias");
			return false;
		} else {
			Date desde = view.fechaDesde.getSelectedDate();
			Date hasta =  view.fechaHasta.getSelectedDate();
			if (desde.compareTo(hasta) > 0)
			{
				popup.mostrarMensaje("La fecha desde debe ser menor que la fecha hasta");
				return false;
			}
		}
		
		return true;

		
	}
	
	


	public void generarReportePorTipo(Date fechaInicio, Date fechaFin, TipoReporteDTO tipoReporte) {
		if (validarCampos()){
			popup.mostrarMensaje("Información", "Generando el reporte... espere un momento por favor.");

		}
	}


	@Override
	public void inicializarActivity() {
		
		view.inicializarControles();
		inicializarCombos();
	}


	

	
}
