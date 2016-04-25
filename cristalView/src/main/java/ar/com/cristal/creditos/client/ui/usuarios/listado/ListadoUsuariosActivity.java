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
package ar.com.cristal.creditos.client.ui.usuarios.listado;

import java.util.List;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.ui.usuarios.abm.AltaEdicionUsuarioPlace;
import ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO;
import ar.com.cristal.creditos.client.ui.util.ClientContext;
import ar.com.cristal.creditos.client.ui.util.CustomAbstractActivity;
import ar.com.cristal.creditos.client.ui.util.PopUpInfo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FlexTable;

/**
 * Activities are started and stopped by an ActivityManager associated with a container Widget.
 */
public class ListadoUsuariosActivity extends CustomAbstractActivity implements ListadoUsuariosView.Presenter {

	/**
	 * Sample property.
	 */
	private String name;
	private PopUpInfo popup = null;
	private ClientFactory clientFactory;
	private ClientContext clientContext = ClientContext.getInstance();
	private ListadoUsuariosView view;
	private static final String ID_COMPONENTE_ACTIVITY = "LISTADO_USUARIOS";

	public ListadoUsuariosActivity(ListadoUsuariosPlace place, ClientFactory cf) {
		this.name = place.getName();		
		clientFactory = cf;
		popup = clientFactory.getPopUp();
	}

	
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		view = clientFactory.getListadoUsuariosView();
		super.start(containerWidget, eventBus, ID_COMPONENTE_ACTIVITY);
		view.setPresenter(this);			
		containerWidget.setWidget(view.asWidget());
		
		
	}

	@Override
	public String mayStop() {
		return null;
	}

	/**
	 * @see ListadoUsuariosView.Presenter#goTo(Place)
	 */
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}

	
	
	/***
	 * Carga inicial de la tabla de peticiones a ser aprobadas
	 */
	public void inicializarTabla(final FlexTable tabla){
		
		
		clientFactory.getUsuarioService().obtenerUsarios(new AsyncCallback<List<UsuarioDTO>>() {
			
			
			public void onSuccess(List<UsuarioDTO> usuarios) {
				
				for (int i = 0; i<usuarios.size(); i++){
					tabla.setText(i+1, 0, usuarios.get(i).getId() + "");
					tabla.setText(i+1, 1, usuarios.get(i).getApellido());
					tabla.setText(i+1, 2, usuarios.get(i).getNombre());
					tabla.setText(i+1, 3, usuarios.get(i).getNombreUsuario());
					tabla.setText(i+1, 4, "" + usuarios.get(i).getPerfil().getNombre());
					tabla.setText(i+1, 5, "SUCURSAL NO VA MAS");
					
					if (usuarios.get(i).isSupervisor())
						tabla.setText(i+1, 6, "SI");
					else
						tabla.setText(i+1, 6, "NO");
					
//					if (usuarios.get(i).isAdmin())
//						tabla.setText(i+1, 7, "SI");
//					else
//						tabla.setText(i+1, 7, "NO");
//					
					
					if (i % 2 == 0) {
						tabla.getRowFormatter().addStyleName(i+1, "TableRow1Pointer");
					} else {				
						tabla.getRowFormatter().addStyleName(i+1, "TableRow2Pointer");
					}
				}
				
			}
			
			public void onFailure(Throwable arg) {
				popup.mostrarMensaje("Error: ", arg.getMessage());
				
			}
		});
		
		
		
		
		

	}


	public void onTableClick(String id) {
		AltaEdicionUsuarioPlace p = clientFactory.getAltaEdicionUsuarioPlace(id);
		
		goTo(p);
	}


	@Override
	public void inicializarActivity() {
		
		view.setName(name);		
		view.initTable();
		
	}
	
}
