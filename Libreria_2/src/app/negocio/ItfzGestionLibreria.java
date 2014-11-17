/**
 * 
 */
package app.negocio;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import app.excepciones.LibroNoEncontradoException;
import app.modelo.Autor;
import app.modelo.Editorial;
import app.modelo.Libro;

/**
 * Interfaz con la que establecemos la parte de negocio de nuestra aplicaci—n. Con esta clase interactuaremos
 * con la capa DAO, encargada de la comunicaci—n con la base de datos.
 * @author danielquesadaarroyo
 *
 */
public interface ItfzGestionLibreria {
	
	public boolean altaLibro(Libro libro);
	public boolean eliminarLibro(String ISBN) throws LibroNoEncontradoException;
	public List<Libro> consultarTodos() throws LibroNoEncontradoException;
	public Libro consultarISBN(String ISBN) throws LibroNoEncontradoException;
	public List<Libro> consultarTitulo(String titulo) throws LibroNoEncontradoException;
	public boolean modificarPrecio(String ISBN, double precio);
}
