package ar.com.cristal.creditos.commons;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.entity.commons.Empresa;
import ar.com.cristal.creditos.servicios.ComunesService;
import ar.com.cristal.creditos.servicios.CreditosService;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.util.LogearUsuario;

@ContextConfiguration(locations={"/ar/com/cristal/creditos/cristalModel-application-context-test.xml"})
public class EmpresaTest extends AbstractTransactionalJUnit4SpringContextTests  {
	
	
	@Autowired CreditosService creditosService;
	@Autowired
	GenericDao genericDao;

	@Autowired
	private ComunesService comunesService;
	
	@Autowired
	private ServiceFacade serviceFacade;

	
	@Before
	public void setup(){
		LogearUsuario.loguear(serviceFacade, "Administrador");		
	}
	
	@Test
	public void dummy(){
		
	}

//	@Rollback(false)
	public void obtenerEmrpesaTest(){
		
		try{
			Empresa e = new Empresa();
			e.setId(null);
			e.setNombre("La Luisina SRL");
			e.setCuil("29-33737373737-0");
		
//			genericDao.saveOrUpdate(e);
			
			e = new Empresa();
			e.setId(null);
			e.setNombre("Cooperativa");
			e.setCuil("55-4949494949-0");
		
//			genericDao.saveOrUpdate(e);
			
			List<Empresa> ts= comunesService.obtenerEmpresas();

//			Assert.assertTrue(ts.size() > 0);
			
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
	}
	


	
}
