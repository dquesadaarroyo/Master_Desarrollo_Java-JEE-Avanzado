package app.excepciones;

public class LibroNoEncontradoException extends Exception{
	
	public LibroNoEncontradoException(){
		
	}
	
	// Excepcion: Error personalizado que mostrar� un mensaje al no encontrar el libro que buscamos
    public String excErrorPersonalizado(){
        return "ERROR PROVOCADO. No se ha encontrado ning�n libro con esas caracteristicas.";
    }

}
