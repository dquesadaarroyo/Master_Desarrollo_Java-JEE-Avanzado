package app.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * POJO de la entidad Libro, donde establecemos varios datos de los libros, entre ellas 
 * una relaci—n many-to-many con la entidad Autor, y many-to-one con la entidad Editorial.
 * @author danielquesadaarroyo
 *
 */
public class Libro implements Serializable{


	private static final long serialVersionUID = 1L;

	private Long id;
	private String titulo;	
	private String isbn;
	private int publicacion;
	private double precio;
	private String descripcion;
	private Set<Autor> autores = new HashSet<Autor>();
	private Editorial editorial;
	
	public void addAutores(Autor a){
		autores.add(a);
		a.getLibros().add(this);
	}
	
	public Libro() {
	
	}
	
	public Libro(String titulo, Autor autor, Editorial editorial, String isbn,
				 int publicacion, double precio, String descripcion) {
		this.titulo = titulo;
		this.editorial = editorial;
		this.isbn = isbn;
		this.publicacion = publicacion;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	public Set<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}

	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
	public int getPublicacion() {
		return publicacion;
	}
	public void setPublicacion(int publicacion) {
		this.publicacion = publicacion;
	}
	
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", isbn=" + isbn
				+ ", publicacion=" + publicacion + ", precio=" + precio
				+ ", descripcion=" + descripcion + ", autores=" + autores
				+ ", editorial=" + editorial + "]";
	}
}
