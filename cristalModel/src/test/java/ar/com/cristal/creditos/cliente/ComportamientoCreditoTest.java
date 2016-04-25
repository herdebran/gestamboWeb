package ar.com.cristal.creditos.cliente;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.entity.creditos.Credito;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.servicios.impl.ClienteService;
import ar.com.cristal.creditos.servicios.impl.ImpresionServiceImpl;
import ar.com.cristal.creditos.util.LogearUsuario;

@ContextConfiguration(locations={"/ar/com/cristal/creditos/cristalModel-application-context-test.xml"})
public class ComportamientoCreditoTest extends AbstractTransactionalJUnit4SpringContextTests {
	private Logger log = Logger.getLogger(ComportamientoCreditoTest.class);

	@Autowired
	GenericDao genericDao;
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	ImpresionServiceImpl impresionService;
	
	@Autowired
	ServiceFacade serviceFacade;
	@Before
	public void setup(){
		LogearUsuario.loguear(serviceFacade, "Administrador");		
	}
	
	@Test
	public void dummy(){
		
	}
	

	public void comportamientoTest(){
		
		String nroCuota = "31";
		
		Credito c = serviceFacade.getCreditosService().obtenerCreditoPorID(9866L);
		
		try {
			System.out.println("comportamiento: " + impresionService.comportamientoTest(c, nroCuota));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		 
	}
	
	
	
	

	public void creditoCuotaVencida(){
		boolean s = serviceFacade.getCreditosService().tieneCuotasVencidas(19114L);
		System.out.println("tiene cuota vencida: " + s);
	}
	
	
	
	
}
