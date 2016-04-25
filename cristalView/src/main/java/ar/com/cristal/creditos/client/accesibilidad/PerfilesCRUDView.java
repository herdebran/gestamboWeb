package ar.com.cristal.creditos.client.accesibilidad;

import java.util.ArrayList;
import java.util.List;

import ar.com.cristal.creditos.client.creditos.lineasdecredito.crud.FlexTableDinamica;
import ar.com.cristal.creditos.client.ui.util.RegularExpressionConstants;
import ar.com.snoop.gwt.commons.client.widget.RegExpTextBoxImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;



public class PerfilesCRUDView extends Composite implements IsWidget {


	

	private static final int CANTIDAD_MAXIMA_FILAS_POR_PAGINA = 150;
	interface Binder extends UiBinder<Widget, PerfilesCRUDView> {
	}
	
	public interface Presenter {
		/**
		 * Navigate to a new Place in the browser.
		 */
		void goTo(Place place);
		
	
		void cargoTablaComponentes();
		void guardarPerfil(PerfilesDto p);
		void obtenerPerfiles();
		void agregoComponenteALaListaDelPerfil(String id, String idComponente);
		void sacoComponenteDeLaListaDelPerfil(String id, String idComponente);
		PerfilesDto obtenerPerfilAGuardar(String idperf);
		PerfilesDto obtenerPerfil(String idperf);


		void limpiarTodosLosCampos();


		PerfilesDto obtenerComponentesDelPerfil(PerfilesDto p);
	}
	
	
	private static final Binder binder = GWT.create(Binder.class);

	private Presenter listener;
	
	public static final String NO_ID_SELECCIONADO = "0";
		
	

	/**
	 * Creo la cabecera de la tabla, cargo listbox de la pantalla,
	 * llamo al metodo onClick del boton BUSCAR, que manda los filtros y completa la tabla.
	 */
	
	public void creoComponentesPantalla() {
		
		
		// CREO LA CABECERA DE LA TABLA DINAMICA
		
		ArrayList<Widget> listadoWidget;
		ArrayList<Widget> nombres;
		tablaPerfiles.setCantidadColumnasTabla(3);
		tablaPerfiles.setCantidadFilasMostrarTabla(CANTIDAD_MAXIMA_FILAS_POR_PAGINA);
		nombres = nombresCabeceraTablaPerfiles();
		tablaPerfiles.cargoNombreDeColumnasCabeceraTablaConWidgets(nombres);
		tablaPerfiles.setEstiloTabla("dataTable");
		numeroFilasMostrarTabla = tablaPerfiles.getCantidadFilasMostrarTabla() - 1;
		
		//componentes
		tablaComponentes.setCantidadColumnasTabla(4);
		tablaComponentes.setCantidadFilasMostrarTabla(CANTIDAD_MAXIMA_FILAS_POR_PAGINA);
		listadoWidget = armoNombreCabeceraTablaComponentes();
		tablaComponentes.cargoNombreDeColumnasCabeceraTablaConWidgets(listadoWidget);	
		tablaComponentes.setEstiloTabla("dataTable");
		
			
//		this.cargoTablaPerfiles();
//		this.cargoTablaComponentes(new ArrayList<ComponenteDePantallaDto>());
		
	}


	public void setPresenter(Presenter listener) {
		this.listener = listener;
	
	}

	
	/**
	 * Metodo constructor: Crea la pantalla de inbox portabilidad, pone la cabecera
	 * de la tabla y carga los listbox
	 */
	
	public PerfilesCRUDView() {
		initWidget(binder.createAndBindUi(this));
		txtNombrePerfil.setExpresionRegular(RegularExpressionConstants.numeroLetrasEspacioGuion);
		this.creoComponentesPantalla(); //creo columnas de la tabla y listbox
		
	}
	
	@UiField FlexTableDinamica tablaPerfiles;
	@UiField FlexTableDinamica tablaComponentes;
	
	// deberían hacer lo mismo
	@UiField Button botonGuardarNombrePerfil;
	@UiField Button botonGuardarConfiguracionPerfil;
	
