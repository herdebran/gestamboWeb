package ar.com.cristal.creditos.servicios;

import java.io.FileOutputStream;

import ar.com.cristal.creditos.util.DescriptorDeAccesoTemplate;

public interface TemplateManagerService {

	
	public String obtenerFullPathParaGuardarbyNombreArchivo(String nombreArchivo, String extencion)throws Exception;
	
	public FileOutputStream obtenerOutputStreamReporteByNombreArchivo(String nombreArchivo, String extencion) throws Exception;
	
	public DescriptorDeAccesoTemplate obtenerDatosDeAccesoByNombreTemplateYExtensionSalida(String nombreArchivo, String extencion) throws Exception;
	
	public DescriptorDeAccesoTemplate obtenerDatosDeAccesoByNombreArchivoExtEIdEmpresa(String nombreArchivo, String extencion, String idEmpresa) throws Exception;
	
	public DescriptorDeAccesoTemplate obtenerDatosDeAccesoByIdEmpresaAreaCodigoReporteYExtencion(String idEmpresa, String area, String codigoReporte, String extencion) throws Exception;
	
	public DescriptorDeAccesoTemplate obtenerDatosDeAccesoByIdEmpresaAreaCodigoReporteYExtencion(String idEmpresa, String area, String codigoReporte, String extension, String identificador) throws Exception;
	
	public DescriptorDeAccesoTemplate obtenerDatosDeAccesoByIdEmpresaAreaCodigoReporteExtencionConMINombreArchivoYMiDir(String idEmpresa, String area, String codigoReporte, String extencion, String miNombreArchivo, String miDir) throws Exception;

	/***
	 * Busca información del template usando el nombre del template, código de área, código reporte
	 * @param nombreReporte
	 * @param codigoArea
	 * @param codigoReporte
	 * @return
	 * @throws Exception
	 */
	public DescriptorDeAccesoTemplate obtenerDatosDeAccesoByNombreTemplateCodigoAreaCodigoReporte(
			String nombreReporte, String codigoArea, String codigoReporte) throws Exception;
}
