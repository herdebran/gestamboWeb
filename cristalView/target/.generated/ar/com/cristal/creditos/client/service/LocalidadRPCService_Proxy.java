package ar.com.cristal.creditos.client.service;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class LocalidadRPCService_Proxy extends RemoteServiceProxy implements ar.com.cristal.creditos.client.service.LocalidadRPCServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "ar.com.cristal.creditos.client.service.LocalidadRPCService";
  private static final String SERIALIZATION_POLICY ="B01B45BCE1CFB53ECF676E9BB569DC63";
  private static final ar.com.cristal.creditos.client.service.LocalidadRPCService_TypeSerializer SERIALIZER = new ar.com.cristal.creditos.client.service.LocalidadRPCService_TypeSerializer();
  
  public LocalidadRPCService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "localidadService", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void obtenerLocalidad(java.lang.Long cliente_id, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("LocalidadRPCService_Proxy.obtenerLocalidad", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerLocalidad");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeObject(cliente_id);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("LocalidadRPCService_Proxy.obtenerLocalidad",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "LocalidadRPCService_Proxy.obtenerLocalidad", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void obtenerLocalidades(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("LocalidadRPCService_Proxy.obtenerLocalidades", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerLocalidades");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("LocalidadRPCService_Proxy.obtenerLocalidades",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "LocalidadRPCService_Proxy.obtenerLocalidades", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void obtenerProvincias(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("LocalidadRPCService_Proxy.obtenerProvincias", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerProvincias");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("LocalidadRPCService_Proxy.obtenerProvincias",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "LocalidadRPCService_Proxy.obtenerProvincias", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
}
