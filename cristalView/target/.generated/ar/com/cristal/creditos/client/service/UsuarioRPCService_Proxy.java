package ar.com.cristal.creditos.client.service;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class UsuarioRPCService_Proxy extends RemoteServiceProxy implements ar.com.cristal.creditos.client.service.UsuarioRPCServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "ar.com.cristal.creditos.client.service.UsuarioRPCService";
  private static final String SERIALIZATION_POLICY ="441D1F4DBEBA494CF98C31728492E399";
  private static final ar.com.cristal.creditos.client.service.UsuarioRPCService_TypeSerializer SERIALIZER = new ar.com.cristal.creditos.client.service.UsuarioRPCService_TypeSerializer();
  
  public UsuarioRPCService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "usuarioService", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void borrarPerfil(int id, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.borrarPerfil", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("borrarPerfil");
      streamWriter.writeInt(1);
      streamWriter.writeString("I");
      streamWriter.writeInt(id);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.borrarPerfil",  "requestSerialized"));
      doInvoke(ResponseReader.VOID, "UsuarioRPCService_Proxy.borrarPerfil", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void borrarUsuario(java.lang.Long id, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.borrarUsuario", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("borrarUsuario");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeObject(id);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.borrarUsuario",  "requestSerialized"));
      doInvoke(ResponseReader.VOID, "UsuarioRPCService_Proxy.borrarUsuario", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void cambiarPasswordUsuario(java.lang.String password, java.lang.String nuevaPassword, java.lang.String nuevaPassword2, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.cambiarPasswordUsuario", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("cambiarPasswordUsuario");
      streamWriter.writeInt(3);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(password);
      streamWriter.writeString(nuevaPassword);
      streamWriter.writeString(nuevaPassword2);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.cambiarPasswordUsuario",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "UsuarioRPCService_Proxy.cambiarPasswordUsuario", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void guardarPerfil(ar.com.cristal.creditos.client.accesibilidad.PerfilesDto p, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.guardarPerfil", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("guardarPerfil");
      streamWriter.writeInt(1);
      streamWriter.writeString("ar.com.cristal.creditos.client.accesibilidad.PerfilesDto/1382345195");
      streamWriter.writeObject(p);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.guardarPerfil",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "UsuarioRPCService_Proxy.guardarPerfil", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void obtenerComponente(java.lang.String gestionCausasLegalesEscritura, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerComponente", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerComponente");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(gestionCausasLegalesEscritura);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerComponente",  "requestSerialized"));
      doInvoke(ResponseReader.STRING, "UsuarioRPCService_Proxy.obtenerComponente", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void obtenerComponentes(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerComponentes", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerComponentes");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerComponentes",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "UsuarioRPCService_Proxy.obtenerComponentes", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void obtenerListadoOperadoresCallCenter(com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerListadoOperadoresCallCenter", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerListadoOperadoresCallCenter");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerListadoOperadoresCallCenter",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "UsuarioRPCService_Proxy.obtenerListadoOperadoresCallCenter", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void obtenerListadoOperadoresMoraTardia(com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerListadoOperadoresMoraTardia", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerListadoOperadoresMoraTardia");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerListadoOperadoresMoraTardia",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "UsuarioRPCService_Proxy.obtenerListadoOperadoresMoraTardia", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void obtenerPerfiles(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerPerfiles", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerPerfiles");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerPerfiles",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "UsuarioRPCService_Proxy.obtenerPerfiles", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void obtenerUsario(java.lang.Long id, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerUsario", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerUsario");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeObject(id);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerUsario",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "UsuarioRPCService_Proxy.obtenerUsario", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void obtenerUsarios(com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerUsarios", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerUsarios");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerUsarios",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "UsuarioRPCService_Proxy.obtenerUsarios", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void obtenerUsariosComercializadores(com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerUsariosComercializadores", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerUsariosComercializadores");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerUsariosComercializadores",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "UsuarioRPCService_Proxy.obtenerUsariosComercializadores", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void obtenerUsuarioLogueado(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerUsuarioLogueado", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerUsuarioLogueado");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerUsuarioLogueado",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "UsuarioRPCService_Proxy.obtenerUsuarioLogueado", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void obtenerUsuarioPorNombreUsuario(java.lang.String nombreUsuario, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerUsuarioPorNombreUsuario", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerUsuarioPorNombreUsuario");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(nombreUsuario);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerUsuarioPorNombreUsuario",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "UsuarioRPCService_Proxy.obtenerUsuarioPorNombreUsuario", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void obtenerUsuarios(boolean incluirBorrados, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerUsuarios", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("obtenerUsuarios");
      streamWriter.writeInt(1);
      streamWriter.writeString("Z");
      streamWriter.writeBoolean(incluirBorrados);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.obtenerUsuarios",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "UsuarioRPCService_Proxy.obtenerUsuarios", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void persistirUsuario(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO usuarioActual, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.persistirUsuario", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("persistirUsuario");
      streamWriter.writeInt(1);
      streamWriter.writeString("ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO/3852725950");
      streamWriter.writeObject(usuarioActual);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.persistirUsuario",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "UsuarioRPCService_Proxy.persistirUsuario", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void tienePermisoAcceso(java.lang.String componente, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.tienePermisoAcceso", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("tienePermisoAcceso");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(componente);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.tienePermisoAcceso",  "requestSerialized"));
      doInvoke(ResponseReader.BOOLEAN, "UsuarioRPCService_Proxy.tienePermisoAcceso", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void tienePermisoAltaReparticion(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.tienePermisoAltaReparticion", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("tienePermisoAltaReparticion");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.tienePermisoAltaReparticion",  "requestSerialized"));
      doInvoke(ResponseReader.BOOLEAN, "UsuarioRPCService_Proxy.tienePermisoAltaReparticion", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void tienePermisoAprobacionFinanciacionDirecta(com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.tienePermisoAprobacionFinanciacionDirecta", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("tienePermisoAprobacionFinanciacionDirecta");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.tienePermisoAprobacionFinanciacionDirecta",  "requestSerialized"));
      doInvoke(ResponseReader.BOOLEAN, "UsuarioRPCService_Proxy.tienePermisoAprobacionFinanciacionDirecta", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void validarNombreUsuario(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO usuarioActual, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.validarNombreUsuario", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("validarNombreUsuario");
      streamWriter.writeInt(1);
      streamWriter.writeString("ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO/3852725950");
      streamWriter.writeObject(usuarioActual);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("UsuarioRPCService_Proxy.validarNombreUsuario",  "requestSerialized"));
      doInvoke(ResponseReader.BOOLEAN, "UsuarioRPCService_Proxy.validarNombreUsuario", statsContext, payload, asyncCallback);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
}
