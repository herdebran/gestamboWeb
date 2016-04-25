package ar.com.cristal.creditos.common;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.util.DateUtil;
import ar.com.cristal.creditos.util.MathUtil;
import ar.com.cristal.creditos.util.NumberToLetterConverter;



public class DetalleRecibo implements Detalle{

	private static final String STRING_VACIO = " ";

	private Logger log = Logger.getLogger(DetalleRecibo.class);
	
	private String apellidoNombre;
	private Double montoTotalPagado;
	private Long nroCredito;
	private Integer nroRecibo; 
	private Double montoBonificacion;
	private List<ItemRecibo> itemsCuota;
	private List<ItemRecibo> itemsCuotaSocial;
	
	private ServiceFacade serviceFacade;
	
	private Map<String, Object> detalleMap = null;
	
	
	


	/***
	 * La bonificación no es utilizada para realizar cálculo alguno. montoTotalPagado debería tener aplicada la bonificación 
	 * indicada en el atributo correspondiente.
	 * @param apellidoNombre
	 * @param montoTotalPagado
	 * @param nroCredito
	 * @param nroRecibo
	 * @param bonificacion
	 * @param itemsCuota
	 * @param itemsCuotaSocial
	 * @param serviceFacade
	 */
	public DetalleRecibo(String apellidoNombre, Double montoTotalPagado,
			Long nroCredito, Integer nroRecibo, Double bonificacion, List<ItemRecibo> itemsCuota,
			List<ItemRecibo> itemsCuotaSocial, ServiceFacade serviceFacade) {
		super();
		this.apellidoNombre = apellidoNombre;
		this.montoTotalPagado = montoTotalPagado;
		this.nroCredito = nroCredito;
		this.nroRecibo = nroRecibo;
		this.itemsCuota = itemsCuota;
		this.itemsCuotaSocial = itemsCuotaSocial;
		this.serviceFacade = serviceFacade;
		this.montoBonificacion = bonificacion;
	}




	public Map<String, Object> generarMap() throws Exception{
		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Generando mapa para recibo");
		detalleMap = new HashMap<String, Object>();
		
		try {
			detalleMap.put("detalleCuotas", armarDetalle("cuota/s", itemsCuota));
			detalleMap.put("detalleCuotaSocial", armarDetalle("cuota social", itemsCuotaSocial));
			detalleMap.put("apellidoNombre", apellidoNombre);
			
			montoTotalPagado = MathUtil.redondearADosDecimales(montoTotalPagado);
			detalleMap.put("montoCuotaEnLetras", NumberToLetterConverter.convertNumberToLetter(montoTotalPagado));
			detalleMap.put("fecha", DateUtil.getDateTime(DateUtil.getDefaultDatePattern(), new Date()));
			detalleMap.put("numeroCredito", nroCredito);
			detalleMap.put("montoTotalPagado", MathUtil.doubleToString2Decimales(montoTotalPagado));
			detalleMap.put("numeroRecibo", nroRecibo);
			detalleMap.put("detalleBonificacion", obtenerDetalleBonificacion());
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " " + e.getMessage());
			throw e;
		}
		
		return detalleMap;
	}




	private Object obtenerDetalleBonificacion() {
		String detalleBonificacion = "";
		if (montoBonificacion > 0)
			montoBonificacion = MathUtil.redondearADosDecimales(montoBonificacion);
			detalleBonificacion = "* Bonificación " +  NumberToLetterConverter.convertNumberToLetter(montoBonificacion) + " (-$" + MathUtil.doubleToString2Decimales(montoBonificacion) + ")";
		return detalleBonificacion;
	}




	private Object armarDetalle(String item, List<ItemRecibo> items) {
		double monto = calcularMontoParcial(items);
		
		if (monto > 0)
			return "Son " + NumberToLetterConverter.convertNumberToLetter(monto) + " ($" + MathUtil.doubleToString2Decimales(monto) + ") en concepto de " + item + ": " + obtenerConcepto(items) ;	
		else 
			return STRING_VACIO;
	}





	private double calcularMontoParcial(List<ItemRecibo> items) {
		double suma = 0.0;
		for (ItemRecibo itemRecibo : items) {
			suma += itemRecibo.getMonto();
		}
		
		suma = MathUtil.redondearADosDecimales(suma);
		
		return suma;
	}





	private String obtenerConcepto(List<ItemRecibo> items) {
		String concepto = "";
		if (items.size() > 0) {
			int tope = items.size() - 1;
			for (int i = 0; i < tope; i++) {
				concepto = concepto + items.get(i).getConceptoPago() + ", ";
			}
			
			concepto = concepto + items.get(tope).getConceptoPago();
		} else 
			concepto = STRING_VACIO;
		
		return concepto;
	}




	public Double getMontoBonificacion() {
		return montoBonificacion;
	}




	public void setMontoBonificacion(Double montoBonificacion) {
		this.montoBonificacion = montoBonificacion;
	}
}
