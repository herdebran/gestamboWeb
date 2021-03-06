package com.google.gwt.user.client.rpc.core.java.util;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class LinkedHashSet_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.util.LinkedHashSet_FieldSerializer.deserialize(reader, (java.util.LinkedHashSet)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return com.google.gwt.user.client.rpc.core.java.util.LinkedHashSet_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.util.LinkedHashSet_FieldSerializer.serialize(writer, (java.util.LinkedHashSet)object);
    }
  }
  public static Class<?> concreteType() {
    return java.util.LinkedHashSet.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, java.util.LinkedHashSet instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.util.HashSet_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static java.util.LinkedHashSet instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new java.util.LinkedHashSet();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, java.util.LinkedHashSet instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.util.HashSet_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
}