	@UiField Button botonNuevoPerfil;
	
	
	@UiField RegExpTextBoxImpl txtNombrePerfil;
	
	@UiField
	TextArea txtDescripcionPerfil;
		

	
	/**
	 * Numero de filas a mostrar en la tabla, lo voy a utilizar
	 * para la paginacion.
	 */
	
	int numeroFilasMostrarTabla = 1;
	
	/**
	 * Numero de pagina actual de la paginacion de la tabla
	 */
	
	int numeroPaginaActualPaginacionTabla = 1;
	
	/**
	 * Cantidad de filas luego de ejecutar la consulta
	 */
	
	int cantidadFilasConsulta = 0;
	
	boolean nuevaConsulta = true;
	
	
	/**
	 * DTO que contiene los filtros que ingreso el usuario en la pantalla Inbox Portabilidad
	 */
	
	String orderByPreFiltro = "";

//	private String idLineaCreditoSeleccionada="";

	private String idPerfilSeleccionado = NO_ID_SELECCIONADO;
	
	
	
	
	public String getIdPerfilSeleccionado() {
		return idPerfilSeleccionado;
	}


//	public String getIdLineaCreditoSeleccionada() {
//		return idLineaCreditoSeleccionada;
//	}


	@UiHandler("botonNuevoPerfil")
	public void onNuevoPerfil(ClickEvent e){
		listener.limpiarTodosLosCampos();
	}
	

	@UiHandler("botonGuardarNombrePerfil")
	public void onBotonGuardarNombrePerfil(ClickEvent e){
				guardarPerfil();
	}
	
	
	@UiHandler("botonGuardarConfiguracionPerfil")
	public void onBotonGuardarConfiguracionPerfil(ClickEvent e){
		guardarPerfil();
		
	}
	
	/**
	 * Cuando se hace una nueva consulta, o sea se presiona el boton BUSCAR,
	 * se actualiza el paginador de la tabla, donde se ingresa nueva posicion
	 * final y se ingresan botones como siguiente y anterior.
	 * @param cantidadFilasR
	 */
	
	public void actualizarPageSelectorPaginacion(Integer cantidadFilas)
	{	
		int cantidadFilasMostrar = tablaComponentes.getCantidadFilasMostrarTabla() - 1;
		int ultimaPagina = 0;
	
		ultimaPagina = (int) (Math.ceil((cantidadFilas).doubleValue() / cantidadFilasMostrar));
		tablaComponentes.getCantidadRegistrosLabel().setText(cantidadFilas.toString());

	}

	
	
	public ArrayList<Widget> armoNombreCabeceraTablaComponentes()
	{
		ArrayList<Widget> listaDeWidgetsCabecera = new ArrayList<Widget>();
		
//		CheckBox chkBoxGeneral = new CheckBox("");
//		listaDeWidgetsCabecera.add(chkBoxGeneral);

		Label lblnombre2 = new Label("");
		listaDeWidgetsCabecera.add(lblnombre2);

		
		Label id = new Label("Id");
		listaDeWidgetsCabecera.add(id);
	
		
		Label nombre = new Label("Nombre");
		listaDeWidgetsCabecera.add(nombre);
		
		Label desc = new Label("Descripción");
		listaDeWidgetsCabecera.add(desc);
		
		return listaDeWidgetsCabecera;
		
	}
	
	
	
	
	public ArrayList<Widget> nombresCabeceraTablaPerfiles()
	{
		ArrayList<Widget> listaDeWidgetsCabecera = new ArrayList<Widget>();
		
		
		Label nada = new Label("");
		listaDeWidgetsCabecera.add(nada);
		
		Label nombre = new Label("Nombre");
		listaDeWidgetsCabecera.add(nombre);
		
		Label lblDescripion = new Label("Descripción");
		listaDeWidgetsCabecera.add(lblDescripion);		
		
		return listaDeWidgetsCabecera;
		
	}
	
	
	
