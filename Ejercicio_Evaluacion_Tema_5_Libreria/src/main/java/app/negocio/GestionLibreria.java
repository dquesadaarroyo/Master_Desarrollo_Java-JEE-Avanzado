package app.negocio;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import app.excepciones.LibroNoEncontradoException;
import app.modelo.Autor;
import app.modelo.Editorial;
import app.modelo.Libro;
import app.persistencia.AutorDAO;
import app.persistencia.EditorialDAO;
import app.persistencia.ItfzAutorDAO;
import app.persistencia.ItfzEditorialDAO;
import app.persistencia.ItfzLibrosDAO;
import app.persistencia.LibrosDAO;


@ManagedBean(name="miGestionLibreria", eager=true)
@ApplicationScoped
public class GestionLibreria implements ItfzGestionLibreria{

	ItfzLibrosDAO miLibroDao = new LibrosDAO();
	ItfzAutorDAO miAutorDao = new AutorDAO();
	ItfzEditorialDAO miEditorialDao = new EditorialDAO();
	List<Libro> misLibros = null;
	List<Editorial> misEditoriales = null;
	Libro miLibro = null;
	boolean resultado = false;
			
	public ItfzLibrosDAO getmiLibroDao() {
		return miLibroDao;
	}

	public void setmiLibroDao(ItfzLibrosDAO miLibroDao) {
		this.miLibroDao = miLibroDao;
	}

	@Override
	public boolean altaLibro(Libro libro) {
		return miLibroDao.altaLibro(libro);
	}
	@Override
	public boolean eliminarLibro(String ISBN) throws LibroNoEncontradoException{
		return miLibroDao.eliminarLibro(ISBN);
	}

	@Override
	public List<Libro> consultarTodos() throws LibroNoEncontradoException{
		try{
			misLibros = miLibroDao.consultarTodos();
		}catch(Exception e){
			throw new LibroNoEncontradoException();
		}
		return misLibros;
	}

	@Override
	public Libro consultarISBN(String ISBN) throws LibroNoEncontradoException{
		try{
			miLibro = miLibroDao.consultarISBN(ISBN);
		}catch(Exception e){
			throw new LibroNoEncontradoException();
		}
		return miLibro;
	}

	@Override
	public List<Libro> consultarTitulo(String titulo) throws LibroNoEncontradoException{
		try{
			misLibros = miLibroDao.consultarTitulo(titulo);
		}catch(Exception e){
			throw new LibroNoEncontradoException();
		}
		return misLibros;
	}

	@Override
	public boolean modificarPrecio(String ISBN, double precio) {
		return miLibroDao.modificarPrecio(ISBN, precio);
	}

	@Override
	public List<Autor> consultarAutores() {
		return miAutorDao.consultarAutores();
	}
	
	public List<Libro> consultarLibroPorAutor(long idAutor) throws LibroNoEncontradoException{
		try{
			misLibros = miLibroDao.consultarLibroPorAutor(idAutor);
		}catch(Exception e){
			throw new LibroNoEncontradoException();
		}
		return misLibros;
	}
	
	public List<Editorial> consultarEditoriales(){
		return miEditorialDao.consultarEditoriales();
	}

	@Override
	public List<Libro> consultarLibroPorEditorial(long idEditorial) throws LibroNoEncontradoException {
		try{
			misLibros = miLibroDao.consultarLibroPorEditorial(idEditorial);
		}catch(Exception e){
			throw new LibroNoEncontradoException();
		}
		return misLibros;
	}

	@Override
	public List<Libro> autoCompletaTitulo(String titulo) {
		misLibros = miLibroDao.autoCompletaTitulo(titulo);
		
		return misLibros;
	}

	@Override
	public List<Libro> librosPorTitulo(String titulo) throws LibroNoEncontradoException{
		misLibros = miLibroDao.librosPorTitulo(titulo);
		return null;
	}
	
	
}
