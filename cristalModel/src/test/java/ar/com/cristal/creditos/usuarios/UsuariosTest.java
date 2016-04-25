package ar.com.cristal.creditos.usuarios;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.entity.login.Establecimiento;
import ar.com.cristal.creditos.entity.login.Perfil;
import ar.com.cristal.creditos.entity.login.Usuario;
import ar.com.cristal.creditos.security.CustomUserDetailsService;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.servicios.impl.UsuarioServiceImpl;
import ar.com.cristal.creditos.util.LogearUsuario;

@ContextConfiguration(locations={"/ar/com/cristal/creditos/cristalModel-application-context-test.xml"})
public class UsuariosTest extends AbstractTransactionalJUnit4SpringContextTests {

	
	@Autowired
	GenericDao genericDao;
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	UsuarioServiceImpl usuarioService;
	
	
	
	@Autowired
	ServiceFacade serviceFacade;
	@Before
	public void setup(){
		LogearUsuario.loguear(serviceFacade, "Administrador");		
	}
	
	@Test
	public void dummy(){
		
	}
	
	

	public void crearUsuarios(){

		if (usuarioService.obtenerUsuarios() == null || usuarioService.obtenerUsuarios().isEmpty()){
		

			try {
				Usuario u = new Usuario("supervisor");
				u.setApellido("supapp");
				u.setNombreUsuario("supervisor");
				u.setPassword("supervisor");
				u.setSupervisor(true);
				u.setAdmin(false);

				Perfil p = (Perfil) serviceFacade.obtenerPerfiles().get(0);
				u.setPerfil(p);
				usuarioService.persistirUsuario(u);

				 
				u = new Usuario("vendedor");
				u.setApellido("vendapp");
				u.setNombreUsuario("vendedor");
				u.setPassword("vendedor");
				u.setSupervisor(false);
				u.setAdmin(false);

					usuarioService.persistirUsuario(u);
				
				u = new Usuario("julio");
				u.setApellido("cortazar");
				u.setNombreUsuario("julio.cortazar");
				u.setPassword("johnny");
				u.setAdmin(false);
				u.setSupervisor(true);
				 
				usuarioService.persistirUsuario(u);
				
				u = new Usuario("jorge");
				u.setApellido("borges");
				u.setNombreUsuario("jorge.borges");
				u.setPassword("johnny");
				u.setAdmin(false);
				u.setSupervisor(false);
				 
				usuarioService.persistirUsuario(u);
				
				u = new Usuario("plaza");
				u.setApellido("italia");
				u.setNombreUsuario("plazaitalia");
				u.setPassword("johnny");
				u.setAdmin(false);
				u.setSupervisor(false);
				 
				usuarioService.persistirUsuario(u);
				
				System.out.println("Cantidad de usuarios: " + genericDao.findAll(Usuario.class));
				
				Assert.assertTrue(new Integer(5).equals(genericDao.findAll(Usuario.class).size()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
	}
	
	
	
	

	public void obtenerUsuario(){
		
		
		UserDetails ud = customUserDetailsService.loadUserByUsername("julio.cortazar");
		
		Assert.assertTrue(ud != null);
	}
	
	

	public void obtenerUsuarios(){
		
		try {
			System.out.println("Cantidad de usuarios: " + usuarioService.obtenerUsuarios().size());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	

	public void obtenerComponenteID(){
		String comp = usuarioService.obtenerComponenteID("CALCULO_SOLICITUD_CREDITOS");
		
		Assert.assertNotNull(comp);
		
		
	}
	
	@Test
	public void obtenerListaEstablecimientosXUsuario(){
		
		Usuario u= usuarioService.obtenerUsuario(1L);
		if (u != null){
			System.out.println("Usuario: " + u.getNombreUsuario());
			List<Establecimiento> lista= serviceFacade.getUsuarioService().obtenerEstablecimientosPorUsuario(u);
			System.out.println("-------------------------------------------------------");
			System.out.println("Establecimientos:");
			for (Establecimiento e: lista){
				System.out.println(e.getNombre());
			}
		}
		Assert.assertTrue(1==1);
		
		
	}


}
