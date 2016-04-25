package com.google.gwt.user.client.rpc.core.java.util;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class NoSuchElementException_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.util.NoSuchElementException_FieldSerializer.deserialize(reader, (java.util.NoSuchElementException)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return com.google.gwt.user.client.rpc.core.java.util.NoSuchElementException_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.util.NoSuchElementException_FieldSerializer.serialize(writer, (java.util.NoSuchElementException)object);
    }
  }
  public static Class<?> concreteType() {
    return java.util.NoSuchElementException.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, java.util.NoSuchElementException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static java.util.NoSuchElementException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new java.util.NoSuchElementException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, java.util.NoSuchElementException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
