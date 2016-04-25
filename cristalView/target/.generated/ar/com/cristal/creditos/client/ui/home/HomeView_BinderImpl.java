package ar.com.cristal.creditos.client.ui.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class HomeView_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, ar.com.cristal.creditos.client.ui.home.HomeView>, ar.com.cristal.creditos.client.ui.home.HomeView.Binder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final ar.com.cristal.creditos.client.ui.home.HomeView owner) {

    ar.com.cristal.creditos.client.ui.home.HomeView_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (ar.com.cristal.creditos.client.ui.home.HomeView_BinderImpl_GenBundle) GWT.create(ar.com.cristal.creditos.client.ui.home.HomeView_BinderImpl_GenBundle.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label usuarioLogueado = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel("<div class='gwt-TitledPanel' style='width:250px;'> <div class='title'>Bienvenido</div> <span id='" + domId0 + "'></span>  </div>");

    usuarioLogueado.setWidth("150px");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(usuarioLogueado, domId0Element);


    owner.usuarioLogueado = usuarioLogueado;

    return f_HTMLPanel1;
  }
}
