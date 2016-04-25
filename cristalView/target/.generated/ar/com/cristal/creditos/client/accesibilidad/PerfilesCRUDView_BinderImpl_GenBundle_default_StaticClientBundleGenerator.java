package ar.com.cristal.creditos.client.accesibilidad;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class PerfilesCRUDView_BinderImpl_GenBundle_default_StaticClientBundleGenerator implements ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDView_BinderImpl_GenBundle {
  public ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDView_BinderImpl_GenCss_style style() {
    return style;
  }
  private void _init0() {
    style = new ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDView_BinderImpl_GenCss_style() {
    private boolean injected;
    public boolean ensureInjected() {
      if (!injected) {
        injected = true;
        com.google.gwt.dom.client.StyleInjector.inject(getText());
        return true;
      }
      return false;
    }
    public String getName() {
      return "style";
    }
    public String getText() {
      return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GECQ-XNDA{font-weight:" + ("bold")  + ";}")) : ((".GECQ-XNDA{font-weight:" + ("bold")  + ";}"));
    }
    public java.lang.String important(){
      return "GECQ-XNDA";
    }
  }
  ;
  }
  
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDView_BinderImpl_GenCss_style style;
  
  static {
    new PerfilesCRUDView_BinderImpl_GenBundle_default_StaticClientBundleGenerator()._init0();
  }
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'style': return this.@ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDView_BinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
