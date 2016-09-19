package by.dunaenergo.training.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import by.dunaenergo.training.model.Answer;

public class AnswerDAO {
	private Session session;

	public AnswerDAO(Session session) {
		super();
		this.session = session;
	}

	public Answer getAnswer(String text) {
		Answer answer = null;
		try {
			Query query = session.getNamedQuery("Получаем ответ по полю text");
			query.setParameter("text", text);
			answer = (Answer) query.uniqueResult();
			System.out.println(answer);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answer;
	}

	public void addAnswer(Answer a) {
		Transaction t = null;
		try {
			t = session.beginTransaction();
			session.save(a);
			t.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			t.rollback();
		}

	}

	public void deleteAnswer(Answer a) {
		Transaction t = null;
		try {
			t = session.beginTransaction();
			session.delete(a);
			t.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			t.rollback();
		}

	}

	public void updateAnswer(Answer a) {
		Transaction t = null;
		try {
			t = session.beginTransaction();
			session.update(a);
			t.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			t.rollback();
		}

	}

}
