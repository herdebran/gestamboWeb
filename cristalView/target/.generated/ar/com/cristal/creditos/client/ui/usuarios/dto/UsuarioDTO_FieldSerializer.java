package ar.com.cristal.creditos.client.ui.usuarios.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class UsuarioDTO_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO)object);
    }
  }
  private static native boolean getAdmin(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO::admin;
  }-*/;
  
  private static native void  setAdmin(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO instance, boolean value) /*-{
    instance.@ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO::admin = value;
  }-*/;
  
  private static native java.lang.String getApellido(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO::apellido;
  }-*/;
  
  private static native void  setApellido(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO::apellido = value;
  }-*/;
  
  private static native java.lang.Long getId(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO::id;
  }-*/;
  
  private static native void  setId(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO instance, java.lang.Long value) /*-{
    instance.@ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO::id = value;
  }-*/;
  
  private static native java.lang.String getNombre(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO::nombre;
  }-*/;
  
  private static native void  setNombre(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO::nombre = value;
  }-*/;
  
  private static native java.lang.String getNombreUsuario(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO::nombreUsuario;
  }-*/;
  
  private static native void  setNombreUsuario(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO::nombreUsuario = value;
  }-*/;
  
  private static native java.lang.String getPassword(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO::password;
  }-*/;
  
  private static native void  setPassword(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO::password = value;
  }-*/;
  
  private static native ar.com.cristal.creditos.client.accesibilidad.PerfilesDto getPerfil(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO::perfil;
  }-*/;
  
  private static native void  setPerfil(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO instance, ar.com.cristal.creditos.client.accesibilidad.PerfilesDto value) /*-{
    instance.@ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO::perfil = value;
  }-*/;
  
  private static native java.lang.String getSessionId(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO::sessionId;
  }-*/;
  
  private static native void  setSessionId(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO::sessionId = value;
  }-*/;
  
  private static native boolean getSupervisor(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO::supervisor;
  }-*/;
  
  private static native void  setSupervisor(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO instance, boolean value) /*-{
    instance.@ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO::supervisor = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO instance) throws SerializationException {
    setAdmin(instance, streamReader.readBoolean());
    setApellido(instance, streamReader.readString());
    setId(instance, (java.lang.Long) streamReader.readObject());
    setNombre(instance, streamReader.readString());
    setNombreUsuario(instance, streamReader.readString());
    setPassword(instance, streamReader.readString());
    setPerfil(instance, (ar.com.cristal.creditos.client.accesibilidad.PerfilesDto) streamReader.readObject());
    setSessionId(instance, streamReader.readString());
    setSupervisor(instance, streamReader.readBoolean());
    
  }
  
  public static ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO instance) throws SerializationException {
    streamWriter.writeBoolean(getAdmin(instance));
    streamWriter.writeString(getApellido(instance));
    streamWriter.writeObject(getId(instance));
    streamWriter.writeString(getNombre(instance));
    streamWriter.writeString(getNombreUsuario(instance));
    streamWriter.writeString(getPassword(instance));
    streamWriter.writeObject(getPerfil(instance));
    streamWriter.writeString(getSessionId(instance));
    streamWriter.writeBoolean(getSupervisor(instance));
    
  }
  
}
