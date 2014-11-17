package app.persistencia;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import app.excepciones.LibroNoEncontradoException;
import app.modelo.Libro;
import app.utilidades.Interceptor;


public class LibrosDAO implements ItfzLibrosDAO{
	
	private boolean resultado = false;
	private List<Libro> misLibros = null;
	private Libro miLibro = null;
	private Transaction tx = null;
	private Session session = null;
	
	public LibrosDAO(){

	}

	private Session getHibernateTemplate() {
		this.session = app.utilidades.HibernateUtil.getSessionFactory().openSession(new Interceptor());
		this.tx = session.beginTransaction();
		
		return session;
	}

	private Session getHibernateTemplateUpdate() {
		session = app.utilidades.HibernateUtilUpdate.getSessionFactory().openSession();
		this.tx = session.beginTransaction();
		
		return session;
	}
	
	@Override
	public boolean altaLibro(Libro libro) {
		
		resultado = false;
		
		try {
			session = getHibernateTemplate();
			session.save(libro);
		    tx.commit();
		    
		    resultado = true;
	    } catch (HibernateException e) {
	    	session.getTransaction().rollback();
	    	System.out.println(e.getMessage());
		}
			
		return resultado;
	}

	@Override
	public boolean eliminarLibro(String ISBN) throws LibroNoEncontradoException{
		resultado = false;
		
		try {
			session = getHibernateTemplateUpdate();
			Query q = session.createQuery("select l from Libro l where l.isbn = :isbn");
			q.setParameter("isbn", ISBN);
			miLibro = (Libro) q.uniqueResult();
			
			if(miLibro == null){
				throw new LibroNoEncontradoException();
			}
			
			session.delete(miLibro);
			tx.commit();
		
			resultado = true;

	    } catch (HibernateException e) {
				System.out.println(e.getMessage());
	    }
		
		return resultado;
	}

	@Override
	public List<Libro> consultarTodos() throws LibroNoEncontradoException{
		try {
			session = getHibernateTemplateUpdate();
			Query q = session.createQuery("from Libro l");
			misLibros = q.list();
			
			if(misLibros.size() == 0){
				throw new LibroNoEncontradoException();
			}
	    } catch (HibernateException e) {
				System.out.println(e.getMessage());
		}
		
		return misLibros;
	}

	@Override
	public Libro consultarISBN(String ISBN) throws LibroNoEncontradoException{
		try{	
			session = getHibernateTemplateUpdate();
			Query q = session.createQuery("from Libro l where l.isbn = :isbn");
			q.setParameter("isbn", ISBN);
			miLibro = (Libro) q.uniqueResult();
			
			if(miLibro == null){
				throw new LibroNoEncontradoException();
			}
			
		} catch (HibernateException e) {
				System.out.println(e.getMessage());
		}
		
		return miLibro;
	}

	@Override
	public List<Libro> consultarTitulo(String titulo) throws LibroNoEncontradoException{
		try{
			session = getHibernateTemplateUpdate();
			Query q = session.createQuery("from Libro l where l.titulo like :titulo");
			q.setParameter("titulo", "%" + titulo + "%");
			misLibros = q.list();
			
			if(misLibros.size() == 0){
				throw new LibroNoEncontradoException();
			}
	    } catch (HibernateException e) {
				System.out.println(e.getMessage());
		}
		
		return misLibros;
	}

	@Override
	public boolean modificarPrecio(String ISBN, double precio) {
		
		resultado = false;
		
		try {
			session = getHibernateTemplateUpdate();
			Query q = session.createQuery("update Libro set precio = :precio where isbn = :isbn");
			q.setParameter("precio", precio);
			q.setParameter("isbn", ISBN);
			int rowCount = q.executeUpdate();
			
			if(rowCount != 0){
				tx.commit();
				resultado = true;
			}
	    } catch (HibernateException e) {
	    	System.out.println(e.getMessage());
	    	session.getTransaction().rollback();
		}
		
		return resultado;
	}

	@Override
	public List<Libro> consultarLibroPorAutor(long idAutor) throws LibroNoEncontradoException {
		try{	
			session = getHibernateTemplateUpdate();
			Query q = session.createQuery("select l from Libro l join l.autores a where a.id = :idAutor");
			q.setParameter("idAutor", idAutor);
			misLibros = q.list();
			
			if(misLibros.size() == 0){
				throw new LibroNoEncontradoException();
			}
	    } catch (HibernateException e) {
				System.out.println(e.getMessage());
		}
		
		return misLibros;
	}

	@Override
	public List<Libro> consultarLibroPorEditorial(long idEditorial) throws LibroNoEncontradoException {
		try{	
			session = getHibernateTemplateUpdate();
			Query q = session.createQuery("select l from Libro l where l.editorial.id = :idEditorial");
			q.setParameter("idEditorial", idEditorial);
			misLibros = q.list();
			
			if(misLibros.size() == 0){
				throw new LibroNoEncontradoException();
			}
	    } catch (HibernateException e) {
				System.out.println(e.getMessage());
		}
		
		return misLibros;
	}

	@Override
	public List<Libro> autoCompletaTitulo(String titulo) {
		try{
			session = getHibernateTemplateUpdate();
			Query q = session.createQuery("select l from Libro l where l.titulo like :titulo");
			q.setParameter("titulo", "%" + titulo +"%");
			misLibros = q.list();
			
	    } catch(HibernateException e) {
				System.out.println(e.getMessage());
		}	
		return misLibros;
	}
}

