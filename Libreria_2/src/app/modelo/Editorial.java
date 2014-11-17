package app.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * POJO de la entidad Editorial, donde establecemos varios datos de las editoriales, entre ellas 
 * una relaci—n one-to-many con la entidad libros, y many-to-one con la entidad Direccion.
 * @author danielquesadaarroyo
 *
 */
public class Editorial implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nombre;
	private String nif;
	private Direccion direccion;
	private Set<Libro> libros = new HashSet<Libro>();
	
	
	public void addLibros(Libro l){
		libros.add(l);
		l.setEditorial(this);
	}
	
	public Editorial() {
	
	}

	public Editorial(String nombre, Direccion direccion, String nif) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.nif = nif;
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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Editorial [id=" + id + ", nombre=" + nombre + ", nif=" + nif
				+ ", direccion=" + direccion + "]";
	}


	
}
