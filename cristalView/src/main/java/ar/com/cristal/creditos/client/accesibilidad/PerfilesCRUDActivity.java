
package ar.com.cristal.creditos.client.accesibilidad;

import java.util.ArrayList;
import java.util.List;

import ar.com.cristal.creditos.client.ClientFactory;
import ar.com.cristal.creditos.client.creditos.lineasdecredito.crud.FlexTableDinamica;
import ar.com.cristal.creditos.client.ui.util.ClientContext;
import ar.com.cristal.creditos.client.ui.util.CustomAbstractActivity;
import ar.com.cristal.creditos.client.ui.util.PopUpInfo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.CheckBox;

/**
 * Activities are started and stopped by an ActivityManager associated with a container Widget.
 */
public class PerfilesCRUDActivity extends CustomAbstractActivity implements PerfilesCRUDView.Presenter {

//	private Logger logger = Logger.getLogger(LineasDeCreditoCRUDActivity.class);	
	
	private String name;
	private PopUpInfo popup = null;
	private ClientFactory clientFactory;
	private ClientContext clientContext = ClientContext.getInstance();
	private PerfilesCRUDView view;
	private List<PerfilesDto> perfiles = new ArrayList<PerfilesDto>();
	private List<ComponenteDePantallaDto> componentes = new ArrayList<ComponenteDePantallaDto>();
	private static final String ID_COMPONENTE_ACTIVITY = "PERFILES";

	public List<ComponenteDePantallaDto> getComponentes() {
		return componentes;
	}


	public void setComponentes(List<ComponenteDePantallaDto> componentes) {
		this.componentes = componentes;
	}


	public List<PerfilesDto> getPerfiles() {
		return perfiles;
	}


	public void setPerfiles(List<PerfilesDto> perfiles) {
		this.perfiles = perfiles;
	}


	public PerfilesCRUDActivity(PerfilesCRUDPlace place, ClientFactory cf) {
		this.name = place.getName();
		
		clientFactory = cf;
	}

	
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		super.start(containerWidget, eventBus, ID_COMPONENTE_ACTIVITY);
		
		view = clientFactory.getPerfilesView();
		view.setPresenter(this);
		
