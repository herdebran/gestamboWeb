package ar.com.cristal.creditos.client.ui.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.ClientFactoryImpl;
import ar.com.cristal.creditos.client.LocalidadFactory;
import ar.com.cristal.creditos.client.LocalidadFactoryImpl;
import ar.com.cristal.creditos.client.accesibilidad.PerfilesDto;
import ar.com.cristal.creditos.client.dto.EmpresaDTO;
import ar.com.cristal.creditos.client.dto.EstablecimientoDTO;
import ar.com.cristal.creditos.client.dto.ItemGastoSucursalDTO;
import ar.com.cristal.creditos.client.dto.MedioContactoDTO;
import ar.com.cristal.creditos.client.dto.TipoReporteDTO;
import ar.com.cristal.creditos.client.localidad.LocalidadDTO;
import ar.com.cristal.creditos.client.tambo.dto.EstadoProductivoEnumDTO;
import ar.com.cristal.creditos.client.tambo.dto.EstadoReproductivoEnumDTO;
import ar.com.cristal.creditos.client.tambo.dto.EstadoSanitarioEnumDTO;
import ar.com.cristal.creditos.client.tambo.dto.RazaDTO;
import ar.com.cristal.creditos.client.tambo.dto.ResultadoTactoDTO;
import ar.com.cristal.creditos.client.tambo.dto.RodeoDTO;
import ar.com.cristal.creditos.client.tambo.dto.TipoRodeoEnumDTO;
import ar.com.cristal.creditos.client.tambo.dto.ToroDTO;
import ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;
import ar.com.snoop.gwt.commons.client.widget.ListBox;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.rpc.AsyncCallback;
/**
 * Clase que centralizar la inicialización y carga de DTOs en los combos.
 * 
 * @author Martín Mantovani
 */
public class InicializarCombos {

	
	final static ClientFactory cf = ClientFactoryImpl.getClientFactoryImpl();
	private final static PopUpInfo popup = cf.getPopUp();
	private static List<UsuarioDTO> todosLosUsuariosDTO = null;
	private static List<UsuarioDTO> usuariosComercializadoresDTO = null;
	private static List<EmpresaDTO> empresas = null;
	private static List<String> estadosDelCliente = null;
	private static List<ItemGastoSucursalDTO> conceptosGastosCaja = null;
	
	static public void inicializarComboEmpresa(final String nombre,final ListBox listBox, final ClientFactory cf){
		final long tiempoCarga = new Date().getTime();
		listBox.clear();
		cf.getComunesService().obtenerEmpresas(new AsyncCallback<List<EmpresaDTO>>() {
			
			public void onFailure(Throwable caught) {
				cf.getPopUp().mostrarMensaje("Error", caught.getMessage());
			}

			public void onSuccess(List<EmpresaDTO> result) {
				
				for (EmpresaDTO obj : result) {
					listBox.addItem(obj);
				}
				
				if (nombre != null && !nombre.isEmpty())
					listBox.selectByText("nombre");
				
				Log.debug("inicializarComboEmpresa Tiempo carga ms: " + (new Date().getTime() - tiempoCarga));
			}

		});
	}
	
	
	static public void inicializarComboEmpresaDefault(final String nombre,final ListBox listBox){
		final long tiempoCarga = new Date().getTime();
		Log.debug("inicializarComboEmpresaDefault");
		
		if (empresas == null) {
			cf.getComunesService().obtenerEmpresas(new AsyncCallback<List<EmpresaDTO>>() {
			
				public void onFailure(Throwable caught) {
					cf.getPopUp().mostrarMensaje("Error", caught.getMessage());
				}
		
				public void onSuccess(List<EmpresaDTO> result) {
					empresas = result;
					Log.debug("inicializarComboEmpresaDefault Tiempo de respuesta ms: " + (new Date().getTime() - tiempoCarga));
					long tiempoCarga = new Date().getTime();
					listBox.clear();
					EmpresaDTO empresa = new EmpresaDTO();
					empresa.setId("-1");
					empresa.setNombre("");
					result.add(0, empresa);
					
					listBox.addAllItems(result);
					
					if (nombre != null && !nombre.isEmpty())
						listBox.selectByText(nombre);
					else 
						listBox.selectByText("");
					
					Log.debug("inicializarComboEmpresaDefault Tiempo carga ms: " + (new Date().getTime() - tiempoCarga));
				}
		
			});
		} else {
			listBox.clear();
			List<EmpresaDTO> result = new ArrayList<EmpresaDTO>();			
			result.addAll(empresas);
			
			listBox.addAllItems(result);
			
			
			if (nombre != null && !nombre.isEmpty())
				listBox.selectByText(nombre);
			else 
				listBox.selectByText("");
		}
}
	
	
	/**
	 * inicializa el listbox con el tipo indicado en el parametro tipo
	 * que tomara de la tabla Tablas
	 * @param tipo
	 * @param clientFactory
	 * @param listBox
	 */
	
