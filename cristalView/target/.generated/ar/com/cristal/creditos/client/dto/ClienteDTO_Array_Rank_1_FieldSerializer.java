package ar.com.cristal.creditos.client.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class ClienteDTO_Array_Rank_1_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.ClienteDTO_Array_Rank_1_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.dto.ClienteDTO[])object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.dto.ClienteDTO_Array_Rank_1_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.ClienteDTO_Array_Rank_1_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.dto.ClienteDTO[])object);
    }
  }
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.dto.ClienteDTO[].class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.dto.ClienteDTO[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static ar.com.cristal.creditos.client.dto.ClienteDTO[] instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int size = streamReader.readInt();
    return new ar.com.cristal.creditos.client.dto.ClienteDTO[size];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.dto.ClienteDTO[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
}
