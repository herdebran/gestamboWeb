package ar.com.cristal.creditos.server.creditos;

import java.text.SimpleDateFormat;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ar.com.cristal.creditos.client.service.CreditosRPCService;
import ar.com.cristal.creditos.common.CristalProperties;
import ar.com.cristal.creditos.server.util.MapperExtended;
import ar.com.cristal.creditos.servicios.CreditosService;
import ar.com.cristal.creditos.servicios.ServiceFacade;
import ar.com.cristal.creditos.servicios.impl.ClienteService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class CreditosRPCServiceImpl extends RemoteServiceServlet implements
		CreditosRPCService {	
	private static final double UMBRAL_MONTO_MINIMO_PRESTAMO = 100.0;
	private static final String NO_APLICA = "N/A";
	private String FINANCIACION_INTERES = "financiacion.interes";
	private CristalProperties cristalProperties = CristalProperties.getInstance();
	private WebApplicationContext context;
	private ServiceFacade serviceFacade;
	private CreditosService creditosService;
	private ClienteService clienteService;	
	private MapperExtended mapper;
	private SimpleDateFormat fecha_format = new SimpleDateFormat("dd/MM/yyyy");

	private Logger log = Logger.getLogger(CreditosRPCServiceImpl.class);	
	
	@Override
	public void init() throws ServletException {
		super.init();
		context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		serviceFacade = (ServiceFacade) context.getBean("serviceFacade");
		creditosService = (CreditosService) context.getBean("creditosService");
		clienteService = (ClienteService) context.getBean("clienteService");		
		mapper = (MapperExtended) context.getBean("dozerMapper");
		
		
	}

}




