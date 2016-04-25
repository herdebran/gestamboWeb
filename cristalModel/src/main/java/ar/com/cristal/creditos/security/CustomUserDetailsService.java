package ar.com.cristal.creditos.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.User;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.com.cristal.creditos.entity.login.Usuario;
import ar.com.cristal.creditos.servicios.ServiceFacade;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	private Logger log = Logger.getLogger(CustomUserDetailsService.class);
	
	@Autowired
 	ServiceFacade facade;
	
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
		
		log.info("Iniciando sesión: " + userName);
		Usuario u = null;
		
		try {
			u = facade.obtenerUsuarioPorNombreUsuario(userName);
		} catch (Exception e) {
			log.error("Error en logueo de usuario: " + e.getMessage(), e);
			throw new UsernameNotFoundException("Sesión no válida");
		}
		
		
		if (u == null || u.isBorrado()) {
			log.info("Usuario no encontrado");
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
		
		log.info("Inició sesión Usuario: " + u.getNombreUsuario() + " Password: ************");
		
		User user = new User(u.getNombreUsuario() , u.getPassword(), true, getAuthorities(true));
		
		
        return user;
    }
	
	
 
    private GrantedAuthority[] getAuthorities(boolean isAdmin) {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
        authList.add(new GrantedAuthorityImpl("ROLE_USER"));
        if (isAdmin) {
            authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
        }
        return authList.toArray(new GrantedAuthority[] {});
    }
 
    

}

 