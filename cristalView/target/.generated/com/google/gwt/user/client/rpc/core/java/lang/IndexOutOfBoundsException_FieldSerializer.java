package com.google.gwt.user.client.rpc.core.java.lang;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class IndexOutOfBoundsException_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.lang.IndexOutOfBoundsException_FieldSerializer.deserialize(reader, (java.lang.IndexOutOfBoundsException)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return com.google.gwt.user.client.rpc.core.java.lang.IndexOutOfBoundsException_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.lang.IndexOutOfBoundsException_FieldSerializer.serialize(writer, (java.lang.IndexOutOfBoundsException)object);
    }
  }
  public static Class<?> concreteType() {
    return java.lang.IndexOutOfBoundsException.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, java.lang.IndexOutOfBoundsException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static java.lang.IndexOutOfBoundsException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new java.lang.IndexOutOfBoundsException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, java.lang.IndexOutOfBoundsException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
