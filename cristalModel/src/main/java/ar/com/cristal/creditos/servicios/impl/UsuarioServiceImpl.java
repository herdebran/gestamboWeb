package ar.com.cristal.creditos.servicios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.ui.WebAuthenticationDetails;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.cristal.creditos.common.Constantes;
import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.entity.login.ComponenteDePantalla;
import ar.com.cristal.creditos.entity.login.Establecimiento;
import ar.com.cristal.creditos.entity.login.Perfil;
import ar.com.cristal.creditos.entity.login.Usuario;
import ar.com.cristal.creditos.entity.sucursales.Sucursal;
import ar.com.cristal.creditos.servicios.ServiceFacade;

@Service("usuarioService")
public class UsuarioServiceImpl {
	
	private Logger log = Logger.getLogger(UsuarioServiceImpl.class);
	@Autowired
	protected ServiceFacade serviceFacade;
	
	@Autowired
	protected GenericDao genericDao;

	/**
	 * Devuelve un usuario a partir de su nombre de usuario
	 * @param nombreUsuario
	 * @return
	 * @throws Exception 
	 */
	public Usuario obtenerUsuarioPorNombreUsuario(String nombreUsuario) throws Exception{
		
		try {
			String usuario =  nombreUsuario.replace("'", "");
			@SuppressWarnings("unchecked")
			List<Usuario> results = (List<Usuario>) genericDao.getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Usuario.class)
			    .add(Restrictions.eq("nombreUsuario",usuario)) );
			
