package app.webservices.utilidades;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase que nos servir‡ para conectarnos con la base de datos, estableciendo la variable hibernate.hbm2ddl.auto" en forma "create".
 * Esta clase la utilizaremos para crear las tablas y datos por primera vez.
 * @author danielquesadaarroyo
 *
 */
public class HibernateUtil {
   
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
    private static SessionFactory buildSessionFactory() {
        try {
        	  return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    public static SessionFactory getSessionFactory() {
    	return sessionFactory;
    }
  
    public static void shutdown() {
     // Close caches and connection pools
    	getSessionFactory().close();
    }

	
}