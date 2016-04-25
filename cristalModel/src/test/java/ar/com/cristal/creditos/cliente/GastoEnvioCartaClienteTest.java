package ar.com.cristal.creditos.cliente;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.entity.creditos.Cliente;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.util.LogearUsuario;

@ContextConfiguration(locations={"/ar/com/cristal/creditos/cristalModel-application-context-test.xml"})
public class GastoEnvioCartaClienteTest extends AbstractTransactionalJUnit4SpringContextTests {
	private Logger log = Logger.getLogger(GastoEnvioCartaClienteTest.class);

	@Autowired
	GenericDao genericDao;
	
		
	@Autowired
	ServiceFacade serviceFacade;
	@Before
	public void setup(){
		LogearUsuario.loguear(serviceFacade, "Administrador");		
	}
	
	@Test
	public void dummy(){
		
	}
	
	
	

		
}
