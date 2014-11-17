package app.webservices.negocio;

import app.webservices.dao.ItfzPersonasDAO;
import app.webservices.dao.PersonasDAO;
import app.webservices.modelo.Persona;


public class Gestion implements ItfzGestion{

	private Persona miPersona=null;
	ItfzPersonasDAO miDao = new PersonasDAO();
	
	@Override
	public Persona consultarPersona(long idPersona) {
		try{
			miPersona = miDao.consultarPersona(idPersona);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return miPersona;
	}	
}
