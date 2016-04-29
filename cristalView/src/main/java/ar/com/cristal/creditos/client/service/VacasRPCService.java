package ar.com.cristal.creditos.client.service;

import ar.com.cristal.creditos.client.tambo.dto.RodeoDTO;
import ar.com.cristal.creditos.client.tambo.dto.VacaDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("vacasService")
public interface VacasRPCService extends RemoteService {

	VacaDTO obtenerVacaById(Long id) throws Exception;

	void guardarRodeoRPC(RodeoDTO rodeo) throws Exception;

	void eliminarRodeoRPC(RodeoDTO rodeo) throws Exception;

	VacaDTO obtenerVacaDTOPorRP(String rp) throws Exception;

	boolean existeVacaRPC(String rp) throws Exception;

}
