package com.google.gwt.user.client.rpc.core.java.util;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class Date_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.util.Date_CustomFieldSerializer.deserialize(reader, (java.util.Date)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return com.google.gwt.user.client.rpc.core.java.util.Date_CustomFieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.util.Date_CustomFieldSerializer.serialize(writer, (java.util.Date)object);
    }
  }
  public static Class<?> concreteType() {
    return java.util.Date.class;
  }
  
}
