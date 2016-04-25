package ar.com.cristal.creditos.client.clientes.busqueda.detalle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class OperacionesHistorialCreditosClienteView_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClienteView>, ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClienteView.Binder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClienteView owner) {

    ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClienteView_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClienteView_BinderImpl_GenBundle) GWT.create(ar.com.cristal.creditos.client.clientes.busqueda.detalle.OperacionesHistorialCreditosClienteView_BinderImpl_GenBundle.class);
    com.google.gwt.dom.client.DivElement clienteDiv = null;
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Anchor anchorDatosOperaciones = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Anchor anchorDatosPersonales = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Anchor anchorDatosAnexos = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    java.lang.String domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Anchor anchorReferidos = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    java.lang.String domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Anchor anchorGarantes = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    java.lang.String domId7 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Anchor anchorSeguimiento = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    java.lang.String domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Anchor anchorLegales = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    java.lang.String domId9 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Anchor anchorLlamadasEnCurso = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel("<ul id='menu'> <li><span id='" + domId2 + "'></span></li> <li><span id='" + domId3 + "'></span></li> <li><span id='" + domId4 + "'></span></li> <li><span id='" + domId5 + "'></span></li> <li><span id='" + domId6 + "'></span></li> <li><span id='" + domId7 + "'></span></li> <li><span id='" + domId8 + "'></span></li> <li><span id='" + domId9 + "'></span></li> </ul>");
    java.lang.String domId10 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label convenioExtrajudical = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId11 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox condicionMorosidad = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId12 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox cuitCliente = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId13 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox cuotasSocialesDeuda = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId14 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.ListBox comportamientoPago = (ar.com.snoop.gwt.commons.client.widget.ListBox) GWT.create(ar.com.snoop.gwt.commons.client.widget.ListBox.class);
    java.lang.String domId15 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label diasUltimoPago = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId16 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId17 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label mensaje = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HTMLPanel avisoOperacionesPanel = new com.google.gwt.user.client.ui.HTMLPanel("<span id='" + domId17 + "'></span>");
    com.google.gwt.dom.client.DivElement divTablaCreditos = null;
    java.lang.String domId18 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId19 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.FlexTable listadoHistorialCliente = owner.listadoHistorialCliente;
    java.lang.String domId20 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId21 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label creditoSeleccionado = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId22 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.FlexTable listadoCuotas = owner.listadoCuotas;
    com.google.gwt.user.client.ui.HTMLPanel panelCuotas = new com.google.gwt.user.client.ui.HTMLPanel("<div class='title' style='float:left'><span id='" + domId21 + "'></span></div> <div style='clear:both'></div> <div style='overflow-y: scroll; height: 200px'> <span id='" + domId22 + "'></span> </div>");
    java.lang.String domId23 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button buttonSolicitud = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId24 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button buttonRefinanciacion = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId25 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button buttonFinanciacion = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId26 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button buttonParalelo = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId27 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button buttonAdelantoSueldo = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId28 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button buttonCambiarPagoVoluntario = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId29 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button buttonModificarCredito = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId30 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button button = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId31 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button buttonPagar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId32 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button agendarLlamada = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId33 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button btnRegistrarSeguimiento = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId34 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button buttonBonificacionReintegro = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId35 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button buttonAnular = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId36 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button buttonAnularConvenio = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId37 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button buttonPagarCuotaSocial = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel("<div class='gwt-TitledPanel'> <div class='title' id='" + domId0 + "'>Cliente</div> </div> <span id='" + domId1 + "'></span>  <div class='gwt-TitledPanel'> <div class='title'>Historial Créditos Cliente | Operaciones</div> <div style='float:left; width:100%;font-family:Arial;font-size:11px'> <div id='contenedorDatosPersonales' style='float:left;width:60%'> <div class='lineaDatoPersonal'> <div style='width: 24%; float:left'>Convenio Extrajudicial:</div> <div style='width: 24%; float:left'><span id='" + domId10 + "'></span></div> <div style='width: 24%; float:left'>Condición Morosidad:</div> <div style='width: 24%; float:left'><span id='" + domId11 + "'></span></div> </div> <div style='clear:both'></div> <div class='lineaDatoPersonal'> <div style='width: 24%; float:left'>Cuil:</div> <div style='width: 24%; float:left'><span id='" + domId12 + "'></span></div> <div style='width: 24%; float:left'>Cuotas Sociales Adeudadas</div> <div style='width: 24%; float:left'><span id='" + domId13 + "'></span></div> </div> </div> <div id='contenedorComportamientoPago' style='float:left;width:40%'> <div class='lineaDatoPersonal'> <div style='width: 49%; float:left'>Comportamiento Pago Débito</div> <div style='width: 49%; float:left'><span id='" + domId14 + "'></span></div> </div> <div class='clear10'></div> <div class='lineaDatoPersonal'> <div style='width: 49%; float:left'><span id='" + domId15 + "'></span></div> </div> </div> </div>  <div class='clear20'></div> <span id='" + domId16 + "'></span> <div class='title'>Operaciones</div> <div class='divScroll' id='" + domId18 + "' style='height: 150px'> <span id='" + domId19 + "'></span> </div> <div class='clear5'></div> <span id='" + domId20 + "'></span> <br><br> <div> <span id='" + domId23 + "'></span> <span id='" + domId24 + "'></span> <span id='" + domId25 + "'></span> <span id='" + domId26 + "'></span> <span id='" + domId27 + "'></span> <span id='" + domId28 + "'></span> <span id='" + domId29 + "'></span> </div> <div class='clear10'></div> <div> <span id='" + domId30 + "'></span> <span id='" + domId31 + "'></span> <span id='" + domId32 + "'></span> <span id='" + domId33 + "'></span> <span id='" + domId34 + "'></span> <span id='" + domId35 + "'></span> <span id='" + domId36 + "'></span> <span id='" + domId37 + "'></span> </div>  </div>");

    anchorDatosOperaciones.setHTML("Operaciones");
    anchorDatosOperaciones.ensureDebugId("anchorDatosOperaciones");
    anchorDatosPersonales.setHTML("Datos del Cliente");
    anchorDatosPersonales.ensureDebugId("anchorDatosPersonales");
    anchorDatosAnexos.setHTML("Datos Anexos");
    anchorDatosAnexos.ensureDebugId("anchorDatosAnexos");
    anchorReferidos.setHTML("Referidos");
    anchorReferidos.ensureDebugId("anchorReferidos");
    anchorGarantes.setHTML("Garantes");
    anchorGarantes.ensureDebugId("anchorGarantes");
    anchorSeguimiento.setHTML("Seguimiento");
    anchorSeguimiento.ensureDebugId("anchorSeguimiento");
    anchorLegales.setHTML("Legales");
    anchorLegales.ensureDebugId("anchorSeguimiento");
    anchorLlamadasEnCurso.setHTML("Llamada en Curso");
    anchorLlamadasEnCurso.ensureDebugId("anchorLlamadaEnCurso");
    condicionMorosidad.setReadOnly(true);
    condicionMorosidad.setWidth("90%");
    cuitCliente.setMaxLength(30);
    cuitCliente.setWidth("90%");
    cuotasSocialesDeuda.setMaxLength(10);
    cuotasSocialesDeuda.setWidth("90%");
    comportamientoPago.setMultipleSelect(false);
    comportamientoPago.setWidth("90%");
    listadoHistorialCliente.ensureDebugId("listadoHistorialCliente");
    listadoHistorialCliente.setStyleName("dataTable");
    listadoHistorialCliente.setWidth("100%");
    listadoCuotas.ensureDebugId("listadoCuotas");
    listadoCuotas.setStyleName("dataTable");
    listadoCuotas.setWidth("100%");
    panelCuotas.setVisible(false);
    buttonSolicitud.setText("Nuevo Crédito / Renovación");
    buttonRefinanciacion.setText("Refinanciar");
    buttonFinanciacion.setText("Financiar Deuda");
    buttonParalelo.setText("Crédito Paralelo");
    buttonAdelantoSueldo.setText("AdelantoSueldo");
    buttonCambiarPagoVoluntario.setText("Cambiar Pago Voluntario");
    buttonCambiarPagoVoluntario.setTitle("Cambia el indicador de pago voluntario");
    buttonModificarCredito.setText("Modificar Crédito");
    buttonModificarCredito.setVisible(true);
    button.setText("Búsqueda Cliente");
    buttonPagar.setText("Pago Cuotas");
    agendarLlamada.setText("Agendar Llamada");
    btnRegistrarSeguimiento.setText("Registrar Seguimiento");
    buttonBonificacionReintegro.setText("Bonificación");
    buttonAnular.setText("Anular Crédito");
    buttonAnular.setTitle("Anula solo Créditos que no estén ACTIVOS dentro de la semana de creación");
    buttonAnularConvenio.setText("Anular Convenio");
    buttonAnularConvenio.setTitle("Anula un convenio ACTIVO por incumplimiento de pago.");
    buttonPagarCuotaSocial.setText("Cuotas Sociales");
    buttonPagarCuotaSocial.setTitle("Registra el pago de cuotas sociales.");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    clienteDiv = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    clienteDiv.removeAttribute("id");
    UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    com.google.gwt.user.client.Element domId4Element = com.google.gwt.dom.client.Document.get().getElementById(domId4).cast();
    com.google.gwt.user.client.Element domId5Element = com.google.gwt.dom.client.Document.get().getElementById(domId5).cast();
    com.google.gwt.user.client.Element domId6Element = com.google.gwt.dom.client.Document.get().getElementById(domId6).cast();
    com.google.gwt.user.client.Element domId7Element = com.google.gwt.dom.client.Document.get().getElementById(domId7).cast();
    com.google.gwt.user.client.Element domId8Element = com.google.gwt.dom.client.Document.get().getElementById(domId8).cast();
    com.google.gwt.user.client.Element domId9Element = com.google.gwt.dom.client.Document.get().getElementById(domId9).cast();
    attachRecord1.detach();
    f_HTMLPanel2.addAndReplaceElement(anchorDatosOperaciones, domId2Element);
    f_HTMLPanel2.addAndReplaceElement(anchorDatosPersonales, domId3Element);
    f_HTMLPanel2.addAndReplaceElement(anchorDatosAnexos, domId4Element);
    f_HTMLPanel2.addAndReplaceElement(anchorReferidos, domId5Element);
    f_HTMLPanel2.addAndReplaceElement(anchorGarantes, domId6Element);
    f_HTMLPanel2.addAndReplaceElement(anchorSeguimiento, domId7Element);
    f_HTMLPanel2.addAndReplaceElement(anchorLegales, domId8Element);
    f_HTMLPanel2.addAndReplaceElement(anchorLlamadasEnCurso, domId9Element);
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId10Element = com.google.gwt.dom.client.Document.get().getElementById(domId10).cast();
    com.google.gwt.user.client.Element domId11Element = com.google.gwt.dom.client.Document.get().getElementById(domId11).cast();
    com.google.gwt.user.client.Element domId12Element = com.google.gwt.dom.client.Document.get().getElementById(domId12).cast();
    com.google.gwt.user.client.Element domId13Element = com.google.gwt.dom.client.Document.get().getElementById(domId13).cast();
    com.google.gwt.user.client.Element domId14Element = com.google.gwt.dom.client.Document.get().getElementById(domId14).cast();
    com.google.gwt.user.client.Element domId15Element = com.google.gwt.dom.client.Document.get().getElementById(domId15).cast();
    UiBinderUtil.TempAttachment attachRecord2 = UiBinderUtil.attachToDom(avisoOperacionesPanel.getElement());
    com.google.gwt.user.client.Element domId17Element = com.google.gwt.dom.client.Document.get().getElementById(domId17).cast();
    attachRecord2.detach();
    avisoOperacionesPanel.addAndReplaceElement(mensaje, domId17Element);
    com.google.gwt.user.client.Element domId16Element = com.google.gwt.dom.client.Document.get().getElementById(domId16).cast();
    divTablaCreditos = com.google.gwt.dom.client.Document.get().getElementById(domId18).cast();
    divTablaCreditos.removeAttribute("id");
    com.google.gwt.user.client.Element domId19Element = com.google.gwt.dom.client.Document.get().getElementById(domId19).cast();
    UiBinderUtil.TempAttachment attachRecord3 = UiBinderUtil.attachToDom(panelCuotas.getElement());
    com.google.gwt.user.client.Element domId21Element = com.google.gwt.dom.client.Document.get().getElementById(domId21).cast();
    com.google.gwt.user.client.Element domId22Element = com.google.gwt.dom.client.Document.get().getElementById(domId22).cast();
    attachRecord3.detach();
    panelCuotas.addAndReplaceElement(creditoSeleccionado, domId21Element);
    panelCuotas.addAndReplaceElement(listadoCuotas, domId22Element);
    com.google.gwt.user.client.Element domId20Element = com.google.gwt.dom.client.Document.get().getElementById(domId20).cast();
    com.google.gwt.user.client.Element domId23Element = com.google.gwt.dom.client.Document.get().getElementById(domId23).cast();
    com.google.gwt.user.client.Element domId24Element = com.google.gwt.dom.client.Document.get().getElementById(domId24).cast();
    com.google.gwt.user.client.Element domId25Element = com.google.gwt.dom.client.Document.get().getElementById(domId25).cast();
    com.google.gwt.user.client.Element domId26Element = com.google.gwt.dom.client.Document.get().getElementById(domId26).cast();
    com.google.gwt.user.client.Element domId27Element = com.google.gwt.dom.client.Document.get().getElementById(domId27).cast();
    com.google.gwt.user.client.Element domId28Element = com.google.gwt.dom.client.Document.get().getElementById(domId28).cast();
    com.google.gwt.user.client.Element domId29Element = com.google.gwt.dom.client.Document.get().getElementById(domId29).cast();
    com.google.gwt.user.client.Element domId30Element = com.google.gwt.dom.client.Document.get().getElementById(domId30).cast();
    com.google.gwt.user.client.Element domId31Element = com.google.gwt.dom.client.Document.get().getElementById(domId31).cast();
    com.google.gwt.user.client.Element domId32Element = com.google.gwt.dom.client.Document.get().getElementById(domId32).cast();
    com.google.gwt.user.client.Element domId33Element = com.google.gwt.dom.client.Document.get().getElementById(domId33).cast();
    com.google.gwt.user.client.Element domId34Element = com.google.gwt.dom.client.Document.get().getElementById(domId34).cast();
    com.google.gwt.user.client.Element domId35Element = com.google.gwt.dom.client.Document.get().getElementById(domId35).cast();
    com.google.gwt.user.client.Element domId36Element = com.google.gwt.dom.client.Document.get().getElementById(domId36).cast();
    com.google.gwt.user.client.Element domId37Element = com.google.gwt.dom.client.Document.get().getElementById(domId37).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel2, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(convenioExtrajudical, domId10Element);
    f_HTMLPanel1.addAndReplaceElement(condicionMorosidad, domId11Element);
    f_HTMLPanel1.addAndReplaceElement(cuitCliente, domId12Element);
    f_HTMLPanel1.addAndReplaceElement(cuotasSocialesDeuda, domId13Element);
    f_HTMLPanel1.addAndReplaceElement(comportamientoPago, domId14Element);
    f_HTMLPanel1.addAndReplaceElement(diasUltimoPago, domId15Element);
    f_HTMLPanel1.addAndReplaceElement(avisoOperacionesPanel, domId16Element);
    f_HTMLPanel1.addAndReplaceElement(listadoHistorialCliente, domId19Element);
    f_HTMLPanel1.addAndReplaceElement(panelCuotas, domId20Element);
    f_HTMLPanel1.addAndReplaceElement(buttonSolicitud, domId23Element);
    f_HTMLPanel1.addAndReplaceElement(buttonRefinanciacion, domId24Element);
    f_HTMLPanel1.addAndReplaceElement(buttonFinanciacion, domId25Element);
    f_HTMLPanel1.addAndReplaceElement(buttonParalelo, domId26Element);
    f_HTMLPanel1.addAndReplaceElement(buttonAdelantoSueldo, domId27Element);
    f_HTMLPanel1.addAndReplaceElement(buttonCambiarPagoVoluntario, domId28Element);
    f_HTMLPanel1.addAndReplaceElement(buttonModificarCredito, domId29Element);
    f_HTMLPanel1.addAndReplaceElement(button, domId30Element);
    f_HTMLPanel1.addAndReplaceElement(buttonPagar, domId31Element);
    f_HTMLPanel1.addAndReplaceElement(agendarLlamada, domId32Element);
    f_HTMLPanel1.addAndReplaceElement(btnRegistrarSeguimiento, domId33Element);
    f_HTMLPanel1.addAndReplaceElement(buttonBonificacionReintegro, domId34Element);
    f_HTMLPanel1.addAndReplaceElement(buttonAnular, domId35Element);
    f_HTMLPanel1.addAndReplaceElement(buttonAnularConvenio, domId36Element);
    f_HTMLPanel1.addAndReplaceElement(buttonPagarCuotaSocial, domId37Element);


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onButtonClick(event);
      }
    };
    button.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onLineaPagoCuotaBonificacionReintegroClick(event);
      }
    };
    listadoCuotas.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onAdelantoSueldoClick(event);
      }
    };
    buttonAdelantoSueldo.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onDatosPersonalesClick(event);
      }
    };
    anchorDatosPersonales.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onLegales(event);
      }
    };
    anchorLegales.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onDatosOperaciones(event);
      }
    };
    anchorDatosOperaciones.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onAnularCredito(event);
      }
    };
    buttonAnular.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onTableClick(event);
      }
    };
    listadoHistorialCliente.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames9 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onCambiarPagoVoluntario(event);
      }
    };
    buttonCambiarPagoVoluntario.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames9);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames10 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onAnularConvenio(event);
      }
    };
    buttonAnularConvenio.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames10);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames11 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onModificarCredito(event);
      }
    };
    buttonModificarCredito.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames11);

    owner.agendarLlamada = agendarLlamada;
    owner.anchorDatosAnexos = anchorDatosAnexos;
    owner.anchorDatosOperaciones = anchorDatosOperaciones;
    owner.anchorDatosPersonales = anchorDatosPersonales;
    owner.anchorGarantes = anchorGarantes;
    owner.anchorLegales = anchorLegales;
    owner.anchorLlamadasEnCurso = anchorLlamadasEnCurso;
    owner.anchorReferidos = anchorReferidos;
    owner.anchorSeguimiento = anchorSeguimiento;
    owner.avisoOperacionesPanel = avisoOperacionesPanel;
    owner.btnRegistrarSeguimiento = btnRegistrarSeguimiento;
    owner.button = button;
    owner.buttonAdelantoSueldo = buttonAdelantoSueldo;
    owner.buttonBonificacionReintegro = buttonBonificacionReintegro;
    owner.buttonCambiarPagoVoluntario = buttonCambiarPagoVoluntario;
    owner.buttonFinanciacion = buttonFinanciacion;
    owner.buttonModificarCredito = buttonModificarCredito;
    owner.buttonPagar = buttonPagar;
    owner.buttonPagarCuotaSocial = buttonPagarCuotaSocial;
    owner.buttonParalelo = buttonParalelo;
    owner.buttonRefinanciacion = buttonRefinanciacion;
    owner.buttonSolicitud = buttonSolicitud;
    owner.clienteDiv = clienteDiv;
    owner.comportamientoPago = comportamientoPago;
    owner.condicionMorosidad = condicionMorosidad;
    owner.convenioExtrajudical = convenioExtrajudical;
    owner.creditoSeleccionado = creditoSeleccionado;
    owner.cuitCliente = cuitCliente;
    owner.cuotasSocialesDeuda = cuotasSocialesDeuda;
    owner.diasUltimoPago = diasUltimoPago;
    owner.divTablaCreditos = divTablaCreditos;
    owner.mensaje = mensaje;
    owner.panelCuotas = panelCuotas;

    return f_HTMLPanel1;
  }
}
