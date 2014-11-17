package app.negocio;

import java.util.List;

import app.excepciones.LibroNoEncontradoException;
import app.modelo.Libro;
import app.persistencia.ItfzLibrosDao;


/**
 * Clase que implementa ItfzGestionLibreria.java
 * 
 * @author danielquesadaarroyo
 *
 */
public class GestionLibreria implements ItfzGestionLibreria{

	ItfzLibrosDao miDao;
	Libro miLibro = null;
	List<Libro> misLibros = null;
	
	
	public ItfzLibrosDao getMiDao() {
		return miDao;
	}

	public void setMiDao(ItfzLibrosDao miDao) {
		this.miDao = miDao;
	}
	
	
	/**
	 * Método que recibe un libro, y que lo da de alta en la base de datos.
	 */
	@Override
	public boolean altaLibro(Libro libro) {
		return miDao.altaLibro(libro);
	}

	/**
	 * Método a través del cual eliminaremos el libro con el ISBN recibido por parametro.
	 */
	@Override
	public boolean eliminarLibro(String ISBN) {
		return miDao.eliminarLibro(ISBN);
	}

	/**
	 * Método con el que consultamos todos los libros de la base de datos.
	 */
	@Override
	public List<Libro> consultarTodos() throws LibroNoEncontradoException {
		
		try{
			misLibros = miDao.consultarTodos();
		}catch(Exception e){
			throw new LibroNoEncontradoException();
		}
		return misLibros;
	}
	
	/**
	 * Método con el que consultamos los libros con el ISBN recibido por parametro.
	 */
	@Override
	public Libro consultarISBN(String isbn) throws LibroNoEncontradoException{
		try{
			miLibro = miDao.consultarISBN(isbn);
		}catch(Exception e){
			throw new LibroNoEncontradoException();
		}
		return miLibro;
	}

	/**
	 * Método con el que realizamos una búsqueda en la base de datos de aquellos libros que en su Titulo, contengan
	 * el String que recibe por parametro.
	 */
	@Override
	public List<Libro> consultarTitulo(String titulo) throws LibroNoEncontradoException {
		
		try{
			misLibros = miDao.consultarTitulo(titulo);
		}catch(Exception e){
			throw new LibroNoEncontradoException();
		}
		return misLibros;
	}

	/**
	 * Método con el que modificaremos el precio de un libro. El método recibe el ISBN y el nuevo precio.
	 */
	@Override
	public boolean modificarPrecio(String isbn, double precio) {
		return miDao.modificarPrecio(isbn, precio);
	}
}
