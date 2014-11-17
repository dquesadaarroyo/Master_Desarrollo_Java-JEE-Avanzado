package app.persistencia;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import app.modelo.Autor;


public class AutorDAO implements ItfzAutorDAO{
		
	private List<Autor> misAutores = null;
	private Transaction tx = null;
	private Session session = null;
	
	public AutorDAO(){

	}
	
	private Session getHibernateTemplateUpdate() {
		session = app.utilidades.HibernateUtilUpdate.getSessionFactory().openSession();
		this.tx = session.beginTransaction();
		
		return session;
	}
	
	public List<Autor> consultarAutores() {
		try {
			session = getHibernateTemplateUpdate();
			Query q = session.createQuery("select a from Autor a");
			misAutores = (List<Autor>) q.list();

	    } catch (HibernateException e) {
				System.out.println(e.getMessage());
		}
		
		return misAutores;
	}
	
}
