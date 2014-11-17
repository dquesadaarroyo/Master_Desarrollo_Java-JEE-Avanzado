package app.cliente;


import app.excepciones.LibroNoEncontradoException;
import app.modelo.Libro;
import app.negocio.GestionLibreria;
import app.negocio.ItfzGestionLibreria;

/**
 * Con esta clase ejecutaremos todos los métodos de lectura, modificación y eliminación de la base de datos. 
 * Si al hacer una búsqueda de un libro, no obtenemos resultado, lanzaremos un error personalizado, LibroNoEncontradoException.
 * @author danielquesadaarroyo
 *
 */
public class Main_Leer {
	public static void main(String[] args) {

		ItfzGestionLibreria miGestion = new GestionLibreria();
		Libro miLibro = null;
		boolean correcto = false;
		
		
		/* Eliminamos uno de los libros de la base de datos */
		try{
			System.out.println("\n\nEliminamos uno de los libros filtrando por isbn:");
			correcto = miGestion.eliminarLibro("9788432220364");
			if(correcto){
				System.out.println("¡¡ENHORABUENA!! Se ha eliminado el libro correctamente");
			}else{
				System.out.println("¡¡UPPSS!! No se ha podido eliminar el libro");	
			}
		}catch(LibroNoEncontradoException e){
			System.out.println(e.excErrorPersonalizado() + " No se ha podido eliminar el libro");
		}
		
		
		/*Probamos a eliminar uno de los libros, pero dando un error controlado LibroNoEncontradoException 
		 * ya que el isbn '3' no existe en la base de datos y no va a ser encontrado.*/
		try{
			System.out.println("\n\nEliminamos uno de los libros filtrando por isbn pero provocando un error:");
			correcto = miGestion.eliminarLibro("3");
			if(correcto){
				System.out.println("¡¡ENHORABUENA!! Se ha eliminado el libro correctamente");
			}else{
				System.out.println("¡¡UPPSS!! No se ha podido eliminar el libro");	
			}
		}catch(LibroNoEncontradoException e){
			System.out.println(e.excErrorPersonalizado() + " No se ha podido eliminar el libro");
		}
		
		/*Consulta de todos los libros existentes en la base de datos*/
		System.out.println("\n\nConsultamos todos los libros:");
		try{
			for(Libro l : miGestion.consultarTodos()){
				System.out.println(l.toString());
			}
		}catch(LibroNoEncontradoException e){
			System.out.println(e.excErrorPersonalizado());
		}
        
        /*Consulta de uno de los libros filtrando por ISBN. En este ejemplo, se dará un error controlado
         * ya que no existe ningún libro con ISBN '5'.*/
		System.out.println("\n\nConsultamos uno de los libros filtrando por ISBN pero provocamos un error controlado:");
		try{
			miLibro = miGestion.consultarISBN("5");
			System.out.println(miLibro.toString());
		}catch(LibroNoEncontradoException e){
			System.out.println(e.excErrorPersonalizado());
		}
		
		/*Consulta de uno de los libros filtrando por ISBN.En este ejemplo, se dará un error controlado
         * ya que no existe ningún libro con ISBN '5'.*/
		System.out.println("\n\nConsultamos uno de los libros filtrando por ISBN:");
		try{
			miLibro = miGestion.consultarISBN("9788408127437");
			System.out.println(miLibro.toString());
		}catch(LibroNoEncontradoException e){
			System.out.println(e.excErrorPersonalizado());
		}
		
		/*Consulta de uno de los libros filtrando por titulo.En este ejemplo, se dará un error controlado
         * ya que no existe ningún libro que contenga en el titulo la palabra 'ejemplo'.*/
		System.out.println("\n\nConsultamos uno de los libros filtrando por el título pero dando error controlado:");
		try{	
			for(Libro l : miGestion.consultarTitulo("ejemplo")){
				System.out.println(l.toString());
			}
		}catch(LibroNoEncontradoException e){
			System.out.println(e.excErrorPersonalizado());
		}
		
		/*Consulta de uno de los libros filtrando por titulo.*/
		System.out.println("\n\nConsultamos uno de los libros filtrando por el título:");
		try{	
			for(Libro l : miGestion.consultarTitulo("cartas")){
				System.out.println(l.toString());
			}
		}catch(LibroNoEncontradoException e){
			System.out.println(e.excErrorPersonalizado());
		}
		
		/*Modificamos el precio de un libro, filtrando por ISBN e indicandole su nuevo precio.*/
		System.out.println("\n\nModificamos el precio de uno de los libros indicando cual es el nuevo precio y filtrando por isbn:");
		correcto = miGestion.modificarPrecio("9788408127437", 897);
		if(correcto){
			System.out.println("¡¡ENHORABUENA!!Se ha modificado el precio correctamente");
		}else{
			System.out.println("¡¡UPPSS!!No se ha podido modificar el precio");	
		}
		
		/*Modificamos el precio de un libro, filtrando por ISBN e indicandole su nuevo precio.En este ejemplo, se dará un error controlado,
		 * pero no utilizando la clase LibroNoEncontradoException, sino utilizando una variable boolean que nos dirá si se ha modificado
		 * algún libro en la base de datos o no.
		 */
		System.out.println("\n\nModificamos el precio de uno de los libros indicando cual es el nuevo precio y filtrando por isbn:");
		correcto = miGestion.modificarPrecio("5", 897);
		if(correcto){
			System.out.println("¡¡ENHORABUENA!!Se ha modificado el precio correctamente");
		}else{
			System.out.println("¡¡UPPSS!!No se ha podido modificar el precio");	
		}

		
	}
}
