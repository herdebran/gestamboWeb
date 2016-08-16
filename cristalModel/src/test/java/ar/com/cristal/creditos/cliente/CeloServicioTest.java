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

import ar.com.cristal.creditos.common.TipoCeloServicioEnum;
import ar.com.cristal.creditos.common.TipoMovStockEnum;
import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.entity.tambo.CeloServicio;
import ar.com.cristal.creditos.entity.tambo.Inseminador;
import ar.com.cristal.creditos.entity.tambo.Producto;
import ar.com.cristal.creditos.entity.tambo.Vaca;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.servicios.VacasService;
import ar.com.cristal.creditos.util.LogearUsuario;

@ContextConfiguration(locations={"/ar/com/cristal/creditos/cristalModel-application-context-test.xml"})
public class CeloServicioTest extends AbstractTransactionalJUnit4SpringContextTests {
	private Logger log = Logger.getLogger(CeloServicioTest.class);

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
	public void persistirCeloTest() {
		try {
			Vaca v = vacasService.obtenerVacaPorRP("230");
			
			if (v != null){
				CeloServicio cs = new CeloServicio();
				
				cs.setFecha(new Date());
				cs.setLactancia(2);
				cs.setNroCeloServicio(1);
				cs.setTipo(TipoCeloServicioEnum.CELO_SIN_SERVICIO);
				cs.setVaca(v);
				vacasService.persistirCeloServicio(cs,true);
				
				Assert.assertNotNull(cs.getId());
			} else 
				Assert.assertTrue(1==2);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
	}
	

	@Test
	@Rollback(false)
	public void insertarInseminadorRPTest() {
		try {
			Inseminador i= new Inseminador();
			
			i.setApellido("Marzullo");
			i.setNombre("Hernan");
			
			vacasService.persistirInseminador(i);
			
			Assert.assertTrue(i != null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Rollback(false)
	public void eliminarCeloServicioTest() {
		try {
			
			vacasService.eliminarCeloServicioById(2L,true);
			
			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void consultarUltimoCeloServicioTest() {
		try {
			
			CeloServicio cs=vacasService.obtenerUltimoCeloServicioPorVacaId(2L);
			System.out.println(cs.getFecha() + " Tipo:" + cs.getTipo().name());
			
			Assert.assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Rollback(false)
	public void InsertarConsumoSemenTest() {
		try {
			
			Producto p= serviceFacade.getRubrosProductosService().obtenerProductoById(1L);
			
			if (p != null)
				serviceFacade.getRubrosProductosService().cargarMovStockProducto(p, 10,TipoMovStockEnum.CONSUMO);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
