package ar.com.cristal.creditos.cliente;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ar.com.cristal.creditos.common.SexoAnimalEnum;
import ar.com.cristal.creditos.common.TipoCeloServicioEnum;
import ar.com.cristal.creditos.common.TipoMovStockEnum;
import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.entity.tambo.CeloServicio;
import ar.com.cristal.creditos.entity.tambo.Inseminador;
import ar.com.cristal.creditos.entity.tambo.Parto;
import ar.com.cristal.creditos.entity.tambo.Producto;
import ar.com.cristal.creditos.entity.tambo.TipoParto;
import ar.com.cristal.creditos.entity.tambo.Vaca;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.servicios.VacasService;
import ar.com.cristal.creditos.util.LogearUsuario;

@ContextConfiguration(locations={"/ar/com/cristal/creditos/cristalModel-application-context-test.xml"})
public class PartoTest extends AbstractTransactionalJUnit4SpringContextTests {
	private Logger log = Logger.getLogger(PartoTest.class);

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
	@Rollback(false)
	public void persistirPartoTest() {
		try {
			Vaca v = vacasService.obtenerVacaPorRP("230");
			
			if (v != null){
				Parto p = new Parto();
				
				p.setFecha(new Date());
				p.setMellizos(false);
				p.setNroParto(4);
				p.setPadre(vacasService.obtenerToros().get(0));
				p.setRpCria1("99999");
				p.setSexoCria1(SexoAnimalEnum.HEMBRA);
				p.setTipoParto(null);
				p.setVaca(v);
				vacasService.persistirParto(p,true);
				
				Assert.assertNotNull(p.getId());
			} else 
				Assert.assertTrue(1==2);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
	}
	

}
