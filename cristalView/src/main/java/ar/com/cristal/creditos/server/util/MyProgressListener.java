package ar.com.cristal.creditos.server.util;

import org.apache.commons.fileupload.ProgressListener;
import org.apache.log4j.Logger;

import ar.com.cristal.creditos.servicios.ServiceFacade;


	public class MyProgressListener implements ProgressListener{
		private Logger log = Logger.getLogger(MyProgressListener.class);
		
		private ServiceFacade svc;
		   private long megaBytes = -1;
		   
		   public MyProgressListener(ServiceFacade service){
			   svc = service;
		   }
		   
		   public void update(long pBytesRead, long pContentLength, int pItems) {
			   long MEGABYTES = 1024 * 1024;
			   
		       long mBytes = pBytesRead / MEGABYTES;
		       if (megaBytes == mBytes) {
		           return;
		       }
		       megaBytes = mBytes;
		       System.out.println("We are currently reading item " + pItems);
		       
		       long KILOBYTES = 1024;
		      
		       if (pContentLength == -1) {
		           System.out.println(svc.obtenerNombreSesionUsuarioUsuarioLogueado() + " : " + pBytesRead/KILOBYTES + " MB have been read.");
		           log.debug(svc.obtenerNombreSesionUsuarioUsuarioLogueado() + " - " + pBytesRead/KILOBYTES + " MB have been read.");
		       } else {
		           System.out.println(svc.obtenerNombreSesionUsuarioUsuarioLogueado() + " :: " + pBytesRead/KILOBYTES + " of " + pContentLength/KILOBYTES + " MB have been read.");
		           log.debug(svc.obtenerNombreSesionUsuarioUsuarioLogueado() + " - " + pBytesRead/KILOBYTES + " of " + pContentLength/KILOBYTES + " MB have been read.");
		       }
		   }

}
