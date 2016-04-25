package ar.com.cristal.creditos.impresion.exporters;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ar.com.cristal.creditos.common.CristalProperties;
import ar.com.cristal.creditos.common.LinkInfoPopup;
import ar.com.cristal.creditos.impresion.comunes.IReportExporter;
import ar.com.cristal.creditos.util.DescriptorDeAccesoTemplate;



public class XlsExporter  implements IReportExporter{

    private static String EXPORTER_TYPE = "xls";
    private String pathNameDesignJrxml;
    private String pathNameDesignJasper;
    private Log log = LogFactory.getLog(this.getClass());
    
    private CristalProperties cristalProperties = CristalProperties.getInstance();
    
    public XlsExporter(){
    	
    }

    
	public static String getEXPORTER_TYPE() {
		return EXPORTER_TYPE;
	}
	
    public String getPathNameDesignJrxml() {
		return pathNameDesignJrxml;
	}


	public void setPathNameDesignJrxml(String pathNameDesignJrxml) {
		this.pathNameDesignJrxml = pathNameDesignJrxml;
	}


	public String getPathNameDesignJasper() {
		return pathNameDesignJasper;
	}


	public void setPathNameDesignJasper(String pathNameDesignJasper) {
		this.pathNameDesignJasper = pathNameDesignJasper;
	}


	
	public LinkInfoPopup exportar(DescriptorDeAccesoTemplate dt, Map<String, Object> hashMap, Collection<Object> data) throws Exception {
		
		String filenameEntrada = dt.getRutaDondeEstaGuardadoElTemplate();
		
		InputStream jasperReportInputStream=null;
		JasperReport jasperReport;

		try {
			log.info("XLSExpoerter: obteniendo template " + filenameEntrada);
			jasperReportInputStream = new FileInputStream(filenameEntrada);


			jasperReport = (JasperReport) JRLoader.loadObject(jasperReportInputStream);
			log.info("se obtubo ok el template " + filenameEntrada);
						
			log.info("XLSExpoerter: filling datos en template ");
			JasperPrint jasperPrint=null;
			try{
				JRBeanCollectionDataSource dataArray = new JRBeanCollectionDataSource(data);				
				jasperPrint = JasperFillManager.fillReport(jasperReport ,hashMap, dataArray);	
			}catch(Exception e){
				log.error("Eror en el fillReport" + e.getMessage());
				throw e;
			}
			
			ByteArrayOutputStream outputByteArray = new ByteArrayOutputStream();
			JRXlsExporter exportador = new JRXlsExporter();
			
			exportador.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exportador.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
//			exportador.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, filenameSalida);
			exportador.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, outputByteArray);
			exportador.setParameter(JRExporterParameter.IGNORE_PAGE_MARGINS, true);
			exportador.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, true);
			exportador.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, true);
			exportador.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, false);
			exportador.setParameter(JRXlsAbstractExporterParameter.IS_IGNORE_CELL_BORDER, false);
			exportador.setParameter(JRXlsAbstractExporterParameter.IS_COLLAPSE_ROW_SPAN, false);
			exportador.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,true);
			exportador.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,true);
			exportador.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,true);
			exportador.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE,true);
			
			exportador.exportReport();
			
			
			try {
				 log.info("Se guardara el reporte generado en disco...");
				 dt.getReporteAGenerarseStream().write(outputByteArray.toByteArray());
				 log.info("reporte generado en disco...ok");
				 dt.getReporteAGenerarseStream().close();
			} catch (IOException e) {
				log.error("Error io: " + e.getMessage());
				throw e;
			}
			
			log.info("XLSExpoerter: exportado...Ok");
		} catch (JRException e) {
			log.error("error generando el archivo jasper");			
			throw new Exception("Ocurrió un error jasper generando el reporte " , e);
		} catch (FileNotFoundException e) {
			log.error("Error FileNotFoundException generando el archivo jasper: " + e.getMessage());		
			throw new Exception("Ocurrió un error generando el reporte ", e); 
		} catch (Exception e){
			log.error("Error Exception generando el archivo jasper: " + e.getMessage(), e);		
			throw new Exception("Ocurrió un error generando el reporte ", e);
		}
		
		
		return dt.getLinkInfoPopup();
	}

	@Override
	public LinkInfoPopup exportar(DescriptorDeAccesoTemplate dt, Map<String, Object> hashMap, Connection c) throws Exception {
		
		String filenameEntrada = dt.getRutaDondeEstaGuardadoElTemplate();
		
		InputStream jasperReportInputStream=null;
		JasperReport jasperReport;

		try {
			log.info("XLSExpoerter: obteniendo template " + filenameEntrada);
			jasperReportInputStream = new FileInputStream(filenameEntrada);

			
			

			jasperReport = (JasperReport) JRLoader.loadObject(jasperReportInputStream);
			log.info("Se obtuvo el template " + filenameEntrada);
			
//			jasperReport = null;
//			try {
//				log.info("compilando el template");
//				jasperReport = JasperCompileManager.compileReport(filenameEntrada);
//			}catch (JRException t){
//				log.error("error al compilar el template" + t.getMessage());
//				throw t;
//			}
//			
			
			log.info("XLSExpoerter: filling datos en template ");
			JasperPrint jasperPrint=null;
			try{				
				jasperPrint = JasperFillManager.fillReport(jasperReport ,hashMap, c);	
			}catch(Exception e){
				log.error("Error en el fillReport" + e.getMessage());
				throw e;
			}
			
			
			log.debug("Configurando exportador...");
			ByteArrayOutputStream outputByteArray = new ByteArrayOutputStream();
			JRXlsExporter exportador = new JRXlsExporter();
			
			exportador.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exportador.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
//			exportador.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, filenameSalida);
			exportador.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, outputByteArray);
			exportador.setParameter(JRExporterParameter.IGNORE_PAGE_MARGINS, true);
			exportador.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, true);
			exportador.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, true);
			exportador.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, false);
			exportador.setParameter(JRXlsAbstractExporterParameter.IS_IGNORE_CELL_BORDER, false);
			exportador.setParameter(JRXlsAbstractExporterParameter.IS_COLLAPSE_ROW_SPAN, false);
			exportador.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,true);
			exportador.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,true);
			exportador.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,true);
			exportador.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE,true);
			
			exportador.exportReport();
			
			
			try {
				 log.info("Se guardara el reporte generado en disco...");
				 dt.getReporteAGenerarseStream().write(outputByteArray.toByteArray());
				 log.info("reporte generado en disco...ok");
				 dt.getReporteAGenerarseStream().close();
			} catch (IOException e) {
				log.error("Error io: " + e.getMessage());
				throw e;
			}
			
			log.info("XLSExporter: exportado...Ok");
		} catch (JRException e) {
			log.error("error generando el archivo jasper");			
			throw new Exception("Ocurrió un error jasper generando el reporte " , e);
		} catch (FileNotFoundException e) {
			log.error("Error FileNotFoundException generando el archivo jasper: " + e.getMessage());		
			throw new Exception("Ocurrió un error generando el reporte ", e); 
		} catch (Exception e) {
			log.error("Error FileNotFoundException generando el archivo jasper: " + e.getMessage());		
			throw new Exception("Ocurrió un error generando el reporte ", e); 
		} catch (Throwable t) {
			log.error("Error FileNotFoundException generando el archivo jasper: " + t.getMessage(), t);		
			throw new Exception("Ocurrió un error al generar el reporte");
		}
		
		return dt.getLinkInfoPopup();
	}


	


}

