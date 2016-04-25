package ar.com.cristal.creditos.servicios.impl;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.cristal.creditos.common.Constantes;
import ar.com.cristal.creditos.common.EstadoClienteEnum;
import ar.com.cristal.creditos.common.EstadoCreditoEnum;
import ar.com.cristal.creditos.common.FormatoDocAnexoEnum;
import ar.com.cristal.creditos.common.TipoDocAnexoEnum;
import ar.com.cristal.creditos.dao.GenericDao;
import ar.com.cristal.creditos.entity.cliente.DatoAnexo;
import ar.com.cristal.creditos.entity.commons.Tablas;
import ar.com.cristal.creditos.entity.creditos.Cliente;
import ar.com.cristal.creditos.entity.creditos.ClienteHistorialDatos;
import ar.com.cristal.creditos.entity.creditos.Credito;
import ar.com.cristal.creditos.entity.creditos.CuotaSocial;
import ar.com.cristal.creditos.entity.creditos.Referido;
import ar.com.cristal.creditos.entity.login.Usuario;
import ar.com.cristal.creditos.localidad.Reparticion;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.util.CristalModelException;
import ar.com.cristal.creditos.util.DateUtil;


@Service
public class ClienteService {
	
	private Logger log = Logger.getLogger(ClienteService.class);


	@Autowired
	protected GenericDao genericDao;
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@Autowired
	private ServiceFacade serviceFacade;
	
		
	public List<Cliente> obtenerClientes(){
		
//		List<Cliente> result = genericDao.getAll(Cliente.class);
		@SuppressWarnings("unchecked")
		List<Cliente> result = genericDao.getSessionFactory().getCurrentSession().createCriteria(Cliente.class)
				.addOrder(Order.asc("apellido"))
				.list();
		
				
		return result;
		
	}
	
	
	public List<Cliente> obtenerClientes(String dni, String cuil) throws Exception{
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			if (dni == null) dni = "";
			if (cuil == null) cuil = "";
			
			if (dni.isEmpty() && cuil.isEmpty()) {
				throw new Exception("Error en la búsqueda de clientes. Cuil y DNI ambos vacíos");
				 
			} else {
				Criteria criteria = genericDao.getSessionFactory().getCurrentSession().createCriteria(Cliente.class); 
				
				criteria.add(Restrictions.or(Restrictions.eq("dni", dni),Restrictions.eq("cuil", cuil)));
				
				clientes = criteria.list();
	
				return clientes;
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	/**
	 * Según el criterio de busqueda ingresado por el usuario, se procede a ejecutar una busqueda en la base de datos
	 * por idCliente, nroCuenta, dni, o nombre y apellido <br></br>
	 * Modo de uso
	 * obtenerClientesByParam(id_3);<br></br>
	 * obtenerClientesByParam(dni_19656552);<br></br>
	 * obtenerClientesByParam(nombre_apellidoEjemplo,nombreEjemplo);<br></br>
	 * obtenerClientesByParam(nombre_apellidoEjemplo, );<br></br>
	 * obtenerClientesByParam(nombre_nombreEjemplo);<br></br>
	 * @return
	 * @throws Exception 
	 */
	public List<Cliente> obtenerClientesByParam(String param) throws Exception{

		try {
			
//			boolean busquedaPorIdOrNroCuenta = false;
			
			Usuario u = usuarioService.obtenerUsuarioLogueado();
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " realiza búsqueda de cliente: " + param);
			
			Long clientesDelComercializadorId = null;

			String[] params = param.split("_");
			
			boolean busquedaPorDNI = params[0].equals("dni");
			
			List<Cliente> result = new ArrayList<Cliente>();
			
			if (params[0].equals("id")){	
//				busquedaPorIdOrNroCuenta = true;
				String qry = "from Cliente where id = "+ params[1];
				if (clientesDelComercializadorId != null) qry = qry + " and idComercializador = " + clientesDelComercializadorId;
				//Busqueda por id del cliente
				qry = qry + " order by id, apellido, nombre";
				result = genericDao.find(qry);
				
			}else if (params[0].equals("idCuenta")){			
//				Busqueda por id de la cuenta del cliente
//				busquedaPorIdOrNroCuenta = true;
				result = genericDao.find("from Cliente where nroCuenta = "+params[1].trim());
				
				
			}else if (params[0].equals("dni")){
				String qry = "from Cliente where dni = "+ Long.valueOf(params[1].trim()).toString(); //Necesario para cuando ponen ceros a la izquierda
				if (clientesDelComercializadorId != null) qry = qry + " and idComercializador = " + clientesDelComercializadorId;
				//Busqueda por el Dni del cliente
				qry = qry + " order by dni, apellido, nombre";
				result = genericDao.find(qry);
				
			}else if (params[0].equals("nombre")){											//Busqueda por el nombre del cliente
				
				String[] apellidoNombre = params[1].split(", ");
				if (apellidoNombre.length == 2){
					String qry = "from Cliente where apellido like '"+apellidoNombre[0].trim()+"%' and nombre like '"+apellidoNombre[1].trim()+"%'";
					if (clientesDelComercializadorId != null) qry = qry + " and idComercializador = " + clientesDelComercializadorId;
					qry = qry + " order by apellido, nombre";
					result = genericDao.find(qry);
					
					if (result.isEmpty() && ! apellidoNombre[0].trim().isEmpty()){
						qry = "from Cliente where apellido like '"+apellidoNombre[0].trim()+"%'";
						if (clientesDelComercializadorId != null) qry = qry + " and idComercializador = " + clientesDelComercializadorId;
						qry = qry + " order by apellido, nombre";
						result = genericDao.find(qry);
					
					}
				}else if (params[1].endsWith(", ")){
					String qry = "from Cliente where apellido like '" + apellidoNombre[0].trim() + "%'";
					if (clientesDelComercializadorId != null) qry = qry + " and idComercializador = " + clientesDelComercializadorId;		
					qry = qry + " order by apellido, nombre";
					result = genericDao.find(qry);
				
				}else{
					String qry = "from Cliente where nombre like '"+apellidoNombre[0].trim()+"%'";
					if (clientesDelComercializadorId != null) qry = qry + " and idComercializador = " + clientesDelComercializadorId;
					qry = qry + " order by apellido, nombre";
					result = genericDao.find(qry);
				
				}
			}
			
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " realiza búsqueda de cliente: " + param + " resultado: " + result.size() + " ocurrencias." ) ;
			
			if (!busquedaPorDNI){
				log.debug("Busqueda: " + param);
				if (result.size() == 1){
					log.debug("Transforma a busqueda por dni: " + param);
					result = obtenerClientesByParam("dni_" + result.get(0).getDni());	
				}
				
			
			}
			
			return result;
		} catch (Exception e) {
			log.error("Se produjo un error al obtener los clientes." + e.getMessage(), e);
			throw e;
		}

	}
	
