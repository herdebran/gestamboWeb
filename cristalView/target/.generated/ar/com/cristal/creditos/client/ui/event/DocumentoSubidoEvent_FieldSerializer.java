package ar.com.cristal.creditos.client.ui.event;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class DocumentoSubidoEvent_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent)object);
    }
  }
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent instance) throws SerializationException {
    instance.exito = streamReader.readBoolean();
    instance.message = streamReader.readString();
    
  }
  
  public static ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent instance) throws SerializationException {
    streamWriter.writeBoolean(instance.exito);
    streamWriter.writeString(instance.message);
    
  }
  
}