	static public void inicializarComboTipos(final String tipo, final ClientFactory clientFactory, final ListBox listBox) {
		final long tiempoCarga = new Date().getTime();
		listBox.clear();
		clientFactory.getComunesService().obtenerListadoGenerico(tipo, new AsyncCallback<List<ListBoxItem>>() {

			public void onFailure(Throwable caught) {
				PopUpInfo popup = clientFactory.getPopUp();
				popup.mostrarMensaje("Error", "inicializarComboXTipos() " + caught.getMessage());	
			}
			public void onSuccess(List<ListBoxItem> result) {
				listBox.addAllItems(result);
				Log.debug("inicializarComboTipos Tiempo carga ms: " + (new Date().getTime() - tiempoCarga));
			}
		});
		
			
	}
	
	
	/**
	 * inicializa el listbox con el tipo indicado en el parametro tipo
	 * que tomara de la tabla Tablas
	 * @param tipo
	 * @param clientFactory
	 * @param listBox
	 */
	
	static public void inicializarComboTipos(final String tipo, final ClientFactory clientFactory, final ListBox listBox, final String valorPorDefecto) {
		final long tiempoCarga = new Date().getTime();
		listBox.clear();
		clientFactory.getComunesService().obtenerListadoGenerico(tipo, new AsyncCallback<List<ListBoxItem>>() {

			public void onFailure(Throwable caught) {
				PopUpInfo popup = clientFactory.getPopUp();
				popup.mostrarMensaje("Error", "inicializarComboXTipos() " + caught.getMessage());	
			}
			public void onSuccess(List<ListBoxItem> result) {
				listBox.addAllItems(result);

				if (valorPorDefecto!= null) listBox.selectByText(valorPorDefecto);
				
				Log.debug("inicializarComboTipos Tiempo carga ms: " + (new Date().getTime() - tiempoCarga));
			}
			
		});
		
			
	}
	
	
	static public void inicializarComboSeguimientoManual(final ClientFactory clientFactory, final ListBox listBox, final String valorPorDefecto) {
		final long tiempoCarga = new Date().getTime();
		listBox.clear();
		clientFactory.getComunesService().obtenerListadoSeguimientoManual(new AsyncCallback<List<ListBoxItem>>() {

			public void onFailure(Throwable caught) {
				PopUpInfo popup = clientFactory.getPopUp();
				popup.mostrarMensaje("Error", "inicializarComboXTipos() " + caught.getMessage());	
			}
			public void onSuccess(List<ListBoxItem> result) {
				listBox.addAllItems(result);

				if (valorPorDefecto!= null) listBox.selectByText(valorPorDefecto);
				
				Log.debug("inicializarComboTipos Tiempo carga ms: " + (new Date().getTime() - tiempoCarga));
			}
			
		});
		
			
	}


	
	
	/**
	 * inicializa el listbox con el tipo indicado en el parametro tipo
	 * que tomara de la tabla Tablas
	 * @param tipo
	 * @param clientFactory
	 * @param listBox
	 */
	
	static public void inicializarCallCenter(final String tipo, final ClientFactory clientFactory, final ListBox listBox, final String valorPorDefecto) {
		final long tiempoCarga = new Date().getTime();
		listBox.clear();
		cf.getComunesService().obtenerListadoGenerico(ConstantesView.CALLCENTER_ATENCION_LLAMADA_TODAS, new AsyncCallback<List<ListBoxItem>>() {

			public void onFailure(Throwable caught) {
				PopUpInfo popup = cf.getPopUp();
				popup.mostrarMensaje("Error", "inicializarComboXTipos() " + caught.getMessage());	
			}
			public void onSuccess(List<ListBoxItem> result) {
				listBox.addAllItems(result);
				clientFactory.getComunesService().obtenerListadoGenerico(tipo, new AsyncCallback<List<ListBoxItem>>() {

					public void onFailure(Throwable caught) {
						PopUpInfo popup = clientFactory.getPopUp();
						popup.mostrarMensaje("Error", "inicializarComboXTipos() " + caught.getMessage());	
					}
					public void onSuccess(List<ListBoxItem> result) {
						
						listBox.addAllItems(result);

						if (valorPorDefecto!= null) listBox.selectByText(valorPorDefecto);
						
						Log.debug("inicializarComboCallcenterTiempo carga ms: " + (new Date().getTime() - tiempoCarga));
					}
					
				});
			}
			
		});
	}
	
