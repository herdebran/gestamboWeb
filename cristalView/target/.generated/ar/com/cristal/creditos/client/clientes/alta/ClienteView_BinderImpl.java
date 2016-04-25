package ar.com.cristal.creditos.client.clientes.alta;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ClienteView_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, ar.com.cristal.creditos.client.clientes.alta.ClienteView>, ar.com.cristal.creditos.client.clientes.alta.ClienteView.Binder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final ar.com.cristal.creditos.client.clientes.alta.ClienteView owner) {

    ar.com.cristal.creditos.client.clientes.alta.ClienteView_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (ar.com.cristal.creditos.client.clientes.alta.ClienteView_BinderImpl_GenBundle) GWT.create(ar.com.cristal.creditos.client.clientes.alta.ClienteView_BinderImpl_GenBundle.class);
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
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl apellido = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId11 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl nombre = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId12 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.datepicker.FullDatePicker fechaNacimientoDatePicker = owner.fechaNacimientoDatePicker;
    java.lang.String domId13 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.ListBox sexo = (ar.com.snoop.gwt.commons.client.widget.ListBox) GWT.create(ar.com.snoop.gwt.commons.client.widget.ListBox.class);
    java.lang.String domId14 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.ListBox tipoDoc = (ar.com.snoop.gwt.commons.client.widget.ListBox) GWT.create(ar.com.snoop.gwt.commons.client.widget.ListBox.class);
    java.lang.String domId15 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl dni = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId16 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl cuil = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId17 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl verificadorDni = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId18 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.ListBox estadoCliente = (ar.com.snoop.gwt.commons.client.widget.ListBox) GWT.create(ar.com.snoop.gwt.commons.client.widget.ListBox.class);
    java.lang.String domId19 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.ListBox provincia = (ar.com.snoop.gwt.commons.client.widget.ListBox) GWT.create(ar.com.snoop.gwt.commons.client.widget.ListBox.class);
    java.lang.String domId20 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox localidad = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId21 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button buscarLocalidad = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId22 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl cp = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId23 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl calle = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId24 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl nro = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId25 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl piso = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId26 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl dpto = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId27 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl caracteristica = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId28 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl telefono = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId29 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl caracteristica1 = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId30 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl telefono1 = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId31 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox reparticion = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId32 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button buscarReparticion = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId33 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId34 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl email = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId35 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId36 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.CheckBox tarjetaBeneficios = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
    java.lang.String domId37 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label5 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId38 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.CheckBox antecedentesJuridicos = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
    java.lang.String domId39 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl caracteristica2 = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId40 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl telefono2 = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId41 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl caracteristica3 = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId42 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl telefono3 = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId43 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.ListBox banco = (ar.com.snoop.gwt.commons.client.widget.ListBox) GWT.create(ar.com.snoop.gwt.commons.client.widget.ListBox.class);
    java.lang.String domId44 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl nroCuenta = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId45 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl cbu = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId46 = com.google.gwt.dom.client.Document.get().createUniqueId();
    ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl verificadorCBU = (ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl) GWT.create(ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl.class);
    java.lang.String domId47 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.CheckBox checkPagoVoluntario = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
    java.lang.String domId48 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox comercializador = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId49 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button buscarComercializador = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId50 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextArea observaciones = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
    java.lang.String domId51 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button aplicar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    java.lang.String domId52 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button cerrar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel("<div class='gwt-TitledPanel'> <div class='title' id='" + domId0 + "'>Cliente</div> </div>  <span id='" + domId1 + "'></span>  <div class='clear5'></div> <div class='title' style='float:left'>Datos Personales</div> <div class='clear5'></div> <table> <thead></thead> <tbody> <tr> <td width='80px'>Apellido</td> <td width='200px'><span id='" + domId10 + "'></span></td> <td width='80px'>Nombre</td> <td><span id='" + domId11 + "'></span></td> <td></td> <td></td> </tr> <tr> <td>Fecha Nacimiento</td> <td><span id='" + domId12 + "'></span></td> <td>Sexo</td> <td><span id='" + domId13 + "'></span></td> <td></td> <td></td> </tr> <tr><td colspan='6'> </td></tr> <tr> <td>Tipo Documento</td> <td><span id='" + domId14 + "'></span></td> <td></td> <td></td> <td></td> <td></td> </tr> <tr> <td>DNI</td> <td><span id='" + domId15 + "'></span></td> <td>CUIL</td> <td><span id='" + domId16 + "'></span></td> <td></td> <td></td> </tr>  <tr> <td>Repetir DNI</td> <td><span id='" + domId17 + "'></span></td> <td>Estado</td> <td width='200px'><span id='" + domId18 + "'></span></td> <td></td> <td></td> </tr>  </tbody> <tfoot> </tfoot> </table> <div class='clear20'></div> <div class='title' style='float:left'>Domicilio</div> <div class='clear5'></div> <table> <thead></thead> <tbody> <tr> <td width='80px'>Provincia</td> <td width='200px'><span id='" + domId19 + "'></span></td> <td colspan='2'> Localidad: <span id='" + domId20 + "'></span> <span id='" + domId21 + "'></span>  Cp: <span id='" + domId22 + "'></span> </td> </tr>  <tr><td colspan='6'> </td></tr>  <tr> <td width='80px'>Calle</td> <td colspan='2'><span id='" + domId23 + "'></span></td> <td colspan='3'> Nro: <span id='" + domId24 + "'></span>  Piso: <span id='" + domId25 + "'></span>  Dpto: <span id='" + domId26 + "'></span>  </td> </tr> <tr><td colspan='6'> </td></tr> <tr> <td width='80px'>Teléfono Fijo</td> <td> <span id='" + domId27 + "'></span> <span id='" + domId28 + "'></span> </td> <td width='80px'>Celular</td> <td> <span id='" + domId29 + "'></span> <span id='" + domId30 + "'></span> <td>Caracteristica sin 0 y numero sin 15.<i> Ejemplo: 221655122</i></td> </td>  </tr>  </tbody> <tfoot> </tfoot> </table>  <div class='clear20'></div> <div id='Laboral-Banco'> <div style='float:left; width:60%'> <div class='title'> Datos Laborales</div> <div class='clear5'></div> <table> <thead></thead> <tbody> <tr> <td width='80px'>Repartición</td> <td colspan='3'><span id='" + domId31 + "'></span> <span id='" + domId32 + "'></span></td> </tr>    <tr> <td> <span id='" + domId33 + "'></span> </td> <td><span id='" + domId34 + "'></span></td> </tr> <tr> <td> <span id='" + domId35 + "'></span> </td> <td><span id='" + domId36 + "'></span></td> </tr> <tr> <td> <span id='" + domId37 + "'></span> </td> <td> <span id='" + domId38 + "'></span> </td> </tr> <tr> <td width='80px'>Tel Laboral 1</td> <td> <span id='" + domId39 + "'></span> <span id='" + domId40 + "'></span> </td> <td width='80px'>Tel Laboral 2</td> <td> <span id='" + domId41 + "'></span> <span id='" + domId42 + "'></span> </td> </tr> </tbody> <tfoot> </tfoot> </table> </div> <div style='float:left; width:35%; margin-left: 1%'> <div class='title' style='float:left'>Datos Bancarios</div> <div class='clear5'></div> <table> <thead></thead> <tbody> <tr> <td width='40%'>Banco</td> <td width='60%'><span id='" + domId43 + "'></span></td> </tr> <tr> <td>Nro Cuenta</td> <td><span id='" + domId44 + "'></span></td> </tr> <tr> <td>CBU</td> <td><span id='" + domId45 + "'></span></td> </tr> <tr> <td>Repetir CBU</td> <td><span id='" + domId46 + "'></span></td> </tr> <tr> <td>Pago Voluntario</td> <td><span id='" + domId47 + "'></span></td> </tr>  </tbody> <tfoot> </tfoot> </table> </div> </div>   <div class='clear20'></div>  <div> <div class='title' style='float:left'>Comercializador</div> <div class='clear5'></div> <table> <thead></thead> <tbody> <td width='80px'>Comercializador</td> <td><span id='" + domId48 + "'></span> <span id='" + domId49 + "'></span></td> </tbody> <tfoot> </tfoot> </table> </div>  <div class='clear20'></div> <div class='title' style='float:left'>Observaciones</div> <div class='clear5'></div> <span id='" + domId50 + "'></span> <div class='clear10'></div> <div style='float:right'> <span id='" + domId51 + "'></span> <span id='" + domId52 + "'></span> </div> <div class='clear20'></div>");

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
    anchorLegales.ensureDebugId("anchorLegales");
    anchorLlamadasEnCurso.setHTML("Llamada en Curso");
    anchorLlamadasEnCurso.ensureDebugId("anchorLlamadaEnCurso");
    apellido.setMaxLength(50);
    apellido.setWidth("160px");
    nombre.setMaxLength(50);
    nombre.setWidth("160px");
    sexo.setMultipleSelect(false);
    sexo.setWidth("100px");
    tipoDoc.setMultipleSelect(false);
    tipoDoc.setWidth("80px");
    dni.setWidth("80px");
    cuil.setWidth("160px");
    verificadorDni.setWidth("80px");
    estadoCliente.setEnabled(true);
    estadoCliente.setMultipleSelect(false);
    estadoCliente.setWidth("150px");
    provincia.setMultipleSelect(false);
    provincia.setWidth("150px");
    localidad.setReadOnly(true);
    localidad.setWidth("150px");
    buscarLocalidad.setText("...");
    buscarLocalidad.setVisible(true);
    cp.setReadOnly(true);
    cp.setMaxLength(8);
    cp.setWidth("50px");
    calle.setMaxLength(255);
    calle.setWidth("250px");
    nro.setMaxLength(6);
    nro.setWidth("40px");
    piso.setMaxLength(2);
    piso.setWidth("40px");
    dpto.setMaxLength(4);
    dpto.setWidth("40px");
    caracteristica.setMaxLength(6);
    caracteristica.setWidth("40px");
    telefono.setMaxLength(10);
    telefono.setWidth("120px");
    caracteristica1.setMaxLength(6);
    caracteristica1.setWidth("40px");
    telefono1.setMaxLength(10);
    telefono1.setWidth("120px");
    reparticion.setEnabled(true);
    reparticion.setReadOnly(true);
    reparticion.setWidth("85%");
    buscarReparticion.setText("...");
    buscarReparticion.setVisible(true);
    f_Label3.setStyleName("textoCSS");
    f_Label3.setText("e-mail");
    email.setMaxLength(50);
    email.setWidth("160px");
    f_Label4.setStyleName("textoCSS");
    f_Label4.setText("Tarjeta de Beneficios");
    f_Label5.setStyleName("textoCSS");
    f_Label5.setText("Antecedentes jurídicos");
    caracteristica2.setMaxLength(6);
    caracteristica2.setWidth("40px");
    telefono2.setMaxLength(10);
    telefono2.setWidth("120px");
    caracteristica3.setMaxLength(6);
    caracteristica3.setWidth("40px");
    telefono3.setMaxLength(10);
    telefono3.setWidth("120px");
    banco.setEnabled(false);
    banco.setMultipleSelect(false);
    banco.setWidth("150px");
    nroCuenta.setMaxLength(12);
    nroCuenta.setWidth("160px");
    cbu.setMaxLength(22);
    cbu.setWidth("160px");
    verificadorCBU.setMaxLength(22);
    verificadorCBU.setWidth("160px");
    checkPagoVoluntario.setWidth("160px");
    comercializador.setReadOnly(true);
    comercializador.setWidth("350px");
    buscarComercializador.setText("...");
    buscarComercializador.setVisible(true);
    observaciones.setVisibleLines(5);
    observaciones.setCharacterWidth(80);
    aplicar.setText("Aplicar");
    cerrar.setText("Cerrar");

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
    com.google.gwt.user.client.Element domId16Element = com.google.gwt.dom.client.Document.get().getElementById(domId16).cast();
    com.google.gwt.user.client.Element domId17Element = com.google.gwt.dom.client.Document.get().getElementById(domId17).cast();
    com.google.gwt.user.client.Element domId18Element = com.google.gwt.dom.client.Document.get().getElementById(domId18).cast();
    com.google.gwt.user.client.Element domId19Element = com.google.gwt.dom.client.Document.get().getElementById(domId19).cast();
    com.google.gwt.user.client.Element domId20Element = com.google.gwt.dom.client.Document.get().getElementById(domId20).cast();
    com.google.gwt.user.client.Element domId21Element = com.google.gwt.dom.client.Document.get().getElementById(domId21).cast();
    com.google.gwt.user.client.Element domId22Element = com.google.gwt.dom.client.Document.get().getElementById(domId22).cast();
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
    com.google.gwt.user.client.Element domId38Element = com.google.gwt.dom.client.Document.get().getElementById(domId38).cast();
    com.google.gwt.user.client.Element domId39Element = com.google.gwt.dom.client.Document.get().getElementById(domId39).cast();
    com.google.gwt.user.client.Element domId40Element = com.google.gwt.dom.client.Document.get().getElementById(domId40).cast();
    com.google.gwt.user.client.Element domId41Element = com.google.gwt.dom.client.Document.get().getElementById(domId41).cast();
    com.google.gwt.user.client.Element domId42Element = com.google.gwt.dom.client.Document.get().getElementById(domId42).cast();
    com.google.gwt.user.client.Element domId43Element = com.google.gwt.dom.client.Document.get().getElementById(domId43).cast();
    com.google.gwt.user.client.Element domId44Element = com.google.gwt.dom.client.Document.get().getElementById(domId44).cast();
    com.google.gwt.user.client.Element domId45Element = com.google.gwt.dom.client.Document.get().getElementById(domId45).cast();
    com.google.gwt.user.client.Element domId46Element = com.google.gwt.dom.client.Document.get().getElementById(domId46).cast();
    com.google.gwt.user.client.Element domId47Element = com.google.gwt.dom.client.Document.get().getElementById(domId47).cast();
    com.google.gwt.user.client.Element domId48Element = com.google.gwt.dom.client.Document.get().getElementById(domId48).cast();
    com.google.gwt.user.client.Element domId49Element = com.google.gwt.dom.client.Document.get().getElementById(domId49).cast();
    com.google.gwt.user.client.Element domId50Element = com.google.gwt.dom.client.Document.get().getElementById(domId50).cast();
    com.google.gwt.user.client.Element domId51Element = com.google.gwt.dom.client.Document.get().getElementById(domId51).cast();
    com.google.gwt.user.client.Element domId52Element = com.google.gwt.dom.client.Document.get().getElementById(domId52).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel2, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(apellido, domId10Element);
    f_HTMLPanel1.addAndReplaceElement(nombre, domId11Element);
    f_HTMLPanel1.addAndReplaceElement(fechaNacimientoDatePicker, domId12Element);
    f_HTMLPanel1.addAndReplaceElement(sexo, domId13Element);
    f_HTMLPanel1.addAndReplaceElement(tipoDoc, domId14Element);
    f_HTMLPanel1.addAndReplaceElement(dni, domId15Element);
    f_HTMLPanel1.addAndReplaceElement(cuil, domId16Element);
    f_HTMLPanel1.addAndReplaceElement(verificadorDni, domId17Element);
    f_HTMLPanel1.addAndReplaceElement(estadoCliente, domId18Element);
    f_HTMLPanel1.addAndReplaceElement(provincia, domId19Element);
    f_HTMLPanel1.addAndReplaceElement(localidad, domId20Element);
    f_HTMLPanel1.addAndReplaceElement(buscarLocalidad, domId21Element);
    f_HTMLPanel1.addAndReplaceElement(cp, domId22Element);
    f_HTMLPanel1.addAndReplaceElement(calle, domId23Element);
    f_HTMLPanel1.addAndReplaceElement(nro, domId24Element);
    f_HTMLPanel1.addAndReplaceElement(piso, domId25Element);
    f_HTMLPanel1.addAndReplaceElement(dpto, domId26Element);
    f_HTMLPanel1.addAndReplaceElement(caracteristica, domId27Element);
    f_HTMLPanel1.addAndReplaceElement(telefono, domId28Element);
    f_HTMLPanel1.addAndReplaceElement(caracteristica1, domId29Element);
    f_HTMLPanel1.addAndReplaceElement(telefono1, domId30Element);
    f_HTMLPanel1.addAndReplaceElement(reparticion, domId31Element);
    f_HTMLPanel1.addAndReplaceElement(buscarReparticion, domId32Element);
    f_HTMLPanel1.addAndReplaceElement(f_Label3, domId33Element);
    f_HTMLPanel1.addAndReplaceElement(email, domId34Element);
    f_HTMLPanel1.addAndReplaceElement(f_Label4, domId35Element);
    f_HTMLPanel1.addAndReplaceElement(tarjetaBeneficios, domId36Element);
    f_HTMLPanel1.addAndReplaceElement(f_Label5, domId37Element);
    f_HTMLPanel1.addAndReplaceElement(antecedentesJuridicos, domId38Element);
    f_HTMLPanel1.addAndReplaceElement(caracteristica2, domId39Element);
    f_HTMLPanel1.addAndReplaceElement(telefono2, domId40Element);
    f_HTMLPanel1.addAndReplaceElement(caracteristica3, domId41Element);
    f_HTMLPanel1.addAndReplaceElement(telefono3, domId42Element);
    f_HTMLPanel1.addAndReplaceElement(banco, domId43Element);
    f_HTMLPanel1.addAndReplaceElement(nroCuenta, domId44Element);
    f_HTMLPanel1.addAndReplaceElement(cbu, domId45Element);
    f_HTMLPanel1.addAndReplaceElement(verificadorCBU, domId46Element);
    f_HTMLPanel1.addAndReplaceElement(checkPagoVoluntario, domId47Element);
    f_HTMLPanel1.addAndReplaceElement(comercializador, domId48Element);
    f_HTMLPanel1.addAndReplaceElement(buscarComercializador, domId49Element);
    f_HTMLPanel1.addAndReplaceElement(observaciones, domId50Element);
    f_HTMLPanel1.addAndReplaceElement(aplicar, domId51Element);
    f_HTMLPanel1.addAndReplaceElement(cerrar, domId52Element);


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onButtonClick(event);
      }
    };
    cerrar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onGarantes(event);
      }
    };
    anchorGarantes.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onSolicitarAprobacionClick(event);
      }
    };
    aplicar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);

    final com.google.gwt.event.dom.client.KeyUpHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.KeyUpHandler() {
      public void onKeyUp(com.google.gwt.event.dom.client.KeyUpEvent event) {
        owner.onCuilChange(event);
      }
    };
    cuil.addKeyUpHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onCausaLegalClick(event);
      }
    };
    anchorLegales.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onLlamadaEnCurso(event);
      }
    };
    anchorLlamadasEnCurso.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickBuscarReparticion(event);
      }
    };
    buscarReparticion.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickBuscarLocalidad(event);
      }
    };
    buscarLocalidad.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames9 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickBuscarComercializador(event);
      }
    };
    buscarComercializador.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames9);

    owner.anchorDatosPersonales = anchorDatosPersonales;
    owner.anchorLegales = anchorLegales;
    owner.anchorLlamadasEnCurso = anchorLlamadasEnCurso;
    owner.antecedentesJuridicos = antecedentesJuridicos;
    owner.apellido = apellido;
    owner.aplicar = aplicar;
    owner.banco = banco;
    owner.buscarComercializador = buscarComercializador;
    owner.calle = calle;
    owner.caracteristica = caracteristica;
    owner.caracteristica1 = caracteristica1;
    owner.caracteristica2 = caracteristica2;
    owner.caracteristica3 = caracteristica3;
    owner.cbu = cbu;
    owner.checkPagoVoluntario = checkPagoVoluntario;
    owner.clienteDiv = clienteDiv;
    owner.comercializador = comercializador;
    owner.cp = cp;
    owner.cuil = cuil;
    owner.dni = dni;
    owner.dpto = dpto;
    owner.email = email;
    owner.estadoCliente = estadoCliente;
    owner.localidad = localidad;
    owner.nombre = nombre;
    owner.nro = nro;
    owner.nroCuenta = nroCuenta;
    owner.observaciones = observaciones;
    owner.piso = piso;
    owner.provincia = provincia;
    owner.reparticion = reparticion;
    owner.sexo = sexo;
    owner.tarjetaBeneficios = tarjetaBeneficios;
    owner.telefono = telefono;
    owner.telefono1 = telefono1;
    owner.telefono2 = telefono2;
    owner.telefono3 = telefono3;
    owner.tipoDoc = tipoDoc;
    owner.verificadorCBU = verificadorCBU;
    owner.verificadorDni = verificadorDni;

    return f_HTMLPanel1;
  }
}
