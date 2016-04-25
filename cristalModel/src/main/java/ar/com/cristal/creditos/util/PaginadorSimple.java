package ar.com.cristal.creditos.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class PaginadorSimple {

	private Logger log = Logger.getLogger(PaginadorSimple.class);
	
	public PaginadorSimple() {
		super();
	}


	public List paginar(List listado, int nroPagina){
		
		if (listado.size() <= 0) return listado;
		
		int registrosPorPagina = listado.size() / obtenerCantidadSegmentos(listado.size());
		
		if (listado.size() < 50) registrosPorPagina = 50;
		
		if (obtenerCantidadSegmentos(listado.size()) == nroPagina+1)
			registrosPorPagina += obtenerCantidadSegmentos(listado.size()) % (nroPagina+1);
		
		
		int limiteInferior = nroPagina * registrosPorPagina;
		
		return paginar(listado, limiteInferior, registrosPorPagina);
	}
	
	
	private List paginar(List listado, int limiteInferior,
			int registrosPorPagina) {
		
		//Esto se hace cuando no se quiere paginar
		if (limiteInferior <= 0 && registrosPorPagina <= 0)
			return listado;
		
		//Es cuando la cantidad que pido teniendo como referencia un inicio en el medio de la lista supera la cantidad de registross por página
		if (registrosPorPagina + limiteInferior> listado.size()) 
			registrosPorPagina = listado.size() - limiteInferior;
		
		//cuando estoy tratando de pedir un con tope inferior mayor a la cantidad de items de la lista
		if (limiteInferior >= listado.size()) return new ArrayList();
		
		log.info("Paginando: " + limiteInferior + " -  " + (limiteInferior + registrosPorPagina));
		
		List resultado = listado.subList(limiteInferior, limiteInferior + registrosPorPagina);
				
		
		return resultado;
	}	
	
	
	
	
	public int obtenerCantidadSegmentos(int cantidad){
		if (cantidad > 6000) 
			return 20;
		else if (cantidad > 4500)
			return 16;
		else if (cantidad > 3000)
			return 10;
		else if (cantidad > 2500)
			return 8;
		else if (cantidad > 1000)
			return 6;
		else if (cantidad > 700)
			return 5;
		else if (cantidad > 500)
			return 4;
		else if (cantidad > 100)
			return 3;
		else
			return 1;
	}
	
	
	public List paginarParalelos(List listado, int nroPagina){
		log.info("Paginar Paralelos. Registros totales:" + listado.size() + " Mostrar segmento:" + nroPagina);
		if (listado.size() <= 0) return listado;
		
		int registrosPorPagina = listado.size() / obtenerCantidadSegmentosListadoParalelos(listado.size());
		
		if (listado.size() < 50) registrosPorPagina = 50;
		
		if (obtenerCantidadSegmentosListadoParalelos(listado.size()) == nroPagina+1)
			registrosPorPagina += obtenerCantidadSegmentosListadoParalelos(listado.size()) % (nroPagina+1);
		
		
		int limiteInferior = nroPagina * registrosPorPagina;
		
		return paginar(listado, limiteInferior, registrosPorPagina);
	}
	
	public int obtenerCantidadSegmentosListadoParalelos(int cantidad){
		if (cantidad > 6000) 
			return 50;
		else if (cantidad > 4500)
			return 45;
		else if (cantidad > 3000)
			return 40;
		else if (cantidad > 2500)
			return 30;
		else if (cantidad > 1000)
			return 20;
		else if (cantidad > 700)
			return 10;
		else if (cantidad > 500)
			return 5;
		else if (cantidad > 100)
			return 4;
		else if (cantidad > 50)
			return 2;
		else
			return 1;
	}
	
}
