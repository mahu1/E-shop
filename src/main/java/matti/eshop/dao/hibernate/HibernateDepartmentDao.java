package matti.eshop.dao.hibernate;

import java.util.List;

import matti.eshop.dao.DepartmentDao;
import matti.eshop.model.Department;
import matti.eshop.model.User;

import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateDepartmentDao extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public List<Department> getAll() {
		return getHibernateTemplate().loadAll(Department.class);
	}
	
	@Override
	public Department getById(int id) {
		Department department = (Department) getHibernateTemplate().get(Department.class, id);
		if(department == null) {
			throw new ObjectRetrievalFailureException(User.class, id);
		}
		return department;
	}

}
