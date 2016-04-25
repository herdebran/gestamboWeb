package ar.com.cristal.creditos.servicios.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.cristal.creditos.common.CristalProperties;
import ar.com.cristal.creditos.dao.GenericDao;
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
	public void guardarVaca(Vaca vaca) throws Exception {
		try {
			genericDao.save(vaca);
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " guardarVaca(): " + e.getMessage(), e);
			throw e;
		}
		
	}



}
