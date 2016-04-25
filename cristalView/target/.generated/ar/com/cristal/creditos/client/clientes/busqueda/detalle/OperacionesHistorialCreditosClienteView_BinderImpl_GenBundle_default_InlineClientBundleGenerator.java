package ar.com.cristal.creditos.client.clientes.busqueda.detalle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class OperacionesHistorialCreditosClienteView_BinderImpl_GenBundle_default_InlineClientBundleGenerator implements ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClienteView_BinderImpl_GenBundle {
  private void _init0() {
  }
  
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  
  static {
    new OperacionesHistorialCreditosClienteView_BinderImpl_GenBundle_default_InlineClientBundleGenerator()._init0();
  }
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
    }
    return null;
  }-*/;
}
