package app.mdb.modelo;

import java.io.Serializable;

public class Persona implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nombre;
	private String apellido1;
	private String apellido2;
	private int telefono;
	private String notas;
	
		
	public Persona(){
		
	}
	
	public Persona(String nombre, String apellido1, String apellido2,
			int telefono, String notas) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefono = telefono;
		this.notas = notas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getNotas() {
		return notas;
	}
	public void setNotas(String notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", telefono=" + telefono
				+ ", notas=" + notas + "]";
	}

}
