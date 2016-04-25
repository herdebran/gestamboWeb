package ar.com.cristal.creditos.servicios.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.cristal.creditos.common.LinkInfoPopup;
import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.documentos.util.DatosTemplate;
import ar.com.cristal.creditos.servicios.ComunesService;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.servicios.TemplateManagerService;
import ar.com.cristal.creditos.util.DateUtil;
import ar.com.cristal.creditos.util.DescriptorDeAccesoTemplate;


/**
 * Gestiona la informacion referente a los template para la generacion de reportes.
 * Resuelve los path de obtencion y guardado de los reportes generados en funcion de
 * distintos parametros y para distintas tecnologias(jasper, openSagres, etc)
 * @author Guillermo
 *
 */

@Service("templateManager")
public class TemplateManagerServiceImpl implements TemplateManagerService{

	private Logger log = Logger.getLogger(TemplateManagerServiceImpl.class);
	@Autowired
	protected GenericDao genericDao;
	@Autowired
	private ComunesService comunesService;
	@Autowired
	private ServiceFacade serviceFacade;

		/**
		 * Retorna el path completo con nombre de archivo de donde se hara el inputStream del template
		 * @param nombreArchivo
		 * @param extencion
		 * @return
		 * @throws Exception
		 */
		public String obtenerFullPathLecturaDeTemplatebyNombreArchivo(String nombreArchivo, String extencion)
				throws Exception {
			
		DatosTemplate dt = comunesService
				.obtenerDatosTemplateByNombreTemplateYExtencion(nombreArchivo,
						extencion);

		return dt.getPathBasicoDocumentos().trim()
				+ dt.getDirectorioOrigen().trim()
				+ dt.getNombreTemplate().trim();
	}

	
	/**
	 * Retorna el path completo con nombre de archivo en donde se debe guardar el archivo indicado x parametro.
	 * se guardara adentro de el contexto de la aplicacion para descargarlo por url.
	 */
	public String obtenerFullPathParaGuardarbyNombreArchivo(String nombreArchivo, String extencion)
			throws Exception {
			
		DatosTemplate dt = comunesService
				.obtenerDatosTemplateByNombreTemplateYExtencion(nombreArchivo,
						extencion);

		return dt.getContextRootDirFullpath().trim()
				+ dt.getDirectorioDestino().trim()
				+ dt.getNombreArchivoSalida().trim();
	}
	
	
	
	/**
	 * obtiene el fileOutputStream apuntado a el path configurado en la base para los el nombreArchivo y extencion pasados. 
	 */
	public FileOutputStream obtenerOutputStreamReporteByNombreArchivo(String nombreArchivo, String extencion) throws Exception{
				FileOutputStream outputfile = null;
				String fname = "";
				try {
					fname = this.obtenerFullPathParaGuardarbyNombreArchivo(nombreArchivo, extencion);
					outputfile = new FileOutputStream(new File(fname));
				} catch (IOException e) {
					log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Error al intentar generar el archivo " + fname);
				}
			
		return outputfile;
	}
	
	/**
	 * Genera el bean que contiene los 3 datos escenciales en la generacion de archivos
	 * El output stream por medio de el que se generará el archivo, el LinkInfoPopup con el 
	 * path de lectura y el label del link y el path donde esta guardado el archivo
	 * @param nombreArchivo
	 * @param extension
	 * @return
	 * @throws Exception
	 */
	public DescriptorDeAccesoTemplate obtenerDatosDeAccesoByNombreTemplateYExtensionSalida(String nombreArchivo, String extension) throws Exception{
					
					DescriptorDeAccesoTemplate dat = new DescriptorDeAccesoTemplate();
				
					DatosTemplate dt = comunesService
							.obtenerDatosTemplateByNombreTemplateYExtencion(nombreArchivo,
									extension);
					//path que contiene los templates
					if(dt==null){
						log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " No se encontro ningún template " + nombreArchivo + " con archivo de salida de extension: " + extension);
						throw new Exception("Error obteniendo template: No se encontro ningún template " + nombreArchivo + " con archivo de salida de extension: " + extension);
					}
					
