package app.negocio;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import app.excepciones.LibroNoEncontradoException;
import app.modelo.Autor;
import app.modelo.Editorial;
import app.modelo.Libro;
import app.persistencia.ItfzLibrosDao;
import app.persistencia.LibrosDAO;

public class GestionLibreria implements ItfzGestionLibreria{

	ItfzLibrosDao miDao = new LibrosDAO();
	List<Libro> misLibros = null;
	Libro miLibro = null;
	boolean resultado = false;
			
	public ItfzLibrosDao getMiDao() {
		return miDao;
	}

	public void setMiDao(ItfzLibrosDao miDao) {
		this.miDao = miDao;
	}

	@Override
	public boolean altaLibro(Libro libro) {
		return miDao.altaLibro(libro);
	}
	@Override
	public boolean eliminarLibro(String ISBN) throws LibroNoEncontradoException{
		return miDao.eliminarLibro(ISBN);
	}

	@Override
	public List<Libro> consultarTodos() throws LibroNoEncontradoException{
		try{
			misLibros = miDao.consultarTodos();
		}catch(Exception e){
			throw new LibroNoEncontradoException();
		}
		return misLibros;
	}

	@Override
	public Libro consultarISBN(String ISBN) throws LibroNoEncontradoException{
		try{
			miLibro = miDao.consultarISBN(ISBN);
		}catch(Exception e){
			throw new LibroNoEncontradoException();
		}
		return miLibro;
	}

	@Override
	public List<Libro> consultarTitulo(String titulo) throws LibroNoEncontradoException{
		try{
			misLibros = miDao.consultarTitulo(titulo);
		}catch(Exception e){
			throw new LibroNoEncontradoException();
		}
		return misLibros;
	}

	@Override
	public boolean modificarPrecio(String ISBN, double precio) {
		return miDao.modificarPrecio(ISBN, precio);
	}
	
}
