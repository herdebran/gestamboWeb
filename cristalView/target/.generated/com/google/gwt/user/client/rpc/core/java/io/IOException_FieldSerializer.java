package com.google.gwt.user.client.rpc.core.java.io;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class IOException_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.io.IOException_FieldSerializer.deserialize(reader, (java.io.IOException)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return com.google.gwt.user.client.rpc.core.java.io.IOException_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.io.IOException_FieldSerializer.serialize(writer, (java.io.IOException)object);
    }
  }
  public static Class<?> concreteType() {
    return java.io.IOException.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, java.io.IOException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static java.io.IOException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new java.io.IOException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, java.io.IOException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
