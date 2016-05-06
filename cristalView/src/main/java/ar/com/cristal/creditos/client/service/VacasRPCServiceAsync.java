package ar.com.cristal.creditos.client.service;

import java.util.List;

import ar.com.cristal.creditos.client.tambo.dto.CategoriaDTO;
import ar.com.cristal.creditos.client.tambo.dto.RazaDTO;
import ar.com.cristal.creditos.client.tambo.dto.ResultadoTactoDTO;
import ar.com.cristal.creditos.client.tambo.dto.RodeoDTO;
import ar.com.cristal.creditos.client.tambo.dto.VacaDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface VacasRPCServiceAsync {

	void obtenerVacaById(Long id, AsyncCallback<VacaDTO> callback);

	void guardarRodeoRPC(RodeoDTO rodeo, AsyncCallback<Void> callback);

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


}