		containerWidget.setWidget(view.asWidget());
		
	}

	

	@Override
	public String mayStop() {
		return null;
	}

	/**
	 * @see ListadoSolicitudAprobacionView.Presenter#goTo(Place)
	 */
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}


	

	
	/**
	 * recarga la tabla de componentes con los componentes del perfil seleccionado.
	 * @param idp
	 */
	public void cargoTablaComponentes() {
				
				clientFactory.getUsuarioService().obtenerComponentes(new AsyncCallback<List<ComponenteDePantallaDto>>() {

					public void onFailure(Throwable caught) {
						popup.mostrarMensaje("Error", "ERROR: se ha producido un error al cargar los componentes  " + caught.getMessage() );
					}

					public void onSuccess(List<ComponenteDePantallaDto> result) {
						
						view.cargoTablaComponentes(result);
					}
					
				}
				);	
	}



	
	/**
	 * borra la linea de credito y todos sus planes
	 */
			public void borrarPerfil(String id) {
				int idp=new Long(id).intValue();
				clientFactory.getUsuarioService().borrarPerfil(idp, new AsyncCallback<Void>(){
					
				public void onFailure(Throwable arg0) {
					popup.mostrarMensaje("Error al borrar perfil", arg0.getMessage());
				}
				public void onSuccess(Void o) {						
						view.cargoTablaPerfiles(new ArrayList<PerfilesDto>());
						
					};
	
				});
	}


	public void guardarPerfil(PerfilesDto p) {

		if (datosValidos(p)){
		
			clientFactory.getUsuarioService().guardarPerfil(p,new AsyncCallback<PerfilesDto>() {
	
				public void onFailure(Throwable caught) {
					popup.mostrarMensaje("Error", "ERROR: se ha producido un error invocar al servicio de gardar perfil " + caught.getMessage());
				}
	
				public void onSuccess(PerfilesDto perfil) {
					obtenerPerfiles();
//					view.setIdLineaCreditoSeleccionada(perfil.getItemValue());
					view.setIdPerfilSeleccionado(perfil.getItemValue());					
					popup.mostrarMensaje("Informacion", "El perfil y los componentes sleccionados se han guardado correctamente!");
				}
			});
		}
		
	}



	private boolean datosValidos(PerfilesDto p) {
		boolean result = true;
		
		if (p.nombre.isEmpty())
			result = false;		 
		
		if (!result)
			popup.mostrarMensaje("Atención", "El Perfil debe tener un Nombre.");
		
		
	
		return result;
	}


	public void obtenerPerfiles(){
		
		clientFactory.getUsuarioService().obtenerPerfiles(new AsyncCallback<List<PerfilesDto>>() {

			public void onFailure(Throwable caught) {
				popup.mostrarMensaje("Error", "Se ha producido un error al cargar los perfiles " + caught.getMessage());
				setPerfiles(new ArrayList<PerfilesDto>());
			}

			public void onSuccess(List<PerfilesDto> result) {
				    setPerfiles((List<PerfilesDto>)result);
					view.cargoTablaPerfiles((List<PerfilesDto>)result);
			}

		});
		
	}
	
	

	/**
	 * Este metodo recorre la lista de perfiles y agrega el componente a la lista de componentes que tiene el perfil 
	 * @param id
	 */
	public void agregoComponenteALaListaDelPerfil(String idPerfil, String idComponente){
				List<PerfilesDto> lista = this.getPerfiles();
				int idPerfilSeleccionado = new Long(idPerfil).intValue();
				for(PerfilesDto p : (List<PerfilesDto>)lista){
					if(p.getId() == idPerfilSeleccionado){
						String comp = p.getListaComponentes();					
						if (comp == null || !comp.contains(idComponente)){
									p.agregarComponente(idComponente);
									break;
						}
					}
					
				}
	}
	
	
	
	/**
	 * Este metodo recorre la lista de perfiles y agrega el componente a la lista de componentes que tiene el perfil 
	 * @param id
	 */
	public void sacoComponenteDeLaListaDelPerfil(String idPerfil, String idComponente){
				List<PerfilesDto> lista = this.getPerfiles();
				int idPerfilSeleccionado = new Long(idPerfil).intValue();
				for(PerfilesDto p : (List<PerfilesDto>)lista){
					if(p.getId() == idPerfilSeleccionado){
									p.sacoComponente(idComponente);
					}
					
				}
	}
	
	/**
	 * obtiene el perfil con id idPerfil de la lista de perfiles
	 * @param idPerfil
	 * @return
	 */
	public PerfilesDto obtenerPerfil(String idPerfil){
		Long idp = new Long(idPerfil);
		List<PerfilesDto> perfiles = this.getPerfiles();
		PerfilesDto pDto=null;
		for(PerfilesDto p: perfiles){
			if(p.getId().equals(idp)){
				pDto = p;
			}	
		}
		return pDto;
	}

	//el perfil con los componentes seleccionados
	public PerfilesDto obtenerPerfilAGuardar(String idPerfil){
		Long idp = new Long(idPerfil);
		List<PerfilesDto> perfiles = this.getPerfiles();
		PerfilesDto pDto=null;
		for(PerfilesDto p: perfiles){
			if(p.getId().equals(idp)){
				pDto = p;
			}	
		}
		pDto.setListaComponentes("");
		obtenerComponentesDelPerfil(pDto);
		return pDto;
	}
	
	
	
	//recorro la tabla de componentes y me quedo con los check=true que son los componentes seleccionados del perfil
	public PerfilesDto obtenerComponentesDelPerfil(PerfilesDto perf) {
		FlexTableDinamica tablaComponentes;
		tablaComponentes = view.tablaComponentes;
		
		for(int ft=1; ft < tablaComponentes.getTable().getRowCount(); ft++){
			CheckBox chk = (CheckBox) tablaComponentes.getTable().getWidget(ft, 0);
			if(chk.getValue()){
				perf.agregarComponente(chk.getFormValue().trim());
			}	
		}
		return perf;		
	}
	
	


	@Override
	public void inicializarActivity() {
		
		popup = clientFactory.getPopUp();
		this.obtenerPerfiles();
		this.cargoTablaComponentes();
		
	}


	@Override
	public void limpiarTodosLosCampos() {
		view.desclickearOtrosRadios("", view.tablaPerfiles);
		view.desclickearTodos(view.tablaComponentes);
		view.txtDescripcionPerfil.setText("");
		view.txtNombrePerfil.setText("");
//		view.setIdLineaCreditoSeleccionada(PerfilesCRUDView.NO_ID_SELECCIONADO);
		view.setIdPerfilSeleccionado(PerfilesCRUDView.NO_ID_SELECCIONADO);
	}
	
}	
		
		
	
