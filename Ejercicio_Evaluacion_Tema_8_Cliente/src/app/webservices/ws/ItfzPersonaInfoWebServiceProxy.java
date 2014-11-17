package app.webservices.ws;

public class ItfzPersonaInfoWebServiceProxy implements app.webservices.ws.ItfzPersonaInfoWebService {
  private String _endpoint = null;
  private app.webservices.ws.ItfzPersonaInfoWebService itfzPersonaInfoWebService = null;
  
  public ItfzPersonaInfoWebServiceProxy() {
    _initItfzPersonaInfoWebServiceProxy();
  }
  
  public ItfzPersonaInfoWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initItfzPersonaInfoWebServiceProxy();
  }
  
  private void _initItfzPersonaInfoWebServiceProxy() {
    try {
      itfzPersonaInfoWebService = (new app.webservices.ws.PersonaInfoWebServiceImplServiceLocator()).getPersonaInfoWebServiceImplPort();
      if (itfzPersonaInfoWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)itfzPersonaInfoWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)itfzPersonaInfoWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (itfzPersonaInfoWebService != null)
      ((javax.xml.rpc.Stub)itfzPersonaInfoWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public app.webservices.ws.ItfzPersonaInfoWebService getItfzPersonaInfoWebService() {
    if (itfzPersonaInfoWebService == null)
      _initItfzPersonaInfoWebServiceProxy();
    return itfzPersonaInfoWebService;
  }
  
  public app.webservices.ws.Persona getPersonaInfo(java.lang.String arg0) throws java.rmi.RemoteException{
    if (itfzPersonaInfoWebService == null)
      _initItfzPersonaInfoWebServiceProxy();
    return itfzPersonaInfoWebService.getPersonaInfo(arg0);
  }
  
  
}