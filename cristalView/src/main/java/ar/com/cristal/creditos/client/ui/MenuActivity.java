/*
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ar.com.cristal.creditos.client.ui;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO;
import ar.com.cristal.creditos.client.event.SelectedItemEvent;
import ar.com.cristal.creditos.client.handler.SelectedItemEventHandler;
import ar.com.cristal.creditos.client.ui.establecimientos.SeleccionEstablecimientoActivity;
import ar.com.cristal.creditos.client.ui.establecimientos.SeleccionEstablecimientoPlace;
import ar.com.cristal.creditos.client.ui.util.ClientContext;
import ar.com.cristal.creditos.client.ui.util.ConstantesView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Activities are started and stopped by an ActivityManager associated with a container Widget.
 */
public class MenuActivity extends AbstractActivity implements MenuView.Presenter {

	/**
	 * Sample property.
	 */
	private String name;
	private ClientFactory clientFactory;
	private MenuView view;
	private HandlerRegistration handler;
	

	public MenuActivity(MenuPlace place, ClientFactory cf) {
		this.name = place.getName();
		clientFactory = cf;
	}

	public void start(final AcceptsOneWidget containerWidget, EventBus eventBus) {
		view = clientFactory.getMenuView();
		view.setPresenter(this);
		view.setName(name);

		
		clientFactory.getUsuarioService().obtenerUsuarioLogueado(new AsyncCallback<UsuarioLogueadoDTO>() {
			
			public void onSuccess(UsuarioLogueadoDTO usuarioLogueado) {

				
				view.anchorUsuarioLogueado.setText(usuarioLogueado.getNombreUsuario());
				if (usuarioLogueado.getEstablecimientoActual() != null)
					view.anchorEstablecimientoActual.setText(" - " + usuarioLogueado.getEstablecimientoActual().getNombre());
				else
					view.anchorEstablecimientoActual.setText("SIN ESTABLECIMIENTO!");
				
				view.setVisible(true);
				containerWidget.setWidget(view.asWidget());
				
			}
			
			public void onFailure(Throwable t) {
				clientFactory.getPopUp().mostrarMensaje(ConstantesView.USUARIO_NO_VALIDO);
				
			}
		});
	}

	@Override
	public String mayStop() {
		//return "Please hold on. This activity is stopping.";
		return null;
	}

	/**
	 * @see MenuView.Presenter#goTo(Place)
	 */
	public void goTo(Place place) {
		// TODO
		System.out.println("gotoplace: " + place.toString());
		
		clientFactory.getPlaceController().goTo(place);
	}

	@Override
	public void mostarSeelccionEstablecimiento() {
		SeleccionEstablecimientoPlace newPlace = new SeleccionEstablecimientoPlace("");

		handler = clientFactory.getEventBus()
				.addHandler(SelectedItemEvent.TYPE, new SelectedItemEventHandler() {
					@Override
					public void onSelectItem(SelectedItemEvent event) {
						handler.removeHandler();
						if (event.getListBoxItem() != null){
							view.anchorEstablecimientoActual.setText(" - " + ClientContext.getInstance().getUsuarioLogueadoDTO().getEstablecimientoActual().getNombre());
						}
							
					}
				 });
		
		
		SeleccionEstablecimientoActivity newAct=new SeleccionEstablecimientoActivity(newPlace, clientFactory);
		newAct.startInPopUp();		
	}

}
