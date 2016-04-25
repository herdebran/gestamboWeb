package ar.com.cristal.creditos.client.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class TipoExistenciaEnumDTO_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO)object);
    }
  }
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO[] values = ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
}
