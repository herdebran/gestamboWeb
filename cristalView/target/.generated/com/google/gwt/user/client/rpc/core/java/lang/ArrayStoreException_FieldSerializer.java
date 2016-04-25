package com.google.gwt.user.client.rpc.core.java.lang;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class ArrayStoreException_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.lang.ArrayStoreException_FieldSerializer.deserialize(reader, (java.lang.ArrayStoreException)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return com.google.gwt.user.client.rpc.core.java.lang.ArrayStoreException_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.lang.ArrayStoreException_FieldSerializer.serialize(writer, (java.lang.ArrayStoreException)object);
    }
  }
  public static Class<?> concreteType() {
    return java.lang.ArrayStoreException.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, java.lang.ArrayStoreException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static java.lang.ArrayStoreException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new java.lang.ArrayStoreException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, java.lang.ArrayStoreException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
