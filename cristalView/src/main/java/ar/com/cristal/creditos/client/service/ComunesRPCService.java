package ar.com.cristal.creditos.client.service;

import java.util.Date;
import java.util.List;

import ar.com.cristal.creditos.client.dto.EmpresaDTO;
import ar.com.cristal.creditos.client.dto.MedioContactoDTO;
import ar.com.cristal.creditos.client.dto.SucursalDTO;
import ar.com.cristal.creditos.client.dto.TablaDTO;
import ar.com.cristal.creditos.client.dto.TipoReporteDTO;
import ar.com.cristal.creditos.client.localidad.LocalidadDTO;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("comunesService")
public interface ComunesRPCService extends RemoteService {
	
	/***
	 * Devuelve la lista de operadores call center.
	 * @return
	 * @throws Exception 
	 */
	List<ListBoxItem> obtenerListadoGenerico(String tipo) throws Exception;

	List<TablaDTO> obtenerTablaByTipo(String tipo) throws Exception;
	
	boolean validarEMail(String email) throws Exception;

	List<String> obtenerEstadosCliente();

	EmpresaDTO obtenerEmpresaPorId(Long id) throws Exception;
	
	List<EmpresaDTO> obtenerEmpresas() throws Exception;
	
	void cambiarEstadoACreditosYSusCuotas(List<Long> idsCreditos) throws Exception;
	
	void cambiarEstadoACreditosYCuotas(Long idCliente) throws Exception;

	List<MedioContactoDTO> obtenerMediosContacto();

	public List<TipoReporteDTO> obtenerTiposReporte()throws Exception;
	
	public List<LocalidadDTO> buscarLocalidad(LocalidadDTO localidadDTO )throws Exception;
	
	public LocalidadDTO guardarCrearLocalidad(LocalidadDTO localidadDTO )throws Exception;

	List<List<ListBoxItem>> obtenerDatosCombos(boolean banco,
			boolean comercializador) throws Exception;
	
	public EmpresaDTO guardarCrearEmpresa(EmpresaDTO empresaDTO )throws Exception;

	List<EmpresaDTO> buscarEmpresa(EmpresaDTO empresaDTO);
	
	
	public SucursalDTO guardarCrearSucursal(SucursalDTO sucursalDTO )throws Exception;
	
	public List<SucursalDTO> buscarSucursal(SucursalDTO sucursalDTO);
	
	
	String ubicacionCartasSambaShare() throws Exception;

	boolean isVerazActivo()throws Exception;

	List<ListBoxItem> obtenerListadoSeguimientoManual() throws Exception;

	Date obtenerFechaActual();
	
}
