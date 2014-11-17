package app.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import app.modelo.Libro;

/**
 * Clase mapeadora, con la que recogemos los datos de la base de datos.
 * 
 * @author danielquesadaarroyo
 *
 */
public class Mapeador implements RowMapper<Libro>{

	@Override
	public Libro mapRow(ResultSet rs, int i) throws SQLException {
		Libro miLibro = new Libro();
		miLibro.setTitulo(rs.getString("TITULO"));
		miLibro.setAutor(rs.getString("AUTOR"));
		miLibro.setEditorial(rs.getString("EDITORIAL"));
		miLibro.setIsbn(rs.getString("ISBN"));
		miLibro.setPublicacion(rs.getInt("PUBLICACION"));
		miLibro.setPrecio(rs.getDouble("PRECIO"));
		miLibro.setDescripcion(rs.getString("DESCRIPCION"));
		
		return miLibro;
	}
	
}