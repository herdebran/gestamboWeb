package ar.com.cristal.creditos.client.ui.usuarios.listado;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ListadoUsuariosView_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, ar.com.cristal.creditos.client.ui.usuarios.listado.ListadoUsuariosView>, ar.com.cristal.creditos.client.ui.usuarios.listado.ListadoUsuariosView.Binder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final ar.com.cristal.creditos.client.ui.usuarios.listado.ListadoUsuariosView owner) {

    ar.com.cristal.creditos.client.ui.usuarios.listado.ListadoUsuariosView_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (ar.com.cristal.creditos.client.ui.usuarios.listado.ListadoUsuariosView_BinderImpl_GenBundle) GWT.create(ar.com.cristal.creditos.client.ui.usuarios.listado.ListadoUsuariosView_BinderImpl_GenBundle.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.FlexTable listadoUsuarios = owner.listadoUsuarios;
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button nuevo = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button button = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel("<div class='gwt-TitledPanel'> <div class='title'>Listado de usuarios</div> <div style='overflow-y: scroll; height: 300px'> <span id='" + domId0 + "'></span> </div> <br> <div style='float:right; marging:15px'> <span id='" + domId1 + "'></span> <span id='" + domId2 + "'></span> </div> </div>");

    listadoUsuarios.ensureDebugId("listadoUsuarios");
    listadoUsuarios.setStyleName("dataTable");
    listadoUsuarios.setWidth("100%");
    nuevo.setText("Nuevo");
    button.setText("Ir a Inicio");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(listadoUsuarios, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(nuevo, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(button, domId2Element);


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onButtonClick(event);
      }
    };
    button.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onTableClick(event);
      }
    };
    listadoUsuarios.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onNuevoClick(event);
      }
    };
    nuevo.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);

    owner.button = button;

    return f_HTMLPanel1;
  }
}
