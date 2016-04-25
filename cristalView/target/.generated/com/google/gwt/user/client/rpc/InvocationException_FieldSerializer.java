package com.google.gwt.user.client.rpc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class InvocationException_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.InvocationException_FieldSerializer.deserialize(reader, (com.google.gwt.user.client.rpc.InvocationException)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return null;
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.InvocationException_FieldSerializer.serialize(writer, (com.google.gwt.user.client.rpc.InvocationException)object);
    }
  }
  public static Class<?> concreteType() {
    return com.google.gwt.user.client.rpc.InvocationException.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.user.client.rpc.InvocationException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.user.client.rpc.InvocationException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
