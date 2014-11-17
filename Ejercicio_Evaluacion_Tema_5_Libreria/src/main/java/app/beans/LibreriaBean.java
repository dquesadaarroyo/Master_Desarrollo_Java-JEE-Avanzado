package app.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.springframework.beans.factory.annotation.Autowired;

import app.excepciones.LibroNoEncontradoException;
import app.modelo.Autor;
import app.modelo.Editorial;
import app.modelo.Libro;
import app.negocio.ItfzGestionLibreria;

@ManagedBean
@ApplicationScoped
public class LibreriaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Autor> misAutores = null;
	private List<Libro> misLibros = new ArrayList<Libro>();
	private List<Editorial> misEditoriales = null;
	private Long idAutor = (long) 0;
	private Long idEditorial = (long) 0;
	private Libro miLibro;

	@ManagedProperty(value = "#{miGestionLibreria}")
	private ItfzGestionLibreria miGestionLibreria;

	@PostConstruct
	public void init() {
		setMisAutores(miGestionLibreria.consultarAutores());
		setMisEditoriales(miGestionLibreria.consultarEditoriales());
	}

	public LibreriaBean() {

	}
	
	public ItfzGestionLibreria getMiGestionLibreria() {
		return miGestionLibreria;
	}

	public void setMiGestionLibreria(ItfzGestionLibreria miGestionLibreria) {
		this.miGestionLibreria = miGestionLibreria;
	}

	public List<Autor> getMisAutores() {
		return misAutores;
	}

	public void setMisAutores(List<Autor> misAutores) {
		this.misAutores = misAutores;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}

	public List<Libro> getMisLibros() {
		return misLibros;
	}

	public void setMisLibros(List<Libro> misLibros) {
		this.misLibros = misLibros;
	}

	public List<Editorial> getMisEditoriales() {
		return misEditoriales;
	}

	public void setMisEditoriales(List<Editorial> misEditoriales) {
		this.misEditoriales = misEditoriales;
	}

	public Long getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(Long idEditorial) {
		this.idEditorial = idEditorial;
	}

	public Libro getMiLibro() {
		return miLibro;
	}

	public void setMiLibro(Libro miLibro) {
		this.miLibro = miLibro;
	}

	/* Métodos que devuelven la página xhtml*/

	public String goToTitle() {
		this.miLibro=null;
		return "buscarTitulo";
	}

	public String goToEditorial() {
		this.idEditorial = (long)0;
		return "buscarEditorial";
	}

	public String goToIndex() {
		this.idAutor = (long)0;
		return "index";
	}

	

	/*Metodos con lógica de negocio*/

	//Método para guardar el ID del autor, con el que realizaremos la búsqueda en base de datos
	public void guardarIdAutor() {
		setIdAutor(idAutor);
	}
	
	//Método para guardar el ID del editorial, con el que realizaremos la búsqueda en base de datos
	public void guardarIdEditorial() {
		setIdEditorial(idEditorial);
	}

	//Método para buscar los libros asociados a un autor
	public List<Libro> librosPorAutor() {
		misLibros.clear();
		try {
			if (idAutor != 0 && idAutor != null) {
				misLibros = miGestionLibreria.consultarLibroPorAutor(idAutor);
			}
		} catch (LibroNoEncontradoException e) {
			System.out.println(e.excErrorPersonalizado()
					+ " No se ha podido eliminar el libro");
		}

		return misLibros;
	}

	//Método para buscar los libros asociados a una editorial
	public List<Libro> librosPorEditorial() {
		misLibros.clear();
		try {
			if (idEditorial != 0 && idEditorial != null) {
				misLibros = miGestionLibreria.consultarLibroPorEditorial(idEditorial);
			}
		} catch (LibroNoEncontradoException e) {
			System.out.println(e.excErrorPersonalizado()
					+ " No se ha podido eliminar el libro");
		}

		return misLibros;
	}

	//Método que autocompleta el titulo de un libro. Este método crea una lista con los libros que contienen el 
	//string que va introduciendo el usuario por pantalla.
	public List<Libro> librosPorTitulo(String titulo) {
		misLibros.clear();
		List<Libro> filtroLibros = new ArrayList<Libro>();
		try {
			misLibros = miGestionLibreria.consultarTodos();

			for (int i = 0; i < misLibros.size(); i++) {
				Libro libro = misLibros.get(i);
				if (libro.getTitulo().toLowerCase().contains(titulo)) {
					filtroLibros.add(libro);
				}
			}
		} catch (LibroNoEncontradoException e) {
			System.out.println(e.excErrorPersonalizado()
					+ " No se ha podido eliminar el libro");
		}

		return filtroLibros;
	}

}
