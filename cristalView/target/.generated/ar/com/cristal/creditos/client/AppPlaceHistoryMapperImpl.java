package ar.com.cristal.creditos.client;

import com.google.gwt.place.impl.AbstractPlaceHistoryMapper;
import ar.com.cristal.creditos.client.AppPlaceHistoryMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.impl.AbstractPlaceHistoryMapper.PrefixAndToken;
import com.google.gwt.core.client.GWT;

public class AppPlaceHistoryMapperImpl extends AbstractPlaceHistoryMapper<Void> implements AppPlaceHistoryMapper {
  
  protected PrefixAndToken getPrefixAndToken(Place newPlace) {
    if (newPlace instanceof ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDPlace) {
      ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDPlace place = (ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDPlace) newPlace;
      PlaceTokenizer<ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDPlace> t = GWT.create(ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDPlace.Tokenizer.class);
      return new PrefixAndToken("PerfilesCRUDPlace", t.getToken((ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDPlace) place));
    }
    if (newPlace instanceof ar.com.cristal.creditos.client.clientes.alta.ClientePlace) {
      ar.com.cristal.creditos.client.clientes.alta.ClientePlace place = (ar.com.cristal.creditos.client.clientes.alta.ClientePlace) newPlace;
      PlaceTokenizer<ar.com.cristal.creditos.client.clientes.alta.ClientePlace> t = GWT.create(ar.com.cristal.creditos.client.clientes.alta.ClientePlace.Tokenizer.class);
      return new PrefixAndToken("ClientePlace", t.getToken((ar.com.cristal.creditos.client.clientes.alta.ClientePlace) place));
    }
    if (newPlace instanceof ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesPlace) {
      ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesPlace place = (ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesPlace) newPlace;
      PlaceTokenizer<ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesPlace> t = GWT.create(ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesPlace.Tokenizer.class);
      return new PrefixAndToken("BusquedaClientesPlace", t.getToken((ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesPlace) place));
    }
    if (newPlace instanceof ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClientePlace) {
      ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClientePlace place = (ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClientePlace) newPlace;
      PlaceTokenizer<ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClientePlace> t = GWT.create(ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClientePlace.Tokenizer.class);
      return new PrefixAndToken("OperacionesHistorialCreditosClientePlace", t.getToken((ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClientePlace) place));
    }
    if (newPlace instanceof ar.com.cristal.creditos.client.creditos.reportes.SeleccionReportePlace) {
      ar.com.cristal.creditos.client.creditos.reportes.SeleccionReportePlace place = (ar.com.cristal.creditos.client.creditos.reportes.SeleccionReportePlace) newPlace;
      PlaceTokenizer<ar.com.cristal.creditos.client.creditos.reportes.SeleccionReportePlace> t = GWT.create(ar.com.cristal.creditos.client.creditos.reportes.SeleccionReportePlace.Tokenizer.class);
      return new PrefixAndToken("SeleccionReportePlace", t.getToken((ar.com.cristal.creditos.client.creditos.reportes.SeleccionReportePlace) place));
    }
    if (newPlace instanceof ar.com.cristal.creditos.client.localidad.ui.BusquedaLocalidadPlace) {
      ar.com.cristal.creditos.client.localidad.ui.BusquedaLocalidadPlace place = (ar.com.cristal.creditos.client.localidad.ui.BusquedaLocalidadPlace) newPlace;
      PlaceTokenizer<ar.com.cristal.creditos.client.localidad.ui.BusquedaLocalidadPlace> t = GWT.create(ar.com.cristal.creditos.client.localidad.ui.BusquedaLocalidadPlace.Tokenizer.class);
      return new PrefixAndToken("BusquedaLocalidadPlace", t.getToken((ar.com.cristal.creditos.client.localidad.ui.BusquedaLocalidadPlace) place));
    }
    if (newPlace instanceof ar.com.cristal.creditos.client.ui.MenuPlace) {
      ar.com.cristal.creditos.client.ui.MenuPlace place = (ar.com.cristal.creditos.client.ui.MenuPlace) newPlace;
      PlaceTokenizer<ar.com.cristal.creditos.client.ui.MenuPlace> t = GWT.create(ar.com.cristal.creditos.client.ui.MenuPlace.Tokenizer.class);
      return new PrefixAndToken("MenuPlace", t.getToken((ar.com.cristal.creditos.client.ui.MenuPlace) place));
    }
    if (newPlace instanceof ar.com.cristal.creditos.client.ui.home.HomePlace) {
      ar.com.cristal.creditos.client.ui.home.HomePlace place = (ar.com.cristal.creditos.client.ui.home.HomePlace) newPlace;
      PlaceTokenizer<ar.com.cristal.creditos.client.ui.home.HomePlace> t = GWT.create(ar.com.cristal.creditos.client.ui.home.HomePlace.Tokenizer.class);
      return new PrefixAndToken("HomePlace", t.getToken((ar.com.cristal.creditos.client.ui.home.HomePlace) place));
    }
    if (newPlace instanceof ar.com.cristal.creditos.client.ui.sucursales.ABMSucursalPlace) {
      ar.com.cristal.creditos.client.ui.sucursales.ABMSucursalPlace place = (ar.com.cristal.creditos.client.ui.sucursales.ABMSucursalPlace) newPlace;
      PlaceTokenizer<ar.com.cristal.creditos.client.ui.sucursales.ABMSucursalPlace> t = GWT.create(ar.com.cristal.creditos.client.ui.sucursales.ABMSucursalPlace.Tokenizer.class);
      return new PrefixAndToken("ABMSucursalPlace", t.getToken((ar.com.cristal.creditos.client.ui.sucursales.ABMSucursalPlace) place));
    }
    if (newPlace instanceof ar.com.cristal.creditos.client.ui.sucursales.ProcesosAdminPlace) {
      ar.com.cristal.creditos.client.ui.sucursales.ProcesosAdminPlace place = (ar.com.cristal.creditos.client.ui.sucursales.ProcesosAdminPlace) newPlace;
      PlaceTokenizer<ar.com.cristal.creditos.client.ui.sucursales.ProcesosAdminPlace> t = GWT.create(ar.com.cristal.creditos.client.ui.sucursales.ProcesosAdminPlace.Tokenizer.class);
      return new PrefixAndToken("ProcesosAdminPlace", t.getToken((ar.com.cristal.creditos.client.ui.sucursales.ProcesosAdminPlace) place));
    }
    if (newPlace instanceof ar.com.cristal.creditos.client.ui.usuarios.abm.AltaEdicionUsuarioPlace) {
      ar.com.cristal.creditos.client.ui.usuarios.abm.AltaEdicionUsuarioPlace place = (ar.com.cristal.creditos.client.ui.usuarios.abm.AltaEdicionUsuarioPlace) newPlace;
      PlaceTokenizer<ar.com.cristal.creditos.client.ui.usuarios.abm.AltaEdicionUsuarioPlace> t = GWT.create(ar.com.cristal.creditos.client.ui.usuarios.abm.AltaEdicionUsuarioPlace.Tokenizer.class);
      return new PrefixAndToken("AltaEdicionUsuarioPlace", t.getToken((ar.com.cristal.creditos.client.ui.usuarios.abm.AltaEdicionUsuarioPlace) place));
    }
    if (newPlace instanceof ar.com.cristal.creditos.client.ui.usuarios.listado.ListadoUsuariosPlace) {
      ar.com.cristal.creditos.client.ui.usuarios.listado.ListadoUsuariosPlace place = (ar.com.cristal.creditos.client.ui.usuarios.listado.ListadoUsuariosPlace) newPlace;
      PlaceTokenizer<ar.com.cristal.creditos.client.ui.usuarios.listado.ListadoUsuariosPlace> t = GWT.create(ar.com.cristal.creditos.client.ui.usuarios.listado.ListadoUsuariosPlace.Tokenizer.class);
      return new PrefixAndToken("ListadoUsuariosPlace", t.getToken((ar.com.cristal.creditos.client.ui.usuarios.listado.ListadoUsuariosPlace) place));
    }
    if (newPlace instanceof ar.com.cristal.creditos.client.ui.usuarios.pass.CambioPasswordUsuarioPlace) {
      ar.com.cristal.creditos.client.ui.usuarios.pass.CambioPasswordUsuarioPlace place = (ar.com.cristal.creditos.client.ui.usuarios.pass.CambioPasswordUsuarioPlace) newPlace;
      PlaceTokenizer<ar.com.cristal.creditos.client.ui.usuarios.pass.CambioPasswordUsuarioPlace> t = GWT.create(ar.com.cristal.creditos.client.ui.usuarios.pass.CambioPasswordUsuarioPlace.Tokenizer.class);
      return new PrefixAndToken("CambioPasswordUsuarioPlace", t.getToken((ar.com.cristal.creditos.client.ui.usuarios.pass.CambioPasswordUsuarioPlace) place));
    }
    if (newPlace instanceof ar.com.cristal.creditos.client.widget.PopUpInfoPlace) {
      ar.com.cristal.creditos.client.widget.PopUpInfoPlace place = (ar.com.cristal.creditos.client.widget.PopUpInfoPlace) newPlace;
      PlaceTokenizer<ar.com.cristal.creditos.client.widget.PopUpInfoPlace> t = GWT.create(ar.com.cristal.creditos.client.widget.PopUpInfoPlace.Tokenizer.class);
      return new PrefixAndToken("PopUpInfoPlace", t.getToken((ar.com.cristal.creditos.client.widget.PopUpInfoPlace) place));
    }
    return null;
  }
  
