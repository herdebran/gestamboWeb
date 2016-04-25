package com.google.gwt.user.client.rpc.core.java.lang;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class ClassCastException_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.lang.ClassCastException_FieldSerializer.deserialize(reader, (java.lang.ClassCastException)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return com.google.gwt.user.client.rpc.core.java.lang.ClassCastException_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.lang.ClassCastException_FieldSerializer.serialize(writer, (java.lang.ClassCastException)object);
    }
  }
  public static Class<?> concreteType() {
    return java.lang.ClassCastException.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, java.lang.ClassCastException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static java.lang.ClassCastException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new java.lang.ClassCastException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, java.lang.ClassCastException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
