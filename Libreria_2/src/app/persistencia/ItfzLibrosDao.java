package app.persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import app.excepciones.LibroNoEncontradoException;
import app.modelo.Autor;
import app.modelo.Editorial;
import app.modelo.Libro;

/**
 * Interfaz que establece la comunicaci—n con la base de datos y con la que podremos dar de alta, consultar, 
 * eliminar y modificar datos.
 * @author danielquesadaarroyo
 *
 */
public interface ItfzLibrosDao <Entity, PK extends Serializable> {
	
	public boolean altaLibro(Libro libro);
	public boolean eliminarLibro(String ISBN) throws LibroNoEncontradoException;
	public List<Libro> consultarTodos() throws LibroNoEncontradoException;
	public Libro consultarISBN(String ISBN) throws LibroNoEncontradoException;
	public List<Libro> consultarTitulo(String titulo) throws LibroNoEncontradoException;
	public boolean modificarPrecio(String ISBN, double precio);

}
