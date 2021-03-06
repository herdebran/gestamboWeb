package de.novanic.eventservice.client.event;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class DefaultDomainEvent_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      de.novanic.eventservice.client.event.DefaultDomainEvent_FieldSerializer.deserialize(reader, (de.novanic.eventservice.client.event.DefaultDomainEvent)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return de.novanic.eventservice.client.event.DefaultDomainEvent_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      de.novanic.eventservice.client.event.DefaultDomainEvent_FieldSerializer.serialize(writer, (de.novanic.eventservice.client.event.DefaultDomainEvent)object);
    }
  }
  private static native de.novanic.eventservice.client.event.domain.Domain getMyDomain(de.novanic.eventservice.client.event.DefaultDomainEvent instance) /*-{
    return instance.@de.novanic.eventservice.client.event.DefaultDomainEvent::myDomain;
  }-*/;
  
  private static native void  setMyDomain(de.novanic.eventservice.client.event.DefaultDomainEvent instance, de.novanic.eventservice.client.event.domain.Domain value) /*-{
    instance.@de.novanic.eventservice.client.event.DefaultDomainEvent::myDomain = value;
  }-*/;
  
  private static native de.novanic.eventservice.client.event.Event getMyEvent(de.novanic.eventservice.client.event.DefaultDomainEvent instance) /*-{
    return instance.@de.novanic.eventservice.client.event.DefaultDomainEvent::myEvent;
  }-*/;
  
  private static native void  setMyEvent(de.novanic.eventservice.client.event.DefaultDomainEvent instance, de.novanic.eventservice.client.event.Event value) /*-{
    instance.@de.novanic.eventservice.client.event.DefaultDomainEvent::myEvent = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return de.novanic.eventservice.client.event.DefaultDomainEvent.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, de.novanic.eventservice.client.event.DefaultDomainEvent instance) throws SerializationException {
    setMyDomain(instance, (de.novanic.eventservice.client.event.domain.Domain) streamReader.readObject());
    setMyEvent(instance, (de.novanic.eventservice.client.event.Event) streamReader.readObject());
    
  }
  
  public static de.novanic.eventservice.client.event.DefaultDomainEvent instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new de.novanic.eventservice.client.event.DefaultDomainEvent();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, de.novanic.eventservice.client.event.DefaultDomainEvent instance) throws SerializationException {
    streamWriter.writeObject(getMyDomain(instance));
    streamWriter.writeObject(getMyEvent(instance));
    
  }
  
}