					//path de directorio que contiene los reportes generados
					String dirPath = dt.getContextRootDirFullpath().trim()
							+ dt.getDirectorioDestino().trim();
					if("".equals(extension)){
						extension =  dt.getExtencionDefault();
					}
					
					Calendar fecha = Calendar.getInstance();
					String anoMesDia = new SimpleDateFormat("yyyyMMdd").format(fecha.getTime());
					//el nombre del archivo
					String fname=dt.getNombreArchivoSalida().trim() + "_" + anoMesDia + "." + fecha.getTime().getTime() + "."+ extension;  
					
					FileOutputStream outputfile = null;
					try {
						outputfile = new FileOutputStream(new File(dirPath + fname));
						log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Se genero el ouputstream ok: " + dirPath + fname);
					} catch (IOException e) {
						log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Error al intentar generar el archivo en el lugar");
						throw new Exception("No se encontro la ruta destino para la generacion del archivo " + e.getMessage());
					}
					LinkInfoPopup l = new LinkInfoPopup();
					l.setUtl(dt.getDirectorioDestino() + fname);
					l.setTextoDelLink(dt.getNombreArchivoSalida());
					l.setUrlPathSinNombreArchivo(dt.getDirectorioDestino());
					dat.setNombreDelArchivodeSalida(dt.getNombreArchivoSalida());
					dat.setNombreArchivo(fname);
					dat.setRutaDondeSeGuardaElArchivoSinNombreArchivo(dirPath);
					dat.setLinkInfoPopup(l);
					dat.setReporteAGenerarseStream(outputfile);
					dat.setRutaDondeEstaGuardadoElTemplate(dt.getDirectorioOrigen()+dt.getPathBasicoDocumentos() + dt.getNombreTemplate());
					dat.setRutaDondeSeGuardaraElArchivo(dt.getContextRootDirFullpath()+dt.getDirectorioDestino()+fname);
							
