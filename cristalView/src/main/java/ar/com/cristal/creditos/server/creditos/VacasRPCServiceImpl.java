package ar.com.cristal.creditos.server.creditos;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ar.com.cristal.creditos.client.service.VacasRPCService;
import ar.com.cristal.creditos.client.tambo.dto.RodeoDTO;
import ar.com.cristal.creditos.client.tambo.dto.VacaDTO;
import ar.com.cristal.creditos.entity.creditos.Cliente;
import ar.com.cristal.creditos.entity.tambo.Rodeo;
import ar.com.cristal.creditos.entity.tambo.Vaca;
import ar.com.cristal.creditos.server.util.MapperExtended;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.servicios.VacasService;
import ar.com.cristal.creditos.servicios.impl.UsuarioServiceImpl;
import de.novanic.eventservice.service.RemoteEventServiceServlet;

@SuppressWarnings("serial")
public class VacasRPCServiceImpl extends RemoteEventServiceServlet implements VacasRPCService{
	
	private WebApplicationContext context;
	private VacasService vacasService;
	private UsuarioServiceImpl  usuarioService;
	private MapperExtended mapper;
	private ServiceFacade serviceFacade;
	private Logger log = Logger.getLogger(VacasRPCServiceImpl.class);	
	
	@Override
	public void init() throws ServletException {
		super.init();
		context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		vacasService = (VacasService) context.getBean("vacasService");
		usuarioService = (UsuarioServiceImpl) context.getBean("usuarioService");
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
	public void guardarRodeoRPC (RodeoDTO rodeo)throws Exception {
			try {
				Rodeo r = mapper.map(rodeo, Rodeo.class);
				vacasService.persistirRodeo(r);
			} catch (Exception e) {
				throw new Exception("Se produjo un error al intentar persistir Rodeo. " + e.getMessage());
			
		}
	}
	
	@Override
	public void eliminarRodeoRPC (RodeoDTO rodeo)throws Exception {
		vacasService.eliminarRodeo((mapper.map(rodeo, Rodeo.class)));
	}
}