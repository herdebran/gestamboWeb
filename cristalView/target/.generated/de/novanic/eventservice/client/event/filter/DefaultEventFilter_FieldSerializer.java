package de.novanic.eventservice.client.event.filter;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class DefaultEventFilter_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      de.novanic.eventservice.client.event.filter.DefaultEventFilter_FieldSerializer.deserialize(reader, (de.novanic.eventservice.client.event.filter.DefaultEventFilter)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return de.novanic.eventservice.client.event.filter.DefaultEventFilter_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      de.novanic.eventservice.client.event.filter.DefaultEventFilter_FieldSerializer.serialize(writer, (de.novanic.eventservice.client.event.filter.DefaultEventFilter)object);
    }
  }
  private static native de.novanic.eventservice.client.event.filter.EventFilter getMyNextEventFilter(de.novanic.eventservice.client.event.filter.DefaultEventFilter instance) /*-{
    return instance.@de.novanic.eventservice.client.event.filter.DefaultEventFilter::myNextEventFilter;
  }-*/;
  
  private static native void  setMyNextEventFilter(de.novanic.eventservice.client.event.filter.DefaultEventFilter instance, de.novanic.eventservice.client.event.filter.EventFilter value) /*-{
    instance.@de.novanic.eventservice.client.event.filter.DefaultEventFilter::myNextEventFilter = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return de.novanic.eventservice.client.event.filter.DefaultEventFilter.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, de.novanic.eventservice.client.event.filter.DefaultEventFilter instance) throws SerializationException {
    setMyNextEventFilter(instance, (de.novanic.eventservice.client.event.filter.EventFilter) streamReader.readObject());
    
  }
  
  public static de.novanic.eventservice.client.event.filter.DefaultEventFilter instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new de.novanic.eventservice.client.event.filter.DefaultEventFilter();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, de.novanic.eventservice.client.event.filter.DefaultEventFilter instance) throws SerializationException {
    streamWriter.writeObject(getMyNextEventFilter(instance));
    
  }
  
}
