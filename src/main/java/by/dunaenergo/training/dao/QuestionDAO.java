package by.dunaenergo.training.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import by.dunaenergo.training.model.Question;

public class QuestionDAO {
	private Session session;

	public QuestionDAO(Session session) {
		super();
		this.session = session;
	}

	public boolean checkQuestion(String q_name) {
		Question q = null;
		try {
			Query query = session.getNamedQuery("findQuestion");
			query.setParameter("param", q_name);
			q = (Question) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return q != null;
	}

	public Question getQuestion(String text) {
		Question q = null;
		try {
			Query query = session.createQuery("FROM Question WHERE short_name=:param");
			query.setString("param", text);
			q = (Question) query.uniqueResult();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;
	}

	public void addQuestion(Question q) {
		Transaction t = null;
		try {
			t = session.beginTransaction();
			session.save(q);
			t.commit();
			Query query = session.createQuery("FROM Question WHERE name=:param");
			query.setString("param", q.getName());
			q = (Question) query.uniqueResult();
			String shortname = "Вопрос " + q.getId();
			q.setShort_name(shortname);
			t = session.beginTransaction();
			session.update(q);
			t.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			t.rollback();
		}

	}

	public void deleteQuestion(Question q) {
		Transaction t = null;
		try {
			t = session.beginTransaction();
			session.delete(q);
			t.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			t.rollback();
		}

	}

	public void updateQuestion(Question q) {
		Transaction t = null;
		try {
			t = session.beginTransaction();
			session.update(q);
			t.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			t.rollback();
		}

	}

}
