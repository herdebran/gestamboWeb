package ar.com.cristal.creditos.client.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class ClienteDTO_FieldSerializer {
  public static class Handler implements com.google.gwt.user.client.rpc.impl.TypeHandler {
    public void deserialize(SerializationStreamReader reader, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.ClienteDTO_FieldSerializer.deserialize(reader, (ar.com.cristal.creditos.client.dto.ClienteDTO)object);
    }
    public Object instantiate(SerializationStreamReader reader) throws SerializationException {
      return ar.com.cristal.creditos.client.dto.ClienteDTO_FieldSerializer.instantiate(reader);
    }
    public void serialize(SerializationStreamWriter writer, Object object) throws SerializationException {
      ar.com.cristal.creditos.client.dto.ClienteDTO_FieldSerializer.serialize(writer, (ar.com.cristal.creditos.client.dto.ClienteDTO)object);
    }
  }
  private static native java.lang.String getCBU(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::CBU;
  }-*/;
  
  private static native void  setCBU(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::CBU = value;
  }-*/;
  
  private static native java.lang.String getCUIL(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::CUIL;
  }-*/;
  
  private static native void  setCUIL(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::CUIL = value;
  }-*/;
  
  private static native java.lang.Boolean getAntecedentesJuridicos(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::antecedentesJuridicos;
  }-*/;
  
  private static native void  setAntecedentesJuridicos(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.Boolean value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::antecedentesJuridicos = value;
  }-*/;
  
  private static native java.lang.String getApellido(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::apellido;
  }-*/;
  
  private static native void  setApellido(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::apellido = value;
  }-*/;
  
  private static native java.lang.String getCalle(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::calle;
  }-*/;
  
  private static native void  setCalle(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::calle = value;
  }-*/;
  
  private static native java.lang.String getCaracteristica(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::caracteristica;
  }-*/;
  
  private static native void  setCaracteristica(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::caracteristica = value;
  }-*/;
  
  private static native java.lang.String getCaracteristica1(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::caracteristica1;
  }-*/;
  
  private static native void  setCaracteristica1(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::caracteristica1 = value;
  }-*/;
  
  private static native java.lang.String getCaracteristica2(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::caracteristica2;
  }-*/;
  
  private static native void  setCaracteristica2(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::caracteristica2 = value;
  }-*/;
  
  private static native java.lang.String getCaracteristica3(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::caracteristica3;
  }-*/;
  
  private static native void  setCaracteristica3(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::caracteristica3 = value;
  }-*/;
  
  private static native java.lang.String getCondicionMorosidad(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::condicionMorosidad;
  }-*/;
  
  private static native void  setCondicionMorosidad(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::condicionMorosidad = value;
  }-*/;
  
  private static native java.lang.String getCp(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::cp;
  }-*/;
  
  private static native void  setCp(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::cp = value;
  }-*/;
  
  private static native java.lang.String getDni(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::dni;
  }-*/;
  
  private static native void  setDni(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::dni = value;
  }-*/;
  
  private static native java.lang.String getDpto(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::dpto;
  }-*/;
  
  private static native void  setDpto(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::dpto = value;
  }-*/;
  
  private static native java.lang.String getEmail(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::email;
  }-*/;
  
  private static native void  setEmail(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::email = value;
  }-*/;
  
  private static native java.lang.String getEstado(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::estado;
  }-*/;
  
  private static native void  setEstado(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::estado = value;
  }-*/;
  
  private static native java.util.Date getFechaAlta(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::fechaAlta;
  }-*/;
  
  private static native void  setFechaAlta(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.util.Date value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::fechaAlta = value;
  }-*/;
  
  private static native java.util.Date getFechaEnvioCartaMoroso2(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::fechaEnvioCartaMoroso2;
  }-*/;
  
  private static native void  setFechaEnvioCartaMoroso2(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.util.Date value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::fechaEnvioCartaMoroso2 = value;
  }-*/;
  
  private static native java.util.Date getFechaEnvioCartaPrejudicial(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::fechaEnvioCartaPrejudicial;
  }-*/;
  
  private static native void  setFechaEnvioCartaPrejudicial(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.util.Date value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::fechaEnvioCartaPrejudicial = value;
  }-*/;
  
  private static native java.util.Date getFechaModificacion(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::fechaModificacion;
  }-*/;
  
  private static native void  setFechaModificacion(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.util.Date value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::fechaModificacion = value;
  }-*/;
  
  private static native java.util.Date getFechaNacimiento(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::fechaNacimiento;
  }-*/;
  
  private static native void  setFechaNacimiento(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.util.Date value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::fechaNacimiento = value;
  }-*/;
  
  private static native java.lang.Long getId(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::id;
  }-*/;
  
  private static native void  setId(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.Long value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::id = value;
  }-*/;
  
  private static native java.lang.Long getIdComercializador(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::idComercializador;
  }-*/;
  
  private static native void  setIdComercializador(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.Long value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::idComercializador = value;
  }-*/;
  
  private static native ar.com.cristal.creditos.client.localidad.LocalidadDTO getLocalidad(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::localidad;
  }-*/;
  
  private static native void  setLocalidad(ar.com.cristal.creditos.client.dto.ClienteDTO instance, ar.com.cristal.creditos.client.localidad.LocalidadDTO value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::localidad = value;
  }-*/;
  
  private static native java.lang.String getNombre(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::nombre;
  }-*/;
  
  private static native void  setNombre(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::nombre = value;
  }-*/;
  
  private static native java.lang.String getNombreUsuario(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::nombreUsuario;
  }-*/;
  
  private static native void  setNombreUsuario(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::nombreUsuario = value;
  }-*/;
  
  private static native java.lang.String getNro(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::nro;
  }-*/;
  
  private static native void  setNro(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::nro = value;
  }-*/;
  
  private static native java.lang.Long getNroCuenta(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::nroCuenta;
  }-*/;
  
  private static native void  setNroCuenta(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.Long value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::nroCuenta = value;
  }-*/;
  
  private static native java.lang.String getObservaciones(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::observaciones;
  }-*/;
  
  private static native void  setObservaciones(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::observaciones = value;
  }-*/;
  
  private static native java.lang.Boolean getPagoVoluntario(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::pagoVoluntario;
  }-*/;
  
  private static native void  setPagoVoluntario(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.Boolean value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::pagoVoluntario = value;
  }-*/;
  
  private static native java.lang.String getPiso(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::piso;
  }-*/;
  
  private static native void  setPiso(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::piso = value;
  }-*/;
  
  private static native java.lang.String getSexo(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::sexo;
  }-*/;
  
  private static native void  setSexo(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::sexo = value;
  }-*/;
  
  private static native java.lang.Double getSueldo(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::sueldo;
  }-*/;
  
  private static native void  setSueldo(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.Double value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::sueldo = value;
  }-*/;
  
  private static native java.lang.Boolean getTarjetaBeneficios(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::tarjetaBeneficios;
  }-*/;
  
  private static native void  setTarjetaBeneficios(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.Boolean value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::tarjetaBeneficios = value;
  }-*/;
  
  private static native java.lang.String getTelefono(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::telefono;
  }-*/;
  
  private static native void  setTelefono(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::telefono = value;
  }-*/;
  
  private static native java.lang.String getTelefono1(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::telefono1;
  }-*/;
  
  private static native void  setTelefono1(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::telefono1 = value;
  }-*/;
  
  private static native java.lang.String getTelefono2(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::telefono2;
  }-*/;
  
  private static native void  setTelefono2(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::telefono2 = value;
  }-*/;
  
  private static native java.lang.String getTelefono3(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::telefono3;
  }-*/;
  
  private static native void  setTelefono3(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::telefono3 = value;
  }-*/;
  
  private static native java.lang.String getTipoDocumento(ar.com.cristal.creditos.client.dto.ClienteDTO instance) /*-{
    return instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::tipoDocumento;
  }-*/;
  
  private static native void  setTipoDocumento(ar.com.cristal.creditos.client.dto.ClienteDTO instance, java.lang.String value) /*-{
    instance.@ar.com.cristal.creditos.client.dto.ClienteDTO::tipoDocumento = value;
  }-*/;
  
  public static Class<?> concreteType() {
    return ar.com.cristal.creditos.client.dto.ClienteDTO.class;
  }
  
  public static void deserialize(SerializationStreamReader streamReader, ar.com.cristal.creditos.client.dto.ClienteDTO instance) throws SerializationException {
    setCBU(instance, streamReader.readString());
    setCUIL(instance, streamReader.readString());
    setAntecedentesJuridicos(instance, (java.lang.Boolean) streamReader.readObject());
    setApellido(instance, streamReader.readString());
    setCalle(instance, streamReader.readString());
    setCaracteristica(instance, streamReader.readString());
    setCaracteristica1(instance, streamReader.readString());
    setCaracteristica2(instance, streamReader.readString());
    setCaracteristica3(instance, streamReader.readString());
    setCondicionMorosidad(instance, streamReader.readString());
    setCp(instance, streamReader.readString());
    setDni(instance, streamReader.readString());
    setDpto(instance, streamReader.readString());
    setEmail(instance, streamReader.readString());
    setEstado(instance, streamReader.readString());
    setFechaAlta(instance, (java.util.Date) streamReader.readObject());
    setFechaEnvioCartaMoroso2(instance, (java.util.Date) streamReader.readObject());
    setFechaEnvioCartaPrejudicial(instance, (java.util.Date) streamReader.readObject());
    setFechaModificacion(instance, (java.util.Date) streamReader.readObject());
    setFechaNacimiento(instance, (java.util.Date) streamReader.readObject());
    setId(instance, (java.lang.Long) streamReader.readObject());
    setIdComercializador(instance, (java.lang.Long) streamReader.readObject());
    setLocalidad(instance, (ar.com.cristal.creditos.client.localidad.LocalidadDTO) streamReader.readObject());
    setNombre(instance, streamReader.readString());
    setNombreUsuario(instance, streamReader.readString());
    setNro(instance, streamReader.readString());
    setNroCuenta(instance, (java.lang.Long) streamReader.readObject());
    setObservaciones(instance, streamReader.readString());
    setPagoVoluntario(instance, (java.lang.Boolean) streamReader.readObject());
    setPiso(instance, streamReader.readString());
    setSexo(instance, streamReader.readString());
    setSueldo(instance, (java.lang.Double) streamReader.readObject());
    setTarjetaBeneficios(instance, (java.lang.Boolean) streamReader.readObject());
    setTelefono(instance, streamReader.readString());
    setTelefono1(instance, streamReader.readString());
    setTelefono2(instance, streamReader.readString());
    setTelefono3(instance, streamReader.readString());
    setTipoDocumento(instance, streamReader.readString());
    
    ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static ar.com.cristal.creditos.client.dto.ClienteDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ar.com.cristal.creditos.client.dto.ClienteDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ar.com.cristal.creditos.client.dto.ClienteDTO instance) throws SerializationException {
    streamWriter.writeString(getCBU(instance));
    streamWriter.writeString(getCUIL(instance));
    streamWriter.writeObject(getAntecedentesJuridicos(instance));
    streamWriter.writeString(getApellido(instance));
    streamWriter.writeString(getCalle(instance));
    streamWriter.writeString(getCaracteristica(instance));
    streamWriter.writeString(getCaracteristica1(instance));
    streamWriter.writeString(getCaracteristica2(instance));
    streamWriter.writeString(getCaracteristica3(instance));
    streamWriter.writeString(getCondicionMorosidad(instance));
    streamWriter.writeString(getCp(instance));
    streamWriter.writeString(getDni(instance));
    streamWriter.writeString(getDpto(instance));
    streamWriter.writeString(getEmail(instance));
    streamWriter.writeString(getEstado(instance));
    streamWriter.writeObject(getFechaAlta(instance));
    streamWriter.writeObject(getFechaEnvioCartaMoroso2(instance));
    streamWriter.writeObject(getFechaEnvioCartaPrejudicial(instance));
    streamWriter.writeObject(getFechaModificacion(instance));
    streamWriter.writeObject(getFechaNacimiento(instance));
    streamWriter.writeObject(getId(instance));
    streamWriter.writeObject(getIdComercializador(instance));
    streamWriter.writeObject(getLocalidad(instance));
    streamWriter.writeString(getNombre(instance));
    streamWriter.writeString(getNombreUsuario(instance));
    streamWriter.writeString(getNro(instance));
    streamWriter.writeObject(getNroCuenta(instance));
    streamWriter.writeString(getObservaciones(instance));
    streamWriter.writeObject(getPagoVoluntario(instance));
    streamWriter.writeString(getPiso(instance));
    streamWriter.writeString(getSexo(instance));
    streamWriter.writeObject(getSueldo(instance));
    streamWriter.writeObject(getTarjetaBeneficios(instance));
    streamWriter.writeString(getTelefono(instance));
    streamWriter.writeString(getTelefono1(instance));
    streamWriter.writeString(getTelefono2(instance));
    streamWriter.writeString(getTelefono3(instance));
    streamWriter.writeString(getTipoDocumento(instance));
    
    ar.com.cristal.creditos.client.dto.DTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
