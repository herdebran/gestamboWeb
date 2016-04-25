package de.novanic.eventservice.client.event.domain;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class DefaultDomain_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      de.novanic.eventservice.client.event.domain.DefaultDomain_FieldSerializer.deserialize(reader, (de.novanic.eventservice.client.event.domain.DefaultDomain)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return de.novanic.eventservice.client.event.domain.DefaultDomain_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      de.novanic.eventservice.client.event.domain.DefaultDomain_FieldSerializer.serialize(writer, (de.novanic.eventservice.client.event.domain.DefaultDomain)object);
    }
  }
  private static native java.lang.String getMyName(de.novanic.eventservice.client.event.domain.DefaultDomain instance) /*-{
    return instance.@de.novanic.eventservice.client.event.domain.DefaultDomain::myName;
  }-*/;
  
  private static native void  setMyName(de.novanic.eventservice.client.event.domain.DefaultDomain instance, java.lang.String value) /*-{
    instance.@de.novanic.eventservice.client.event.domain.DefaultDomain::myName = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return de.novanic.eventservice.client.event.domain.DefaultDomain.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, de.novanic.eventservice.client.event.domain.DefaultDomain instance) throws SerializationException {
    setMyName(instance, streamReader.readString());
    
  }
  
  public static de.novanic.eventservice.client.event.domain.DefaultDomain instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new de.novanic.eventservice.client.event.domain.DefaultDomain();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, de.novanic.eventservice.client.event.domain.DefaultDomain instance) throws SerializationException {
    streamWriter.writeString(getMyName(instance));
    
  }
  
}
