package ar.com.cristal.creditos.client.service.event;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class DefaultRemoteEventService_Proxy extends RemoteServiceProxy implements ar.com.cristal.creditos.client.service.event.DefaultRemoteEventServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "ar.com.cristal.creditos.client.service.event.DefaultRemoteEventService";
  private static final String SERIALIZATION_POLICY ="E1A59005D02C34466A08DB0025C35FD4";
  private static final ar.com.cristal.creditos.client.service.event.DefaultRemoteEventService_TypeSerializer SERIALIZER = new ar.com.cristal.creditos.client.service.event.DefaultRemoteEventService_TypeSerializer();
  
  public DefaultRemoteEventService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "DefaultRemoteEventService", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void enviarMensaje(java.lang.String message, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("DefaultRemoteEventService_Proxy.enviarMensaje", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("enviarMensaje");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(message);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("DefaultRemoteEventService_Proxy.enviarMensaje",  "requestSerialized"));
      doInvoke(ResponseReader.VOID, "DefaultRemoteEventService_Proxy.enviarMensaje", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void enviarMensaje(java.lang.String dominio, de.novanic.eventservice.client.event.Event evento, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("DefaultRemoteEventService_Proxy.enviarMensaje", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("enviarMensaje");
      streamWriter.writeInt(2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("de.novanic.eventservice.client.event.Event");
      streamWriter.writeString(dominio);
      streamWriter.writeObject(evento);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("DefaultRemoteEventService_Proxy.enviarMensaje",  "requestSerialized"));
      doInvoke(ResponseReader.VOID, "DefaultRemoteEventService_Proxy.enviarMensaje", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void enviarMensaje(java.lang.String domain, java.lang.String message, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("DefaultRemoteEventService_Proxy.enviarMensaje", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("enviarMensaje");
      streamWriter.writeInt(2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(domain);
      streamWriter.writeString(message);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("DefaultRemoteEventService_Proxy.enviarMensaje",  "requestSerialized"));
      doInvoke(ResponseReader.VOID, "DefaultRemoteEventService_Proxy.enviarMensaje", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
}
