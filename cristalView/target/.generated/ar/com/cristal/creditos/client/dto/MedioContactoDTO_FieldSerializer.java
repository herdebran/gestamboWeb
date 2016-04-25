package ar.com.cristal.creditos.client.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class MedioContactoDTO_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.MedioContactoDTO_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.dto.MedioContactoDTO)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.dto.MedioContactoDTO_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.MedioContactoDTO_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.dto.MedioContactoDTO)object);
    }
  }
  private static native java.lang.String getDescripcion(ar.com.cristal.creditos.client.dto.MedioContactoDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.MedioContactoDTO::descripcion;
  }-*/;
  
  private static native void  setDescripcion(ar.com.cristal.creditos.client.dto.MedioContactoDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.MedioContactoDTO::descripcion = value;
  }-*/;
  
  private static native java.lang.Long getId(ar.com.cristal.creditos.client.dto.MedioContactoDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.MedioContactoDTO::id;
  }-*/;
  
  private static native void  setId(ar.com.cristal.creditos.client.dto.MedioContactoDTO instance, java.lang.Long value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.MedioContactoDTO::id = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.dto.MedioContactoDTO.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.dto.MedioContactoDTO instance) throws SerializationException {
    setDescripcion(instance, streamReader.readString());
    setId(instance, (java.lang.Long) streamReader.readObject());
    
    ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static ar.com.cristal.creditos.client.dto.MedioContactoDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.cristal.creditos.client.dto.MedioContactoDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.dto.MedioContactoDTO instance) throws SerializationException {
    streamWriter.writeString(getDescripcion(instance));
    streamWriter.writeObject(getId(instance));
    
    ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
