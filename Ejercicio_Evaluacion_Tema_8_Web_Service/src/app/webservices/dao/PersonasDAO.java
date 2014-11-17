package app.webservices.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import app.webservices.modelo.Persona;

public class PersonasDAO implements ItfzPersonasDAO{

	private Transaction tx = null;
	private Session session = null;
	private Persona miPersona=null;
	
	private Session getHibernateTemplate() {
		this.session = app.webservices.utilidades.HibernateUtil.getSessionFactory().openSession();
		this.setTx(session.beginTransaction());
		
		return session;
	}

	public Transaction getTx() {
		return tx;
	}

	public void setTx(Transaction tx) {
		this.tx = tx;
	}

	public Persona getMiPersona() {
		return miPersona;
	}

	public void setMiPersona(Persona miPersona) {
		this.miPersona = miPersona;
	}

	@Override
	public Persona consultarPersona(long id) {		
		try {
			session = getHibernateTemplate();
			Query q = session.createQuery("select p from Persona p where p.idPersona = :idPERSONAS");
			q.setParameter("idPERSONAS", id);
			miPersona = (Persona) q.uniqueResult();
	    } catch (HibernateException e) {
				System.out.println(e.getMessage());
	    }
		
		return miPersona;
	}
	
	
	
	
}
