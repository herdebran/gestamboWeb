package ar.com.cristal.creditos.commons;

import java.util.Calendar;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ar.com.cristal.creditos.common.Constantes;
import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.documentos.util.DatosTemplate;
import ar.com.cristal.creditos.servicios.ComunesService;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.util.LogearUsuario;

@ContextConfiguration(locations={"/ar/com/cristal/creditos/cristalModel-application-context-test.xml"})
public class ComunesTest extends AbstractTransactionalJUnit4SpringContextTests  {
	
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
	
	/**
	 * 
	 */

//	@Rollback(false)
	public void obtenerTemplates(){
		
		try{
			
			
			DatosTemplate t =  new DatosTemplate();
			t.setCodigoArea("COBRANZAS");
			t.setCodigoReporte("MOROSO_2");
			t.setDescripcion("Nombre del template usado en cobranzas para  la notificacion de morosos 2");
			t.setIdEmpresa(new Long(1l));
//			t.setNombreSalida("Cooperativa_Cobranzas_Moroso_2.odt");
//			t.setNombreTemplate("Cooperativa_Cobranzas_Moroso_2.odt");
//			t.setPathDestino("/COBRANZAS/");
//			t.setPathOrigen("/TEMPLATES_COBRANZAS/");
//			genericDao.save(t);
			
			t =  new DatosTemplate();
			t.setCodigoArea("COBRANZAS");
			t.setCodigoReporte("PREJUDICIAL");
			t.setDescripcion("Nombre del template usado en cobranzas para  la notificacion prejudicial");
			t.setIdEmpresa(new Long(1l));
//			t.setNombreSalida("Cooperativa_Cobranzas_Prejudicial.odt");
//			t.setNombreTemplate("Cooperativa_Cobranzas_Prejudicial.odt");
//			t.setPathDestino("/COBRANZAS/");
//			t.setPathOrigen("/TEMPLATES_COBRANZAS/");
//			genericDao.save(t);
		
			Assert.assertTrue(true);
			
		}catch(Exception e){
			Assert.assertTrue(false);
		}
		
	}
	



	public void obtener(){
		Double i = Double.valueOf("10");
		Integer f = Integer.valueOf("10.0");
		int g = i.intValue();
		System.out.println("integer: "  + f);
	}
	


	public void tareaRealizada(){
		Calendar fechaEvaluacion = Calendar.getInstance();
		String nombreTareaRegistrada = Constantes.TAREA_REGISTRAR_DEUDA_CLIENTES_MOROSOS;
		System.out.println(comunesService.tareaMensualRealizada(nombreTareaRegistrada, fechaEvaluacion));
		
	}
}