package app.utilidades;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.EmptyInterceptor;


import app.modelo.Libro;

public class Interceptor extends EmptyInterceptor implements Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public void postFlush(Iterator entities) {
	    int i =0;
	    while (entities.hasNext()) {
	    	Object miLibro = (Object) entities.next();
	    	if(miLibro instanceof Libro){
	    		System.out.println("Se ha insertado un nuevo libro en la base de datos: " + miLibro.toString());
	    	}
	    }
	}
	
	
}
