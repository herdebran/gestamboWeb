package ar.com.cristal.creditos.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class PopUpInfoView_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, ar.com.cristal.creditos.client.widget.PopUpInfoView>, ar.com.cristal.creditos.client.widget.PopUpInfoView.Binder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final ar.com.cristal.creditos.client.widget.PopUpInfoView owner) {

    ar.com.cristal.creditos.client.widget.PopUpInfoView_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (ar.com.cristal.creditos.client.widget.PopUpInfoView_BinderImpl_GenBundle) GWT.create(ar.com.cristal.creditos.client.widget.PopUpInfoView_BinderImpl_GenBundle.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label titulo = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.dom.client.DivElement informacionDiv = null;
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label informacion = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.FlexTable tablaInformacion = (com.google.gwt.user.client.ui.FlexTable) GWT.create(com.google.gwt.user.client.ui.FlexTable.class);
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button aceptar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel("<div style='width:400px;border:1px solid #A4CDDF;background-color:gray; border:1px gray solid; opacity: 1; margin-top: 5px'> <div class='gwt-TitledPanel'> <div id='headerInformacion'> <div class='title'><span id='" + domId0 + "'></span></div> </div> <div id='" + domId1 + "' style='background: #A4CDDF;color:black; padding: 10px;'> <span id='" + domId2 + "'></span> <span id='" + domId3 + "'></span>  </div> <div class='clear5' style='background: #A4CDDF;color:black;'></div> <center id='footerInformacion' style='background: #006AA4;color:black; padding: 5px'> <span id='" + domId4 + "'></span> </center> </div> </div>");

    titulo.setText("Información");
    aceptar.setText("Aceptar");
    f_HTMLPanel1.setHeight("300px");
    f_HTMLPanel1.setWidth("400px");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    informacionDiv = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    informacionDiv.removeAttribute("id");
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    com.google.gwt.user.client.Element domId4Element = com.google.gwt.dom.client.Document.get().getElementById(domId4).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(titulo, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(informacion, domId2Element);
    f_HTMLPanel1.addAndReplaceElement(tablaInformacion, domId3Element);
    f_HTMLPanel1.addAndReplaceElement(aceptar, domId4Element);


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onButtonClick(event);
      }
    };
    aceptar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    owner.aceptar = aceptar;
    owner.informacion = informacion;
    owner.informacionDiv = informacionDiv;
    owner.tablaInformacion = tablaInformacion;
    owner.titulo = titulo;

    return f_HTMLPanel1;
  }
}
