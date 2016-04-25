package ar.com.cristal.creditos.server.converters;

import org.dozer.CustomConverter;

import ar.com.cristal.creditos.common.EstadoCreditoEnum;

/**
 * Custom converter para los estados de un Crédito
 * @author lucas.napoli
 *
 */
public class EstadoCreditoCustomConverter implements CustomConverter {

	

		  public Object convert(Object destination, Object source, Class destClass, Class sourceClass) {
		    if (source == null) {
		      return null;
		    }
		    
		    if (source instanceof String) {
		    	
		    	return EstadoCreditoEnum.valueOf(source.toString());
		    	
		    }else{

		    	EstadoCreditoEnum estado = (EstadoCreditoEnum)source;

		    	return estado.toString();
		    	
		    }
		  
		  }
	}