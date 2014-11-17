package app.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Autor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nombre;
	private String nacionalidad;
	private String comentarios;
	private Set<Libro> libros = new HashSet<Libro>();

	
	public void addLibros(Libro l){
		libros.add(l);
		l.getAutores().add(this);
	}
	
	public Autor() {
	
	}

	public Autor(String nombre, String nacionalidad, String comentarios,
			Set<Libro> libros) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.comentarios = comentarios;
		this.libros = libros;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", nacionalidad="
				+ nacionalidad + ", comentarios=" + comentarios + "]";
	}
}
