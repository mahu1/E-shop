package matti.eshop.dao.hibernate;

import java.util.List;

import matti.eshop.dao.ItemDao;
import matti.eshop.model.Item;
import matti.eshop.model.Order;
import matti.eshop.service.ItemSearchDto;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.StringUtils;

public class HibernateItemDao extends HibernateDaoSupport implements ItemDao {

	@Override
	public int persist(Item item) {
		getHibernateTemplate().persist(item);
		return item.getItemId();
	}

	@Override
	public List<Item> search(ItemSearchDto dto) {
		Criteria criteria = getSession().createCriteria(Item.class, "i");
		criteria.createCriteria("i.location", "l", Criteria.INNER_JOIN);
		criteria.createCriteria("i.department", "d", Criteria.INNER_JOIN);
		criteria.createCriteria("i.seller", "s", Criteria.INNER_JOIN);
		criteria.createCriteria("i.order", "o", Criteria.LEFT_JOIN);
		
		criteria.add(Restrictions.ge("i.endTime", new DateTime()));
		criteria.add(Restrictions.isNull("o.item.itemId"));
		
		if(StringUtils.hasText(dto.getTitle())) {
			Conjunction conjunction = Restrictions.conjunction();
			
			String[] splitTitle = dto.getTitle().split("[ -]+");
			for(int i=0; i<splitTitle.length; i++) {
				conjunction.add(Restrictions.ilike("i.title", splitTitle[i], MatchMode.ANYWHERE));
			}
			criteria.add(conjunction);
		}
		if(dto.getMinPrice() != null) {
			criteria.add(Restrictions.ge("i.price", dto.getMinPrice()));
		}
		if(dto.getMaxPrice() != null) {
			criteria.add(Restrictions.le("i.price", dto.getMaxPrice()));
		}
		if(StringUtils.hasText(dto.getSeller())) {
			criteria.add(Restrictions.ilike("s.userName", dto.getSeller(), MatchMode.EXACT));
		}
		if(dto.getLocationId() != 0) {
			criteria.add(Restrictions.eq("l.locationId", dto.getLocationId()));
		}
		if(dto.getDepartmentId() != 0) {
			criteria.add(Restrictions.eq("d.departmentId", dto.getDepartmentId()));
		}

		return criteria.list();
	}

	@Override
	public Item getById(int id) {
		Item item = (Item) getHibernateTemplate().get(Item.class, id);
		if(item == null) {
			throw new ObjectRetrievalFailureException(Item.class, id);
		}
		return item;
	}

	@Override
	public List<Item> getUsersOpenItems(int id) {
		Criteria criteria = getSession().createCriteria(Item.class, "i");
		criteria.createCriteria("i.seller", "s", Criteria.INNER_JOIN);
		criteria.createCriteria("i.order", "o", Criteria.LEFT_JOIN);
		
		criteria.add(Restrictions.eq("s.userId", id));
		criteria.add(Restrictions.ge("i.endTime", new DateTime()));
		criteria.add(Restrictions.isNull("o.item.itemId"));
		
		return criteria.list();
	}
	
	@Override
	public boolean isItemInSell(int id) {
		Criteria criteria = getSession().createCriteria(Order.class, "o");
		
		Item item = getById(id);
		if(item.getEndTime().isAfter(new DateTime())) {
			criteria.add(Restrictions.eq("o.item.itemId", id));
		}
		
		if(criteria.list().isEmpty()) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isUsersUnsoldItem(int userId, int itemId) {
		Criteria criteria = getSession().createCriteria(Order.class, "o");
		
		criteria.add(Restrictions.eq("o.item.itemId", itemId));
		
		Item item = getById(itemId);
		if(item.getSeller().getUserId() == userId && criteria.list().isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public List<Item> getUsersUnsoldItems(int id) {
		Criteria criteria = getSession().createCriteria(Item.class, "i");
		criteria.createCriteria("i.seller", "s", Criteria.INNER_JOIN);
		criteria.createCriteria("i.order", "o", Criteria.LEFT_JOIN);
		
		criteria.add(Restrictions.eq("s.userId", id));
		criteria.add(Restrictions.le("i.endTime", new DateTime()));
		criteria.add(Restrictions.isNull("o.item.itemId"));
		
		return criteria.list();
	}

	@Override
	public void removeOutdatedItems(DateTime timeLimit) {
		// hql
//		Query query = getSession().createQuery("delete from Order from Order order inner join Item item with order.itemId = item.itemId where endTime < :limit");
//		query.setDate("limit", timeLimit.toDate());
//		query.executeUpdate();
//		System.out.println("poisto1");
		
		Query query2 = getSession().createQuery("delete from Item where endTime < :limit");
		query2.setDate("limit", timeLimit.toDate());
		query2.executeUpdate();
		System.out.println("poisto2");
	}

}
