package ar.com.cristal.creditos.client.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class DatoAnexoDTO_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.DatoAnexoDTO_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.dto.DatoAnexoDTO)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.dto.DatoAnexoDTO_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.DatoAnexoDTO_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.dto.DatoAnexoDTO)object);
    }
  }
  private static native java.lang.String getDescripcion(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::descripcion;
  }-*/;
  
  private static native void  setDescripcion(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::descripcion = value;
  }-*/;
  
  private static native java.util.Date getFechaAltaModificacion(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::fechaAltaModificacion;
  }-*/;
  
  private static native void  setFechaAltaModificacion(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance, java.util.Date value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::fechaAltaModificacion = value;
  }-*/;
  
  private static native java.lang.String getFilename(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::filename;
  }-*/;
  
  private static native void  setFilename(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::filename = value;
  }-*/;
  
  private static native java.lang.Long getId(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::id;
  }-*/;
  
  private static native void  setId(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance, java.lang.Long value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::id = value;
  }-*/;
  
  private static native java.lang.Long getIdCliente(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::idCliente;
  }-*/;
  
  private static native void  setIdCliente(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance, java.lang.Long value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::idCliente = value;
  }-*/;
  
  private static native java.lang.String getMimeType(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::mimeType;
  }-*/;
  
  private static native void  setMimeType(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::mimeType = value;
  }-*/;
  
  private static native java.lang.String getNombreUsuario(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::nombreUsuario;
  }-*/;
  
  private static native void  setNombreUsuario(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::nombreUsuario = value;
  }-*/;
  
  private static native java.lang.String getRotulo(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::rotulo;
  }-*/;
  
  private static native void  setRotulo(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::rotulo = value;
  }-*/;
  
  private static native java.lang.Long getSolicitudCreditoId(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::solicitudCreditoId;
  }-*/;
  
  private static native void  setSolicitudCreditoId(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance, java.lang.Long value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::solicitudCreditoId = value;
  }-*/;
  
  private static native java.lang.String getTipoDoc(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::tipoDoc;
  }-*/;
  
  private static native void  setTipoDoc(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::tipoDoc = value;
  }-*/;
  
  private static native java.lang.Long getUsuarioId(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::usuarioId;
  }-*/;
  
  private static native void  setUsuarioId(ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance, java.lang.Long value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::usuarioId = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.dto.DatoAnexoDTO.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance) throws SerializationException {
    setDescripcion(instance, streamReader.readString());
    setFechaAltaModificacion(instance, (java.util.Date) streamReader.readObject());
    setFilename(instance, streamReader.readString());
    setId(instance, (java.lang.Long) streamReader.readObject());
    setIdCliente(instance, (java.lang.Long) streamReader.readObject());
    setMimeType(instance, streamReader.readString());
    setNombreUsuario(instance, streamReader.readString());
    setRotulo(instance, streamReader.readString());
    setSolicitudCreditoId(instance, (java.lang.Long) streamReader.readObject());
    setTipoDoc(instance, streamReader.readString());
    setUsuarioId(instance, (java.lang.Long) streamReader.readObject());
    
    ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static ar.com.cristal.creditos.client.dto.DatoAnexoDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.cristal.creditos.client.dto.DatoAnexoDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.dto.DatoAnexoDTO instance) throws SerializationException {
    streamWriter.writeString(getDescripcion(instance));
    streamWriter.writeObject(getFechaAltaModificacion(instance));
    streamWriter.writeString(getFilename(instance));
    streamWriter.writeObject(getId(instance));
    streamWriter.writeObject(getIdCliente(instance));
    streamWriter.writeString(getMimeType(instance));
    streamWriter.writeString(getNombreUsuario(instance));
    streamWriter.writeString(getRotulo(instance));
    streamWriter.writeObject(getSolicitudCreditoId(instance));
    streamWriter.writeString(getTipoDoc(instance));
    streamWriter.writeObject(getUsuarioId(instance));
    
    ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
