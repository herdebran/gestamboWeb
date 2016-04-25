package ar.com.cristal.creditos.client;

import ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDView;
import ar.com.cristal.creditos.client.clientes.alta.ClienteView;
import ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesView;
import ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClientePlace;
import ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClienteView;
import ar.com.cristal.creditos.client.creditos.reportes.SeleccionReporteView;
import ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO;
import ar.com.cristal.creditos.client.localidad.ui.BusquedaLocalidadView;
import ar.com.cristal.creditos.client.service.ClientesRPCService;
import ar.com.cristal.creditos.client.service.ClientesRPCServiceAsync;
import ar.com.cristal.creditos.client.service.ComunesRPCService;
import ar.com.cristal.creditos.client.service.ComunesRPCServiceAsync;
import ar.com.cristal.creditos.client.service.CreditosRPCService;
import ar.com.cristal.creditos.client.service.CreditosRPCServiceAsync;
import ar.com.cristal.creditos.client.service.UsuarioRPCService;
import ar.com.cristal.creditos.client.service.UsuarioRPCServiceAsync;
import ar.com.cristal.creditos.client.service.event.DefaultRemoteEventService;
import ar.com.cristal.creditos.client.service.event.DefaultRemoteEventServiceAsync;
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
import ar.com.cristal.creditos.client.widget.PopUpInfoPlace;
import ar.com.cristal.creditos.client.widget.PopUpInfoView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;

public class ClientFactoryImpl implements ClientFactory {
	
	private static ClientFactoryImpl instance = null; 
	
	public static final ClientFactoryImpl getClientFactoryImpl(){
		if (instance == null) instance = GWT.create(ClientFactoryImpl.class);
		
		return instance;
	}
    private final EventBus eventBus = new SimpleEventBus();
    private final PlaceController placeController = new PlaceController(eventBus);
    
    private HomeView homeView = null;
    private MenuView menuView = null;
    private OperacionesHistorialCreditosClienteView operacionesHistorialCreditosClienteView = null;
    private BusquedaClientesView busquedaClientesView = null;
    private PopUpInfoView popUpInfoView = null;
    private AltaEdicionUsuarioView altaEdicionUsuarioView = null;
    private ListadoUsuariosView listadoUsuariosView = null;
    private PerfilesCRUDView perfilesCRUDView;
    private ClienteView clienteView;
    private SeleccionReporteView seleccionReporteView = null;
    private BusquedaLocalidadView busquedaLocalidadView = null;
    private CambioPasswordUsuarioView cambioPasswordUsuarioView = null;
    private ABMSucursalView abmSucursalView = null;
    private SeleccionEstablecimientoView seleccionEstablecimientoView = null;

    private ProcesosAdminView procesosAdminView=null;
    
    //Util
    private PopUpInfo popUpInfo = null;
    
	
    //Place
    private HomePlace homePlace = null;
    private PopUpInfoPlace popUpInfoPlace = null;
    private AltaEdicionUsuarioPlace altaEdicionUsuarioPlace;
    private OperacionesHistorialCreditosClientePlace operacionesHistorialCreditosClientePlace = null;
    private SeleccionEstablecimientoPlace seleccionEstablecimientoPlace = null;
    
    //Services
    private final DefaultRemoteEventServiceAsync defaultRemoteEventServiceAsync = DefaultRemoteEventService.Util.getInstance();    
    
    private final DocumentoGeneradoEvent documentoGeneradoEventService = DocumentoGeneradoEvent.Util.getInstance();
    
    private  CreditosRPCServiceAsync creditosService = null;
    
    private UsuarioRPCServiceAsync usuarioService = null;
    
    private ClientesRPCServiceAsync clientesService = null;
	
	private ComunesRPCServiceAsync comunesService = null;
	
	
	
	

    public EventBus getEventBus() {
        return eventBus;
    }

	public PlaceController getPlaceController() {
		return placeController;
	}

	
	/****************************************************
	 * Places
	 ****************************************************/
	
	public HomePlace getHomePlace() {
		if (homePlace == null) homePlace = new HomePlace("");
		return homePlace;
	}

	
	 public PopUpInfoPlace getPopUpInfoPlace() {
		 if (popUpInfoPlace == null) popUpInfoPlace = new PopUpInfoPlace("");		 	
			return popUpInfoPlace;
		}
	 
	 public AltaEdicionUsuarioPlace getAltaEdicionUsuarioPlace(String token) {
		 if (altaEdicionUsuarioPlace == null) altaEdicionUsuarioPlace = new AltaEdicionUsuarioPlace(token);
		 altaEdicionUsuarioPlace.setToken(token);
			return altaEdicionUsuarioPlace;
		}


	public OperacionesHistorialCreditosClientePlace getOperacionesHistorialCreditosClientePlace(String string) {
		if (operacionesHistorialCreditosClientePlace == null) operacionesHistorialCreditosClientePlace = new OperacionesHistorialCreditosClientePlace(string);
		operacionesHistorialCreditosClientePlace.setToken(string);
		return operacionesHistorialCreditosClientePlace;
	}
	
	public SeleccionEstablecimientoPlace getSeleccionEstablecimientoPlace(String string) {
		if (seleccionEstablecimientoPlace == null) seleccionEstablecimientoPlace = new SeleccionEstablecimientoPlace(string);
		seleccionEstablecimientoPlace.setToken(string);
		return seleccionEstablecimientoPlace;
	}
	
