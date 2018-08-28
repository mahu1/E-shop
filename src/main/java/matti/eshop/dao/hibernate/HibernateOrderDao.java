package matti.eshop.dao.hibernate;

import java.util.List;

import matti.eshop.dao.OrderDao;
import matti.eshop.model.Order;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateOrderDao extends HibernateDaoSupport implements OrderDao {

	@Override
	public void persist(Order order) {
		getHibernateTemplate().persist(order);
	}

	@Override
	public List<Order> getUsersOrders(int id) {
		Criteria criteria = getSession().createCriteria(Order.class, "o");
		
		criteria.add(Restrictions.eq("o.buyer.userId", id));
		return criteria.list();

	}
	
	@Override
	public List<Order> getUsersSoldItems(int id) {
		Criteria criteria = getSession().createCriteria(Order.class, "o");
		criteria.createCriteria("o.item", "i", Criteria.INNER_JOIN);
		
		criteria.add(Restrictions.eq("i.seller.userId", id));
		return criteria.list();
	}

}
