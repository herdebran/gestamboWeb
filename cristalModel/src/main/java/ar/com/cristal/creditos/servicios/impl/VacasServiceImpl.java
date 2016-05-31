package ar.com.cristal.creditos.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.cristal.creditos.common.CristalProperties;
import ar.com.cristal.creditos.common.EstadoClienteEnum;
import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.entity.creditos.Cliente;
import ar.com.cristal.creditos.entity.login.Establecimiento;
import ar.com.cristal.creditos.entity.tambo.Categoria;
import ar.com.cristal.creditos.entity.tambo.Raza;
import ar.com.cristal.creditos.entity.tambo.ResultadoTacto;
import ar.com.cristal.creditos.entity.tambo.Rodeo;
import ar.com.cristal.creditos.entity.tambo.Toro;
import ar.com.cristal.creditos.entity.tambo.Vaca;
import ar.com.cristal.creditos.localidad.Localidad;
import ar.com.cristal.creditos.localidad.Provincia;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.servicios.VacasService;

@Service("vacasService")
public class VacasServiceImpl implements VacasService {

	private Logger log = Logger.getLogger(VacasServiceImpl.class);

	@Autowired
	protected GenericDao genericDao;

	@Autowired
	private ServiceFacade serviceFacade;

	private CristalProperties cristalProperties = CristalProperties
			.getInstance();

