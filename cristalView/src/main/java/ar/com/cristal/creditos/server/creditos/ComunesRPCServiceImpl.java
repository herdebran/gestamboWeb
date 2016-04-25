package ar.com.cristal.creditos.server.creditos;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.dozer.MappingException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ar.com.cristal.creditos.client.dto.EmpresaDTO;
import ar.com.cristal.creditos.client.dto.MedioContactoDTO;
import ar.com.cristal.creditos.client.dto.SucursalDTO;
import ar.com.cristal.creditos.client.dto.TablaDTO;
import ar.com.cristal.creditos.client.dto.TipoReporteDTO;
import ar.com.cristal.creditos.client.localidad.LocalidadDTO;
import ar.com.cristal.creditos.client.service.ComunesRPCService;
import ar.com.cristal.creditos.common.Constantes;
import ar.com.cristal.creditos.common.EstadoClienteEnum;
import ar.com.cristal.creditos.common.LinkInfoPopup;
import ar.com.cristal.creditos.entity.commons.Empresa;
import ar.com.cristal.creditos.entity.commons.Tablas;
import ar.com.cristal.creditos.entity.reportes.TipoReporte;
import ar.com.cristal.creditos.entity.sucursales.Sucursal;
import ar.com.cristal.creditos.localidad.Localidad;
import ar.com.cristal.creditos.server.util.MapperExtended;
import ar.com.cristal.creditos.servicios.ComunesService;
import ar.com.cristal.creditos.servicios.ImpresionService;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.servicios.TemplateManagerService;
import ar.com.cristal.creditos.util.DescriptorDeAccesoTemplate;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;


