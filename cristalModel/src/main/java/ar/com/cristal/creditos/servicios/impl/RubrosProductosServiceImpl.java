package ar.com.cristal.creditos.servicios.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.cristal.creditos.common.CristalProperties;
import ar.com.cristal.creditos.common.TipoCeloServicioEnum;
import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.entity.creditos.CuotaSocial;
import ar.com.cristal.creditos.entity.login.Establecimiento;
import ar.com.cristal.creditos.entity.login.Usuario;
import ar.com.cristal.creditos.entity.tambo.Categoria;
import ar.com.cristal.creditos.entity.tambo.CeloServicio;
import ar.com.cristal.creditos.entity.tambo.Inseminador;
import ar.com.cristal.creditos.entity.tambo.Producto;
import ar.com.cristal.creditos.entity.tambo.Raza;
import ar.com.cristal.creditos.entity.tambo.ResultadoTacto;
import ar.com.cristal.creditos.entity.tambo.Rodeo;
import ar.com.cristal.creditos.entity.tambo.TipoServicio;
import ar.com.cristal.creditos.entity.tambo.Toro;
import ar.com.cristal.creditos.entity.tambo.Vaca;
import ar.com.cristal.creditos.servicios.RubrosProductosService;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.servicios.VacasService;
import ar.com.cristal.creditos.util.DateUtil;

@Service("RubrosProductosService")
public class RubrosProductosServiceImpl implements RubrosProductosService {

	private Logger log = Logger.getLogger(RubrosProductosServiceImpl.class);

	@Autowired
	protected GenericDao genericDao;

	@Autowired
	private ServiceFacade serviceFacade;
	
	@Autowired
	private UsuarioServiceImpl usuarioService;

	private CristalProperties cristalProperties = CristalProperties
			.getInstance();

	@Override
	@Transactional
	public Producto persistirProducto(Producto prod) throws Exception {
		try {
			if (prod.getId() == null){
				//ALTA: Agrega usuario y Fecha
				prod.setFechaAlta(serviceFacade.getFechaActual());
				prod.setEstablecimiento(serviceFacade.obtenerEstablecimientoLogueado());
				prod.setUsuarioAlta(serviceFacade.obtenerUsuarioLogueadoId());
				prod.setActivo(true);
				prod.setStock(0.0);
				prod.setPrecioUnitario(0.0);
			}
			genericDao.saveOrUpdate(prod);
			if (prod.getId() != null)
				log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Se creó producto id: " + prod.getId());
			
			return prod;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " persistirProducto(): " + e.getMessage(), e);
			throw e;
		}
		
	}

	
}
