package de.novanic.eventservice.client.event.filter;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class CompositeEventFilter_Array_Rank_1_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      de.novanic.eventservice.client.event.filter.CompositeEventFilter_Array_Rank_1_FieldSerializer.deserialize(reader, (de.novanic.eventservice.client.event.filter.CompositeEventFilter[])object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return de.novanic.eventservice.client.event.filter.CompositeEventFilter_Array_Rank_1_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      de.novanic.eventservice.client.event.filter.CompositeEventFilter_Array_Rank_1_FieldSerializer.serialize(writer, (de.novanic.eventservice.client.event.filter.CompositeEventFilter[])object);
    }
  }
  public static Class<?> concreteType() {
    return de.novanic.eventservice.client.event.filter.CompositeEventFilter[].class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, de.novanic.eventservice.client.event.filter.CompositeEventFilter[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static de.novanic.eventservice.client.event.filter.CompositeEventFilter[] instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int size = streamReader.readInt();
    return new de.novanic.eventservice.client.event.filter.CompositeEventFilter[size];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, de.novanic.eventservice.client.event.filter.CompositeEventFilter[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
}
