package app.webservices.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import app.webservices.modelo.Persona;

@WebService
@SOAPBinding(style=Style.RPC)
public interface ItfzPersonaInfoWebService {
	@WebMethod
	public Persona getPersonaInfo(String idPersona);
}
