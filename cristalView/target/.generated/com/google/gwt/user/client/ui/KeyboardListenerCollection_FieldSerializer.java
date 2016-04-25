package com.google.gwt.user.client.ui;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class KeyboardListenerCollection_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      com.google.gwt.user.client.ui.KeyboardListenerCollection_FieldSerializer.deserialize(reader, (com.google.gwt.user.client.ui.KeyboardListenerCollection)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return com.google.gwt.user.client.ui.KeyboardListenerCollection_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      com.google.gwt.user.client.ui.KeyboardListenerCollection_FieldSerializer.serialize(writer, (com.google.gwt.user.client.ui.KeyboardListenerCollection)object);
    }
  }
  public static Class<?> concreteType() {
    return com.google.gwt.user.client.ui.KeyboardListenerCollection.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.user.client.ui.KeyboardListenerCollection instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.util.ArrayList_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.google.gwt.user.client.ui.KeyboardListenerCollection instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.google.gwt.user.client.ui.KeyboardListenerCollection();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.user.client.ui.KeyboardListenerCollection instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.util.ArrayList_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
}
