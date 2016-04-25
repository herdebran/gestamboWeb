package ar.com.cristal.creditos.client.ui.usuarios.abm;

import java.util.ArrayList;
import java.util.List;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.accesibilidad.PerfilesDto;
import ar.com.cristal.creditos.client.dto.SucursalDTO;
import ar.com.cristal.creditos.client.ui.home.HomePlace;
import ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO;
import ar.com.cristal.creditos.client.ui.usuarios.listado.ListadoUsuariosPlace;
import ar.com.cristal.creditos.client.ui.util.ClientContext;
import ar.com.cristal.creditos.client.ui.util.CustomAbstractActivity;
import ar.com.cristal.creditos.client.ui.util.InicializarCombos;
import ar.com.cristal.creditos.client.ui.util.MD5;
import ar.com.cristal.creditos.client.ui.util.PopUpInfo;
import ar.com.cristal.creditos.client.widget.CustomSiNoDialogBox;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DialogBox;

/***
 * Maneja todo lo relacionada a la generación de solicitudes de aprobación de
 * crédito y a la aprobación de los mismos Puede ser accedida en modo consulta o
 * en modo edición de acuerdo al estado de la solicitud Según los permisos del
 * usuario se pueden acceder a ciertos controles que un usuario vendedor no
 * puede: ---Aprobar ---Rechazar ---Detalle de Aprobación Rechazo: según los
 * permisos el usuario podrá editar o no ese campo
 * 
 * 
 * @author daniel.madera
 * 
 */
