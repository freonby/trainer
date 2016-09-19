package by.dunaenergo.training.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import by.dunaenergo.training.model.Theme;

public class ThemeDAO {
	private Session session;

	public ThemeDAO(Session session) {
		super();
		this.session = session;
	}

	public boolean checkTheme(String th_name) {
		Theme th = null;
		try {
			Query query = session.getNamedQuery("findTheme");
			query.setParameter("param", th_name);
			th = (Theme) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return th != null;
	}

	public Theme getTheme(String text) {
		Theme t = null;
		try {
			Query query = session.createQuery("FROM Theme WHERE name=:param");
			query.setString("param", text);
			t = (Theme) query.uniqueResult();
		} catch (HibernateException e) {

			e.printStackTrace();
		}
		return t;
	}

	public void addTheme(Theme th) {
		Transaction t = null;
		try {
			t = session.beginTransaction();
			session.save(th);
			t.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			t.rollback();
		}
	}

	public void deleteTheme(Theme th) {
		Transaction t = null;
		try {
			t = session.beginTransaction();
			session.delete(th);
			t.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			t.rollback();
		}

	}

	public void updateTheme(Theme th) {
		Transaction t = null;
		try {
			t = session.beginTransaction();
			session.update(th);
			t.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			t.rollback();
		}

	}

}
