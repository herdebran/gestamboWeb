package ar.com.cristal.creditos.client;

import ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDPlace;
import ar.com.cristal.creditos.client.clientes.alta.ClientePlace;
import ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesPlace;
import ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClientePlace;
import ar.com.cristal.creditos.client.creditos.reportes.SeleccionReportePlace;
import ar.com.cristal.creditos.client.localidad.ui.BusquedaLocalidadPlace;
import ar.com.cristal.creditos.client.tambo.animales.alta.AltaAnimalesPlace;
import ar.com.cristal.creditos.client.tambo.animales.ficha.FichaAnimalesPlace;
import ar.com.cristal.creditos.client.tambo.partediario.ParteDiarioPlace;
import ar.com.cristal.creditos.client.tambo.partediario.celoservicio.PdCeloServicioPlace;
import ar.com.cristal.creditos.client.tambo.partediario.parto.PdPartoPlace;
import ar.com.cristal.creditos.client.ui.MenuPlace;
import ar.com.cristal.creditos.client.ui.establecimientos.SeleccionEstablecimientoPlace;
import ar.com.cristal.creditos.client.ui.home.HomePlace;
import ar.com.cristal.creditos.client.ui.sucursales.ABMSucursalPlace;
import ar.com.cristal.creditos.client.ui.sucursales.ProcesosAdminPlace;
import ar.com.cristal.creditos.client.ui.usuarios.abm.AltaEdicionUsuarioPlace;
import ar.com.cristal.creditos.client.ui.usuarios.listado.ListadoUsuariosPlace;
import ar.com.cristal.creditos.client.ui.usuarios.pass.CambioPasswordUsuarioPlace;
import ar.com.cristal.creditos.client.widget.PopUpInfoPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({MenuPlace.Tokenizer.class, HomePlace.Tokenizer.class,AltaAnimalesPlace.Tokenizer.class,FichaAnimalesPlace.Tokenizer.class, 
	ParteDiarioPlace.Tokenizer.class,PopUpInfoPlace.Tokenizer.class, AltaEdicionUsuarioPlace.Tokenizer.class,
	PdCeloServicioPlace.Tokenizer.class,PdPartoPlace.Tokenizer.class,ListadoUsuariosPlace.Tokenizer.class, OperacionesHistorialCreditosClientePlace.Tokenizer.class, 
	ListadoUsuariosPlace.Tokenizer.class, OperacionesHistorialCreditosClientePlace.Tokenizer.class,
	BusquedaClientesPlace.Tokenizer.class, ClientePlace.Tokenizer.class,
	PerfilesCRUDPlace.Tokenizer.class,PerfilesCRUDPlace.Tokenizer.class, 
	SeleccionReportePlace.Tokenizer.class,BusquedaLocalidadPlace.Tokenizer.class,CambioPasswordUsuarioPlace.Tokenizer.class,
	ABMSucursalPlace.Tokenizer.class, 
	ProcesosAdminPlace.Tokenizer.class,SeleccionEstablecimientoPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper
{
}