			if (!results.isEmpty()) 
				return results.get(0);
			else
				return null;
		} catch (DataAccessException e) {
			log.error("Error de logueo de usuario:" + nombreUsuario + " " + e.getMessage(), e);
			throw new Exception(e);
		}
		
	}

	

	/***
	 * Dado un id, devuelve el usuario de la base
	 * @param id
	 * @return
	 */
	public Usuario obtenerUsuario(Long id) {
		return genericDao.get(Usuario.class, id);
	}
	
	
	
	
	
	public List<Usuario> obtenerUsuarios(){
		return obtenerUsuarios(false);
			
	}
	
	public List<Usuario> obtenerUsuarios(boolean incluirBorrados){
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Usuario.class);
		
		if (!incluirBorrados)
			criteria.add(Restrictions.eq("borrado",false));
		
	    criteria.addOrder(Order.asc("apellido"));
		criteria.addOrder(Order.asc("nombre"));
		
		@SuppressWarnings("unchecked")
		List<Usuario> result = (List<Usuario>)genericDao.getHibernateTemplate().findByCriteria(criteria);
		
		return result;
			
	}
	
	/***
	 * Dado un id, devuelve el usuario de la base
	 * @param id
	 * @return
	 */
	public List<Perfil>obtenerPerfiles(){
		 List<Perfil> result = genericDao.find("FROM Perfil p ORDER BY p.nombre");
		 return result;
	}
	
	public void borrarPerfil(int id){
		log.info("borrarPerfil: por borrar (id): " + id );
		Perfil p = new Perfil();
		p.setId(new Long(id));
		this.genericDao.delete(p);
		log.info("borrarPerfil(id): " + id +" de perfil borrado ok.");

	}
	
	
	@Transactional
	public void guardarPerfil(Perfil p){
		log.info("guardarPerfil... " );
		this.genericDao.saveOrUpdate(p);
		log.info("guardarPerfil guardado ok.");
		
	}
	
	
	

	public List<Sucursal> obtenerSucursales(){
		return genericDao.find("From Sucursal u order by u.nombre");
		
		
	}

	@Transactional
	public void persistirUsuario(Usuario u) throws Exception {
		log.info("persistirUsuario(): " + u.getNombreUsuario());
		
		try {
			genericDao.saveOrUpdate(u);
		} catch (Exception e) {
			log.error("persistirUsuario(): " + e.getMessage(), e);
			throw e;
		}
		
	}
	
	/***
	 * Dado un id, devuelve el usuario de la base
	 * @param id
	 * @return
	 */
	public Sucursal obtenerSucursal(Long id) {
//		log.info("UsuarioServiceImpl - obtenerSucursal(): " + id.toString());
		return genericDao.get(Sucursal.class, id);
	}
	@Transactional
	public void borrarUsuario(Long id) {
		log.info("UsuarioServiceImpl - borrarUsuario(): " + id.toString());
		Usuario u = obtenerUsuario(id);
		u.setBorrado(true);
		genericDao.update(u);
		log.info("UsuarioServiceImpl - borrarUsuario(): OK" + id.toString());
	}

	
	
	
	/**
	 * obtiene todos los componentes asociados a un perfil
	 */
		public List<ComponenteDePantalla> obtenerComponentes(){
				List<ComponenteDePantalla> componentes = new ArrayList<ComponenteDePantalla>();
				
				componentes = this.genericDao.find("FROM ComponenteDePantalla");
				if(!componentes.isEmpty()){
					return componentes;
				}else{
					return new ArrayList<ComponenteDePantalla>();
			}
		}

	public String obtenerComponenteID(String componente) {
		Object[] param = {componente};
		List<Integer> ids = this.genericDao.find("select c.id FROM ComponenteDePantalla as c where c.nombre = ?", param);
				
		if (!ids.isEmpty())
			return ids.get(0).toString();
		else
			return null;
	}



	public Usuario obtenerUsuarioLogueado() throws Exception {
		
		Object details = SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
		
		if (details instanceof UserDetails) {
            String userName = ((UserDetails)details).getUsername();
            Usuario u = obtenerUsuarioPorNombreUsuario(userName);
            
            Object wadDetail = SecurityContextHolder.getContext().getAuthentication().getDetails();
            if (wadDetail instanceof WebAuthenticationDetails)
            	u.setSessionId( ((WebAuthenticationDetails) wadDetail).getSessionId());
            return u;
		} else 
			throw new Exception("Usuario no logueado");
	}



	@SuppressWarnings("unchecked")
	public List<Usuario> obtenerUsuariosComercializadores() {
		List<Usuario> usuarios = obtenerUsuarios();
		 
		usuarios = (List<Usuario>) CollectionUtils.select(usuarios, new Predicate() {
			
			public boolean evaluate(Object obj) {
				Usuario u = (Usuario) obj;
				return "COMERCIALIZADOR".equalsIgnoreCase(u.getPerfil().getNombre());
			}
		});
		
		return usuarios;
	}
		
	@Transactional
	public Boolean cambiarPasswordUsuario(String password,String nuevaPassword) throws Exception{
		Usuario usuarioLogueado = obtenerUsuarioLogueado();
		boolean cambioOK =usuarioLogueado.getPassword().equals(password);;
		if (cambioOK) {
			usuarioLogueado.setPassword(nuevaPassword);
			persistirUsuario(usuarioLogueado);			
		}
		return cambioOK;
	}
	
	
	
	/***
	 * De una lista de nombres de usuarios separados por | devuelve true si existe
	 * @param listaUsuario
	 * @return
	 * @throws Exception
	 */
	public boolean existeUsuarioEnListaString(String listaUsuario) throws Exception{
		StringTokenizer tokenizer = new StringTokenizer(listaUsuario, "|");
		List<String> usuariosAnulaCreditos = new ArrayList<String>();
		final Usuario usuario = obtenerUsuarioLogueado();
		
		
		while (tokenizer.hasMoreTokens()){
			String nombreUsuario = tokenizer.nextToken();
			usuariosAnulaCreditos.add(nombreUsuario);
		}
		 
		if (!usuariosAnulaCreditos.isEmpty()) {
			boolean existe = CollectionUtils.exists(usuariosAnulaCreditos, new Predicate() {
			
			@Override
			public boolean evaluate(Object id) {
				return usuario.getNombreUsuario().equalsIgnoreCase((String) id);
			}
		 });
		 return existe;
		}
		
		return false;
	}



	public boolean tienePermisoAltaReparticion() throws Exception {
		String lista = serviceFacade.getProperty(Constantes.USUARIOS_ALTA_REPARTICION);
		return existeUsuarioEnListaString(lista);
	}


	public Sucursal obtenerSucursalPorNombre(String nombre) {
		log.info("UsuarioServiceImpl - obtenerSucursalPorNombre(): " + nombre);

		List<Sucursal> results = (List<Sucursal>) genericDao.getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Sucursal.class)
			    .add(Restrictions.eq("nombre",nombre)) );
			
		log.info("UsuarioServiceImpl - obtenerSucursalPorNombre() - Fin ");
		
		if (!results.isEmpty()) 
			return results.get(0);
		else
			return null;	

		
	}
	
	/***
	 * Dado un nombre de perfil devuelve la instancia
	 * @param id
	 * @return
	 */
	public Perfil obtenerPerfilPorNombre(String nombre){
		 
		 
		 
		List<Perfil> results = (List<Perfil>) genericDao.getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Perfil.class)
				    .add(Restrictions.eq("nombre",nombre)) );
				
			
			if (!results.isEmpty()) 
				return results.get(0);
			else
				return null;	

			
	}
	
	public List<Establecimiento> obtenerEstablecimientosPorUsuario(Usuario u){
		 
		 
		 
		List<Establecimiento> results = (List<Establecimiento>) genericDao.getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Establecimiento.class)
				    .add(Restrictions.eq("usuario",u)) );
				
			
			if (!results.isEmpty()) 
				return results;
			else
				return null;	

			
	}
	
	public List<Establecimiento> obtenerEstablecimientosUsuarioLogueado (){
		Usuario u;
		try {
			u = obtenerUsuarioLogueado();
			return obtenerEstablecimientosPorUsuario(u);

		} catch (Exception e) {
			return null;
		}
		
	}
	
	/***
	 * Dado un id, devuelve el establecimiento de la base
	 * @param id
	 * @return
	 */
	public Establecimiento obtenerEstablecimiento(Long id) {
		return genericDao.get(Establecimiento.class, id);
	}
	
	@Transactional
	public void setearEstablecimientoXUsuario (long usuarioId,long establecimientoId){
		Usuario u= obtenerUsuario(usuarioId);
		
		if (u != null){
			u.setEstablecimientoActual(establecimientoId);
			genericDao.update(u);
			log.info("UsuarioServiceImpl - Usuario:" + u.getNombreUsuario() + " - Set establecimiento actual id:" + establecimientoId);
		} else {
			log.error("UsuarioServiceImpl - No se encontro usuario con id:" + usuarioId);
		}
		
	}
}











