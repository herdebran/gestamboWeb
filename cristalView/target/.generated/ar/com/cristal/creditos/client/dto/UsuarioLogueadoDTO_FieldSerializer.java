package ar.com.cristal.creditos.client.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class UsuarioLogueadoDTO_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO)object);
    }
  }
  private static native boolean getAdmin(ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO::admin;
  }-*/;
  
  private static native void  setAdmin(ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO instance, boolean value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO::admin = value;
  }-*/;
  
  private static native java.lang.String getApellido(ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO::apellido;
  }-*/;
  
  private static native void  setApellido(ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO::apellido = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getId(ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO::id;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void  setId(ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO instance, long value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO::id = value;
  }-*/;
  
  private static native java.lang.String getNombre(ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO::nombre;
  }-*/;
  
  private static native void  setNombre(ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO::nombre = value;
  }-*/;
  
  private static native java.lang.String getNombreUsuario(ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO::nombreUsuario;
  }-*/;
  
  private static native void  setNombreUsuario(ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO::nombreUsuario = value;
  }-*/;
  
  private static native ar.com.cristal.creditos.client.accesibilidad.PerfilesDto getPerfil(ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO::perfil;
  }-*/;
  
  private static native void  setPerfil(ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO instance, ar.com.cristal.creditos.client.accesibilidad.PerfilesDto value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO::perfil = value;
  }-*/;
  
  private static native java.lang.String getSessionId(ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO::sessionId;
  }-*/;
  
  private static native void  setSessionId(ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO::sessionId = value;
  }-*/;
  
  private static native boolean getSupervisor(ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO::supervisor;
  }-*/;
  
  private static native void  setSupervisor(ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO instance, boolean value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO::supervisor = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO instance) throws SerializationException {
    setAdmin(instance, streamReader.readBoolean());
    setApellido(instance, streamReader.readString());
    setId(instance, streamReader.readLong());
    setNombre(instance, streamReader.readString());
    setNombreUsuario(instance, streamReader.readString());
    setPerfil(instance, (ar.com.cristal.creditos.client.accesibilidad.PerfilesDto) streamReader.readObject());
    setSessionId(instance, streamReader.readString());
    setSupervisor(instance, streamReader.readBoolean());
    
  }
  
  public static ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO instance) throws SerializationException {
    streamWriter.writeBoolean(getAdmin(instance));
    streamWriter.writeString(getApellido(instance));
    streamWriter.writeLong(getId(instance));
    streamWriter.writeString(getNombre(instance));
    streamWriter.writeString(getNombreUsuario(instance));
    streamWriter.writeObject(getPerfil(instance));
    streamWriter.writeString(getSessionId(instance));
    streamWriter.writeBoolean(getSupervisor(instance));
    
  }
  
}
