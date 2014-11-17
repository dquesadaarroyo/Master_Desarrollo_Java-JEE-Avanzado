package app.webservices.bean;

import java.net.MalformedURLException;
import java.net.URL;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.ws.Service;

import app.webservices.modelo.Persona;
import app.webservices.ws.ItfzPersonaInfoWebService;
import app.webservices.ws.PersonaInfoWebServiceImpl;

@ManagedBean(name="personaBean", eager=true)
@ApplicationScoped
public class PersonaBean {
	
	private String idPersona;
	private Persona miPersona = new Persona();
	
	public PersonaBean() {
		
	}

	public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}
	
	public Persona getMiPersona() {
		return miPersona;
	}

	public void setMiPersona(Persona miPersona) {
		this.miPersona = miPersona;
	}
	
	public String callWebService(){
		URL url;
		try {
			url = new URL("http://127.0.0.1:9876/personaInfo?wsdl");
			QName qname = new QName("http://ws.webservices.app/","PersonaInfoWebServiceImplService");
			Service service = Service.create(url,qname);
			ItfzPersonaInfoWebService eif = service.getPort(ItfzPersonaInfoWebService.class);
			this.miPersona = eif.getPersonaInfo(getIdPersona());
			
			System.out.println("Result: " + eif.getPersonaInfo(getIdPersona()));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "busqueda";
	}

	
	
}