		return dat;
		
	}
	
	
	
	/**
	 * Genera el bean que contiene los 3 datos escenciales en la generacion de archivos
	 * El output stream por medio de el que se generará el archivo, el LinkInfoPopup con el 
	 * path de lectura y el label del link y el path donde esta guardado el archivo
	 * @param nombreArchivo
	 * @param extencion
	 * @return
	 * @throws Exception
	 */
	public DescriptorDeAccesoTemplate obtenerDatosDeAccesoByNombreArchivoExtEIdEmpresa(String nombreArchivo, String extencion, String idEmpresa) throws Exception{
					
					try {
						DescriptorDeAccesoTemplate dat = new DescriptorDeAccesoTemplate();
						
						DatosTemplate dt = comunesService
								.obtenerDatosTemplateByNombreArchivoYExtencionEIdEmpresa(nombreArchivo,
										extencion, idEmpresa);
						
						//path de directorio que contiene los reportes generados
						String dirPath = dt.getContextRootDirFullpath().trim()
								+ dt.getDirectorioDestino().trim();
						if("".equals(extencion)){
							extencion =  dt.getExtencionDefault();
						}
						//el nombre del archivo
						String fname=dt.getNombreArchivoSalida().trim() + "_" + new Date().getTime() + "."+ extencion;  
						
						FileOutputStream outputfile = null;
						try {
							outputfile = new FileOutputStream(new File(dirPath + fname));
							log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Se genero el ouputstream ok: " + dirPath + fname);
						} catch (IOException e) {
							log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Error al intentar generar el archivo en el lugar");
							throw new Exception("No se encontro la ruta destino para la generacion del archivo " + e.getMessage());
						}
						LinkInfoPopup l = new LinkInfoPopup();
						l.setUtl( dt.getDirectorioDestino() + fname);
						l.setTextoDelLink(dt.getNombreArchivoSalida());
						
						dat.setNombreDelArchivodeSalida(dt.getNombreArchivoSalida());
						dat.setRutaDondeSeGuardaElArchivoSinNombreArchivo(dirPath);
						dat.setLinkInfoPopup(l);
						dat.setReporteAGenerarseStream(outputfile);
						dat.setRutaDondeEstaGuardadoElTemplate(dt.getDirectorioOrigen()+dt.getPathBasicoDocumentos() + dt.getNombreTemplate() + "."+ extencion);
						dat.setRutaDondeSeGuardaraElArchivo(dt.getContextRootDirFullpath()+dt.getDirectorioDestino()+fname);
								
						return dat;
					} catch (Exception e) {
						log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " obtenerDatosDeAccesoByNombreArchivoExtEIdEmpresa(): "  + e.getMessage());
						throw e;
					}
		
	}
		
	/**
	 * obtiene datos template x idempresa, area, codigo reporte y extencion.
	 * ej: La luisina(1), COBRANZAS, MOROSOS_2, odt
	 */
	public DescriptorDeAccesoTemplate obtenerDatosDeAccesoByIdEmpresaAreaCodigoReporteYExtencion(String idEmpresa, String area, String codigoReporte, String extension) throws Exception{
		
		try {
			DescriptorDeAccesoTemplate dat = new DescriptorDeAccesoTemplate();
			
			DatosTemplate dt = comunesService
					.obtenerNombreTemplateByIdEmpresaAreaYCodigoReporte(idEmpresa, area, codigoReporte);
						
			//path de directorio que contiene los reportes generados
			String dirPath = dt.getContextRootDirFullpath().trim()
					+ dt.getDirectorioDestino().trim();
			if("".equals(extension)){
				extension =  dt.getExtencionDefault();
			}
			//el nombre del archivo
			Calendar fecha = Calendar.getInstance();
			String anoMesDia = new SimpleDateFormat("yyyyMMdd").format(fecha.getTime());
			String fname=dt.getNombreArchivoSalida().trim() + "_" + anoMesDia + "." + new Date().getTime() + "."+ extension;  
			
			FileOutputStream outputfile = null;
			try {
				outputfile = new FileOutputStream(new File(dirPath + fname));
				log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Se genero el ouputstream ok: " + dirPath + fname);
			} catch (IOException e) {
				log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Error al intentar generar el archivo en el lugar: " + dirPath + fname);
				throw new Exception("No se encontro la ruta destino para la generacion del archivo " + e.getMessage());
			}
			LinkInfoPopup l = new LinkInfoPopup();
			l.setUtl(dt.getDirectorioDestino() + fname);
			l.setTextoDelLink(dt.getNombreArchivoSalida());
			l.setUrlPathSinNombreArchivo(dt.getDirectorioDestino());
			
			dat.setNombreArchivo(fname);
			dat.setNombreDelArchivodeSalida(dt.getNombreArchivoSalida());
			dat.setRutaDondeSeGuardaElArchivoSinNombreArchivo(dirPath);
			dat.setLinkInfoPopup(l);
			dat.setReporteAGenerarseStream(outputfile);
			dat.setRutaDondeEstaGuardadoElTemplate(dt.getDirectorioOrigen()+dt.getPathBasicoDocumentos() + dt.getNombreTemplate());
			dat.setRutaDondeSeGuardaraElArchivo(dt.getContextRootDirFullpath()+dt.getDirectorioDestino()+fname);
					
			return dat;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " obtenerDatosDeAccesoByIdEmpresaAreaCodigoReporteYExtencion(): "  + e.getMessage());
			throw e;
		}

}
	
	
	
	public DescriptorDeAccesoTemplate obtenerDatosDeAccesoByIdEmpresaAreaCodigoReporteYExtencion(String idEmpresa, String area, String codigoReporte, String extension, String identificador) throws Exception{
		
		try {
			DescriptorDeAccesoTemplate dat = new DescriptorDeAccesoTemplate();
			
			DatosTemplate dt = comunesService
					.obtenerNombreTemplateByIdEmpresaAreaYCodigoReporte(idEmpresa, area, codigoReporte);
						
			//path de directorio que contiene los reportes generados
			String dirPath = dt.getContextRootDirFullpath().trim()
					+ dt.getDirectorioDestino().trim();
			if("".equals(extension)){
				extension =  dt.getExtencionDefault();
			}
			
			//el nombre del archivo
			String fname=dt.getNombreArchivoSalida().trim() + "_" + identificador + "."+ extension;  
			
			FileOutputStream outputfile = null;
			try {
				outputfile = new FileOutputStream(new File(dirPath + fname));
				log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Se genero el ouputstream ok: " + dirPath + fname);
			} catch (IOException e) {
				log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Error al intentar generar el archivo en el lugar: " + dirPath + fname);
				throw new Exception("No se encontro la ruta destino para la generacion del archivo " + e.getMessage());
			}
			LinkInfoPopup l = new LinkInfoPopup();
			l.setUtl(dt.getDirectorioDestino() + fname);
			l.setTextoDelLink(dt.getNombreArchivoSalida());
			l.setUrlPathSinNombreArchivo(dt.getDirectorioDestino());
			
			dat.setNombreArchivo(fname);
			dat.setNombreDelArchivodeSalida(dt.getNombreArchivoSalida());
			dat.setRutaDondeSeGuardaElArchivoSinNombreArchivo(dirPath);
			dat.setLinkInfoPopup(l);
			dat.setReporteAGenerarseStream(outputfile);
			dat.setRutaDondeEstaGuardadoElTemplate(dt.getDirectorioOrigen()+dt.getPathBasicoDocumentos() + dt.getNombreTemplate());
			dat.setRutaDondeSeGuardaraElArchivo(dt.getContextRootDirFullpath()+dt.getDirectorioDestino()+fname);
					
			return dat;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " obtenerDatosDeAccesoByIdEmpresaAreaCodigoReporteYExtencion(): "  + e.getMessage());
			throw e;
		}

	}
	
	@Override
	public DescriptorDeAccesoTemplate obtenerDatosDeAccesoByNombreTemplateCodigoAreaCodigoReporte(
			String nombreReporte, String codigoArea, String codigoReporte) throws Exception{
		DescriptorDeAccesoTemplate dat = new DescriptorDeAccesoTemplate();
		
		DatosTemplate dt = comunesService
				.obtenerDatosTemplateByNombreTemplateCodigoAreaCodigoReporte(nombreReporte,
						codigoArea, codigoReporte);
		//path que contiene los templates
		if(dt==null){
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " No se encontro ningún template " + nombreReporte + " con codigo de área: " + codigoArea);
			throw new Exception("Error obteniendo template: No se encontro ningún template " + nombreReporte + " con codigo de área: " + codigoArea);
		}
		
		//path de directorio que contiene los reportes generados
		String dirPath = dt.getContextRootDirFullpath().trim()
				+ dt.getDirectorioDestino().trim();
		
		String extension = dt.getExtencionDefault();
		
		
		Calendar fecha = Calendar.getInstance();
		String anoMesDia = new SimpleDateFormat("yyyyMMdd").format(fecha.getTime());
		//el nombre del archivo
		String fname=dt.getNombreArchivoSalida().trim() + "_" + anoMesDia + "." + fecha.getTime().getTime() + "."+ extension;  
		
		FileOutputStream outputfile = null;
		try {
			outputfile = new FileOutputStream(new File(dirPath + fname));
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Se genero el ouputstream ok: " + dirPath + fname);
		} catch (IOException e) {
			String msg = serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Error al intentar generar el archivo en el lugar: " + dirPath + fname;
			log.error(msg);
			throw new Exception("No se encontro la ruta destino para la generacion del archivo " + e.getMessage(), e);
		}
		LinkInfoPopup l = new LinkInfoPopup();
		l.setUtl(dt.getDirectorioDestino() + fname);
		l.setTextoDelLink(dt.getNombreArchivoSalida());
		l.setUrlPathSinNombreArchivo(dt.getDirectorioDestino());
		dat.setNombreDelArchivodeSalida(dt.getNombreArchivoSalida());
		dat.setNombreArchivo(fname);
		dat.setRutaDondeSeGuardaElArchivoSinNombreArchivo(dirPath);
		dat.setLinkInfoPopup(l);
		dat.setReporteAGenerarseStream(outputfile);
		dat.setRutaDondeEstaGuardadoElTemplate(dt.getDirectorioOrigen()+dt.getPathBasicoDocumentos() + dt.getNombreTemplate());
		dat.setRutaDondeSeGuardaraElArchivo(dt.getContextRootDirFullpath()+dt.getDirectorioDestino()+fname);
		
		
		return dat;
	}
	
	
	

	/**
	 * obtiene datos template x idempresa, area, codigo reporte y extencion
	 * y setea en el fileoutputStream el miNombreArchivo como parte del nombre de salida.
	 * Si miDir tiene un nombre verifica que no este creado y lo crea. 
	 * El fileOutputStream lo deja apuntado dentro de miDir
	 * El parametro miDir No se cnofigura en la base, se pasa como parte de los datos de negocio.
	 * Usado para la generacion multiple de rerpotes. Ej: /MAYO/LiquidacionComercializador_MariaToñetti_123452524
	 * ej: La luisina(1), COBRANZAS, MOROSOS_2, odt, MariaToñetti, MAYO
	 */

	public DescriptorDeAccesoTemplate obtenerDatosDeAccesoByIdEmpresaAreaCodigoReporteExtencionConMINombreArchivoYMiDir(
			String idEmpresa, String area, String codigoReporte,
			String extencion, String miNombreArchivo, String miDir)
			throws Exception {

		try {
			DescriptorDeAccesoTemplate dat = new DescriptorDeAccesoTemplate();
			
			DatosTemplate dt = comunesService
					.obtenerNombreTemplateByIdEmpresaAreaYCodigoReporte(idEmpresa, area, codigoReporte);
//			//path que contiene los templates
//			String ditPathTemplates = dt.getPathBasicoDocumentos() + dt.getNombreTemplate(); 
//			
//			//nombre del template
//			String nombreTemplate = dt.getNombreTemplate();
					
			//path de directorio que contiene los reportes generados
			String dirPath = dt.getContextRootDirFullpath().trim()
					+ dt.getDirectorioDestino().trim();
			if("".equals(extencion)){
				extencion =  dt.getExtencionDefault();
			}
			//el nombre del archivo
			String fname=dt.getNombreArchivoSalida().trim() + "_"+ miNombreArchivo + "_" + new Date().getTime() + "."+ extencion;  
			
			//Si se indica directorio lo creo si es que no existe
			miDir=miDir.trim();
			if(miDir != null && !"".equals(miDir)){
				dirPath = dirPath + "/" + miDir ;
				boolean exists = (new File(dirPath)).exists();
				if(!exists){
					log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " CREANDO DIRECTORIO ....." + miDir);
					boolean success = (new File(dirPath).mkdir());
				}else{
					log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " El directorio ya existe, no se creará " + miDir);
				}	
				dirPath = dirPath + "/";
			}	
			
			FileOutputStream outputfile = null;
			try {
				outputfile = new FileOutputStream(new File(dirPath + fname));
				log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Se genero el ouputstream ok: " + dirPath + fname);
			} catch (IOException e) {
				log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Error al intentar generar el archivo en el lugar");
				throw new Exception("No se encontro la ruta destino para la generacion del archivo " + e.getMessage());
			}
			LinkInfoPopup l = new LinkInfoPopup();
			l.setUtl(dt.getDirectorioDestino() + "/"+miDir+"/" + fname);
			l.setTextoDelLink(dt.getNombreArchivoSalida());
			l.setUrlPathSinNombreArchivo(dt.getDirectorioDestino());
			
			dat.setNombreDelArchivodeSalida(dt.getNombreArchivoSalida());
			dat.setRutaDondeSeGuardaElArchivoSinNombreArchivo(dirPath);
			dat.setLinkInfoPopup(l);
			dat.setReporteAGenerarseStream(outputfile);
			dat.setRutaDondeEstaGuardadoElTemplate(dt.getDirectorioOrigen()+dt.getPathBasicoDocumentos() + dt.getNombreTemplate());
			dat.setRutaDondeSeGuardaraElArchivo(dt.getContextRootDirFullpath()+dt.getDirectorioDestino()+fname);
					
			return dat;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " obtenerDatosDeAccesoByIdEmpresaAreaCodigoReporteYExtencion(): "  + e.getMessage());
			throw e;
		}
		
	}


	

	
	
	
	
}