	/**
	 * Asumo que apellido, nombre y dni son identificadores unicos.
	 * 
	 * @param clientes
	 * @param apellido
	 * @param nombre
	 * @param dni
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Cliente obtenerClientePor(final String apellido, final String nombre, final String dni){
		Cliente cliente = null;
		
		List<Cliente> clientes = genericDao.getSessionFactory().getCurrentSession().createCriteria(Cliente.class)
			.add(Restrictions.eq("apellido", apellido).ignoreCase())
			.add(Restrictions.eq("nombre", nombre).ignoreCase())
			.add(Restrictions.eq("dni", dni)).list();
		  
		if(clientes.size() == 1){
			cliente = clientes.get(0);
		}
		
		return cliente; 
	}
	
	public Cliente obtenerClienteById(Long id){
//		log.info("obtenerClienteById(): " + id); 
		Cliente result = genericDao.get(Cliente.class, id);				
		return result;
		
	}

	@Transactional
	public void persistirCliente(Cliente cliente) throws Exception {
		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " idCliente: " + cliente.getId()); 
		try {
			
			agregarAuditoria(cliente);
			try {
				persistirClienteHistorialDatos(cliente);
			} catch (Exception e) {
				log.error("No se pudo persistir Historial Datos Cliente. Falla: " + e.getMessage());
			}
			
			if (esClienteDadoDeBaja(cliente)){
				cliente = darDeBaja(cliente);
			} else {
			
				cliente = genericDao.merge(cliente);
			}
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " persistirCliente(): " + e.getMessage(), e);
			throw e;
		}
	}



	private boolean esClienteDadoDeBaja(Cliente cliente) {
		String query = "select estado from Cliente where id = :idCliente";		
		Query querySQL = genericDao.getSessionFactory().getCurrentSession().createQuery(query);
		querySQL.setParameter("idCliente", cliente.getId());
		
		EstadoClienteEnum estado = (EstadoClienteEnum) querySQL.uniqueResult();
		
		if (estado.equals(cliente.getEstado()))
			return false;
		else
			if (EstadoClienteEnum.BAJA.equals(cliente.getEstado()))
				return true;
			else
				return false;
		
	}



	private void agregarAuditoria(Cliente cliente) throws Exception {
		if (cliente.getId() == null || cliente.getId() <= 0) 
			cliente.setUsuarioAlta(serviceFacade.obtenerUsuarioLogueado().getId());
		else {			
			//Para no perder el usuario de alta se sobreescribe
			Cliente c = obtenerClienteById(cliente.getId());
			if (cliente.getUsuarioAlta() == null) cliente.setUsuarioAlta(c.getUsuarioAlta());
			
			if (cliente.getUsuarioBajaId() == null) {
				cliente.setUsuarioBajaId(c.getUsuarioBajaId());
				cliente.setFechaBaja(c.getFechaBaja());
			}
			
			cliente.setUsuarioModificacion(serviceFacade.obtenerUsuarioLogueado().getId());
		}
	}
	
	
	
	



	@Transactional
	public void guardarCliente(Cliente cliente) throws Exception {
//		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " idCliente: " + cliente.getId()); 
		try {
			agregarAuditoria(cliente);
			
			genericDao.save(cliente);
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " guardarCliente(): " + e.getMessage(), e);
			throw e;
		}
//		log.info("guardarCliente(): fin");
	}
	
	@SuppressWarnings("unchecked")
	public boolean poseeMasDeUnCreditoActivo(Long idCliente){
		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " idCliente: " + idCliente); 		

		List<Credito>  creditos = new ArrayList<Credito>();
		
		creditos = genericDao.getSessionFactory().getCurrentSession().createCriteria(Credito.class)
						.add(Restrictions.eq("estado", EstadoCreditoEnum.ACTIVO))
						.add(Restrictions.eq("cliente.id", Long.parseLong(idCliente.toString())))
						.list();

	    if (creditos.size()>1 || creditos.size()==0){
	    	return true;
	    }else 
	    	return false; 
	    
	}	
	
	public void eliminarCliente(Cliente cliente) throws Exception{
		
		cliente.setEstado(EstadoClienteEnum.BAJA);
		cliente.setEliminado(true);
		persistirCliente(cliente);
	}
	
	@Transactional
	public void crearCliente(Cliente cliente) throws Exception{
		if (!clienteExiste(cliente)){
			
			cliente.setEstado(EstadoClienteEnum.ACTIVO);
			
			if (cliente.getId() == null) {
				
				cliente.setEliminado(false);
			}
			
			guardarCliente(cliente);
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean clienteExiste(Cliente cliente){
		List<Cliente>  clientes = new ArrayList<Cliente>();
		
		clientes = genericDao.getSessionFactory().getCurrentSession().createCriteria(Cliente.class)
//				.add(Restrictions.eq("nombre", cliente.getNombre()).ignoreCase())
//				.add(Restrictions.eq("apellido", cliente.getApellido()).ignoreCase())
//				.add(Restrictions.eq("dni", cliente.getDni()))
				.add(Restrictions.eq("cuil", cliente.getCuil()))		
				.list();
		
		Criteria criteria  = genericDao.getSessionFactory().getCurrentSession().createCriteria(Cliente.class);
			criteria.add(Restrictions.eq("cuil", cliente.getCuil()));
			
			clientes = criteria.list();
		
		//TODO: revisar si no debe chequear >= 1
		if (clientes.size()==1){
			if (cliente.getId() != null)
				return !clientes.get(0).getId().equals(cliente.getId());
			else 
				return true;
		} else {
			return false;
		}
		
	}
	
		
	@Transactional
	public void modificarCliente(Cliente cliente) throws Exception{	
		try {
			if (cliente.getEstado() == null) cliente.setEstado(EstadoClienteEnum.ACTIVO);
			
			persistirCliente(cliente);
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " modificarCliente" + e.getMessage());
			throw new Exception("Error al modificar el cliente.", e);
		}
	}
	
	@Transactional
	private Cliente darDeBaja(Cliente cliente) throws Exception{	
		try {
			cliente.setEstado(EstadoClienteEnum.BAJA);
			cliente.setFechaBaja(Calendar.getInstance().getTime());
			cliente.setUsuarioBajaId(serviceFacade.obtenerUsuarioLogueadoId());					
			cliente = genericDao.merge(cliente);
			
			return cliente;

		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " darDeBaja " + cliente.getId());
			throw e;
		}
	}
	

	@SuppressWarnings("unchecked")
	public List<Referido> obtenerReferidos(Long idCliente){
			List<Referido> referidos = new ArrayList<Referido>();
			referidos = genericDao.getSessionFactory().getCurrentSession().createCriteria(Referido.class)
					.add(Restrictions.eq("cliente.id",idCliente))
					.addOrder(Order.asc("apellido"))
					.list();
			return referidos;
	}
	
	@SuppressWarnings("unchecked")
	public List<Reparticion> obtenerReparticionesPor(Long idCliente){
			List<Reparticion> reparticion = new ArrayList<Reparticion>();
			reparticion = genericDao.getSessionFactory().getCurrentSession().createCriteria(Reparticion.class)
					.add(Restrictions.eq("cliente.id",idCliente)).list();
			return reparticion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Reparticion> obtenerReparticiones(){
			List<Reparticion> reparticion = new ArrayList<Reparticion>();
			reparticion = genericDao.getSessionFactory().getCurrentSession().createCriteria(Reparticion.class).addOrder(Order.asc("nombre")).list();
			return reparticion;
	}

	@SuppressWarnings("unchecked")
	public List<Reparticion> obtenerReparticionesConDatosActivos(){
		List<Reparticion> result=new ArrayList<Reparticion>();	
		String query = "select r.id,r.nombre,r.descripcion,r.tipoPrivado from Cliente cl inner join Reparticion r on cl.reparticion_id=r.id where cl.pagoVoluntario=0 and cl.estado='ACTIVO' group by r.nombre";
		
		//Query querySQL = genericDao.getSessionFactory().getCurrentSession().createQuery(query);
		SQLQuery querySQL=serviceFacade.createSQLQuery(query);
		querySQL.addEntity(Reparticion.class);
		
		result=(List<Reparticion>) querySQL.list();
		
		return result;			
	}

	@Transactional
	public void eliminarReferido(Referido r) {
		log.info("Eliminando referido: " + r.getId());
		genericDao.delete(r);
		
	}
	


	/**
	 * Metodo que guarda en la base de datos al archivo anexo
	 * @param clientId
	 * @param filename
	 * @param content
	 * @param idAnexoModificacion 
	 * @throws Exception
	 */
	@Transactional
	public void uploadDocDatoAnexo(String clientId, String rotulo, int tipo, String descripcion, InputStream content, int size, String idAnexoModificacion, String filename) throws Exception{
		DatoAnexo doc = new DatoAnexo();
		byte[] aux = new byte[size];
		String delimiter = "\\.";
		String[] strAuxFilename; 
		strAuxFilename = filename.split(delimiter);
		try{
			log.debug(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " guardando dato anexo.");
			if (!idAnexoModificacion.isEmpty()) doc = obtenerAnexoById(idAnexoModificacion);
			doc.setUsuarioId(serviceFacade.obtenerUsuarioLogueadoId());
			doc.setFechaAltaModificacion(serviceFacade.getFechaActual());
			doc.setIdCliente(Long.parseLong(clientId));
			doc.setRotulo(rotulo);
			doc.setDescripcion(descripcion);
			
			switch (tipo){
			case 1: doc.setTipoDocumento(TipoDocAnexoEnum.DNI); break;
			case 2: doc.setTipoDocumento(TipoDocAnexoEnum.FOTO); break;
			case 3: doc.setTipoDocumento(TipoDocAnexoEnum.CROQUIS); break;
			case 4: doc.setTipoDocumento(TipoDocAnexoEnum.RECIBO_DE_SUELDO); break;
			case 5: doc.setTipoDocumento(TipoDocAnexoEnum.DEMANDA); break;
			case 6: doc.setTipoDocumento(TipoDocAnexoEnum.OTRO); break;
			}
			log.debug(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Subiendo archivo: " + filename);
			
			if (size > 0){
				FormatoDocAnexoEnum fda = FormatoDocAnexoEnum.valueOf(strAuxFilename[strAuxFilename.length - 1].toString().toLowerCase()); 
			
			
				switch (fda){
				case pdf: doc.setMimeType("application/pdf"); break;
				case jpg: doc.setMimeType("image/jpeg"); break;
				case jpeg: doc.setMimeType("image/jpeg"); break;
				case gif: doc.setMimeType("image/gif"); break;
				case tif: doc.setMimeType("image/tiff"); break;
				case png: doc.setMimeType("image/png"); break;
				case odt: doc.setMimeType("application/vnd.oasis.opendocument.text"); break;
				case doc: doc.setMimeType("application/msword");break;
				case xls: doc.setMimeType("application/vnd.ms-excel");break;
				case zip: doc.setMimeType("application/zip");break;
				}
			}

			content.read(aux);
			if (aux.length > 0){
				doc.setFileContent(aux);
				doc.setFilename(getFilename(filename));
			}
			
			Cliente cliente = obtenerClienteById(Long.valueOf(clientId));
			doc.setCliente(cliente);
			
			if (!idAnexoModificacion.isEmpty()){
				doc.setId(Long.parseLong(idAnexoModificacion));
			}
			
			if (doc.getFileContent() == null) throw new Exception("Archivo no válido");
				
			genericDao.saveOrUpdate(doc);
			log.debug(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " dato anexo guardado.");
			
		}catch (IOException e){
			throw e;
			
		}catch (Exception e){
			throw e;
		}
	}
	
	private String getFilename(String filename) {
		String delimiter = "/";
		String delimiter2 = "\\";
		String[] aux = filename.split(delimiter);
		int position = filename.lastIndexOf(delimiter2)+1;
		String subsequence = filename.subSequence(position,filename.length()).toString();
		
		if (aux.length>1) return aux[aux.length-1];
		else return subsequence;
	}




	
	/**
	 * obtiene un archivo anexo por id
	 * @param idAnexo
	 * @return
	 */
	public DatoAnexo obtenerAnexoById(String idAnexo){
		List<DatoAnexo> result = new ArrayList<DatoAnexo>();
		result = genericDao.find("from DatoAnexo where id ="+idAnexo);
		return result.get(0);
	}
	
	public byte[] obtenerFileContentAnexoById(String idAnexo){
		List<DatoAnexo> result = new ArrayList<DatoAnexo>();
		result = genericDao.find("from DatoAnexo where id ="+idAnexo);
		return result.get(0).getFileContent();
	}


	/************************************************************
	 * Solo para testing, realiza un borrado fisico en la base.
	 * @param cliente
	 */
	@Transactional
	public void eliminarClienteDeLaBase(Cliente cliente){
		genericDao.delete(cliente);
	}




	public List<Cliente> obtenerClientesFallecidos() {
		
		String  queryFallecidos = "select llamada.cliente" 
				+ "from Llamada as llamada" 
				+ "inner join llamada.cliente"
				+ "where llamada.tipoLlamada.codigo = " + EstadoClienteEnum.FALLECIDO;

				
				
		List<Cliente> result = new ArrayList<Cliente>();
		result = genericDao.find(queryFallecidos);

		
		return result;
	}


	@Transactional
	public void marcarFechaEnvioNotificacion(String idCliente, String tipoNotificacion) {
		try {
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado()  + " Marcando cliente con notificación " + tipoNotificacion + " para el cliente " + idCliente);
			Cliente c = obtenerClienteById(Long.valueOf(idCliente));
			if (Constantes.MOROSO2.equalsIgnoreCase(tipoNotificacion)){
				c.setFechaEnvioCartaMoroso2(serviceFacade.getFechaActual());
				
			} else {
				c.setFechaEnvioCartaPrejudicial(serviceFacade.getFechaActual());
			}
			
			guardarCliente(c);
			
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Se produjo un error al intentar marcar al cliente el envío de la notificación: " + tipoNotificacion, e);
			//Se decide no hacer nada
		}
		
		
	}



