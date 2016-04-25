package ar.com.cristal.creditos.client.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class SucursalDTO_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.SucursalDTO_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.dto.SucursalDTO)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.dto.SucursalDTO_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.SucursalDTO_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.dto.SucursalDTO)object);
    }
  }
  private static native java.lang.Long getId(ar.com.cristal.creditos.client.dto.SucursalDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.SucursalDTO::id;
  }-*/;
  
  private static native void  setId(ar.com.cristal.creditos.client.dto.SucursalDTO instance, java.lang.Long value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.SucursalDTO::id = value;
  }-*/;
  
  private static native java.lang.String getNombre(ar.com.cristal.creditos.client.dto.SucursalDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.SucursalDTO::nombre;
  }-*/;
  
  private static native void  setNombre(ar.com.cristal.creditos.client.dto.SucursalDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.SucursalDTO::nombre = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.dto.SucursalDTO.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.dto.SucursalDTO instance) throws SerializationException {
    setId(instance, (java.lang.Long) streamReader.readObject());
    setNombre(instance, streamReader.readString());
    
  }
  
  public static ar.com.cristal.creditos.client.dto.SucursalDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.cristal.creditos.client.dto.SucursalDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.dto.SucursalDTO instance) throws SerializationException {
    streamWriter.writeObject(getId(instance));
    streamWriter.writeString(getNombre(instance));
    
  }
  
}
