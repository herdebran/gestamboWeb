package ar.com.cristal.creditos.tambo;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ar.com.cristal.creditos.common.EstadoClienteEnum;
import ar.com.cristal.creditos.common.EstadoProductivoEnum;
import ar.com.cristal.creditos.common.EstadoReproductivoEnum;
import ar.com.cristal.creditos.common.EstadoSanitarioEnum;
import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.entity.creditos.Cliente;
import ar.com.cristal.creditos.entity.login.Establecimiento;
import ar.com.cristal.creditos.entity.tambo.Rodeo;
import ar.com.cristal.creditos.entity.tambo.Vaca;
import ar.com.cristal.creditos.localidad.Localidad;
import ar.com.cristal.creditos.localidad.Reparticion;
import ar.com.cristal.creditos.servicios.LocalidadService;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.servicios.VacasService;
import ar.com.cristal.creditos.servicios.impl.ClienteService;
import ar.com.cristal.creditos.util.DateUtil;
import ar.com.cristal.creditos.util.LogearUsuario;
import ar.com.cristal.tambo.enums.TipoRodeoEnum;

@ContextConfiguration(locations={"/ar/com/cristal/creditos/cristalModel-application-context-test.xml"})
public class RodeoTest extends AbstractTransactionalJUnit4SpringContextTests {
	private Logger log = Logger.getLogger(RodeoTest.class);

	@Autowired
	GenericDao genericDao;
	
	@Autowired
	VacasService vacasService;
	
	@Autowired
	ServiceFacade serviceFacade;
	@Before
	public void setup(){
		LogearUsuario.loguear(serviceFacade, "Administrador");		
	}
	
	@Test
	public void dummy(){
		
	}

	
	
	@Test
	@Rollback(true)
	public void rodeoNuevo() {
		try {
			Rodeo r = new Rodeo();
			r.setNombre("TAMBO GENERAL");
			r.setTipoRodeo(TipoRodeoEnum.TAMBO_GENERAL);
			
			vacasService.persistirRodeo(r);
			Assert.assertNotNull(r.getId());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void EliminarRodeoTest() {
		try {
			vacasService.eliminarRodeoById(2L);
			Assert.assertTrue(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	
}
