package ar.com.cristal.creditos.common;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.util.DateUtil;
import ar.com.cristal.creditos.util.MathUtil;
import ar.com.cristal.creditos.util.NumberToLetterConverter;

public class DetalleFactura implements Detalle{

	private static final String STRING_VACIO = " ";

	private Logger log = Logger.getLogger(DetalleFactura.class);
	
	private String apellidoNombre;
	private Double montoTotalPagado = 0.0; 
	private Double capital;
	private Double interes;
	private String leyenda = null;
	private double montoCuotaSocial;
	
	
	private ServiceFacade serviceFacade;
	
	private Map<String, Object> detalleMap = null;

	


	/***
	 * Genera el detalle de la factura según la información pasada. En caso de existir bonificación (debe ser valor positivo), se descontará en los 
	 * intereses existentes.
	 * @param apellidoNombre
	 */
	public DetalleFactura(String apellidoNombre, double capital, double interes, double montoCuotaSocial, String leyenda, 
			double montoTotalPagado, ServiceFacade serviceFacade) {
		super();
		this.apellidoNombre = apellidoNombre;		
		this.capital = capital;
		this.interes = interes;
		this.serviceFacade = serviceFacade;
		this.montoTotalPagado = montoTotalPagado;
		this.montoCuotaSocial = montoCuotaSocial;
		
		//Calculo de concepto capital, interés y leyenda
		this.leyenda = leyenda;
		
	}


	public Map<String, Object> generarMap() throws Exception{
		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Generando mapa para factura");
		detalleMap = new HashMap<String, Object>();
		
		try {			
			//Fecha
			Calendar cal = DateUtil.createCalendar(serviceFacade.getFechaActual());
			detalleMap.put("dia", cal.get(Calendar.DAY_OF_MONTH));
			detalleMap.put("mes", cal.get(Calendar.MONTH) + 1);
			detalleMap.put("anno", cal.get(Calendar.YEAR));
			
			//Cliente
			detalleMap.put("apellidoNombre", apellidoNombre);
			
			//Concepto
			detalleMap.put("detalleCapital", armarDetalleCapital());
			detalleMap.put("detalleInteres", armarDetalleInteres());
			detalleMap.put("detalleCuotaSocial", armarDetalleCuotasSociales());
			detalleMap.put("leyenda", leyenda);
			
			//Resumen
			detalleMap.put("montoEnLetras", NumberToLetterConverter.convertNumberToLetter(montoTotalPagado));
			detalleMap.put("montoTotalPagado", MathUtil.doubleToString2Decimales(montoTotalPagado));
			
			
			
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " " + e.getMessage());
			throw e;
		}
		
		return detalleMap;
	}



	private Object armarDetalleCapital() {
		return "$" + MathUtil.doubleToString2Decimales(capital) + " por DEVOLUCIÓN DE CAPITAL";	
	}

	private Object armarDetalleInteres() {
		
		return "$" + MathUtil.doubleToString2Decimales(interes) + " por INTERÉS";	
	}
	
	private Object armarDetalleCuotasSociales() {
		
		
		if (montoCuotaSocial > 0)
			return "$" + MathUtil.doubleToString2Decimales(montoCuotaSocial) + " por CUOTA SOCIAL" ;	
		else 
			return STRING_VACIO;
	}






	




}
