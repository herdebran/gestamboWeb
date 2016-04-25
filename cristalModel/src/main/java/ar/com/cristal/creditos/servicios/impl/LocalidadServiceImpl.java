package ar.com.cristal.creditos.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.localidad.Localidad;
import ar.com.cristal.creditos.localidad.Provincia;
import ar.com.cristal.creditos.servicios.LocalidadService;
import ar.com.cristal.creditos.servicios.ServiceFacade;

@Service("localidadService")
public class LocalidadServiceImpl implements LocalidadService {
	private Logger log = Logger.getLogger(LocalidadServiceImpl.class);

	@Autowired
	protected GenericDao genericDao;
	
	@Autowired
	private ServiceFacade serviceFacade;
	
	@SuppressWarnings("unchecked")
	public Localidad obtenerLocalidad(Long cliente_id){
		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - inicio");
		List<Localidad> localidades = new ArrayList<Localidad>();
		
		localidades = genericDao.getSessionFactory().getCurrentSession().createCriteria(Localidad.class)
		.add(Restrictions.eq("cliente.id", cliente_id)).list();
		if (!localidades.isEmpty()){
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " obtenerLocalidad:fin");
			return localidades.get(0);
		}else{
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " error obtenerLocalidad()");
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Provincia> obtenerProvincias(){
		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - inicio");
		List<Provincia> provincias = new ArrayList<Provincia>();
		provincias = genericDao.getSessionFactory().getCurrentSession().createCriteria(Provincia.class)
				.addOrder(Order.asc("nombre"))
				.list();
     	return provincias;
				
 	}
	
	@SuppressWarnings("unchecked")
	public List<Localidad> obtenerLocalidades(){
		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - inicio");
		List<Localidad> localidades = new ArrayList<Localidad>();
		localidades = genericDao.getSessionFactory().getCurrentSession().createCriteria(Localidad.class)
				.addOrder(Order.asc("nombre"))
				.list();
		return localidades;
	}
}