@SuppressWarnings("serial")
public class ComunesRPCServiceImpl extends RemoteServiceServlet implements
		ComunesRPCService {
	private WebApplicationContext context;
	private ServiceFacade serviceFacade;
	private ImpresionService impresionService;
	private TemplateManagerService templateManagerService;
	private MapperExtended mapper;	
	private ComunesService comunesService;
	
	private Logger log = Logger.getLogger(ComunesRPCServiceImpl.class);

	private String LIQUIDACION_COMERCIALIZADORES="LIQUIDACION_COMERCIALIZADORES";
	private String COBRANZAS="COBRANZAS";
	
	
	public void init() throws ServletException {
		super.init();
		context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		serviceFacade = (ServiceFacade) context.getBean("serviceFacade");
		mapper = (MapperExtended) context.getBean("dozerMapper");
		impresionService = (ImpresionService) context.getBean("impresionService");
		comunesService = (ComunesService) context.getBean("comunesService");
		templateManagerService=(TemplateManagerService)context.getBean("templateManager");
	}

	public List<ListBoxItem> obtenerListadoGenerico(String tipo) throws Exception {
		List<TablaDTO> valores = mapper.convertList(comunesService.obtenerTablaByTipo(tipo), TablaDTO.class);
		Collections.sort(valores, new Comparator<TablaDTO>() {

			public int compare(TablaDTO o1, TablaDTO o2) {
				
				return o1.getItemText().compareTo(o2.getItemText());
			}
		});
		List<ListBoxItem> result = new ArrayList<ListBoxItem>();
		TablaDTO valorVacio = new TablaDTO();
		valorVacio.setNombre("");
		valorVacio.setDescripcion("");
		valorVacio.setCodigo("VALOR_VACIO");
		valorVacio.setId(-1L);
		valores.add(0, valorVacio);
		for (TablaDTO valor : valores) {
			result.add(valor);
		}
		
		
		return result;
	}
	
	
	
	public List<TablaDTO> obtenerTablaByTipo(String tipo) throws Exception {
		try{
			return mapper.convertList(comunesService.obtenerTablaByTipo(tipo),
					TablaDTO.class);			
		}catch(Exception e ){
			throw e;
		}
		
	}

	
	
	/**
	 * retorna la lisat de enumerativos en un arraylist de strings
	 */
	public List<String> obtenerEstadosCliente() {
		List<String> l = new ArrayList<String>();
		for(EstadoClienteEnum estado : EstadoClienteEnum.values()){
			l.add(estado.toString());
		}
		return l;
	}
	
	public boolean validarEMail(String email) throws Exception{
		try {
			return comunesService.validarEMail(email);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new Exception(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Ocurrió un error al validar el email");
		}
	}

	

	public EmpresaDTO obtenerEmpresaPorId(Long id) throws Exception {
		try {
			return mapper.map(comunesService.obtenerEmpresaPorId(id), EmpresaDTO.class);
		} catch (MappingException e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " obtenerEmpresaPorId() Error de mapeo: " + e.getMessage(), e);
			throw new Exception("Se produjo un error al intentar obtener los datos de la empresa");
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " obtenerEmpresaPorId(): " + e.getMessage(), e);
			throw new Exception("Se produjo un error al intentar obtener los datos de la empresa");
		}
	}


	
	/*
	 * obtiene los datos necesarios e imprime el archivo.
	 */
	private LinkInfoPopup imprimirLiquidacionComercializador(
			List<Object> ventas, Map<String, Object> otrosDatos, Empresa emp, String nombreComer, String mes)throws Exception {
		DescriptorDeAccesoTemplate dat=null;
		log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Comenzando la generacion del reporte para comercializador " + nombreComer);
		LinkInfoPopup l;
		try {
			//obteniendo Descriptor de template con creacion de directorio (solo la primera vez)
			dat = templateManagerService
					.obtenerDatosDeAccesoByIdEmpresaAreaCodigoReporteExtencionConMINombreArchivoYMiDir(
							emp.getId().toString(), COBRANZAS,
							LIQUIDACION_COMERCIALIZADORES, "",nombreComer, mes);
	
			
			
			l =impresionService.imprimirDocumento(dat,otrosDatos, ventas,Constantes.REPORTE_EXPORTACION_XLS);
						
//			l =impresionService.imprimirDocumento(dat,otrosDatos, ventas,Constantes.REPORTE_EXPORTACION_PDF);
			
			l.setTextoDelLink(nombreComer + "_" + emp.getNombre());
			
			
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Se produjo un error en: imprimirLiquidacionComercializador() " + e.getMessage(), e);
			throw new Exception("Ocurrió un error al obtener el template para la liquidación de comercializadores: ");
		}
		return l;
			
		
	}
	
	
	public void cambiarEstadoACreditosYSusCuotas(List<Long> idsCreditos) throws Exception{
		try{
			comunesService.cambiarEstadoACreditosYSusCuotas(idsCreditos);
			
		}catch(Exception e){
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " error en cambiarEstadoACreditoYCuotas() " + e.getMessage(), e);
			throw new Exception("Ocurrió un error al cambiarle el estado de creditos por legales: " + e.getMessage());
		}
	}

	@Override
	public void cambiarEstadoACreditosYCuotas(Long idCliente) throws Exception {
		// Buscar creditos activos del cliente.
		// Establecer el/los creditos como LEGALES y sus cuotas como CANCELADA_LEGALES.
		serviceFacade.getCreditosService().cambiarEstadoACreditosYCuotas(idCliente);
	}




	@Override
	public List<TipoReporteDTO> obtenerTiposReporte() throws Exception {
		List<TipoReporte> tiposReportes = comunesService.obtenerTiposReporte();
		List<TipoReporteDTO> tiposReportesDTO = new ArrayList<TipoReporteDTO>(); 
		try{
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Info iniciando obtenerTiposReporte...");
			tiposReportesDTO = mapper.convertList(tiposReportes, TipoReporteDTO.class);
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Fin de obtenerTiposReporte.");
		}catch(Exception e){
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Error al obtenerTiposReporte " + e.getMessage(), e);
			throw new Exception("Se produjo un error al obtener los tipos de reportes.");
		}
		return tiposReportesDTO;
	}

	@Override
	public List<MedioContactoDTO> obtenerMediosContacto() {
		return mapper.convertList(comunesService.obtenerMediosContacto(), MedioContactoDTO.class);
	}



	@Override
	public List<LocalidadDTO> buscarLocalidad(LocalidadDTO localidadDTO)	throws Exception {
		Localidad localidad = mapper.map(localidadDTO,Localidad.class);
		List<Localidad> localidades = comunesService.buscarLocalidad(localidad);
		List<LocalidadDTO> localidadesDTO = mapper.convertList(localidades, LocalidadDTO.class);
		return localidadesDTO;
	}

	@Override
	public LocalidadDTO guardarCrearLocalidad(LocalidadDTO localidadDTO)	throws Exception {
		Localidad localidad = mapper.map(localidadDTO,Localidad.class);
		comunesService.guardarCrearLocalidad(localidad);
		localidadDTO.setId(localidad.getId());
		return localidadDTO;
	}



	@Override
	public EmpresaDTO guardarCrearEmpresa(EmpresaDTO empresaDTO) throws Exception {
		Empresa empresa = mapper.map(empresaDTO,Empresa.class);
		comunesService.guardarCrearEmpresa(empresa);
		empresa.setId(empresa.getId());
		return empresaDTO;
	}

	@Override
	public List<EmpresaDTO> buscarEmpresa(EmpresaDTO empresaDTO) {
		Empresa empresa = mapper.map(empresaDTO,Empresa.class);
		List<Empresa> empresas = comunesService.buscarEmpresa(empresa);
		List<EmpresaDTO> empresasDTO = mapper.convertList(empresas, EmpresaDTO.class);
		return empresasDTO;
	}

	@Override
	public SucursalDTO guardarCrearSucursal(SucursalDTO sucursalDTO)	throws Exception {
		Sucursal sucursal = mapper.map(sucursalDTO,Sucursal.class);
		comunesService.guardarCrearSucursal(sucursal);
		sucursalDTO.setId(sucursal.getId());
		return sucursalDTO;
	}

	@Override
	public List<SucursalDTO> buscarSucursal(SucursalDTO sucursalDTO) {
		Sucursal sucursal = mapper.map(sucursalDTO,Sucursal.class);
		List<Sucursal> sucursales = comunesService.buscarSucursal(sucursal);
		List<SucursalDTO> sucursalesDTO = mapper.convertList(sucursales, SucursalDTO.class);
		return sucursalesDTO;
	}

	
	/**
	 * obtiene todas las empresas registradas
	 */
	@Override
	public List<EmpresaDTO> obtenerEmpresas() throws Exception {
	
		List<EmpresaDTO> res = new ArrayList<EmpresaDTO>();
	    try {
			List<Empresa> empresas = comunesService.obtenerEmpresas();

			res = mapper.convertList(empresas, EmpresaDTO.class);
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " error al obtener las empresas " + e.getMessage(), e);
			throw new Exception("Se produjo un error al obtener las empresas");
		}
	    		
		return res;
	}


	@Override
	public String ubicacionCartasSambaShare() throws Exception {
		return comunesService.getUbicacionCartasSambaShare();
	}

	@Override
	public boolean isVerazActivo() throws Exception {
		return comunesService.isVerazOnlineActivo();
	}

	@Override
	public List<ListBoxItem> obtenerListadoSeguimientoManual() throws Exception {
		List<ListBoxItem> result = obtenerListadoGenerico(Constantes.CALLCENTER_ASIGNACION_LLAMADA);
		
		Tablas moraTardia = serviceFacade.getComunesService().obtenerTablaByCodigoYTipo("MORA_TARDIA", Constantes.MORA_TARDIA_ASIGNACION_LLAMADA);
		
		TablaDTO moraTardiaDTO = mapper.map(moraTardia, TablaDTO.class);
		
		result.add(moraTardiaDTO);
		
		return result;
	}

	@Override
	public Date obtenerFechaActual() {
		return serviceFacade.getFechaActual();
	}

	@Override
	public List<List<ListBoxItem>> obtenerDatosCombos(boolean banco,
			boolean comercializador) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
