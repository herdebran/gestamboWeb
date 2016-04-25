package ar.com.cristal.creditos.perfiles;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.entity.login.Perfil;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.util.LogearUsuario;

@ContextConfiguration(locations = { "/ar/com/cristal/creditos/cristalModel-application-context-test.xml" })
public class PerfilesTest extends
		AbstractTransactionalJUnit4SpringContextTests {

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
	

//	//@Rollback(true)
	public void creacionPerfil() {
		
		try {
			
			
			
			Perfil p = new Perfil();
			
			p.setNombre("VENTAS");
			p.setDescripcion("Son aquellos que tienen acceso a las pantallas de ventas de créditos");

//			genericDao.save(p);
			
			
			p = new Perfil();
			
			p.setNombre("CALLCENTER");
			p.setDescripcion("Son aquellos que tienen acceso a las pantallas de call center");

//			genericDao.save(p);
			
			
			p = new Perfil();
			
			p.setNombre("ADMINISTRADOR");
			p.setDescripcion("Son aquellos que tienen acceso a todas las pantallas");

//			genericDao.save(p);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	

	public void obtenerPerfiles(){
		List<Perfil> perfiles = serviceFacade.obtenerPerfiles();
		
		System.out.println("Perfiles: " + perfiles.size());
		
	}

	

}
