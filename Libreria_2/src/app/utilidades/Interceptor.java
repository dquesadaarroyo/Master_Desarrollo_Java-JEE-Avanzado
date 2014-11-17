package app.utilidades;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.EmptyInterceptor;


import app.modelo.Libro;

/**
 * Clase interceptora del evento de dar de alta un nuevo libro en la base de datos.
 * @author danielquesadaarroyo
 *
 */
public class Interceptor extends EmptyInterceptor implements Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public void postFlush(Iterator entities) {
	    while (entities.hasNext()) {
	    	Object miLibro = (Object) entities.next();
	    	if(miLibro instanceof Libro){
	    		System.out.println("Se ha insertado un nuevo libro en la base de datos: " + miLibro.toString());
	    	}
	    }
	}
	
	
}
