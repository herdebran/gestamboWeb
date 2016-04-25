package ar.com.cristal.creditos.client.localidad;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class ProvinciaDTO_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.localidad.ProvinciaDTO_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.localidad.ProvinciaDTO)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.localidad.ProvinciaDTO_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.localidad.ProvinciaDTO_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.localidad.ProvinciaDTO)object);
    }
  }
  private static native java.lang.Long getId(ar.com.cristal.creditos.client.localidad.ProvinciaDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.localidad.ProvinciaDTO::id;
  }-*/;
  
  private static native void  setId(ar.com.cristal.creditos.client.localidad.ProvinciaDTO instance, java.lang.Long value) /*-{
    instance.@ar.com.cristal.creditos.client.localidad.ProvinciaDTO::id = value;
  }-*/;
  
  private static native java.lang.String getNombre(ar.com.cristal.creditos.client.localidad.ProvinciaDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.localidad.ProvinciaDTO::nombre;
  }-*/;
  
  private static native void  setNombre(ar.com.cristal.creditos.client.localidad.ProvinciaDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.localidad.ProvinciaDTO::nombre = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.localidad.ProvinciaDTO.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.localidad.ProvinciaDTO instance) throws SerializationException {
    setId(instance, (java.lang.Long) streamReader.readObject());
    setNombre(instance, streamReader.readString());
    
    ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static ar.com.cristal.creditos.client.localidad.ProvinciaDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.cristal.creditos.client.localidad.ProvinciaDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.localidad.ProvinciaDTO instance) throws SerializationException {
    streamWriter.writeObject(getId(instance));
    streamWriter.writeString(getNombre(instance));
    
    ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
