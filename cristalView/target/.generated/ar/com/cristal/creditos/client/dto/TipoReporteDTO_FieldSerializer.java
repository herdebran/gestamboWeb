package ar.com.cristal.creditos.client.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class TipoReporteDTO_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.TipoReporteDTO_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.dto.TipoReporteDTO)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.dto.TipoReporteDTO_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.TipoReporteDTO_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.dto.TipoReporteDTO)object);
    }
  }
  private static native java.lang.String getCodigoReporte(ar.com.cristal.creditos.client.dto.TipoReporteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.TipoReporteDTO::codigoReporte;
  }-*/;
  
  private static native void  setCodigoReporte(ar.com.cristal.creditos.client.dto.TipoReporteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.TipoReporteDTO::codigoReporte = value;
  }-*/;
  
  private static native java.lang.String getDescripcion(ar.com.cristal.creditos.client.dto.TipoReporteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.TipoReporteDTO::descripcion;
  }-*/;
  
  private static native void  setDescripcion(ar.com.cristal.creditos.client.dto.TipoReporteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.TipoReporteDTO::descripcion = value;
  }-*/;
  
  private static native java.lang.Long getId(ar.com.cristal.creditos.client.dto.TipoReporteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.TipoReporteDTO::id;
  }-*/;
  
  private static native void  setId(ar.com.cristal.creditos.client.dto.TipoReporteDTO instance, java.lang.Long value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.TipoReporteDTO::id = value;
  }-*/;
  
  private static native java.lang.String getNombre(ar.com.cristal.creditos.client.dto.TipoReporteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.TipoReporteDTO::nombre;
  }-*/;
  
  private static native void  setNombre(ar.com.cristal.creditos.client.dto.TipoReporteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.TipoReporteDTO::nombre = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.dto.TipoReporteDTO.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.dto.TipoReporteDTO instance) throws SerializationException {
    setCodigoReporte(instance, streamReader.readString());
    setDescripcion(instance, streamReader.readString());
    setId(instance, (java.lang.Long) streamReader.readObject());
    setNombre(instance, streamReader.readString());
    
    ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static ar.com.cristal.creditos.client.dto.TipoReporteDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.cristal.creditos.client.dto.TipoReporteDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.dto.TipoReporteDTO instance) throws SerializationException {
    streamWriter.writeString(getCodigoReporte(instance));
    streamWriter.writeString(getDescripcion(instance));
    streamWriter.writeObject(getId(instance));
    streamWriter.writeString(getNombre(instance));
    
    ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
