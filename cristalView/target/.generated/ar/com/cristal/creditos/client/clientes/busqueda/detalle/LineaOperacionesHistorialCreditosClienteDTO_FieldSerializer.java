package ar.com.cristal.creditos.client.clientes.busqueda.detalle;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class LineaOperacionesHistorialCreditosClienteDTO_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO)object);
    }
  }
  private static native int getCuotasPagas(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::cuotasPagas;
  }-*/;
  
  private static native void  setCuotasPagas(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance, int value) /*-{
    instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::cuotasPagas = value;
  }-*/;
  
  private static native int getCuotasTotal(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::cuotasTotal;
  }-*/;
  
  private static native void  setCuotasTotal(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance, int value) /*-{
    instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::cuotasTotal = value;
  }-*/;
  
  private static native java.lang.String getDescTipoCredito(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::descTipoCredito;
  }-*/;
  
  private static native void  setDescTipoCredito(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::descTipoCredito = value;
  }-*/;
  
  private static native java.lang.String getEmpresa(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::empresa;
  }-*/;
  
  private static native void  setEmpresa(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::empresa = value;
  }-*/;
  
  private static native java.lang.String getEstadoCredito(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::estadoCredito;
  }-*/;
  
  private static native void  setEstadoCredito(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::estadoCredito = value;
  }-*/;
  
  private static native java.lang.String getFechaCreacionCredito(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::fechaCreacionCredito;
  }-*/;
  
  private static native void  setFechaCreacionCredito(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::fechaCreacionCredito = value;
  }-*/;
  
  private static native java.lang.String getFechaSolicitudCredito(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::fechaSolicitudCredito;
  }-*/;
  
  private static native void  setFechaSolicitudCredito(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::fechaSolicitudCredito = value;
  }-*/;
  
  private static native java.lang.String getFechaVencimiento(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::fechaVencimiento;
  }-*/;
  
  private static native void  setFechaVencimiento(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::fechaVencimiento = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getIdCredito(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::idCredito;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void  setIdCredito(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance, long value) /*-{
    instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::idCredito = value;
  }-*/;
  
  private static native java.lang.String getMedioDeContacto(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::medioDeContacto;
  }-*/;
  
  private static native void  setMedioDeContacto(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::medioDeContacto = value;
  }-*/;
  
  private static native java.lang.Double getMontoCredito(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::montoCredito;
  }-*/;
  
  private static native void  setMontoCredito(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance, java.lang.Double value) /*-{
    instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::montoCredito = value;
  }-*/;
  
  private static native java.lang.String getPagoVoluntario(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::pagoVoluntario;
  }-*/;
  
  private static native void  setPagoVoluntario(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::pagoVoluntario = value;
  }-*/;
  
  private static native java.lang.String getSucursal(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::sucursal;
  }-*/;
  
  private static native void  setSucursal(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::sucursal = value;
  }-*/;
  
  private static native java.lang.String getTipoComprobante(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::tipoComprobante;
  }-*/;
  
  private static native void  setTipoComprobante(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::tipoComprobante = value;
  }-*/;
  
  private static native java.lang.String getTipoMedioEntregaDinero(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::tipoMedioEntregaDinero;
  }-*/;
  
  private static native void  setTipoMedioEntregaDinero(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::tipoMedioEntregaDinero = value;
  }-*/;
  
  private static native java.lang.String getUsuario(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::usuario;
  }-*/;
  
  private static native void  setUsuario(ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO::usuario = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance) throws SerializationException {
    setCuotasPagas(instance, streamReader.readInt());
    setCuotasTotal(instance, streamReader.readInt());
    setDescTipoCredito(instance, streamReader.readString());
    setEmpresa(instance, streamReader.readString());
    setEstadoCredito(instance, streamReader.readString());
    setFechaCreacionCredito(instance, streamReader.readString());
    setFechaSolicitudCredito(instance, streamReader.readString());
    setFechaVencimiento(instance, streamReader.readString());
    setIdCredito(instance, streamReader.readLong());
    setMedioDeContacto(instance, streamReader.readString());
    setMontoCredito(instance, (java.lang.Double) streamReader.readObject());
    setPagoVoluntario(instance, streamReader.readString());
    setSucursal(instance, streamReader.readString());
    setTipoComprobante(instance, streamReader.readString());
    setTipoMedioEntregaDinero(instance, streamReader.readString());
    setUsuario(instance, streamReader.readString());
    
    ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.clientes.busqueda.detalle.LineaOperacionesHistorialCreditosClienteDTO instance) throws SerializationException {
    streamWriter.writeInt(getCuotasPagas(instance));
    streamWriter.writeInt(getCuotasTotal(instance));
    streamWriter.writeString(getDescTipoCredito(instance));
    streamWriter.writeString(getEmpresa(instance));
    streamWriter.writeString(getEstadoCredito(instance));
    streamWriter.writeString(getFechaCreacionCredito(instance));
    streamWriter.writeString(getFechaSolicitudCredito(instance));
    streamWriter.writeString(getFechaVencimiento(instance));
    streamWriter.writeLong(getIdCredito(instance));
    streamWriter.writeString(getMedioDeContacto(instance));
    streamWriter.writeObject(getMontoCredito(instance));
    streamWriter.writeString(getPagoVoluntario(instance));
    streamWriter.writeString(getSucursal(instance));
    streamWriter.writeString(getTipoComprobante(instance));
    streamWriter.writeString(getTipoMedioEntregaDinero(instance));
    streamWriter.writeString(getUsuario(instance));
    
    ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
