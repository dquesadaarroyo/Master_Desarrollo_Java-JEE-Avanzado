package app.webservices.ws;

import javax.jws.WebService;

import app.webservices.modelo.Persona;
import app.webservices.negocio.Gestion;
import app.webservices.negocio.ItfzGestion;

@WebService(endpointInterface="app.webservices.ws.ItfzPersonaInfoWebService")
public class PersonaInfoWebServiceImpl implements ItfzPersonaInfoWebService{

	@Override
	public Persona getPersonaInfo(String idPersona) {
		ItfzGestion gestion = new Gestion();
		Persona miPersona = gestion.consultarPersona(Long.parseLong(idPersona));
		
		return miPersona;
	}	
	
}
