package ar.com.cristal.creditos.servicios.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.cristal.creditos.common.Constantes;
import ar.com.cristal.creditos.common.CristalProperties;
import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.documentos.util.DatosTemplate;
import ar.com.cristal.creditos.entity.commons.ConfiguracionSistema;
import ar.com.cristal.creditos.entity.commons.Empresa;
import ar.com.cristal.creditos.entity.commons.MedioContacto;
import ar.com.cristal.creditos.entity.commons.RegistroTarea;
import ar.com.cristal.creditos.entity.commons.Tablas;
import ar.com.cristal.creditos.entity.creditos.Cliente;
import ar.com.cristal.creditos.entity.creditos.Credito;
import ar.com.cristal.creditos.entity.reportes.TipoReporte;
import ar.com.cristal.creditos.entity.sucursales.Sucursal;
import ar.com.cristal.creditos.localidad.Localidad;
import ar.com.cristal.creditos.localidad.Reparticion;
import ar.com.cristal.creditos.servicios.ComunesService;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.util.DateUtil;

@Service("comunesService")
public class ComunesServiceImpl implements ComunesService {


	private Logger log = Logger.getLogger(ComunesServiceImpl.class);

	@Autowired
	protected GenericDao genericDao;
	
	@Autowired
	protected ServiceFacade serviceFacade;
	


	
	
	
	public List<Empresa> obtenerEmpresas() throws Exception {
		try{
			return genericDao.getAll(Empresa.class);	
		}catch(Exception e){
			log.error("error obteniendo todas las empresas");
			throw e;
		}
		
	}



	/**
	 * retrona todos los registros con el "tipo" indicado en la columna tipo.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Tablas> obtenerTablaByTipo(String tipo) throws Exception {
		List<Tablas> tabla = new ArrayList<Tablas>();
		try{
			DetachedCriteria criteria = DetachedCriteria.forClass(Tablas.class);
			criteria.add(Restrictions.eq("tipo", tipo));
			tabla = (List<Tablas>) genericDao.getHibernateTemplate().findByCriteria(
					criteria);

		}catch(Exception e){
			log.error("error obteniendo todas las tablas con tipo " + tipo);
			throw e;
		}
		return tabla;
	}

	@SuppressWarnings("unchecked")
	public Tablas obtenerTablaByCodigoYTipo(String codigo, String tipo) throws Exception {
		List<Tablas> tabla = new ArrayList<Tablas>();
		try{
			DetachedCriteria criteria = DetachedCriteria.forClass(Tablas.class);
			criteria.add(Restrictions.eq("codigo", codigo));
			criteria.add(Restrictions.eq("tipo", tipo));
			
			tabla = (List<Tablas>) genericDao.getHibernateTemplate().findByCriteria(criteria);
			return tabla.get(0);
		}catch(Exception e){
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " error obteniendo todas las tablas con tipo " + tipo);
			throw e;
		}
		
	}


	@SuppressWarnings("unchecked")
	public DatosTemplate obtenerNombreTemplateByIdEmpresaAreaYCodigoReporte(
			String idEmp, String area, String codigo) throws Exception {
		List<DatosTemplate> ltemp = new ArrayList<DatosTemplate>();
		try{
			DetachedCriteria criteria = DetachedCriteria.forClass(DatosTemplate.class);
			criteria.add(Restrictions.eq("idEmpresa", new Long(idEmp)));
			criteria.add(Restrictions.eq("codigoArea", area));
			criteria.add(Restrictions.eq("codigoReporte", codigo.toUpperCase()));
			ltemp = (List<DatosTemplate>) genericDao.getHibernateTemplate().findByCriteria(
					criteria);

		}catch(Exception e){
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " error al intentar obtener el template para idEmpresa: " + idEmp + " area "+ area + " codigo "+ codigo + " la excepcion " + e.getMessage());
			throw e;
		}
		
		if(ltemp.size()>0){
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Directorio destino del archivo debe ser: " + ltemp.get(0).getContextRootDirFullpath() + ltemp.get(0).getDirectorioDestino());
			return ltemp.get(0); 
		}
		log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " No se encontro el template definido para idEmpresa : " + idEmp + " codigoArea "+ area + " codigoReporte " + codigo + " Asegurese que existe una tupla en DatosTemplate");
		return null;
	}



	
	
	public Empresa obtenerEmpresaPorId(Long id) {
		return genericDao.get(Empresa.class, id);
	}
	
	
	public boolean validarEMail(String email){
		boolean resultado = true;
		try {
			if(!email.isEmpty()){
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
			}
		   } catch (AddressException ex) {
		      resultado = false;
		   }
		return resultado;
	}




	
	/**
	 * filtra por nombreTemplate y ext, si ext no esta filtra solo por nombrearchivo
	 */
	@SuppressWarnings("unchecked")
	public DatosTemplate obtenerDatosTemplateByNombreTemplateYExtencion(
			String fn, String ext) throws Exception {
		List<DatosTemplate> ltemp=null;
		try{
			DetachedCriteria criteria = DetachedCriteria.forClass(DatosTemplate.class);
			criteria.add(Restrictions.eq("nombreTemplate", fn));
			if(!"".equals(ext)){
						criteria.add(Restrictions.eq("extencionDefault", ext));
			}
			
			ltemp = (List<DatosTemplate>) genericDao.getHibernateTemplate().findByCriteria(
					criteria);
			
			
		}catch(Exception f){
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Error intentando obtener los datos del template " +  f.getMessage());
			throw f;
		}
		if(ltemp.size()>0){
			return ltemp.get(0); 
		}
		return null;
	}
	

