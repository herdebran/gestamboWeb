package com.google.gwt.user.client.rpc.core.java.io;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class UnsupportedEncodingException_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.io.UnsupportedEncodingException_FieldSerializer.deserialize(reader, (java.io.UnsupportedEncodingException)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return com.google.gwt.user.client.rpc.core.java.io.UnsupportedEncodingException_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.io.UnsupportedEncodingException_FieldSerializer.serialize(writer, (java.io.UnsupportedEncodingException)object);
    }
  }
  public static Class<?> concreteType() {
    return java.io.UnsupportedEncodingException.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, java.io.UnsupportedEncodingException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.io.IOException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static java.io.UnsupportedEncodingException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new java.io.UnsupportedEncodingException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, java.io.UnsupportedEncodingException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.io.IOException_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
