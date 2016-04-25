package ar.com.cristal.creditos.client.localidad;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class LocalidadDTO_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.localidad.LocalidadDTO_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.localidad.LocalidadDTO)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.localidad.LocalidadDTO_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.localidad.LocalidadDTO_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.localidad.LocalidadDTO)object);
    }
  }
  private static native ar.com.cristal.creditos.client.dto.ClienteDTO getCliente(ar.com.cristal.creditos.client.localidad.LocalidadDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.localidad.LocalidadDTO::cliente;
  }-*/;
  
  private static native void  setCliente(ar.com.cristal.creditos.client.localidad.LocalidadDTO instance, ar.com.cristal.creditos.client.dto.ClienteDTO value) /*-{
    instance.@ar.com.cristal.creditos.client.localidad.LocalidadDTO::cliente = value;
  }-*/;
  
  private static native java.lang.Integer getCodigo(ar.com.cristal.creditos.client.localidad.LocalidadDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.localidad.LocalidadDTO::codigo;
  }-*/;
  
  private static native void  setCodigo(ar.com.cristal.creditos.client.localidad.LocalidadDTO instance, java.lang.Integer value) /*-{
    instance.@ar.com.cristal.creditos.client.localidad.LocalidadDTO::codigo = value;
  }-*/;
  
  private static native java.lang.Long getId(ar.com.cristal.creditos.client.localidad.LocalidadDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.localidad.LocalidadDTO::id;
  }-*/;
  
  private static native void  setId(ar.com.cristal.creditos.client.localidad.LocalidadDTO instance, java.lang.Long value) /*-{
    instance.@ar.com.cristal.creditos.client.localidad.LocalidadDTO::id = value;
  }-*/;
  
  private static native java.lang.String getNombre(ar.com.cristal.creditos.client.localidad.LocalidadDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.localidad.LocalidadDTO::nombre;
  }-*/;
  
  private static native void  setNombre(ar.com.cristal.creditos.client.localidad.LocalidadDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.localidad.LocalidadDTO::nombre = value;
  }-*/;
  
  private static native ar.com.cristal.creditos.client.localidad.ProvinciaDTO getProvincia(ar.com.cristal.creditos.client.localidad.LocalidadDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.localidad.LocalidadDTO::provincia;
  }-*/;
  
  private static native void  setProvincia(ar.com.cristal.creditos.client.localidad.LocalidadDTO instance, ar.com.cristal.creditos.client.localidad.ProvinciaDTO value) /*-{
    instance.@ar.com.cristal.creditos.client.localidad.LocalidadDTO::provincia = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.localidad.LocalidadDTO.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.localidad.LocalidadDTO instance) throws SerializationException {
    setCliente(instance, (ar.com.cristal.creditos.client.dto.ClienteDTO) streamReader.readObject());
    setCodigo(instance, (java.lang.Integer) streamReader.readObject());
    setId(instance, (java.lang.Long) streamReader.readObject());
    setNombre(instance, streamReader.readString());
    setProvincia(instance, (ar.com.cristal.creditos.client.localidad.ProvinciaDTO) streamReader.readObject());
    
    ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static ar.com.cristal.creditos.client.localidad.LocalidadDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.cristal.creditos.client.localidad.LocalidadDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.localidad.LocalidadDTO instance) throws SerializationException {
    streamWriter.writeObject(getCliente(instance));
    streamWriter.writeObject(getCodigo(instance));
    streamWriter.writeObject(getId(instance));
    streamWriter.writeString(getNombre(instance));
    streamWriter.writeObject(getProvincia(instance));
    
    ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
