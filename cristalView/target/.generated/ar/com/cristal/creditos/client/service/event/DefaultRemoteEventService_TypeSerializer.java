package ar.com.cristal.creditos.client.service.event;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.rpc.impl.TypeHandler;
import java.util.HashMap;
import java.util.Map;

public class DefaultRemoteEventService_TypeSerializer extends com.google.gwt.user.client.rpc.impl.SerializerBase {
  private static final Map<String, TypeHandler> methodMapJava;
  private static final MethodMap methodMapNative;
  private static final Map<Class<?>, String> signatureMapJava;
  private static final JsArrayString signatureMapNative;
  
  static {
    if (GWT.isScript()) {
      methodMapJava = null;
      methodMapNative = loadMethodsNative();
      signatureMapJava = null;
      signatureMapNative = loadSignaturesNative();
    } else {
      methodMapJava = loadMethodsJava();
      methodMapNative = null;
      signatureMapJava = loadSignaturesJava();
      signatureMapNative = null;
    }
  }
  
  @SuppressWarnings("deprecation")
  private static Map<String, TypeHandler> loadMethodsJava() {
    Map<String, TypeHandler> result = new HashMap<String, TypeHandler>();
    result.put("ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent/3745886056", new ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent_FieldSerializer.Handler());
    result.put("ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent/4085108744", new ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent_FieldSerializer.Handler());
    result.put("ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent/2095703593", new ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent_FieldSerializer.Handler());
    result.put("com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533", new com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer.Handler());
    result.put("de.novanic.eventservice.client.event.domain.DefaultDomain/240262385", new de.novanic.eventservice.client.event.domain.DefaultDomain_FieldSerializer.Handler());
    result.put("de.novanic.eventservice.client.event.listener.unlisten.DefaultUnlistenEvent/2862324233", new de.novanic.eventservice.client.event.listener.unlisten.DefaultUnlistenEvent_FieldSerializer.Handler());
    result.put("java.lang.Boolean/476441737", new com.google.gwt.user.client.rpc.core.java.lang.Boolean_FieldSerializer.Handler());
    result.put("java.lang.Long/4227064769", new com.google.gwt.user.client.rpc.core.java.lang.Long_FieldSerializer.Handler());
    result.put("java.lang.String/2004016611", new com.google.gwt.user.client.rpc.core.java.lang.String_FieldSerializer.Handler());
    result.put("java.util.Collections$EmptySet/3150696644", new com.google.gwt.user.client.rpc.core.java.util.Collections_EmptySet_FieldSerializer.Handler());
    result.put("java.util.HashSet/1594477813", new com.google.gwt.user.client.rpc.core.java.util.HashSet_FieldSerializer.Handler());
    result.put("java.util.LinkedHashSet/3628722029", new com.google.gwt.user.client.rpc.core.java.util.LinkedHashSet_FieldSerializer.Handler());
    result.put("java.util.TreeMap/1575826026", new com.google.gwt.user.client.rpc.core.java.util.TreeMap_FieldSerializer.Handler());
    result.put("java.util.TreeSet/1002270346", new com.google.gwt.user.client.rpc.core.java.util.TreeSet_FieldSerializer.Handler());
    return result;
  }
  
  @SuppressWarnings("deprecation")
  private static native MethodMap loadMethodsNative() /*-{
    var result = {};
    result["ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent/3745886056"] = [
        ,
        ,
        @ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lar/com/cristal/creditos/client/ui/event/AprobacionRechazoEvent;)
      ];
    
    result["ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent/4085108744"] = [
        ,
        ,
        @ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lar/com/cristal/creditos/client/ui/event/DocumentoGeneradoEvent;)
      ];
    
    result["ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent/2095703593"] = [
        ,
        ,
        @ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lar/com/cristal/creditos/client/ui/event/DocumentoSubidoEvent;)
      ];
    
    result["com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533"] = [
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/IncompatibleRemoteServiceException;),
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/user/client/rpc/IncompatibleRemoteServiceException;)
      ];
    
    result["de.novanic.eventservice.client.event.domain.DefaultDomain/240262385"] = [
        ,
        ,
        @de.novanic.eventservice.client.event.domain.DefaultDomain_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lde/novanic/eventservice/client/event/domain/DefaultDomain;)
      ];
    
    result["de.novanic.eventservice.client.event.listener.unlisten.DefaultUnlistenEvent/2862324233"] = [
        ,
        ,
        @de.novanic.eventservice.client.event.listener.unlisten.DefaultUnlistenEvent_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lde/novanic/eventservice/client/event/listener/unlisten/DefaultUnlistenEvent;)
      ];
    
    result["java.lang.Boolean/476441737"] = [
        ,
        ,
        @com.google.gwt.user.client.rpc.core.java.lang.Boolean_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/Boolean;)
      ];
    
    result["java.lang.Long/4227064769"] = [
        ,
        ,
        @com.google.gwt.user.client.rpc.core.java.lang.Long_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/Long;)
      ];
    
    result["java.lang.String/2004016611"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/String;),
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/String;)
      ];
    
    result["java.util.Collections$EmptySet/3150696644"] = [
        ,
        ,
        @com.google.gwt.user.client.rpc.core.java.util.Collections.EmptySet_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/Set;)
      ];
    
    result["java.util.HashSet/1594477813"] = [
        ,
        ,
        @com.google.gwt.user.client.rpc.core.java.util.HashSet_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/HashSet;)
      ];
    
    result["java.util.LinkedHashSet/3628722029"] = [
        ,
        ,
        @com.google.gwt.user.client.rpc.core.java.util.LinkedHashSet_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/LinkedHashSet;)
      ];
    
    result["java.util.TreeMap/1575826026"] = [
        ,
        ,
        @com.google.gwt.user.client.rpc.core.java.util.TreeMap_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/TreeMap;)
      ];
    
    result["java.util.TreeSet/1002270346"] = [
        ,
        ,
        @com.google.gwt.user.client.rpc.core.java.util.TreeSet_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/TreeSet;)
      ];
    
    return result;
  }-*/;
  
