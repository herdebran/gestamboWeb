package ar.com.cristal.creditos.server.creditos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ar.com.cristal.creditos.servicios.impl.ClienteService;
import de.novanic.eventservice.service.RemoteEventServiceServlet;

@SuppressWarnings("serial")
public class OpenDatosAnexosServlet extends RemoteEventServiceServlet{
	
	private WebApplicationContext context;

	private ClienteService clienteService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		clienteService = (ClienteService) context.getBean("clienteService");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType(request.getParameter("mimeType"));
		String extencion = getExtencion(request.getParameter("mimeType"));
		if (isImage(request.getParameter("mimeType"))){ 
			response.setHeader("Content-disposition", "");
			
		}
		else response.setHeader("Content-disposition", "attachment; filename="+"DocAnexo_"+request.getParameter("idDocAnexo")+extencion);
		
		try{
			String idDoc = request.getParameter("idDocAnexo");
			byte[] docAnexoFileContent = clienteService.obtenerFileContentAnexoById(idDoc);
			
			response.getOutputStream().write(docAnexoFileContent);
		}catch (Throwable e){
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			throw new ServletException(e);
		}
	}

	private boolean isImage(String parameter) {
		if ((parameter.equals("image/jpg"))
				|| (parameter.equals("image/jpeg"))
				|| (parameter.equals("image/gif"))
				|| (parameter.equals("image/tiff"))
				|| (parameter.equals("image/png")))
			return true;
		else return false;
	}

	private String getExtencion(String parameter) {
		String result="";
		if (parameter.equals("application/pdf")){
			result = ".pdf";
		}else if (parameter.equals("application/msword")){
			result = ".doc";
		}else if (parameter.equals("application/vnd.oasis.opendocument.text")){
			result = ".odt";
		}else if (parameter.equals("application/vnd.ms-excel")){
			result = ".xls";
		}else if (parameter.equals("image/jpg")){
			result = ".jpg";
		}else if (parameter.equals("image/jpeg")){
			result = ".jpeg";
		}else if (parameter.equals("image/gif")){
			result = ".gif";
		}else if (parameter.equals("image/tiff")){
			result = ".tiff";
		}else if (parameter.equals("image/png")){
			result = ".png";
		} else if (parameter.equals("application/zip")){
			result = ".zip";
		}
		
		return result;
	}
	
}