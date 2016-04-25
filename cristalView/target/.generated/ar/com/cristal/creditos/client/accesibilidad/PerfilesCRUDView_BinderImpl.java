package ar.com.cristal.creditos.client.accesibilidad;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class PerfilesCRUDView_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDView>, ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDView.Binder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDView owner) {

    ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDView_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDView_BinderImpl_GenBundle) GWT.create(ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDView_BinderImpl_GenBundle.class);
    ar.com.cristal.creditos.client.accesibilidad.PerfilesCRUDView_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label1 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl txtNombrePerfil = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label2 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextArea txtDescripcionPerfil = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button botonNuevoPerfil = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button botonGuardarNombrePerfil = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.cristal.creditos.client.creditos.lineasdecredito.crud.FlexTableDinamica tablaPerfiles = (ar.com.cristal.creditos.client.creditos.lineasdecredito.crud.FlexTableDinamica) GWT.create(ar.com.cristal.creditos.client.creditos.lineasdecredito.crud.FlexTableDinamica.class);
    java.lang.String domId7 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.cristal.creditos.client.creditos.lineasdecredito.crud.FlexTableDinamica tablaComponentes = (ar.com.cristal.creditos.client.creditos.lineasdecredito.crud.FlexTableDinamica) GWT.create(ar.com.cristal.creditos.client.creditos.lineasdecredito.crud.FlexTableDinamica.class);
    java.lang.String domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button botonGuardarConfiguracionPerfil = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HTMLPanel pantallaPerfiles = new com.google.gwt.user.client.ui.HTMLPanel("<div class='gwt-TitledPanel'> <div class='title'>Perfiles</div> <table> <tr> <td> <span id='" + domId0 + "'></span> </td> <td> <span id='" + domId1 + "'></span> </td> </tr> <tr> <td> <span id='" + domId2 + "'></span> </td> <td> <span id='" + domId3 + "'></span> </td> </tr>  </table>   <div style='float:right'> <span id='" + domId4 + "'></span>    <span id='" + domId5 + "'></span> </div> <div style='clear:both'></div> <div class='clear5'></div> <div style='overflow-y: scroll; height: 150px'> <span id='" + domId6 + "'></span> </div>   <div class='clear20'></div> <div class='title'>Componentes de un perfil</div> <div> <div style='clear:both'></div>  <div class='clear5'></div> <div style='overflow-y: scroll; height: 225px'> <span id='" + domId7 + "'></span> </div> </div> <div class='clear10'></div> <div style='float:right'> <span id='" + domId8 + "'></span> </div> </div>");

    f_Label1.setStyleName("textoCSS");
    f_Label1.setText("Nombre del perfil");
    txtNombrePerfil.setWidth("200px");
    f_Label2.setStyleName("textoCSS");
    f_Label2.setText("Descripción");
    txtDescripcionPerfil.setVisibleLines(3);
    txtDescripcionPerfil.setCharacterWidth(80);
    botonNuevoPerfil.setStyleName("gwt-Button");
    botonNuevoPerfil.setText("Nuevo");
    botonNuevoPerfil.setTitle("Limpia los campos para crear un nuevo Perfil");
    botonGuardarNombrePerfil.setStyleName("gwt-Button");
    botonGuardarNombrePerfil.setText("Guardar Perfil");
    botonGuardarNombrePerfil.setTitle("Guarda la información del Perfil");
    tablaPerfiles.setWidth("960px");
    tablaComponentes.setWidth("960px");
    botonGuardarConfiguracionPerfil.setStyleName("gwt-Button");
    botonGuardarConfiguracionPerfil.setText("Guardar Perfil");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(pantallaPerfiles.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    com.google.gwt.user.client.Element domId4Element = com.google.gwt.dom.client.Document.get().getElementById(domId4).cast();
    com.google.gwt.user.client.Element domId5Element = com.google.gwt.dom.client.Document.get().getElementById(domId5).cast();
    com.google.gwt.user.client.Element domId6Element = com.google.gwt.dom.client.Document.get().getElementById(domId6).cast();
    com.google.gwt.user.client.Element domId7Element = com.google.gwt.dom.client.Document.get().getElementById(domId7).cast();
    com.google.gwt.user.client.Element domId8Element = com.google.gwt.dom.client.Document.get().getElementById(domId8).cast();
    attachRecord0.detach();
    pantallaPerfiles.addAndReplaceElement(f_Label1, domId0Element);
    pantallaPerfiles.addAndReplaceElement(txtNombrePerfil, domId1Element);
    pantallaPerfiles.addAndReplaceElement(f_Label2, domId2Element);
    pantallaPerfiles.addAndReplaceElement(txtDescripcionPerfil, domId3Element);
    pantallaPerfiles.addAndReplaceElement(botonNuevoPerfil, domId4Element);
    pantallaPerfiles.addAndReplaceElement(botonGuardarNombrePerfil, domId5Element);
    pantallaPerfiles.addAndReplaceElement(tablaPerfiles, domId6Element);
    pantallaPerfiles.addAndReplaceElement(tablaComponentes, domId7Element);
    pantallaPerfiles.addAndReplaceElement(botonGuardarConfiguracionPerfil, domId8Element);


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onNuevoPerfil(event);
      }
    };
    botonNuevoPerfil.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onBotonGuardarNombrePerfil(event);
      }
    };
    botonGuardarNombrePerfil.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onBotonGuardarConfiguracionPerfil(event);
      }
    };
    botonGuardarConfiguracionPerfil.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);

    owner.botonGuardarConfiguracionPerfil = botonGuardarConfiguracionPerfil;
    owner.botonGuardarNombrePerfil = botonGuardarNombrePerfil;
    owner.botonNuevoPerfil = botonNuevoPerfil;
    owner.tablaComponentes = tablaComponentes;
    owner.tablaPerfiles = tablaPerfiles;
    owner.txtDescripcionPerfil = txtDescripcionPerfil;
    owner.txtNombrePerfil = txtNombrePerfil;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return pantallaPerfiles;
  }
}
