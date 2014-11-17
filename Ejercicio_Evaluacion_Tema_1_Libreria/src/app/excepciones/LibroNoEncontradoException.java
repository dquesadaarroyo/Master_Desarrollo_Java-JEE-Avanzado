package app.excepciones;

/**
 * Excepcion personalizada, que ser‡ ejecutada cuando no se encuentren datos en la base de datos.
 * 
 * @author danielquesadaarroyo
 *
 */
public class LibroNoEncontradoException extends Exception{

	private static final long serialVersionUID = 1L;

	public LibroNoEncontradoException(){
		
	}
	
	// Excepcion: Error personalizado que mostrar‡ un mensaje al no encontrar el libro que buscamos
    public String excErrorPersonalizado(){
        return "ERROR --> No se ha encontrado ningœn libro con estos datos en la Base de Datos. \n"
        	 + "          Error capturado por LibroNoEncontradoException .";
    }

}
