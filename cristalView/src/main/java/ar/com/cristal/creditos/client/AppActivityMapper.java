package ar.com.cristal.creditos.client;

//import ar.com.cristal.creditos.client.creditos.aprobaciones.depositos.ListadoSolicitudDepositoActivity;
//import ar.com.cristal.creditos.client.creditos.aprobaciones.depositos.ListadoSolicitudDepositoPlace;
import ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDActivity;
import ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDPlace;
import ar.com.cristal.creditos.client.clientes.alta.ClienteActivity;
import ar.com.cristal.creditos.client.clientes.alta.ClientePlace;
import ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesActivity;
import ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesPlace;
import ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClienteActivity;
import ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClientePlace;
import ar.com.cristal.creditos.client.creditos.reportes.SeleccionReporteActivity;
import ar.com.cristal.creditos.client.creditos.reportes.SeleccionReportePlace;
import ar.com.cristal.creditos.client.localidad.ui.BusquedaLocalidadActivity;
import ar.com.cristal.creditos.client.localidad.ui.BusquedaLocalidadPlace;
import ar.com.cristal.creditos.client.tambo.animales.alta.AltaAnimalesActivity;
import ar.com.cristal.creditos.client.tambo.animales.alta.AltaAnimalesPlace;
import ar.com.cristal.creditos.client.tambo.animales.ficha.FichaAnimalesActivity;
import ar.com.cristal.creditos.client.tambo.animales.ficha.FichaAnimalesPlace;
import ar.com.cristal.creditos.client.tambo.partediario.ParteDiarioActivity;
import ar.com.cristal.creditos.client.tambo.partediario.ParteDiarioPlace;
import ar.com.cristal.creditos.client.tambo.partediario.celoservicio.PdCeloServicioActivity;
import ar.com.cristal.creditos.client.tambo.partediario.celoservicio.PdCeloServicioPlace;
import ar.com.cristal.creditos.client.tambo.partediario.parto.PdPartoActivity;
import ar.com.cristal.creditos.client.tambo.partediario.parto.PdPartoPlace;
import ar.com.cristal.creditos.client.ui.home.HomeActivity;
import ar.com.cristal.creditos.client.ui.home.HomePlace;
import ar.com.cristal.creditos.client.ui.sucursales.ABMSucursalActivity;
import ar.com.cristal.creditos.client.ui.sucursales.ABMSucursalPlace;
import ar.com.cristal.creditos.client.ui.usuarios.abm.AltaEdicionUsuarioActivity;
import ar.com.cristal.creditos.client.ui.usuarios.abm.AltaEdicionUsuarioPlace;
import ar.com.cristal.creditos.client.ui.usuarios.listado.ListadoUsuariosActivity;
import ar.com.cristal.creditos.client.ui.usuarios.listado.ListadoUsuariosPlace;
import ar.com.cristal.creditos.client.ui.usuarios.pass.CambioPasswordUsuarioActivity;
import ar.com.cristal.creditos.client.ui.usuarios.pass.CambioPasswordUsuarioPlace;
import ar.com.cristal.creditos.client.widget.PopUpInfoActivity;
import ar.com.cristal.creditos.client.widget.PopUpInfoPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {
    private ClientFactory clientFactory;
    private Activity currentActivity;

    public AppActivityMapper(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }

    
    public Activity getActivity(Place place) {    	
        if (place instanceof HomePlace)
        	currentActivity = new HomeActivity((HomePlace) place, clientFactory);
       
        
        else if (place instanceof PopUpInfoPlace)
        	currentActivity = new PopUpInfoActivity((PopUpInfoPlace)place, clientFactory);
        
        else if (place instanceof AltaAnimalesPlace)
        	currentActivity = new AltaAnimalesActivity((AltaAnimalesPlace)place, clientFactory);

        else if (place instanceof FichaAnimalesPlace)
        	currentActivity = new FichaAnimalesActivity((FichaAnimalesPlace)place, clientFactory);

        else if (place instanceof ParteDiarioPlace)
        	currentActivity = new ParteDiarioActivity((ParteDiarioPlace)place, clientFactory);

        else if (place instanceof PdCeloServicioPlace)
        	currentActivity = new PdCeloServicioActivity((PdCeloServicioPlace)place, clientFactory);

        else if (place instanceof PdPartoPlace)
        	currentActivity = new PdPartoActivity((PdPartoPlace)place, clientFactory);

        else if (place instanceof ListadoUsuariosPlace)
        	currentActivity = new ListadoUsuariosActivity((ListadoUsuariosPlace)place, clientFactory);
        
        else if (place instanceof AltaEdicionUsuarioPlace)
        	currentActivity = new AltaEdicionUsuarioActivity((AltaEdicionUsuarioPlace)place, clientFactory);
        
        else if (currentActivity == null) {
        	currentActivity = new HomeActivity(new HomePlace("Inicio"), clientFactory);
        }
        else if (place instanceof PerfilesCRUDPlace){
        	currentActivity = new PerfilesCRUDActivity((PerfilesCRUDPlace)place, clientFactory);
        }
        else if (place instanceof OperacionesHistorialCreditosClientePlace){
        	currentActivity = new OperacionesHistorialCreditosClienteActivity((OperacionesHistorialCreditosClientePlace)place, clientFactory);
        }
        else if (place instanceof BusquedaClientesPlace){
        	currentActivity = new BusquedaClientesActivity((BusquedaClientesPlace)place, clientFactory);
        }
 
        
        else if (place instanceof ClientePlace){
        	currentActivity = new ClienteActivity((ClientePlace)place, clientFactory);    
        }
        
        else if (place instanceof SeleccionReportePlace)
        	currentActivity = new SeleccionReporteActivity((SeleccionReportePlace)place, clientFactory);
        
        else if (place instanceof BusquedaLocalidadPlace)
        	currentActivity = new BusquedaLocalidadActivity((BusquedaLocalidadPlace)place, clientFactory);
        
        else if (place instanceof CambioPasswordUsuarioPlace)
        	currentActivity = new CambioPasswordUsuarioActivity((CambioPasswordUsuarioPlace)place, clientFactory);
 
        else if (place instanceof ABMSucursalPlace)
        	currentActivity = new ABMSucursalActivity((ABMSucursalPlace)place, clientFactory);
        
        //else if (place instanceof SeleccionEstablecimientoPlace)
        //	currentActivity = new SeleccionEstablecimientoActivity((SeleccionEstablecimientoPlace)place, clientFactory);
        
        else   if (place instanceof HomePlace)
        	currentActivity = new HomeActivity((HomePlace) place, clientFactory);

        if (currentActivity==null){
        	Place newPlace = new HomePlace("");
        	currentActivity = new HomeActivity((HomePlace) newPlace, clientFactory);
        }
        	
        return currentActivity;
    }
}