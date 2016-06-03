package ar.com.cristal.creditos.client.service;

import java.util.List;

import ar.com.cristal.creditos.client.tambo.dto.CategoriaDTO;
import ar.com.cristal.creditos.client.tambo.dto.RazaDTO;
import ar.com.cristal.creditos.client.tambo.dto.ResultadoTactoDTO;
import ar.com.cristal.creditos.client.tambo.dto.RodeoDTO;
import ar.com.cristal.creditos.client.tambo.dto.ToroDTO;
import ar.com.cristal.creditos.client.tambo.dto.VacaDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("vacasService")
public interface VacasRPCService extends RemoteService {

	VacaDTO obtenerVacaById(Long id) throws Exception;

	RodeoDTO guardarRodeoRPC(RodeoDTO rodeo) throws Exception;

	void eliminarRodeoRPC(RodeoDTO rodeo) throws Exception;

	VacaDTO obtenerVacaDTOPorRP(String rp) throws Exception;

	boolean existeVacaRPC(String rp) throws Exception;

	VacaDTO guardarVacaRPC(VacaDTO vacaDTO) throws Exception;

	List<RazaDTO> obtenerRazasRPC();

	List<RodeoDTO> obtenerRodeosRPC() throws Exception;

	List<CategoriaDTO> obtenerCategoriasRPC(long idRaza) throws Exception;

	List<ResultadoTactoDTO> obtenerResultadosTactoRPC();

	ToroDTO persistirToroRPC(ToroDTO toroDTO) throws Exception;

	List<ToroDTO> obtenerTorosRPC() throws Exception;

	List<ToroDTO> buscarToroPorNombre(String nombre) throws Exception;

	List<RodeoDTO> buscarRodeoPorNombre(String nombre) throws Exception;

	List<VacaDTO> ListarVacasXRodeoIdRPC(Long rodeoId) throws Exception;

}
