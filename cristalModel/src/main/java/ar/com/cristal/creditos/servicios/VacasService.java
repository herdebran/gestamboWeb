package ar.com.cristal.creditos.servicios;

import ar.com.cristal.creditos.entity.tambo.Rodeo;
import ar.com.cristal.creditos.entity.tambo.Vaca;


public interface VacasService {

	Vaca guardarVaca(Vaca vaca) throws Exception;

	Vaca obtenerVacaById(Long id);

	void persistirRodeo(Rodeo rodeo) throws Exception;

	void eliminarRodeo(Rodeo rodeo) throws Exception;

	Rodeo obtenerRodeoById(Long id);

	void eliminarRodeoById(Long id) throws Exception;

	Vaca obtenerVacaPorRP(String rp) throws Exception;
	

}