	/***
	 * 
	 * @param departamentoAtencion: MORA_TARDIA_ATENCION_LLAMADA_ o CALLCENTER_ATENCION_LLAMADA
	 * @param tipo: tipo Llamado	 
	 * @param listBox
	 * @param valorPorDefecto
	 */
	static public void inicializarComboListadoRespuestas(final String departamentoAtencion, final String tipo, final ListBox listBox, final String valorPorDefecto) {
		final long tiempoCarga = new Date().getTime();
		listBox.clear();
		cf.getComunesService().obtenerListadoGenerico(departamentoAtencion + "TODAS", new AsyncCallback<List<ListBoxItem>>() {

			public void onFailure(Throwable caught) {
				PopUpInfo popup = cf.getPopUp();
				popup.mostrarMensaje("Error", "inicializarComboXTipos() " + caught.getMessage());	
			}
			public void onSuccess(List<ListBoxItem> result) {
				listBox.addAllItems(result);
				cf.getComunesService().obtenerListadoGenerico(tipo, new AsyncCallback<List<ListBoxItem>>() {

					public void onFailure(Throwable caught) {
						PopUpInfo popup = cf.getPopUp();
						popup.mostrarMensaje("Error", "inicializarComboXTipos() " + caught.getMessage());	
					}
					public void onSuccess(List<ListBoxItem> result) {
						
						listBox.addAllItems(result);

						if (valorPorDefecto!= null) listBox.selectByText(valorPorDefecto);
						
						Log.debug("inicializarComboCallcenterTiempo carga ms: " + (new Date().getTime() - tiempoCarga));
					}
					
				});
			}
			
		});
	}
	

	static public void inicializarComboMasculinoFemenino(final ListBox listBox, String seleccionar) {
		listBox.clear();
		listBox.addItem("", "");
		listBox.addItem(ConstantesView.MASCULINO, ConstantesView.MASCULINO);
		listBox.addItem(ConstantesView.FEMENINO, ConstantesView.FEMENINO);	
		if (seleccionar != null)
			listBox.selectByText(seleccionar);
		 else
			 listBox.selectByText(ConstantesView.MASCULINO);
		
	}
		



		static public void inicializarComboLocalidades(final String nombre,final ListBox listBox){
			final long tiempoCarga = new Date().getTime();
			listBox.clear();
			LocalidadFactory localidadFactory = LocalidadFactoryImpl.getClientFactoryImpl();
			localidadFactory.getLocalidadService().obtenerLocalidades(new AsyncCallback<List<LocalidadDTO>>() {

				public void onFailure(Throwable e) {
					popup.mostrarMensaje("Error", "Error al obtener localidades " + e.getMessage());
					
				}

				public void onSuccess(List<LocalidadDTO> localidades) {
					LocalidadDTO loc = new LocalidadDTO();
					loc.setId(-1L);
					loc.setNombre("Todas");
					listBox.addItem(loc);
					for (LocalidadDTO localidadDTO : localidades) {
						listBox.addItem(localidadDTO);
					}
					if (listBox!= null) listBox.selectByText(nombre);
					
					Log.debug("inicializarComboLocalidades Tiempo carga ms: " + (new Date().getTime() - tiempoCarga));
				}

			});
		}


		
		static public void inicializarComboLocalidadesDefault(final String nombre,final ListBox listBox){
			final long tiempoCarga = new Date().getTime();
			listBox.clear();
			LocalidadFactory localidadFactory = LocalidadFactoryImpl.getClientFactoryImpl();
			localidadFactory.getLocalidadService().obtenerLocalidades(new AsyncCallback<List<LocalidadDTO>>() {

				public void onFailure(Throwable e) {
					popup.mostrarMensaje("Error", "Error al obtener localidades: " + e.getMessage());
					
				}

				public void onSuccess(List<LocalidadDTO> localidades) {
					LocalidadDTO loc = new LocalidadDTO();
					loc.setId(-1L);
					loc.setNombre("");
					listBox.addItem(loc);
					for (LocalidadDTO localidadDTO : localidades) {
						listBox.addItem(localidadDTO);
					}
					if (nombre!= null) 
						listBox.selectByText(nombre);
					else 
						listBox.selectByText("");
					
					Log.debug("inicializarComboLocalidades Tiempo carga ms: " + (new Date().getTime() - tiempoCarga));
				}

			});
		}
		
		

static public void inicializarComboOperadores(final ClientFactory clientFactory, final String nombre,final ListBox listBox){
	final long tiempoCarga = new Date().getTime();
	listBox.clear();
	clientFactory.getUsuarioService().obtenerListadoOperadoresCallCenter(new AsyncCallback<List<UsuarioDTO>>() {

		public void onFailure(Throwable c) {
			PopUpInfo popup = clientFactory.getPopUp();
			popup.mostrarMensaje("Error", "inicializarCombos() " +c.getMessage());
		}

		public void onSuccess(List<UsuarioDTO> result) {
			
			UsuarioDTO usuarioVacio = new UsuarioDTO();
			usuarioVacio.setId(-1L);
			result.add(0, usuarioVacio);
			
			
			for (UsuarioDTO u : result) {
				listBox.addItem(u);
			}
			
			if (result != null) listBox.selectByText(nombre);
			
			Log.debug("inicializarComboOperadores Tiempo carga ms: " + (new Date().getTime() - tiempoCarga));
		}
	});
}


static public void inicializarComboOperadoresMoraTardia(final ClientFactory clientFactory, final String nombre,final ListBox listBox){
	final long tiempoCarga = new Date().getTime();
	listBox.clear();
	clientFactory.getUsuarioService().obtenerListadoOperadoresMoraTardia(new AsyncCallback<List<UsuarioDTO>>() {

		public void onFailure(Throwable c) {
			PopUpInfo popup = clientFactory.getPopUp();
			popup.mostrarMensaje("Error", "inicializarCombos() " +c.getMessage());
		}

		public void onSuccess(List<UsuarioDTO> result) {
			
			UsuarioDTO usuarioVacio = new UsuarioDTO();
			usuarioVacio.setId(-1L);
			result.add(0, usuarioVacio);
			
			
			for (UsuarioDTO u : result) {
				listBox.addItem(u);
			}
			
			if (result != null) listBox.selectByText(nombre);
			
			Log.debug("inicializarComboOperadores Tiempo carga ms: " + (new Date().getTime() - tiempoCarga));
		}
	});
}