	/***
	 * Devuelve true si se envió una carta en el mes dado del tipo pasado
	 * @param cliente
	 * @param tipoCarta
	 * @param nroMes
	 * @return
	 */
	public boolean seEnvioCarta(Cliente cliente, String tipoCarta, int nroMes) {
		Calendar fechaEnvioCarta = Calendar.getInstance();
		
		try {
			if (Constantes.PREJUDICIAL.equalsIgnoreCase(tipoCarta)){
				
				if (cliente.getFechaEnvioCartaPrejudicial() != null) {
					
					fechaEnvioCarta.setTime(cliente.getFechaEnvioCartaPrejudicial());
					
					return fechaEnvioCarta.get(Calendar.MONTH) == nroMes;
					
				}
				
				
			} else if (Constantes.MOROSO2.equalsIgnoreCase(tipoCarta)){
				if (cliente.getFechaEnvioCartaMoroso2() != null) {
					
					fechaEnvioCarta.setTime(cliente.getFechaEnvioCartaMoroso2());
					
					return fechaEnvioCarta.get(Calendar.MONTH) == nroMes;
					
				}
				
			}
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Se produjo un error en la determinación de envío de carta al cliente " + cliente.getId() + " para el tipo de carta " + tipoCarta, e);
			return false;
		} 
		
		return false;
	}



