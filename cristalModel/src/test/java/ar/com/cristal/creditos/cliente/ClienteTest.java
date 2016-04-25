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
import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.entity.creditos.Cliente;
import ar.com.cristal.creditos.localidad.Localidad;
import ar.com.cristal.creditos.localidad.Reparticion;
import ar.com.cristal.creditos.servicios.LocalidadService;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.servicios.impl.ClienteService;
import ar.com.cristal.creditos.util.DateUtil;
import ar.com.cristal.creditos.util.LogearUsuario;

@ContextConfiguration(locations={"/ar/com/cristal/creditos/cristalModel-application-context-test.xml"})
public class ClienteTest extends AbstractTransactionalJUnit4SpringContextTests {
	private Logger log = Logger.getLogger(ClienteTest.class);

	@Autowired
	GenericDao genericDao;
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	LocalidadService localidadService;
	
	@Autowired
	ServiceFacade serviceFacade;
	@Before
	public void setup(){
		LogearUsuario.loguear(serviceFacade, "Administrador");		
	}
	
	@Test
	public void dummy(){
		
	}
	
	

	public void hora(){
//		12/6 1737
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 12);		
		c.set(Calendar.MONTH, 5);
		c.set(Calendar.HOUR_OF_DAY, 17);
		c.set(Calendar.MINUTE, 37);
		
		c.add(Calendar.MILLISECOND, 504109282);
		
		System.out.println(c.getTime());
		
	}

	
	

	public void clienteNuevo() {
		try {
			
			List<Cliente> clientes = clienteService.obtenerClientesByParam("nombre_Woody, Daniels");
			
			if (clientes.isEmpty()){
				Cliente c = new Cliente();
				c.setApellido("Woody");
				c.setNombre("Daniels");
				c.setDni("28068479");
				c.setCuil("20-28068479-2");
				c.setEstado(EstadoClienteEnum.ACTIVO);
				c.setFechaAlta(new Date());
				Calendar fecha = Calendar.getInstance();			
				fecha.add(Calendar.YEAR, -40);
				c.setFechaNacimiento(fecha.getTime());
	
				c.setCalle("145");
				c.setCaracteristica("0221");
				c.setTelefono("45039232");
				c.setCp("1900");
				
				c.setCBU("1234567890123456789012");
				c.setNroCuenta(165165L);
				
				c.setDpto("");
				c.setPiso("-");
				c.setEmail("dnm@gmail.com");
				c.setNro("1543");
				
				c.setObservaciones("observaciones...");
				c.setPagoVoluntario(true);
				
				Localidad localidad = localidadService.obtenerLocalidades().get(0);
				c.setLocalidad(localidad);
				
				c.setSueldo(6800.0);
				
				c.setTarjetaBeneficios(false);
							
				
				clienteService.persistirCliente(c);
				
				Assert.assertNotNull(c.getId());
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
	}
	

	public void modificarClienteTest(){
		
		List<Cliente> clientes;
		try {
			clientes = clienteService.obtenerClientesByParam("nombre_Woody, Daniels");
			
			
			if (clientes.size() == 1) { 
				Cliente cliente = clienteService.obtenerClienteById(new Long(36));
				cliente.setDni("28068479");
				try {
					clienteService.persistirCliente(cliente);
					Assert.assertTrue(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
	}
	
	


	


	public void existeCliente(){
		Cliente cliente = new Cliente();
		cliente.setId(8L);
		cliente.setCuil("20-26683110-3");
		Reparticion r = new Reparticion();
		r.setId(15L);
		
		System.out.println(clienteService.clienteExiste(cliente));
	}
	
	
	
	

	public void pagoEnvioCarta(){
		Calendar cInicio = DateUtil.createCalendar(2012, 9, 1, 16, 14);
		Calendar cFin = DateUtil.createCalendar(2012, 9,1, 16, 15);
//		2012-10-01 16:14:15
		 serviceFacade.getClienteService().obtenerMontoPagoEnvioCarta(12133L,cInicio.getTime(), cFin.getTime());
		 
		 
	}
	
	
	@Test
	public void cuantosDiasHaceQueNoPaga() {
		Long clienteId=1300L;
		
		try {
			System.out.println(serviceFacade.getClienteService().obtenerDiasDesdeUltimoPagoXCliente(clienteId));
			//System.out.println(serviceFacade.getClienteService().obtenerFechaUltimoPago(clienteId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
