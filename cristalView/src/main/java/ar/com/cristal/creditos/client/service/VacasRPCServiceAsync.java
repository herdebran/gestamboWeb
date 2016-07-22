package ar.com.cristal.creditos.client.service;

import java.util.Date;
import java.util.List;

import ar.com.cristal.creditos.client.tambo.dto.CategoriaDTO;
import ar.com.cristal.creditos.client.tambo.dto.CeloServicioDTO;
import ar.com.cristal.creditos.client.tambo.dto.InseminadorDTO;
import ar.com.cristal.creditos.client.tambo.dto.RazaDTO;
import ar.com.cristal.creditos.client.tambo.dto.ResultadoTactoDTO;
import ar.com.cristal.creditos.client.tambo.dto.RodeoDTO;
import ar.com.cristal.creditos.client.tambo.dto.TipoServicioDTO;
import ar.com.cristal.creditos.client.tambo.dto.ToroDTO;
import ar.com.cristal.creditos.client.tambo.dto.VacaDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface VacasRPCServiceAsync {

	void obtenerVacaById(Long id, AsyncCallback<VacaDTO> callback);

	void guardarRodeoRPC(RodeoDTO rodeo, AsyncCallback<RodeoDTO> callback);

	void eliminarRodeoRPC(RodeoDTO rodeo, AsyncCallback<Void> callback);

	void obtenerVacaDTOPorRP(String rp, AsyncCallback<VacaDTO> callback);

	void existeVacaRPC(String rp, AsyncCallback<Boolean> callback);

	void guardarVacaRPC(VacaDTO vacaDTO, AsyncCallback<VacaDTO> callback);

	void obtenerRazasRPC(AsyncCallback<List<RazaDTO>> callback);

	void obtenerRodeosRPC(AsyncCallback<List<RodeoDTO>> callback);

	void obtenerCategoriasRPC(long idRaza,
			AsyncCallback<List<CategoriaDTO>> callback);

	void obtenerResultadosTactoRPC(
			AsyncCallback<List<ResultadoTactoDTO>> callback);

	void persistirToroRPC(ToroDTO toroDTO, AsyncCallback<ToroDTO> callback);

	void obtenerTorosRPC(AsyncCallback<List<ToroDTO>> callback);

	void buscarToroPorNombre(String nombre,
			AsyncCallback<List<ToroDTO>> callback);

	void buscarRodeoPorNombre(String nombre,
			AsyncCallback<List<RodeoDTO>> callback);

	void ListarVacasXRodeoIdRPC(Long rodeoId,
			AsyncCallback<List<VacaDTO>> callback);

	void obtenerVacasByParam(String param, AsyncCallback<List<VacaDTO>> callback);

	void obtenerInseminadoresRPC(AsyncCallback<List<InseminadorDTO>> callback);

	void obtenerVacasEstablecimientoActualRPC(
			AsyncCallback<List<VacaDTO>> callback);

	void obtenerTiposServicioRPC(AsyncCallback<List<TipoServicioDTO>> callback);

	void obtenerCelosServiciosPorFechaRPC(Date fecha,
			AsyncCallback<List<CeloServicioDTO>> callback);

	void insertarCeloServicioRPC(CeloServicioDTO csDTO,
			AsyncCallback<CeloServicioDTO> callback);

	void eliminarCeloServicioPorIdRPC(Long id,
			AsyncCallback<CeloServicioDTO> callback);


}