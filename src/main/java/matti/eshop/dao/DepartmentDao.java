package matti.eshop.dao;

import java.util.List;

import matti.eshop.model.Department;

public interface DepartmentDao {

	List<Department> getAll();

	Department getById(int id);
	
}
