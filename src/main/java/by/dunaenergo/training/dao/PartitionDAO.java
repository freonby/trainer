package by.dunaenergo.training.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import by.dunaenergo.training.model.Part;

public class PartitionDAO {
	private Session session;

	public PartitionDAO(Session session) {
		super();
		this.session = session;
	}

	public boolean checkPartition(String part_name) {
		Part p = null;
		try {
			Query query = session.getNamedQuery("findPartition");
			query.setParameter("param", part_name);
			p = (Part) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return p != null;
	}

	public Part getPartition(String text) {
		Part p = null;
		try {
			Query query = session.createQuery("FROM Part WHERE name=:param");
			query.setString("param", text);
			p = (Part) query.uniqueResult();
		} catch (HibernateException e) {

			e.printStackTrace();
		}
		return p;
	}

	public void addPartition(Part p) {
		Transaction t = null;
		try {
			t = session.beginTransaction();
			session.save(p);
			t.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			t.rollback();
		}

	}

	public void deletePartition(Part p) {
		Transaction t = null;
		try {
			t = session.beginTransaction();
			session.delete(p);
			t.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			t.rollback();
		}

	}

	public void updatePartition(Part p) {
		Transaction t = null;
		try {
			t = session.beginTransaction();
			session.update(p);
			t.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			t.rollback();
		}

	}

}