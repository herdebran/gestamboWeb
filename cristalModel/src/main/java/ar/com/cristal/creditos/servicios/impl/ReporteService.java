package ar.com.cristal.creditos.servicios.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.cristal.creditos.common.LinkInfoPopup;
import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.documentos.GeneradorDocumento;
import ar.com.cristal.creditos.documentos.util.Template;
import ar.com.cristal.creditos.servicios.ImpresionService;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.util.DateUtil;
import ar.com.cristal.creditos.util.DescriptorDeAccesoTemplate;

@Service("reporteService")
public class ReporteService {
	
	private final int COLUMNA_CANTIDAD_CLIENTES = 0;
	private final int COLUMNA_CANTIDAD_LLAMADAS = 1;
	private final int COLUMNA_CANTIDAD_LLAMADAS_EFECTIVAS = 2;
	private final int COLUMNA_OPERADOR = 3;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ServiceFacade serviceFacade;
	
	@Autowired
	private ImpresionService impresionService;
	
	private static final String queryEfectividadPorSucursal = "select count(l.cantidadLlamadas), sum(l.cantidadLlamadas) as llamados, sum(l.llamadoExitoso) as efectivo , " + 
					" concat(u.apellido, ', ' , u.nombre, ' (', u.id, ')') as Operador" + 
					" from Llamado as l " +
					" inner join l.tipoLlamada as t" +
					" inner join l.operador as u" +
					" inner join l.operador.sucursal as s " +
					" where t.tipo = 'CALLCENTER_ASIGNACION_LLAMADA' " +
					" and codigo in (:tipoLlamadaCodigo)" +
					" and (resuelto <> 0) " +
					" and s.id = :sucursalId " +
					" and date(l.fechaAsignacion) > date(:fechaDesde) " +
					" and date(l.fechaAsignacion) <= date(:fechaHasta) " +
					" group by u.apellido, u.nombre "; 

			

	private Logger log = Logger.getLogger(ReporteService.class);

	
	@Autowired
	protected GenericDao genericDao;

	
	public void generarReporte(Template template) throws Exception{
		
		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() +  " Generando Reporte");
		GeneradorDocumento generador = new GeneradorDocumento();
					
		generador.generarReporte(template);
		
		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() +  " Reporte generado: " + template.getNombreSalida());
		
	}
	
	public String generarReporteSinConversion(DescriptorDeAccesoTemplate dat, Map<String, String> m) throws Exception{
		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() +  " Generando Reporte");
		GeneradorDocumento generador = new GeneradorDocumento();
		
		return generador.generarReporteSinConversion(dat,m);
			
	}
	

	
	
	/**
	 * genera la impresion desde cobranzas para muchas cuotas pagas dle mismo credito
	 */
	public String generarReciboDePagoDeCuotasCobranzas(Map<String, Object> m, DescriptorDeAccesoTemplate dat)throws Exception{
		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() +  " generarReciboDePagoDeCuotasCobranzas()" );
		GeneradorDocumento gd = new GeneradorDocumento();
		return gd.generarReciboDePago(dat,m);
		
	}


	/**
	 * En el momento de realizar el pago exitoso se obtiene la ultima llamada realizada por el mismo motivo. 
	 * La llamada se establece como exitosa y se actualizan los cambios.
	 * 
	 * @param credito
	 * @param smotivo 
	 * @throws Exception 
	 */
//	public void calculoEfectividad(Credito credito) throws Exception {
//
//	}
	/***
	 * Genera reporte de morosidad 1 o 2 con monto de deuda
	 * @param nombreReporte
	 * @param tipoReporte: MOROSO_1 || MOROSO_2 
	 * @return
	 * @throws Exception
	 */
	public LinkInfoPopup generarReporteMorosidad(String nombreReporte, String tipoReporte) throws Exception{
		LinkInfoPopup link = null;
		DescriptorDeAccesoTemplate dat = null;
		
		dat = serviceFacade.getTemplateManagerService()
				.obtenerDatosDeAccesoByNombreTemplateCodigoAreaCodigoReporte(nombreReporte, "COBRANZAS", tipoReporte);
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		List<Object> clientes = new ArrayList<Object>();
		
		
		params.put("condicionMorosidad", tipoReporte);
		params.put("fecha", DateUtil.getString(new Date()));
		
		link = impresionService.imprimirDocumento(dat, params, clientes, "xls"); 
		return link;
	}



}

	
