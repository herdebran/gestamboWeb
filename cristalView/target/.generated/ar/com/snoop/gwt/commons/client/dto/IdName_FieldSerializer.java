package ar.com.snoop.gwt.commons.client.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class IdName_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.snoop.gwt.commons.client.dto.IdName_FieldSerializer.deserialize(reader, (ar.com.snoop.gwt.commons.client.dto.IdName)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.snoop.gwt.commons.client.dto.IdName_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.snoop.gwt.commons.client.dto.IdName_FieldSerializer.serialize(writer, (ar.com.snoop.gwt.commons.client.dto.IdName)object);
    }
  }
  private static native java.lang.Long getId(ar.com.snoop.gwt.commons.client.dto.IdName instance) /*-{
    return instance.@ar.com.snoop.gwt.commons.client.dto.IdName::id;
  }-*/;
  
  private static native void  setId(ar.com.snoop.gwt.commons.client.dto.IdName instance, java.lang.Long value) /*-{
    instance.@ar.com.snoop.gwt.commons.client.dto.IdName::id = value;
  }-*/;
  
  private static native java.lang.String getName(ar.com.snoop.gwt.commons.client.dto.IdName instance) /*-{
    return instance.@ar.com.snoop.gwt.commons.client.dto.IdName::name;
  }-*/;
  
  private static native void  setName(ar.com.snoop.gwt.commons.client.dto.IdName instance, java.lang.String value) /*-{
    instance.@ar.com.snoop.gwt.commons.client.dto.IdName::name = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return ar.com.snoop.gwt.commons.client.dto.IdName.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.snoop.gwt.commons.client.dto.IdName instance) throws SerializationException {
    setId(instance, (java.lang.Long) streamReader.readObject());
    setName(instance, streamReader.readString());
    
  }
  
  public static ar.com.snoop.gwt.commons.client.dto.IdName instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.snoop.gwt.commons.client.dto.IdName();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.snoop.gwt.commons.client.dto.IdName instance) throws SerializationException {
    streamWriter.writeObject(getId(instance));
    streamWriter.writeString(getName(instance));
    
  }
  
}
