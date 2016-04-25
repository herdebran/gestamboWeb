package com.google.gwt.user.client.rpc.core.java.lang;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class UnsupportedOperationException_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.lang.UnsupportedOperationException_FieldSerializer.deserialize(reader, (java.lang.UnsupportedOperationException)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return com.google.gwt.user.client.rpc.core.java.lang.UnsupportedOperationException_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.lang.UnsupportedOperationException_FieldSerializer.serialize(writer, (java.lang.UnsupportedOperationException)object);
    }
  }
  public static Class<?> concreteType() {
    return java.lang.UnsupportedOperationException.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, java.lang.UnsupportedOperationException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static java.lang.UnsupportedOperationException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new java.lang.UnsupportedOperationException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, java.lang.UnsupportedOperationException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