	static public void inicializarComboPerfiles(final ClientFactory clientFactory, final ListBox listBox, final String valorPorDefecto) {
		final long tiempoCarga = new Date().getTime();
		clientFactory.getUsuarioService().obtenerPerfiles(new AsyncCallback<List<PerfilesDto>>() {

			public void onSuccess(List<PerfilesDto> result) {
				listBox.clear();
				PerfilesDto p = new PerfilesDto();
				p.setId(-1L);
				p.setNombre("");
				result.add(p);
				for (PerfilesDto obj : result) {
					listBox.addItem(obj);
				}
				
				if (valorPorDefecto!= null)
					listBox.selectByText(valorPorDefecto);
				else
					listBox.selectByText("");
				
				
				Log.debug("inicializarComboPerfiles Tiempo carga ms: " + (new Date().getTime() - tiempoCarga));
				
			}

			public void onFailure(Throwable arg0) {
				PopUpInfo popup = clientFactory.getPopUp();
				popup.mostrarMensaje("Error", "inicializarCombos() " + arg0.getMessage());

			}
		});
		
	}
	
	public static void inicializarComboUsuarios(final String nombre, final ListBox listBox) {
		final long tiempoCarga = new Date().getTime();
		cf.getUsuarioService().obtenerUsarios(new AsyncCallback<List<UsuarioDTO>>(){
			public void onSuccess(List<UsuarioDTO> usuarios) {
				listBox.clear();
				UsuarioDTO u = new UsuarioDTO();
				u.setId(-1L);
				u.setNombre("");
				listBox.addItem(u);
				
				for (UsuarioDTO localidadDTO : usuarios) {
					listBox.addItem(localidadDTO);
				}
			
				if (nombre!= null) 
					listBox.selectByText(nombre);
				else 
					listBox.selectByText("");
				
				
				Log.debug("inicializarComboUsuarios Tiempo carga ms: " + (new Date().getTime() - tiempoCarga));
			}

			
			public void onFailure(Throwable arg0) {
				PopUpInfo popup = cf.getPopUp();
				popup.mostrarMensaje("Error", "inicializarCombos() " + arg0.getMessage());
				
			}

			

		});
	}
	
	
	
	public static void inicializarComboUsuariosPorNombreUsuario(final String nombreUsuario, final ListBox listBox) {
		
		if (nombreUsuario != null){
			cf.getUsuarioService().obtenerUsuarioPorNombreUsuario(nombreUsuario, new AsyncCallback<UsuarioDTO>() {
	
				@Override
				public void onFailure(Throwable arg0) {
					PopUpInfo popup = cf.getPopUp();
					popup.mostrarMensaje("Error", "inicializarCombos() " + arg0.getMessage());
					
				}
	
				@Override
				public void onSuccess(UsuarioDTO usuario) {
					seleccionarUsuario(usuario.getItemText(), listBox);
					
				}
			});
		} else {
			seleccionarUsuario(null, listBox);
		}
		
		
	}
	
