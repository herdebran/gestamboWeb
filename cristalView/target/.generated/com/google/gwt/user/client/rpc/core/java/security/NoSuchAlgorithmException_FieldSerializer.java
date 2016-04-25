package com.google.gwt.user.client.rpc.core.java.security;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class NoSuchAlgorithmException_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.security.NoSuchAlgorithmException_FieldSerializer.deserialize(reader, (java.security.NoSuchAlgorithmException)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return com.google.gwt.user.client.rpc.core.java.security.NoSuchAlgorithmException_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.security.NoSuchAlgorithmException_FieldSerializer.serialize(writer, (java.security.NoSuchAlgorithmException)object);
    }
  }
  public static Class<?> concreteType() {
    return java.security.NoSuchAlgorithmException.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, java.security.NoSuchAlgorithmException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.security.GeneralSecurityException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static java.security.NoSuchAlgorithmException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new java.security.NoSuchAlgorithmException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, java.security.NoSuchAlgorithmException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.security.GeneralSecurityException_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
