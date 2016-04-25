
package ar.com.cristal.creditos.client.creditos.reportes;

import java.util.Date;

import ar.com.cristal.creditos.client.dto.TipoReporteDTO;
import ar.com.snoop.gwt.commons.client.widget.ListBox;
import ar.com.snoop.gwt.commons.client.widget.datepicker.FullDatePicker;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;


public class SeleccionReporteView extends Composite implements IsWidget {
  
	

	public interface Presenter {

		void goTo(Place place);
		
		void generarReportePorTipo(Date fechaInicio, Date fechaFin, TipoReporteDTO motivo);

	}
	
	
	interface Binder extends UiBinder<Widget, SeleccionReporteView> {
	}
	
	private static final Binder binder = GWT.create(Binder.class);

	private Presenter listener;
	
	public Integer opcionElegida=0;  //TODO: sacar esto cuando tenga los nombres de los places
	
	
	
			
	@UiField(provided=true)
	FullDatePicker fechaDesde = new FullDatePicker("");
	
	@UiField(provided=true)
	FullDatePicker fechaHasta = new FullDatePicker("");
	
	@UiField
	ListBox tipoReporte;
	
	
	@UiField
	Button buttonReporte;
	
	@UiField
	TextArea descripcion;
	
	public SeleccionReporteView() {
		initWidget(binder.createAndBindUi(this));
		//fechaHasta.setSelectedDate(new Date());
		fechaHasta.setWeekendSelectable(true);
		fechaDesde.setWeekendSelectable(true);
		descripcion.setText("");
		descripcion.setReadOnly(true);		
		descripcion.setVisibleLines(4);
	}


	public void setPresenter(Presenter listener) {
		this.listener = listener;
	
	}

	
	public void inicializarControles() {
			
	}


	@UiHandler("buttonReporte")
	void onGenerarReporte(ClickEvent e){
		listener.generarReportePorTipo(fechaDesde.getSelectedDate(),fechaHasta.getSelectedDate(),(TipoReporteDTO)tipoReporte.getSelectedItem());
	}
	
	@UiHandler("tipoReporte")
	void onTipoReporte(ChangeEvent e){
		TipoReporteDTO reporte = (TipoReporteDTO) ((ListBox)e.getSource()).getSelectedItem();
		
		descripcion.setText(reporte.getDescripcion());
	}
	
	
}
