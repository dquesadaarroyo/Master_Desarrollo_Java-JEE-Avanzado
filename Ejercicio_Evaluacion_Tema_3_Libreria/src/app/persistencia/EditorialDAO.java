package app.persistencia;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import app.modelo.Autor;
import app.modelo.Editorial;

public class EditorialDAO  implements ItfzEditorialDAO{
	
	private List<Editorial> misEditoriales = null;
	private Transaction tx = null;
	private Session session = null;
	
	public EditorialDAO(){

	}
	
	private Session getHibernateTemplateUpdate() {
		session = app.utilidades.HibernateUtilUpdate.getSessionFactory().openSession();
		this.tx = session.beginTransaction();
		
		return session;
	}
	
	public List<Editorial> consultarEditoriales(){
		try {
			session = getHibernateTemplateUpdate();
			Query q = session.createQuery("select e from Editorial e");
			misEditoriales = (List<Editorial>) q.list();

	    } catch (HibernateException e) {
				System.out.println(e.getMessage());
		}
		
		return misEditoriales;
	}

}