	/**r
	 * retorna el place de solo lectura o de lecturaEscritura segun los permisos del usuario
	 */
	



	/****************************************************
	 * Vistas
	 ****************************************************/

	public MenuView getMenuView() {
		if (menuView == null) menuView = new MenuView();
		return menuView;
	}
	
	public HomeView getHomeView() {
		if (homeView == null) homeView = new HomeView();
		return homeView;
	}

	public PopUpInfoView getPopUpInfoView() {
		if (popUpInfoView == null) popUpInfoView = new PopUpInfoView();
		return popUpInfoView;
		
	}
	
	public AltaEdicionUsuarioView getAltaEdicionUsuarioView() {
		
		if (altaEdicionUsuarioView == null) altaEdicionUsuarioView = new AltaEdicionUsuarioView();
		return altaEdicionUsuarioView;
	}

	
	public ListadoUsuariosView getListadoUsuariosView() {
		if (listadoUsuariosView == null) listadoUsuariosView = new ListadoUsuariosView();
		return listadoUsuariosView;
	}
	
	public PerfilesCRUDView getPerfilesView() {
		if (perfilesCRUDView == null) perfilesCRUDView = new PerfilesCRUDView();
		return perfilesCRUDView;
	}
	

	public ClienteView getClienteView() {
		if (clienteView == null) clienteView = new ClienteView();
		return clienteView;
	}
	

	
	public OperacionesHistorialCreditosClienteView getOperacionesHistorialCreditosClienteView() {
		if (operacionesHistorialCreditosClienteView == null) operacionesHistorialCreditosClienteView = new OperacionesHistorialCreditosClienteView();
		return operacionesHistorialCreditosClienteView;
	}
	
	public BusquedaClientesView getBusquedaClientesView(){
		if (busquedaClientesView == null) busquedaClientesView = new BusquedaClientesView();
		return busquedaClientesView;
	}
	
	public SeleccionEstablecimientoView getSeleccionEstablecimientoView(){
		if (seleccionEstablecimientoView == null) seleccionEstablecimientoView = new SeleccionEstablecimientoView();
		return seleccionEstablecimientoView;
	}
	

	/****************************************************
	 * Servicios
	 ****************************************************/
	

	public DocumentoGeneradoEvent getDocumentoGeneradoEventService() {
		return documentoGeneradoEventService;
	}

	public DefaultRemoteEventServiceAsync getDefaultEventService() {
		return defaultRemoteEventServiceAsync;
	}

	

	public CreditosRPCServiceAsync getCreditosService() {
		if(creditosService == null) creditosService = GWT.create(CreditosRPCService.class);
		return creditosService;
	}
	
	public ClientesRPCServiceAsync getClientesService() {
		if(clientesService == null) clientesService = GWT.create(ClientesRPCService.class);
		return clientesService;
	}

	public PopUpInfo getPopUp() {
		if (popUpInfo == null) popUpInfo = new PopUpInfo(this);
		return popUpInfo;
	}

	
	public UsuarioRPCServiceAsync getUsuarioService() {
		if(usuarioService == null) usuarioService = GWT.create(UsuarioRPCService.class);
		return usuarioService;
	}

	
	
	public ComunesRPCServiceAsync getComunesService() {
		if(comunesService == null) comunesService = GWT.create(ComunesRPCService.class);
		return comunesService;
	}

	
	
	//indica si el id de comercializador que tiene el cliente es el mismo que el id de comercializador del usu logueado
	public boolean isClienteDelComercializador(Long idComerEnUsuLogueado, Long idComerEnClient) {
		if (idComerEnClient == null) 
			return false;
		else 			
			return idComerEnUsuLogueado.equals(idComerEnClient);
	}

	@Override
	public SeleccionReporteView getSeleccionReporteView() {
		if(seleccionReporteView == null ) seleccionReporteView = new SeleccionReporteView();
		return seleccionReporteView;
	}
	
	@Override
	public BusquedaLocalidadView getBusquedaLocaliadView() {
		if (busquedaLocalidadView ==null) busquedaLocalidadView = new BusquedaLocalidadView();
		return busquedaLocalidadView;
	}
	

	public CambioPasswordUsuarioView getCambioPasswordUsuarioView(){
		if (cambioPasswordUsuarioView == null) cambioPasswordUsuarioView = new CambioPasswordUsuarioView();
		return cambioPasswordUsuarioView;
	}

	@Override
	public ABMSucursalView getABMSucursalView() {
		if (abmSucursalView == null) abmSucursalView = new ABMSucursalView();
		return abmSucursalView;
		
		
		
	}
	

	
	
	@Override
	public String getURLBase() {
		String base = GWT.getHostPageBaseURL();
		
		return base;
	}

	





	@Override
	public ProcesosAdminView getProcesosAdminView() {
		if(procesosAdminView == null) procesosAdminView = new ProcesosAdminView();		
		return procesosAdminView;
	}


	@Override
	public Place getCalculoSolicitudRefinanciacionCreditosPlace(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Place getCausaLegalPlace(UsuarioLogueadoDTO usuarioLogueadoDTO,
			String gestionCausasLegalesEscritura, String token) {
		// TODO Auto-generated method stub
		return null;
	}




}
