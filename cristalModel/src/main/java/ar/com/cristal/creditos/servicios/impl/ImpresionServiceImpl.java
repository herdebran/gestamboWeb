package ar.com.cristal.creditos.servicios.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.cristal.creditos.common.Constantes;
import ar.com.cristal.creditos.common.LinkInfoPopup;
import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.entity.creditos.Credito;
import ar.com.cristal.creditos.entity.reportes.TipoReporte;
import ar.com.cristal.creditos.impresion.comunes.IReportExporter;
import ar.com.cristal.creditos.impresion.factory.ExporterFactory;
import ar.com.cristal.creditos.servicios.ImpresionService;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.util.DescriptorDeAccesoTemplate;

/**
 * Implementacion del servicio de impresion.
 * @author Guillermo
 *
 */
@Service("impresionService")
public class ImpresionServiceImpl implements ImpresionService {

	private Logger log = Logger.getLogger(ImpresionServiceImpl.class);
	
	@Autowired
	private GenericDao genericDao;
	
	@Autowired
	private ServiceFacade serviceFacade;
	
	/**
	 * Imprime el documento especificado en DatosTemplate con los hashMap datos.
	 * @return: el fullpath de donde esta y como se llama el documento.
	 */
	public LinkInfoPopup imprimirDocumento(DescriptorDeAccesoTemplate dt, Map<String, Object> hashMap , Collection<Object> data) throws Exception {
		
		try {
			ExporterFactory factory = ExporterFactory.getInstance();

			IReportExporter exporter = factory.getExporterPorTipo(Constantes.REPORTE_EXPORTACION_XLS);
			LinkInfoPopup ip  = exporter.exportar(dt, hashMap, data);
			
			return ip;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " imprimirDocumento(): " + e.getMessage());
			throw e;
		}
	}
	
	/**
	 * Imprime el documento especificado en DatosTemplate con los hashMap datos.
	 * @return: el fullpath de donde esta y como se llama el documento.
	 */
	public LinkInfoPopup imprimirDocumento(DescriptorDeAccesoTemplate dt, Map<String, Object> hashMap , 
			Collection<Object> data, String formatoDocumento) throws Exception {
		
		try {
			ExporterFactory factory = ExporterFactory.getInstance();

			IReportExporter exporter = factory.getExporterPorTipo(formatoDocumento);
			LinkInfoPopup ip  = exporter.exportar(dt, hashMap, data);
			
			return ip;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " imprimirDocumento(): " + e.getMessage());
			throw e;
		}
	}
	
	private Integer obtenerCantidadCreditosByClienteId(Long idCliente) throws Exception {
		return serviceFacade.getCreditosService().obtenerCreditosByClientId(idCliente).size();
	}

	
	/***
	 * Requiere que el número de cuota sea distinto de vacío o nulo.
	 * @param credito
	 * @param nroCuota
	 * @return Devuelve la última respuesta del banco
	 * @throws Exception
	 */
	private String obtenerComprotamiento(Credito credito) throws Exception{
		
		//TODO: convertir código de banco a 
	    String resultado = "";
	    
	    try {
	    	//Ultimas respuestas registradas ordenadas por fecha de envío al banco
	    	String stringQuery = "Select codigoRespuestaBanco " +
	    			"from Aux_disco ad inner join Cuota c on ad.cuota_id = c.id " +
	    			"where c.estado <> 'PAGA' and " +
	    			"c.credito_id = :credito_id and " +
	    			"codigoRespuestaBanco is not null order by fechaEnvio desc limit 1";
			
			
			SQLQuery ultimasRespuestaRegistrada = serviceFacade
					.createSQLQuery(stringQuery);
			
			ultimasRespuestaRegistrada.setLong("credito_id", credito.getId());
			
			@SuppressWarnings("unchecked")
			List<String> respuestas = (List<String>) ultimasRespuestaRegistrada.list();
			
			if (!respuestas.isEmpty())
				resultado = respuestas.get(0);
		} catch (Exception e) {
			log.warn("creditoId: " + credito.getId());
			log.warn("Debería haber habido un resultado: " + e.getMessage(), e);
			//No se arroja la excepcion intencionalmente
		}
	    

		
		
	    
	    
		
	    return resultado;

	}
	
	/***
	 * Solo para test
	 * @param c
	 * @param nroCuota
	 * @return
	 * @throws Exception 
	 */
	public String comportamientoTest(Credito c, String nroCuota) throws Exception{
		return obtenerComprotamiento(c);
	    
	}

	
	private boolean necesitaProcesamientoEspecial(TipoReporte tipoReporte){
		return tipoReporte.getCodigoReporte().equalsIgnoreCase(Constantes.LEGALES) || tipoReporte.getCodigoReporte().equalsIgnoreCase(Constantes.PREJUDICIAL);
	}

	@Override
	public LinkInfoPopup imprimirDocumento(DescriptorDeAccesoTemplate dt,
			Map<String, Object> hashMap, TipoReporte tipoReporte)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}	
	

}
