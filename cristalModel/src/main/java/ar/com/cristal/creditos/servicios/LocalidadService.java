package ar.com.cristal.creditos.servicios;

import java.util.List;

import ar.com.cristal.creditos.localidad.Localidad;
import ar.com.cristal.creditos.localidad.Provincia;

public interface LocalidadService {
	public Localidad obtenerLocalidad(Long cliente_id);
	
	public List<Provincia> obtenerProvincias();
	
	public List<Localidad> obtenerLocalidades();
	
}
