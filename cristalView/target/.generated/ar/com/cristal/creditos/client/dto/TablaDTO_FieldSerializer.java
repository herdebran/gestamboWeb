package ar.com.cristal.creditos.client.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class TablaDTO_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.TablaDTO_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.dto.TablaDTO)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.dto.TablaDTO_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.TablaDTO_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.dto.TablaDTO)object);
    }
  }
  private static native java.lang.String getAux_1(ar.com.cristal.creditos.client.dto.TablaDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.TablaDTO::aux_1;
  }-*/;
  
  private static native void  setAux_1(ar.com.cristal.creditos.client.dto.TablaDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.TablaDTO::aux_1 = value;
  }-*/;
  
  private static native java.lang.String getCodigo(ar.com.cristal.creditos.client.dto.TablaDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.TablaDTO::codigo;
  }-*/;
  
  private static native void  setCodigo(ar.com.cristal.creditos.client.dto.TablaDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.TablaDTO::codigo = value;
  }-*/;
  
  private static native java.lang.String getDescripcion(ar.com.cristal.creditos.client.dto.TablaDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.TablaDTO::descripcion;
  }-*/;
  
  private static native void  setDescripcion(ar.com.cristal.creditos.client.dto.TablaDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.TablaDTO::descripcion = value;
  }-*/;
  
  private static native java.lang.Long getId(ar.com.cristal.creditos.client.dto.TablaDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.TablaDTO::id;
  }-*/;
  
  private static native void  setId(ar.com.cristal.creditos.client.dto.TablaDTO instance, java.lang.Long value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.TablaDTO::id = value;
  }-*/;
  
  private static native java.lang.String getNombre(ar.com.cristal.creditos.client.dto.TablaDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.TablaDTO::nombre;
  }-*/;
  
  private static native void  setNombre(ar.com.cristal.creditos.client.dto.TablaDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.TablaDTO::nombre = value;
  }-*/;
  
  private static native java.lang.String getTipo(ar.com.cristal.creditos.client.dto.TablaDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.TablaDTO::tipo;
  }-*/;
  
  private static native void  setTipo(ar.com.cristal.creditos.client.dto.TablaDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.TablaDTO::tipo = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.dto.TablaDTO.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.dto.TablaDTO instance) throws SerializationException {
    setAux_1(instance, streamReader.readString());
    setCodigo(instance, streamReader.readString());
    setDescripcion(instance, streamReader.readString());
    setId(instance, (java.lang.Long) streamReader.readObject());
    setNombre(instance, streamReader.readString());
    setTipo(instance, streamReader.readString());
    
  }
  
  public static ar.com.cristal.creditos.client.dto.TablaDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.cristal.creditos.client.dto.TablaDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.dto.TablaDTO instance) throws SerializationException {
    streamWriter.writeString(getAux_1(instance));
    streamWriter.writeString(getCodigo(instance));
    streamWriter.writeString(getDescripcion(instance));
    streamWriter.writeObject(getId(instance));
    streamWriter.writeString(getNombre(instance));
    streamWriter.writeString(getTipo(instance));
    
  }
  
}
