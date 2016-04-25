package ar.com.cristal.creditos.jobs;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import ar.com.cristal.creditos.common.Constantes;
import ar.com.cristal.creditos.servicios.ComunesService;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.util.LogearUsuario;

public class TareaActualizarCuotasVencidas extends QuartzJobBean {

	private ServiceFacade serviceFacade;
	
	private Logger log = Logger.getLogger(TareaActualizarCuotasVencidas.class);
	
	@Override
	protected void executeInternal(JobExecutionContext jec) throws JobExecutionException {
		log.info("inicio TareaActualizarCuotasVencidas");
		ComunesService cs = serviceFacade.getComunesService();
		Long id = null;
		
		try {	
			LogearUsuario.loguear(serviceFacade, "Administrador");
			
			id = cs.registrarInicioTarea(Constantes.TAREA_ACTUALIZAR_CUOTAS_VENCIDAS);
			
			//serviceFacade.getCreditosService().ActualizarCuotasVencidas(new Date());
			
			cs.registrarFinTarea(id);
			
			
		} catch (Exception e) {
			
			try {
				cs.registrarFalla(id, e.getMessage());
			} catch (Exception e1) {
				//No se hace nada
				log.error("Error al registrar falla ", e1);
			}		
			
			log.error("Error Ejecutando Job TareaActualizarCuotasVencidas", e);
			throw new JobExecutionException("Error Ejecutando Job TareaActualizarCuotasVencidas" + e.getMessage());
		}
		log.info("fin tarea TareaActualizarCuotasVencidas");
	}

	public ServiceFacade getServiceFacade() {
		return serviceFacade;
	}

	public void setServiceFacade(ServiceFacade serviceFacade) {
		this.serviceFacade = serviceFacade;
	}

}
