package ar.com.cristal.creditos.server.creditos;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ar.com.cristal.creditos.client.service.VacasRPCService;
import ar.com.cristal.creditos.client.tambo.dto.CategoriaDTO;
import ar.com.cristal.creditos.client.tambo.dto.InseminadorDTO;
import ar.com.cristal.creditos.client.tambo.dto.RazaDTO;
import ar.com.cristal.creditos.client.tambo.dto.ResultadoTactoDTO;
import ar.com.cristal.creditos.client.tambo.dto.RodeoDTO;
import ar.com.cristal.creditos.client.tambo.dto.TipoServicioDTO;
import ar.com.cristal.creditos.client.tambo.dto.ToroDTO;
import ar.com.cristal.creditos.client.tambo.dto.VacaDTO;
import ar.com.cristal.creditos.entity.tambo.Rodeo;
import ar.com.cristal.creditos.entity.tambo.Toro;
import ar.com.cristal.creditos.entity.tambo.Vaca;
import ar.com.cristal.creditos.server.util.MapperExtended;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.servicios.VacasService;
import de.novanic.eventservice.service.RemoteEventServiceServlet;

@SuppressWarnings("serial")
public class VacasRPCServiceImpl extends RemoteEventServiceServlet implements VacasRPCService{
	
	private WebApplicationContext context;
	private VacasService vacasService;
	private MapperExtended mapper;
	private ServiceFacade serviceFacade;
	private Logger log = Logger.getLogger(VacasRPCServiceImpl.class);	
	
	@Override
	public void init() throws ServletException {
		super.init();
		context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		vacasService = (VacasService) context.getBean("vacasService");
		serviceFacade = (ServiceFacade) context.getBean("serviceFacade");
		mapper = (MapperExtended) context.getBean("dozerMapper");
	}

	@Override
	public VacaDTO obtenerVacaById(Long id) throws Exception {
		try {
			Vaca c = vacasService.obtenerVacaById(id);
			
			VacaDTO result = null;
			if (c != null)
				result = mapper.map(c, VacaDTO.class);
			
			return result;
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - obtenerVacaById(): " + id,e);
			throw new Exception("Se produjo un error al intentar obtener vaca con id: " + id);
		}
	}
	
	@Override
	public VacaDTO guardarVacaRPC (VacaDTO vacaDTO)throws Exception {
		try {
			Vaca vaca = mapper.map(vacaDTO, Vaca.class);
			return mapper.map(vacasService.guardarVaca(vaca),VacaDTO.class);
		} catch (Exception e) {
			throw e;
		}
	}

	
	@Override
	public VacaDTO obtenerVacaDTOPorRP(final String rp) throws Exception{
		try {
			return mapper.map(vacasService.obtenerVacaPorRP(rp),VacaDTO.class);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean existeVacaRPC (final String rp)throws Exception{
		
		try {
			Vaca v =vacasService.obtenerVacaPorRP(rp);
			
			return (v!=null);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public RodeoDTO guardarRodeoRPC (RodeoDTO rodeo)throws Exception {
			try {
				Rodeo r = mapper.map(rodeo, Rodeo.class);
				return mapper.map(vacasService.persistirRodeo(r),RodeoDTO.class);
			} catch (Exception e) {
				throw new Exception("Se produjo un error al intentar persistir Rodeo. " + e.getMessage());
			
		}
	}
	
	@Override
	public void eliminarRodeoRPC (RodeoDTO rodeo)throws Exception {
		vacasService.eliminarRodeo((mapper.map(rodeo, Rodeo.class)));
	}
	
	@Override
	public List<RazaDTO> obtenerRazasRPC() {
		
		List<RazaDTO> razas = mapper.convertList(vacasService.obtenerRazas(),RazaDTO.class);
		return razas;
	}
	
	@Override
	public List<RodeoDTO> obtenerRodeosRPC() throws Exception{
		try {
			return mapper.convertList(vacasService.obtenerRodeos(),RodeoDTO.class);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public List<CategoriaDTO> obtenerCategoriasRPC(long idRaza) throws Exception{
		try {
			return mapper.convertList(vacasService.obtenerCategorias(idRaza),CategoriaDTO.class);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<ResultadoTactoDTO> obtenerResultadosTactoRPC() {
		
		List<ResultadoTactoDTO> resDTO = mapper.convertList(vacasService.obtenerResultadosTacto(),ResultadoTactoDTO.class);
		return resDTO;
	}

	@Override
	public ToroDTO persistirToroRPC (ToroDTO toroDTO)throws Exception {
		try {
			Toro toro = mapper.map(toroDTO, Toro.class);
			return mapper.map(vacasService.persistirToro(toro),ToroDTO.class);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<ToroDTO> obtenerTorosRPC() throws Exception{
		try {
			return mapper.convertList(vacasService.obtenerToros(),ToroDTO.class);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<ToroDTO> buscarToroPorNombre(String nombre)	throws Exception {
		List<Toro> toros = vacasService.buscarToroPorNombre(nombre);
		List<ToroDTO> torosDTO = mapper.convertList(toros, ToroDTO.class);
		return torosDTO;
	}

	@Override
	public List<RodeoDTO> buscarRodeoPorNombre(String nombre)	throws Exception {
		List<Rodeo> rodeos = vacasService.buscarRodeoPorNombre(nombre);
		List<RodeoDTO> rodeosDTO = mapper.convertList(rodeos, RodeoDTO.class);
		return rodeosDTO;
	}

	@Override
	public List<VacaDTO> ListarVacasXRodeoIdRPC(Long rodeoId) throws Exception{
		try {
			return mapper.convertList(vacasService.listarVacaXRodeoId(rodeoId),VacaDTO.class);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public List<VacaDTO> obtenerVacasByParam(String param) throws Exception {
		try {
			long tiempo = new Date().getTime(); 
			List<Vaca> busqueda= vacasService.obtenerVacasByParam(param);
			
			log.info(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " Tiempo de búsqueda [ms] : " + (new Date().getTime() - tiempo) + ". Cantidad de resultados: " + busqueda.size());
			
			return mapper.convertList(busqueda, VacaDTO.class);
		} catch (Exception e) {
			log.error(serviceFacade.obtenerNombreSesionUsuarioUsuarioLogueado() + " - Se produjo un error al obtener vacas." + e.getMessage(), e);
			throw new Exception("Se produjo un error al obtener los vacas.");
		}
	}

	@Override
	public List<InseminadorDTO> obtenerInseminadoresRPC() throws Exception{
		try {
			return mapper.convertList(vacasService.obtenerInseminadores(),InseminadorDTO.class);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<VacaDTO> obtenerVacasEstablecimientoActualRPC() throws Exception{
		try {
			return mapper.convertList(vacasService.obtenerVacasEstablecimientoActual(),VacaDTO.class);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<TipoServicioDTO> obtenerTiposServicioRPC() throws Exception{
		try {
			return mapper.convertList(vacasService.obtenerTiposServicio(),TipoServicioDTO.class);
		} catch (Exception e) {
			throw e;
		}
	}

}