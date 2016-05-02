package ar.com.cristal.creditos.servicios.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.cristal.creditos.common.CristalProperties;
import ar.com.cristal.creditos.common.EstadoClienteEnum;
import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.entity.creditos.Cliente;
import ar.com.cristal.creditos.entity.login.Establecimiento;
import ar.com.cristal.creditos.entity.tambo.Rodeo;
import ar.com.cristal.creditos.entity.tambo.Vaca;
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

}
