package ar.com.cristal.creditos.client.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class EmpresaDTO_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.EmpresaDTO_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.dto.EmpresaDTO)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.dto.EmpresaDTO_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.EmpresaDTO_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.dto.EmpresaDTO)object);
    }
  }
  private static native boolean getCobraCuotaSocial(ar.com.cristal.creditos.client.dto.EmpresaDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.EmpresaDTO::cobraCuotaSocial;
  }-*/;
  
  private static native void  setCobraCuotaSocial(ar.com.cristal.creditos.client.dto.EmpresaDTO instance, boolean value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.EmpresaDTO::cobraCuotaSocial = value;
  }-*/;
  
  private static native java.lang.String getCuil(ar.com.cristal.creditos.client.dto.EmpresaDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.EmpresaDTO::cuil;
  }-*/;
  
  private static native void  setCuil(ar.com.cristal.creditos.client.dto.EmpresaDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.EmpresaDTO::cuil = value;
  }-*/;
  
  private static native java.lang.String getDomicilio(ar.com.cristal.creditos.client.dto.EmpresaDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.EmpresaDTO::domicilio;
  }-*/;
  
  private static native void  setDomicilio(ar.com.cristal.creditos.client.dto.EmpresaDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.EmpresaDTO::domicilio = value;
  }-*/;
  
  private static native java.lang.String getId(ar.com.cristal.creditos.client.dto.EmpresaDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.EmpresaDTO::id;
  }-*/;
  
  private static native void  setId(ar.com.cristal.creditos.client.dto.EmpresaDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.EmpresaDTO::id = value;
  }-*/;
  
  private static native java.lang.String getNombre(ar.com.cristal.creditos.client.dto.EmpresaDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.EmpresaDTO::nombre;
  }-*/;
  
  private static native void  setNombre(ar.com.cristal.creditos.client.dto.EmpresaDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.EmpresaDTO::nombre = value;
  }-*/;
  
  private static native java.lang.Double getParticipacionDirecta(ar.com.cristal.creditos.client.dto.EmpresaDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.EmpresaDTO::participacionDirecta;
  }-*/;
  
  private static native void  setParticipacionDirecta(ar.com.cristal.creditos.client.dto.EmpresaDTO instance, java.lang.Double value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.EmpresaDTO::participacionDirecta = value;
  }-*/;
  
  private static native java.lang.Double getParticipacionIndirecta(ar.com.cristal.creditos.client.dto.EmpresaDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.EmpresaDTO::participacionIndirecta;
  }-*/;
  
  private static native void  setParticipacionIndirecta(ar.com.cristal.creditos.client.dto.EmpresaDTO instance, java.lang.Double value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.EmpresaDTO::participacionIndirecta = value;
  }-*/;
  
  private static native boolean getPermiteRapipago(ar.com.cristal.creditos.client.dto.EmpresaDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.EmpresaDTO::permiteRapipago;
  }-*/;
  
  private static native void  setPermiteRapipago(ar.com.cristal.creditos.client.dto.EmpresaDTO instance, boolean value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.EmpresaDTO::permiteRapipago = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.dto.EmpresaDTO.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.dto.EmpresaDTO instance) throws SerializationException {
    setCobraCuotaSocial(instance, streamReader.readBoolean());
    setCuil(instance, streamReader.readString());
    setDomicilio(instance, streamReader.readString());
    setId(instance, streamReader.readString());
    setNombre(instance, streamReader.readString());
    setParticipacionDirecta(instance, (java.lang.Double) streamReader.readObject());
    setParticipacionIndirecta(instance, (java.lang.Double) streamReader.readObject());
    setPermiteRapipago(instance, streamReader.readBoolean());
    
    ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static ar.com.cristal.creditos.client.dto.EmpresaDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.cristal.creditos.client.dto.EmpresaDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.dto.EmpresaDTO instance) throws SerializationException {
    streamWriter.writeBoolean(getCobraCuotaSocial(instance));
    streamWriter.writeString(getCuil(instance));
    streamWriter.writeString(getDomicilio(instance));
    streamWriter.writeString(getId(instance));
    streamWriter.writeString(getNombre(instance));
    streamWriter.writeObject(getParticipacionDirecta(instance));
    streamWriter.writeObject(getParticipacionIndirecta(instance));
    streamWriter.writeBoolean(getPermiteRapipago(instance));
    
    ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
