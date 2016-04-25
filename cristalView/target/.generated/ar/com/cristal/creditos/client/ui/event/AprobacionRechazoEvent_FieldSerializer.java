package ar.com.cristal.creditos.client.ui.event;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class AprobacionRechazoEvent_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent)object);
    }
  }
  private static native java.lang.Long getIdSolicitud(ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent instance) /*-{
    return instance.@ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent::idSolicitud;
  }-*/;
  
  private static native void  setIdSolicitud(ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent instance, java.lang.Long value) /*-{
    instance.@ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent::idSolicitud = value;
  }-*/;
  
  private static native java.lang.String getSucursalSolicitante(ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent instance) /*-{
    return instance.@ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent::sucursalSolicitante;
  }-*/;
  
  private static native void  setSucursalSolicitante(ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent::sucursalSolicitante = value;
  }-*/;
  
  private static native java.lang.String getTipoSolicitudPreguntaRespuesta(ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent instance) /*-{
    return instance.@ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent::tipoSolicitudPreguntaRespuesta;
  }-*/;
  
  private static native void  setTipoSolicitudPreguntaRespuesta(ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent::tipoSolicitudPreguntaRespuesta = value;
  }-*/;
  
  private static native java.lang.String getUsuarioRespuesta(ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent instance) /*-{
    return instance.@ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent::usuarioRespuesta;
  }-*/;
  
  private static native void  setUsuarioRespuesta(ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent::usuarioRespuesta = value;
  }-*/;
  
  private static native java.lang.String getUsuarioSolicitante(ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent instance) /*-{
    return instance.@ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent::usuarioSolicitante;
  }-*/;
  
  private static native void  setUsuarioSolicitante(ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent::usuarioSolicitante = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent instance) throws SerializationException {
    setIdSolicitud(instance, (java.lang.Long) streamReader.readObject());
    instance.message = streamReader.readString();
    setSucursalSolicitante(instance, streamReader.readString());
    setTipoSolicitudPreguntaRespuesta(instance, streamReader.readString());
    setUsuarioRespuesta(instance, streamReader.readString());
    setUsuarioSolicitante(instance, streamReader.readString());
    
  }
  
  public static ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent instance) throws SerializationException {
    streamWriter.writeObject(getIdSolicitud(instance));
    streamWriter.writeString(instance.message);
    streamWriter.writeString(getSucursalSolicitante(instance));
    streamWriter.writeString(getTipoSolicitudPreguntaRespuesta(instance));
    streamWriter.writeString(getUsuarioRespuesta(instance));
    streamWriter.writeString(getUsuarioSolicitante(instance));
    
  }
  
}