  protected PlaceTokenizer<?> getTokenizer(String prefix) {
    if ("SeleccionReportePlace".equals(prefix)) {
      return GWT.create(ar.com.cristal.creditos.client.creditos.reportes.SeleccionReportePlace.Tokenizer.class);
    }
    if ("CambioPasswordUsuarioPlace".equals(prefix)) {
      return GWT.create(ar.com.cristal.creditos.client.ui.usuarios.pass.CambioPasswordUsuarioPlace.Tokenizer.class);
    }
    if ("ClientePlace".equals(prefix)) {
      return GWT.create(ar.com.cristal.creditos.client.clientes.alta.ClientePlace.Tokenizer.class);
    }
    if ("MenuPlace".equals(prefix)) {
      return GWT.create(ar.com.cristal.creditos.client.ui.MenuPlace.Tokenizer.class);
    }
    if ("OperacionesHistorialCreditosClientePlace".equals(prefix)) {
      return GWT.create(ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClientePlace.Tokenizer.class);
    }
    if ("BusquedaLocalidadPlace".equals(prefix)) {
      return GWT.create(ar.com.cristal.creditos.client.localidad.ui.BusquedaLocalidadPlace.Tokenizer.class);
    }
    if ("PerfilesCRUDPlace".equals(prefix)) {
      return GWT.create(ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDPlace.Tokenizer.class);
    }
    if ("ABMSucursalPlace".equals(prefix)) {
      return GWT.create(ar.com.cristal.creditos.client.ui.sucursales.ABMSucursalPlace.Tokenizer.class);
    }
    if ("BusquedaClientesPlace".equals(prefix)) {
      return GWT.create(ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesPlace.Tokenizer.class);
    }
    if ("ProcesosAdminPlace".equals(prefix)) {
      return GWT.create(ar.com.cristal.creditos.client.ui.sucursales.ProcesosAdminPlace.Tokenizer.class);
    }
    if ("PopUpInfoPlace".equals(prefix)) {
      return GWT.create(ar.com.cristal.creditos.client.widget.PopUpInfoPlace.Tokenizer.class);
    }
    if ("HomePlace".equals(prefix)) {
      return GWT.create(ar.com.cristal.creditos.client.ui.home.HomePlace.Tokenizer.class);
    }
    if ("AltaEdicionUsuarioPlace".equals(prefix)) {
      return GWT.create(ar.com.cristal.creditos.client.ui.usuarios.abm.AltaEdicionUsuarioPlace.Tokenizer.class);
    }
    if ("ListadoUsuariosPlace".equals(prefix)) {
      return GWT.create(ar.com.cristal.creditos.client.ui.usuarios.listado.ListadoUsuariosPlace.Tokenizer.class);
    }
    return null;
  }

}
