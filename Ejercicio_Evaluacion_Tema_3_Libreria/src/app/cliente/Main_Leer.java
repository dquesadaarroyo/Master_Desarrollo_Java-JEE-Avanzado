package app.cliente;


import app.excepciones.LibroNoEncontradoException;
import app.modelo.Libro;
import app.negocio.GestionLibreria;
import app.negocio.ItfzGestionLibreria;

public class Main_Leer {
	public static void main(String[] args) {

		ItfzGestionLibreria miGestion = new GestionLibreria();
		Libro miLibro = null;
		boolean correcto = false;
		
		
		try{
			System.out.println("\n\nEliminamos uno de los libros filtrando por isbn:");
			correcto = miGestion.eliminarLibro("9788432220364");
			if(correcto){
				System.out.println("좋ENHORABUENA!! Se ha eliminado el libro correctamente");
			}else{
				System.out.println("좋UPPSS!! No se ha podido eliminar el libro");	
			}
		}catch(LibroNoEncontradoException e){
			System.out.println(e.excErrorPersonalizado() + " No se ha podido eliminar el libro");
		}
		
		try{
			System.out.println("\n\nEliminamos uno de los libros filtrando por isbn:");
			correcto = miGestion.eliminarLibro("3");
			if(correcto){
				System.out.println("좋ENHORABUENA!! Se ha eliminado el libro correctamente");
			}else{
				System.out.println("좋UPPSS!! No se ha podido eliminar el libro");	
			}
		}catch(LibroNoEncontradoException e){
			System.out.println(e.excErrorPersonalizado() + " No se ha podido eliminar el libro");
		}
		
		
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
		
		System.out.println("\n\nConsultamos uno de los libros filtrando por ISBN:");
		try{
			miLibro = miGestion.consultarISBN("9788408127437");
			System.out.println(miLibro.toString());
		}catch(LibroNoEncontradoException e){
			System.out.println(e.excErrorPersonalizado());
		}
        
		System.out.println("\n\nConsultamos uno de los libros filtrando por el t뭪ulo:");
		try{	
			for(Libro l : miGestion.consultarTitulo("ejemplo")){
				System.out.println(l.toString());
			}
		}catch(LibroNoEncontradoException e){
			System.out.println(e.excErrorPersonalizado());
		}
		
		System.out.println("\n\nConsultamos uno de los libros filtrando por el t뭪ulo:");
		try{	
			for(Libro l : miGestion.consultarTitulo("cartas")){
				System.out.println(l.toString());
			}
		}catch(LibroNoEncontradoException e){
			System.out.println(e.excErrorPersonalizado());
		}
		
		System.out.println("\n\nModificamos el precio de uno de los libros indicando cual es el nuevo precio y filtrando por isbn:");
		correcto = miGestion.modificarPrecio("9788408127437", 897);
		if(correcto){
			System.out.println("좋ENHORABUENA!!Se ha modificado el precio correctamente");
		}else{
			System.out.println("좋UPPSS!!No se ha podido modificar el precio");	
		}
        
		System.out.println("\n\nModificamos el precio de uno de los libros indicando cual es el nuevo precio y filtrando por isbn:");
		correcto = miGestion.modificarPrecio("5", 897);
		if(correcto){
			System.out.println("좋ENHORABUENA!!Se ha modificado el precio correctamente");
		}else{
			System.out.println("좋UPPSS!!No se ha podido modificar el precio");	
		}

		
	}
}