	private static void seleccionarUsuario(final String nombre, final ListBox listBox){
		cf.getUsuarioService().obtenerUsarios(new AsyncCallback<List<UsuarioDTO>>(){
			public void onSuccess(List<UsuarioDTO> usuarios) {
				listBox.clear();
				UsuarioDTO u = new UsuarioDTO();
				u.setId(-1L);
				u.setNombre("");
				listBox.addItem(u);
				
				for (UsuarioDTO localidadDTO : usuarios) {
					listBox.addItem(localidadDTO);
				}
			
				if (nombre!= null) 
					listBox.selectByText(nombre);
				else 
					listBox.selectByText("");
				
			}

			
			public void onFailure(Throwable arg0) {
				PopUpInfo popup = cf.getPopUp();
				popup.mostrarMensaje("Error", "inicializarCombos() " + arg0.getMessage());
				
			}

			

		});
		
	}
	
	/***
	 * Inicializa combo usuarios teniendo en cuenta los usuarios eliminados (logicamente)
	 * @param nombreUsuario
	 * @param listBox
	 */
	public static void inicializarComboUsuariosTodos(final String nombreUsuario, final ListBox listBox) {
		listBox.clear();
		if (nombreUsuario != null){
			cf.getUsuarioService().obtenerUsuarioPorNombreUsuario(nombreUsuario, new AsyncCallback<UsuarioDTO>() {
	
				@Override
				public void onFailure(Throwable arg0) {
					PopUpInfo popup = cf.getPopUp();
					popup.mostrarMensaje("Error", "inicializarCombos() " + arg0.getMessage());
					
				}
	
				@Override
				public void onSuccess(UsuarioDTO usuario) {
					seleccionarUsuariosTodos(usuario.getItemText(), listBox);
					
				}
			});
		} else {
			seleccionarUsuariosTodos("", listBox);
		}
		
	}


	
	private static void seleccionarUsuariosTodos(final String nombreUsuario,
			final ListBox listBox) {
		//Incluye usuarios eliminados (lógicamente)
		if (todosLosUsuariosDTO == null || todosLosUsuariosDTO.isEmpty()) {
			cf.getUsuarioService().obtenerUsuarios(true, new AsyncCallback<List<UsuarioDTO>>() {
				
				@Override
				public void onSuccess(List<UsuarioDTO> usuarios) {
					todosLosUsuariosDTO = usuarios;
					listBox.clear();
					UsuarioDTO u = new UsuarioDTO();
					u.setId(-1L);
					u.setNombre("");
					listBox.addItem(u);
					
					for (UsuarioDTO obj : usuarios) {
						listBox.addItem(obj);
					}
				
					if (nombreUsuario!= null) 
						listBox.selectByText(nombreUsuario);
					else 
						listBox.selectByText("");
					
				}
	
				
				@Override
				public void onFailure(Throwable e) {
					popup.mostrarMensajeError(e.getMessage());
					
				}
			});
		} else {
			if (nombreUsuario!= null) {
				for (UsuarioDTO obj : todosLosUsuariosDTO) {
					listBox.addItem(obj);
				}
				listBox.selectByText(nombreUsuario);
			}
			else 
				listBox.selectByText("");
		}
	}
	
	
	public static void resetearYCargarComboUsuuariosComercializadores(final String value, final ListBox listbox){
		usuariosComercializadoresDTO = null;
		inicializarComboUsuariosComercializadores(value, listbox);
	}
	
	public static void inicializarComboUsuariosComercializadores(final String value,
			final ListBox listBox) {
		final long tiempoCarga = new Date().getTime();
		listBox.clear();		
		if (usuariosComercializadoresDTO == null){

			cf.getUsuarioService().obtenerUsariosComercializadores(new AsyncCallback<List<UsuarioDTO>>(){
				public void onSuccess(List<UsuarioDTO> usuarios) {
					usuariosComercializadoresDTO = usuarios;
					listBox.clear();
					UsuarioDTO u = new UsuarioDTO();
					u.setId(-1L);
					u.setNombre("");
					listBox.addItem(u);
					
					listBox.addAllItems(usuariosComercializadoresDTO);
				
					if (value != null) 
						listBox.selectByValue(value);
					else 
						listBox.selectByText("");
					
					
					Log.debug("inicializarComboUsuariosComercializadores Tiempo carga ms: " + (new Date().getTime() - tiempoCarga));
				}

				
				public void onFailure(Throwable arg0) {
					PopUpInfo popup = cf.getPopUp();
					popup.mostrarMensaje("Error", "inicializarCombos() " + arg0.getMessage());
					
				}

				

			});

		} else {
			
			listBox.clear();
			UsuarioDTO u = new UsuarioDTO();
			u.setId(-1L);
			u.setNombre("");
			listBox.addItem(u);
			
			listBox.addAllItems(usuariosComercializadoresDTO);
		
			if (value!= null) 
				listBox.selectByValue(value);
			else 
				listBox.selectByText("");
			
			Log.debug("inicializarUsuariosComercializadores Tiempo carga ms: " + (new Date().getTime() - tiempoCarga));
			
		}
		
		
	}
	
	
	
