package app.excepciones;

public class LibroNoEncontradoException extends Exception{
	
	public LibroNoEncontradoException(){
		
	}
	
	// Excepcion: Error personalizado que mostrar‡ un mensaje al no encontrar el libro que buscamos
    public String excErrorPersonalizado(){
        return "ERROR PROVOCADO. No se ha encontrado ningœn libro con esas caracteristicas.";
    }

}
