package ar.com.cristal.creditos.reportes;


import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.servicios.ComunesService;
import ar.com.cristal.creditos.servicios.ImpresionService;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.servicios.TemplateManagerService;
import ar.com.cristal.creditos.servicios.impl.ReporteService;
import ar.com.cristal.creditos.util.LogearUsuario;


@ContextConfiguration(locations={"/ar/com/cristal/creditos/cristalModel-application-context-test.xml"})
public class ReportesJasperTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired 
	private ReporteService reporteService;
	
	@Autowired
	private ImpresionService impresionService;
	
	@Autowired
	private ComunesService comunesService;
	
	@Autowired
	private TemplateManagerService templateManager;
	
	
	@Autowired
	protected GenericDao genericDao;
	
	@Autowired
	private ServiceFacade serviceFacade;
	
	@Before
	public void setup(){
		LogearUsuario.loguear(serviceFacade, "Administrador");		
	}
	
	@Test
	public void dummy(){
		
	}
	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void generarReporteJasper(){
//		
//		DescriptorDeAccesoTemplate dt;
//		try {	
//			dt = templateManager.obtenerDatosDeAccesoByIdEmpresaAreaCodigoReporteYExtencion("0","COBRANZAS","tiporeporte", "");
//			Map<String, Object> hm = new HashMap<String, Object>();
//			hm.put("fechaReporte", "16/04/2012 15:30:00");
//			hm.put("motivoReporte", "PARALELO");
//			
//			Collection<Object> data = new ArrayList<Object>();
//			data.add(new LineaReportePorMotivoBean("22/04/2012", "Nuñez", "Manuela","El señor nuñez no estaba, salio de vacaciones por 15 dias"));
//			data.add(new LineaReportePorMotivoBean("22/04/2012", "Albarez, Jose Hernesto", "Manuela","Jose Hernesto se comprometio a pasar a pagar la cuota"));
//
//			//impresionService.imprimirDocumento(dt, hm, data);
////			impresionService.imprimirDocumento(dt, hm, data);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
		


	@Test
	public void pasarALetras() {
		Double number=956.06D;
		System.out.println (ar.com.cristal.creditos.util.NumberToLetterConverter.convertNumberToLetter(number));
	}
	
}
