package ar.com.cristal.creditos.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.Authentication;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.userdetails.User;

import ar.com.cristal.creditos.entity.login.Usuario;
import ar.com.cristal.creditos.servicios.ServiceFacade;
/***
 * Esta clase sirve para realizar el logueo de un usuario desde test
 * @author daniel.madera
 *
 */
public class LogearUsuario {
	private static Logger log = Logger.getLogger(LogearUsuario.class);	
	public static void loguear(final ServiceFacade serviceFacade, final String usuario) {
		 SecurityContextHolder.getContext().setAuthentication(new Authentication() {
				
				public String getName() {
					return usuario;
				}
				
				public void setAuthenticated(boolean arg0) throws IllegalArgumentException {
					
				}
				
				public boolean isAuthenticated() {
					return true;
				}
				
				public Object getPrincipal() {
					try {
						Usuario u = serviceFacade.obtenerUsuarioPorNombreUsuario(usuario);
						
						User user = new User(u.getNombreUsuario() , u.getPassword(), true, getAuthorities(true));
						
						return user;
					} catch (Exception e) {
						log.error(e);
						return null;
					}
				}
				
				public Object getDetails() {
					try {
						Usuario u = serviceFacade.obtenerUsuarioPorNombreUsuario(usuario);
						
						User user = new User(u.getNombreUsuario() , u.getPassword(), true, getAuthorities(true));
						
						return user;
					} catch (Exception e) {
						log.error(e);
						return null;
					}
				}
				
				public Object getCredentials() {
					return null;
				}
				
				public GrantedAuthority[] getAuthorities() {
					List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
			        authList.add(new GrantedAuthorityImpl("ROLE_USER"));
			      
			            authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
			      
			        return authList.toArray(new GrantedAuthority[] {});
			   }
				
				 private GrantedAuthority[] getAuthorities(boolean isAdmin) {
				        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
				        authList.add(new GrantedAuthorityImpl("ROLE_USER"));
				        if (isAdmin) {
				            authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
				        }
				        return authList.toArray(new GrantedAuthority[] {});
				    }
			});
		
	}

}
