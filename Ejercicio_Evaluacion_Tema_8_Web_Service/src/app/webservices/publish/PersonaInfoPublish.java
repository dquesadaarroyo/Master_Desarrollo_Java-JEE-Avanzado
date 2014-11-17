package app.webservices.publish;

import javax.xml.ws.Endpoint;

import app.webservices.ws.PersonaInfoWebServiceImpl;

public class PersonaInfoPublish {

	public static void main(String[] args){
		Endpoint.publish("http://127.0.0.1:9876/personaInfo", new PersonaInfoWebServiceImpl());
		System.out.println("Servicio publicado.");
	}
}
