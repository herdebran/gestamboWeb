package ar.com.cristal.creditos.client.ui.usuarios.abm;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class AltaEdicionUsuarioView_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, ar.com.cristal.creditos.client.ui.usuarios.abm.AltaEdicionUsuarioView>, ar.com.cristal.creditos.client.ui.usuarios.abm.AltaEdicionUsuarioView.Binder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final ar.com.cristal.creditos.client.ui.usuarios.abm.AltaEdicionUsuarioView owner) {

    ar.com.cristal.creditos.client.ui.usuarios.abm.AltaEdicionUsuarioView_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (ar.com.cristal.creditos.client.ui.usuarios.abm.AltaEdicionUsuarioView_BinderImpl_GenBundle) GWT.create(ar.com.cristal.creditos.client.ui.usuarios.abm.AltaEdicionUsuarioView_BinderImpl_GenBundle.class);
    ar.com.cristal.creditos.client.ui.usuarios.abm.AltaEdicionUsuarioView_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label titulo = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl apellido = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl nombre = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl nombreUsuario = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.PasswordTextBox password = (com.google.gwt.user.client.ui.PasswordTextBox) GWT.create(com.google.gwt.user.client.ui.PasswordTextBox.class);
    java.lang.String domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label lblModificacion = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.PasswordTextBox confirmacionPassword = (com.google.gwt.user.client.ui.PasswordTextBox) GWT.create(com.google.gwt.user.client.ui.PasswordTextBox.class);
    java.lang.String domId7 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.CheckBox supervisor = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
    java.lang.String domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.ListBox sucursales = (ar.com.snoop.gwt.commons.client.widget.ListBox) GWT.create(ar.com.snoop.gwt.commons.client.widget.ListBox.class);
    java.lang.String domId9 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.ListBox perfiles = (ar.com.snoop.gwt.commons.client.widget.ListBox) GWT.create(ar.com.snoop.gwt.commons.client.widget.ListBox.class);
    java.lang.String domId10 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.CheckBox administrador = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
    java.lang.String domId11 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button guardar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId12 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button borrar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId13 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button cancelar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel("<div class='gwt-TitledPanel'> <div class='title' style='float:left'><span id='" + domId0 + "'></span> </div> <div class='clear05'></div>  <div class='title'>Datos del usuario</div> <div class='clear10'></div> <table> <thead></thead> <tbody> <tr> <td width='120px'>Apellido</td> <td><span id='" + domId1 + "'></span></td> </tr> <tr> <td>Nombre</td> <td><span id='" + domId2 + "'></span></td> </tr> <tr> <td>Nombre de Usuario</td> <td><span id='" + domId3 + "'></span></td> </tr> <tr> <td>Contraseña</td> <td><span id='" + domId4 + "'></span></td> <td style='font-size: 8px;color: lightBlue'><span id='" + domId5 + "'></span> </td> </tr> <tr> <td>Confirmación de Contraseña</td> <td><span id='" + domId6 + "'></span></td> </tr> <tr> <td>Supervisor</td> <td><span id='" + domId7 + "'></span> </td> </tr> <tr> <td>Sucursales</td> <td><span id='" + domId8 + "'></span></td> </tr> <tr> <td>Perfil</td> <td><span id='" + domId9 + "'></span></td> </tr> <tr> <td><span id='" + domId10 + "'></span> </td> </tr>  </tbody> <tfoot> </tfoot> </table>  <div class='clear5'></div>   <div class='clear20'></div>   <div style='float:right'> <span id='" + domId11 + "'></span> <span id='" + domId12 + "'></span> <span id='" + domId13 + "'></span> </div> <div class='clear20'></div> </div>");

    apellido.setMaxLength(25);
    apellido.setWidth("160px");
    nombre.setMaxLength(25);
    nombre.setWidth("160px");
    nombreUsuario.setMaxLength(25);
    nombreUsuario.setWidth("160px");
    password.setMaxLength(8);
    password.setWidth("100px");
    lblModificacion.setText("");
    confirmacionPassword.setMaxLength(8);
    confirmacionPassword.setWidth("100px");
    sucursales.setMultipleSelect(false);
    sucursales.setWidth("200px");
    perfiles.setMultipleSelect(false);
    perfiles.setWidth("200px");
    administrador.setVisible(false);
    guardar.setText("Guardar");
    borrar.setText("Borrar");
    cancelar.setText("Volver");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    com.google.gwt.user.client.Element domId4Element = com.google.gwt.dom.client.Document.get().getElementById(domId4).cast();
    com.google.gwt.user.client.Element domId5Element = com.google.gwt.dom.client.Document.get().getElementById(domId5).cast();
    com.google.gwt.user.client.Element domId6Element = com.google.gwt.dom.client.Document.get().getElementById(domId6).cast();
    com.google.gwt.user.client.Element domId7Element = com.google.gwt.dom.client.Document.get().getElementById(domId7).cast();
    com.google.gwt.user.client.Element domId8Element = com.google.gwt.dom.client.Document.get().getElementById(domId8).cast();
    com.google.gwt.user.client.Element domId9Element = com.google.gwt.dom.client.Document.get().getElementById(domId9).cast();
    com.google.gwt.user.client.Element domId10Element = com.google.gwt.dom.client.Document.get().getElementById(domId10).cast();
    com.google.gwt.user.client.Element domId11Element = com.google.gwt.dom.client.Document.get().getElementById(domId11).cast();
    com.google.gwt.user.client.Element domId12Element = com.google.gwt.dom.client.Document.get().getElementById(domId12).cast();
    com.google.gwt.user.client.Element domId13Element = com.google.gwt.dom.client.Document.get().getElementById(domId13).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(titulo, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(apellido, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(nombre, domId2Element);
    f_HTMLPanel1.addAndReplaceElement(nombreUsuario, domId3Element);
    f_HTMLPanel1.addAndReplaceElement(password, domId4Element);
    f_HTMLPanel1.addAndReplaceElement(lblModificacion, domId5Element);
    f_HTMLPanel1.addAndReplaceElement(confirmacionPassword, domId6Element);
    f_HTMLPanel1.addAndReplaceElement(supervisor, domId7Element);
    f_HTMLPanel1.addAndReplaceElement(sucursales, domId8Element);
    f_HTMLPanel1.addAndReplaceElement(perfiles, domId9Element);
    f_HTMLPanel1.addAndReplaceElement(administrador, domId10Element);
    f_HTMLPanel1.addAndReplaceElement(guardar, domId11Element);
    f_HTMLPanel1.addAndReplaceElement(borrar, domId12Element);
    f_HTMLPanel1.addAndReplaceElement(cancelar, domId13Element);


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onButtonClick(event);
      }
    };
    cancelar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onGuardarClick(event);
      }
    };
    guardar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onBorrarClick(event);
      }
    };
    borrar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);

    final com.google.gwt.event.dom.client.ChangeHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ChangeHandler() {
      public void onChange(com.google.gwt.event.dom.client.ChangeEvent event) {
        owner.onPasswordModificado(event);
      }
    };
    password.addChangeHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);

    owner.administrador = administrador;
    owner.apellido = apellido;
    owner.borrar = borrar;
    owner.cancelar = cancelar;
    owner.confirmacionPassword = confirmacionPassword;
    owner.guardar = guardar;
    owner.lblModificacion = lblModificacion;
    owner.nombre = nombre;
    owner.nombreUsuario = nombreUsuario;
    owner.password = password;
    owner.perfiles = perfiles;
    owner.sucursales = sucursales;
    owner.supervisor = supervisor;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_HTMLPanel1;
  }
}
