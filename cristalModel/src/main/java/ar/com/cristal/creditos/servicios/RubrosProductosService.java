package ar.com.cristal.creditos.servicios;
import ar.com.cristal.creditos.common.TipoMovStockEnum;
import ar.com.cristal.creditos.entity.tambo.MovimientoStock;
/**
 * Servicio para manejar todo lo relativo a Rubros y productos: Stocks, etc
 */
import ar.com.cristal.creditos.entity.tambo.Producto;


public interface RubrosProductosService {


	Producto persistirProducto(Producto producto) throws Exception;

	Producto obtenerProductoById(Long id) throws Exception;

	Producto cargarMovStockProducto(Producto prod, double cantidad,
			TipoMovStockEnum tipoMov) throws Exception;


}