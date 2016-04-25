/**
 * Copyright (C) 2011 Angelo Zerr <angelo.zerr@gmail.com> and Pascal Leclercq <pascal.leclercq@gmail.com>
 *
 * All rights reserved.
 *
 * Permission is hereby granted, free  of charge, to any person obtaining
 * a  copy  of this  software  and  associated  documentation files  (the
 * "Software"), to  deal in  the Software without  restriction, including
 * without limitation  the rights to  use, copy, modify,  merge, publish,
 * distribute,  sublicense, and/or sell  copies of  the Software,  and to
 * permit persons to whom the Software  is furnished to do so, subject to
 * the following conditions:
 *
 * The  above  copyright  notice  and  this permission  notice  shall  be
 * included in all copies or substantial portions of the Software.
 *
 * THE  SOFTWARE IS  PROVIDED  "AS  IS", WITHOUT  WARRANTY  OF ANY  KIND,
 * EXPRESS OR  IMPLIED, INCLUDING  BUT NOT LIMITED  TO THE  WARRANTIES OF
 * MERCHANTABILITY,    FITNESS    FOR    A   PARTICULAR    PURPOSE    AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE,  ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package ar.com.cristal.creditos.documentos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;

import ar.com.cristal.creditos.documentos.util.Template;
import ar.com.cristal.creditos.util.DescriptorDeAccesoTemplate;
import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;



public class GeneradorDocumento {
	
	Logger log = Logger.getLogger(GeneradorDocumento.class);
	
	@Autowired
	ServletContextAware servletContext;
	
	
	public OutputStream generarReporte(Template template) throws Exception {
		OutputStream out = null;

		log.warn("generarReporte(): Deprecado");
		try {
			// 1) Load ODT file by filling Velocity template engine and cache
			// it to the registry
			File file = new File(template.getNombreTemplate());
			String pa = file.getCanonicalPath();
					
			FileInputStream fs = new FileInputStream(template.getRealPathDocumentos() + template.getPathOrigen()+ template.getNombreTemplate());
			
				
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(
					fs, TemplateEngineKind.Velocity);

			// 2) Create context Java model
			IContext context = report.createContext();
			
			for(String key : template.valoresTemplate().keySet()){
				context.put(key,template.valoresTemplate().get(key));
			}
			
			Options options = Options.getTo(ConverterTypeTo.PDF).via(
					ConverterTypeVia.ITEXT);
			
			String fname= template.getContextRootName() + template.getPathDestino() + template.getNombreSalida() + "_" + new Date().getTime() + ".pdf";
			
			out = new FileOutputStream(new File(fname));
//			out = dat.getReporteAGenerarseStream();
			
			log.info("Generandose la notificacion con nombre de archivo " + fname);
			report.convert(context, options, out);
			out.close();
			fs.close();

		} catch (IOException e) {
			log.fatal("Generador de reportes (IOException): " + e.getMessage());
			throw e;
			
		} catch (XDocReportException e) {
			log.fatal("Generador de reportes (XDocReportException): " + e.getMessage());
			throw new Exception(e.getMessage());
		}
		

		return out;
	}
	
	
	
	
	
	public String generarReporte(DescriptorDeAccesoTemplate dat, Map<String,Object> map) throws Exception {
		
		log.info("Generandose Reporte Con Conversión");
		String fnameRet="";
		String nombreArchivo;
		OutputStream out = null;
		try {
					
			FileInputStream fs = new FileInputStream(dat.getRutaDondeEstaGuardadoElTemplate());
			
				
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(
					fs, TemplateEngineKind.Velocity);

			// 2) Create context Java model
			IContext context = report.createContext();
			
			for(String key : map.keySet()){
				context.put(key,map.get(key));
			}
			
			Options options = Options.getTo(ConverterTypeTo.PDF).via(
					ConverterTypeVia.ITEXT);

			//TODO: hacer posible la reutilización del outputstream que existe creado en dat y no crear siempre un new FileOutputStream
			nombreArchivo = dat.getNombreBaseDelArchivodeSalida()+ "_" 	+ new Date().getTime() + ".pdf";
			fnameRet= dat.getRutaDondeSeGuardaElArchivoSinNombreArchivo()  + nombreArchivo;
			out = new FileOutputStream(new File(fnameRet));
			
			
			log.info("Generandose la notificacion con nombre de archivo " + fnameRet);
			report.convert(context, options, out);
			out.close();			
			fs.close();

		} catch (IOException e) {
			log.fatal("Generador de reportes (IOException): " + e.getMessage());
			throw e;
			
		} catch (XDocReportException e) {
			log.fatal("Generador de reportes (XDocReportException)  " + e.getMessage());
			throw e;
		}
		


		return dat.getLinkInfoPopup().getUrlPathSinNombreArchivo() + nombreArchivo;
//		return dat.getLinkInfoPopup().getUtl() ;
	}
	
	
	/***
	 * Genera un recibo de pago. Reutiliza el output stream 
	 * @param dat
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public String generarReciboDePago(DescriptorDeAccesoTemplate dat, Map<String,Object> map) throws Exception {
		
		log.info("Generandose Reporte Con Conversion");
		String fnameRet="";
		String nombreArchivo;
		OutputStream out = null;
		try {
					
			FileInputStream fs = new FileInputStream(dat.getRutaDondeEstaGuardadoElTemplate());
			
				
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(
					fs, TemplateEngineKind.Velocity);

			// 2) Create context Java model
			IContext context = report.createContext();
			
			for(String key : map.keySet()){
				context.put(key,map.get(key));
			}
			
			Options options = Options.getTo(ConverterTypeTo.PDF).via(
					ConverterTypeVia.ITEXT);

			//TODO: hacer posible la reutilización del outputstream que existe creado en dat y no crear siempre un new FileOutputStream
			/*
			nombreArchivo = dat.getNombreBaseDelArchivodeSalida()+ "_" 	+ new Date().getTime() + ".pdf";
			fnameRet= dat.getRutaDondeSeGuardaElArchivoSinNombreArchivo()  + nombreArchivo;
			out = new FileOutputStream(new File(fnameRet));
			*/
			
			nombreArchivo = dat.getNombreArchivo();
			out = dat.getReporteAGenerarseStream();
			
			log.info("Generandose la notificacion con nombre de archivo " + fnameRet);
			report.convert(context, options, out);
			out.close();			
			fs.close();

		} catch (IOException e) {
			log.fatal("Generador de reportes (IOException): " + e.getMessage());
			throw e;
			
		} catch (XDocReportException e) {
			log.fatal("Generador de reportes (XDocReportException)  " + e.getMessage());
			out.close();
			throw e;
		}
		


		return dat.getLinkInfoPopup().getUrlPathSinNombreArchivo() + nombreArchivo;
