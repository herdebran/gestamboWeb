package ar.com.cristal.creditos.client;

//import ar.com.cristal.creditos.client.creditos.aprobaciones.depositos.ListadoSolicitudDepositoView;
import ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDView;
import ar.com.cristal.creditos.client.clientes.alta.ClienteView;
import ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesView;
import ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClientePlace;
import ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClienteView;
import ar.com.cristal.creditos.client.creditos.reportes.SeleccionReporteView;
import ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO;
import ar.com.cristal.creditos.client.localidad.ui.BusquedaLocalidadView;
import ar.com.cristal.creditos.client.service.ClientesRPCServiceAsync;
import ar.com.cristal.creditos.client.service.ComunesRPCServiceAsync;
import ar.com.cristal.creditos.client.service.CreditosRPCServiceAsync;
import ar.com.cristal.creditos.client.service.UsuarioRPCServiceAsync;
import ar.com.cristal.creditos.client.service.VacasRPCServiceAsync;
import ar.com.cristal.creditos.client.service.event.DefaultRemoteEventServiceAsync;
import ar.com.cristal.creditos.client.tambo.animales.alta.AltaAnimalesPlace;
import ar.com.cristal.creditos.client.tambo.animales.alta.AltaAnimalesView;
import ar.com.cristal.creditos.client.tambo.animales.ficha.FichaAnimalesPlace;
import ar.com.cristal.creditos.client.tambo.animales.ficha.FichaAnimalesView;
import ar.com.cristal.creditos.client.tambo.partediario.ParteDiarioPlace;
import ar.com.cristal.creditos.client.tambo.partediario.ParteDiarioView;
import ar.com.cristal.creditos.client.tambo.partediario.celoservicio.PdCeloServicioActivity;
import ar.com.cristal.creditos.client.tambo.partediario.celoservicio.PdCeloServicioView;
import ar.com.cristal.creditos.client.tambo.partediario.parto.PdPartoPlace;
import ar.com.cristal.creditos.client.tambo.partediario.parto.PdPartoView;
import ar.com.cristal.creditos.client.tambo.rodeos.ui.BusquedaRodeosView;
import ar.com.cristal.creditos.client.tambo.toros.ui.BusquedaTorosView;
import ar.com.cristal.creditos.client.ui.MenuView;
import ar.com.cristal.creditos.client.ui.establecimientos.SeleccionEstablecimientoPlace;
import ar.com.cristal.creditos.client.ui.establecimientos.SeleccionEstablecimientoView;
import ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent;
import ar.com.cristal.creditos.client.ui.home.HomePlace;
import ar.com.cristal.creditos.client.ui.home.HomeView;
import ar.com.cristal.creditos.client.ui.sucursales.ABMSucursalView;
import ar.com.cristal.creditos.client.ui.sucursales.ProcesosAdminView;
import ar.com.cristal.creditos.client.ui.usuarios.abm.AltaEdicionUsuarioPlace;
import ar.com.cristal.creditos.client.ui.usuarios.abm.AltaEdicionUsuarioView;
import ar.com.cristal.creditos.client.ui.usuarios.listado.ListadoUsuariosView;
import ar.com.cristal.creditos.client.ui.usuarios.pass.CambioPasswordUsuarioView;
import ar.com.cristal.creditos.client.ui.util.PopUpInfo;
import ar.com.cristal.creditos.client.widget.PopUpInfoView;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import de.novanic.eventservice.client.event.domain.Domain;
import de.novanic.eventservice.client.event.domain.DomainFactory;

/***
 * Cuando se crea una nueva vista y servicio debe actualizarse esta interfaz.
 * @author daniel.madera
 *
 */
public interface ClientFactory {
	
	static final Domain DOMAIN = DomainFactory.getDomain("documentoGenerado");	 
	static final Domain DOMAIN_APROBACIONES = DomainFactory.getDomain("aprobaciones");	 
	 
    EventBus getEventBus();
    PlaceController getPlaceController();

    
    //Util
    PopUpInfo getPopUp();
    
    
    //Places
    HomePlace getHomePlace();
    Place getPopUpInfoPlace();
    AltaAnimalesPlace getAltaAnimalesPlace (String token);
    FichaAnimalesPlace getFichaAnimalesPlace (String token);
    
    AltaEdicionUsuarioPlace getAltaEdicionUsuarioPlace(String id);
    Place getCalculoSolicitudRefinanciacionCreditosPlace(String token);
    OperacionesHistorialCreditosClientePlace getOperacionesHistorialCreditosClientePlace(String string);
    Place getCausaLegalPlace(UsuarioLogueadoDTO usuarioLogueadoDTO, String gestionCausasLegalesEscritura, String token);
    SeleccionEstablecimientoPlace getSeleccionEstablecimientoPlace (String id);
    ParteDiarioPlace getParteDiarioPlace (String id);
    PdPartoPlace getPdPartoPlace (String id);
    
    ///Vistas
    MenuView getMenuView();
    HomeView getHomeView();
    AltaAnimalesView getAltaAnimalesView();
    FichaAnimalesView getFichaAnimalesView();
    ParteDiarioView getParteDiarioView();
    PdCeloServicioView getPdCeloServicioView();
    PdPartoView getPdPartoView();
    
    OperacionesHistorialCreditosClienteView getOperacionesHistorialCreditosClienteView();
    PerfilesCRUDView getPerfilesView();
    PopUpInfoView getPopUpInfoView();
    AltaEdicionUsuarioView getAltaEdicionUsuarioView();
    ListadoUsuariosView getListadoUsuariosView();
    BusquedaClientesView getBusquedaClientesView();
//    FinanciacionView getFinanciacionView();
    ClienteView getClienteView();
    SeleccionReporteView getSeleccionReporteView();
    BusquedaLocalidadView getBusquedaLocaliadView();
    CambioPasswordUsuarioView getCambioPasswordUsuarioView();
    ABMSucursalView getABMSucursalView();
	ProcesosAdminView getProcesosAdminView();
	SeleccionEstablecimientoView getSeleccionEstablecimientoView();
	BusquedaTorosView getBusquedaTorosView();
	BusquedaRodeosView getBusquedaRodeosView();
	
    ///Servicios
    
    
    /***
     * 
     * @return
     */

    DocumentoGeneradoEvent getDocumentoGeneradoEventService();
    DefaultRemoteEventServiceAsync getDefaultEventService();
    CreditosRPCServiceAsync getCreditosService();
    UsuarioRPCServiceAsync getUsuarioService();
    ClientesRPCServiceAsync getClientesService();
    VacasRPCServiceAsync getVacasService();
	ComunesRPCServiceAsync getComunesService();
	String getURLBase();

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
    
}

