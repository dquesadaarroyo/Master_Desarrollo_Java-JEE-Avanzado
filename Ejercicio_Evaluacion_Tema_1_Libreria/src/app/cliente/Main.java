package app.cliente;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import app.excepciones.LibroNoEncontradoException;
import app.modelo.Libro;
import app.negocio.GestionLibreria;
import app.negocio.ItfzGestionLibreria;

/** 
 * Clase principal que ejecutará todos los métodos propuestos en el enunciado del ejercicio.
 * 
 * @author danielquesadaarroyo
 *
 */

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext contexto = new ClassPathXmlApplicationContext("spring.xml");
		Libro miLibro = null;
		boolean correcto = false;
		
		ItfzGestionLibreria miGestion = contexto.getBean("gestionLibreria", GestionLibreria.class);
		Libro miLibro1 = contexto.getBean("miLibro1", Libro.class);
		Libro miLibro2 = contexto.getBean("miLibro2", Libro.class);
		Libro miLibro3 = contexto.getBean("miLibro3", Libro.class);
		Libro miLibro4 = contexto.getBean("miLibro4", Libro.class);
		Libro miLibro5 = contexto.getBean("miLibro5", Libro.class);
		
		miGestion.altaLibro(miLibro1);
		miGestion.altaLibro(miLibro2);
		miGestion.altaLibro(miLibro3);
		miGestion.altaLibro(miLibro4);
		miGestion.altaLibro(miLibro5);
		
		//Consultar todos los libros de la base de datos
		System.out.println("\n\nConsultamos todos los libros:");
		try{
			for(Libro l : miGestion.consultarTodos()){
				System.out.println(l.toString());
			}
		}catch(LibroNoEncontradoException e){
			System.out.println(e.excErrorPersonalizado());
		}
			
		System.out.println("\n\nConsultamos uno de los libros filtrando por ISBN:");
		try{
			miLibro = miGestion.consultarISBN("5");
			System.out.println(miLibro.toString());
		}catch(LibroNoEncontradoException e){
			System.out.println(e.excErrorPersonalizado());
		}
		
		System.out.println("\n\nConsultamos uno de los libros filtrando por el título:");
		try{	
			for(Libro l : miGestion.consultarTitulo("ejemplo4")){
				System.out.println(l.toString());
			}
		}catch(LibroNoEncontradoException e){
			System.out.println(e.excErrorPersonalizado());
		}
		
		System.out.println("\n\nModificamos el precio de uno de los libros indicando cual es el nuevo precio y filtrando por isbn:");
		correcto = miGestion.modificarPrecio("1", 897);
		if(correcto){
			System.out.println("¡¡ENHORABUENA!!Se ha modificado el precio correctamente");
		}else{
			System.out.println("¡¡UPPSS!!No se ha podido modificar el precio");	
		}
		//Consultar todos los libros de la base de datos
		System.out.println("\n\nMostramos todos los libros para revisar que se ha modificado el precio:");
		try{
			for(Libro l : miGestion.consultarTodos()){
				System.out.println(l.toString());
			}
		}catch(LibroNoEncontradoException e){
			System.out.println(e.excErrorPersonalizado());
		}
		
		System.out.println("\n\nEliminamos uno de los libros filtrando por isbn:");
		correcto = miGestion.eliminarLibro("2");
		if(correcto){
			System.out.println("¡¡ENHORABUENA!! Se ha eliminado el libro correctamente");
		}else{
			System.out.println("¡¡UPPSS!! No se ha podido eliminar el libro");	
		}
		
		//Consultar todos los libros de la base de datos
		System.out.println("\n\nConsultamos todos los libros para ver que se ha eliminado el que queriamos:");
		try{
			for(Libro l : miGestion.consultarTodos()){
				System.out.println(l.toString());
			}
		}catch(LibroNoEncontradoException e){
			System.out.println(e.excErrorPersonalizado());
		}
		
	}
}
