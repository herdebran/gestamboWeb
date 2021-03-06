package com.google.gwt.user.client.rpc.core.java.util;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class Stack_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer.deserialize(reader, (java.util.Stack)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer.serialize(writer, (java.util.Stack)object);
    }
  }
  public static Class<?> concreteType() {
    return java.util.Stack.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, java.util.Stack instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.util.Vector_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static java.util.Stack instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new java.util.Stack();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, java.util.Stack instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.util.Vector_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
}
