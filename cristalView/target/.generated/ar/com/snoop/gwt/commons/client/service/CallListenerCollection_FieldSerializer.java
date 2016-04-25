package ar.com.snoop.gwt.commons.client.service;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class CallListenerCollection_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.snoop.gwt.commons.client.service.CallListenerCollection_FieldSerializer.deserialize(reader, (ar.com.snoop.gwt.commons.client.service.CallListenerCollection)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.snoop.gwt.commons.client.service.CallListenerCollection_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.snoop.gwt.commons.client.service.CallListenerCollection_FieldSerializer.serialize(writer, (ar.com.snoop.gwt.commons.client.service.CallListenerCollection)object);
    }
  }
  public static Class<?> concreteType() {
    return ar.com.snoop.gwt.commons.client.service.CallListenerCollection.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.snoop.gwt.commons.client.service.CallListenerCollection instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.util.Vector_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static ar.com.snoop.gwt.commons.client.service.CallListenerCollection instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.snoop.gwt.commons.client.service.CallListenerCollection();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.snoop.gwt.commons.client.service.CallListenerCollection instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.util.Vector_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
}
