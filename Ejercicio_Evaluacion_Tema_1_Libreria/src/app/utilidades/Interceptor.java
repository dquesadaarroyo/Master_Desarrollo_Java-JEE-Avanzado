package app.utilidades;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;

import app.modelo.Libro;


/** Clase controlada por un aspecto, definido en spring.xml, que se ejecutará siempre que 
 * se intente dar de alta un nuevo libro. Dependiendo del resultado del alta, mostrará un mensaje u otro.
 * 
 * @author danielquesadaarroyo
 *
 */
public class Interceptor {
	
	public void interceptarAltaLibro(JoinPoint joinPoint, Object result){
		if ((boolean)result){			
			System.out.println("****** ¡¡ENHORABUENA!! Ha insertado un nuevo libro en la base de datos");
		}else{
			System.out.println("****** ¡¡ERROR!! No hemos podido inserta un nuevo libro en la base de datos");
		}
	}
}
