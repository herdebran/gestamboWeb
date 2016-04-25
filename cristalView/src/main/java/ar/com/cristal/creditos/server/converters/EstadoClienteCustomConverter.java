package ar.com.cristal.creditos.server.converters;

import org.dozer.CustomConverter;

import ar.com.cristal.creditos.common.EstadoClienteEnum;

/**
 * Custom converter para los estados de un Cliente
 * @author daniel.madera
 *
 */
public class EstadoClienteCustomConverter implements CustomConverter {

	

		  public Object convert(Object destination, Object source, Class destClass, Class sourceClass) {
		    if (source == null) {
		      return null;
		    }
		    
		    if (source instanceof String) {
		    	
		    	return EstadoClienteEnum.valueOf(source.toString());
		    	
		    }else{

		    	EstadoClienteEnum estado = (EstadoClienteEnum)source;

		    	return estado.toString();
		    	
		    }
		  
		  }
	}