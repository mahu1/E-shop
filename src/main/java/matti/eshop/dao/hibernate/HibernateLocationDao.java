package matti.eshop.dao.hibernate;

import java.util.List;

import matti.eshop.dao.LocationDao;
import matti.eshop.model.Location;
import matti.eshop.model.User;

import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateLocationDao extends HibernateDaoSupport implements LocationDao {

	@Override
	public List<Location> getAll() {
		return getHibernateTemplate().loadAll(Location.class);
	}

	@Override
	public Location getById(int id) {
		Location location = (Location) getHibernateTemplate().get(Location.class, id);
		if(location == null) {
			throw new ObjectRetrievalFailureException(User.class, id);
		}
		return location;
	}

}
