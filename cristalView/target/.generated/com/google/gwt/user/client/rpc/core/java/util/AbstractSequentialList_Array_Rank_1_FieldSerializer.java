package com.google.gwt.user.client.rpc.core.java.util;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class AbstractSequentialList_Array_Rank_1_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.util.AbstractSequentialList_Array_Rank_1_FieldSerializer.deserialize(reader, (java.util.AbstractSequentialList[])object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return com.google.gwt.user.client.rpc.core.java.util.AbstractSequentialList_Array_Rank_1_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.util.AbstractSequentialList_Array_Rank_1_FieldSerializer.serialize(writer, (java.util.AbstractSequentialList[])object);
    }
  }
  public static Class<?> concreteType() {
    return java.util.AbstractSequentialList[].class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, java.util.AbstractSequentialList[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static java.util.AbstractSequentialList[] instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int size = streamReader.readInt();
    return new java.util.AbstractSequentialList[size];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, java.util.AbstractSequentialList[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
}
