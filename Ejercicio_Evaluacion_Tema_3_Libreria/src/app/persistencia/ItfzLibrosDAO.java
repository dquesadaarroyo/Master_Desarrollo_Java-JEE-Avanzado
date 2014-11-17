/**
 * 
 */
package app.persistencia;

import java.util.List;

import app.excepciones.LibroNoEncontradoException;
import app.modelo.Libro;

/**
 * @author danielquesadaarroyo
 *
 */
public interface ItfzLibrosDAO{
	
	public boolean altaLibro(Libro libro);
	public boolean eliminarLibro(String ISBN) throws LibroNoEncontradoException;
	public List<Libro> consultarTodos() throws LibroNoEncontradoException;
	public Libro consultarISBN(String ISBN) throws LibroNoEncontradoException;
	public List<Libro> consultarTitulo(String titulo) throws LibroNoEncontradoException;
	public boolean modificarPrecio(String ISBN, double precio);
	public List<Libro> consultarLibroPorAutor(long idAutor) throws LibroNoEncontradoException;
	public List<Libro> consultarLibroPorEditorial(long idEditorial) throws LibroNoEncontradoException;
	public List<Libro> autoCompletaTitulo(String titulo);
}