	public void setIdPerfilSeleccionado(String id){
		idPerfilSeleccionado = id;
	}
	
	/**
	 * recarga los componentes del perfil seleccionado
	 * @param id
	 */
	public void seteoComponentesDelPerfil(String componentes){
			seteoCheckOn(componentes, tablaComponentes);
	}
	
	
	
	
	//obtiene todos los componentes de la base
	public void cargoTodosLosComponentes(){
		listener.cargoTablaComponentes();
	}
	
	public ArrayList<Widget> completoTablaComponentesConListaWidgetUsandoDTO(final ComponenteDePantallaDto componente)
	{
		ArrayList<Widget> listaDeWidgets = new ArrayList();
		
		final CheckBox chkBoxPorFila = new CheckBox("");

		
		chkBoxPorFila.setFormValue(componente.getId() + "");
		listaDeWidgets.add(chkBoxPorFila);

		Label id = new Label(componente.getId()+"");
		listaDeWidgets.add(id);
		
		Label nombre = new Label(componente.getNombre());
		listaDeWidgets.add(nombre);
		
		Label descripcion = new Label(componente.getDescripcion());
		listaDeWidgets.add(descripcion);
		
		return listaDeWidgets;
		
	}
	
			
		/**
		 * Descliquea todos los otros Radiobuttons excepto el del "id"
		 * Se supone que esta fila de radiobuttons es la primera.
		 * @param id
		 * @param tabla
		 */
		public void desclickearOtrosRadios(String id, FlexTableDinamica tabla){
			
				for(int fila=1; fila < tabla.getTable().getRowCount(); fila++){
					RadioButton chk = (RadioButton) tabla.getTable().getWidget(fila, 0);
					if (!id.equals(chk.getFormValue())){
							chk.setValue(false);
					}else{
						chk.setValue(true);
					}				
					
				}

		}
	
	
		public void seteoCheckOn(String lista, FlexTableDinamica tabla){
			desclickearTodos(tabla);
			String[] comp = lista.split(",");
			//CAMBIO fila = 0 -> fila = 1
			for(int fila=0; fila < comp.length; fila++){
					for(int ft=1; ft < tabla.getTable().getRowCount(); ft++){
						try {
							CheckBox chk = (CheckBox) tabla.getTable().getWidget(ft, 0);
							if (comp[fila].trim().equals(chk.getFormValue().trim())){
									chk.setValue(true);
									continue;
							}
						} catch (Exception e) {
							// se decide no hacer nada
						}
						
					}
			}
	}
		
		
		
	public void desclickearTodos(FlexTableDinamica tabla) { 
		for(int ft=1; ft < tabla.getTable().getRowCount(); ft++){
				try {
					CheckBox chk = (CheckBox) tabla.getTable().getWidget(ft, 0);
					chk.setValue(false);
				} catch (Exception e) {
					//// se decide no hacer nada
				}
			}				
			
		}


	
	
