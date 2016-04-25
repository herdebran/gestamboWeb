package ar.com.cristal.creditos.client.accesibilidad;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class PerfilesDto_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.accesibilidad.PerfilesDto_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.accesibilidad.PerfilesDto)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.accesibilidad.PerfilesDto_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.accesibilidad.PerfilesDto_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.accesibilidad.PerfilesDto)object);
    }
  }
  private static native java.lang.String getListaComponentes(ar.com.cristal.creditos.client.accesibilidad.PerfilesDto instance) /*-{
    return instance.@ar.com.cristal.creditos.client.accesibilidad.PerfilesDto::listaComponentes;
  }-*/;
  
  private static native void  setListaComponentes(ar.com.cristal.creditos.client.accesibilidad.PerfilesDto instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.accesibilidad.PerfilesDto::listaComponentes = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.accesibilidad.PerfilesDto.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.accesibilidad.PerfilesDto instance) throws SerializationException {
    instance.Descripcion = streamReader.readString();
    instance.checked = streamReader.readBoolean();
    instance.id = (java.lang.Long) streamReader.readObject();
    setListaComponentes(instance, streamReader.readString());
    instance.nombre = streamReader.readString();
    
  }
  
  public static ar.com.cristal.creditos.client.accesibilidad.PerfilesDto instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.cristal.creditos.client.accesibilidad.PerfilesDto();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.accesibilidad.PerfilesDto instance) throws SerializationException {
    streamWriter.writeString(instance.Descripcion);
    streamWriter.writeBoolean(instance.checked);
    streamWriter.writeObject(instance.id);
    streamWriter.writeString(getListaComponentes(instance));
    streamWriter.writeString(instance.nombre);
    
  }
  
}
