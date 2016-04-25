package com.google.gwt.user.client.rpc.core.java.security;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class GeneralSecurityException_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.security.GeneralSecurityException_FieldSerializer.deserialize(reader, (java.security.GeneralSecurityException)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return com.google.gwt.user.client.rpc.core.java.security.GeneralSecurityException_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.security.GeneralSecurityException_FieldSerializer.serialize(writer, (java.security.GeneralSecurityException)object);
    }
  }
  public static Class<?> concreteType() {
    return java.security.GeneralSecurityException.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, java.security.GeneralSecurityException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static java.security.GeneralSecurityException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new java.security.GeneralSecurityException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, java.security.GeneralSecurityException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
