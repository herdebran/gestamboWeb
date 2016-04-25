package ar.com.cristal.creditos.client.creditos.reportes;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class SeleccionReporteView_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, ar.com.cristal.creditos.client.creditos.reportes.SeleccionReporteView>, ar.com.cristal.creditos.client.creditos.reportes.SeleccionReporteView.Binder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final ar.com.cristal.creditos.client.creditos.reportes.SeleccionReporteView owner) {

    ar.com.cristal.creditos.client.creditos.reportes.SeleccionReporteView_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (ar.com.cristal.creditos.client.creditos.reportes.SeleccionReporteView_BinderImpl_GenBundle) GWT.create(ar.com.cristal.creditos.client.creditos.reportes.SeleccionReporteView_BinderImpl_GenBundle.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.datepicker.FullDatePicker fechaDesde = owner.fechaDesde;
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.datepicker.FullDatePicker fechaHasta = owner.fechaHasta;
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.ListBox tipoReporte = (ar.com.snoop.gwt.commons.client.widget.ListBox) GWT.create(ar.com.snoop.gwt.commons.client.widget.ListBox.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextArea descripcion = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button buttonReporte = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel("<div class='gwt-TitledPanel'> <div class='title'>Reportes por tipo y rango de fechas</div> <div style='float:left'>Complete los datos para realizar la consulta</div> <br><br> <table> <thead></thead> <tbody> <tr> <td width='80px'>Fecha desde</td> <td width='80px'><span id='" + domId0 + "'></span></td> <td width='40px'></td> <td width='80px'>Fecha hasta</td> <td width='80px'><span id='" + domId1 + "'></span></td> <td width='40px'></td> <td width='80px'>Motivo</td> <td><span id='" + domId2 + "'></span></td> </tr> <tr> <td width='80px'>Descripción</td> <td colspan='7'><span id='" + domId3 + "'></span></td> </tr> </tbody> </table> <br><br><br> <span id='" + domId4 + "'></span>  </div>");

    tipoReporte.setMultipleSelect(false);
    tipoReporte.setWidth("280px");
    descripcion.setWidth("100%");
    buttonReporte.setText("Generar Reporte");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    com.google.gwt.user.client.Element domId4Element = com.google.gwt.dom.client.Document.get().getElementById(domId4).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(fechaDesde, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(fechaHasta, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(tipoReporte, domId2Element);
    f_HTMLPanel1.addAndReplaceElement(descripcion, domId3Element);
    f_HTMLPanel1.addAndReplaceElement(buttonReporte, domId4Element);


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onGenerarReporte(event);
      }
    };
    buttonReporte.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ChangeHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ChangeHandler() {
      public void onChange(com.google.gwt.event.dom.client.ChangeEvent event) {
        owner.onTipoReporte(event);
      }
    };
    tipoReporte.addChangeHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    owner.buttonReporte = buttonReporte;
    owner.descripcion = descripcion;
    owner.tipoReporte = tipoReporte;

    return f_HTMLPanel1;
  }
}
