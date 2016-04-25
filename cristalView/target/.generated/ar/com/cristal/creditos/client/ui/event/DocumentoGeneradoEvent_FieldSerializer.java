package ar.com.cristal.creditos.client.ui.event;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class DocumentoGeneradoEvent_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent)object);
    }
  }
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent instance) throws SerializationException {
    instance.message = streamReader.readString();
    
  }
  
  public static ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent instance) throws SerializationException {
    streamWriter.writeString(instance.message);
    
  }
  
}
