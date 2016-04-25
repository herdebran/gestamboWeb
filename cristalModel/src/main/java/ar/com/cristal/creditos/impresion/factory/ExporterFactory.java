package ar.com.cristal.creditos.impresion.factory;

import net.sf.jasperreports.engine.JRException;

import org.apache.log4j.Logger;

import ar.com.cristal.creditos.common.Constantes;
import ar.com.cristal.creditos.impresion.comunes.IReportExporter;
import ar.com.cristal.creditos.impresion.exporters.PdfExporter;
import ar.com.cristal.creditos.impresion.exporters.XlsExporter;


public class ExporterFactory {

	
	private static volatile ExporterFactory INSTANCE;
	private Logger log = Logger.getLogger(ExporterFactory.class);
	
	private ExporterFactory(){
        
    }

	/**
     * retorna la instancia del factory (Singleton)
     * @return
     */
    public static ExporterFactory getInstance() {

		synchronized (ExporterFactory.class) {
			if (INSTANCE == null) {
				INSTANCE = new ExporterFactory();
			}
		}
		return INSTANCE;
	}


    
	 /**
	 * obtiene una instacia de un Reporte de (TipoExporter) pasando como paramtro el tipo de reporte a exportar        
	 * @return
	 */
	public IReportExporter getExporterPorTipo(String tipoRepo)
			throws JRException {
		IReportExporter tr = null;
		try {
			if (Constantes.REPORTE_EXPORTACION_XLS.equals(tipoRepo.toUpperCase()))
				tr = new XlsExporter();
			else if (Constantes.REPORTE_EXPORTACION_PDF.equals(tipoRepo.toUpperCase())){
				tr = new PdfExporter();
			} else {
				tr = new XlsExporter();
			}

		} catch (Exception e) {
			log.error("Error obteniendo los exporters: " + e.getMessage());
			throw new JRException(e.getMessage());
		}
		return tr;
	}
   
   
   
   
   
}