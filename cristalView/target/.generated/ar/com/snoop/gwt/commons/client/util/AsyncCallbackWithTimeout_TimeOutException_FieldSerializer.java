package ar.com.snoop.gwt.commons.client.util;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class AsyncCallbackWithTimeout_TimeOutException_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.snoop.gwt.commons.client.util.AsyncCallbackWithTimeout_TimeOutException_FieldSerializer.deserialize(reader, (ar.com.snoop.gwt.commons.client.util.AsyncCallbackWithTimeout.TimeOutException)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.snoop.gwt.commons.client.util.AsyncCallbackWithTimeout_TimeOutException_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.snoop.gwt.commons.client.util.AsyncCallbackWithTimeout_TimeOutException_FieldSerializer.serialize(writer, (ar.com.snoop.gwt.commons.client.util.AsyncCallbackWithTimeout.TimeOutException)object);
    }
  }
  public static Class<?> concreteType() {
    return ar.com.snoop.gwt.commons.client.util.AsyncCallbackWithTimeout.TimeOutException.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.snoop.gwt.commons.client.util.AsyncCallbackWithTimeout.TimeOutException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static ar.com.snoop.gwt.commons.client.util.AsyncCallbackWithTimeout.TimeOutException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.snoop.gwt.commons.client.util.AsyncCallbackWithTimeout.TimeOutException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.snoop.gwt.commons.client.util.AsyncCallbackWithTimeout.TimeOutException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
