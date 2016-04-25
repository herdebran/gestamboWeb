package ar.com.snoop.gwt.commons.client.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class IdName_Array_Rank_1_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.snoop.gwt.commons.client.dto.IdName_Array_Rank_1_FieldSerializer.deserialize(reader, (ar.com.snoop.gwt.commons.client.dto.IdName[])object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.snoop.gwt.commons.client.dto.IdName_Array_Rank_1_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.snoop.gwt.commons.client.dto.IdName_Array_Rank_1_FieldSerializer.serialize(writer, (ar.com.snoop.gwt.commons.client.dto.IdName[])object);
    }
  }
  public static Class<?> concreteType() {
    return ar.com.snoop.gwt.commons.client.dto.IdName[].class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.snoop.gwt.commons.client.dto.IdName[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static ar.com.snoop.gwt.commons.client.dto.IdName[] instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int size = streamReader.readInt();
    return new ar.com.snoop.gwt.commons.client.dto.IdName[size];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.snoop.gwt.commons.client.dto.IdName[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
}