	/**
	 * filtra por nombreArchivo y ext, si ext no esta filtra solo por nombrearchivo
	 */
	@SuppressWarnings("unchecked")
	public DatosTemplate obtenerDatosTemplateByNombreArchivoYExtencionEIdEmpresa(
			String fn, String ext, String idemp) throws Exception {
		List<DatosTemplate> ltemp=null;
		Long idempresa=null;
		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " se realiza la busqueda de datos template x nombre archivo, estencion e idempresa");
		try{
			DetachedCriteria criteria = DetachedCriteria.forClass(DatosTemplate.class);
			criteria.add(Restrictions.eq("nombreTemplate", fn));
			if(!"".equals(ext)){
						criteria.add(Restrictions.eq("extencionDefault", ext));
			}
			if(idemp != null && !"".equals(idemp)){
				idempresa=new Long(idemp);
				criteria.add(Restrictions.eq("idEmpresa", idempresa));
			}
			ltemp = (List<DatosTemplate>) genericDao.getHibernateTemplate().findByCriteria(
					criteria);
		
			
		}catch(Exception f){
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Error intentando obtener los datos del template " +  f.getMessage());
			throw f;
		}
		if(ltemp.size()>0){
			return ltemp.get(0); 
		}
		return null;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public DatosTemplate obtenerDatosTemplateByNombreTemplateCodigoAreaCodigoReporte(
			String nombreReporte, String codigoArea, String codigoReporte)
			throws Exception {
		List<DatosTemplate> ltemp=null;
		try{
			DetachedCriteria criteria = DetachedCriteria.forClass(DatosTemplate.class);
			criteria.add(Restrictions.eq("nombreTemplate", nombreReporte));
			criteria.add(Restrictions.eq("codigoArea", codigoArea));
			criteria.add(Restrictions.eq("codigoReporte", codigoReporte));
		
			
			ltemp = (List<DatosTemplate>) genericDao.getHibernateTemplate().findByCriteria(
					criteria);
			
			
		}catch(Exception f){
			String msg = " Error intentando obtener los datos del template " + nombreReporte + " " + codigoArea + " " + codigoReporte + ": ";
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + msg +  f.getMessage());
			throw f;
		}
		if(ltemp.size()>0){
			return ltemp.get(0); 
		}
		return null;
	}

	





		@Override
		public List<TipoReporte> obtenerTiposReporte() throws Exception {
			List<TipoReporte> tiposReportes = new ArrayList<TipoReporte>();
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Iniciando obtenerTiposReporte...");
			tiposReportes = genericDao.findAll(TipoReporte.class);
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Fin obtenerTiposReporte.");
			return tiposReportes;
		}


		@Override
		public List<MedioContacto> obtenerMediosContacto() {
			return genericDao.getAll(MedioContacto.class);
		}



		@Override
		public List<Reparticion> buscarReparticion(Reparticion reparticion) {
			DetachedCriteria criteria = DetachedCriteria.forClass(Reparticion.class);
			criteria.add(Restrictions.like("nombre",reparticion.getNombre(),MatchMode.ANYWHERE).ignoreCase());
			List<Reparticion>  reparticiones =genericDao.findByCriteria(criteria); 
			return  reparticiones;
		}



		@Transactional
		public void guardarCrearReparticion(Reparticion reparticion) {
			genericDao.saveOrUpdate(reparticion);
		}



		@Override
		public List<Localidad> buscarLocalidad(Localidad localidad) {
			DetachedCriteria criteria = DetachedCriteria.forClass(Localidad.class);
			criteria.add(Restrictions.like("nombre",localidad.getNombre(),MatchMode.ANYWHERE).ignoreCase());
			List<Localidad>  localidades =genericDao.findByCriteria(criteria);
			return localidades;
		}



		@Transactional
		public void guardarCrearLocalidad(Localidad localidad) {
			genericDao.saveOrUpdate(localidad);			
		}



		@Transactional
		public void guardarCrearEmpresa(Empresa empresa) {
			genericDao.saveOrUpdate(empresa);			
		}



		@Override
		public List<Empresa> buscarEmpresa(Empresa empresa) {
			DetachedCriteria criteria = DetachedCriteria.forClass(Empresa.class);
			if (empresa.getNombre()!= null)
					criteria.add(Restrictions.like("nombre",empresa.getNombre(),MatchMode.ANYWHERE).ignoreCase());
			List<Empresa>  empresas =genericDao.findByCriteria(criteria); 
			return  empresas;
		}

		@Transactional
		public void guardarCrearSucursal(Sucursal sucursal) {
			genericDao.saveOrUpdate(sucursal);			
		}

		@Override
		public List<Sucursal> buscarSucursal(Sucursal sucursal) {
			DetachedCriteria criteria = DetachedCriteria.forClass(Sucursal.class);
			if (sucursal.getNombre()!= null)
				criteria.add(Restrictions.like("nombre",sucursal.getNombre(),MatchMode.ANYWHERE).ignoreCase());
			List<Sucursal>  sucursales =genericDao.findByCriteria(criteria); 
			return  sucursales;
		}

		@Override
		public Sucursal buscarSucursal(String nombreSucursal) {
			DetachedCriteria criteria = DetachedCriteria.forClass(Sucursal.class);
			List<Sucursal>  sucursales = Collections.EMPTY_LIST;
			if (nombreSucursal != null){
				criteria.add(Restrictions.eq("nombre", nombreSucursal).ignoreCase());
				sucursales =genericDao.findByCriteria(criteria);
			}
			
			if (sucursales.size() > 0)
				return sucursales.get(0);
			else
				return null;
		}



		
		@Transactional
		public Long registrarInicioTarea(String accion) throws Exception{
			try {
				log.info("Registro inicio tarea " + accion);
				RegistroTarea registro = new RegistroTarea();
				registro.setFechaInicio(serviceFacade.getFechaActual());
				registro.setAccion(accion);
				registro.setProcesado(false);
				registro.setUsuarioId(serviceFacade.obtenerUsuarioLogueado().getId());
				
				
				genericDao.save(registro);
				log.info("Registro inicio tarea " + registro.getId());
				return registro.getId();
			} catch (Exception e) {
				throw e;
			}
		}
		
		
		
		@Transactional
		public void registrarFinTarea(Long id) throws Exception{
			try {
				registrarFinTarea(id, "");
			} catch (Exception e) {
				throw e;
			}
		}


		@Transactional
		public void registrarFinTarea(Long id, String observacion) throws Exception{
			try {
				log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Registrando fin tarea: " + id);
				RegistroTarea registro = genericDao.get(RegistroTarea.class, id);
				registro.setFechaFin(serviceFacade.getFechaActual());
				registro.setProcesado(true);
				
				if (observacion != null && observacion.length() > 0)
					registro.setObservacion("Fin Tarea: " + observacion);
				else
					registro.setObservacion("Fin Tarea");
				
				genericDao.update(registro);
			} catch (Exception e) {
				throw e;
			}
		}
		

		@Override
		@Transactional
		public void registrarFalla(Long id, String error) throws Exception {
			RegistroTarea registro = genericDao.get(RegistroTarea.class, id);
			registro.setFechaFin(new Date());
			registro.setObservacion(error);
			genericDao.update(registro);
			
		}



		@Override
		@Transactional
		public boolean cuotaSocialGenerada(int periodo, int año) {
			String qry = "select id from RegistroTarea where accion = :accion" + 
					" and month(fechaInicio) = :periodo " +
					" and year(fechaInicio) = :year " +
					" and procesado = 1";
			
			
			try {				
				SQLQuery q = genericDao.getSessionFactory().getCurrentSession().createSQLQuery(qry);
				q.setString("accion", Constantes.TAREA_CUOTA_SOCIAL);
				q.setInteger("periodo", periodo);
				q.setInteger("year", año);
				
				log.debug("Query: " + qry);
			
			
				if (q.list().size() > 0){
					return true;
				} else
					return false;
			} catch (HibernateException e) {
				log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " error: " + e.getMessage(), e);
			}
			return false;
		}
		
		@Override
		@Transactional
		public boolean tareaEnEjecucion(Date fecha, String tarea) {
			String qry = "select id from RegistroTarea where accion = :accion" + 					
					" and fechaFin is null " +
					" and procesado = 0 ";
					
			
			
			try {				
				if (fecha != null) qry += " and date(fechaInicio) = :fecha ";
				
				SQLQuery q = genericDao.getSessionFactory().getCurrentSession().createSQLQuery(qry);
				q.setString("accion", tarea);
				
				if (fecha != null) q.setDate("fecha", fecha);
				
				log.debug("Query: " + qry);
			
			
				if (q.list().size() > 0){
					return true;
				} else
					return false;
			} catch (HibernateException e) {
				log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " error: " + e.getMessage(), e);
			}
			return false;
		}
		
		
		public String getUbicacionCartasSambaShare() throws Exception{
			String ubicacion = "Las cartas generadas se encuentran en el directorio compartido: " + CristalProperties.getInstance().getValue("samba.share");
			return ubicacion;
		}



		@Override
		@Transactional
		public boolean tareaMensualRealizada(String nombreTareaRegistrada, Calendar fechaEvaluacion){
			Calendar fInicio = (Calendar)fechaEvaluacion.clone();
			fInicio.set(Calendar.DAY_OF_MONTH, 1);
			Date fFin = DateUtil.getFinalDateOfMonth(fechaEvaluacion.getTime());
			
			log.debug("Evaluacion Tarea Mensual Realizada " + nombreTareaRegistrada + " periodo: " + DateUtil.getString(fInicio.getTime()) + " - " + DateUtil.getString(fFin));
			
			String sql = "select r.* from RegistroTarea r " +
					"where date(fechaInicio) between date(:fechaInicio) " +
					"and date(:fechaFin) " +
					"and accion = :tarea " +
					"and procesado = 1 limit 1";
			
			
			SQLQuery q = serviceFacade.createSQLQuery(sql);
			q.addEntity(RegistroTarea.class);
			q.setString("tarea", nombreTareaRegistrada);
			q.setParameter("fechaInicio", fInicio);
			q.setParameter("fechaFin", fFin);
			RegistroTarea r = (RegistroTarea) q.uniqueResult();
			
			return r != null;
			
		}

		
		@Override		
		@Transactional
		public boolean tareaRealizada(String nombreTareaRegistrada, Calendar fechaInicio, Calendar fechaTope){			
			String sql = "select r.* from RegistroTarea r " +
					"where date(fechaInicio) between date(:fechaInicio) " +
					"and date(:fechaFin) " +
					"and accion = :tarea " +
					"and procesado = 1 limit 1";
			
			
			SQLQuery q = serviceFacade.createSQLQuery(sql);
			q.addEntity(RegistroTarea.class);
			q.setString("tarea", nombreTareaRegistrada);
			q.setParameter("fechaInicio", fechaInicio);
			q.setParameter("fechaFin", fechaTope);
			RegistroTarea r = (RegistroTarea) q.uniqueResult();
			
			
			return r != null;
			
		}

		@Override
		public boolean isVerazOnlineActivo() {
			DetachedCriteria criteria = DetachedCriteria.forClass(ConfiguracionSistema.class);
			criteria.add(Restrictions.eq("propiedad", "ConsultaVerazOnline"));
			@SuppressWarnings("unchecked")
			List<ConfiguracionSistema> result = (List<ConfiguracionSistema>) genericDao.getHibernateTemplate().findByCriteria(
					criteria);
			
			
			return "1".equals(result.get(0).getValor());
		}
		
		@Override
		public List<Tablas> obtenerListadoLlamadasDepartamentosCall() {

			String sql = "select * from Tablas " +
					"where (tipo = 'MORA_TARDIA_ASIGNACION_LLAMADA' " +
					"or tipo = 'CALLCENTER_ASIGNACION_LLAMADA') " +
					"and codigo not in ('MOROSO_1','MOROSO_2','PREJUDICIAL') " +
					"union " +
					"select * from Tablas " +
					"where tipo = 'CALLCENTER_ASIGNACION_LLAMADA' " +
					"and codigo in ('MOROSO_1','MOROSO_2','PREJUDICIAL') order by nombre";
			
			SQLQuery q = serviceFacade.createSQLQuery(sql);
			q.addEntity(Tablas.class);
			@SuppressWarnings("unchecked")
			List<Tablas> result = (List<Tablas>) q.list();
			return result;
		}



		@Override
		public Integer getScoreVerazOffline() {
			try {
				DetachedCriteria criteria = DetachedCriteria.forClass(ConfiguracionSistema.class);
				criteria.add(Restrictions.eq("propiedad", "ValorVerazOffline"));
				@SuppressWarnings("unchecked")
				List<ConfiguracionSistema> result = (List<ConfiguracionSistema>) genericDao.getHibernateTemplate().findByCriteria(
						criteria);
				
				
				return Integer.parseInt(result.get(0).getValor());
			} catch (Exception e) {
				log.error("Error al obtener el veraz offline ");
				return 656;
			}
		}
		
		
		@Override
		public Object getPropiedadConfiguracionSistema(String propiedad) {
			try {
				DetachedCriteria criteria = DetachedCriteria.forClass(ConfiguracionSistema.class);
				criteria.add(Restrictions.eq("propiedad", propiedad));
				@SuppressWarnings("unchecked")
				List<ConfiguracionSistema> result = (List<ConfiguracionSistema>) genericDao.getHibernateTemplate().findByCriteria(
						criteria);
				
				
				return result.get(0).getValor();
			} catch (Exception e) {
				log.error("Error al obtener el veraz offline ");
				return 656;
			}
		}



		@Override
		public void cambiarEstadoACreditosYSusCuotas(List<Long> idsCreditos)
				throws Exception {
			// TODO Auto-generated method stub
			
		}



		@Override
		public Double obtenerPunitoriosCredito(Credito credito) {
			// TODO Auto-generated method stub
			return null;
		}



		@Override
		public void invalidarCuotasSociales() {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void invalidarCuotasSociales(Long clienteId, String detalle) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void registrarSeguimiento(String mensaje, Cliente cliente)
				throws Exception {
			// TODO Auto-generated method stub
			
		}


		
}
