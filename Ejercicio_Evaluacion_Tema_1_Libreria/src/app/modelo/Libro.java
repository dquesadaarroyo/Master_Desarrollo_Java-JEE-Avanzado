package app.modelo;


/**
 * POJO de tipo Libro, donde definimos sus atributos y declaramos sus m�todos constructores y m�todos Get y Set.
 * @author danielquesadaarroyo
 *
 */
public class Libro {
	
	String titulo;
	private String autor;
	private String editorial;
	private String isbn;
	private int publicacion;
	private double precio;
	private String descripcion;
	
	public Libro() {
	
	}
	
	public Libro(String titulo, String autor, String editorial, String isbn,
				 int publicacion, double precio, String descripcion) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.isbn = isbn;
		this.publicacion = publicacion;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
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
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", editorial="
				+ editorial + ", isbn=" + isbn + ", publicacion=" + publicacion
				+ ", precio=" + precio + ", descripcion=" + descripcion + "]";
	}
	
}
