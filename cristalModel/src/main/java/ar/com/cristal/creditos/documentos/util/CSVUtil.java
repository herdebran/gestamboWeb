package ar.com.cristal.creditos.documentos.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.supercsv.io.CsvMapWriter;
import org.supercsv.io.ICsvMapWriter;
import org.supercsv.prefs.CsvPreference;

import ar.com.cristal.creditos.entity.commons.Efectividad;


public class CSVUtil {
	private static Logger log = Logger.getLogger(CSVUtil.class);

	static HashMap<String, ? super Object> data;
		
	public static void generarReporte(String[] header, Map<String,List<Efectividad>> datos, FileWriter fileWriter) throws Exception{
		ICsvMapWriter writer = null;
		  try {
			  Date d = new Date();
			  
			  writer = new CsvMapWriter(fileWriter, CsvPreference.EXCEL_PREFERENCE);
			  //por cada uno de los datos de efectividad tengo que cargar el hash.
			  
			  writer.writeHeader(header);
			  
			  for (String k : datos.keySet()) {
				  writer.writeHeader(k);
				  
				  try {
					for (Efectividad e : datos.get(k)) {
						  data = new HashMap<String, Object>();
						  data.put(header[0], e.getNombre());
						  data.put(header[1], e.getCantidadLlamadasMorosidad());
					      data.put(header[2], e.getCantidadLlamadasMorosidadEfectiva());
					      data.put(header[3], e.getPorcentajeMorosidad());
					      data.put(header[4], e.getCantidadLlamadasColocacion());
					      data.put(header[5], e.getCantidadLlamadasColocacionEfectiva());
					      data.put(header[6], e.getPorcentajeColocacion());
					      data.put(header[7], e.getCantidadLlamadasPrejudicial());
					      data.put(header[8], e.getCantidadLlamadasPrejudicialEfectiva());
					      data.put(header[9], e.getPorcentajePrejudicial());
					      
					      writer.write(data, header);
					}
				} catch (Exception e) {
					log.error("Error al escribir linea en reporte de efectividad: " + e.getMessage());
					 writer.close();
					throw new Exception("Error al generar reporte de efectividad", e);
				}
				  
			  }
			  
			  
		      writer.close();
		    } catch (IOException e) {		    	 
		    	try {
					writer.close();
				} catch (Exception e1) {
					log.error("Error al cerrar writer: " + e1.getMessage());
					throw new Exception("Error al generar reporte de efectividad", e1);
				}
		    	throw new Exception("Error al generar reporte de efectividad", e);
			} 
	}
}
