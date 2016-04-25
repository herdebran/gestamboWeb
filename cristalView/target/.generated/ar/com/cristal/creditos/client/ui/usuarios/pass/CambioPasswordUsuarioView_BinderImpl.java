package ar.com.cristal.creditos.client.ui.usuarios.pass;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class CambioPasswordUsuarioView_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, ar.com.cristal.creditos.client.ui.usuarios.pass.CambioPasswordUsuarioView>, ar.com.cristal.creditos.client.ui.usuarios.pass.CambioPasswordUsuarioView.Binder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final ar.com.cristal.creditos.client.ui.usuarios.pass.CambioPasswordUsuarioView owner) {

    ar.com.cristal.creditos.client.ui.usuarios.pass.CambioPasswordUsuarioView_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (ar.com.cristal.creditos.client.ui.usuarios.pass.CambioPasswordUsuarioView_BinderImpl_GenBundle) GWT.create(ar.com.cristal.creditos.client.ui.usuarios.pass.CambioPasswordUsuarioView_BinderImpl_GenBundle.class);
    ar.com.cristal.creditos.client.ui.usuarios.pass.CambioPasswordUsuarioView_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label titulo = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.PasswordTextBox password = (com.google.gwt.user.client.ui.PasswordTextBox) GWT.create(com.google.gwt.user.client.ui.PasswordTextBox.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.PasswordTextBox nuevaPassword = (com.google.gwt.user.client.ui.PasswordTextBox) GWT.create(com.google.gwt.user.client.ui.PasswordTextBox.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.PasswordTextBox confirmacionNuevaPassword = (com.google.gwt.user.client.ui.PasswordTextBox) GWT.create(com.google.gwt.user.client.ui.PasswordTextBox.class);
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button guardar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button cancelar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel("<div class='gwt-TitledPanel'> <div class='title' style='float:left'><span id='" + domId0 + "'></span> </div> <div class='clear05'></div> <div class='title'>Cambio de Password</div> <div class='clear10'></div> <table> <thead></thead> <tbody> <tr> <td>Contraseña Actual</td> <td><span id='" + domId1 + "'></span></td> </tr> <tr> <td>Nueva Contraseña</td> <td><span id='" + domId2 + "'></span></td> </tr> <tr> <td>Confirme Nueva Contraseña</td> <td><span id='" + domId3 + "'></span></td> </tr> </tbody> </table> <div class='clear5'></div> <div class='clear20'></div>  <div style='float:right'> <span id='" + domId4 + "'></span> <span id='" + domId5 + "'></span> </div> <div class='clear20'></div> </div>");

    password.setMaxLength(8);
    password.setWidth("100px");
    nuevaPassword.setMaxLength(8);
    nuevaPassword.setWidth("100px");
    confirmacionNuevaPassword.setMaxLength(8);
    confirmacionNuevaPassword.setWidth("100px");
    guardar.setText("Guardar");
    cancelar.setText("Volver");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    com.google.gwt.user.client.Element domId4Element = com.google.gwt.dom.client.Document.get().getElementById(domId4).cast();
    com.google.gwt.user.client.Element domId5Element = com.google.gwt.dom.client.Document.get().getElementById(domId5).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(titulo, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(password, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(nuevaPassword, domId2Element);
    f_HTMLPanel1.addAndReplaceElement(confirmacionNuevaPassword, domId3Element);
    f_HTMLPanel1.addAndReplaceElement(guardar, domId4Element);
    f_HTMLPanel1.addAndReplaceElement(cancelar, domId5Element);


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onGuardarClick(event);
      }
    };
    guardar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onVolverClick(event);
      }
    };
    cancelar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    owner.confirmacionNuevaPassword = confirmacionNuevaPassword;
    owner.nuevaPassword = nuevaPassword;
    owner.password = password;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_HTMLPanel1;
  }
}