	@Override
	@Transactional
	public Vaca guardarVaca(Vaca vaca) throws Exception {
		try {
			if (vaca.getId() == null){
				//ALTA: Agrega usuario y Fecha
				vaca.setFechaAlta(serviceFacade.getFechaActual());
				vaca.setEstablecimiento(serviceFacade.obtenerEstablecimientoLogueado());
				vaca.setUsuarioAlta(serviceFacade.obtenerUsuarioLogueadoId());
			}
			genericDao.saveOrUpdate(vaca);
			return vaca;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " guardarVaca(): " + e.getMessage(), e);
			throw e;
		}
		
	}

	@Override
	public Vaca obtenerVacaById(Long id){
		Vaca result = genericDao.get(Vaca.class, id);				
		return result;
		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Vaca obtenerVacaPorRP(final String rp) throws Exception{
		Vaca vaca = null;
		
		try {
			Establecimiento establecimiento=serviceFacade.obtenerEstablecimientoLogueado();
			
			List<Vaca> vacas = genericDao.getSessionFactory().getCurrentSession().createCriteria(Vaca.class)
				.add(Restrictions.eq("rp", rp).ignoreCase())
				.add(Restrictions.eq("establecimiento", establecimiento)).list();
			  
			if(vacas.size() == 1){
				vaca = vacas.get(0);
			}
			
			return vaca;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " obtenerVacaPorRP(): " + e.getMessage(), e);
			throw e;
		}
	}
	
	@Override
	@Transactional
	public void persistirRodeo(Rodeo rodeo) throws Exception {
		try {
			rodeo.setFechaAlta(serviceFacade.getFechaActual());
			rodeo.setEstablecimiento(serviceFacade.obtenerEstablecimientoLogueado());
			genericDao.saveOrUpdate(rodeo);
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " se crea rodeo "+ rodeo.getNombre() + " ok.");
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " persistirRodeo(): " + e.getMessage(), e);
			throw e;
		}
		
	}
	
	@Override
	public void eliminarRodeo(Rodeo rodeo) throws Exception{
		try {
			rodeo.setEliminado(false);
			persistirRodeo(rodeo);
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " se elimina rodeo "+ rodeo.getNombre() + " ok.");
			
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " EliminarRodeo(): " + e.getMessage(), e);
			throw e;
		}
	}

	@Override
	public Rodeo obtenerRodeoById(Long id){
		Rodeo result = genericDao.get(Rodeo.class, id);				
		return result;
		
	}

	private Raza obtenerRazaById(Long id){
		Raza result = genericDao.get(Raza.class, id);				
		return result;
		
	}

	@Override
	public void eliminarRodeoById(Long id)throws Exception{
		try {
			Rodeo r = obtenerRodeoById(id);
			eliminarRodeo(r);
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " EliminarRodeoById(): " + e.getMessage(), e);
			throw e;
		}
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Raza> obtenerRazas(){
		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " obtenerRazas()- inicio");
		List<Raza> razas = new ArrayList<Raza>();
		razas = genericDao.getSessionFactory().getCurrentSession().createCriteria(Raza.class)
				.addOrder(Order.asc("nombre"))
				.list();
     	return razas;
				
 	}

	/**
	 * Devuelve la lista de rodeos del Establecmiento Logueado
	 * @return
	 * @throws Exception
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Rodeo> obtenerRodeos() throws Exception{
		try {
			Establecimiento establecimiento=serviceFacade.obtenerEstablecimientoLogueado();
			
			List<Rodeo> rodeos = genericDao.getSessionFactory().getCurrentSession().createCriteria(Rodeo.class)
				.add(Restrictions.eq("eliminado", Boolean.FALSE))
				.add(Restrictions.eq("establecimiento", establecimiento)).list();
			  
			return rodeos;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " obtenerRodeos(): " + e.getMessage(), e);
			throw e;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Categoria> obtenerCategorias(long idRaza) throws Exception{
		try {
			Raza raza = obtenerRazaById(idRaza);
			List<Categoria> lista = genericDao.getSessionFactory().getCurrentSession().createCriteria(Categoria.class)
				.add(Restrictions.eq("raza", raza))
				.addOrder(Order.asc("id")).list();
			  
			return lista;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " obtenerCategorias(): " + e.getMessage(), e);
			throw e;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ResultadoTacto> obtenerResultadosTacto(){
		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " obtenerResultadosTacto()- inicio");
		List<ResultadoTacto> resul = new ArrayList<ResultadoTacto>();
		resul = genericDao.getSessionFactory().getCurrentSession().createCriteria(ResultadoTacto.class)
				.addOrder(Order.asc("resultado"))
				.list();
     	return resul;
				
 	}
	
	@Override
	@Transactional
	public Toro persistirToro(Toro toro) throws Exception {
		try {
			if (toro.getId() == null){
				//ALTA: Agrega usuario y Fecha
				toro.setFechaAlta(serviceFacade.getFechaActual());
				toro.setEstablecimiento(serviceFacade.obtenerEstablecimientoLogueado());
				toro.setUsuarioAlta(serviceFacade.obtenerUsuarioLogueadoId());
				toro.setEliminado(false);
			}
			genericDao.saveOrUpdate(toro);
			if (toro.getId() != null)
				log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Se creó toro id: " + toro.getId());
			
			return toro;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " persistirToro(): " + e.getMessage(), e);
			throw e;
		}
		
	}


	/**
	 * Devuelve TOROS del Establecmiento Logueado
	 * @return
	 * @throws Exception
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Toro> obtenerToros() throws Exception{
		try {
			Establecimiento establecimiento=serviceFacade.obtenerEstablecimientoLogueado();
			
			List<Toro> toros = genericDao.getSessionFactory().getCurrentSession().createCriteria(Toro.class)
				.add(Restrictions.eq("eliminado", Boolean.FALSE))
				.add(Restrictions.eq("establecimiento", establecimiento))
				.addOrder(Order.asc("nombre")).list();
			  
			return toros;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " obtenerToros(): " + e.getMessage(), e);
			throw e;
		}
	}

	@Override
	public List<Toro> buscarToroPorNombre(String nombre) throws Exception {
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Toro.class);
			criteria.add(Restrictions.like("nombre",nombre,MatchMode.ANYWHERE).ignoreCase());
			criteria.add(Restrictions.eq("establecimiento", serviceFacade.obtenerEstablecimientoLogueado()));
			List<Toro>  toros =genericDao.findByCriteria(criteria);
			return toros;
		} catch (Exception e){
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " buscarToroPorNombre(): " + e.getMessage(), e);
			throw e;
			
		}
	}


}
