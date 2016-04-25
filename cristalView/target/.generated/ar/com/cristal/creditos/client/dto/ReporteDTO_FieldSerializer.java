package ar.com.cristal.creditos.client.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class ReporteDTO_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.ReporteDTO_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.dto.ReporteDTO)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.dto.ReporteDTO_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.ReporteDTO_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.dto.ReporteDTO)object);
    }
  }
  private static native java.lang.String getFormato(ar.com.cristal.creditos.client.dto.ReporteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ReporteDTO::formato;
  }-*/;
  
  private static native void  setFormato(ar.com.cristal.creditos.client.dto.ReporteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ReporteDTO::formato = value;
  }-*/;
  
  private static native java.lang.Long getId(ar.com.cristal.creditos.client.dto.ReporteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ReporteDTO::id;
  }-*/;
  
  private static native void  setId(ar.com.cristal.creditos.client.dto.ReporteDTO instance, java.lang.Long value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ReporteDTO::id = value;
  }-*/;
  
  private static native java.lang.String getNombre(ar.com.cristal.creditos.client.dto.ReporteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ReporteDTO::nombre;
  }-*/;
  
  private static native void  setNombre(ar.com.cristal.creditos.client.dto.ReporteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ReporteDTO::nombre = value;
  }-*/;
  
  private static native java.lang.String getRutaDestino(ar.com.cristal.creditos.client.dto.ReporteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ReporteDTO::rutaDestino;
  }-*/;
  
  private static native void  setRutaDestino(ar.com.cristal.creditos.client.dto.ReporteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ReporteDTO::rutaDestino = value;
  }-*/;
  
  private static native java.lang.String getRutaOrigenTemplate(ar.com.cristal.creditos.client.dto.ReporteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ReporteDTO::rutaOrigenTemplate;
  }-*/;
  
  private static native void  setRutaOrigenTemplate(ar.com.cristal.creditos.client.dto.ReporteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ReporteDTO::rutaOrigenTemplate = value;
  }-*/;
  
  private static native ar.com.cristal.creditos.client.dto.TipoReporteDTO getTipoReporte(ar.com.cristal.creditos.client.dto.ReporteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ReporteDTO::tipoReporte;
  }-*/;
  
  private static native void  setTipoReporte(ar.com.cristal.creditos.client.dto.ReporteDTO instance, ar.com.cristal.creditos.client.dto.TipoReporteDTO value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ReporteDTO::tipoReporte = value;
  }-*/;
  
  private static native java.lang.String getUrl(ar.com.cristal.creditos.client.dto.ReporteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ReporteDTO::url;
  }-*/;
  
  private static native void  setUrl(ar.com.cristal.creditos.client.dto.ReporteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ReporteDTO::url = value;
  }-*/;
  
  private static native java.util.HashMap getValues(ar.com.cristal.creditos.client.dto.ReporteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ReporteDTO::values;
  }-*/;
  
  private static native void  setValues(ar.com.cristal.creditos.client.dto.ReporteDTO instance, java.util.HashMap value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ReporteDTO::values = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.dto.ReporteDTO.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.dto.ReporteDTO instance) throws SerializationException {
    setFormato(instance, streamReader.readString());
    setId(instance, (java.lang.Long) streamReader.readObject());
    setNombre(instance, streamReader.readString());
    setRutaDestino(instance, streamReader.readString());
    setRutaOrigenTemplate(instance, streamReader.readString());
    setTipoReporte(instance, (ar.com.cristal.creditos.client.dto.TipoReporteDTO) streamReader.readObject());
    setUrl(instance, streamReader.readString());
    setValues(instance, (java.util.HashMap) streamReader.readObject());
    
    ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static ar.com.cristal.creditos.client.dto.ReporteDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.cristal.creditos.client.dto.ReporteDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.dto.ReporteDTO instance) throws SerializationException {
    streamWriter.writeString(getFormato(instance));
    streamWriter.writeObject(getId(instance));
    streamWriter.writeString(getNombre(instance));
    streamWriter.writeString(getRutaDestino(instance));
    streamWriter.writeString(getRutaOrigenTemplate(instance));
    streamWriter.writeObject(getTipoReporte(instance));
    streamWriter.writeString(getUrl(instance));
    streamWriter.writeObject(getValues(instance));
    
    ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
