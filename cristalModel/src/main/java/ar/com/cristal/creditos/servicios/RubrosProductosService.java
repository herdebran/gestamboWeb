package ar.com.cristal.creditos.servicios;
/**
 * Servicio para manejar todo lo relativo a Rubros y productos: Stocks, etc
 */
import ar.com.cristal.creditos.entity.tambo.Producto;


public interface RubrosProductosService {


	Producto persistirProducto(Producto producto) throws Exception;

	

}