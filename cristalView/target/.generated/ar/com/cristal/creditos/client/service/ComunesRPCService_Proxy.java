package ar.com.cristal.creditos.client.service;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class ComunesRPCService_Proxy extends RemoteServiceProxy implements ar.com.cristal.creditos.client.service.ComunesRPCServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "ar.com.cristal.creditos.client.service.ComunesRPCService";
  private static final String SERIALIZATION_POLICY ="32EB1E5CFD3B1FB3C82A6685697C48DB";
  private static final ar.com.cristal.creditos.client.service.ComunesRPCService_TypeSerializer SERIALIZER = new ar.com.cristal.creditos.client.service.ComunesRPCService_TypeSerializer();
  
  public ComunesRPCService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "comunesService", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void buscarEmpresa(ar.com.cristal.creditos.client.dto.EmpresaDTO empresaDTO, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.buscarEmpresa", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("buscarEmpresa");
      streamWriter.writeInt(1);
      streamWriter.writeString("ar.com.cristal.creditos.client.dto.EmpresaDTO/2860350642");
      streamWriter.writeObject(empresaDTO);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.buscarEmpresa",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ComunesRPCService_Proxy.buscarEmpresa", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void buscarLocalidad(ar.com.cristal.creditos.client.localidad.LocalidadDTO localidadDTO, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.buscarLocalidad", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("buscarLocalidad");
      streamWriter.writeInt(1);
      streamWriter.writeString("ar.com.cristal.creditos.client.localidad.LocalidadDTO/2789612882");
      streamWriter.writeObject(localidadDTO);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.buscarLocalidad",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ComunesRPCService_Proxy.buscarLocalidad", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void buscarSucursal(ar.com.cristal.creditos.client.dto.SucursalDTO sucursalDTO, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.buscarSucursal", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("buscarSucursal");
      streamWriter.writeInt(1);
      streamWriter.writeString("ar.com.cristal.creditos.client.dto.SucursalDTO/391370096");
      streamWriter.writeObject(sucursalDTO);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.buscarSucursal",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ComunesRPCService_Proxy.buscarSucursal", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void cambiarEstadoACreditosYCuotas(java.lang.Long idCliente, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.cambiarEstadoACreditosYCuotas", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("cambiarEstadoACreditosYCuotas");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeObject(idCliente);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.cambiarEstadoACreditosYCuotas",  "requestSerialized"));
      doInvoke(ResponseReader.VOID, "ComunesRPCService_Proxy.cambiarEstadoACreditosYCuotas", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void cambiarEstadoACreditosYSusCuotas(java.util.List idsCreditos, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.cambiarEstadoACreditosYSusCuotas", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("cambiarEstadoACreditosYSusCuotas");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.util.List");
      streamWriter.writeObject(idsCreditos);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.cambiarEstadoACreditosYSusCuotas",  "requestSerialized"));
      doInvoke(ResponseReader.VOID, "ComunesRPCService_Proxy.cambiarEstadoACreditosYSusCuotas", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void guardarCrearEmpresa(ar.com.cristal.creditos.client.dto.EmpresaDTO empresaDTO, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.guardarCrearEmpresa", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("guardarCrearEmpresa");
      streamWriter.writeInt(1);
      streamWriter.writeString("ar.com.cristal.creditos.client.dto.EmpresaDTO/2860350642");
      streamWriter.writeObject(empresaDTO);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.guardarCrearEmpresa",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ComunesRPCService_Proxy.guardarCrearEmpresa", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void guardarCrearLocalidad(ar.com.cristal.creditos.client.localidad.LocalidadDTO localidadDTO, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.guardarCrearLocalidad", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("guardarCrearLocalidad");
      streamWriter.writeInt(1);
      streamWriter.writeString("ar.com.cristal.creditos.client.localidad.LocalidadDTO/2789612882");
      streamWriter.writeObject(localidadDTO);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.guardarCrearLocalidad",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ComunesRPCService_Proxy.guardarCrearLocalidad", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void guardarCrearSucursal(ar.com.cristal.creditos.client.dto.SucursalDTO sucursalDTO, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.guardarCrearSucursal", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("guardarCrearSucursal");
      streamWriter.writeInt(1);
      streamWriter.writeString("ar.com.cristal.creditos.client.dto.SucursalDTO/391370096");
      streamWriter.writeObject(sucursalDTO);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.guardarCrearSucursal",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ComunesRPCService_Proxy.guardarCrearSucursal", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void isVerazActivo(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.isVerazActivo", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("isVerazActivo");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.isVerazActivo",  "requestSerialized"));
      doInvoke(ResponseReader.BOOLEAN, "ComunesRPCService_Proxy.isVerazActivo", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void obtenerDatosCombos(boolean banco, boolean comercializador, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.obtenerDatosCombos", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerDatosCombos");
      streamWriter.writeInt(2);
      streamWriter.writeString("Z");
      streamWriter.writeString("Z");
      streamWriter.writeBoolean(banco);
      streamWriter.writeBoolean(comercializador);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.obtenerDatosCombos",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ComunesRPCService_Proxy.obtenerDatosCombos", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void obtenerEmpresaPorId(java.lang.Long id, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.obtenerEmpresaPorId", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerEmpresaPorId");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeObject(id);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.obtenerEmpresaPorId",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ComunesRPCService_Proxy.obtenerEmpresaPorId", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void obtenerEmpresas(com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.obtenerEmpresas", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerEmpresas");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.obtenerEmpresas",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ComunesRPCService_Proxy.obtenerEmpresas", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void obtenerEstadosCliente(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.obtenerEstadosCliente", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerEstadosCliente");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.obtenerEstadosCliente",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ComunesRPCService_Proxy.obtenerEstadosCliente", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void obtenerFechaActual(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.obtenerFechaActual", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerFechaActual");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.obtenerFechaActual",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ComunesRPCService_Proxy.obtenerFechaActual", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void obtenerListadoGenerico(java.lang.String tipo, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.obtenerListadoGenerico", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerListadoGenerico");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(tipo);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.obtenerListadoGenerico",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ComunesRPCService_Proxy.obtenerListadoGenerico", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void obtenerListadoSeguimientoManual(com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.obtenerListadoSeguimientoManual", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerListadoSeguimientoManual");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.obtenerListadoSeguimientoManual",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ComunesRPCService_Proxy.obtenerListadoSeguimientoManual", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void obtenerMediosContacto(com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.obtenerMediosContacto", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerMediosContacto");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.obtenerMediosContacto",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ComunesRPCService_Proxy.obtenerMediosContacto", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void obtenerTablaByTipo(java.lang.String tipo, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.obtenerTablaByTipo", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerTablaByTipo");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(tipo);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.obtenerTablaByTipo",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ComunesRPCService_Proxy.obtenerTablaByTipo", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void obtenerTiposReporte(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.obtenerTiposReporte", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerTiposReporte");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.obtenerTiposReporte",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ComunesRPCService_Proxy.obtenerTiposReporte", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void ubicacionCartasSambaShare(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.ubicacionCartasSambaShare", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("ubicacionCartasSambaShare");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.ubicacionCartasSambaShare",  "requestSerialized"));
      doInvoke(ResponseReader.STRING, "ComunesRPCService_Proxy.ubicacionCartasSambaShare", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void validarEMail(java.lang.String email, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.validarEMail", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("validarEMail");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(email);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ComunesRPCService_Proxy.validarEMail",  "requestSerialized"));
      doInvoke(ResponseReader.BOOLEAN, "ComunesRPCService_Proxy.validarEMail", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
}
