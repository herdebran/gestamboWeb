package ar.com.snoop.gwt.commons.client.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class ValueName_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.snoop.gwt.commons.client.dto.ValueName_FieldSerializer.deserialize(reader, (ar.com.snoop.gwt.commons.client.dto.ValueName)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.snoop.gwt.commons.client.dto.ValueName_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.snoop.gwt.commons.client.dto.ValueName_FieldSerializer.serialize(writer, (ar.com.snoop.gwt.commons.client.dto.ValueName)object);
    }
  }
  private static native java.lang.String getName(ar.com.snoop.gwt.commons.client.dto.ValueName instance) /*-{
    return instance.@ar.com.snoop.gwt.commons.client.dto.ValueName::name;
  }-*/;
  
  private static native void  setName(ar.com.snoop.gwt.commons.client.dto.ValueName instance, java.lang.String value) /*-{
    instance.@ar.com.snoop.gwt.commons.client.dto.ValueName::name = value;
  }-*/;
  
  private static native java.lang.String getValue(ar.com.snoop.gwt.commons.client.dto.ValueName instance) /*-{
    return instance.@ar.com.snoop.gwt.commons.client.dto.ValueName::value;
  }-*/;
  
  private static native void  setValue(ar.com.snoop.gwt.commons.client.dto.ValueName instance, java.lang.String value) /*-{
    instance.@ar.com.snoop.gwt.commons.client.dto.ValueName::value = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return ar.com.snoop.gwt.commons.client.dto.ValueName.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.snoop.gwt.commons.client.dto.ValueName instance) throws SerializationException {
    setName(instance, streamReader.readString());
    setValue(instance, streamReader.readString());
    
  }
  
  public static ar.com.snoop.gwt.commons.client.dto.ValueName instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.snoop.gwt.commons.client.dto.ValueName();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.snoop.gwt.commons.client.dto.ValueName instance) throws SerializationException {
    streamWriter.writeString(getName(instance));
    streamWriter.writeString(getValue(instance));
    
  }
  
}
