package ar.com.cristal.creditos.jobs;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.transaction.annotation.Transactional;

import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.util.LogearUsuario;

public class TareaPing extends QuartzJobBean {

	private ServiceFacade serviceFacade;
	
	private Logger log = Logger.getLogger(TareaPing.class);
	
	@Override
	@Transactional
	protected void executeInternal(JobExecutionContext jec) throws JobExecutionException {
		
		try {		
			LogearUsuario.loguear(serviceFacade, "Administrador");			
			serviceFacade.getClienteService().ping();
			log.info("Ping");
			
		} catch (Exception e) {
			log.error("Error Ejecutando Job TareaPing", e);
			
			throw new JobExecutionException("Error Ejecutando Job TareaPing" + e.getMessage());
		}
	}

	public ServiceFacade getServiceFacade() {
		return serviceFacade;
	}

	public void setServiceFacade(ServiceFacade serviceFacade) {
		this.serviceFacade = serviceFacade;
	}

}
