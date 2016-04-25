package ar.com.cristal.creditos.client.accesibilidad;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class ComponenteDePantallaDto_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.accesibilidad.ComponenteDePantallaDto_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.accesibilidad.ComponenteDePantallaDto)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.accesibilidad.ComponenteDePantallaDto_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.accesibilidad.ComponenteDePantallaDto_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.accesibilidad.ComponenteDePantallaDto)object);
    }
  }
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.accesibilidad.ComponenteDePantallaDto.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.accesibilidad.ComponenteDePantallaDto instance) throws SerializationException {
    instance.checked = streamReader.readBoolean();
    instance.descripcion = streamReader.readString();
    instance.id = streamReader.readInt();
    instance.nombre = streamReader.readString();
    
  }
  
  public static ar.com.cristal.creditos.client.accesibilidad.ComponenteDePantallaDto instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.cristal.creditos.client.accesibilidad.ComponenteDePantallaDto();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.accesibilidad.ComponenteDePantallaDto instance) throws SerializationException {
    streamWriter.writeBoolean(instance.checked);
    streamWriter.writeString(instance.descripcion);
    streamWriter.writeInt(instance.id);
    streamWriter.writeString(instance.nombre);
    
  }
  
}
