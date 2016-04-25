package ar.com.cristal.creditos.client.service;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class ClientesRPCService_Proxy extends RemoteServiceProxy implements ar.com.cristal.creditos.client.service.ClientesRPCServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "ar.com.cristal.creditos.client.service.ClientesRPCService";
  private static final String SERIALIZATION_POLICY ="E7E9999A4FC3A65433B0CFADA6FB5033";
  private static final ar.com.cristal.creditos.client.service.ClientesRPCService_TypeSerializer SERIALIZER = new ar.com.cristal.creditos.client.service.ClientesRPCService_TypeSerializer();
  
  public ClientesRPCService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "clientesService", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void crearCliente(ar.com.cristal.creditos.client.dto.ClienteDTO cliente, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.crearCliente", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("crearCliente");
      streamWriter.writeInt(1);
      streamWriter.writeString("ar.com.cristal.creditos.client.dto.ClienteDTO/2095328581");
      streamWriter.writeObject(cliente);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.crearCliente",  "requestSerialized"));
      doInvoke(ResponseReader.VOID, "ClientesRPCService_Proxy.crearCliente", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void eliminarCliente(ar.com.cristal.creditos.client.dto.ClienteDTO cliente, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.eliminarCliente", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("eliminarCliente");
      streamWriter.writeInt(1);
      streamWriter.writeString("ar.com.cristal.creditos.client.dto.ClienteDTO/2095328581");
      streamWriter.writeObject(cliente);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.eliminarCliente",  "requestSerialized"));
      doInvoke(ResponseReader.VOID, "ClientesRPCService_Proxy.eliminarCliente", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void existeCliente(ar.com.cristal.creditos.client.dto.ClienteDTO clienteActual, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.existeCliente", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("existeCliente");
      streamWriter.writeInt(1);
      streamWriter.writeString("ar.com.cristal.creditos.client.dto.ClienteDTO/2095328581");
      streamWriter.writeObject(clienteActual);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.existeCliente",  "requestSerialized"));
      doInvoke(ResponseReader.BOOLEAN, "ClientesRPCService_Proxy.existeCliente", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void modificar(ar.com.cristal.creditos.client.dto.ClienteDTO clienteActual, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.modificar", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("modificar");
      streamWriter.writeInt(1);
      streamWriter.writeString("ar.com.cristal.creditos.client.dto.ClienteDTO/2095328581");
      streamWriter.writeObject(clienteActual);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.modificar",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ClientesRPCService_Proxy.modificar", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void obtenerClienteById(java.lang.Long id, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.obtenerClienteById", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerClienteById");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeObject(id);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.obtenerClienteById",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ClientesRPCService_Proxy.obtenerClienteById", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void obtenerClientes(boolean activo, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.obtenerClientes", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerClientes");
      streamWriter.writeInt(1);
      streamWriter.writeString("Z");
      streamWriter.writeBoolean(activo);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.obtenerClientes",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ClientesRPCService_Proxy.obtenerClientes", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void obtenerClientesByDNICuil(java.lang.String dni, java.lang.String cuil, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.obtenerClientesByDNICuil", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerClientesByDNICuil");
      streamWriter.writeInt(2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(dni);
      streamWriter.writeString(cuil);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.obtenerClientesByDNICuil",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ClientesRPCService_Proxy.obtenerClientesByDNICuil", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void obtenerClientesByParam(java.lang.String param, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.obtenerClientesByParam", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerClientesByParam");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(param);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.obtenerClientesByParam",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ClientesRPCService_Proxy.obtenerClientesByParam", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void obtenerCondicionMorosidad(java.lang.Long id, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.obtenerCondicionMorosidad", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerCondicionMorosidad");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeObject(id);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.obtenerCondicionMorosidad",  "requestSerialized"));
      doInvoke(ResponseReader.STRING, "ClientesRPCService_Proxy.obtenerCondicionMorosidad", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void obtenerCreditosPorFinalizar(java.lang.Long idCliente, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.obtenerCreditosPorFinalizar", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerCreditosPorFinalizar");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeObject(idCliente);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.obtenerCreditosPorFinalizar",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ClientesRPCService_Proxy.obtenerCreditosPorFinalizar", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void obtenerTiposDocs(com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.obtenerTiposDocs", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerTiposDocs");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.obtenerTiposDocs",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ClientesRPCService_Proxy.obtenerTiposDocs", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void persistir(ar.com.cristal.creditos.client.dto.ClienteDTO clienteActual, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.persistir", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("persistir");
      streamWriter.writeInt(1);
      streamWriter.writeString("ar.com.cristal.creditos.client.dto.ClienteDTO/2095328581");
      streamWriter.writeObject(clienteActual);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.persistir",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ClientesRPCService_Proxy.persistir", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void poseeMasDeUnCreditoActivo(java.lang.Long idCliente, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.poseeMasDeUnCreditoActivo", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("poseeMasDeUnCreditoActivo");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeObject(idCliente);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ClientesRPCService_Proxy.poseeMasDeUnCreditoActivo",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ClientesRPCService_Proxy.poseeMasDeUnCreditoActivo", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
}
