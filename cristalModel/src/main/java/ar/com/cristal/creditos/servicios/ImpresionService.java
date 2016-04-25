package ar.com.cristal.creditos.servicios;

import java.util.Collection;
import java.util.Map;

import ar.com.cristal.creditos.common.LinkInfoPopup;
import ar.com.cristal.creditos.entity.reportes.TipoReporte;
import ar.com.cristal.creditos.util.DescriptorDeAccesoTemplate;

public interface ImpresionService {

	
	public LinkInfoPopup imprimirDocumento(DescriptorDeAccesoTemplate dt, Map<String, Object> hashMap, Collection<Object> data ) throws Exception;
	
	public LinkInfoPopup imprimirDocumento(DescriptorDeAccesoTemplate dt, Map<String, Object> hashMap,TipoReporte tipoReporte) throws Exception;

	
	/***
	 * Imprime el documento especificado en DatosTemplate con los hashMap datos.
	 * @param dt: descriptor de acceso
	 * @param params: parametros
	 * @param data
	 * @param formatoDocumento: xls, pdf
	 * @return
	 * @throws Exception
	 */
	public LinkInfoPopup imprimirDocumento(DescriptorDeAccesoTemplate dt, Map<String, Object> params , Collection<Object> data, String formatoDocumento) throws Exception;
}
