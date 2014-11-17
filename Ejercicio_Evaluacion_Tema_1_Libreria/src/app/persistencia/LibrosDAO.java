package app.persistencia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import app.excepciones.LibroNoEncontradoException;
import app.modelo.Libro;


public class LibrosDAO implements ItfzLibrosDao{
	
    private NamedParameterJdbcTemplate plantilla;
    private RowMapper<Libro> mapeadorLibro;
    Libro miLibro = null;
    List<Libro> misLibros = null;
    
    /* Métodos get y set */

    public NamedParameterJdbcTemplate getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(NamedParameterJdbcTemplate plantilla) {
		this.plantilla = plantilla;
	}

	public RowMapper<Libro> getMapeadorLibro() {
		return mapeadorLibro;
	}

	public void setMapeadorLibro(RowMapper<Libro> mapeadorLibro) {
		this.mapeadorLibro = mapeadorLibro;
	}

	/* FIN métodos get y set */
	
	/**
	 * Método que recibe un libro, y que lo da de alta en la base de datos.
	 */
	@Override
	public boolean altaLibro(Libro libro) {
		
		boolean correcto = false;
		
		try{
			System.out.println("\nDatos del nuevo libro : ");
			System.out.println("Titulo --> " + libro.getTitulo());
			System.out.println("Autor --> " + libro.getAutor());
			System.out.println("Editorial --> " + libro.getEditorial());
			System.out.println("ISBN --> " + libro.getIsbn());
			System.out.println("Publicación --> " + libro.getPublicacion());
			System.out.println("Precio --> " + libro.getPrecio());
			System.out.println("Descripción --> " + libro.getDescripcion());
			
			String sql = "INSERT INTO LIBROS VALUES(:titulo, :autor, :editorial, :isbn, :publicacion, :precio, :descripcion)";
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("titulo", libro.getTitulo());
			parametros.put("autor", libro.getAutor());
			parametros.put("editorial", libro.getEditorial());
			parametros.put("isbn", libro.getIsbn());
			parametros.put("publicacion", libro.getPublicacion());
			parametros.put("precio", libro.getPrecio());
			parametros.put("descripcion", libro.getDescripcion());
		
			plantilla.update(sql, parametros);
			correcto = true;
		}catch(Exception e){
			correcto = false;
		}

		return correcto;
	}

	/**
	 * Método a través del cual eliminaremos el libro con el ISBN recibido por parametro.
	 */
	@Override
	public boolean eliminarLibro(String ISBN) {
		
		boolean correcto = false;
		
		try{
			String sql = "DELETE FROM LIBROS WHERE ISBN=:isbn";
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("isbn", ISBN);
			
			int  i = plantilla.update(sql, parametros);

			if (i != 0){
				correcto = true;
			}else if(i == 0){
				correcto = false;
			}
		}catch(Exception e){
			System.out.println("Error al eliminar un libro -->  " + e.getMessage());
		}
		
		return correcto;
	}

	/**
	 * Método con el que consultamos todos los libros de la base de datos.
	 */
	@Override
	public List<Libro> consultarTodos()  throws LibroNoEncontradoException{
		String sql = "SELECT TITULO,AUTOR,EDITORIAL,ISBN,PUBLICACION,PRECIO,DESCRIPCION FROM LIBROS";
		
		try{
			misLibros = plantilla.query(sql, mapeadorLibro);
		}catch(Exception e){
			if(miLibro == null){
				throw new LibroNoEncontradoException();
			}else{
				System.out.println(e.getMessage());
			}
		}
		return misLibros;
	}

	/**
	 * Método con el que consultamos los libros con el ISBN recibido por parametro.
	 */
	@Override
	public Libro consultarISBN(String isbn) throws LibroNoEncontradoException{
		
		String sql = "SELECT TITULO,AUTOR,EDITORIAL,ISBN,PUBLICACION,PRECIO,DESCRIPCION FROM LIBROS WHERE ISBN = :isbn";
		Map<String,Object> parametros = new HashMap<>();
		parametros.put("isbn", isbn);
		
		try{
			miLibro = plantilla.queryForObject(sql, parametros, mapeadorLibro);
		}catch(Exception e){
			if(miLibro == null){
				throw new LibroNoEncontradoException();
			}else{
				System.out.println(e.getMessage());
			}
		}
		return miLibro;
	}

	/**
	 * Método con el que realizamos una búsqueda en la base de datos de aquellos libros que en su Titulo, contengan
	 * el String que recibe por parametro.
	 */
	@Override
	public List<Libro> consultarTitulo(String titulo)  throws LibroNoEncontradoException{
		String sql = "SELECT TITULO,AUTOR,EDITORIAL,ISBN,PUBLICACION,PRECIO,DESCRIPCION FROM LIBROS WHERE TITULO LIKE :titulo";

		Map<String,Object> parametros = new HashMap<>();
		parametros.put("titulo","%" + titulo + "%");
		
		try{
			misLibros = plantilla.query(sql, (Map<String,Object>)parametros,mapeadorLibro);
		}catch(Exception e){
			if(miLibro == null){
				throw new LibroNoEncontradoException();
			}else{
				System.out.println(e.getMessage());
			}
		}
		return misLibros;
	}

	/**
	 * Método con el que modificaremos el precio de un libro. El método recibe el ISBN y el nuevo precio.
	 */
	@Override
	public boolean modificarPrecio(String isbn, double precio) {
		
		boolean correcto = false;
		
		try{
			String sql = "UPDATE LIBROS SET PRECIO = :precio WHERE ISBN = :isbn";
			Map<String,Object> parametros = new HashMap<>();
			parametros.put("precio", precio);
			parametros.put("isbn", isbn);
			
			int i = plantilla.update(sql, parametros);
			
			if (i != 0){
				correcto = true;
			}else if(i == 0){
				correcto = false;
			}
			
		}catch(Exception e){
			System.out.println("Error al modificar el precio de un libro -->  " + e.getMessage());
		}
		
		return correcto;
	}

}
