package ar.com.cristal.creditos.client.service;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class CreditosRPCService_Proxy extends RemoteServiceProxy implements ar.com.cristal.creditos.client.service.CreditosRPCServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "ar.com.cristal.creditos.client.service.CreditosRPCService";
  private static final String SERIALIZATION_POLICY ="C7E56CC2978735D904C480333E78733B";
  private static final ar.com.cristal.creditos.client.service.CreditosRPCService_TypeSerializer SERIALIZER = new ar.com.cristal.creditos.client.service.CreditosRPCService_TypeSerializer();
  
  public CreditosRPCService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "creditosService", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
}
