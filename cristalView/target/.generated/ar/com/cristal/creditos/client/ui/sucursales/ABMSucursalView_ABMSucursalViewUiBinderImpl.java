package ar.com.cristal.creditos.client.ui.sucursales;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ABMSucursalView_ABMSucursalViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, ar.com.cristal.creditos.client.ui.sucursales.ABMSucursalView>, ar.com.cristal.creditos.client.ui.sucursales.ABMSucursalView.ABMSucursalViewUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final ar.com.cristal.creditos.client.ui.sucursales.ABMSucursalView owner) {

    ar.com.cristal.creditos.client.ui.sucursales.ABMSucursalView_ABMSucursalViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (ar.com.cristal.creditos.client.ui.sucursales.ABMSucursalView_ABMSucursalViewUiBinderImpl_GenBundle) GWT.create(ar.com.cristal.creditos.client.ui.sucursales.ABMSucursalView_ABMSucursalViewUiBinderImpl_GenBundle.class);
    ar.com.cristal.creditos.client.ui.sucursales.ABMSucursalView_ABMSucursalViewUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.dom.client.DivElement containerPopUp = null;
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox sucursalBusqueda = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button botonBuscar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button botonLimpiar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.FlexTable detalle = (com.google.gwt.user.client.ui.FlexTable) GWT.create(com.google.gwt.user.client.ui.FlexTable.class);
    java.lang.String domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox nombre = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button botonGuardar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId7 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button botonCrear = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button botonSeleccionar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId9 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button botonCerrar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel("<div id='" + domId0 + "'> <div class='gwt-TitledPanel'> <div class='title'>Búsqueda de Sucursales</div> <div class='clear20'></div> <table> <thead></thead> <tbody> <tr> <td>Sucursal</td> <td><span id='" + domId1 + "'></span></td> </tr> </tbody> </table> <div class='clear20'></div> <div style='float:right'> <span id='" + domId2 + "'></span> <span id='" + domId3 + "'></span> </div> <div class='clear20'></div> <div style='overflow-y: scroll; height: 270px'> <span id='" + domId4 + "'></span> </div>  <div class='clear20'></div> <div class='title'>Edición</div> <table> <thead></thead> <tbody> <tr> <td>Nombre</td> </tr> <tr> <td><span id='" + domId5 + "'></span></td> </tr> </tbody> </table> <div class='clear20'></div> <div align='right'> <span id='" + domId6 + "'></span> <span id='" + domId7 + "'></span> <span id='" + domId8 + "'></span> <span id='" + domId9 + "'></span> </div> </div> </div>");

    sucursalBusqueda.setMaxLength(100);
    sucursalBusqueda.setWidth("160px");
    botonBuscar.setStyleName("gwt-Button");
    botonBuscar.setText("Buscar");
    botonLimpiar.setStyleName("gwt-Button");
    botonLimpiar.setText("Limpiar");
    detalle.ensureDebugId("detalle");
    detalle.setStyleName("dataTable");
    detalle.setWidth("98%");
    nombre.setMaxLength(100);
    nombre.setWidth("160px");
    botonGuardar.setStyleName("gwt-Button");
    botonGuardar.setText("Guardar");
    botonCrear.setStyleName("gwt-Button");
    botonCrear.setText("Crear");
    botonSeleccionar.setStyleName("gwt-Button");
    botonSeleccionar.setText("Seleccionar");
    botonSeleccionar.setVisible(false);
    botonCerrar.setStyleName("gwt-Button");
    botonCerrar.setText("Cerrar");
    botonCerrar.setVisible(false);

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    containerPopUp = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    containerPopUp.removeAttribute("id");
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    com.google.gwt.user.client.Element domId4Element = com.google.gwt.dom.client.Document.get().getElementById(domId4).cast();
    com.google.gwt.user.client.Element domId5Element = com.google.gwt.dom.client.Document.get().getElementById(domId5).cast();
    com.google.gwt.user.client.Element domId6Element = com.google.gwt.dom.client.Document.get().getElementById(domId6).cast();
    com.google.gwt.user.client.Element domId7Element = com.google.gwt.dom.client.Document.get().getElementById(domId7).cast();
    com.google.gwt.user.client.Element domId8Element = com.google.gwt.dom.client.Document.get().getElementById(domId8).cast();
    com.google.gwt.user.client.Element domId9Element = com.google.gwt.dom.client.Document.get().getElementById(domId9).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(sucursalBusqueda, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(botonBuscar, domId2Element);
    f_HTMLPanel1.addAndReplaceElement(botonLimpiar, domId3Element);
    f_HTMLPanel1.addAndReplaceElement(detalle, domId4Element);
    f_HTMLPanel1.addAndReplaceElement(nombre, domId5Element);
    f_HTMLPanel1.addAndReplaceElement(botonGuardar, domId6Element);
    f_HTMLPanel1.addAndReplaceElement(botonCrear, domId7Element);
    f_HTMLPanel1.addAndReplaceElement(botonSeleccionar, domId8Element);
    f_HTMLPanel1.addAndReplaceElement(botonCerrar, domId9Element);


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickLimpiar(event);
      }
    };
    botonLimpiar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickBuscar(event);
      }
    };
    botonBuscar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickGuardar(event);
      }
    };
    botonGuardar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickCrear(event);
      }
    };
    botonCrear.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickCerrar(event);
      }
    };
    botonCerrar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickSeleccionar(event);
      }
    };
    botonSeleccionar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6);

    owner.botonBuscar = botonBuscar;
    owner.botonCerrar = botonCerrar;
    owner.botonCrear = botonCrear;
    owner.botonGuardar = botonGuardar;
    owner.botonLimpiar = botonLimpiar;
    owner.botonSeleccionar = botonSeleccionar;
    owner.containerPopUp = containerPopUp;
    owner.detalle = detalle;
    owner.nombre = nombre;
    owner.sucursalBusqueda = sucursalBusqueda;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_HTMLPanel1;
  }
}
