package ar.com.cristal.creditos.client;

import java.util.ArrayList;
import java.util.List;

import ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO;
import ar.com.cristal.creditos.client.ui.MenuPlace;
import ar.com.cristal.creditos.client.ui.MenuView;
import ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent;
import ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEventListener;
import ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent;
import ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEventListener;
import ar.com.cristal.creditos.client.ui.util.MensajeriaServerPush;
import ar.com.cristal.creditos.client.ui.util.PopUpInfo;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.novanic.eventservice.client.event.RemoteEventService;
import de.novanic.eventservice.client.event.RemoteEventServiceFactory;
import de.novanic.eventservice.client.event.domain.Domain;
import de.novanic.eventservice.client.event.domain.DomainFactory;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Creditos implements EntryPoint {
	
	 private Place defaultPlace = new MenuPlace("home");
	 
	 private VerticalPanel appContainer;
	 private SimplePanel topMenu = new SimplePanel();
	 
	 private static final Domain DOMAIN = DomainFactory.getDomain("documentoGenerado");	 
	 private static final Domain DOMAIN_APROBACIONES = DomainFactory.getDomain("aprobaciones");	 
	 private RemoteEventServiceFactory theEventServiceFactory;
	 private RemoteEventService theEventService;
	 
	 private ClientFactory clientFactory;

	 private UsuarioLogueadoDTO usuarioLogueadoDTO;
	 
	 
	
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		Log.setCurrentLogLevel(Log.LOG_LEVEL_OFF);
		appContainer = new VerticalPanel();
		SimplePanel mainContent = new SimplePanel();
		
		topMenu.setWidth("100%");
		appContainer.add(topMenu);
		appContainer.add(mainContent);
		 
		Log.info("Inicio de panel principal");
		
		clientFactory = ClientFactoryImpl.getClientFactoryImpl();
	        EventBus eventBus = clientFactory.getEventBus();
	        PlaceController placeController = clientFactory.getPlaceController();

	        // Start ActivityManager for the main widget with our ActivityMapper
	        ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
	        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
	        activityManager.setDisplay(mainContent);
	        
	        
	        ActivityMapper menuActivityMapper = new MenuActivityMapper(clientFactory);
	        ActivityManager menuActivityManager = new ActivityManager(menuActivityMapper, eventBus);
	        menuActivityManager.setDisplay(topMenu);
	        
	        
	        	   	       
	        // Start PlaceHistoryHandler with our PlaceHistoryMapper
	        AppPlaceHistoryMapper historyMapper= GWT.create(AppPlaceHistoryMapper.class);
	        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
	        historyHandler.register(placeController, eventBus, defaultPlace);
	        
	        
	       
	        RootPanel.get("content").add(appContainer);
	        // Goes to the place represented on URL else default place
	        historyHandler.handleCurrentHistory();
	        
//	        LineasDeCreditoCRUDView lineasCreditos = new LineasDeCreditoCRUDView();
//	        RootPanel.get("content").add(lineasCreditos);

	        addListener();
	        
	        
	        
	        
	        clientFactory.getMenuView().getMensajes().setVisible(false);

	        Log.info("Fin inicialización de panel principal");

	}
	
	
	private void addListener(){
		
		 theEventServiceFactory = RemoteEventServiceFactory.getInstance();
		 theEventService = theEventServiceFactory.getRemoteEventService();
		 
//		 theEventService.removeListeners(DOMAIN);
		 
		/**
		 * Register our listener to the domain
		 */
		theEventService.addListener(DOMAIN, new DocumentoGeneradoEventListener(){
			
			public void onDocumentoGeneradoEventListener(DocumentoGeneradoEvent event){
				/**
				 * Get the message from the event and append it to the allready received messages
				 */
				Window.alert("Información: " + event.getMessage());
				
			}
		});
		
		
		/**
		 * Se registra el dominio de aprobaciones 
		 */
		theEventService.addListener(DOMAIN_APROBACIONES, new AprobacionRechazoEventListener(){
			@Override
			public void onAprobacionRechazoEventListener(AprobacionRechazoEvent event) {
				//FIXME: temporalmente anulados los carteles de mensaje de aprobacion/rechazo
//				mostrarMensajeServerPush(event);
				
			}

			
		});
		
	}
	
	private void mostrarMensajeServerPush(final AprobacionRechazoEvent event) {
		final MenuView menu = clientFactory.getMenuView();
	
		if (usuarioLogueadoDTO == null){
			clientFactory.getUsuarioService().obtenerUsuarioLogueado(new AsyncCallback<UsuarioLogueadoDTO>() {
				
				public void onSuccess(UsuarioLogueadoDTO u) {
					usuarioLogueadoDTO = u;
//					mostrarMensajeAnexo(event);
					
					if (MensajeriaServerPush.tratarEvento(event, usuarioLogueadoDTO)){
						menu.getMensajes().setText(event.getMessage());
						menu.getMensajes().setVisible(true);
						menu.setIdSolicitud(event.getIdSolicitud());

					}
					
				}
				
				public void onFailure(Throwable arg0) {
					clientFactory.getPopUp().mostrarMensaje("info", arg0.getMessage());
					
				}
			});
		} else {
//			mostrarMensajeAnexo(event);
			
			if (MensajeriaServerPush.tratarEvento(event, usuarioLogueadoDTO)){
				menu.getMensajes().setText(event.getMessage());				
				menu.getMensajes().setVisible(true);
				menu.setIdSolicitud(event.getIdSolicitud());

				
			}
		}
		
		
		
			
		
		
	}
	
	
	/***
	 * Metodo temporal para comprender los mensajes y analizar quién los recibe
	 * @param event
	 */
	private void mostrarMensajeAnexo(AprobacionRechazoEvent event){
		final List<String> mensajes = new ArrayList<String>();
		
		final PopUpInfo p = new  PopUpInfo(clientFactory);
		mensajes.add("Mensaje temporal que muestra cuándo y quién genera un evento de aprobación/rechazo de una solicitud");
		mensajes.add("Estado de la solicitud: " + event.getTipoSolicitudPreguntaRespuesta());
		mensajes.add("Sucursal: " + event.getSucursalSolicitante());
		mensajes.add("Solicitante: " + event.getUsuarioSolicitante());
		mensajes.add("Usuario respuesta: " + event.getUsuarioRespuesta());
		mensajes.add("----------------------------");
		mensajes.add("Usuario logueado: " + usuarioLogueadoDTO.getNombreUsuario());
		mensajes.add("Usuario logueado es supervisor: " + usuarioLogueadoDTO.isSupervisor());
		p.mostrarMensaje("Información Temporal", mensajes);
	}
}
