package ar.com.cristal.creditos.server.converters;

import org.dozer.CustomConverter;

import ar.com.cristal.creditos.common.TipoDocAnexoEnum;

/**
 * Custom converter los tipos de documento permitidos para los anexos del cliente
 * @author lucas.napoli
 *
 */
public class TipoDocAnexoCustomConverter implements CustomConverter {

	

		  public Object convert(Object destination, Object source, Class destClass, Class sourceClass) {
		    if (source == null) {
		      return null;
		    }
		    
		    if (source instanceof String) {
		    	
		    	return TipoDocAnexoEnum.valueOf(source.toString());
		    	
		    }else{

		    	TipoDocAnexoEnum tipo = (TipoDocAnexoEnum)source;

		    	return tipo.toString();
		    	
		    }
		  
		  }
	}