//		return dat.getLinkInfoPopup().getUtl() ;
	}
	
	
	/***
	 * Nueva generación de cartas reemplaza a generarReporte()
	 * 
	 * @param dat
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public String generarCartas(DescriptorDeAccesoTemplate dat, Map<String,Object> map) throws Exception {
		
		log.info("Generandose Reporte Con Conversión");
		String fnameRet="";
		String nombreArchivo;
		OutputStream out = null;
		try {
					
			FileInputStream fs = new FileInputStream(dat.getRutaDondeEstaGuardadoElTemplate());
			
				
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(
					fs, TemplateEngineKind.Velocity);

			// 2) Create context Java model
			IContext context = report.createContext();
			
			for(String key : map.keySet()){
				context.put(key,map.get(key));
			}
			
			Options options = Options.getTo(ConverterTypeTo.PDF).via(
					ConverterTypeVia.ITEXT);

//			nombreArchivo = dat.getNombreBaseDelArchivodeSalida()+ "_" 	+ new Date().getTime() + ".pdf";
			nombreArchivo = dat.getNombreArchivo();
			fnameRet= dat.getRutaDondeSeGuardaElArchivoSinNombreArchivo()  + nombreArchivo;

//			out = new FileOutputStream(new File(fnameRet));
			out = dat.getReporteAGenerarseStream();
			
			
			log.info("Generandose la notificacion con nombre de archivo " + fnameRet);
			report.convert(context, options, out);
			out.close();			
			fs.close();

		} catch (IOException e) {
			log.fatal("Generador de reportes (IOException): " + e.getMessage());
			throw e;
			
		} catch (XDocReportException e) {
			log.fatal("Generador de reportes (XDocReportException)  " + e.getMessage());
			throw e;
		}
		


		return dat.getLinkInfoPopup().getUrlPathSinNombreArchivo() + nombreArchivo;
//		return dat.getLinkInfoPopup().getUtl() ;
	}
	

	
	public String  generarReporteSinConversion(DescriptorDeAccesoTemplate dat, Map<String, String> m) throws Exception{
		log.info("Generandose Reporte Sin Conversión");
		OutputStream out = null;

		String fnameRet="", nombreArchivo= dat.getNombreArchivo();
		try {
			// 1) Load ODT file by filling Velocity template engine and cache
			// it to the registry
//			File file = new File(template.getNombreTemplate());
//			String pa = file.getCanonicalPath();
					
			FileInputStream fs = new FileInputStream(dat.getRutaDondeEstaGuardadoElTemplate());

			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(
					fs, TemplateEngineKind.Velocity);

			// 2) Create context Java model
			IContext context = report.createContext();
			
			//Paso todos los valores al context que necesita el generador para hacer el reporte
			for(String key : m.keySet()){
				context.put(key,m.get(key));
			}

			fnameRet= dat.getRutaDondeSeGuardaElArchivoSinNombreArchivo()  + nombreArchivo;
			
			out = dat.getReporteAGenerarseStream();
						
			log.info("Generandose la notificacion con nombre de archivo " + fnameRet);
			report.process(context, dat.getReporteAGenerarseStream());
			out.close();
			fs.close();

		} catch (IOException e) {
			log.fatal("Generador de reportes (IOException): " + e.getMessage());
			throw e;
			
		} catch (XDocReportException e) {
			log.fatal("Generador de reportes (XDocReportException): " + e.getMessage());
			throw new Exception(e);
		}
		return dat.getLinkInfoPopup().getUtl();
	}

	
}
