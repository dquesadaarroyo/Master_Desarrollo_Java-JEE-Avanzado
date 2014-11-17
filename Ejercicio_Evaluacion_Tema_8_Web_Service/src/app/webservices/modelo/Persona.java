package app.webservices.modelo;

import java.io.Serializable;

public class Persona implements Serializable{

	private static final long serialVersionUID = 1L;

	private long idPersona;
	private String nombPerso;
	
	public Persona(){
		
	}
	
	public Persona(long idPersona, String nombPerso) {
		this.idPersona = idPersona;
		this.nombPerso = nombPerso;
	}
	public long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombPerso() {
		return nombPerso;
	}
	public void setNombPerso(String nombPerso) {
		this.nombPerso = nombPerso;
	}
	
	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombPerso=" + nombPerso
				+ "]";
	}

}
