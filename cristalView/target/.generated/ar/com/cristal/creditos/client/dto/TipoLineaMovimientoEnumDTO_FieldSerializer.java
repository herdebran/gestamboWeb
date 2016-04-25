package ar.com.cristal.creditos.client.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class TipoLineaMovimientoEnumDTO_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO)object);
    }
  }
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO[] values = ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
}