	/**
	 * Pasa los valores del PerfilesDto cada uno a una instancia de widget
	 * @param perfil
	 * @return: una lista de widget que representan una fila en la tabla
	 */
	public ArrayList<Widget> completoTablaPerfiles(final PerfilesDto perfil)
	{
		ArrayList<Widget> listaDeWidgets = new ArrayList<Widget>();
		
		
		final RadioButton radioPerfil = new RadioButton("perfiles");
		radioPerfil.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent e) {
				String id = radioPerfil.getFormValue();
				setIdPerfilSeleccionado(id);
				PerfilesDto dtop = listener.obtenerPerfil(id);
				seteoComponentesDelPerfil(dtop.getListaComponentes());
				mostrarDatosPerfil(dtop);
			}

			
		});
		
		
		
		radioPerfil.setFormValue(perfil.getItemValue());
		listaDeWidgets.add(radioPerfil);
		
		
		Label nombre = new Label(perfil.getNombre());
		listaDeWidgets.add(nombre);
		
		Label desc = new Label(perfil.getDescripcion());
		listaDeWidgets.add(desc);
		
		return listaDeWidgets;
		
	}
	

	private void mostrarDatosPerfil(PerfilesDto dtop) {
		txtNombrePerfil.setText(dtop.getNombre());
		txtDescripcionPerfil.setText(dtop.getDescripcion());
		
	}

	
	
	
	
	
	/**
	 * Cada vez que se presiona siguiente o anterior en la paginacion de la tabla,
	 * se actualiza el numero de pagina actual, se hace nuevamente la consulta,
	 * solicitando solamente las filas que se necesitan en la nueva pagina.
	 */
	
	public void pageNumberChanged(int newPageNumber) {
		
		numeroPaginaActualPaginacionTabla = newPageNumber + 1;
//		hagoConsulta();		
		
	}
	

	
	public void cargoTablaComponentes(List<ComponenteDePantallaDto> componentes){
				
		/**
		 * Como tengo un listado de DTO, lo recorro y por cada DTO armo la fila
		 * en forma de listado de widget.
		 */
		
		tablaComponentes.borrarFilasDeTabla();
		tablaComponentes.cargoNombreDeColumnasCabeceraTablaConWidgets(armoNombreCabeceraTablaComponentes());
		
		for (ComponenteDePantallaDto componente : componentes) 
			{
						
				ArrayList<Widget> listadoWidgetFila = completoTablaComponentesConListaWidgetUsandoDTO(componente);

				/**
				 * Cargo una fila de la tabla
				 */
				
				tablaComponentes.cargoUnaFilaDeTablaConListaWidget(listadoWidgetFila);
				
			}

		}
		
		
	
	
	
	/**
	 * cargo las filas de la tabla, sin inculuir las cabecerass de columnas
	 */			
		public void cargoTablaPerfiles(List<PerfilesDto> perfiles){
			this.tablaPerfiles.borrarTabla();			
			tablaPerfiles.cargoNombreDeColumnasCabeceraTablaConWidgets(nombresCabeceraTablaPerfiles());
			for (PerfilesDto perfil : perfiles) 
				{							
					ArrayList<Widget> listadoWidgetFila = completoTablaPerfiles(perfil);
					if (!NO_ID_SELECCIONADO.equals(getIdPerfilSeleccionado()) && getIdPerfilSeleccionado().equals(perfil.getItemValue())){
						//existe un id seleccionado y activo el radio si es necesario
						((RadioButton)listadoWidgetFila.get(0)).setValue(true);
					}
					this.tablaPerfiles.cargoUnaFilaDeTablaConListaWidget(listadoWidgetFila);
							
				}
		
			}

		

		private void guardarPerfil() {
			PerfilesDto p = null;
			if (NO_ID_SELECCIONADO.equals(getIdPerfilSeleccionado())){
				p = this.obtenerPerfilAGuardar();
				listener.obtenerComponentesDelPerfil(p);
			}
			else
			{
				p = listener.obtenerPerfilAGuardar(getIdPerfilSeleccionado());
				p.setNombre(txtNombrePerfil.getText());
				p.setDescripcion(txtDescripcionPerfil.getText());
				
			}
			listener.guardarPerfil(p);
			
		
		}
		
		
		
		/***
		 * Devuelve un nuevo perfil
		 * @return
		 */
		private PerfilesDto obtenerPerfilAGuardar(){
			PerfilesDto p = new PerfilesDto();
			p.setNombre(this.txtNombrePerfil.getText());
			p.setDescripcion(txtDescripcionPerfil.getText());
			return p;
		}
		
		public void cargoTablaPerfiles(){
			listener.obtenerPerfiles();
		}
		
		public void agregoComponenteALaListaDelPerfil(String idcomp){
				listener.agregoComponenteALaListaDelPerfil(this.getIdPerfilSeleccionado(), idcomp);
		}
		
		public void sacoComponenteDeLaListaDelPerfil(String id){
			listener.sacoComponenteDeLaListaDelPerfil(this.getIdPerfilSeleccionado(), id);
		}
		
		
}


	
	