public class AltaEdicionUsuarioActivity extends CustomAbstractActivity implements
		AltaEdicionUsuarioView.Presenter {


	private static final String ID_COMPONENTE_ACTIVITY = "ALTA_EDICION_USUARIO";

	private String token;
	
	private boolean passwordModificado = false;
	

	private ClientFactory clientFactory;
	private ClientContext clientContext = ClientContext.getInstance();

	private PopUpInfo popup = null;

	private final AltaEdicionUsuarioView view;

	private UsuarioDTO usuarioActual = null;

	public AltaEdicionUsuarioActivity(AltaEdicionUsuarioPlace place,
			ClientFactory cf) {
		clientFactory = cf;
		view = clientFactory.getAltaEdicionUsuarioView();
		popup = clientFactory.getPopUp();
		this.token = place.getToken();

	}

	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		super.start(containerWidget, eventBus, ID_COMPONENTE_ACTIVITY);
		
	
			
			passwordModificado = false;
			view.setPresenter(this);
			view.limpiarControles();

			

			containerWidget.setWidget(view.asWidget());


	}

	/***
	 * En caso que se tenga el id se puede obtener el usuario Este caso se da
	 * cuando se accede a este módulo a partir de una previa selección del
	 * usuario
	 */
	private void obtenerUsuario(String id) {
		
		Long idUsuario = new Long(id);
		
		clientFactory.getUsuarioService().obtenerUsario(idUsuario,
				new AsyncCallback<UsuarioDTO>() {

					public void onFailure(Throwable arg0) {
						popup.mostrarMensaje(
								"Error: ",
								"Error Activity_obtenerUsuario(): "
										+ arg0.getMessage());

					}

					public void onSuccess(UsuarioDTO usuario) {
						usuarioActual = usuario;
						cargarDatosUsuario(usuarioActual);
						
						//Inicializo la bandera de modificación de password
						passwordModificado = false;

					}

				});

	}

	private void cargarDatosUsuario(UsuarioDTO usuarioActual) {
		try {
			view.apellido.setText(usuarioActual.getApellido());
			view.nombre.setText(usuarioActual.getNombre());
			view.nombreUsuario.setText(usuarioActual.getNombreUsuario());
			view.administrador.setValue(usuarioActual.isAdmin());
			view.supervisor.setValue(usuarioActual.isSupervisor());
			view.password.setText(usuarioActual.getPassword().substring(0,7));
			view.confirmacionPassword.setText(usuarioActual.getPassword().substring(0,7));
			view.perfiles.selectByText(usuarioActual.getPerfil().getItemText());


		} catch (Exception e) {
			popup.mostrarMensaje("Error: ",
					"Error cargarDatosUsuario(): " + e.getMessage());
		}

	}

	@Override
	public String mayStop() {
		return null;
	}

	/**
	 * @see AltaEdicionUsuarioView.Presenter#goTo(Place)
	 */
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}

	private void inicializarCombos(String perfil, String sucursal) {
		try {

			InicializarCombos.inicializarComboPerfiles(clientFactory, view.perfiles, perfil);
			
			
		} catch (Exception e) {
			popup.mostrarMensaje("Error",
					"inicializarCombos(): " + e.getMessage());
		}

	}

	

	/***
	 * Genera el dto de usuario
	 * 
	 * @return
	 */
	private UsuarioDTO generarUsuarioDTO() {
		UsuarioDTO result = new UsuarioDTO();

		if (usuarioActual != null && usuarioActual.getId() != null
				&& usuarioActual.getId() > 0) {
			result.setId(usuarioActual.getId());
		}
		
		result.setApellido(view.apellido.getText());
		result.setNombre(view.nombre.getText());
		
		
		//Si el usuario se está actualizando y no quiso modificar la contraseña
		//se utiliza la que ya tiene el usuario actual
		if (passwordModificado){
			String pass = MD5.md5(view.password.getText());
			result.setPassword(pass);
		}
		else {
			result.setPassword(usuarioActual.getPassword());
			
		}
	
		result.setPerfil((PerfilesDto)view.perfiles.getSelectedItem());
		
		result.setSupervisor(view.supervisor.getValue());
		result.setNombreUsuario(view.nombreUsuario.getValue());
		
		result.setAdmin(view.administrador.getValue());
		
		return result;
	}

	/***
	 * Devuelve false si el conenido no es correcto. Por ejemplo, cuando la
	 * extracción es mayor al sueldo.
	 * 
	 * @param mensajeError
	 * @return
	 */
	private boolean validacionDeContenido(List<String> mensajeError) {
		boolean result = true;
		//TODO: Terminar de validar
		try {

			if (!view.confirmacionPassword.getText().equals(view.password.getText())){
				result = false;
				mensajeError.add("La contraseña y confirmación no coincide.");
			}
		} catch (Exception ex) {
			result = false;
			mensajeError.add("Error en los datos ingresados");
		}

		return result;
	}

	

	/***
	 * Valida los datos para la emisión de una solicitud de aprobación de
	 * crédito
	 * 
	 * @param mensajeError
	 * @return
	 * @throws Exception
	 */
	private boolean datosValidos(List<String> mensajeError) throws Exception {
		boolean result = true;
		try {

			mensajeError.clear();

			
			// valida apellido 
			if (view.apellido.getText().length() == 0) {
				result = false;
				mensajeError.add("El apellido es obligatorio.");

			}

			// valida nombre
			if (view.nombre.getText().length() == 0) {
				result = false;
				mensajeError.add("El nombre es obligatorio.");

			}
			
			
			// valida nombre
			if (view.nombreUsuario.getText().length() == 0) {
				result = false;
				mensajeError.add("El nombre de usuario es obligatorio.");
	
			}
			

			// valida contraseña
			if (view.password.getText().length() == 0) {
				result = false;
				mensajeError.add("La contraseña es obligatoria.");
	
			}
						
						
			// valida confirmación contraseña
			if (view.confirmacionPassword.getText().length() == 0) {
				result = false;
				mensajeError.add("La confirmación de contraseña es obligatoria.");
	
			}
					

			
			// valida surucsal
			if (view.sucursales.getSelectedIndex() < 0) {
				result = false;
				mensajeError.add("Debe seleccionar una sucursal.");
	
			}

			// valida perfil
			if (view.perfiles.getSelectedIndex() < 0) {
				result = false;
				mensajeError.add("Debe seleccionar un perfil de usuario.");
	
			}			
						
						

			// Se valida el contenido solo si los datos ingresados son correctos
			if (result == true)
				result = validacionDeContenido(mensajeError);
			


		} catch (Exception e) {

			throw new Exception("datosValidos(): " + e.getMessage(), e);
		}

		return result;
	}

	public void onCerrar() {
		token = "";
		Place newPlace = new HomePlace("Home");
		goTo(newPlace);

	}

	public void onPersistirUsuario() {

		List<String> mensajeError = new ArrayList<String>();
		try {
			
			boolean ok = datosValidos(mensajeError);

			if (ok) {
				
				
				usuarioActual = generarUsuarioDTO();
				
				clientFactory.getUsuarioService().validarNombreUsuario(usuarioActual, new AsyncCallback<Boolean>() {

					public void onFailure(Throwable e) {
						popup.mostrarMensaje("Error", e.getMessage());
						
					}

					public void onSuccess(Boolean datosValidos) {
						if (!datosValidos){
							popup.mostrarMensaje("Datos no válidos", "El nombre de usuario es existente.");
						} else 
						{
							
						
				
							view.guardar.setEnabled(false);
							clientFactory.getUsuarioService().persistirUsuario(
									usuarioActual, new AsyncCallback<UsuarioDTO>() {
			
										public void onFailure(Throwable arg0) {
											popup.mostrarMensaje("Error", arg0.getMessage());
											view.guardar.setEnabled(true);
			
										}
			
										public void onSuccess(UsuarioDTO usuario) {
											view.guardar.setEnabled(true);
											usuarioActual = usuario;
											popup.mostrarMensaje("Datos Guardados", "Se han actualizado los datos correctamente");
											onCancelar();
											
										}
			
									});
				
						} ///else
						
					}//success
				});//validarNombreUsuario
				
			} else {
				popup.mostrarMensaje("Datos no válidos", mensajeError);
				
			}

		} catch (Exception e) {
			popup.mostrarMensaje("Error:", "onPersistirUsuario(): " + e.getMessage());
		}

	}

	public void onCancelar() {
		Place p = new ListadoUsuariosPlace("");
		this.goTo(p);

	}

	public void onPasswordModificado() {
		passwordModificado = true;
	}

	public void onBorrar() {
		
		
		dialogBox();
		

		
	}

	
	private void eliminarUsuario() {
		if (clientContext.getUsuarioLogueadoDTO().isAdmin()){
		clientFactory.getUsuarioService().borrarUsuario(usuarioActual.getId(), new AsyncCallback<Void>() {

			public void onFailure(Throwable arg0) {
				
				popup.mostrarMensaje("Error", arg0.getMessage());
			}

			public void onSuccess(Void arg0) {
				
				popup.mostrarMensaje("Usuario Eliminado", "Se ha eliminado con éxito el usuario.");
				
				onCancelar();
			}
		});
	} else {
		popup.mostrarMensaje("Permisos insuficientes", "Sólo los administradores pueden eliminar usuarios.");
	}
	}
	
	private void dialogBox() {
		
		final DialogBox dialogbox = CustomSiNoDialogBox.dialogBox("Advertencia!", "Está seguro que desea borrar?");
		
		 ClickHandler listenerNo = new ClickHandler() {
				
				public void onClick(ClickEvent arg0) {
					dialogbox.hide();
					
				}
			};
			
			ClickHandler listenerSi = new ClickHandler() {
				
				public void onClick(ClickEvent arg0) {
					dialogbox.hide();
					eliminarUsuario();
					
					
				}
			};
		
			CustomSiNoDialogBox.setHandlers(listenerSi, listenerNo);
		
	}

	@Override
	public void inicializarActivity() {
		
		view.guardar.setEnabled(true);
		

		usuarioActual = null;

		if (token != null && !token.isEmpty()) {

			obtenerUsuario(token);
			view.nombreUsuario.setEnabled(false);

		} else {
			// /Caso de creación de usuario
			view.nombreUsuario.setEnabled(true);
			inicializarCombos("","");

		}
		
	}

}
