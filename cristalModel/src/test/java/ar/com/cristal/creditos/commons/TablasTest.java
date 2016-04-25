package ar.com.cristal.creditos.commons;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.entity.commons.Tablas;
import ar.com.cristal.creditos.servicios.ComunesService;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.util.LogearUsuario;


@ContextConfiguration(locations={"/ar/com/cristal/creditos/cristalModel-application-context-test.xml"})
public class TablasTest extends AbstractTransactionalJUnit4SpringContextTests  {
	
	@Autowired
	GenericDao genericDao;

//	@Autowired
//	private CobrosService cobrosService;
//
//	@Autowired CreditosService creditosService;
	@Autowired ComunesService comunesService;
//
	@Autowired
	ServiceFacade serviceFacade;


	@Before
	public void setup(){
		LogearUsuario.loguear(serviceFacade, "Administrador");		
	}
	
	@Test
	public void dummy(){
		
	}
	

//	@Rollback(false)
	public void obtenerTablasTest(){
		
		try{
			Tablas t = new Tablas();
			t.setNombre("Morosos 1");
			t.setCodigo("MOROSO_1");
			t.setDescripcion("morosos 1 area de cobranzas");
			t.setTipo("COBRANZAS");
//			genericDao.saveOrUpdate(t);
			
			
			t = new Tablas();
			t.setNombre("Morosos 2");
			t.setCodigo("MOROSO_2");
			t.setDescripcion("morosos 2 area de cobranzas");
			t.setTipo("COBRANZAS");
//			genericDao.saveOrUpdate(t);
			
			t = new Tablas();
			t.setNombre("Prejudicial");
			t.setCodigo("PREJUDICIAL");
			t.setDescripcion("instancia prejudicial");
			t.setTipo("COBRANZAS");
			
//			genericDao.saveOrUpdate(t);
			
			List<Tablas> ts= comunesService.obtenerTablaByTipo("COBRANZAS");

			Assert.assertTrue(ts.size() >= 3);
			
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
	}
	






}
