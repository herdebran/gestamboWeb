package ar.com.cristal.creditos.impresion.comunes;

import java.sql.Connection;
import java.util.Collection;
import java.util.Map;

import ar.com.cristal.creditos.common.LinkInfoPopup;
import ar.com.cristal.creditos.util.DescriptorDeAccesoTemplate;

public interface IReportExporter {



	public LinkInfoPopup exportar(DescriptorDeAccesoTemplate dt, Map<String, Object> hashMap,
			 Collection<Object> data) throws Exception;

	
	public LinkInfoPopup exportar(DescriptorDeAccesoTemplate dt, Map<String, Object> hashMap,
			  Connection c) throws Exception;


}
