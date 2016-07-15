package ar.com.cristal.creditos.servicios;

import java.util.List;

import ar.com.cristal.creditos.entity.tambo.Categoria;
import ar.com.cristal.creditos.entity.tambo.CeloServicio;
import ar.com.cristal.creditos.entity.tambo.Inseminador;
import ar.com.cristal.creditos.entity.tambo.Raza;
import ar.com.cristal.creditos.entity.tambo.ResultadoTacto;
import ar.com.cristal.creditos.entity.tambo.Rodeo;
import ar.com.cristal.creditos.entity.tambo.TipoServicio;
import ar.com.cristal.creditos.entity.tambo.Toro;
import ar.com.cristal.creditos.entity.tambo.Vaca;


public interface VacasService {

	Vaca guardarVaca(Vaca vaca) throws Exception;

	Vaca obtenerVacaById(Long id) throws Exception;

	Rodeo persistirRodeo(Rodeo rodeo) throws Exception;

	void eliminarRodeo(Rodeo rodeo) throws Exception;

	Rodeo obtenerRodeoById(Long id);

	void eliminarRodeoById(Long id) throws Exception;

	Vaca obtenerVacaPorRP(String rp) throws Exception;

	List<Raza> obtenerRazas();

	List<Rodeo> obtenerRodeos() throws Exception;

	List<Categoria> obtenerCategorias(long idRaza) throws Exception;

	List<ResultadoTacto> obtenerResultadosTacto();

	Toro persistirToro(Toro toro) throws Exception;

	List<Toro> obtenerToros() throws Exception;

	List<Toro> buscarToroPorNombre(String nombre) throws Exception;

	List<Rodeo> buscarRodeoPorNombre(String nombre) throws Exception;

	List<Vaca> listarVacaXRodeoId(Long rodeoId) throws Exception;

	List<Vaca> obtenerVacasByParam(String param) throws Exception;

	CeloServicio persistirCeloServicio(CeloServicio celoServicio)
			throws Exception;

	Inseminador persistirInseminador(Inseminador inseminador) throws Exception;

	void eliminarCeloServicio(CeloServicio cs) throws Exception;

	CeloServicio obtenerCeloServicioById(Long id);

	void eliminarCeloServicioById(Long id) throws Exception;

	List<Inseminador> obtenerInseminadores() throws Exception;

	List<Vaca> obtenerVacasEstablecimientoActual() throws Exception;

	List<TipoServicio> obtenerTiposServicio() throws Exception;
	

}