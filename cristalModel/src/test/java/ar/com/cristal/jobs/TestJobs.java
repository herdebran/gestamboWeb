package ar.com.cristal.jobs;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ar.com.cristal.creditos.common.Constantes;
import ar.com.cristal.creditos.servicios.ComunesService;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.util.DateUtil;
import ar.com.cristal.creditos.util.LogearUsuario;

@ContextConfiguration(locations = { "/ar/com/cristal/creditos/cristalModel-application-context-test.xml" })
public class TestJobs extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private ServiceFacade serviceFacade;

	@Before
	public void setup(){
		LogearUsuario.loguear(serviceFacade, "Administrador");		
	}



	public void testCuotaSocialGenerada(){
		ComunesService cs = serviceFacade.getComunesService();
		System.out.println("CuotaSocial Generada:  " + cs.cuotaSocialGenerada(10, 2012));
		
		
		Calendar calendar = DateUtil.createCalendar(new Date());
		//Verifica que no se haya ejecutado la generación de la cuota social para el período
		System.out.println(cs.cuotaSocialGenerada(calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR)));
		
	}
	
	
	
}