	public static void inicializarComboUsuariosComercializadores(final Long id,
			final ListBox listBox) {
		final long tiempoCarga = new Date().getTime();
		listBox.clear();
		cf.getUsuarioService().obtenerUsariosComercializadores(new AsyncCallback<List<UsuarioDTO>>(){
			public void onSuccess(List<UsuarioDTO> usuarios) {
				UsuarioDTO u = new UsuarioDTO();
				u.setId(-1L);
				u.setNombre("");
				listBox.addItem(u);
				
				
				for (UsuarioDTO localidadDTO : usuarios) {
					listBox.addItem(localidadDTO);
				}
			
				if (id!= null) 
					listBox.selectByValue(id.toString());
				else 
					listBox.setSelectedIndex(0);
				
				Log.debug("inicializarComboUsuariosComercializadores Tiempo carga ms: " + (new Date().getTime() - tiempoCarga));
			}

			
			public void onFailure(Throwable arg0) {
				PopUpInfo popup = cf.getPopUp();
				popup.mostrarMensaje("Error", "inicializarCombos() " + arg0.getMessage());
				
			}

			

		});
		
	}
	
	/**
	 * Inicializa con los 12 meses del año
	 * @param listBox
	 * @param seleccionar
	 */
	
	static public void inicializarComboTodosLosMeses(final ListBox listBox, String seleccionar) {
		listBox.clear();
		listBox.addItem("", "");
		listBox.addItem("ENERO", "0");
		listBox.addItem("FEBRERO", "1");
		listBox.addItem("MARZO", "2");
		listBox.addItem("ABRIL", "3");
		listBox.addItem("MAYO", "4");
		listBox.addItem("JUNIO", "5");
		listBox.addItem("JULIO", "6");
		listBox.addItem("AGOSTO", "7");
		listBox.addItem("SEPTIEMBRE", "8");
		listBox.addItem("OCTUBRE", "9");
		listBox.addItem("NOVIEMBRE", "10");
		listBox.addItem("DICIEMBRE", "11");
		
		if (seleccionar != null)
			listBox.selectByText(seleccionar);
		 else
			 listBox.selectByText("");
		
	}


	public static void inicializarComboCuotas(String texto, ListBox listBox) {
		listBox.clear();
		
		listBox.addItem("", "");
		for (int i = 1; i <= 36; i++){
			listBox.addItem(String.valueOf(i), String.valueOf(i));
		}
		
		if (texto == null || !texto.isEmpty()) texto = "";
		
		listBox.selectByText(texto);
		
	}
	
	

	
	public static void inicializarComboCuotasSolicitud(String texto, ListBox listBox) {
		listBox.clear();
		
		listBox.addItem("", "");
		
		
		listBox.addItem("1", "1");
		listBox.addItem("3", "3");
		listBox.addItem("6", "6");
		listBox.addItem("9", "9");
		listBox.addItem("12", "12");
		listBox.addItem("15", "15");
		listBox.addItem("18", "18");
		listBox.addItem("24", "24");
		listBox.addItem("36", "36");
		listBox.selectByText("1");
		
		if (texto == null || texto.isEmpty()) texto = "";
		
		listBox.selectByText(texto);
		
	}
	






	public static void inicializarComboMedioContacto(final String itemText, final ListBox listBox) {
		inicializarComboMedioContacto(itemText, listBox, false);
	}



