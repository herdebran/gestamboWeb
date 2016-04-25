package ar.com.cristal.creditos.server.creditos;

import java.util.List;

import javax.servlet.ServletException;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ar.com.cristal.creditos.client.localidad.LocalidadDTO;
import ar.com.cristal.creditos.client.localidad.ProvinciaDTO;
import ar.com.cristal.creditos.client.service.LocalidadRPCService;
import ar.com.cristal.creditos.server.util.MapperExtended;
import ar.com.cristal.creditos.servicios.LocalidadService;
import ar.com.cristal.creditos.servicios.impl.LocalidadServiceImpl;
import de.novanic.eventservice.service.RemoteEventServiceServlet;

@SuppressWarnings("serial")
public class LocalidadRCPServiceImpl extends RemoteEventServiceServlet implements LocalidadRPCService {

	private LocalidadService localidadService;
	private MapperExtended mapper;
	public MapperExtended getMapper() {
		return mapper;
	}
	private WebApplicationContext context;
	

	@Override
	public void init() throws ServletException {
		super.init();
		context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		localidadService = (LocalidadServiceImpl) context.getBean("localidadService");
		mapper = (MapperExtended) context.getBean("dozerMapper");
	}
	public LocalidadDTO obtenerLocalidad(Long cliente_id) {
		return getMapper().map(localidadService.obtenerLocalidad(cliente_id),LocalidadDTO.class);
	}
	public List<ProvinciaDTO> obtenerProvincias() {
		
		List<ProvinciaDTO> provincias = getMapper().convertList(localidadService.obtenerProvincias(),ProvinciaDTO.class);
		return provincias;
	}
	public List<LocalidadDTO> obtenerLocalidades() {
		List<LocalidadDTO> localidades = getMapper().convertList(localidadService.obtenerLocalidades(), LocalidadDTO.class);
		return localidades;
	}

}
