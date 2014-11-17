package app.webservices.publish;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import app.webservices.ws.ItfzPersonaInfoWebService;

public class PersonalInfoClient {
	
	public static void main(String[] args) throws Exception{
		URL url = new URL("http://127.0.0.1:9876/personaInfo?wsdl");
		QName qname = new QName("http://ws.webservices.app/","PersonaInfoWebServiceImplService");
		Service service = Service.create(url,qname);
		ItfzPersonaInfoWebService eif = service.getPort(ItfzPersonaInfoWebService.class);
		System.out.println("Result: " + eif.getPersonaInfo("1"));
	}

}
