package ar.com.cristal.creditos.client.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class DTO_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.dto.DTO)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.dto.DTO)object);
    }
  }
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.dto.DTO.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.dto.DTO instance) throws SerializationException {
    
  }
  
  public static ar.com.cristal.creditos.client.dto.DTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.cristal.creditos.client.dto.DTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.dto.DTO instance) throws SerializationException {
    
  }
  
}
