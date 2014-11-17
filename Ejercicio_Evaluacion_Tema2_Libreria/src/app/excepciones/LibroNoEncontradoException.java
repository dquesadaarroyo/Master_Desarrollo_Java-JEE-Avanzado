package app.excepciones;


/**
 *  Excepcion: Error personalizado que mostrar� un mensaje al no encontrar el libro que buscamos
 * @author danielquesadaarroyo
 *
 */
public class LibroNoEncontradoException extends Exception{
	
	public LibroNoEncontradoException(){
		
	}
	
    public String excErrorPersonalizado(){
        return "ERROR PROVOCADO. No se ha encontrado ning�n libro con esas caracteristicas.";
    }

}
