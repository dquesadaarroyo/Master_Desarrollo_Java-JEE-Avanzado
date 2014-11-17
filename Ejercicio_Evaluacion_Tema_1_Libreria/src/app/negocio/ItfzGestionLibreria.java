/**
 * 
 */
package app.negocio;

import java.util.List;

import app.excepciones.LibroNoEncontradoException;
import app.modelo.Libro;

/**
 * Interfaz donde se definen los métodos que serán implementados en la clase GestionLibreria.java
 * 
 * @author danielquesadaarroyo
 *
 */
public interface ItfzGestionLibreria {
	
	public boolean altaLibro(Libro libro);
	public boolean eliminarLibro(String ISBN);
	public List<Libro> consultarTodos() throws LibroNoEncontradoException;
	public Libro consultarISBN(String isbn) throws LibroNoEncontradoException;
	public List<Libro> consultarTitulo(String titulo) throws LibroNoEncontradoException;
	public boolean modificarPrecio(String isbn, double precio);
	
}
