package ar.com.cristal.creditos.cliente;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ar.com.cristal.creditos.common.EstadoClienteEnum;
import ar.com.cristal.creditos.common.EstadoProductivoEnum;
import ar.com.cristal.creditos.common.EstadoReproductivoEnum;
import ar.com.cristal.creditos.common.EstadoSanitarioEnum;
import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.entity.creditos.Cliente;
import ar.com.cristal.creditos.entity.login.Establecimiento;
import ar.com.cristal.creditos.entity.tambo.Vaca;
import ar.com.cristal.creditos.localidad.Localidad;
import ar.com.cristal.creditos.localidad.Reparticion;
import ar.com.cristal.creditos.servicios.LocalidadService;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.servicios.VacasService;
import ar.com.cristal.creditos.servicios.impl.ClienteService;
import ar.com.cristal.creditos.util.DateUtil;
import ar.com.cristal.creditos.util.LogearUsuario;

@ContextConfiguration(locations={"/ar/com/cristal/creditos/cristalModel-application-context-test.xml"})
public class VacaTest extends AbstractTransactionalJUnit4SpringContextTests {
	private Logger log = Logger.getLogger(VacaTest.class);

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
	public void vacaNueva() {
		try {
			
			Vaca v=new Vaca();
			v.setCategoria("CL1");
			v.setCategoriaMadre("PB");
			v.setEliminado(false);
			Establecimiento e = serviceFacade.getUsuarioService().obtenerEstablecimiento(serviceFacade.obtenerUsuarioLogueado().getEstablecimientoActual());
			v.setEstablecimiento(e);
			v.setEstadoProductivo(EstadoProductivoEnum.ORDEÑE);
			v.setEstadoReproductivo(EstadoReproductivoEnum.PREÑADA);
			v.setEstadoSanitario(EstadoSanitarioEnum.SANA);
			Calendar fecha = Calendar.getInstance();			
			fecha.add(Calendar.YEAR, -10);
			v.setFechaNacimiento(fecha.getTime());
			v.setLactancia(3);
			v.setLitrosPromedio(0.0);
			v.setRc("333322211");
			v.setRp("230");
			v.setUsuarioAlta(serviceFacade.obtenerUsuarioLogueadoId());
			
			vacasService.guardarVaca(v);
			Assert.assertNotNull(v.getId());
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
	}
	

	
	
}
