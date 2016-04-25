package ar.com.cristal.creditos.client.creditos.lineasdecredito.crud;



import java.util.ArrayList;


import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * Tabla dinamica, se define numero de columnas y filas a mostrar, 
 * Se puede cargar con un listado de widget o string la cabecera y las filas.
 * 
 * Las filas se cargan fila por fila, donde un listado de string/widget representa a UNA fila.
 * 
 * Se le aplican estilos a la tabla, dichos estilos por defecto son los de nextel,
 * pero se pueden modificar.
 * 
 * 
 * @author Juan Pereyra
 *
 */

public class FlexTableDinamica extends Composite{
	
  public int datosFijos;
  
  	// Defino la cantidad de columnas de la tabla con setCantidadColumnasTabla(int)
  	private int cantidadColumnasTabla = 0;
  	
  	// Estilos para intercarlar en las filas de la tabla, se ponen por defecto estilos de nextel
  	// pero se pueden cambiar con setEstiloFilaUno(String) y setEstiloFilaDos(String)
	private String estiloFilaUno = "TableRow1";
	private String estiloFilaDos = "TableRow2";
	
	
	// Estilo para la cebecera de la tabla, se pone como defecto estilo de nextel
	// pero se puede cambiar con setEstiloCabeceraTabla(String)
	private String estiloCabeceraTabla = "header";
	
	// Variable para saber si se aplican los estilos de las filas en forma intercalada
	// por defecto esta en true (se aplican los estilos) pero se puede cambiar con setIntercalarEstilosFilaTabla(boolean)
	private boolean intercalarEstilosFilaTabla = true;
	
	// No cambiar valor de esta variable, en caso que intercalarEstilosFilaTabla esta en true, se usa
	// para saber que estilo aplicar a cada fila
	private boolean agregoEstiloFila = false;
	
	// Defino la cantidad de filas que voy a mostrar en la tabla por pagina, tener en cuenta que la cabecera cuenta como fila,
	// por lo tanto si ponemos setCantidadFilasMostrarTabla(6) van a ser 5 filas de datos mas 1 fila para la cabecera
	private int cantidadFilasMostrarTabla = 0;
  

    // Defino la FlexTable a utilizar como tabla
	private FlexTable table = new FlexTable();
	
	
	Label CantidadRegistrosLabel = new Label("");
	
	private int idSeleccionado = 0;
	
