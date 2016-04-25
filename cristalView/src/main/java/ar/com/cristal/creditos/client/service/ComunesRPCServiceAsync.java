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

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface ComunesRPCServiceAsync {

	
	void obtenerListadoGenerico(String tipo, 
			AsyncCallback<List<ListBoxItem>> asyncCallback);


	void obtenerTablaByTipo(String tipo, AsyncCallback<List<TablaDTO>> callback);


	void obtenerEstadosCliente(AsyncCallback<List<String>> callback);


	void validarEMail(String email, AsyncCallback<Boolean> callback);
	
	void obtenerEmpresaPorId(Long id, AsyncCallback<EmpresaDTO> callback);

	void cambiarEstadoACreditosYSusCuotas(List<Long> idsCreditos,
			AsyncCallback<Void> callback);


//	void calculoReportesCreditosACobrar(Long idCredito,
//			AsyncCallback<Void> callback);


	void cambiarEstadoACreditosYCuotas(Long idCliente,
			AsyncCallback<Void> callback);


	void obtenerTiposReporte(AsyncCallback<List<TipoReporteDTO>> callback);


	void obtenerMediosContacto(
			AsyncCallback<List<MedioContactoDTO>> asyncCallback);

	void buscarLocalidad(LocalidadDTO localidadDTO,	AsyncCallback<List<LocalidadDTO>> callback);


	void guardarCrearLocalidad(LocalidadDTO localidadDTO,AsyncCallback<LocalidadDTO> callback);


	void obtenerDatosCombos(boolean banco, boolean comercializador,
			AsyncCallback<List<List<ListBoxItem>>> asyncCallback);


	void guardarCrearEmpresa(EmpresaDTO empresaDTO,	AsyncCallback<EmpresaDTO> callback);
	
	void buscarEmpresa(EmpresaDTO empresaDTO,	AsyncCallback<List<EmpresaDTO>> callback);

	void guardarCrearSucursal(SucursalDTO sucursalDTO,	AsyncCallback<SucursalDTO> callback);


	void buscarSucursal(SucursalDTO sucursalDTO,AsyncCallback<List<SucursalDTO>> callback);


	void obtenerEmpresas(AsyncCallback<List<EmpresaDTO>> asyncCallback);


	void ubicacionCartasSambaShare(AsyncCallback<String> callback);


	void isVerazActivo(AsyncCallback<Boolean> callback);


	void obtenerListadoSeguimientoManual(
			AsyncCallback<List<ListBoxItem>> asyncCallback);


	void obtenerFechaActual(AsyncCallback<Date> callback);


	}

	
	

