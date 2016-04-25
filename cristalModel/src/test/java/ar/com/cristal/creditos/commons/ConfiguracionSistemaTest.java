package ar.com.cristal.creditos.commons;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.entity.commons.ConfiguracionSistema;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.util.LogearUsuario;

@ContextConfiguration(locations={"/ar/com/cristal/creditos/cristalModel-application-context-test.xml"})
public class ConfiguracionSistemaTest extends AbstractTransactionalJUnit4SpringContextTests  {
	
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

//	@Rollback(false)
	public void obtenerConfiguracionSistema(){
		
		try{
			
			System.out.println(serviceFacade.getComunesService().isVerazOnlineActivo());
			
			List<ConfiguracionSistema> configuracion = new ArrayList<ConfiguracionSistema>();
			
			configuracion = genericDao.findAll(ConfiguracionSistema.class);
			
			for (ConfiguracionSistema c : configuracion) {
				System.out.println(c.getPropiedad());
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}
	

	
	
}