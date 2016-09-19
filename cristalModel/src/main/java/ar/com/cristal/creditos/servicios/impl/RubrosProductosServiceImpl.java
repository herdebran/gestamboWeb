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
import ar.com.cristal.creditos.common.TipoMovStockEnum;
import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.entity.creditos.CuotaSocial;
import ar.com.cristal.creditos.entity.login.Establecimiento;
import ar.com.cristal.creditos.entity.login.Usuario;
import ar.com.cristal.creditos.entity.tambo.Categoria;
import ar.com.cristal.creditos.entity.tambo.CeloServicio;
import ar.com.cristal.creditos.entity.tambo.Inseminador;
import ar.com.cristal.creditos.entity.tambo.MovimientoStock;
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

				genericDao.save(prod);
				if (prod.getId() != null)
					log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Se creó producto id: " + prod.getId());
			} else {
				genericDao.merge(prod);
				log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Se actualizo el producto: " + prod.getId());

			}
			
			return prod;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " persistirProducto(): " + e.getMessage(), e);
			throw e;
		}
		
	}

	@Override
	public Producto obtenerProductoById(Long id) throws Exception{
		Producto result =null;
		result = genericDao.get(Producto.class, id);
		
		if (result != null && result.getEstablecimiento() != null){
			if (! result.getEstablecimiento().equals(serviceFacade.obtenerEstablecimientoLogueado()))
					result=null;
		}
		
		return result;
		
	}
	
	/**
	 * Metodo que solo persiste el Movimiento de Stock
	 * Deberia ser llamado por un metodo transaccional que persista el Mov y acualice el Stock del Porducto en cuestion
	 * @param mov
	 * @return
	 * @throws Exception
	 */
	private MovimientoStock persistirMovimientoStock(MovimientoStock mov) throws Exception {
		try {
			if (mov.getId() == null){
				//ALTA: Agrega usuario y Fecha
				mov.setFechaAlta(serviceFacade.getFechaActual());
				mov.setEstablecimiento(serviceFacade.obtenerEstablecimientoLogueado());
				mov.setUsuarioAlta(serviceFacade.obtenerUsuarioLogueadoId());
				mov.setEliminado(false);
			}
			genericDao.saveOrUpdate(mov);
			if (mov.getId() != null)
				log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Se persistió el MovStock con id: " + mov.getId());
			
			return mov;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " persistirMovimientoStock(): " + e.getMessage(), e);
			throw e;
		}
		
	}
	
	/**
	 * Inserta el movimiento de Stock y actualiza el Stock de la tabla de Producto
	 * @param prod
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional
	public Producto cargarMovStockProducto(Producto prod,double cantidad,TipoMovStockEnum tipoMov) throws Exception {
		try {
			
			double cantAlgebraica=0.0;
			
			//Primer paso: Inserta el mov de Stock
			MovimientoStock ms=new MovimientoStock();
			ms.setCantidadEntra(0.0);
			if (TipoMovStockEnum.COMPRA.equals(tipoMov) || TipoMovStockEnum.PRODUCCION.equals(tipoMov)){
				ms.setCantidadEntra(cantidad);
				cantAlgebraica=cantidad;
			}
			ms.setCantidadSale(0.0);
			if (TipoMovStockEnum.VENTA.equals(tipoMov) || TipoMovStockEnum.CONSUMO.equals(tipoMov)){
				ms.setCantidadSale(cantidad);
				cantAlgebraica=cantidad * (-1L);
			}
				
			ms.setEliminado(false);
			ms.setPrecioUnitario(prod.getPrecioUnitario());
			ms.setProducto(prod);
			ms.setTipoMov(tipoMov);
			ms.setUnidad(prod.getUnidad());
			persistirMovimientoStock(ms);
			
			//Segundo paso: se suma (o resta el Stock) del producto
			prod.setStock(prod.getStock() + cantAlgebraica);
			persistirProducto(prod);
			
			return prod;
			
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " cargarMovStockProducto(): " + e.getMessage(), e);
			throw e;
		}
		
	}


}
