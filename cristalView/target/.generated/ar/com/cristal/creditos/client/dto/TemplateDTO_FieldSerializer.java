package ar.com.cristal.creditos.client.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class TemplateDTO_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.TemplateDTO_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.dto.TemplateDTO)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.dto.TemplateDTO_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.TemplateDTO_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.dto.TemplateDTO)object);
    }
  }
  private static native java.lang.String getDescripcion(ar.com.cristal.creditos.client.dto.TemplateDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.TemplateDTO::descripcion;
  }-*/;
  
  private static native void  setDescripcion(ar.com.cristal.creditos.client.dto.TemplateDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.TemplateDTO::descripcion = value;
  }-*/;
  
  private static native java.lang.Long getId(ar.com.cristal.creditos.client.dto.TemplateDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.TemplateDTO::id;
  }-*/;
  
  private static native void  setId(ar.com.cristal.creditos.client.dto.TemplateDTO instance, java.lang.Long value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.TemplateDTO::id = value;
  }-*/;
  
  private static native java.lang.String getNombreSalida(ar.com.cristal.creditos.client.dto.TemplateDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.TemplateDTO::nombreSalida;
  }-*/;
  
  private static native void  setNombreSalida(ar.com.cristal.creditos.client.dto.TemplateDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.TemplateDTO::nombreSalida = value;
  }-*/;
  
  private static native java.lang.String getNombreTemplate(ar.com.cristal.creditos.client.dto.TemplateDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.TemplateDTO::nombreTemplate;
  }-*/;
  
  private static native void  setNombreTemplate(ar.com.cristal.creditos.client.dto.TemplateDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.TemplateDTO::nombreTemplate = value;
  }-*/;
  
  private static native boolean getPermiteMultipleEnvio(ar.com.cristal.creditos.client.dto.TemplateDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.TemplateDTO::permiteMultipleEnvio;
  }-*/;
  
  private static native void  setPermiteMultipleEnvio(ar.com.cristal.creditos.client.dto.TemplateDTO instance, boolean value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.TemplateDTO::permiteMultipleEnvio = value;
  }-*/;
  
  private static native java.util.Map getValores(ar.com.cristal.creditos.client.dto.TemplateDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.TemplateDTO::valores;
  }-*/;
  
  private static native void  setValores(ar.com.cristal.creditos.client.dto.TemplateDTO instance, java.util.Map value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.TemplateDTO::valores = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.dto.TemplateDTO.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.dto.TemplateDTO instance) throws SerializationException {
    setDescripcion(instance, streamReader.readString());
    setId(instance, (java.lang.Long) streamReader.readObject());
    setNombreSalida(instance, streamReader.readString());
    setNombreTemplate(instance, streamReader.readString());
    setPermiteMultipleEnvio(instance, streamReader.readBoolean());
    setValores(instance, (java.util.Map) streamReader.readObject());
    
    ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static ar.com.cristal.creditos.client.dto.TemplateDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.cristal.creditos.client.dto.TemplateDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.dto.TemplateDTO instance) throws SerializationException {
    streamWriter.writeString(getDescripcion(instance));
    streamWriter.writeObject(getId(instance));
    streamWriter.writeString(getNombreSalida(instance));
    streamWriter.writeString(getNombreTemplate(instance));
    streamWriter.writeBoolean(getPermiteMultipleEnvio(instance));
    streamWriter.writeObject(getValores(instance));
    
    ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
