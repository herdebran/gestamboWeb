package ar.com.cristal.creditos.client.clientes.busqueda;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class BusquedaClientesView_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesView>, ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesView.Binder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesView owner) {

    ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesView_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesView_BinderImpl_GenBundle) GWT.create(ar.com.cristal.creditos.client.clientes.busqueda.BusquedaClientesView_BinderImpl_GenBundle.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl rcAnimal = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl rpAnimal = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button buttonBuscar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button buttonBorrar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button buttonModificar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button buttonNuevo = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button buttonFichaVaca = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.dom.client.DivElement divTabla = null;
    java.lang.String domId7 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.FlexTable listadoAnimales = owner.listadoAnimales;
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel("<div class='gwt-TitledPanel'> <div class='title'>Búsqueda de Animales</div> <div style='font-size:11px;float:left;font-weight:normal'>Las búsquedas verifican la existencia de OTRO animal con igual RP al animal encontrado por cualquier criterio</div> <br><br> <table> <thead></thead> <tbody> <tr> <td>RC</td> <td> <span id='" + domId0 + "'></span> </td> </tr> <tr> <td>RP</td> <td> <span id='" + domId1 + "'></span> </td> <td>(ENTER para intentar abrir la ficha)</td> </tr> </tbody> </table> <div class='clear10'></div> <div style='float:left'> <span id='" + domId2 + "'></span> <span id='" + domId3 + "'></span> <span id='" + domId4 + "'></span> <span id='" + domId5 + "'></span> <span id='" + domId6 + "'></span> </div> <div class='clear10'></div> <div id='" + domId7 + "' style='height: 200px'> <span id='" + domId8 + "'></span> </div> <div class='clear15'></div>   </div>");

    rcAnimal.setMaxLength(100);
    rcAnimal.setWidth("100px");
    rcAnimal.setExpresionRegular("[0123456789]{0,9}");
    rpAnimal.setMaxLength(100);
    rpAnimal.setWidth("60px");
    rpAnimal.setExpresionRegular("[0123456789]{0,10}");
    buttonBuscar.setText("Buscar");
    buttonBorrar.setText("Limpiar");
    buttonModificar.setText("Modificar Animal");
    buttonNuevo.setText("Nuevo Animal");
    buttonFichaVaca.setText("Ficha de Animal");
    buttonFichaVaca.setVisible(true);
    listadoAnimales.ensureDebugId("listadoAnimales");
    listadoAnimales.setStyleName("dataTable");
    listadoAnimales.setWidth("98%");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    com.google.gwt.user.client.Element domId4Element = com.google.gwt.dom.client.Document.get().getElementById(domId4).cast();
    com.google.gwt.user.client.Element domId5Element = com.google.gwt.dom.client.Document.get().getElementById(domId5).cast();
    com.google.gwt.user.client.Element domId6Element = com.google.gwt.dom.client.Document.get().getElementById(domId6).cast();
    divTabla = com.google.gwt.dom.client.Document.get().getElementById(domId7).cast();
    divTabla.removeAttribute("id");
    com.google.gwt.user.client.Element domId8Element = com.google.gwt.dom.client.Document.get().getElementById(domId8).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(rcAnimal, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(rpAnimal, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(buttonBuscar, domId2Element);
    f_HTMLPanel1.addAndReplaceElement(buttonBorrar, domId3Element);
    f_HTMLPanel1.addAndReplaceElement(buttonModificar, domId4Element);
    f_HTMLPanel1.addAndReplaceElement(buttonNuevo, domId5Element);
    f_HTMLPanel1.addAndReplaceElement(buttonFichaVaca, domId6Element);
    f_HTMLPanel1.addAndReplaceElement(listadoAnimales, domId8Element);


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onButtonNuevo(event);
      }
    };
    buttonNuevo.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onButtonBuscarClick(event);
      }
    };
    buttonBuscar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onButtonModificarClick(event);
      }
    };
    buttonModificar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);

    final com.google.gwt.event.dom.client.KeyUpHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.KeyUpHandler() {
      public void onKeyUp(com.google.gwt.event.dom.client.KeyUpEvent event) {
        owner.onRpKeyPress(event);
      }
    };
    rpAnimal.addKeyUpHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);

    final com.google.gwt.event.dom.client.KeyUpHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.KeyUpHandler() {
      public void onKeyUp(com.google.gwt.event.dom.client.KeyUpEvent event) {
        owner.onRcKeyPress(event);
      }
    };
    rcAnimal.addKeyUpHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onTableClick(event);
      }
    };
    listadoAnimales.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6);

    owner.buttonBorrar = buttonBorrar;
    owner.buttonBuscar = buttonBuscar;
    owner.buttonFichaVaca = buttonFichaVaca;
    owner.buttonModificar = buttonModificar;
    owner.buttonNuevo = buttonNuevo;
    owner.divTabla = divTabla;
    owner.rcAnimal = rcAnimal;
    owner.rpAnimal = rpAnimal;

    return f_HTMLPanel1;
  }
}
