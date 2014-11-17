package app.cliente;

import app.webservices.dao.ItfzPersonasDAO;
import app.webservices.dao.PersonasDAO;
import app.webservices.modelo.Persona;
import app.webservices.negocio.Gestion;
import app.webservices.negocio.ItfzGestion;

/**
 * Con esta clase ejecutaremos todos los métodos de lectura, modificación y eliminación de la base de datos. 
 * Si al hacer una búsqueda de un libro, no obtenemos resultado, lanzaremos un error personalizado, LibroNoEncontradoException.
 * @author danielquesadaarroyo
 *
 */
public class Main_Leer {
	public static void main(String[] args) {

		ItfzGestion miGestion = new Gestion();
		Persona miPersona = null;		
		
		/*Consulta de uno de los libros filtrando por titulo.*/
		System.out.println("\n\nConsultamos uno de los libros filtrando por el título:");
		miPersona = miGestion.consultarPersona(2);
		System.out.println(miPersona.toString());		
	}
}