  @SuppressWarnings("deprecation")
  private static Map<Class<?>, String> loadSignaturesJava() {
    Map<Class<?>, String> result = new HashMap<Class<?>, String>();
    result.put(ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent/3745886056");
    result.put(ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent/4085108744");
    result.put(ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent/2095703593");
    result.put(com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer.concreteType(), "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533");
    result.put(de.novanic.eventservice.client.event.domain.DefaultDomain_FieldSerializer.concreteType(), "de.novanic.eventservice.client.event.domain.DefaultDomain/240262385");
    result.put(de.novanic.eventservice.client.event.listener.unlisten.DefaultUnlistenEvent_FieldSerializer.concreteType(), "de.novanic.eventservice.client.event.listener.unlisten.DefaultUnlistenEvent/2862324233");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.Boolean_FieldSerializer.concreteType(), "java.lang.Boolean/476441737");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.Long_FieldSerializer.concreteType(), "java.lang.Long/4227064769");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.String_FieldSerializer.concreteType(), "java.lang.String/2004016611");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Collections.EmptySet_CustomFieldSerializer.concreteType(), "java.util.Collections$EmptySet/3150696644");
    result.put(com.google.gwt.user.client.rpc.core.java.util.HashSet_FieldSerializer.concreteType(), "java.util.HashSet/1594477813");
    result.put(com.google.gwt.user.client.rpc.core.java.util.LinkedHashSet_FieldSerializer.concreteType(), "java.util.LinkedHashSet/3628722029");
    result.put(com.google.gwt.user.client.rpc.core.java.util.TreeMap_FieldSerializer.concreteType(), "java.util.TreeMap/1575826026");
    result.put(com.google.gwt.user.client.rpc.core.java.util.TreeSet_FieldSerializer.concreteType(), "java.util.TreeSet/1002270346");
    return result;
  }
  
  @SuppressWarnings("deprecation")
  private static native JsArrayString loadSignaturesNative() /*-{
    var result = [];
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent::class)] = "ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent/3745886056";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent::class)] = "ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent/4085108744";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent::class)] = "ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent/2095703593";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException::class)] = "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@de.novanic.eventservice.client.event.domain.DefaultDomain::class)] = "de.novanic.eventservice.client.event.domain.DefaultDomain/240262385";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@de.novanic.eventservice.client.event.listener.unlisten.DefaultUnlistenEvent::class)] = "de.novanic.eventservice.client.event.listener.unlisten.DefaultUnlistenEvent/2862324233";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.Boolean::class)] = "java.lang.Boolean/476441737";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.Long::class)] = "java.lang.Long/4227064769";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.String::class)] = "java.lang.String/2004016611";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Collections$EmptySet::class)] = "java.util.Collections$EmptySet/3150696644";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.HashSet::class)] = "java.util.HashSet/1594477813";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.LinkedHashSet::class)] = "java.util.LinkedHashSet/3628722029";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.TreeMap::class)] = "java.util.TreeMap/1575826026";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.TreeSet::class)] = "java.util.TreeSet/1002270346";
    return result;
  }-*/;
  
  public DefaultRemoteEventService_TypeSerializer() {
    super(methodMapJava, methodMapNative, signatureMapJava, signatureMapNative);
  }
  
}
