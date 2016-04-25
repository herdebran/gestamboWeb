package de.novanic.eventservice.client.event.filter;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class DefaultCompositeEventFilter_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter_FieldSerializer.deserialize(reader, (de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter_FieldSerializer.serialize(writer, (de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter)object);
    }
  }
  private static native java.util.List getMyEventFilters(de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter instance) /*-{
    return instance.@de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter::myEventFilters;
  }-*/;
  
  private static native void  setMyEventFilters(de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter instance, java.util.List value) /*-{
    instance.@de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter::myEventFilters = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter instance) throws SerializationException {
    setMyEventFilters(instance, (java.util.List) streamReader.readObject());
    
  }
  
  public static de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter instance) throws SerializationException {
    streamWriter.writeObject(getMyEventFilters(instance));
    
  }
  
}