	static public void inicializarComboTipoReporte(final String nombre,final ListBox listBox, final ClientFactory cf){
		final long tiempoCarga = new Date().getTime();
		listBox.clear();
		cf.getComunesService().obtenerTiposReporte(new AsyncCallback<List<TipoReporteDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				PopUpInfo popup = cf.getPopUp();
				popup.mostrarMensaje("Error", "inicializarCombos() " + caught.getMessage());
			}

			@Override
			public void onSuccess(List<TipoReporteDTO> result) {
				TipoReporteDTO u = new TipoReporteDTO();
				u.setId(-1L);
				u.setNombre("");
				listBox.addItem(u);
				
				for (TipoReporteDTO reporteDTO : result) {
					listBox.addItem(reporteDTO);
				}
			
				if (nombre!= null) 
					listBox.selectByValue(nombre);
				else 
					listBox.selectByValue("");
				
				Log.debug("inicializarComboTipoReporte Tiempo carga ms: " + (new Date().getTime() - tiempoCarga));
			}
		});
	}
	


	
	

	public static void inicializarCombos(final ListBox bancos, final ListBox comercializadores) {
		final long tiempoCarga = new Date().getTime();

			
			final boolean banco;
			final boolean comercializador;
			
			banco = bancos != null;
			comercializador = comercializadores != null;
			
			cf.getComunesService().obtenerDatosCombos(banco, comercializador, new AsyncCallback<List<List<ListBoxItem>>>() {

				@Override
				public void onFailure(Throwable e) {
					popup.mostrarMensaje("Error", "inicializarCombos():   " + e.getMessage());
					
				}

				@Override
				public void onSuccess(List<List<ListBoxItem>> result) {
					if (banco){
						bancos.clear();
						bancos.addAllItems(result.get(0));
						
					}
					
					if (comercializador){
						comercializadores.addAllItems(result.get(1));
					}
					
					Log.debug("inicializarCombos() Tiempo carga ms: " + (new Date().getTime() - tiempoCarga));
					
				}
			});
			
			
		
			
		
		
	}



	
	
	public static void inicializarComboMedioContacto(final String itemText, final ListBox listBox, final boolean esComercializador) {
		final long tiempoCarga = new Date().getTime();
		cf.getComunesService().obtenerMediosContacto(new AsyncCallback<List<MedioContactoDTO>>(){
			public void onSuccess(List<MedioContactoDTO> medios) {
				
				listBox.clear();
				System.out.println("esComer: " + esComercializador);
				if (esComercializador && (itemText == null || itemText.isEmpty())){
					for (MedioContactoDTO medio : medios) {
						if ("Comercializador".equalsIgnoreCase(medio.getDescripcion())){
							listBox.addItem(medio);
							break;
						}
					}
					
					listBox.setSelectedIndex(0);
					
				} else {
				
					MedioContactoDTO u = new MedioContactoDTO();
					u.setId(-1L);
					u.setDescripcion("");
					listBox.addItem(u);
					
					
					for (MedioContactoDTO medio : medios) {
						listBox.addItem(medio);
					}
				
					
					if (itemText == null || itemText.isEmpty()) 
						listBox.selectByText("");				
					else 					
						listBox.selectByText(itemText.trim());
				}
				
				
				
				
				Log.debug("inicializarComboMedioContacto Tiempo carga ms: " + (new Date().getTime() - tiempoCarga));
			}

			
			public void onFailure(Throwable arg0) {
				PopUpInfo popup = cf.getPopUp();
				popup.mostrarMensaje("Error", "inicializarCombos() " + arg0.getMessage());
				
			}

			

		});
		
	}

	/* De acá para abajo son todos para uso de Gestambo Propiamente*/
	
	public static void inicializarComboEstablecimientosUsuarioLogueado(final String itemText, final ListBox listBox) {
		listBox.clear();
		
		cf.getUsuarioService().obtenerEstablecimientosUsuarioLogueadoRPC(new AsyncCallback<List<EstablecimientoDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				popup.mostrarMensaje("Atencion","No se han encontrado establecimientos asociados al usuario.");
			}

			@Override
			public void onSuccess(List<EstablecimientoDTO> result) {
				for (EstablecimientoDTO e: result){
					listBox.addItem(e);
				}
				
				if (result.size() == 1){
					//Un solo establecimiento, elijo ese
					listBox.selectByText(result.get(0).getNombre());
				} else {
					if (itemText == null || itemText.isEmpty()) 
						listBox.selectByText("");				
					else 					
						listBox.selectByText(itemText.trim());
				}
			}
		});
		
	}
	
	static public void inicializarComboEstadoProductivo(final ListBox listBox, String seleccionar) {
		listBox.clear();
		for (EstadoProductivoEnumDTO estado:EstadoProductivoEnumDTO.values()){
			listBox.addItem(estado.getItemText(),estado.getItemValue());
		}

		if (seleccionar != null)
			listBox.selectByText(seleccionar);
		
	}

	static public void inicializarComboEstadoReproductivo(final ListBox listBox, String seleccionar) {
		listBox.clear();
		for (EstadoReproductivoEnumDTO estado:EstadoReproductivoEnumDTO.values()){
			listBox.addItem(estado.getItemText(),estado.getItemValue());
		}

		if (seleccionar != null)
			listBox.selectByText(seleccionar);
		
	}
	
	static public void inicializarComboEstadoSanitario(final ListBox listBox, String seleccionar) {
		listBox.clear();
		for (EstadoSanitarioEnumDTO estado:EstadoSanitarioEnumDTO.values()){
			listBox.addItem(estado.getItemText(),estado.getItemValue());
		}

		if (seleccionar != null)
			listBox.selectByText(seleccionar);
		
	}
	static public void inicializarComboRodeos(final String nombre,final ListBox listBox){
		final long tiempoCarga = new Date().getTime();
		listBox.clear();
		cf.getVacasService().obtenerRodeosRPC(new AsyncCallback<List<RodeoDTO>>() {
			
			public void onFailure(Throwable caught) {
				cf.getPopUp().mostrarMensaje("Error", caught.getMessage());
			}

			public void onSuccess(List<RodeoDTO> result) {
				
				for (RodeoDTO obj : result) {
					listBox.addItem(obj);
				}
				
				if (nombre != null && !nombre.isEmpty())
					listBox.selectByText(nombre);
				
				Log.debug("inicializarComboRodeos Tiempo carga ms: " + (new Date().getTime() - tiempoCarga));
			}

		});
	}
	
	static public void inicializarComboProblemasTacto(final ListBox listBox,final String nombre){
		final long tiempoCarga = new Date().getTime();
		listBox.clear();
		listBox.addItem("","");
		cf.getVacasService().obtenerResultadosTactoRPC(new AsyncCallback<List<ResultadoTactoDTO>>() {

			
			public void onFailure(Throwable caught) {
				cf.getPopUp().mostrarMensaje("Error", caught.getMessage());
			}

			public void onSuccess(List<ResultadoTactoDTO> result) {
				
				for (ResultadoTactoDTO obj : result) {
					listBox.addItem(obj);
				}
				
				if (nombre != null && !nombre.isEmpty())
					listBox.selectByText("nombre");
				
				Log.debug("inicializarComboProblemas Tiempo carga ms: " + (new Date().getTime() - tiempoCarga));
			}

		});
	}

	static public void inicializarComboToros(final String nombre,final ListBox listBox){
		final long tiempoCarga = new Date().getTime();
		listBox.clear();
		listBox.addItem("", "");
		cf.getVacasService().obtenerTorosRPC(new AsyncCallback<List<ToroDTO>>() {
			
			public void onFailure(Throwable caught) {
				cf.getPopUp().mostrarMensaje("Error", caught.getMessage());
			}

			public void onSuccess(List<ToroDTO> result) {
				
				for (ToroDTO obj : result) {
					listBox.addItem(obj);
				}
				
				if (nombre != null && !nombre.isEmpty())
					listBox.selectByText(nombre);
				
				Log.debug("inicializarComboToros Tiempo carga ms: " + (new Date().getTime() - tiempoCarga));
			}

		});
	}
	
	static public void inicializarComboRaza(final String raza,final ListBox listBox) {
		try {
			final long tiempoCarga = new Date().getTime();
			cf.getVacasService().obtenerRazasRPC(new AsyncCallback<List<RazaDTO>>() {
			
				public void onFailure(Throwable caught) {
					popup.mostrarMensaje("Error", "No se pudo inicializar el combo Razas");
					
				}

				public void onSuccess(List<RazaDTO> razas) {
					listBox.clear();
					listBox.addItem("","");
					for (RazaDTO razaDTO : razas) {
						listBox.addItem(razaDTO);
					}
					if (raza!= null) listBox.selectByText(raza);
					
					System.out.println("inicializarComboXRaza Tiempo de carga: " + (new Date().getTime() - tiempoCarga));
				}

			});
		} catch (Exception e) {
			popup.mostrarMensaje("Error", "No se pudo inicializar el combo de razas.");
		}
	}
	
	static public void inicializarComboTipoRodeo(final String nombre,final ListBox listBox){
		final long tiempoCarga = new Date().getTime();
		listBox.clear();
		
		for (TipoRodeoEnumDTO tipo:TipoRodeoEnumDTO.values()) {
			listBox.addItem(tipo);
		}
		if (nombre != null && !nombre.isEmpty())
			listBox.selectByText("nombre");
				
		Log.debug("inicializarComboTipoRodeo Tiempo carga ms: " + (new Date().getTime() - tiempoCarga));
	}


}
