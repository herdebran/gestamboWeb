package de.novanic.eventservice.client.event.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.rpc.impl.TypeHandler;
import java.util.HashMap;
import java.util.Map;

public class EventService_TypeSerializer extends com.google.gwt.user.client.rpc.impl.SerializerBase {
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
    result.put("ar.com.snoop.gwt.commons.client.service.CallListenerCollection/3395236877", new ar.com.snoop.gwt.commons.client.service.CallListenerCollection_FieldSerializer.Handler());
    result.put("com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533", new com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer.Handler());
    result.put("de.novanic.eventservice.client.event.DefaultDomainEvent/3924906731", new de.novanic.eventservice.client.event.DefaultDomainEvent_FieldSerializer.Handler());
    result.put("[Lde.novanic.eventservice.client.event.DefaultDomainEvent;/4107875583", new de.novanic.eventservice.client.event.DefaultDomainEvent_Array_Rank_1_FieldSerializer.Handler());
    result.put("[Lde.novanic.eventservice.client.event.DomainEvent;/2573218216", new de.novanic.eventservice.client.event.DomainEvent_Array_Rank_1_FieldSerializer.Handler());
    result.put("de.novanic.eventservice.client.event.domain.DefaultDomain/240262385", new de.novanic.eventservice.client.event.domain.DefaultDomain_FieldSerializer.Handler());
    result.put("[Lde.novanic.eventservice.client.event.filter.AppendableEventFilter;/3140808580", new de.novanic.eventservice.client.event.filter.AppendableEventFilter_Array_Rank_1_FieldSerializer.Handler());
    result.put("[Lde.novanic.eventservice.client.event.filter.CascadingEventFilter;/4218008474", new de.novanic.eventservice.client.event.filter.CascadingEventFilter_Array_Rank_1_FieldSerializer.Handler());
    result.put("[Lde.novanic.eventservice.client.event.filter.CompositeEventFilter;/3667622880", new de.novanic.eventservice.client.event.filter.CompositeEventFilter_Array_Rank_1_FieldSerializer.Handler());
    result.put("de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter/2036315829", new de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter_FieldSerializer.Handler());
    result.put("[Lde.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter;/2853401946", new de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter_Array_Rank_1_FieldSerializer.Handler());
    result.put("de.novanic.eventservice.client.event.filter.DefaultEventFilter/3359357329", new de.novanic.eventservice.client.event.filter.DefaultEventFilter_FieldSerializer.Handler());
    result.put("[Lde.novanic.eventservice.client.event.filter.DefaultEventFilter;/2136978271", new de.novanic.eventservice.client.event.filter.DefaultEventFilter_Array_Rank_1_FieldSerializer.Handler());
    result.put("[Lde.novanic.eventservice.client.event.filter.EventFilter;/836210305", new de.novanic.eventservice.client.event.filter.EventFilter_Array_Rank_1_FieldSerializer.Handler());
    result.put("de.novanic.eventservice.client.event.listener.unlisten.DefaultUnlistenEvent/2862324233", new de.novanic.eventservice.client.event.listener.unlisten.DefaultUnlistenEvent_FieldSerializer.Handler());
    result.put("de.novanic.eventservice.client.event.listener.unlisten.UnlistenEventListener$Scope/4054018674", new de.novanic.eventservice.client.event.listener.unlisten.UnlistenEventListener_Scope_FieldSerializer.Handler());
    result.put("java.lang.Boolean/476441737", new com.google.gwt.user.client.rpc.core.java.lang.Boolean_FieldSerializer.Handler());
    result.put("java.lang.Long/4227064769", new com.google.gwt.user.client.rpc.core.java.lang.Long_FieldSerializer.Handler());
    result.put("java.lang.String/2004016611", new com.google.gwt.user.client.rpc.core.java.lang.String_FieldSerializer.Handler());
    result.put("java.util.ArrayList/3821976829", new com.google.gwt.user.client.rpc.core.java.util.ArrayList_FieldSerializer.Handler());
    result.put("java.util.Arrays$ArrayList/1243019747", new com.google.gwt.user.client.rpc.core.java.util.Arrays_ArrayList_FieldSerializer.Handler());
    result.put("java.util.Collections$EmptyList/3012082351", new com.google.gwt.user.client.rpc.core.java.util.Collections_EmptyList_FieldSerializer.Handler());
    result.put("java.util.Collections$EmptySet/3150696644", new com.google.gwt.user.client.rpc.core.java.util.Collections_EmptySet_FieldSerializer.Handler());
    result.put("java.util.Collections$SingletonList/833432284", new com.google.gwt.user.client.rpc.core.java.util.Collections_SingletonList_FieldSerializer.Handler());
    result.put("java.util.HashSet/1594477813", new com.google.gwt.user.client.rpc.core.java.util.HashSet_FieldSerializer.Handler());
    result.put("java.util.LinkedHashSet/3628722029", new com.google.gwt.user.client.rpc.core.java.util.LinkedHashSet_FieldSerializer.Handler());
    result.put("java.util.LinkedList/1060625595", new com.google.gwt.user.client.rpc.core.java.util.LinkedList_FieldSerializer.Handler());
    result.put("java.util.Stack/1031431137", new com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer.Handler());
    result.put("java.util.TreeMap/1575826026", new com.google.gwt.user.client.rpc.core.java.util.TreeMap_FieldSerializer.Handler());
    result.put("java.util.TreeSet/1002270346", new com.google.gwt.user.client.rpc.core.java.util.TreeSet_FieldSerializer.Handler());
    result.put("java.util.Vector/3125574444", new com.google.gwt.user.client.rpc.core.java.util.Vector_FieldSerializer.Handler());
    return result;
  }
  
  @SuppressWarnings("deprecation")
  private static native MethodMap loadMethodsNative() /*-{
    var result = {};
    result["ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent/3745886056"] = [
        @ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/ui/event/AprobacionRechazoEvent;),
        @ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lar/com/cristal/creditos/client/ui/event/AprobacionRechazoEvent;)
      ];
    
    result["ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent/4085108744"] = [
        @ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/ui/event/DocumentoGeneradoEvent;),
        @ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lar/com/cristal/creditos/client/ui/event/DocumentoGeneradoEvent;)
      ];
    
    result["ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent/2095703593"] = [
        @ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/ui/event/DocumentoSubidoEvent;),
        @ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lar/com/cristal/creditos/client/ui/event/DocumentoSubidoEvent;)
      ];
    
    result["ar.com.snoop.gwt.commons.client.service.CallListenerCollection/3395236877"] = [
        @ar.com.snoop.gwt.commons.client.service.CallListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.snoop.gwt.commons.client.service.CallListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/snoop/gwt/commons/client/service/CallListenerCollection;),
        @ar.com.snoop.gwt.commons.client.service.CallListenerCollection_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lar/com/snoop/gwt/commons/client/service/CallListenerCollection;)
      ];
    
    result["com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533"] = [
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/IncompatibleRemoteServiceException;),
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/user/client/rpc/IncompatibleRemoteServiceException;)
      ];
    
    result["de.novanic.eventservice.client.event.DefaultDomainEvent/3924906731"] = [
        @de.novanic.eventservice.client.event.DefaultDomainEvent_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @de.novanic.eventservice.client.event.DefaultDomainEvent_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lde/novanic/eventservice/client/event/DefaultDomainEvent;),
      ];
    
    result["[Lde.novanic.eventservice.client.event.DefaultDomainEvent;/4107875583"] = [
        @de.novanic.eventservice.client.event.DefaultDomainEvent_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @de.novanic.eventservice.client.event.DefaultDomainEvent_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lde/novanic/eventservice/client/event/DefaultDomainEvent;),
      ];
    
    result["[Lde.novanic.eventservice.client.event.DomainEvent;/2573218216"] = [
        @de.novanic.eventservice.client.event.DomainEvent_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @de.novanic.eventservice.client.event.DomainEvent_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lde/novanic/eventservice/client/event/DomainEvent;),
      ];
    
    result["de.novanic.eventservice.client.event.domain.DefaultDomain/240262385"] = [
        @de.novanic.eventservice.client.event.domain.DefaultDomain_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @de.novanic.eventservice.client.event.domain.DefaultDomain_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lde/novanic/eventservice/client/event/domain/DefaultDomain;),
        @de.novanic.eventservice.client.event.domain.DefaultDomain_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lde/novanic/eventservice/client/event/domain/DefaultDomain;)
      ];
    
    result["[Lde.novanic.eventservice.client.event.filter.AppendableEventFilter;/3140808580"] = [
        @de.novanic.eventservice.client.event.filter.AppendableEventFilter_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @de.novanic.eventservice.client.event.filter.AppendableEventFilter_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lde/novanic/eventservice/client/event/filter/AppendableEventFilter;),
        @de.novanic.eventservice.client.event.filter.AppendableEventFilter_Array_Rank_1_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;[Lde/novanic/eventservice/client/event/filter/AppendableEventFilter;)
      ];
    
    result["[Lde.novanic.eventservice.client.event.filter.CascadingEventFilter;/4218008474"] = [
        @de.novanic.eventservice.client.event.filter.CascadingEventFilter_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @de.novanic.eventservice.client.event.filter.CascadingEventFilter_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lde/novanic/eventservice/client/event/filter/CascadingEventFilter;),
        @de.novanic.eventservice.client.event.filter.CascadingEventFilter_Array_Rank_1_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;[Lde/novanic/eventservice/client/event/filter/CascadingEventFilter;)
      ];
    
    result["[Lde.novanic.eventservice.client.event.filter.CompositeEventFilter;/3667622880"] = [
        @de.novanic.eventservice.client.event.filter.CompositeEventFilter_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @de.novanic.eventservice.client.event.filter.CompositeEventFilter_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lde/novanic/eventservice/client/event/filter/CompositeEventFilter;),
        @de.novanic.eventservice.client.event.filter.CompositeEventFilter_Array_Rank_1_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;[Lde/novanic/eventservice/client/event/filter/CompositeEventFilter;)
      ];
    
    result["de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter/2036315829"] = [
        @de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lde/novanic/eventservice/client/event/filter/DefaultCompositeEventFilter;),
        @de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lde/novanic/eventservice/client/event/filter/DefaultCompositeEventFilter;)
      ];
    
    result["[Lde.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter;/2853401946"] = [
        @de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lde/novanic/eventservice/client/event/filter/DefaultCompositeEventFilter;),
        @de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter_Array_Rank_1_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;[Lde/novanic/eventservice/client/event/filter/DefaultCompositeEventFilter;)
      ];
    
    result["de.novanic.eventservice.client.event.filter.DefaultEventFilter/3359357329"] = [
        @de.novanic.eventservice.client.event.filter.DefaultEventFilter_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @de.novanic.eventservice.client.event.filter.DefaultEventFilter_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lde/novanic/eventservice/client/event/filter/DefaultEventFilter;),
        @de.novanic.eventservice.client.event.filter.DefaultEventFilter_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lde/novanic/eventservice/client/event/filter/DefaultEventFilter;)
      ];
    
    result["[Lde.novanic.eventservice.client.event.filter.DefaultEventFilter;/2136978271"] = [
        @de.novanic.eventservice.client.event.filter.DefaultEventFilter_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @de.novanic.eventservice.client.event.filter.DefaultEventFilter_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lde/novanic/eventservice/client/event/filter/DefaultEventFilter;),
        @de.novanic.eventservice.client.event.filter.DefaultEventFilter_Array_Rank_1_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;[Lde/novanic/eventservice/client/event/filter/DefaultEventFilter;)
      ];
    
    result["[Lde.novanic.eventservice.client.event.filter.EventFilter;/836210305"] = [
        @de.novanic.eventservice.client.event.filter.EventFilter_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @de.novanic.eventservice.client.event.filter.EventFilter_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lde/novanic/eventservice/client/event/filter/EventFilter;),
        @de.novanic.eventservice.client.event.filter.EventFilter_Array_Rank_1_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;[Lde/novanic/eventservice/client/event/filter/EventFilter;)
      ];
    
    result["de.novanic.eventservice.client.event.listener.unlisten.DefaultUnlistenEvent/2862324233"] = [
        @de.novanic.eventservice.client.event.listener.unlisten.DefaultUnlistenEvent_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @de.novanic.eventservice.client.event.listener.unlisten.DefaultUnlistenEvent_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lde/novanic/eventservice/client/event/listener/unlisten/DefaultUnlistenEvent;),
        @de.novanic.eventservice.client.event.listener.unlisten.DefaultUnlistenEvent_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lde/novanic/eventservice/client/event/listener/unlisten/DefaultUnlistenEvent;)
      ];
    
    result["de.novanic.eventservice.client.event.listener.unlisten.UnlistenEventListener$Scope/4054018674"] = [
        ,
        ,
        @de.novanic.eventservice.client.event.listener.unlisten.UnlistenEventListener_Scope_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lde/novanic/eventservice/client/event/listener/unlisten/UnlistenEventListener$Scope;)
      ];
    
    result["java.lang.Boolean/476441737"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.Boolean_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Boolean_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Boolean;),
        @com.google.gwt.user.client.rpc.core.java.lang.Boolean_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/Boolean;)
      ];
    
    result["java.lang.Long/4227064769"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.Long_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Long_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Long;),
        @com.google.gwt.user.client.rpc.core.java.lang.Long_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/Long;)
      ];
    
    result["java.lang.String/2004016611"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/String;),
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/String;)
      ];
    
    result["java.util.ArrayList/3821976829"] = [
        @com.google.gwt.user.client.rpc.core.java.util.ArrayList_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.ArrayList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/ArrayList;),
        @com.google.gwt.user.client.rpc.core.java.util.ArrayList_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/ArrayList;)
      ];
    
    result["java.util.Arrays$ArrayList/1243019747"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Arrays.ArrayList_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Arrays.ArrayList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/List;),
        @com.google.gwt.user.client.rpc.core.java.util.Arrays.ArrayList_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/List;)
      ];
    
    result["java.util.Collections$EmptyList/3012082351"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyList_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/List;),
        @com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyList_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/List;)
      ];
    
    result["java.util.Collections$EmptySet/3150696644"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Collections.EmptySet_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Collections.EmptySet_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/Set;),
        @com.google.gwt.user.client.rpc.core.java.util.Collections.EmptySet_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/Set;)
      ];
    
    result["java.util.Collections$SingletonList/833432284"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Collections.SingletonList_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Collections.SingletonList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/List;),
        @com.google.gwt.user.client.rpc.core.java.util.Collections.SingletonList_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/List;)
      ];
    
    result["java.util.HashSet/1594477813"] = [
        @com.google.gwt.user.client.rpc.core.java.util.HashSet_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.HashSet_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/HashSet;),
        @com.google.gwt.user.client.rpc.core.java.util.HashSet_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/HashSet;)
      ];
    
    result["java.util.LinkedHashSet/3628722029"] = [
        @com.google.gwt.user.client.rpc.core.java.util.LinkedHashSet_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.LinkedHashSet_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/LinkedHashSet;),
        @com.google.gwt.user.client.rpc.core.java.util.LinkedHashSet_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/LinkedHashSet;)
      ];
    
    result["java.util.LinkedList/1060625595"] = [
        @com.google.gwt.user.client.rpc.core.java.util.LinkedList_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.LinkedList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/LinkedList;),
        @com.google.gwt.user.client.rpc.core.java.util.LinkedList_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/LinkedList;)
      ];
    
    result["java.util.Stack/1031431137"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/Stack;),
        @com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/Stack;)
      ];
    
    result["java.util.TreeMap/1575826026"] = [
        @com.google.gwt.user.client.rpc.core.java.util.TreeMap_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.TreeMap_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/TreeMap;),
        @com.google.gwt.user.client.rpc.core.java.util.TreeMap_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/TreeMap;)
      ];
    
    result["java.util.TreeSet/1002270346"] = [
        @com.google.gwt.user.client.rpc.core.java.util.TreeSet_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.TreeSet_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/TreeSet;),
        @com.google.gwt.user.client.rpc.core.java.util.TreeSet_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/TreeSet;)
      ];
    
    result["java.util.Vector/3125574444"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Vector_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Vector_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/Vector;),
        @com.google.gwt.user.client.rpc.core.java.util.Vector_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/Vector;)
      ];
    
    return result;
  }-*/;
  
  @SuppressWarnings("deprecation")
  private static Map<Class<?>, String> loadSignaturesJava() {
    Map<Class<?>, String> result = new HashMap<Class<?>, String>();
    result.put(ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent/3745886056");
    result.put(ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent/4085108744");
    result.put(ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent/2095703593");
    result.put(ar.com.snoop.gwt.commons.client.service.CallListenerCollection_FieldSerializer.concreteType(), "ar.com.snoop.gwt.commons.client.service.CallListenerCollection/3395236877");
    result.put(com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer.concreteType(), "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533");
    result.put(de.novanic.eventservice.client.event.DefaultDomainEvent_FieldSerializer.concreteType(), "de.novanic.eventservice.client.event.DefaultDomainEvent/3924906731");
    result.put(de.novanic.eventservice.client.event.DefaultDomainEvent_Array_Rank_1_FieldSerializer.concreteType(), "[Lde.novanic.eventservice.client.event.DefaultDomainEvent;/4107875583");
    result.put(de.novanic.eventservice.client.event.DomainEvent_Array_Rank_1_FieldSerializer.concreteType(), "[Lde.novanic.eventservice.client.event.DomainEvent;/2573218216");
    result.put(de.novanic.eventservice.client.event.domain.DefaultDomain_FieldSerializer.concreteType(), "de.novanic.eventservice.client.event.domain.DefaultDomain/240262385");
    result.put(de.novanic.eventservice.client.event.filter.AppendableEventFilter_Array_Rank_1_FieldSerializer.concreteType(), "[Lde.novanic.eventservice.client.event.filter.AppendableEventFilter;/3140808580");
    result.put(de.novanic.eventservice.client.event.filter.CascadingEventFilter_Array_Rank_1_FieldSerializer.concreteType(), "[Lde.novanic.eventservice.client.event.filter.CascadingEventFilter;/4218008474");
    result.put(de.novanic.eventservice.client.event.filter.CompositeEventFilter_Array_Rank_1_FieldSerializer.concreteType(), "[Lde.novanic.eventservice.client.event.filter.CompositeEventFilter;/3667622880");
    result.put(de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter_FieldSerializer.concreteType(), "de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter/2036315829");
    result.put(de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter_Array_Rank_1_FieldSerializer.concreteType(), "[Lde.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter;/2853401946");
    result.put(de.novanic.eventservice.client.event.filter.DefaultEventFilter_FieldSerializer.concreteType(), "de.novanic.eventservice.client.event.filter.DefaultEventFilter/3359357329");
    result.put(de.novanic.eventservice.client.event.filter.DefaultEventFilter_Array_Rank_1_FieldSerializer.concreteType(), "[Lde.novanic.eventservice.client.event.filter.DefaultEventFilter;/2136978271");
    result.put(de.novanic.eventservice.client.event.filter.EventFilter_Array_Rank_1_FieldSerializer.concreteType(), "[Lde.novanic.eventservice.client.event.filter.EventFilter;/836210305");
    result.put(de.novanic.eventservice.client.event.listener.unlisten.DefaultUnlistenEvent_FieldSerializer.concreteType(), "de.novanic.eventservice.client.event.listener.unlisten.DefaultUnlistenEvent/2862324233");
    result.put(de.novanic.eventservice.client.event.listener.unlisten.UnlistenEventListener_Scope_FieldSerializer.concreteType(), "de.novanic.eventservice.client.event.listener.unlisten.UnlistenEventListener$Scope/4054018674");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.Boolean_FieldSerializer.concreteType(), "java.lang.Boolean/476441737");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.Long_FieldSerializer.concreteType(), "java.lang.Long/4227064769");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.String_FieldSerializer.concreteType(), "java.lang.String/2004016611");
    result.put(com.google.gwt.user.client.rpc.core.java.util.ArrayList_FieldSerializer.concreteType(), "java.util.ArrayList/3821976829");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Arrays.ArrayList_CustomFieldSerializer.concreteType(), "java.util.Arrays$ArrayList/1243019747");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyList_CustomFieldSerializer.concreteType(), "java.util.Collections$EmptyList/3012082351");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Collections.EmptySet_CustomFieldSerializer.concreteType(), "java.util.Collections$EmptySet/3150696644");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Collections.SingletonList_CustomFieldSerializer.concreteType(), "java.util.Collections$SingletonList/833432284");
    result.put(com.google.gwt.user.client.rpc.core.java.util.HashSet_FieldSerializer.concreteType(), "java.util.HashSet/1594477813");
    result.put(com.google.gwt.user.client.rpc.core.java.util.LinkedHashSet_FieldSerializer.concreteType(), "java.util.LinkedHashSet/3628722029");
    result.put(com.google.gwt.user.client.rpc.core.java.util.LinkedList_FieldSerializer.concreteType(), "java.util.LinkedList/1060625595");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer.concreteType(), "java.util.Stack/1031431137");
    result.put(com.google.gwt.user.client.rpc.core.java.util.TreeMap_FieldSerializer.concreteType(), "java.util.TreeMap/1575826026");
    result.put(com.google.gwt.user.client.rpc.core.java.util.TreeSet_FieldSerializer.concreteType(), "java.util.TreeSet/1002270346");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Vector_FieldSerializer.concreteType(), "java.util.Vector/3125574444");
    return result;
  }
  
  @SuppressWarnings("deprecation")
  private static native JsArrayString loadSignaturesNative() /*-{
    var result = [];
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent::class)] = "ar.com.cristal.creditos.client.ui.event.AprobacionRechazoEvent/3745886056";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent::class)] = "ar.com.cristal.creditos.client.ui.event.DocumentoGeneradoEvent/4085108744";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent::class)] = "ar.com.cristal.creditos.client.ui.event.DocumentoSubidoEvent/2095703593";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.snoop.gwt.commons.client.service.CallListenerCollection::class)] = "ar.com.snoop.gwt.commons.client.service.CallListenerCollection/3395236877";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException::class)] = "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@de.novanic.eventservice.client.event.DefaultDomainEvent::class)] = "de.novanic.eventservice.client.event.DefaultDomainEvent/3924906731";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@de.novanic.eventservice.client.event.DefaultDomainEvent[]::class)] = "[Lde.novanic.eventservice.client.event.DefaultDomainEvent;/4107875583";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@de.novanic.eventservice.client.event.DomainEvent[]::class)] = "[Lde.novanic.eventservice.client.event.DomainEvent;/2573218216";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@de.novanic.eventservice.client.event.domain.DefaultDomain::class)] = "de.novanic.eventservice.client.event.domain.DefaultDomain/240262385";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@de.novanic.eventservice.client.event.filter.AppendableEventFilter[]::class)] = "[Lde.novanic.eventservice.client.event.filter.AppendableEventFilter;/3140808580";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@de.novanic.eventservice.client.event.filter.CascadingEventFilter[]::class)] = "[Lde.novanic.eventservice.client.event.filter.CascadingEventFilter;/4218008474";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@de.novanic.eventservice.client.event.filter.CompositeEventFilter[]::class)] = "[Lde.novanic.eventservice.client.event.filter.CompositeEventFilter;/3667622880";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter::class)] = "de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter/2036315829";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@de.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter[]::class)] = "[Lde.novanic.eventservice.client.event.filter.DefaultCompositeEventFilter;/2853401946";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@de.novanic.eventservice.client.event.filter.DefaultEventFilter::class)] = "de.novanic.eventservice.client.event.filter.DefaultEventFilter/3359357329";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@de.novanic.eventservice.client.event.filter.DefaultEventFilter[]::class)] = "[Lde.novanic.eventservice.client.event.filter.DefaultEventFilter;/2136978271";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@de.novanic.eventservice.client.event.filter.EventFilter[]::class)] = "[Lde.novanic.eventservice.client.event.filter.EventFilter;/836210305";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@de.novanic.eventservice.client.event.listener.unlisten.DefaultUnlistenEvent::class)] = "de.novanic.eventservice.client.event.listener.unlisten.DefaultUnlistenEvent/2862324233";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@de.novanic.eventservice.client.event.listener.unlisten.UnlistenEventListener$Scope::class)] = "de.novanic.eventservice.client.event.listener.unlisten.UnlistenEventListener$Scope/4054018674";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.Boolean::class)] = "java.lang.Boolean/476441737";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.Long::class)] = "java.lang.Long/4227064769";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.String::class)] = "java.lang.String/2004016611";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.ArrayList::class)] = "java.util.ArrayList/3821976829";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Arrays$ArrayList::class)] = "java.util.Arrays$ArrayList/1243019747";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Collections$EmptyList::class)] = "java.util.Collections$EmptyList/3012082351";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Collections$EmptySet::class)] = "java.util.Collections$EmptySet/3150696644";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Collections$SingletonList::class)] = "java.util.Collections$SingletonList/833432284";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.HashSet::class)] = "java.util.HashSet/1594477813";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.LinkedHashSet::class)] = "java.util.LinkedHashSet/3628722029";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.LinkedList::class)] = "java.util.LinkedList/1060625595";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Stack::class)] = "java.util.Stack/1031431137";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.TreeMap::class)] = "java.util.TreeMap/1575826026";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.TreeSet::class)] = "java.util.TreeSet/1002270346";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Vector::class)] = "java.util.Vector/3125574444";
    return result;
  }-*/;
  
  public EventService_TypeSerializer() {
    super(methodMapJava, methodMapNative, signatureMapJava, signatureMapNative);
  }
  
}
