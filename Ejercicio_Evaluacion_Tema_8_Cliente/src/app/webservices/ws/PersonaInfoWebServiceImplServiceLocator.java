/**
 * PersonaInfoWebServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package app.webservices.ws;

public class PersonaInfoWebServiceImplServiceLocator extends org.apache.axis.client.Service implements app.webservices.ws.PersonaInfoWebServiceImplService {

    public PersonaInfoWebServiceImplServiceLocator() {
    }


    public PersonaInfoWebServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PersonaInfoWebServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PersonaInfoWebServiceImplPort
    private java.lang.String PersonaInfoWebServiceImplPort_address = "http://localhost:9876/personaInfo";

    public java.lang.String getPersonaInfoWebServiceImplPortAddress() {
        return PersonaInfoWebServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PersonaInfoWebServiceImplPortWSDDServiceName = "PersonaInfoWebServiceImplPort";

    public java.lang.String getPersonaInfoWebServiceImplPortWSDDServiceName() {
        return PersonaInfoWebServiceImplPortWSDDServiceName;
    }

    public void setPersonaInfoWebServiceImplPortWSDDServiceName(java.lang.String name) {
        PersonaInfoWebServiceImplPortWSDDServiceName = name;
    }

    public app.webservices.ws.ItfzPersonaInfoWebService getPersonaInfoWebServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PersonaInfoWebServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPersonaInfoWebServiceImplPort(endpoint);
    }

    public app.webservices.ws.ItfzPersonaInfoWebService getPersonaInfoWebServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            app.webservices.ws.PersonaInfoWebServiceImplServiceSoapBindingStub _stub = new app.webservices.ws.PersonaInfoWebServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getPersonaInfoWebServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPersonaInfoWebServiceImplPortEndpointAddress(java.lang.String address) {
        PersonaInfoWebServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (app.webservices.ws.ItfzPersonaInfoWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                app.webservices.ws.PersonaInfoWebServiceImplServiceSoapBindingStub _stub = new app.webservices.ws.PersonaInfoWebServiceImplServiceSoapBindingStub(new java.net.URL(PersonaInfoWebServiceImplPort_address), this);
                _stub.setPortName(getPersonaInfoWebServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("PersonaInfoWebServiceImplPort".equals(inputPortName)) {
            return getPersonaInfoWebServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.webservices.app/", "PersonaInfoWebServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.webservices.app/", "PersonaInfoWebServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PersonaInfoWebServiceImplPort".equals(portName)) {
            setPersonaInfoWebServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
