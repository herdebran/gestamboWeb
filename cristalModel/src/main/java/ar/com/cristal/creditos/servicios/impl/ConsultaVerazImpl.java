package ar.com.cristal.creditos.servicios.impl;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.cristal.creditos.servicios.ServiceFacade;

/**
 * Se encarga de enviar un xml al servidor del veraz y calcula el score con la respuesta del mismo.
 * 
 * @author martin.mantovani
 *
 */
@Service("consultaVerazService")
public class ConsultaVerazImpl {
	
	private static Logger log = Logger.getLogger(ConsultaVerazImpl.class);
	
	
	
	@Autowired
	private ServiceFacade serviceFacade;
	
	HttpURLConnection httpConn;
	
	/**
	 * Dado un xml de respuesta con datos válidos, obtiene el score.
	 * @param respData
	 * @return el score contenido en el xml validado.
	 */
	public Integer getScore(String respData){
		Integer score = null;
		if (datosCorrectos(respData).equals("Sin Error")){
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Obteniendo Score");
			boolean posicionScore = false;
			String[] variables = respData.split("<variable>");
			int indiceVeraz = 0;
			for (String v1: variables){
		    	if (v1.contains("score_veraz")){
		    		posicionScore =  true;
		    		
		    	}
	    	indiceVeraz++;
	    	if (posicionScore){
	    	String var = variables[indiceVeraz-1];
		    String[] v = var.split("<");
		    String[] b = v[5].split("<!");
		    String[] c = b[0].split("CDATA");
		    String d = c[1].toString();
		    String e = d.substring(d.indexOf("[")+1, d.indexOf("]"));
		    score = new Integer(e);
	    	}
		}
		
		
		}else{
			score = -1;
		}
		return score;
	}
	
	/**
	 * Dado el xml de respuesta del sevidor verifica si hay respuesta de errores en la misma.
	 * 
	 * @param xml
	 * @return true si el archivo no contiene errores, false en caso contrario.
	 */
	private String datosCorrectos(String xml){
		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - Verificando si el xml recibido por el servidor contiene codigos de error...");
		String resultado = "";
		String[] variables = xml.split("<variable>");
		 for (String v1: variables){
			 if (v1.contains("<mensajeError></mensajeError>") || v1.equals("")){
				  resultado = "Sin Error";
				  break;
			 }else{
				 resultado = calcularError(v1);
			 }
		 }
		
		return resultado;
		
	}
	
	private String calcularError(String xml){
		if (!xml.equals("")){
			String[] descripcion = xml.split("<mensajeError>");
			log.info(descripcion[1].substring(0, descripcion[1].indexOf("<")));
		}
		return "";
	}

	/**
	 *  Envía la consulta en formato xml al sitio. Debe esepecificarse el usuario y el dni que se incluye en la misma.
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public void uploadToServer(String apellidoNombreCliente, String sexoCliente, String dni) throws Exception  {
		try {
			
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - Inicio" );
			String usuarioVeraz = serviceFacade.getProperty("usuario.veraz");
			String password = serviceFacade.getProperty("pass.veraz");
			String urlServer = serviceFacade.getProperty("url.veraz");;
			
			validarDNI(dni);
	        OutputStream os;
	        log.info("-----------------------------------------------------------------");
	        log.info("Enviando xml...");
	        
	        String xml = "par_xml=<?xml version='1.0' encoding='ISO-8859-1' ?><mensaje><identificador><userlogon><matriz>C04503</matriz><usuario>"+usuarioVeraz+"</usuario><password>"+ password + "</password></userlogon><medio>HTML</medio><formatoInforme>T</formatoInforme><reenvio/><producto>Experto</producto><lote><sectorVeraz>F0</sectorVeraz><sucursalVeraz>0</sucursalVeraz><cliente>TRA-999845721</cliente><fechaHora>2006-08-02T16:22:03.099</fechaHora></lote></identificador><consulta><integrantes>1</integrantes><integrante valor='1'><nombre>" + apellidoNombreCliente + "</nombre><sexo>" + sexoCliente + "</sexo><documento>"+dni+"</documento></integrante></consulta></mensaje>";
		    log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " XML de consulta: " + xml);
	        URL url;
			url = new URL(urlServer);
		    httpConn= (HttpURLConnection) url.openConnection();
		    httpConn.setDoOutput(true);
		    os = httpConn.getOutputStream();
		    BufferedWriter osw = new BufferedWriter(new OutputStreamWriter(os));
		    osw.write(xml);
		    osw.flush();
		    osw.close();
		
		}catch(DNIException e){
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + "  " + e.getMessage(), e);
			throw new DNIException();
		}catch (MalformedURLException e){
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " " + e.getMessage(), e);
			throw new Exception(e);
		}catch (IOException e){
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " " + e.getMessage(), e);
			throw new Exception(e);
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " " + e.getMessage(), e);
			throw new Exception(e.getMessage(), e);
		}

    }

	private boolean validarDNI(String DNI) throws DNIException {
		boolean resultado=true;

		// Debe tener DNI
		if (DNI.equals("")){
			resultado = false;
			throw new DNIException();
		}
		return resultado;
	}
	
	@SuppressWarnings("serial")
	public class DNIException extends Exception{
		public void mensaje(){
			log.info("-----------------------------------------------------------------");
			log.info("Debe especificar el DNI.");
			log.info("-----------------------------------------------------------------");
			log.info(" ");						
		}
		
	}
	
	@SuppressWarnings("serial")
	public class VerazException extends Exception{
		public VerazException(IOException e) {
			// TODO Auto-generated constructor stub
		}

		public String getMessage(){
			return "Error al intentar obtener Score en Veraz, por favor vuelva a intentar";
		}
		
		
	}
/**
 * Obtiene la respuesta del servidor en formato string.
 * @return
 * @throws MalformedURLException
 * @throws IOException
 * @throws VerazException 
 */

 public String downloadFromServer()
            throws MalformedURLException, IOException, VerazException {
	 	if (httpConn == null){
	 		return "";
	 	}else{
	 		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Recibiendo datos del servidor...");
	        String returnString = null;
	        StringBuffer sb = null;
	        BufferedInputStream in;
	        in = new BufferedInputStream(httpConn.getInputStream());
	
	        int x = 0;
	        sb = new StringBuffer();
	        try {
				while ((x = in.read()) != -1) {
				    sb.append((char) x);
				}
			} catch (IOException e) {			
				throw new VerazException(e);
			}
	        in.close();
	        in = null;
	        if (httpConn != null) {
	            httpConn.disconnect();
	        }
	
	        returnString = sb.toString();
	
	        return returnString;
	 		}
    }
 
 
 	public Integer getScoreVeraz(String apellidoNombreCliente, String sexoCliente, String dni) throws Exception{
 		
 		uploadToServer(apellidoNombreCliente, sexoCliente,dni);
 	
 		Integer score = getScore(downloadFromServer());
	

 		return score;
 		
 	}
		 
}
