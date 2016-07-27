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
import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.entity.creditos.CuotaSocial;
import ar.com.cristal.creditos.entity.login.Establecimiento;
import ar.com.cristal.creditos.entity.login.Usuario;
import ar.com.cristal.creditos.entity.tambo.Categoria;
import ar.com.cristal.creditos.entity.tambo.CeloServicio;
import ar.com.cristal.creditos.entity.tambo.Inseminador;
import ar.com.cristal.creditos.entity.tambo.Raza;
import ar.com.cristal.creditos.entity.tambo.ResultadoTacto;
import ar.com.cristal.creditos.entity.tambo.Rodeo;
import ar.com.cristal.creditos.entity.tambo.TipoServicio;
import ar.com.cristal.creditos.entity.tambo.Toro;
import ar.com.cristal.creditos.entity.tambo.Vaca;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.servicios.VacasService;
import ar.com.cristal.creditos.util.DateUtil;

@Service("vacasService")
public class VacasServiceImpl implements VacasService {

	private Logger log = Logger.getLogger(VacasServiceImpl.class);

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
	public Vaca obtenerVacaById(Long id) throws Exception{
		return obtenerVacaById(id,false);
		
	}
	
	public Vaca obtenerVacaById(Long id,boolean todosLosEstablecimientos) throws Exception{
		Vaca result =null;
		result = genericDao.get(Vaca.class, id);
		
		if (! todosLosEstablecimientos){
			if (result != null && result.getEstablecimiento() != null){
				if (! result.getEstablecimiento().equals(serviceFacade.obtenerEstablecimientoLogueado()))
						result=null;
			}
		}
		
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
	public Rodeo persistirRodeo(Rodeo rodeo) throws Exception {
		try {
			if (rodeo.getId() == null){
				//ALta de Rodeo 
				rodeo.setFechaAlta(serviceFacade.getFechaActual());
				rodeo.setEstablecimiento(serviceFacade.obtenerEstablecimientoLogueado());
				rodeo.setEliminado(false);
			}
			
			genericDao.saveOrUpdate(rodeo);
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " se crea rodeo "+ rodeo.getNombre() + " ok.");
			return rodeo;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " persistirRodeo(): " + e.getMessage(), e);
			throw e;
		}
		
	}
	
	@Override
	public void eliminarRodeo(Rodeo rodeo) throws Exception{
		try {
			rodeo.setEliminado(true);
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
			if (r != null)
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

	@Override
	public List<Rodeo> buscarRodeoPorNombre(String nombre) throws Exception {
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Rodeo.class);
			criteria.add(Restrictions.like("nombre",nombre,MatchMode.ANYWHERE).ignoreCase());
			criteria.add(Restrictions.eq("establecimiento", serviceFacade.obtenerEstablecimientoLogueado()));
			List<Rodeo>  rodeos =genericDao.findByCriteria(criteria);
			return rodeos;
		} catch (Exception e){
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " buscarRodeoPorNombre(): " + e.getMessage(), e);
			throw e;
			
		}
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Vaca> listarVacaXRodeoId(final Long rodeoId) throws Exception{
		Vaca vaca = null;
		
		try {
			String queryVacasXRodeo="select * from Vaca where rodeo_id = :rodeoId and eliminado=0";
			SQLQuery query = serviceFacade.createSQLQuery(queryVacasXRodeo);
			query.addEntity(Vaca.class);
			query.setLong("rodeoId", rodeoId);

			@SuppressWarnings("unchecked")
			List<Vaca> result = query.list();

			return result;			
			
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " listarVacaXRodeoId(): " + e.getMessage(), e);
			throw e;
		}
	}
	
	
	/**
	 * Según el criterio de busqueda ingresado por el usuario, 
	 * se procede a ejecutar una busqueda de VACAS en la base de datos
	 * por Rodeo, RP o RC. Maneja solo el universo del Establec. logueado
	 * Modo de uso
	 * obtenerClientesByParam(rp_230);<br></br>
	 * obtenerClientesByParam(rc_19656552);<br></br>
	 * obtenerClientesByParam(rodeo_12);
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<Vaca> obtenerVacasByParam(String param) throws Exception{

		try {
			
			Usuario u = usuarioService.obtenerUsuarioLogueado();
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " realiza búsqueda de vaca: " + param);
			
			String[] params = param.split("_");
			
			List<Vaca> result = new ArrayList<Vaca>();
			
			if (params[0].equals("rp")){	
				//Busqueda por rp
				String qry = "from Vaca where rp = "+ params[1];
				qry = qry+ " and establecimiento_id = "+ serviceFacade.obtenerEstablecimientoLogueado().getId();
				qry = qry+ " and eliminado = false";
				qry = qry + " order by rp";
				result = genericDao.find(qry);
				
			}else if (params[0].equals("rc")){			
//				Busqueda por rc
				String qry = "from Vaca where rc = "+ params[1];
				qry = qry+ " and establecimiento_id = "+ serviceFacade.obtenerEstablecimientoLogueado().getId();
				qry = qry+ " and eliminado = false";
				qry = qry + " order by rp";
				result = genericDao.find(qry);
			}else if (params[0].equals("rodeo")){	
				//Busqueda por rodeo
				String qry = "from Vaca where rodeo_id = "+ params[1];
				qry = qry+ " and establecimiento_id = "+ serviceFacade.obtenerEstablecimientoLogueado().getId();
				qry = qry+ " and eliminado = false";
				qry = qry + " order by rp";
				result = genericDao.find(qry);
			}
			
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " realiza búsqueda de Vaca: " + param + " resultado: " + result.size() + " ocurrencias." ) ;

			
			return result;
		} catch (Exception e) {
			log.error("Se produjo un error al obtener las vacas." + e.getMessage(), e);
			throw e;
		}

	}	
	
	@Override
	@Transactional
	public Inseminador persistirInseminador(Inseminador inseminador) throws Exception {
		try {
			if (inseminador.getId() == null){
				//ALTA: Agrega usuario y Fecha
				inseminador.setFechaAlta(serviceFacade.getFechaActual());
				inseminador.setEstablecimiento(serviceFacade.obtenerEstablecimientoLogueado());
				inseminador.setUsuarioAlta(serviceFacade.obtenerUsuarioLogueadoId());
			}
			genericDao.saveOrUpdate(inseminador);
			return inseminador;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " persistirInseminador(): " + e.getMessage(), e);
			throw e;
		}
		
	}
	/**
	 * Persiste el celo/servicio, 
	 * Incrementa los servicios a la Vaca, Toro e Inseminador
	 * actualizaSituacionActual=true
	 * 		- Resta el Stock de Semen
	 *  	- Actualiza ultimo servicio en la tabla Vacas
	 */
	@Override
	@Transactional
	public CeloServicio persistirCeloServicio(CeloServicio celoServicio,boolean actualizaSituacionActual) throws Exception {
		try {
			if (celoServicio.getId() == null){
				//ALTA: Agrega usuario y Fecha
				celoServicio.setFechaAlta(serviceFacade.getFechaActual());
				celoServicio.setUsuarioAlta(serviceFacade.obtenerUsuarioLogueadoId());
			}
			genericDao.saveOrUpdate(celoServicio);
			
			//Si hay toro, actualizo su estadistica
			if (celoServicio.getToro() != null)
				registrarServicioDadoToro(celoServicio.getToro().getId(),actualizaSituacionActual);
			
			//Si hay Inseminador, actualizo su estadistica
			if (celoServicio.getInseminador() != null)
				registrarServicioDadoInseminador(celoServicio.getInseminador().getId());
			
			
			//Actualizar ultimo Servicio Vaca
			//Incrementar Servicios Dados Vaca
			
			return celoServicio;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " persistirCeloServicio(): " + e.getMessage(), e);
			throw e;
		}
		
	}

	/**
	 * Incrementa los servicios de un inseminador
	 * @param id
	 */
	private void registrarServicioDadoInseminador(Long id) {
		Inseminador i;
		try {
			i = obtenerInseminadorById(id);
			if (i != null){
				i.setServiciosCampo(i.getServiciosCampo()+1);
				
				persistirInseminador(i);
				log.info("Se actualizan servicios dados inseminador id: " + id + ". Cant: " + i.getServiciosCampo());
			}

		} catch (Exception e) {
			log.error("Error al registrarServicioDadoInseminador:" + e.getMessage() );
		}
		
		
	}

	/**
	 * Incrementa el servicio de Un toro y resta el stock de semen.
	 * @param id
	 * @param actualizaSituacionActual
	 */
	private void registrarServicioDadoToro(Long id,	boolean actualizaSituacionActual) {
		try {
			Toro t = obtenerToroById(id);
			t.setServiciosCampo(t.getServiciosCampo()+1);
			
			if (actualizaSituacionActual)
				registrarSalidaSemenPorIdToro(id);
			
			persistirToro(t);
			log.info("Se incrementan servicios dados toro id " + id + ". Servicios:" + t.getServiciosCampo());
		} catch (Exception e) {
			log.error("Error al registrarServicioDadoToro id " + id + ": " + e.getMessage());
		}
		
	}

	private void registrarSalidaSemenPorIdToro(Long id) {
		// TODO Implementar la parte de Stock. Restar pajuela aqui.
		
	}

	@Override
	public CeloServicio eliminarCeloServicio(CeloServicio cs,boolean actualizaSituacionActual) throws Exception{
		try {
			CeloServicio result;
			cs.setEliminado(true);
			cs.setUsuarioBaja(serviceFacade.obtenerUsuarioLogueadoId());
			cs.setFechaBaja(serviceFacade.getFechaActual());
			result=persistirCeloServicio(cs,actualizaSituacionActual);
			
			if (result.getEliminado())
				log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " se elimina celoServicio id: "+ cs.getId() + " ok.");
			
			return result;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " EliminarCeloServicio(): " + e.getMessage(), e);
			throw e;
		}
	}
	
	@Override
	public CeloServicio obtenerCeloServicioById(Long id){
		CeloServicio result = genericDao.get(CeloServicio.class, id);				
		return result;
		
	}

	@Override
	public CeloServicio eliminarCeloServicioById(Long id,boolean actualizaSituacionActual)throws Exception{
		try {
			CeloServicio cs = obtenerCeloServicioById(id);
			CeloServicio result=null;
			if (cs != null)
				result=eliminarCeloServicio(cs,actualizaSituacionActual);
			else
				log.warn(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " eliminarCeloServicioById(): No se encontro servicio para eliminar con id: " + id);
			
			return result;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " eliminarCeloServicioById(): " + e.getMessage(), e);
			throw e;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Inseminador> obtenerInseminadores() throws Exception{
		try {
			Establecimiento establecimiento=serviceFacade.obtenerEstablecimientoLogueado();
			
			List<Inseminador> inse = genericDao.getSessionFactory().getCurrentSession().createCriteria(Inseminador.class)
				.add(Restrictions.eq("eliminado", Boolean.FALSE))
				.add(Restrictions.eq("establecimiento", establecimiento))
				.addOrder(Order.asc("apellido")).list();
			  
			return inse;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " obtenerInseminadores(): " + e.getMessage(), e);
			throw e;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Vaca> obtenerVacasEstablecimientoActual() throws Exception{
		try {
			Establecimiento establecimiento=serviceFacade.obtenerEstablecimientoLogueado();
			
			List<Vaca> vacas = genericDao.getSessionFactory().getCurrentSession().createCriteria(Vaca.class)
				.add(Restrictions.eq("eliminado", Boolean.FALSE))
				.add(Restrictions.eq("establecimiento", establecimiento))
				.addOrder(Order.asc("rp")).list();
			  
			return vacas;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " obtenerVacas(): " + e.getMessage(), e);
			throw e;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<TipoServicio> obtenerTiposServicio() throws Exception{
		try {
			
			List<TipoServicio> ts = genericDao.getSessionFactory().getCurrentSession().createCriteria(TipoServicio.class)
				.add(Restrictions.eq("activo", Boolean.TRUE))
				.addOrder(Order.asc("id")).list();
			  
			return ts;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " obtenerTiposServicio(): " + e.getMessage(), e);
			throw e;
		}
	}
	
	
	/**
	 * Devuelve los celos y servicios cargados en Fecha dentro del establecimiento logueado
	 * @param fecha
	 * @return
	 * @throws Exception
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<CeloServicio> obtenerCelosServiciosPorFecha(final Date fecha) throws Exception{
		try {
			Establecimiento establecimiento=serviceFacade.obtenerEstablecimientoLogueado();
			Calendar fDesde = DateUtil.createCalendar(fecha);
			fDesde.set(Calendar.HOUR, 0);
			fDesde.set(Calendar.MINUTE, 0);
			fDesde.set(Calendar.SECOND, 0);
			Calendar fHasta = DateUtil.createCalendar(fecha);
			fHasta.set(Calendar.HOUR, 23);
			fHasta.set(Calendar.MINUTE,59);
			fHasta.set(Calendar.SECOND, 59);
			
			List<CeloServicio> result = genericDao.getSessionFactory().getCurrentSession().createCriteria(CeloServicio.class)
				.add(Restrictions.between("fecha", fDesde.getTime(),fHasta.getTime()))
				.add(Restrictions.eq("establecimiento", establecimiento))
				.add(Restrictions.eq("eliminado", false)).list();
			  
			return result;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " obtenerCelosServiciosPorFecha(): " + e.getMessage(), e);
			throw e;
		}
	}

	private Toro obtenerToroById(Long id) throws Exception{
		return obtenerToroById(id,false);
		
	}
	private Toro obtenerToroById(Long id,boolean todosLosEstablecimientos) throws Exception{
		Toro result =null;
		result = genericDao.get(Toro.class, id);
		
		if (! todosLosEstablecimientos){
			if (result != null && result.getEstablecimiento() != null){
				if (! result.getEstablecimiento().equals(serviceFacade.obtenerEstablecimientoLogueado()))
						result=null;
			}
		}
		
		return result;
		
	}
	
	private Inseminador obtenerInseminadorById(Long id) throws Exception{
		Inseminador result =null;
		result = genericDao.get(Inseminador.class, id);
		
		return result;
		
	}
	
	@Override
	public CeloServicio obtenerUltimoCeloServicioPorVacaId(Long vacaId) throws Exception{	
		try {
			List<CeloServicio> resultado=new ArrayList<CeloServicio>();

			String sql = "select c.* from CeloServicio c " +
					"where c.vaca_id = :vaca_id ";
			
			String sqlOrder = " order by c.fecha desc "; 
			String sqlLimit = " LIMIT 1";
			
					
			SQLQuery query = serviceFacade.createSQLQuery(sql + sqlOrder + sqlLimit);
			query.addEntity(CeloServicio.class);
			query.setLong("vaca_id", vacaId);
			
			resultado = (List) query.list();
	
			if (resultado.size()>0)
				return resultado.get(0);
			else
				return null;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}
	
}
