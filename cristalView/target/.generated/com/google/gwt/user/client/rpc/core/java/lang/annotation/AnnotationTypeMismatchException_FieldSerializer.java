package com.google.gwt.user.client.rpc.core.java.lang.annotation;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class AnnotationTypeMismatchException_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.lang.annotation.AnnotationTypeMismatchException_FieldSerializer.deserialize(reader, (java.lang.annotation.AnnotationTypeMismatchException)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return com.google.gwt.user.client.rpc.core.java.lang.annotation.AnnotationTypeMismatchException_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      com.google.gwt.user.client.rpc.core.java.lang.annotation.AnnotationTypeMismatchException_FieldSerializer.serialize(writer, (java.lang.annotation.AnnotationTypeMismatchException)object);
    }
  }
  public static Class<?> concreteType() {
    return java.lang.annotation.AnnotationTypeMismatchException.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, java.lang.annotation.AnnotationTypeMismatchException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static java.lang.annotation.AnnotationTypeMismatchException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new java.lang.annotation.AnnotationTypeMismatchException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, java.lang.annotation.AnnotationTypeMismatchException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
