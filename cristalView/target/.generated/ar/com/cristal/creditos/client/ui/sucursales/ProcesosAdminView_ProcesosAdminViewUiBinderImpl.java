package ar.com.cristal.creditos.client.ui.sucursales;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ProcesosAdminView_ProcesosAdminViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, ar.com.cristal.creditos.client.ui.sucursales.ProcesosAdminView>, ar.com.cristal.creditos.client.ui.sucursales.ProcesosAdminView.ProcesosAdminViewUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final ar.com.cristal.creditos.client.ui.sucursales.ProcesosAdminView owner) {

    ar.com.cristal.creditos.client.ui.sucursales.ProcesosAdminView_ProcesosAdminViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (ar.com.cristal.creditos.client.ui.sucursales.ProcesosAdminView_ProcesosAdminViewUiBinderImpl_GenBundle) GWT.create(ar.com.cristal.creditos.client.ui.sucursales.ProcesosAdminView_ProcesosAdminViewUiBinderImpl_GenBundle.class);
    ar.com.cristal.creditos.client.ui.sucursales.ProcesosAdminView_ProcesosAdminViewUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.dom.client.DivElement containerPopUp = null;
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button botonEscribirRdoPago = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button botonLeerRdoPago = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button botonCerrar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel("<div id='" + domId0 + "'> <div class='gwt-TitledPanel'> <div class='title'>Procesos Administrativos de Sincronizacion</div> <div class='clear20'></div> <div style='float:right'> <span id='" + domId1 + "'></span> <span id='" + domId2 + "'></span> </div> <div class='clear20'></div> <div align='right'> <span id='" + domId3 + "'></span> </div> </div> </div>");

    botonEscribirRdoPago.setStyleName("gwt-Button");
    botonEscribirRdoPago.setText("Escribir Tabla SMS Recor. Pago");
    botonLeerRdoPago.setStyleName("gwt-Button");
    botonLeerRdoPago.setText("Leer Envios Rdo Pago");
    botonCerrar.setStyleName("gwt-Button");
    botonCerrar.setText("Cerrar");
    botonCerrar.setVisible(true);

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    containerPopUp = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    containerPopUp.removeAttribute("id");
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(botonEscribirRdoPago, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(botonLeerRdoPago, domId2Element);
    f_HTMLPanel1.addAndReplaceElement(botonCerrar, domId3Element);


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickCerrar(event);
      }
    };
    botonCerrar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickLeerRdoPago(event);
      }
    };
    botonLeerRdoPago.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickEscribirRdoPago(event);
      }
    };
    botonEscribirRdoPago.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);

    owner.botonCerrar = botonCerrar;
    owner.botonEscribirRdoPago = botonEscribirRdoPago;
    owner.botonLeerRdoPago = botonLeerRdoPago;
    owner.containerPopUp = containerPopUp;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_HTMLPanel1;
  }
}
