package matti.eshop.dao.hibernate;

import java.util.List;

import matti.eshop.dao.UserDao;
import matti.eshop.model.User;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateUserDao extends HibernateDaoSupport implements UserDao {

	@Override
	public void persist(User user) {
		getHibernateTemplate().persist(user);
	}
	
	@Override
	public User getById(int id) {
		User user = (User) getHibernateTemplate().get(User.class, id);
		if(user == null) {
			throw new ObjectRetrievalFailureException(User.class, id);
		}
		return user;
	}

	@Override
	public User findByUserName(String userName) {
		Criteria criteria = getSession().createCriteria(User.class, "u");
		criteria.add(Restrictions.eq("u.userName", userName));

		return (User) criteria.uniqueResult();
	}
	
	@Override
	public List<User> getAll() {
		return getHibernateTemplate().loadAll(User.class);
	}

}
