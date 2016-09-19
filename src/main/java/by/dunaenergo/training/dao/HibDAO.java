package by.dunaenergo.training.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import by.dunaenergo.training.interfaces.UserDAO;
import by.dunaenergo.training.model.Part;

public class HibDAO implements UserDAO {

	private SessionFactory sessionFactory;

	public HibDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Part> list() {
		@SuppressWarnings("unchecked")
		List<Part> list = (List<Part>) sessionFactory.getCurrentSession().createCriteria(Part.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

	@Override
	@Transactional
	public Part getPartitionByName(String name) {
		Part partition = (Part) sessionFactory.getCurrentSession().createCriteria(Part.class).add(Restrictions.eq("name", name)).uniqueResult();
		return partition;
	}

}
