package ar.com.snoop.gwt.commons.client.exception;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class RpcExceptionMessages_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages_FieldSerializer.deserialize(reader, (ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages_FieldSerializer.serialize(writer, (ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages)object);
    }
  }
  private static native java.util.List getMessages(ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages instance) /*-{
    return instance.@ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages::messages;
  }-*/;
  
  private static native void  setMessages(ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages instance, java.util.List value) /*-{
    instance.@ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages::messages = value;
  }-*/;
  
  private static native java.lang.String getMsg(ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages instance) /*-{
    return instance.@ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages::msg;
  }-*/;
  
  private static native void  setMsg(ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages instance, java.lang.String value) /*-{
    instance.@ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages::msg = value;
  }-*/;
  
  private static native java.lang.String getStack(ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages instance) /*-{
    return instance.@ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages::stack;
  }-*/;
  
  private static native void  setStack(ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages instance, java.lang.String value) /*-{
    instance.@ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages::stack = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages instance) throws SerializationException {
    setMessages(instance, (java.util.List) streamReader.readObject());
    setMsg(instance, streamReader.readString());
    setStack(instance, streamReader.readString());
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages instance) throws SerializationException {
    streamWriter.writeObject(getMessages(instance));
    streamWriter.writeString(getMsg(instance));
    streamWriter.writeString(getStack(instance));
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
