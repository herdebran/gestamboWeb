package ar.com.cristal.creditos.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.rpc.impl.TypeHandler;
import java.util.HashMap;
import java.util.Map;

public class ComunesRPCService_TypeSerializer extends com.google.gwt.user.client.rpc.impl.SerializerBase {
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
    result.put("ar.com.cristal.creditos.client.accesibilidad.PerfilesDto/1382345195", new ar.com.cristal.creditos.client.accesibilidad.PerfilesDto_FieldSerializer.Handler());
    result.put("[Lar.com.cristal.creditos.client.accesibilidad.PerfilesDto;/2267895133", new ar.com.cristal.creditos.client.accesibilidad.PerfilesDto_Array_Rank_1_FieldSerializer.Handler());
    result.put("ar.com.cristal.creditos.client.clientes.busqueda.detalle.DatosOperacionesHistorialCreditosClienteDTO/3961592710", new ar.com.cristal.creditos.client.clientes.busqueda.detalle.DatosOperacionesHistorialCreditosClienteDTO_FieldSerializer.Handler());
    result.put("ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO/3037036523", new ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO_FieldSerializer.Handler());
    result.put("ar.com.cristal.creditos.client.dto.ClienteDTO/2095328581", new ar.com.cristal.creditos.client.dto.ClienteDTO_FieldSerializer.Handler());
    result.put("[Lar.com.cristal.creditos.client.dto.ClienteDTO;/2414100404", new ar.com.cristal.creditos.client.dto.ClienteDTO_Array_Rank_1_FieldSerializer.Handler());
    result.put("ar.com.cristal.creditos.client.dto.DTO/188801063", new ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.Handler());
    result.put("ar.com.cristal.creditos.client.dto.DatoAnexoDTO/684498257", new ar.com.cristal.creditos.client.dto.DatoAnexoDTO_FieldSerializer.Handler());
    result.put("ar.com.cristal.creditos.client.dto.EmpresaDTO/2860350642", new ar.com.cristal.creditos.client.dto.EmpresaDTO_FieldSerializer.Handler());
    result.put("[Lar.com.cristal.creditos.client.dto.EmpresaDTO;/3910318810", new ar.com.cristal.creditos.client.dto.EmpresaDTO_Array_Rank_1_FieldSerializer.Handler());
    result.put("ar.com.cristal.creditos.client.dto.EstadoLineaMovimientoEnumDTO/2162181107", new ar.com.cristal.creditos.client.dto.EstadoLineaMovimientoEnumDTO_FieldSerializer.Handler());
    result.put("[Lar.com.cristal.creditos.client.dto.EstadoLineaMovimientoEnumDTO;/969081028", new ar.com.cristal.creditos.client.dto.EstadoLineaMovimientoEnumDTO_Array_Rank_1_FieldSerializer.Handler());
    result.put("ar.com.cristal.creditos.client.dto.MedioContactoDTO/3170001166", new ar.com.cristal.creditos.client.dto.MedioContactoDTO_FieldSerializer.Handler());
    result.put("[Lar.com.cristal.creditos.client.dto.MedioContactoDTO;/3943193510", new ar.com.cristal.creditos.client.dto.MedioContactoDTO_Array_Rank_1_FieldSerializer.Handler());
    result.put("ar.com.cristal.creditos.client.dto.ReporteDTO/2439882081", new ar.com.cristal.creditos.client.dto.ReporteDTO_FieldSerializer.Handler());
    result.put("ar.com.cristal.creditos.client.dto.SucursalDTO/391370096", new ar.com.cristal.creditos.client.dto.SucursalDTO_FieldSerializer.Handler());
    result.put("[Lar.com.cristal.creditos.client.dto.SucursalDTO;/4203355625", new ar.com.cristal.creditos.client.dto.SucursalDTO_Array_Rank_1_FieldSerializer.Handler());
    result.put("ar.com.cristal.creditos.client.dto.TablaDTO/422271071", new ar.com.cristal.creditos.client.dto.TablaDTO_FieldSerializer.Handler());
    result.put("[Lar.com.cristal.creditos.client.dto.TablaDTO;/3458133905", new ar.com.cristal.creditos.client.dto.TablaDTO_Array_Rank_1_FieldSerializer.Handler());
    result.put("ar.com.cristal.creditos.client.dto.TemplateDTO/2957827815", new ar.com.cristal.creditos.client.dto.TemplateDTO_FieldSerializer.Handler());
    result.put("[Lar.com.cristal.creditos.client.dto.TemplateDTO;/2568169495", new ar.com.cristal.creditos.client.dto.TemplateDTO_Array_Rank_1_FieldSerializer.Handler());
    result.put("ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO/1568102849", new ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO_FieldSerializer.Handler());
    result.put("[Lar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO;/1651989439", new ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO_Array_Rank_1_FieldSerializer.Handler());
    result.put("ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO/416314937", new ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO_FieldSerializer.Handler());
    result.put("[Lar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO;/1461749132", new ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO_Array_Rank_1_FieldSerializer.Handler());
    result.put("ar.com.cristal.creditos.client.dto.TipoReporteDTO/3440181086", new ar.com.cristal.creditos.client.dto.TipoReporteDTO_FieldSerializer.Handler());
    result.put("[Lar.com.cristal.creditos.client.dto.TipoReporteDTO;/611028180", new ar.com.cristal.creditos.client.dto.TipoReporteDTO_Array_Rank_1_FieldSerializer.Handler());
    result.put("ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO/4057573843", new ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO_FieldSerializer.Handler());
    result.put("[Lar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO;/2093729984", new ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO_Array_Rank_1_FieldSerializer.Handler());
    result.put("ar.com.cristal.creditos.client.localidad.LocalidadDTO/2789612882", new ar.com.cristal.creditos.client.localidad.LocalidadDTO_FieldSerializer.Handler());
    result.put("[Lar.com.cristal.creditos.client.localidad.LocalidadDTO;/4260027851", new ar.com.cristal.creditos.client.localidad.LocalidadDTO_Array_Rank_1_FieldSerializer.Handler());
    result.put("ar.com.cristal.creditos.client.localidad.ProvinciaDTO/465194783", new ar.com.cristal.creditos.client.localidad.ProvinciaDTO_FieldSerializer.Handler());
    result.put("[Lar.com.cristal.creditos.client.localidad.ProvinciaDTO;/1544639041", new ar.com.cristal.creditos.client.localidad.ProvinciaDTO_Array_Rank_1_FieldSerializer.Handler());
    result.put("ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO/3852725950", new ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO_FieldSerializer.Handler());
    result.put("[Lar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO;/2330493543", new ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO_Array_Rank_1_FieldSerializer.Handler());
    result.put("ar.com.snoop.gwt.commons.client.dto.IdName/2316885078", new ar.com.snoop.gwt.commons.client.dto.IdName_FieldSerializer.Handler());
    result.put("[Lar.com.snoop.gwt.commons.client.dto.IdName;/2981353357", new ar.com.snoop.gwt.commons.client.dto.IdName_Array_Rank_1_FieldSerializer.Handler());
    result.put("[Lar.com.snoop.gwt.commons.client.dto.ListBoxItem;/1294146406", new ar.com.snoop.gwt.commons.client.dto.ListBoxItem_Array_Rank_1_FieldSerializer.Handler());
    result.put("ar.com.snoop.gwt.commons.client.dto.ValueName/703560471", new ar.com.snoop.gwt.commons.client.dto.ValueName_FieldSerializer.Handler());
    result.put("[Lar.com.snoop.gwt.commons.client.dto.ValueName;/3344507399", new ar.com.snoop.gwt.commons.client.dto.ValueName_Array_Rank_1_FieldSerializer.Handler());
    result.put("ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages/259591088", new ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages_FieldSerializer.Handler());
    result.put("ar.com.snoop.gwt.commons.client.service.CallListenerCollection/3395236877", new ar.com.snoop.gwt.commons.client.service.CallListenerCollection_FieldSerializer.Handler());
    result.put("[Lar.com.snoop.gwt.commons.client.service.CallListenerCollection;/3923857391", new ar.com.snoop.gwt.commons.client.service.CallListenerCollection_Array_Rank_1_FieldSerializer.Handler());
    result.put("ar.com.snoop.gwt.commons.client.util.AsyncCallbackWithTimeout$TimeOutException/1686082547", new ar.com.snoop.gwt.commons.client.util.AsyncCallbackWithTimeout_TimeOutException_FieldSerializer.Handler());
    result.put("com.google.gwt.http.client.RequestException/190587325", new com.google.gwt.http.client.RequestException_FieldSerializer.Handler());
    result.put("com.google.gwt.i18n.client.impl.DateRecord/112389920", new com.google.gwt.i18n.client.impl.DateRecord_FieldSerializer.Handler());
    result.put("com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533", new com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer.Handler());
    result.put("com.google.gwt.user.client.rpc.SerializableException/3047383460", new com.google.gwt.user.client.rpc.SerializableException_FieldSerializer.Handler());
    result.put("com.google.gwt.user.client.rpc.SerializationException/2836333220", new com.google.gwt.user.client.rpc.SerializationException_FieldSerializer.Handler());
    result.put("com.google.gwt.user.client.rpc.ServiceDefTarget$NoServiceEntryPointSpecifiedException/3408313447", new com.google.gwt.user.client.rpc.ServiceDefTarget_NoServiceEntryPointSpecifiedException_FieldSerializer.Handler());
    result.put("com.google.gwt.user.client.ui.ChangeListenerCollection/687647911", new com.google.gwt.user.client.ui.ChangeListenerCollection_FieldSerializer.Handler());
    result.put("com.google.gwt.user.client.ui.ClickListenerCollection/3821115695", new com.google.gwt.user.client.ui.ClickListenerCollection_FieldSerializer.Handler());
    result.put("com.google.gwt.user.client.ui.FocusListenerCollection/666063950", new com.google.gwt.user.client.ui.FocusListenerCollection_FieldSerializer.Handler());
    result.put("com.google.gwt.user.client.ui.KeyboardListenerCollection/1999488875", new com.google.gwt.user.client.ui.KeyboardListenerCollection_FieldSerializer.Handler());
    result.put("java.io.IOException/1159940531", new com.google.gwt.user.client.rpc.core.java.io.IOException_FieldSerializer.Handler());
    result.put("java.io.UnsupportedEncodingException/1526756933", new com.google.gwt.user.client.rpc.core.java.io.UnsupportedEncodingException_FieldSerializer.Handler());
    result.put("java.lang.ArithmeticException/1539622151", new com.google.gwt.user.client.rpc.core.java.lang.ArithmeticException_FieldSerializer.Handler());
    result.put("java.lang.ArrayIndexOutOfBoundsException/600550433", new com.google.gwt.user.client.rpc.core.java.lang.ArrayIndexOutOfBoundsException_FieldSerializer.Handler());
    result.put("java.lang.ArrayStoreException/3540507190", new com.google.gwt.user.client.rpc.core.java.lang.ArrayStoreException_FieldSerializer.Handler());
    result.put("java.lang.Boolean/476441737", new com.google.gwt.user.client.rpc.core.java.lang.Boolean_FieldSerializer.Handler());
    result.put("java.lang.ClassCastException/702295179", new com.google.gwt.user.client.rpc.core.java.lang.ClassCastException_FieldSerializer.Handler());
    result.put("java.lang.Double/858496421", new com.google.gwt.user.client.rpc.core.java.lang.Double_FieldSerializer.Handler());
    result.put("java.lang.Exception/1920171873", new com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.Handler());
    result.put("java.lang.IllegalArgumentException/1755012560", new com.google.gwt.user.client.rpc.core.java.lang.IllegalArgumentException_FieldSerializer.Handler());
    result.put("java.lang.IllegalStateException/1972187323", new com.google.gwt.user.client.rpc.core.java.lang.IllegalStateException_FieldSerializer.Handler());
    result.put("java.lang.IndexOutOfBoundsException/2489527753", new com.google.gwt.user.client.rpc.core.java.lang.IndexOutOfBoundsException_FieldSerializer.Handler());
    result.put("java.lang.Integer/3438268394", new com.google.gwt.user.client.rpc.core.java.lang.Integer_FieldSerializer.Handler());
    result.put("java.lang.Long/4227064769", new com.google.gwt.user.client.rpc.core.java.lang.Long_FieldSerializer.Handler());
    result.put("[Ljava.lang.Long;/97727328", new com.google.gwt.user.client.rpc.core.java.lang.Long_Array_Rank_1_FieldSerializer.Handler());
    result.put("java.lang.NegativeArraySizeException/3846860241", new com.google.gwt.user.client.rpc.core.java.lang.NegativeArraySizeException_FieldSerializer.Handler());
    result.put("java.lang.NullPointerException/1463492344", new com.google.gwt.user.client.rpc.core.java.lang.NullPointerException_FieldSerializer.Handler());
    result.put("java.lang.NumberFormatException/3305228476", new com.google.gwt.user.client.rpc.core.java.lang.NumberFormatException_FieldSerializer.Handler());
    result.put("java.lang.RuntimeException/515124647", new com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.Handler());
    result.put("java.lang.String/2004016611", new com.google.gwt.user.client.rpc.core.java.lang.String_FieldSerializer.Handler());
    result.put("java.lang.StringIndexOutOfBoundsException/500777603", new com.google.gwt.user.client.rpc.core.java.lang.StringIndexOutOfBoundsException_FieldSerializer.Handler());
    result.put("[Ljava.lang.String;/2600011424", new com.google.gwt.user.client.rpc.core.java.lang.String_Array_Rank_1_FieldSerializer.Handler());
    result.put("java.lang.UnsupportedOperationException/3744010015", new com.google.gwt.user.client.rpc.core.java.lang.UnsupportedOperationException_FieldSerializer.Handler());
    result.put("java.lang.annotation.AnnotationTypeMismatchException/976205828", new com.google.gwt.user.client.rpc.core.java.lang.annotation.AnnotationTypeMismatchException_FieldSerializer.Handler());
    result.put("java.security.DigestException/629316798", new com.google.gwt.user.client.rpc.core.java.security.DigestException_FieldSerializer.Handler());
    result.put("java.security.GeneralSecurityException/2669239907", new com.google.gwt.user.client.rpc.core.java.security.GeneralSecurityException_FieldSerializer.Handler());
    result.put("java.security.NoSuchAlgorithmException/2892037213", new com.google.gwt.user.client.rpc.core.java.security.NoSuchAlgorithmException_FieldSerializer.Handler());
    result.put("java.sql.Date/3996530531", new com.google.gwt.user.client.rpc.core.java.sql.Date_FieldSerializer.Handler());
    result.put("java.sql.Time/831929183", new com.google.gwt.user.client.rpc.core.java.sql.Time_FieldSerializer.Handler());
    result.put("java.sql.Timestamp/1769758459", new com.google.gwt.user.client.rpc.core.java.sql.Timestamp_FieldSerializer.Handler());
    result.put("[Ljava.util.AbstractList;/727920111", new com.google.gwt.user.client.rpc.core.java.util.AbstractList_Array_Rank_1_FieldSerializer.Handler());
    result.put("[Ljava.util.AbstractSequentialList;/3144020509", new com.google.gwt.user.client.rpc.core.java.util.AbstractSequentialList_Array_Rank_1_FieldSerializer.Handler());
    result.put("java.util.ArrayList/3821976829", new com.google.gwt.user.client.rpc.core.java.util.ArrayList_FieldSerializer.Handler());
    result.put("[Ljava.util.ArrayList;/2672211863", new com.google.gwt.user.client.rpc.core.java.util.ArrayList_Array_Rank_1_FieldSerializer.Handler());
    result.put("java.util.Arrays$ArrayList/1243019747", new com.google.gwt.user.client.rpc.core.java.util.Arrays_ArrayList_FieldSerializer.Handler());
    result.put("java.util.Collections$EmptyList/3012082351", new com.google.gwt.user.client.rpc.core.java.util.Collections_EmptyList_FieldSerializer.Handler());
    result.put("java.util.Collections$EmptyMap/2636129644", new com.google.gwt.user.client.rpc.core.java.util.Collections_EmptyMap_FieldSerializer.Handler());
    result.put("java.util.Collections$SingletonList/833432284", new com.google.gwt.user.client.rpc.core.java.util.Collections_SingletonList_FieldSerializer.Handler());
    result.put("java.util.ConcurrentModificationException/2717383897", new com.google.gwt.user.client.rpc.core.java.util.ConcurrentModificationException_FieldSerializer.Handler());
    result.put("java.util.Date/1659716317", new com.google.gwt.user.client.rpc.core.java.util.Date_FieldSerializer.Handler());
    result.put("java.util.EmptyStackException/89438517", new com.google.gwt.user.client.rpc.core.java.util.EmptyStackException_FieldSerializer.Handler());
    result.put("java.util.HashMap/962170901", new com.google.gwt.user.client.rpc.core.java.util.HashMap_FieldSerializer.Handler());
    result.put("java.util.IdentityHashMap/3881143367", new com.google.gwt.user.client.rpc.core.java.util.IdentityHashMap_FieldSerializer.Handler());
    result.put("java.util.LinkedHashMap/1551059846", new com.google.gwt.user.client.rpc.core.java.util.LinkedHashMap_FieldSerializer.Handler());
    result.put("java.util.LinkedList/1060625595", new com.google.gwt.user.client.rpc.core.java.util.LinkedList_FieldSerializer.Handler());
    result.put("[Ljava.util.LinkedList;/4144402753", new com.google.gwt.user.client.rpc.core.java.util.LinkedList_Array_Rank_1_FieldSerializer.Handler());
    result.put("[Ljava.util.List;/2827171268", new com.google.gwt.user.client.rpc.core.java.util.List_Array_Rank_1_FieldSerializer.Handler());
    result.put("java.util.NoSuchElementException/1559248883", new com.google.gwt.user.client.rpc.core.java.util.NoSuchElementException_FieldSerializer.Handler());
    result.put("java.util.Stack/1031431137", new com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer.Handler());
    result.put("[Ljava.util.Stack;/850422574", new com.google.gwt.user.client.rpc.core.java.util.Stack_Array_Rank_1_FieldSerializer.Handler());
    result.put("java.util.TooManyListenersException/2023078032", new com.google.gwt.user.client.rpc.core.java.util.TooManyListenersException_FieldSerializer.Handler());
    result.put("java.util.TreeMap/1575826026", new com.google.gwt.user.client.rpc.core.java.util.TreeMap_FieldSerializer.Handler());
    result.put("java.util.Vector/3125574444", new com.google.gwt.user.client.rpc.core.java.util.Vector_FieldSerializer.Handler());
    result.put("[Ljava.util.Vector;/3309436523", new com.google.gwt.user.client.rpc.core.java.util.Vector_Array_Rank_1_FieldSerializer.Handler());
    return result;
  }
  
  @SuppressWarnings("deprecation")
  private static native MethodMap loadMethodsNative() /*-{
    var result = {};
    result["ar.com.cristal.creditos.client.accesibilidad.PerfilesDto/1382345195"] = [
        @ar.com.cristal.creditos.client.accesibilidad.PerfilesDto_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.accesibilidad.PerfilesDto_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/accesibilidad/PerfilesDto;),
      ];
    
    result["[Lar.com.cristal.creditos.client.accesibilidad.PerfilesDto;/2267895133"] = [
        @ar.com.cristal.creditos.client.accesibilidad.PerfilesDto_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.accesibilidad.PerfilesDto_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lar/com/cristal/creditos/client/accesibilidad/PerfilesDto;),
      ];
    
    result["ar.com.cristal.creditos.client.clientes.busqueda.detalle.DatosOperacionesHistorialCreditosClienteDTO/3961592710"] = [
        @ar.com.cristal.creditos.client.clientes.busqueda.detalle.DatosOperacionesHistorialCreditosClienteDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.clientes.busqueda.detalle.DatosOperacionesHistorialCreditosClienteDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/clientes/busqueda/detalle/DatosOperacionesHistorialCreditosClienteDTO;),
      ];
    
    result["ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO/3037036523"] = [
        @ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/clientes/busqueda/detalle/LineaOperacionesHistorialCreditosClienteDTO;),
      ];
    
    result["ar.com.cristal.creditos.client.dto.ClienteDTO/2095328581"] = [
        @ar.com.cristal.creditos.client.dto.ClienteDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.ClienteDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/dto/ClienteDTO;),
        @ar.com.cristal.creditos.client.dto.ClienteDTO_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lar/com/cristal/creditos/client/dto/ClienteDTO;)
      ];
    
    result["[Lar.com.cristal.creditos.client.dto.ClienteDTO;/2414100404"] = [
        @ar.com.cristal.creditos.client.dto.ClienteDTO_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.ClienteDTO_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lar/com/cristal/creditos/client/dto/ClienteDTO;),
      ];
    
    result["ar.com.cristal.creditos.client.dto.DTO/188801063"] = [
        @ar.com.cristal.creditos.client.dto.DTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.DTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/dto/DTO;),
        @ar.com.cristal.creditos.client.dto.DTO_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lar/com/cristal/creditos/client/dto/DTO;)
      ];
    
    result["ar.com.cristal.creditos.client.dto.DatoAnexoDTO/684498257"] = [
        @ar.com.cristal.creditos.client.dto.DatoAnexoDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.DatoAnexoDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/dto/DatoAnexoDTO;),
      ];
    
    result["ar.com.cristal.creditos.client.dto.EmpresaDTO/2860350642"] = [
        @ar.com.cristal.creditos.client.dto.EmpresaDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.EmpresaDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/dto/EmpresaDTO;),
        @ar.com.cristal.creditos.client.dto.EmpresaDTO_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lar/com/cristal/creditos/client/dto/EmpresaDTO;)
      ];
    
    result["[Lar.com.cristal.creditos.client.dto.EmpresaDTO;/3910318810"] = [
        @ar.com.cristal.creditos.client.dto.EmpresaDTO_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.EmpresaDTO_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lar/com/cristal/creditos/client/dto/EmpresaDTO;),
      ];
    
    result["ar.com.cristal.creditos.client.dto.EstadoLineaMovimientoEnumDTO/2162181107"] = [
        @ar.com.cristal.creditos.client.dto.EstadoLineaMovimientoEnumDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.EstadoLineaMovimientoEnumDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/dto/EstadoLineaMovimientoEnumDTO;),
      ];
    
    result["[Lar.com.cristal.creditos.client.dto.EstadoLineaMovimientoEnumDTO;/969081028"] = [
        @ar.com.cristal.creditos.client.dto.EstadoLineaMovimientoEnumDTO_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.EstadoLineaMovimientoEnumDTO_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lar/com/cristal/creditos/client/dto/EstadoLineaMovimientoEnumDTO;),
      ];
    
    result["ar.com.cristal.creditos.client.dto.MedioContactoDTO/3170001166"] = [
        @ar.com.cristal.creditos.client.dto.MedioContactoDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.MedioContactoDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/dto/MedioContactoDTO;),
      ];
    
    result["[Lar.com.cristal.creditos.client.dto.MedioContactoDTO;/3943193510"] = [
        @ar.com.cristal.creditos.client.dto.MedioContactoDTO_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.MedioContactoDTO_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lar/com/cristal/creditos/client/dto/MedioContactoDTO;),
      ];
    
    result["ar.com.cristal.creditos.client.dto.ReporteDTO/2439882081"] = [
        @ar.com.cristal.creditos.client.dto.ReporteDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.ReporteDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/dto/ReporteDTO;),
      ];
    
    result["ar.com.cristal.creditos.client.dto.SucursalDTO/391370096"] = [
        @ar.com.cristal.creditos.client.dto.SucursalDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.SucursalDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/dto/SucursalDTO;),
        @ar.com.cristal.creditos.client.dto.SucursalDTO_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lar/com/cristal/creditos/client/dto/SucursalDTO;)
      ];
    
    result["[Lar.com.cristal.creditos.client.dto.SucursalDTO;/4203355625"] = [
        @ar.com.cristal.creditos.client.dto.SucursalDTO_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.SucursalDTO_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lar/com/cristal/creditos/client/dto/SucursalDTO;),
      ];
    
    result["ar.com.cristal.creditos.client.dto.TablaDTO/422271071"] = [
        @ar.com.cristal.creditos.client.dto.TablaDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.TablaDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/dto/TablaDTO;),
      ];
    
    result["[Lar.com.cristal.creditos.client.dto.TablaDTO;/3458133905"] = [
        @ar.com.cristal.creditos.client.dto.TablaDTO_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.TablaDTO_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lar/com/cristal/creditos/client/dto/TablaDTO;),
      ];
    
    result["ar.com.cristal.creditos.client.dto.TemplateDTO/2957827815"] = [
        @ar.com.cristal.creditos.client.dto.TemplateDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.TemplateDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/dto/TemplateDTO;),
      ];
    
    result["[Lar.com.cristal.creditos.client.dto.TemplateDTO;/2568169495"] = [
        @ar.com.cristal.creditos.client.dto.TemplateDTO_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.TemplateDTO_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lar/com/cristal/creditos/client/dto/TemplateDTO;),
      ];
    
    result["ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO/1568102849"] = [
        @ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/dto/TipoExistenciaEnumDTO;),
      ];
    
    result["[Lar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO;/1651989439"] = [
        @ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lar/com/cristal/creditos/client/dto/TipoExistenciaEnumDTO;),
      ];
    
    result["ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO/416314937"] = [
        @ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/dto/TipoLineaMovimientoEnumDTO;),
      ];
    
    result["[Lar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO;/1461749132"] = [
        @ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lar/com/cristal/creditos/client/dto/TipoLineaMovimientoEnumDTO;),
      ];
    
    result["ar.com.cristal.creditos.client.dto.TipoReporteDTO/3440181086"] = [
        @ar.com.cristal.creditos.client.dto.TipoReporteDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.TipoReporteDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/dto/TipoReporteDTO;),
      ];
    
    result["[Lar.com.cristal.creditos.client.dto.TipoReporteDTO;/611028180"] = [
        @ar.com.cristal.creditos.client.dto.TipoReporteDTO_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.TipoReporteDTO_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lar/com/cristal/creditos/client/dto/TipoReporteDTO;),
      ];
    
    result["ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO/4057573843"] = [
        @ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/dto/UsuarioLogueadoDTO;),
      ];
    
    result["[Lar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO;/2093729984"] = [
        @ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lar/com/cristal/creditos/client/dto/UsuarioLogueadoDTO;),
      ];
    
    result["ar.com.cristal.creditos.client.localidad.LocalidadDTO/2789612882"] = [
        @ar.com.cristal.creditos.client.localidad.LocalidadDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.localidad.LocalidadDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/localidad/LocalidadDTO;),
        @ar.com.cristal.creditos.client.localidad.LocalidadDTO_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lar/com/cristal/creditos/client/localidad/LocalidadDTO;)
      ];
    
    result["[Lar.com.cristal.creditos.client.localidad.LocalidadDTO;/4260027851"] = [
        @ar.com.cristal.creditos.client.localidad.LocalidadDTO_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.localidad.LocalidadDTO_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lar/com/cristal/creditos/client/localidad/LocalidadDTO;),
      ];
    
    result["ar.com.cristal.creditos.client.localidad.ProvinciaDTO/465194783"] = [
        @ar.com.cristal.creditos.client.localidad.ProvinciaDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.localidad.ProvinciaDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/localidad/ProvinciaDTO;),
        @ar.com.cristal.creditos.client.localidad.ProvinciaDTO_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lar/com/cristal/creditos/client/localidad/ProvinciaDTO;)
      ];
    
    result["[Lar.com.cristal.creditos.client.localidad.ProvinciaDTO;/1544639041"] = [
        @ar.com.cristal.creditos.client.localidad.ProvinciaDTO_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.localidad.ProvinciaDTO_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lar/com/cristal/creditos/client/localidad/ProvinciaDTO;),
      ];
    
    result["ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO/3852725950"] = [
        @ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/cristal/creditos/client/ui/usuarios/dto/UsuarioDTO;),
      ];
    
    result["[Lar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO;/2330493543"] = [
        @ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lar/com/cristal/creditos/client/ui/usuarios/dto/UsuarioDTO;),
      ];
    
    result["ar.com.snoop.gwt.commons.client.dto.IdName/2316885078"] = [
        @ar.com.snoop.gwt.commons.client.dto.IdName_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.snoop.gwt.commons.client.dto.IdName_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/snoop/gwt/commons/client/dto/IdName;),
      ];
    
    result["[Lar.com.snoop.gwt.commons.client.dto.IdName;/2981353357"] = [
        @ar.com.snoop.gwt.commons.client.dto.IdName_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.snoop.gwt.commons.client.dto.IdName_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lar/com/snoop/gwt/commons/client/dto/IdName;),
      ];
    
    result["[Lar.com.snoop.gwt.commons.client.dto.ListBoxItem;/1294146406"] = [
        @ar.com.snoop.gwt.commons.client.dto.ListBoxItem_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.snoop.gwt.commons.client.dto.ListBoxItem_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lar/com/snoop/gwt/commons/client/dto/ListBoxItem;),
      ];
    
    result["ar.com.snoop.gwt.commons.client.dto.ValueName/703560471"] = [
        @ar.com.snoop.gwt.commons.client.dto.ValueName_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.snoop.gwt.commons.client.dto.ValueName_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/snoop/gwt/commons/client/dto/ValueName;),
      ];
    
    result["[Lar.com.snoop.gwt.commons.client.dto.ValueName;/3344507399"] = [
        @ar.com.snoop.gwt.commons.client.dto.ValueName_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.snoop.gwt.commons.client.dto.ValueName_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lar/com/snoop/gwt/commons/client/dto/ValueName;),
      ];
    
    result["ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages/259591088"] = [
        @ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/snoop/gwt/commons/client/exception/RpcExceptionMessages;),
      ];
    
    result["ar.com.snoop.gwt.commons.client.service.CallListenerCollection/3395236877"] = [
        @ar.com.snoop.gwt.commons.client.service.CallListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.snoop.gwt.commons.client.service.CallListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/snoop/gwt/commons/client/service/CallListenerCollection;),
        @ar.com.snoop.gwt.commons.client.service.CallListenerCollection_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lar/com/snoop/gwt/commons/client/service/CallListenerCollection;)
      ];
    
    result["[Lar.com.snoop.gwt.commons.client.service.CallListenerCollection;/3923857391"] = [
        @ar.com.snoop.gwt.commons.client.service.CallListenerCollection_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.snoop.gwt.commons.client.service.CallListenerCollection_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lar/com/snoop/gwt/commons/client/service/CallListenerCollection;),
      ];
    
    result["ar.com.snoop.gwt.commons.client.util.AsyncCallbackWithTimeout$TimeOutException/1686082547"] = [
        @ar.com.snoop.gwt.commons.client.util.AsyncCallbackWithTimeout_TimeOutException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @ar.com.snoop.gwt.commons.client.util.AsyncCallbackWithTimeout_TimeOutException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lar/com/snoop/gwt/commons/client/util/AsyncCallbackWithTimeout$TimeOutException;),
      ];
    
    result["com.google.gwt.http.client.RequestException/190587325"] = [
        @com.google.gwt.http.client.RequestException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.http.client.RequestException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/http/client/RequestException;),
      ];
    
    result["com.google.gwt.i18n.client.impl.DateRecord/112389920"] = [
        @com.google.gwt.i18n.client.impl.DateRecord_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.i18n.client.impl.DateRecord_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/i18n/client/impl/DateRecord;),
        @com.google.gwt.i18n.client.impl.DateRecord_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/i18n/client/impl/DateRecord;)
      ];
    
    result["com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533"] = [
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/IncompatibleRemoteServiceException;),
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/user/client/rpc/IncompatibleRemoteServiceException;)
      ];
    
    result["com.google.gwt.user.client.rpc.SerializableException/3047383460"] = [
        @com.google.gwt.user.client.rpc.SerializableException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.SerializableException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/SerializableException;),
      ];
    
    result["com.google.gwt.user.client.rpc.SerializationException/2836333220"] = [
        @com.google.gwt.user.client.rpc.SerializationException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.SerializationException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/SerializationException;),
      ];
    
    result["com.google.gwt.user.client.rpc.ServiceDefTarget$NoServiceEntryPointSpecifiedException/3408313447"] = [
        @com.google.gwt.user.client.rpc.ServiceDefTarget_NoServiceEntryPointSpecifiedException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.ServiceDefTarget_NoServiceEntryPointSpecifiedException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/ServiceDefTarget$NoServiceEntryPointSpecifiedException;),
      ];
    
    result["com.google.gwt.user.client.ui.ChangeListenerCollection/687647911"] = [
        @com.google.gwt.user.client.ui.ChangeListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.ChangeListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/ChangeListenerCollection;),
      ];
    
    result["com.google.gwt.user.client.ui.ClickListenerCollection/3821115695"] = [
        @com.google.gwt.user.client.ui.ClickListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.ClickListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/ClickListenerCollection;),
      ];
    
    result["com.google.gwt.user.client.ui.FocusListenerCollection/666063950"] = [
        @com.google.gwt.user.client.ui.FocusListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.FocusListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/FocusListenerCollection;),
      ];
    
    result["com.google.gwt.user.client.ui.KeyboardListenerCollection/1999488875"] = [
        @com.google.gwt.user.client.ui.KeyboardListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.KeyboardListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/KeyboardListenerCollection;),
      ];
    
    result["java.io.IOException/1159940531"] = [
        @com.google.gwt.user.client.rpc.core.java.io.IOException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.io.IOException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/io/IOException;),
      ];
    
    result["java.io.UnsupportedEncodingException/1526756933"] = [
        @com.google.gwt.user.client.rpc.core.java.io.UnsupportedEncodingException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.io.UnsupportedEncodingException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/io/UnsupportedEncodingException;),
      ];
    
    result["java.lang.ArithmeticException/1539622151"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.ArithmeticException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.ArithmeticException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/ArithmeticException;),
      ];
    
    result["java.lang.ArrayIndexOutOfBoundsException/600550433"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.ArrayIndexOutOfBoundsException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.ArrayIndexOutOfBoundsException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/ArrayIndexOutOfBoundsException;),
      ];
    
    result["java.lang.ArrayStoreException/3540507190"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.ArrayStoreException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.ArrayStoreException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/ArrayStoreException;),
      ];
    
    result["java.lang.Boolean/476441737"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.Boolean_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Boolean_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Boolean;),
        @com.google.gwt.user.client.rpc.core.java.lang.Boolean_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/Boolean;)
      ];
    
    result["java.lang.ClassCastException/702295179"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.ClassCastException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.ClassCastException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/ClassCastException;),
      ];
    
    result["java.lang.Double/858496421"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.Double_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Double_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Double;),
        @com.google.gwt.user.client.rpc.core.java.lang.Double_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/Double;)
      ];
    
    result["java.lang.Exception/1920171873"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Exception;),
        @com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/Exception;)
      ];
    
    result["java.lang.IllegalArgumentException/1755012560"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.IllegalArgumentException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.IllegalArgumentException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/IllegalArgumentException;),
      ];
    
    result["java.lang.IllegalStateException/1972187323"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.IllegalStateException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.IllegalStateException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/IllegalStateException;),
      ];
    
    result["java.lang.IndexOutOfBoundsException/2489527753"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.IndexOutOfBoundsException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.IndexOutOfBoundsException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/IndexOutOfBoundsException;),
      ];
    
    result["java.lang.Integer/3438268394"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.Integer_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Integer_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Integer;),
        @com.google.gwt.user.client.rpc.core.java.lang.Integer_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/Integer;)
      ];
    
    result["java.lang.Long/4227064769"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.Long_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Long_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Long;),
        @com.google.gwt.user.client.rpc.core.java.lang.Long_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/Long;)
      ];
    
    result["[Ljava.lang.Long;/97727328"] = [
        ,
        ,
        @com.google.gwt.user.client.rpc.core.java.lang.Long_Array_Rank_1_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;[Ljava/lang/Long;)
      ];
    
    result["java.lang.NegativeArraySizeException/3846860241"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.NegativeArraySizeException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.NegativeArraySizeException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/NegativeArraySizeException;),
      ];
    
    result["java.lang.NullPointerException/1463492344"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.NullPointerException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.NullPointerException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/NullPointerException;),
      ];
    
    result["java.lang.NumberFormatException/3305228476"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.NumberFormatException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.NumberFormatException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/NumberFormatException;),
      ];
    
    result["java.lang.RuntimeException/515124647"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/RuntimeException;),
        @com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/RuntimeException;)
      ];
    
    result["java.lang.String/2004016611"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/String;),
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/String;)
      ];
    
    result["java.lang.StringIndexOutOfBoundsException/500777603"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.StringIndexOutOfBoundsException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.StringIndexOutOfBoundsException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/StringIndexOutOfBoundsException;),
      ];
    
    result["[Ljava.lang.String;/2600011424"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.String_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.String_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Ljava/lang/String;),
      ];
    
    result["java.lang.UnsupportedOperationException/3744010015"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.UnsupportedOperationException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.UnsupportedOperationException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/UnsupportedOperationException;),
      ];
    
    result["java.lang.annotation.AnnotationTypeMismatchException/976205828"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.annotation.AnnotationTypeMismatchException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.annotation.AnnotationTypeMismatchException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/annotation/AnnotationTypeMismatchException;),
      ];
    
    result["java.security.DigestException/629316798"] = [
        @com.google.gwt.user.client.rpc.core.java.security.DigestException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.security.DigestException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/security/DigestException;),
      ];
    
    result["java.security.GeneralSecurityException/2669239907"] = [
        @com.google.gwt.user.client.rpc.core.java.security.GeneralSecurityException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.security.GeneralSecurityException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/security/GeneralSecurityException;),
      ];
    
    result["java.security.NoSuchAlgorithmException/2892037213"] = [
        @com.google.gwt.user.client.rpc.core.java.security.NoSuchAlgorithmException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.security.NoSuchAlgorithmException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/security/NoSuchAlgorithmException;),
      ];
    
    result["java.sql.Date/3996530531"] = [
        @com.google.gwt.user.client.rpc.core.java.sql.Date_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.sql.Date_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/sql/Date;),
        @com.google.gwt.user.client.rpc.core.java.sql.Date_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/sql/Date;)
      ];
    
    result["java.sql.Time/831929183"] = [
        @com.google.gwt.user.client.rpc.core.java.sql.Time_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.sql.Time_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/sql/Time;),
        @com.google.gwt.user.client.rpc.core.java.sql.Time_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/sql/Time;)
      ];
    
    result["java.sql.Timestamp/1769758459"] = [
        @com.google.gwt.user.client.rpc.core.java.sql.Timestamp_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.sql.Timestamp_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/sql/Timestamp;),
        @com.google.gwt.user.client.rpc.core.java.sql.Timestamp_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/sql/Timestamp;)
      ];
    
    result["[Ljava.util.AbstractList;/727920111"] = [
        @com.google.gwt.user.client.rpc.core.java.util.AbstractList_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.AbstractList_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Ljava/util/AbstractList;),
      ];
    
    result["[Ljava.util.AbstractSequentialList;/3144020509"] = [
        @com.google.gwt.user.client.rpc.core.java.util.AbstractSequentialList_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.AbstractSequentialList_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Ljava/util/AbstractSequentialList;),
      ];
    
    result["java.util.ArrayList/3821976829"] = [
        @com.google.gwt.user.client.rpc.core.java.util.ArrayList_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.ArrayList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/ArrayList;),
        @com.google.gwt.user.client.rpc.core.java.util.ArrayList_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/ArrayList;)
      ];
    
    result["[Ljava.util.ArrayList;/2672211863"] = [
        @com.google.gwt.user.client.rpc.core.java.util.ArrayList_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.ArrayList_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Ljava/util/ArrayList;),
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
    
    result["java.util.Collections$EmptyMap/2636129644"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyMap_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyMap_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/Map;),
      ];
    
    result["java.util.Collections$SingletonList/833432284"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Collections.SingletonList_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Collections.SingletonList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/List;),
        @com.google.gwt.user.client.rpc.core.java.util.Collections.SingletonList_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/List;)
      ];
    
    result["java.util.ConcurrentModificationException/2717383897"] = [
        @com.google.gwt.user.client.rpc.core.java.util.ConcurrentModificationException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.ConcurrentModificationException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/ConcurrentModificationException;),
      ];
    
    result["java.util.Date/1659716317"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Date_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Date_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/Date;),
        @com.google.gwt.user.client.rpc.core.java.util.Date_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/Date;)
      ];
    
    result["java.util.EmptyStackException/89438517"] = [
        @com.google.gwt.user.client.rpc.core.java.util.EmptyStackException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.EmptyStackException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/EmptyStackException;),
      ];
    
    result["java.util.HashMap/962170901"] = [
        @com.google.gwt.user.client.rpc.core.java.util.HashMap_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.HashMap_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/HashMap;),
      ];
    
    result["java.util.IdentityHashMap/3881143367"] = [
        @com.google.gwt.user.client.rpc.core.java.util.IdentityHashMap_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.IdentityHashMap_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/IdentityHashMap;),
      ];
    
    result["java.util.LinkedHashMap/1551059846"] = [
        @com.google.gwt.user.client.rpc.core.java.util.LinkedHashMap_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.LinkedHashMap_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/LinkedHashMap;),
      ];
    
    result["java.util.LinkedList/1060625595"] = [
        @com.google.gwt.user.client.rpc.core.java.util.LinkedList_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.LinkedList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/LinkedList;),
        @com.google.gwt.user.client.rpc.core.java.util.LinkedList_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/LinkedList;)
      ];
    
    result["[Ljava.util.LinkedList;/4144402753"] = [
        @com.google.gwt.user.client.rpc.core.java.util.LinkedList_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.LinkedList_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Ljava/util/LinkedList;),
      ];
    
    result["[Ljava.util.List;/2827171268"] = [
        @com.google.gwt.user.client.rpc.core.java.util.List_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.List_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Ljava/util/List;),
      ];
    
    result["java.util.NoSuchElementException/1559248883"] = [
        @com.google.gwt.user.client.rpc.core.java.util.NoSuchElementException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.NoSuchElementException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/NoSuchElementException;),
      ];
    
    result["java.util.Stack/1031431137"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/Stack;),
        @com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/Stack;)
      ];
    
    result["[Ljava.util.Stack;/850422574"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Stack_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Stack_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Ljava/util/Stack;),
      ];
    
    result["java.util.TooManyListenersException/2023078032"] = [
        @com.google.gwt.user.client.rpc.core.java.util.TooManyListenersException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.TooManyListenersException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/TooManyListenersException;),
      ];
    
    result["java.util.TreeMap/1575826026"] = [
        @com.google.gwt.user.client.rpc.core.java.util.TreeMap_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.TreeMap_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/TreeMap;),
      ];
    
    result["java.util.Vector/3125574444"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Vector_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Vector_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/Vector;),
        @com.google.gwt.user.client.rpc.core.java.util.Vector_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/Vector;)
      ];
    
    result["[Ljava.util.Vector;/3309436523"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Vector_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Vector_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Ljava/util/Vector;),
      ];
    
    return result;
  }-*/;
  
  @SuppressWarnings("deprecation")
  private static Map<Class<?>, String> loadSignaturesJava() {
    Map<Class<?>, String> result = new HashMap<Class<?>, String>();
    result.put(ar.com.cristal.creditos.client.accesibilidad.PerfilesDto_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.accesibilidad.PerfilesDto/1382345195");
    result.put(ar.com.cristal.creditos.client.accesibilidad.PerfilesDto_Array_Rank_1_FieldSerializer.concreteType(), "[Lar.com.cristal.creditos.client.accesibilidad.PerfilesDto;/2267895133");
    result.put(ar.com.cristal.creditos.client.clientes.busqueda.detalle.DatosOperacionesHistorialCreditosClienteDTO_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.clientes.busqueda.detalle.DatosOperacionesHistorialCreditosClienteDTO/3961592710");
    result.put(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO/3037036523");
    result.put(ar.com.cristal.creditos.client.dto.ClienteDTO_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.dto.ClienteDTO/2095328581");
    result.put(ar.com.cristal.creditos.client.dto.ClienteDTO_Array_Rank_1_FieldSerializer.concreteType(), "[Lar.com.cristal.creditos.client.dto.ClienteDTO;/2414100404");
    result.put(ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.dto.DTO/188801063");
    result.put(ar.com.cristal.creditos.client.dto.DatoAnexoDTO_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.dto.DatoAnexoDTO/684498257");
    result.put(ar.com.cristal.creditos.client.dto.EmpresaDTO_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.dto.EmpresaDTO/2860350642");
    result.put(ar.com.cristal.creditos.client.dto.EmpresaDTO_Array_Rank_1_FieldSerializer.concreteType(), "[Lar.com.cristal.creditos.client.dto.EmpresaDTO;/3910318810");
    result.put(ar.com.cristal.creditos.client.dto.EstadoLineaMovimientoEnumDTO_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.dto.EstadoLineaMovimientoEnumDTO/2162181107");
    result.put(ar.com.cristal.creditos.client.dto.EstadoLineaMovimientoEnumDTO_Array_Rank_1_FieldSerializer.concreteType(), "[Lar.com.cristal.creditos.client.dto.EstadoLineaMovimientoEnumDTO;/969081028");
    result.put(ar.com.cristal.creditos.client.dto.MedioContactoDTO_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.dto.MedioContactoDTO/3170001166");
    result.put(ar.com.cristal.creditos.client.dto.MedioContactoDTO_Array_Rank_1_FieldSerializer.concreteType(), "[Lar.com.cristal.creditos.client.dto.MedioContactoDTO;/3943193510");
    result.put(ar.com.cristal.creditos.client.dto.ReporteDTO_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.dto.ReporteDTO/2439882081");
    result.put(ar.com.cristal.creditos.client.dto.SucursalDTO_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.dto.SucursalDTO/391370096");
    result.put(ar.com.cristal.creditos.client.dto.SucursalDTO_Array_Rank_1_FieldSerializer.concreteType(), "[Lar.com.cristal.creditos.client.dto.SucursalDTO;/4203355625");
    result.put(ar.com.cristal.creditos.client.dto.TablaDTO_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.dto.TablaDTO/422271071");
    result.put(ar.com.cristal.creditos.client.dto.TablaDTO_Array_Rank_1_FieldSerializer.concreteType(), "[Lar.com.cristal.creditos.client.dto.TablaDTO;/3458133905");
    result.put(ar.com.cristal.creditos.client.dto.TemplateDTO_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.dto.TemplateDTO/2957827815");
    result.put(ar.com.cristal.creditos.client.dto.TemplateDTO_Array_Rank_1_FieldSerializer.concreteType(), "[Lar.com.cristal.creditos.client.dto.TemplateDTO;/2568169495");
    result.put(ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO/1568102849");
    result.put(ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO_Array_Rank_1_FieldSerializer.concreteType(), "[Lar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO;/1651989439");
    result.put(ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO/416314937");
    result.put(ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO_Array_Rank_1_FieldSerializer.concreteType(), "[Lar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO;/1461749132");
    result.put(ar.com.cristal.creditos.client.dto.TipoReporteDTO_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.dto.TipoReporteDTO/3440181086");
    result.put(ar.com.cristal.creditos.client.dto.TipoReporteDTO_Array_Rank_1_FieldSerializer.concreteType(), "[Lar.com.cristal.creditos.client.dto.TipoReporteDTO;/611028180");
    result.put(ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO/4057573843");
    result.put(ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO_Array_Rank_1_FieldSerializer.concreteType(), "[Lar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO;/2093729984");
    result.put(ar.com.cristal.creditos.client.localidad.LocalidadDTO_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.localidad.LocalidadDTO/2789612882");
    result.put(ar.com.cristal.creditos.client.localidad.LocalidadDTO_Array_Rank_1_FieldSerializer.concreteType(), "[Lar.com.cristal.creditos.client.localidad.LocalidadDTO;/4260027851");
    result.put(ar.com.cristal.creditos.client.localidad.ProvinciaDTO_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.localidad.ProvinciaDTO/465194783");
    result.put(ar.com.cristal.creditos.client.localidad.ProvinciaDTO_Array_Rank_1_FieldSerializer.concreteType(), "[Lar.com.cristal.creditos.client.localidad.ProvinciaDTO;/1544639041");
    result.put(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO_FieldSerializer.concreteType(), "ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO/3852725950");
    result.put(ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO_Array_Rank_1_FieldSerializer.concreteType(), "[Lar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO;/2330493543");
    result.put(ar.com.snoop.gwt.commons.client.dto.IdName_FieldSerializer.concreteType(), "ar.com.snoop.gwt.commons.client.dto.IdName/2316885078");
    result.put(ar.com.snoop.gwt.commons.client.dto.IdName_Array_Rank_1_FieldSerializer.concreteType(), "[Lar.com.snoop.gwt.commons.client.dto.IdName;/2981353357");
    result.put(ar.com.snoop.gwt.commons.client.dto.ListBoxItem_Array_Rank_1_FieldSerializer.concreteType(), "[Lar.com.snoop.gwt.commons.client.dto.ListBoxItem;/1294146406");
    result.put(ar.com.snoop.gwt.commons.client.dto.ValueName_FieldSerializer.concreteType(), "ar.com.snoop.gwt.commons.client.dto.ValueName/703560471");
    result.put(ar.com.snoop.gwt.commons.client.dto.ValueName_Array_Rank_1_FieldSerializer.concreteType(), "[Lar.com.snoop.gwt.commons.client.dto.ValueName;/3344507399");
    result.put(ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages_FieldSerializer.concreteType(), "ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages/259591088");
    result.put(ar.com.snoop.gwt.commons.client.service.CallListenerCollection_FieldSerializer.concreteType(), "ar.com.snoop.gwt.commons.client.service.CallListenerCollection/3395236877");
    result.put(ar.com.snoop.gwt.commons.client.service.CallListenerCollection_Array_Rank_1_FieldSerializer.concreteType(), "[Lar.com.snoop.gwt.commons.client.service.CallListenerCollection;/3923857391");
    result.put(ar.com.snoop.gwt.commons.client.util.AsyncCallbackWithTimeout_TimeOutException_FieldSerializer.concreteType(), "ar.com.snoop.gwt.commons.client.util.AsyncCallbackWithTimeout$TimeOutException/1686082547");
    result.put(com.google.gwt.http.client.RequestException_FieldSerializer.concreteType(), "com.google.gwt.http.client.RequestException/190587325");
    result.put(com.google.gwt.i18n.client.impl.DateRecord_FieldSerializer.concreteType(), "com.google.gwt.i18n.client.impl.DateRecord/112389920");
    result.put(com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer.concreteType(), "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533");
    result.put(com.google.gwt.user.client.rpc.SerializableException_FieldSerializer.concreteType(), "com.google.gwt.user.client.rpc.SerializableException/3047383460");
    result.put(com.google.gwt.user.client.rpc.SerializationException_FieldSerializer.concreteType(), "com.google.gwt.user.client.rpc.SerializationException/2836333220");
    result.put(com.google.gwt.user.client.rpc.ServiceDefTarget_NoServiceEntryPointSpecifiedException_FieldSerializer.concreteType(), "com.google.gwt.user.client.rpc.ServiceDefTarget$NoServiceEntryPointSpecifiedException/3408313447");
    result.put(com.google.gwt.user.client.ui.ChangeListenerCollection_FieldSerializer.concreteType(), "com.google.gwt.user.client.ui.ChangeListenerCollection/687647911");
    result.put(com.google.gwt.user.client.ui.ClickListenerCollection_FieldSerializer.concreteType(), "com.google.gwt.user.client.ui.ClickListenerCollection/3821115695");
    result.put(com.google.gwt.user.client.ui.FocusListenerCollection_FieldSerializer.concreteType(), "com.google.gwt.user.client.ui.FocusListenerCollection/666063950");
    result.put(com.google.gwt.user.client.ui.KeyboardListenerCollection_FieldSerializer.concreteType(), "com.google.gwt.user.client.ui.KeyboardListenerCollection/1999488875");
    result.put(com.google.gwt.user.client.rpc.core.java.io.IOException_FieldSerializer.concreteType(), "java.io.IOException/1159940531");
    result.put(com.google.gwt.user.client.rpc.core.java.io.UnsupportedEncodingException_FieldSerializer.concreteType(), "java.io.UnsupportedEncodingException/1526756933");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.ArithmeticException_FieldSerializer.concreteType(), "java.lang.ArithmeticException/1539622151");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.ArrayIndexOutOfBoundsException_FieldSerializer.concreteType(), "java.lang.ArrayIndexOutOfBoundsException/600550433");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.ArrayStoreException_FieldSerializer.concreteType(), "java.lang.ArrayStoreException/3540507190");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.Boolean_FieldSerializer.concreteType(), "java.lang.Boolean/476441737");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.ClassCastException_FieldSerializer.concreteType(), "java.lang.ClassCastException/702295179");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.Double_FieldSerializer.concreteType(), "java.lang.Double/858496421");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.concreteType(), "java.lang.Exception/1920171873");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.IllegalArgumentException_FieldSerializer.concreteType(), "java.lang.IllegalArgumentException/1755012560");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.IllegalStateException_FieldSerializer.concreteType(), "java.lang.IllegalStateException/1972187323");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.IndexOutOfBoundsException_FieldSerializer.concreteType(), "java.lang.IndexOutOfBoundsException/2489527753");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.Integer_FieldSerializer.concreteType(), "java.lang.Integer/3438268394");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.Long_FieldSerializer.concreteType(), "java.lang.Long/4227064769");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.Long_Array_Rank_1_FieldSerializer.concreteType(), "[Ljava.lang.Long;/97727328");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.NegativeArraySizeException_FieldSerializer.concreteType(), "java.lang.NegativeArraySizeException/3846860241");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.NullPointerException_FieldSerializer.concreteType(), "java.lang.NullPointerException/1463492344");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.NumberFormatException_FieldSerializer.concreteType(), "java.lang.NumberFormatException/3305228476");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.concreteType(), "java.lang.RuntimeException/515124647");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.String_FieldSerializer.concreteType(), "java.lang.String/2004016611");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.StringIndexOutOfBoundsException_FieldSerializer.concreteType(), "java.lang.StringIndexOutOfBoundsException/500777603");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.String_Array_Rank_1_FieldSerializer.concreteType(), "[Ljava.lang.String;/2600011424");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.UnsupportedOperationException_FieldSerializer.concreteType(), "java.lang.UnsupportedOperationException/3744010015");
    result.put(com.google.gwt.user.client.rpc.core.java.lang.annotation.AnnotationTypeMismatchException_FieldSerializer.concreteType(), "java.lang.annotation.AnnotationTypeMismatchException/976205828");
    result.put(com.google.gwt.user.client.rpc.core.java.security.DigestException_FieldSerializer.concreteType(), "java.security.DigestException/629316798");
    result.put(com.google.gwt.user.client.rpc.core.java.security.GeneralSecurityException_FieldSerializer.concreteType(), "java.security.GeneralSecurityException/2669239907");
    result.put(com.google.gwt.user.client.rpc.core.java.security.NoSuchAlgorithmException_FieldSerializer.concreteType(), "java.security.NoSuchAlgorithmException/2892037213");
    result.put(com.google.gwt.user.client.rpc.core.java.sql.Date_FieldSerializer.concreteType(), "java.sql.Date/3996530531");
    result.put(com.google.gwt.user.client.rpc.core.java.sql.Time_FieldSerializer.concreteType(), "java.sql.Time/831929183");
    result.put(com.google.gwt.user.client.rpc.core.java.sql.Timestamp_FieldSerializer.concreteType(), "java.sql.Timestamp/1769758459");
    result.put(com.google.gwt.user.client.rpc.core.java.util.AbstractList_Array_Rank_1_FieldSerializer.concreteType(), "[Ljava.util.AbstractList;/727920111");
    result.put(com.google.gwt.user.client.rpc.core.java.util.AbstractSequentialList_Array_Rank_1_FieldSerializer.concreteType(), "[Ljava.util.AbstractSequentialList;/3144020509");
    result.put(com.google.gwt.user.client.rpc.core.java.util.ArrayList_FieldSerializer.concreteType(), "java.util.ArrayList/3821976829");
    result.put(com.google.gwt.user.client.rpc.core.java.util.ArrayList_Array_Rank_1_FieldSerializer.concreteType(), "[Ljava.util.ArrayList;/2672211863");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Arrays.ArrayList_CustomFieldSerializer.concreteType(), "java.util.Arrays$ArrayList/1243019747");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyList_CustomFieldSerializer.concreteType(), "java.util.Collections$EmptyList/3012082351");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyMap_CustomFieldSerializer.concreteType(), "java.util.Collections$EmptyMap/2636129644");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Collections.SingletonList_CustomFieldSerializer.concreteType(), "java.util.Collections$SingletonList/833432284");
    result.put(com.google.gwt.user.client.rpc.core.java.util.ConcurrentModificationException_FieldSerializer.concreteType(), "java.util.ConcurrentModificationException/2717383897");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Date_FieldSerializer.concreteType(), "java.util.Date/1659716317");
    result.put(com.google.gwt.user.client.rpc.core.java.util.EmptyStackException_FieldSerializer.concreteType(), "java.util.EmptyStackException/89438517");
    result.put(com.google.gwt.user.client.rpc.core.java.util.HashMap_FieldSerializer.concreteType(), "java.util.HashMap/962170901");
    result.put(com.google.gwt.user.client.rpc.core.java.util.IdentityHashMap_FieldSerializer.concreteType(), "java.util.IdentityHashMap/3881143367");
    result.put(com.google.gwt.user.client.rpc.core.java.util.LinkedHashMap_FieldSerializer.concreteType(), "java.util.LinkedHashMap/1551059846");
    result.put(com.google.gwt.user.client.rpc.core.java.util.LinkedList_FieldSerializer.concreteType(), "java.util.LinkedList/1060625595");
    result.put(com.google.gwt.user.client.rpc.core.java.util.LinkedList_Array_Rank_1_FieldSerializer.concreteType(), "[Ljava.util.LinkedList;/4144402753");
    result.put(com.google.gwt.user.client.rpc.core.java.util.List_Array_Rank_1_FieldSerializer.concreteType(), "[Ljava.util.List;/2827171268");
    result.put(com.google.gwt.user.client.rpc.core.java.util.NoSuchElementException_FieldSerializer.concreteType(), "java.util.NoSuchElementException/1559248883");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer.concreteType(), "java.util.Stack/1031431137");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Stack_Array_Rank_1_FieldSerializer.concreteType(), "[Ljava.util.Stack;/850422574");
    result.put(com.google.gwt.user.client.rpc.core.java.util.TooManyListenersException_FieldSerializer.concreteType(), "java.util.TooManyListenersException/2023078032");
    result.put(com.google.gwt.user.client.rpc.core.java.util.TreeMap_FieldSerializer.concreteType(), "java.util.TreeMap/1575826026");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Vector_FieldSerializer.concreteType(), "java.util.Vector/3125574444");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Vector_Array_Rank_1_FieldSerializer.concreteType(), "[Ljava.util.Vector;/3309436523");
    return result;
  }
  
  @SuppressWarnings("deprecation")
  private static native JsArrayString loadSignaturesNative() /*-{
    var result = [];
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.accesibilidad.PerfilesDto::class)] = "ar.com.cristal.creditos.client.accesibilidad.PerfilesDto/1382345195";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.accesibilidad.PerfilesDto[]::class)] = "[Lar.com.cristal.creditos.client.accesibilidad.PerfilesDto;/2267895133";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.clientes.busqueda.detalle.DatosOperacionesHistorialCreditosClienteDTO::class)] = "ar.com.cristal.creditos.client.clientes.busqueda.detalle.DatosOperacionesHistorialCreditosClienteDTO/3961592710";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::class)] = "ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO/3037036523";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.ClienteDTO::class)] = "ar.com.cristal.creditos.client.dto.ClienteDTO/2095328581";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.ClienteDTO[]::class)] = "[Lar.com.cristal.creditos.client.dto.ClienteDTO;/2414100404";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.DTO::class)] = "ar.com.cristal.creditos.client.dto.DTO/188801063";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.DatoAnexoDTO::class)] = "ar.com.cristal.creditos.client.dto.DatoAnexoDTO/684498257";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.EmpresaDTO::class)] = "ar.com.cristal.creditos.client.dto.EmpresaDTO/2860350642";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.EmpresaDTO[]::class)] = "[Lar.com.cristal.creditos.client.dto.EmpresaDTO;/3910318810";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.EstadoLineaMovimientoEnumDTO::class)] = "ar.com.cristal.creditos.client.dto.EstadoLineaMovimientoEnumDTO/2162181107";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.EstadoLineaMovimientoEnumDTO[]::class)] = "[Lar.com.cristal.creditos.client.dto.EstadoLineaMovimientoEnumDTO;/969081028";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.MedioContactoDTO::class)] = "ar.com.cristal.creditos.client.dto.MedioContactoDTO/3170001166";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.MedioContactoDTO[]::class)] = "[Lar.com.cristal.creditos.client.dto.MedioContactoDTO;/3943193510";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.ReporteDTO::class)] = "ar.com.cristal.creditos.client.dto.ReporteDTO/2439882081";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.SucursalDTO::class)] = "ar.com.cristal.creditos.client.dto.SucursalDTO/391370096";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.SucursalDTO[]::class)] = "[Lar.com.cristal.creditos.client.dto.SucursalDTO;/4203355625";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.TablaDTO::class)] = "ar.com.cristal.creditos.client.dto.TablaDTO/422271071";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.TablaDTO[]::class)] = "[Lar.com.cristal.creditos.client.dto.TablaDTO;/3458133905";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.TemplateDTO::class)] = "ar.com.cristal.creditos.client.dto.TemplateDTO/2957827815";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.TemplateDTO[]::class)] = "[Lar.com.cristal.creditos.client.dto.TemplateDTO;/2568169495";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO::class)] = "ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO/1568102849";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO[]::class)] = "[Lar.com.cristal.creditos.client.dto.TipoExistenciaEnumDTO;/1651989439";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO::class)] = "ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO/416314937";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO[]::class)] = "[Lar.com.cristal.creditos.client.dto.TipoLineaMovimientoEnumDTO;/1461749132";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.TipoReporteDTO::class)] = "ar.com.cristal.creditos.client.dto.TipoReporteDTO/3440181086";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.TipoReporteDTO[]::class)] = "[Lar.com.cristal.creditos.client.dto.TipoReporteDTO;/611028180";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO::class)] = "ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO/4057573843";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO[]::class)] = "[Lar.com.cristal.creditos.client.dto.UsuarioLogueadoDTO;/2093729984";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.localidad.LocalidadDTO::class)] = "ar.com.cristal.creditos.client.localidad.LocalidadDTO/2789612882";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.localidad.LocalidadDTO[]::class)] = "[Lar.com.cristal.creditos.client.localidad.LocalidadDTO;/4260027851";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.localidad.ProvinciaDTO::class)] = "ar.com.cristal.creditos.client.localidad.ProvinciaDTO/465194783";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.localidad.ProvinciaDTO[]::class)] = "[Lar.com.cristal.creditos.client.localidad.ProvinciaDTO;/1544639041";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO::class)] = "ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO/3852725950";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO[]::class)] = "[Lar.com.cristal.creditos.client.ui.usuarios.dto.UsuarioDTO;/2330493543";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.snoop.gwt.commons.client.dto.IdName::class)] = "ar.com.snoop.gwt.commons.client.dto.IdName/2316885078";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.snoop.gwt.commons.client.dto.IdName[]::class)] = "[Lar.com.snoop.gwt.commons.client.dto.IdName;/2981353357";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.snoop.gwt.commons.client.dto.ListBoxItem[]::class)] = "[Lar.com.snoop.gwt.commons.client.dto.ListBoxItem;/1294146406";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.snoop.gwt.commons.client.dto.ValueName::class)] = "ar.com.snoop.gwt.commons.client.dto.ValueName/703560471";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.snoop.gwt.commons.client.dto.ValueName[]::class)] = "[Lar.com.snoop.gwt.commons.client.dto.ValueName;/3344507399";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages::class)] = "ar.com.snoop.gwt.commons.client.exception.RpcExceptionMessages/259591088";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.snoop.gwt.commons.client.service.CallListenerCollection::class)] = "ar.com.snoop.gwt.commons.client.service.CallListenerCollection/3395236877";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.snoop.gwt.commons.client.service.CallListenerCollection[]::class)] = "[Lar.com.snoop.gwt.commons.client.service.CallListenerCollection;/3923857391";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@ar.com.snoop.gwt.commons.client.util.AsyncCallbackWithTimeout$TimeOutException::class)] = "ar.com.snoop.gwt.commons.client.util.AsyncCallbackWithTimeout$TimeOutException/1686082547";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.http.client.RequestException::class)] = "com.google.gwt.http.client.RequestException/190587325";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.i18n.client.impl.DateRecord::class)] = "com.google.gwt.i18n.client.impl.DateRecord/112389920";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException::class)] = "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.rpc.SerializableException::class)] = "com.google.gwt.user.client.rpc.SerializableException/3047383460";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.rpc.SerializationException::class)] = "com.google.gwt.user.client.rpc.SerializationException/2836333220";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.rpc.ServiceDefTarget$NoServiceEntryPointSpecifiedException::class)] = "com.google.gwt.user.client.rpc.ServiceDefTarget$NoServiceEntryPointSpecifiedException/3408313447";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.ChangeListenerCollection::class)] = "com.google.gwt.user.client.ui.ChangeListenerCollection/687647911";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.ClickListenerCollection::class)] = "com.google.gwt.user.client.ui.ClickListenerCollection/3821115695";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.FocusListenerCollection::class)] = "com.google.gwt.user.client.ui.FocusListenerCollection/666063950";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.KeyboardListenerCollection::class)] = "com.google.gwt.user.client.ui.KeyboardListenerCollection/1999488875";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.io.IOException::class)] = "java.io.IOException/1159940531";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.io.UnsupportedEncodingException::class)] = "java.io.UnsupportedEncodingException/1526756933";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.ArithmeticException::class)] = "java.lang.ArithmeticException/1539622151";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.ArrayIndexOutOfBoundsException::class)] = "java.lang.ArrayIndexOutOfBoundsException/600550433";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.ArrayStoreException::class)] = "java.lang.ArrayStoreException/3540507190";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.Boolean::class)] = "java.lang.Boolean/476441737";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.ClassCastException::class)] = "java.lang.ClassCastException/702295179";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.Double::class)] = "java.lang.Double/858496421";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.Exception::class)] = "java.lang.Exception/1920171873";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.IllegalArgumentException::class)] = "java.lang.IllegalArgumentException/1755012560";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.IllegalStateException::class)] = "java.lang.IllegalStateException/1972187323";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.IndexOutOfBoundsException::class)] = "java.lang.IndexOutOfBoundsException/2489527753";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.Integer::class)] = "java.lang.Integer/3438268394";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.Long::class)] = "java.lang.Long/4227064769";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.Long[]::class)] = "[Ljava.lang.Long;/97727328";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.NegativeArraySizeException::class)] = "java.lang.NegativeArraySizeException/3846860241";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.NullPointerException::class)] = "java.lang.NullPointerException/1463492344";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.NumberFormatException::class)] = "java.lang.NumberFormatException/3305228476";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.RuntimeException::class)] = "java.lang.RuntimeException/515124647";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.String::class)] = "java.lang.String/2004016611";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.StringIndexOutOfBoundsException::class)] = "java.lang.StringIndexOutOfBoundsException/500777603";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.String[]::class)] = "[Ljava.lang.String;/2600011424";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.UnsupportedOperationException::class)] = "java.lang.UnsupportedOperationException/3744010015";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.annotation.AnnotationTypeMismatchException::class)] = "java.lang.annotation.AnnotationTypeMismatchException/976205828";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.security.DigestException::class)] = "java.security.DigestException/629316798";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.security.GeneralSecurityException::class)] = "java.security.GeneralSecurityException/2669239907";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.security.NoSuchAlgorithmException::class)] = "java.security.NoSuchAlgorithmException/2892037213";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.sql.Date::class)] = "java.sql.Date/3996530531";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.sql.Time::class)] = "java.sql.Time/831929183";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.sql.Timestamp::class)] = "java.sql.Timestamp/1769758459";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.AbstractList[]::class)] = "[Ljava.util.AbstractList;/727920111";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.AbstractSequentialList[]::class)] = "[Ljava.util.AbstractSequentialList;/3144020509";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.ArrayList::class)] = "java.util.ArrayList/3821976829";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.ArrayList[]::class)] = "[Ljava.util.ArrayList;/2672211863";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Arrays$ArrayList::class)] = "java.util.Arrays$ArrayList/1243019747";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Collections$EmptyList::class)] = "java.util.Collections$EmptyList/3012082351";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Collections$EmptyMap::class)] = "java.util.Collections$EmptyMap/2636129644";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Collections$SingletonList::class)] = "java.util.Collections$SingletonList/833432284";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.ConcurrentModificationException::class)] = "java.util.ConcurrentModificationException/2717383897";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Date::class)] = "java.util.Date/1659716317";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.EmptyStackException::class)] = "java.util.EmptyStackException/89438517";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.HashMap::class)] = "java.util.HashMap/962170901";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.IdentityHashMap::class)] = "java.util.IdentityHashMap/3881143367";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.LinkedHashMap::class)] = "java.util.LinkedHashMap/1551059846";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.LinkedList::class)] = "java.util.LinkedList/1060625595";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.LinkedList[]::class)] = "[Ljava.util.LinkedList;/4144402753";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.List[]::class)] = "[Ljava.util.List;/2827171268";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.NoSuchElementException::class)] = "java.util.NoSuchElementException/1559248883";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Stack::class)] = "java.util.Stack/1031431137";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Stack[]::class)] = "[Ljava.util.Stack;/850422574";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.TooManyListenersException::class)] = "java.util.TooManyListenersException/2023078032";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.TreeMap::class)] = "java.util.TreeMap/1575826026";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Vector::class)] = "java.util.Vector/3125574444";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Vector[]::class)] = "[Ljava.util.Vector;/3309436523";
    return result;
  }-*/;
  
  public ComunesRPCService_TypeSerializer() {
    super(methodMapJava, methodMapNative, signatureMapJava, signatureMapNative);
  }
  
}