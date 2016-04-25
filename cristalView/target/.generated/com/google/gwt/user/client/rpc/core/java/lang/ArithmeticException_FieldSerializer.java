package com.google.gwt.user.client.rpc.core.java.lang;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class ArithmeticException_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.lang.ArithmeticException_FieldSerializer.deserialize(reader, (java.lang.ArithmeticException)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return com.google.gwt.user.client.rpc.core.java.lang.ArithmeticException_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.lang.ArithmeticException_FieldSerializer.serialize(writer, (java.lang.ArithmeticException)object);
    }
  }
  public static Class<?> concreteType() {
    return java.lang.ArithmeticException.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, java.lang.ArithmeticException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static java.lang.ArithmeticException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new java.lang.ArithmeticException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, java.lang.ArithmeticException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