	public int getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(int idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public Label getCantidadRegistrosLabel() {
		return CantidadRegistrosLabel;
	}

	public void setCantidadRegistrosLabel(Label cantidadRegistrosLabel) {
		CantidadRegistrosLabel = cantidadRegistrosLabel;
	}



	/**
	 * 
	 * Tabla dinamica, pasos para usarla:
	 * 1) Definir cantidad de columnas con setCantidadColumnasTabla(int)...
	 * 2) Definir cantidad de filas a mostrar en la tabla con setCantidadFilasMostrarTabla(int)...
	 * 3) Para crear la cabecera, se le puede pasar un listado de string con cargoNombreDeColumnasCabeceraTablaConString,
	 * o un listado de Widget (ejemplo: para usar CheckBox en la cabecera de alguna columna) con cargoNombreDeColumnasCabeceraTablaConWidgets.
	 * 4) Para crear una fila, se le pasa un listado de widget con cargoUnaFilaDeTablaConListaWidget, con los widgets para UNA fila...
	 * 5) Se tiene estilos para la cabecera y filas (se intercala), estan por defecto los de nextel, pero se pueden modificar...
	 * 6) Por defecto se intercala los estilos de las filas, se puede cambiar con setIntercalarEstilosFilaTabla(boolean)...
	 *  
	 */

	public FlexTableDinamica() {
		
		super();
		initWidget(getTable());
		this.table.setCellPadding(0);
		this.table.setCellSpacing(0);
	
	}
	
	/**
	 * Retorno la FlexTableDinamica
	 * @return
	 */
	public FlexTable getTable()
	{
		return this.table;
	}
	
	
		/**
		 * Retorno estilo uno para fila de la tabla dinamica
		 * @return
		 */
		public String getEstiloFilaUno() {
			return estiloFilaUno;
		}

		/**
		 * Defino estilo uno para fila de la tabla dinamica
		 * @param estilo fila uno
		 */
		public void setEstiloFilaUno(String estiloFilaUno) {
			this.estiloFilaUno = estiloFilaUno;
		}

		/**
		 * Retorno estilo dos para fila de la tabla dinamica
		 * @return estilo fila dos
		 */
		public String getEstiloFilaDos() {
			return estiloFilaDos;
		}

		/**
		 * Defino estilo dos para fila de la tabla dinamica
		 * @param estiloFilaDos
		 */
		public void setEstiloFilaDos(String estiloFilaDos) {
			this.estiloFilaDos = estiloFilaDos;
		}

		/**
		 * Si esta en true, se intercala los estilos de la tabla
		 * @return
		 */
		public boolean getIntercalarEstilosFilaTabla() {
			return intercalarEstilosFilaTabla;
		}

		/**
		 * Se pone en true, si se quiere que se intercale los estilos
		 * para la fila de la tabla
		 * @param intercalar
		 */
		public void setIntercalarEstilosFilaTabla(boolean intercalar) {
			this.intercalarEstilosFilaTabla = intercalar;
		}
	
		
		public boolean getAgregoEstiloFila() {
			return agregoEstiloFila;
		}

		/**
		 * NO usar este metodo desde afuera, es uso interno para intercalar estilos
		 * para setear estilos de las filas usar setEstiloFilaUno, setEstiloFilaDos y
		 * para la cabecera setEstiloCabeceraTabla
		 * @param agregoEstiloFilaIntercalado
		 */
		public void setAgregoEstiloFila(boolean agregoEstiloFilaIntercalado) {
			this.agregoEstiloFila = agregoEstiloFilaIntercalado;
		}
		
		public String getEstiloCabeceraTabla() {
			return estiloCabeceraTabla;
		}


		/**
		 * Defino el estilo para la cabecera, por defecto esta en fondoCabecera
		 * @param estiloCabeceraTabla
		 */
		public void setEstiloCabeceraTabla(String estiloCabeceraTabla) {
			this.estiloCabeceraTabla = estiloCabeceraTabla;
		}
		
		/**
		 * 
		 * @return cantidad de filas que muestra la tabla
		 */
		public int getCantidadFilasMostrarTabla() {
			return cantidadFilasMostrarTabla;
		}

		/**
		 * Defino la cantidad de filas a mostrar en la tabla,
		 * tener en cuenta que si ponemos 6 filas, son 5 filas de datos
		 * y 1 fila para la cabecera. O sea, hay que sumar 1 fila mas para la cabecera.
		 * @param cantidadFilasMostrarTabla
		 */
		public void setCantidadFilasMostrarTabla(int cantidadFilasMostrarTabla) {
			this.cantidadFilasMostrarTabla = cantidadFilasMostrarTabla;
		}
		
		
		public void setEstiloTabla(String estilo){
			this.getTable().setStyleName(estilo);
		}
	
	
	/**
	 * retorna el numero de filas de la tabla dinamica
	 * @return
	 */
	public int cantidadFilas(){
		return this.getTable().getRowCount();
	}
	
	public void setDatosFijos(){

		datosFijos= getTable().getRowCount();

		
		datosFijos= table.getRowCount();
		

		}
	
	
	  public int getCantidadColumnasTabla() {
			return cantidadColumnasTabla;
		}


		public void setCantidadColumnasTabla(int nuevaCantidadColumnasTabla) {
			this.cantidadColumnasTabla = nuevaCantidadColumnasTabla;
		}
	
	public int getDatosFijos(){
	
	return datosFijos;
	}
		

	
	/**
	 * Se borra el contenido de la tabla
	 * cabecera y las filas.
	 */
	
	public void borrarTabla()
	{
		getTable().clear();
		getTable().removeAllRows();
	}
	
	/**
	 * Se borran todas las filas de la tabla.
	 */
	
	public void borrarFilasDeTabla()
	{
		getTable().removeAllRows();
	}
	
	/**
	 * Se especifica si se quiere intercalar estilos para las filas,
	 * ejemplo: Se pinta de gris el color de fondo de una fila y la siguiente
	 * fila tendra color de fondo de otro color.
	 * Los estilos para las filas estan por default, pero se pueden modificar,
	 * con setEstiloFilaUno y setEstiloFilaDos
	 * 
	 * @param intercalo
	 */
	
	public void intercalarEstilosFilas(boolean intercalo)
	{
		setIntercalarEstilosFilaTabla(intercalo);
	}
	
	
//
//	
//	METODOS PARA CREAR LA CABECERA DE LA TABLA
// 	 Opciones para crear la cabecera:
//  	1) Lista de widgets 
// 	    2) Lista de string
//
//
	
	
	
	/**
	 * Explicacion:
	 * Se carga la cabecera de la tabla, se le pasa un listado de STRING,
	 * Solo se permite texto en la cabecera, si se quiere poner algun
	 * widget (button, CheckBox, etc..) usar el metodo cargoNombreDeColumnasCabeceraTablaConString
	 *  
	 * Validacion: 
	 * Se compara la cantidad de string con la cantidad de columnas, si la 
	 * cantidad de string es mayor, se retorna false y la carga no se hace.
	 * 
	 * Estilo de la cabecera:
	 * Se agrega estilo a la cabecera, tenemos un estilo por default 
	 * (estiloCabeceraTabla) pero se puede modificar con setEstiloCabeceraTabla.
	 * 
	 * @param  nombreStringCabeceraColumnas : lista de string
	 * @return True: si se cargo la fila OK. 
	 * 		   False: si la cantidad de widgets es mayor
	 * 		   a la cantidad de columnas de la tabla.
	 */
	
	public boolean cargoNombreDeColumnasCabeceraTablaConString(ArrayList<String> nombreStringCabeceraColumnas)
	{
		
		int cantidadColumnasTabla = this.getCantidadColumnasTabla();
		int numeroNombreColumnasPasados = nombreStringCabeceraColumnas.size() + 1;
		
		
		
		int numeroColumnaActual = 0;
		
		if (cantidadColumnasTabla == numeroNombreColumnasPasados)
		{
			for ( String nombreDeUnaColumnaString : nombreStringCabeceraColumnas) 
			{
				getTable().setText(0, numeroColumnaActual, nombreDeUnaColumnaString);
				numeroColumnaActual++;
			}
			
			getTable().getRowFormatter().addStyleName(0, getEstiloCabeceraTabla());
			
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * Explicacion:
	 * Se carga la cabecera de la tabla, se le pasa un listado de WIDGET,
	 * para permitir poner button, CheckBox, RadioButton, etc.. 
	 * en la cabecera de una columna.
	 * Ejemplo: CheckBox para seleccionar todos los items de la tabla.
	 * 
	 * Validacion: 
	 * Se compara la cantidad de widgets con la cantidad de columnas, si la 
	 * cantidad de widgets es mayor, se retorna false y la carga no se hace.
	 * 
	 * Estilo de la cabecera:
	 * Se agrega estilo a la cabecera, tenemos un estilo por default 
	 * (estiloCabeceraTabla) pero se puede modificar con setEstiloCabeceraTabla.
	 * 
	 * @param  nombreWidgetCabeceraColumnas : lista de widget
	 * @return True: si se cargo la fila OK. 
	 * 		   False: si la cantidad de widgets es mayor
	 * 		   a la cantidad de columnas de la tabla.
	 */
	
	public boolean cargoNombreDeColumnasCabeceraTablaConWidgets(ArrayList<Widget> nombreWidgetCabeceraColumnas)
	{
		
		
		int numRows = getTable().getRowCount(); 
			
		numRows = getTable().insertRow(numRows);
		
		int cantidadColumnasTabla = getCantidadColumnasTabla();
		int numeroNombreColumnasPasados = nombreWidgetCabeceraColumnas.size();
			
		int numeroColumnaActual = 0;
		
//		getTable().getRowFormatter().addStyleName(0, "header");
		
		if (cantidadColumnasTabla == numeroNombreColumnasPasados)
		{
			
			for ( Widget nombreDeUnaColumnaWidget : nombreWidgetCabeceraColumnas) 
			{	 
				
				getTable().setWidget(numRows, numeroColumnaActual, nombreDeUnaColumnaWidget);
				numeroColumnaActual++;
			}
			
			getTable().getRowFormatter().addStyleName(0, getEstiloCabeceraTabla());
			
			return true;
		}
		else
		{
			return false;
		}
		
		
		
	}
	
	
//
//	
//	METODOS PARA CARGAR UNA FILA DE LA TABLA
//		Opciones para cargar la fila: 
//			1) Lista de widgets
//			2) Lista de string
//
//
	
	/**
	 * Explicacion:
	 * Se carga UNA fila de la tabla, mediante un listado de widgets que se 
	 * ingresaran en dicha fila
	 * 
	 * Validacion:
	 * Se compara la cantidad de widgets con la
	 * cantidad de columnas de la tabla, si son distintas, se devuelve
	 * false y no se carga la fila.
	 * 
	 * Estilos de la tabla:
	 * Se verifica si se desea intercalar estilos para las filas,
	 * Si intercalarEstilosFilaTabla esta en true, se usan los estilos estiloFilaUno
	 * y estiloFilaDos, estan por defecto los estilos de nextel, pero se pueden modificar.
	 * 
	 * @param widgetsDeUnaFila
	 * @return True: si se cargo la fila OK. 
	 * 		   False: si la cantidad de widgets es mayor
	 * 		   a la cantidad de columnas de la tabla.
	 */
	
	public boolean cargoUnaFilaDeTablaConListaWidget(ArrayList<Widget> widgetsDeUnaFila)
	{
		int numRows = getTable().getRowCount();  
		
		if (numRows < getCantidadFilasMostrarTabla())
			
			{

				numRows = getTable().insertRow(numRows);
		
		
				int numeroColumnasTabla = this.getCantidadColumnasTabla();
				int numeroColumnaActual = 0;
		
				int numeroWidgetsPasados = widgetsDeUnaFila.size();

				if (numeroColumnasTabla == numeroWidgetsPasados)
					{
		
						for ( Widget widgetIndividual : widgetsDeUnaFila) 
							{

								getTable().setWidget(numRows, numeroColumnaActual, widgetIndividual);
								numeroColumnaActual++;
							}
				
				
						if (this.getIntercalarEstilosFilaTabla() == true)
							{
								this.agregoEstiloFilaIntercalados(numRows);
							}
				
				
					return true;

				
				}
				else
				{
					return false;
				}
		
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * Explicacion:
	 * Se carga UNA fila de la tabla, mediante un listado de strings que se
	 * ingresaran en dicha fila
	 * 
	 * Validacion:
	 * Se compara la cantidad de strings con la
	 * cantidad de columnas de la tabla, si son distintas, se devuelve
	 * false y no se carga la fila.
	 * 
	 * Estilos de la tabla:
	 * Se verifica si se desea intercalar estilos para las filas,
	 * Si intercalarEstilosFilaTabla esta en true, se usan los estilos estiloFilaUno
	 * y estiloFilaDos, estan por defecto los estilos de nextel, pero se pueden modificar.
	 * 
	 * @param stringsDeUnaFila
	 * @return True: si se cargo la fila OK. 
	 * 		   False: si la cantidad de strings es mayor
	 * 		   a la cantidad de columnas de la tabla.
	 */
	
	
	public boolean cargoUnaFilaDeTablaConListaString(ArrayList<String> stringsDeUnaFila)
	{
		int numRows = getTable().getRowCount();  
		
		if (numRows < getCantidadFilasMostrarTabla())
			
			{

				numRows = getTable().insertRow(numRows);
		
		
				int numeroColumnasTabla = this.getCantidadColumnasTabla();
				int numeroColumnaActual = 0;
		
				int numeroStringPasados = stringsDeUnaFila.size();

				if (numeroColumnasTabla == numeroStringPasados)
					{
		
						for ( String stringIndividual : stringsDeUnaFila) 
							{
								getTable().setText(numRows, numeroColumnaActual, stringIndividual);
								numeroColumnaActual++;
							}
				
				
						if (this.getIntercalarEstilosFilaTabla() == true)
							{
								this.agregoEstiloFilaIntercalados(numRows);
							}
				
				
					return true;

				
				}
				else
				{
					return false;
				}
		
		}
		else
		{
			return false;
		}
	}
	
	// 
	// METODOS PARA APLICAR ESTILOS A LA TABLA
	//
	
	/**
	 * Si no se quiere usar el metodo que intercala estilos, se puede:
	 * Agregar estilo a una determinada fila
	 * @param numeroFila : numero de la fila
	 * @param nombreEstilo : nombre del estilo
	 */
	
	public void agregoEstiloFila(int numeroFila, String nombreEstiloFila)
	{
		getTable().getRowFormatter().addStyleName(numeroFila, nombreEstiloFila);
	}
	
	/**
	 * Se agrega estilo a una determinada celda de la tabla
	 * @param numeroFila : numero de fila
	 * @param numeroCelda : numero de celda
	 * @param nombreEstiloCelda : nombre del estilo
	 */
	
	public void agregoEstiloCelda(int numeroFila, int numeroCelda, String nombreEstiloCelda)
	{
		getTable().getCellFormatter().addStyleName(numeroFila, numeroCelda, nombreEstiloCelda);
	}
	
	
	/**
	 * Intercalo el estilo para las filas,
	 * si getAgregoEstiloFila == true, le corrresponde
	 * el estilo de fila uno, sino, el estilo de fila dos.
	 * Los estilos estan seteados por default, pero se pueden
	 * modificar.
	 * 
	 * @param numeroFila
	 */
	
	public void agregoEstiloFilaIntercalados(int numeroFila)
	{
//		if (getAgregoEstiloFila() == true)
//		{
//			getTable().getRowFormatter().addStyleName(numeroFila, getEstiloFilaUno());
//			setAgregoEstiloFila(false);
//		}
//		else
//		{
//			getTable().getRowFormatter().addStyleName(numeroFila, getEstiloFilaDos());
//			setAgregoEstiloFila(true);
//		}
		
		
		String styleName = numeroFila % 2 == 0 ? getEstiloFilaUno() : getEstiloFilaDos();
		
		getTable().getRowFormatter().addStyleName(numeroFila, styleName);
				
	}
	
	
	/**
	 * Si el tipo es PORT-IN y tiene solicitud de cambio de fecha
	 * Se pinta el fondo del campo Portacion de verde
	 * @param tipoPortabilidad
	 * @param cambioFecha
	 * @return true si cumple condiciones, para cambiar color de fondo a verde
	 */

	public boolean pintarPortacion(String tipoPortabilidad, boolean cambioFecha)
	{
		if ((tipoPortabilidad == "PORT-IN") & (cambioFecha == true))
		{
				return true;
		}
		else
		{
				return false;
		}
	}
	
	
	
	
	
	public void setTable(FlexTable table) {
		this.table = table;
	}


	
};



