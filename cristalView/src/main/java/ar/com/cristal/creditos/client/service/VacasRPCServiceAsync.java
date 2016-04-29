package ar.com.cristal.creditos.client.service;

import ar.com.cristal.creditos.client.tambo.dto.RodeoDTO;
import ar.com.cristal.creditos.client.tambo.dto.VacaDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface VacasRPCServiceAsync {

	void obtenerVacaById(Long id, AsyncCallback<VacaDTO> callback);

	void guardarRodeoRPC(RodeoDTO rodeo, AsyncCallback<Void> callback);

	void eliminarRodeoRPC(RodeoDTO rodeo, AsyncCallback<Void> callback);

	void obtenerVacaDTOPorRP(String rp, AsyncCallback<VacaDTO> callback);

	void existeVacaRPC(String rp, AsyncCallback<Boolean> callback);


}