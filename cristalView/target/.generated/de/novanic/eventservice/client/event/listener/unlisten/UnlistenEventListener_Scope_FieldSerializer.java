package de.novanic.eventservice.client.event.listener.unlisten;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class UnlistenEventListener_Scope_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      de.novanic.eventservice.client.event.listener.unlisten.UnlistenEventListener_Scope_FieldSerializer.deserialize(reader, (de.novanic.eventservice.client.event.listener.unlisten.UnlistenEventListener.Scope)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return de.novanic.eventservice.client.event.listener.unlisten.UnlistenEventListener_Scope_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      de.novanic.eventservice.client.event.listener.unlisten.UnlistenEventListener_Scope_FieldSerializer.serialize(writer, (de.novanic.eventservice.client.event.listener.unlisten.UnlistenEventListener.Scope)object);
    }
  }
  public static Class<?> concreteType() {
    return de.novanic.eventservice.client.event.listener.unlisten.UnlistenEventListener.Scope.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, de.novanic.eventservice.client.event.listener.unlisten.UnlistenEventListener.Scope instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static de.novanic.eventservice.client.event.listener.unlisten.UnlistenEventListener.Scope instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    de.novanic.eventservice.client.event.listener.unlisten.UnlistenEventListener.Scope[] values = de.novanic.eventservice.client.event.listener.unlisten.UnlistenEventListener.Scope.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, de.novanic.eventservice.client.event.listener.unlisten.UnlistenEventListener.Scope instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
}