	@Transactional
	public void pasarClientesALegales(List<Long> clientesId) throws Exception {
		try {
			for (Long id : clientesId) {
				Cliente c = obtenerClienteById(id);
				if (c.getEstado().equals(EstadoClienteEnum.FALLECIDO))
					c.setEstado(EstadoClienteEnum.FALLECIDO_LEGALES);
				else
					c.setEstado(EstadoClienteEnum.LEGALES);
				
				c.setCondicionMorosidad("");
				
				persistirCliente(c);
			}
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " pasarClientesALegales: " + e.getMessage());
			throw e;
		}
		
	}



	/***
	 * Retorna el id de la empresa a la cual "pertenece" el cliente. Se toma como que el cliente pertenece a la última empresa que le otorgó el crédito<br/>
	 * Busca entre los créditos del cliente el último registrado y si no encuentra nada devuelve el id 1 (id de la cooperativa)
	 * @param id
	 * @return
	 */
	public Long obtenerIdEmpresaDelCliente(Long id){		
		try {
			List<Credito> creditos = serviceFacade.getCreditosService().obtenerCreditosByClientId(id);
			if (!creditos.isEmpty()) {
				Collections.sort(creditos, new Comparator<Credito>(){
	
					@Override
					public int compare(Credito c1, Credito c2) {					
						return c2.getId().compareTo(c1.getId());
					}
					
				});
				
				Long result = 1L;
				
				//se tienen los créditos ordenados por id de mayor a menor
				for (Credito credito : creditos) {
					if (credito.getEmpresa().getCobraCuotaSocial()){
						result = credito.getEmpresa().getId();
						break; //termina la búsqueda de la empresa.
					}
				}
				
//				return creditos.get(creditos.size()-1).getEmpresa() != null ? creditos.get(creditos.size()-1).getEmpresa().getId() : 1L;
				return result;
			} else 
				return 1L;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Se produjo un error al obtener la empresa a la cual pertenece el cliente " + id, e);
			return 1L;
		}
		
	}
	
	
	public Reparticion obtenerReparticion(Long id){
		return genericDao.get(Reparticion.class, id);
	}



	/***
	 * Devuelve a los clientes con la condición de morosidad que se busca. Prejudicial, Moroso 1, Moroso 2. <br/>
	 * Si la empresa es null entonces no filtrará por empresa
	 * @param condicionMorosidad
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Cliente> obtenerclientePorCondicionMorosidad(String condicionMorosidad, Long empresaId) {
		
		List<Cliente> clientes = null;
		
		Criteria cri = genericDao.getSessionFactory().getCurrentSession().createCriteria(Cliente.class)
				.add(Restrictions.eq("condicionMorosidad", condicionMorosidad))				
				.add(Restrictions.ne("estado", EstadoClienteEnum.FALLECIDO))
				.add(Restrictions.ne("estado", EstadoClienteEnum.FALLECIDO_LEGALES))
				.add(Restrictions.ne("estado", EstadoClienteEnum.LEGALES))
				.add(Restrictions.ne("estado", EstadoClienteEnum.EJECUTADO))
				.add(Restrictions.ne("estado", EstadoClienteEnum.BAJA));
				
		
		if (empresaId != null){
			cri.createCriteria("creditoCondicionMorosidad").add(Restrictions.eq("empresa.id",empresaId));
			log.debug(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Agrega filtro por empresaId: " + empresaId);
		}
		clientes = cri.list();
		
		return clientes;
		
		
	}


	/***
	 * Devuelve la suma de los gastos de envío de carta para un cliente por cobrar o cobrado según vigente = 1 o 0
	 * @param clienteId
	 * @param b
	 * @return
	 */
	public double obtenerMontoGastoEnvioCarta(Long clienteId, boolean vigente) {
		String query = "select sum(monto) from GastoCliente g " +
				"where cliente_id = :clienteId " +
				"and vigente = :vigente";
		SQLQuery squery = serviceFacade.createSQLQuery(query);
		squery.setBoolean("vigente", vigente);
		squery.setLong("clienteId", clienteId);
		
		Double monto = (Double) squery.uniqueResult();
		
		return monto == null ? 0.0 : monto;
	}
	


	public double obtenerMontoPagoEnvioCarta(Long clienteId, Date fechaInicioPagoTransaccion, Date fechaFinPagoTransaccion) {
		String query = "select sum(monto) from GastoCliente g " +
				"where cliente_id = :clienteId " +
				"and fechaPago is not null " +
				"and fechaPago between :fechaInicio and :fechaFin";
		SQLQuery squery = serviceFacade.createSQLQuery(query);
		squery.setParameter("fechaInicio", fechaInicioPagoTransaccion);
		squery.setParameter("fechaFin", fechaFinPagoTransaccion);
		squery.setLong("clienteId", clienteId);
		
		Double monto = (Double) squery.uniqueResult();
		
		return monto == null ? 0.0 : monto;
	}


	/***
	 * Determina si el cliente está esperando respuesta del banco de alguna cuota
	 * @param clienteId
	 * @return
	 */
	public boolean esperaRespuestaBanco(Long clienteId) {
		
		
		String query = "select count(*) as resultado from Aux_disco a " +
				"where cliente_id = :clienteId " +
				"and generado = 1 " +
				"and codigoRespuestaBanco is null " +
				"and cuota_id is not null";
		
		SQLQuery squery = serviceFacade.createSQLQuery(query);
		squery.setLong("clienteId", clienteId);
		squery.addScalar("resultado", Hibernate.LONG);
		
		boolean result;
		result = ((Long)squery.uniqueResult() > 0);
		return result;
	
		
		
		
	}



	@Transactional
	public void ping() {
		try {
			SQLQuery query =  serviceFacade.createSQLQuery("select 1");
			query.uniqueResult();
		} catch (HibernateException e) {
			log.error(e);
		}
		
	}



	public String obtenerApellidoNombreComer(Long idCliente) {
		String q = "select case when com.nombre != '' then concat(com.apellido,', ',com.nombre) else com.apellido end nombre " +
				"from Comercializador com inner join Cliente c on c.idComercializador = com.id " +
				"where c.id = :id";
		SQLQuery query =  serviceFacade.createSQLQuery(q);
		query.setLong("id", idCliente);
		Object result = query.uniqueResult();
		
		if (result == null || ((String) result).isEmpty())
			return "";
		else
			return (String) result;
		
	}


	/***
	 * Devuelve la sucursal del cliente que se obtiene del último crédito activo o no activo en caso de no tener activos.
	 * En caso de no presentar créditos, se devuelve string vacío
	 * @param idCliente
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String obtenerSucursalCliente(Long idCliente){
		String qryCreditosActivos = "select s.sucursal from Credito c " +
				"inner join SolicitudAprobacionCredito s on c.solicitudAprobacionCredito_id = s.id " +
				"where c.cliente_id = :clienteId and c.estado = 'ACTIVO' order by c.id desc";
		
		SQLQuery query =  serviceFacade.createSQLQuery(qryCreditosActivos);
		query.setLong("clienteId", idCliente);
		List<Object> result = query.list();
		
		if (result != null && !result.isEmpty())
			return result.get(0).toString();
		
		
		//En caso de no encontrar ningún crédito activo
		String qryCreditos = "select s.sucursal from Credito c " +
				"inner join SolicitudAprobacionCredito s on c.solicitudAprobacionCredito_id = s.id " +
				"where c.cliente_id = :clienteId order by c.id desc";
		query =  serviceFacade.createSQLQuery(qryCreditos);
		query.setLong("clienteId", idCliente);
		result = query.list();
		
		
		if (result != null && !result.isEmpty())
			return result.get(0).toString();
		else
			return "";
	}


	public List<Long> creditosPorFinalizar(Long clienteId) throws Exception{
		try {
			List<Long> resultado = new ArrayList<Long>();
			
			String query = "select  credito_id from Cuota cuo " +
					"inner join Credito cre on cuo.credito_id = cre.id " +
					"where cuo.estado != 'PAGA' " +
					"and cre.estado = 'ACTIVO' " +
					"and cliente_id = :clienteId " +
					"group by credito_id having count(*) = 1"; 
					
			SQLQuery sqlQuery = serviceFacade.createSQLQuery(query);
			sqlQuery.setLong("clienteId", clienteId);
			
			List result = sqlQuery.list();
			
			for (Object obj : result) {
				resultado.add(((BigInteger)obj).longValue());
				
			}
			
			return resultado;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}
	
	/***
	 * Devuelve las ultimas cuotas sociales del cliente que se pasa por parámetro
	 * La Cantidad de cuotas tambien se pasa como parámetro
	 * Estados: ('NO_PAGA','PAGA')
	 * @param clienteId
	 * @param cantCuotas
	 * @return
	 * @throws Exception
	 */
	public List<CuotaSocial> obtenerCuotasSociales(Long clienteId,Long cantCuotas) throws Exception{	
		try {
			List<CuotaSocial> resultado=new ArrayList<CuotaSocial>();

			String sql = "select cuo.* from CuotaSocial cuo " +
					"inner join Cliente cli on cli.id = cuo.cliente_id "+
					"where cli.id = :cliente_id ";
			
			String sqlEstados = " and cuo.estado in ('NO_PAGA','PAGA') ";
			
			String sqlOrder = " order by cuo.mes asc "; 
			//String sqlOrder = " order by cuo.fechaPago asc ";
			String sqlLimit = " LIMIT " + String.valueOf(cantCuotas) ;
			
					
			SQLQuery query = serviceFacade.createSQLQuery(sql + sqlEstados + sqlOrder + sqlLimit);
			query.addEntity(CuotaSocial.class);
			query.setLong("cliente_id", clienteId);
			
			resultado = (List) query.list();
			
			return resultado;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}
	
	public List<CuotaSocial> obtenerCuotasSocialesPagas(Long clienteId,Long cantCuotas) throws Exception{
		//Devuelve las ultimas cuotas sociales Pagas del cliente que se pasa por parámetro
		//La Cantidad de cuotas tambien se pasa como parámetro
		//Se ordenan por fecha de pago descente
		try {
			List<CuotaSocial> resultado=new ArrayList<CuotaSocial>();

			String sql = "select cuo.* from CuotaSocial cuo " +
					"inner join Cliente cli on cli.id = cuo.cliente_id "+
					"where cli.id = :cliente_id ";
			
			String sqlEstados = " and cuo.estado = 'PAGA'";
			
			String sqlOrder = " order by cuo.fechaPago desc ";
			String sqlLimit = " LIMIT " + String.valueOf(cantCuotas) ;
			
					
			SQLQuery query = serviceFacade.createSQLQuery(sql + sqlEstados + sqlOrder + sqlLimit);
			query.addEntity(CuotaSocial.class);
			query.setLong("cliente_id", clienteId);
			
			resultado = (List) query.list();
			
			return resultado;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}
	public List<CuotaSocial> obtenerCuotasSocialesNoPagas(Long clienteId,Long cantCuotas) throws Exception{
		//Devuelve las ultimas cuotas sociales No Pagas del cliente que se pasa por parámetro
		//La Cantidad de cuotas tambien se pasa como parámetro
		//Las cuotas no pagas se ordenan de la mas vieja (mes) a la mas nueva
		try {
			List<CuotaSocial> resultado=new ArrayList<CuotaSocial>();

			String sql = "select cuo.* from CuotaSocial cuo " +
					"inner join Cliente cli on cli.id = cuo.cliente_id "+
					"where cli.id = :cliente_id ";
			
			String sqlEstados = " and cuo.estado = 'NO_PAGA' ";
			
			String sqlOrder = " order by cuo.mes asc "; 
			String sqlLimit = " LIMIT " + String.valueOf(cantCuotas) ;
			
					
			SQLQuery query = serviceFacade.createSQLQuery(sql + sqlEstados + sqlOrder + sqlLimit);
			query.addEntity(CuotaSocial.class);
			query.setLong("cliente_id", clienteId);
			
			resultado = (List) query.list();
			
			return resultado;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}


	
	@Transactional
	public void asociarDatosAnexosASolicitud(List<Long> anexos, Long solicitudId) throws CristalModelException {
		try {
			for (Long id : anexos) {
				DatoAnexo anexo = obtenerAnexoById(id.toString());
				anexo.setSolicitudCreditoId(solicitudId);
				genericDao.update(anexo);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new CristalModelException(e.getMessage());
		}
	}
	
	/***
	 * Devuelve lista de Clientes dado de baja en un rango de fechas
	 * @param fechaInicio
	 * @param fechaHasta
	 * @return
	 */
	public List<Cliente> obtenerClientesDadosDeBaja(Date fechaInicio, Date fechaHasta) {
		Calendar fechaInicial = DateUtil.createCalendar(fechaInicio);
		DateUtil.inicializarHoraMinutosSegundos(fechaInicial);
		Date fechaDesde = fechaInicial.getTime();
		
		
		log.debug(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() 
				+ " Consultando clientes dados de baja "
				+ " Fecha Desde: " + fechaDesde.toString()
				+ " Fecha Hasta: " + fechaHasta.toString());
		
		String  queryBajas = "select cli.* " 
				+ "from Cliente as cli " 
				+ "where cli.fechaBaja between :desde "  
				+ " and :hasta";

				
				
		SQLQuery squery = null;
		squery = serviceFacade.createSQLQuery(queryBajas);
		squery.setDate("desde", fechaDesde);
		squery.setDate("hasta", fechaHasta);
		
		squery.addEntity(Cliente.class);
		
		return (List<Cliente>) squery.list();
		
				
				
		
		
	}
	
	/***
	 * Devuelve la cantidad de días que pasaron desde el último pago
	 * Si no hay ningun pago, dias desde el 1er vencimiento de Cuota
	 * @param clienteId
	 * @return
	 */
	public Long obtenerDiasDesdeUltimoPagoXCliente(Long clienteId)throws Exception {
		Date ultimoPago=null;
		log.debug(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - Incio Cliente Id:" + clienteId);
		try {
			String query="select p.fechaPago " + 
					"from Pago p " +
					"inner join Cuota cuo on cuo.id = p.cuota_id " +
					"inner join Credito c on c.id = cuo.credito_id " +
					"where c.cliente_id = :clienteId "  +
					"and conceptoPago in ('PAGO_PARCIAL_DE_CUOTA','PAGO_PUNITORIO') " +
					"order by p.fechaPago desc " +
					"limit 1";
			
			SQLQuery squery = serviceFacade.createSQLQuery(query);			
			squery.setLong("clienteId", clienteId);
			
			
			log.debug("Query: " + squery.getQueryString());
			ultimoPago = (Date) squery.uniqueResult();
			
			if (ultimoPago == null) {
				//Nunca pago, Obtengo el vencimiento de la 1er Cuota
				log.debug("Cliente nunca registro pago. Se intenta obtener vencimiento 1ra cuota.");

				String query2="select cuo.fechaVencimiento " +
						"from  Cuota cuo " +
						"inner join Credito c " +
						"on c.id = cuo.credito_id " +
						"where c.cliente_id = :clienteId "  +
						"order by cuo.fechaVencimiento asc " + 
						"limit 1";
				
				SQLQuery squery2 = serviceFacade.createSQLQuery(query2);			
				squery2.setLong("clienteId", clienteId);
				
				
				log.debug("Query 1ra Cuota: " + squery2.getQueryString());
				ultimoPago = (Date) squery2.uniqueResult();
			}
			
			if (ultimoPago != null) {
				Long diff=serviceFacade.getFechaActual().getTime() - ultimoPago.getTime();
				Long diffDays = diff / (24 * 60 * 60 * 1000);
				return diffDays;
			} else {
				//Algun motivo extraño: ejemplo se eliminaron creditos a mano
				log.error("No se pueden obtener dias desde ultima cuota. Cliente: " + clienteId);
				return 0L;
			}
		} catch (HibernateException e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " error " + e.getMessage());
			throw e;
		}
		
	}
	
	/***
	 * Agregado Nov 14
	 * Si es una modificacion de datos, guarda un registro en una tabla de historicos
	 * Sirve para INAES y para poder saber que datos se modificaron en un rango de fechas
	 * @param cliente
	 * @throws Exception
	 */
	private void persistirClienteHistorialDatos(Cliente cli) throws Exception {
		try {
			log.info("Iniciando ClienteHistorialDatos.");
			if (cli.getId() != null && cli.getId() > 0) { 
				//Es la modificacion de un cliente (inserto registro)
				Cliente cliente = obtenerClienteById(cli.getId());
				
				if (cliente != null) {
					ClienteHistorialDatos ch=new ClienteHistorialDatos();
					ch.setApellido(cliente.getApellido());
					ch.setCalle(cliente.getCalle());
					ch.setCaracteristica(cliente.getCaracteristica());
					ch.setCaracteristica1(cliente.getCaracteristica1());
					ch.setCaracteristica2(cliente.getCaracteristica2());
					ch.setCaracteristica3(cliente.getCaracteristica3());
					ch.setCliente(cliente);
					ch.setCp(cliente.getCp());
					ch.setCuil(cliente.getCuil());
					ch.setCuit(cliente.getCuit());
					ch.setDni(cliente.getDni());
					ch.setEmail(cliente.getEmail());
					ch.setFechaNacimiento(cliente.getFechaNacimiento());
					ch.setLocalidad(cliente.getLocalidad());
					ch.setNombre(cliente.getNombre());
					ch.setNro(cliente.getNro());
					ch.setPiso(cliente.getPiso());
					ch.setTelefono(cliente.getTelefono());
					ch.setTelefono1(cliente.getTelefono1());
					ch.setTelefono2(cliente.getTelefono2());
					ch.setTelefono3(cliente.getTelefono3());
					ch.setTipoDocumento(cliente.getTipoDocumento());
					ch.setObservaciones(cliente.getObservaciones());
					ch.setFechaModificacion(serviceFacade.getFechaActual());
					ch.setUsuarioModificacion(serviceFacade.obtenerUsuarioLogueado().getId());
					
					log.info("Se va a guardar historico de Cliente: " + cliente.getId().toString());
					genericDao.save(ch);
				}
			}
		} catch (Exception e) {
			log.error("Error al persistir historialDatos: " + e.getMessage());
		}
	}
	
}
