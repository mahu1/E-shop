package matti.eshop.dao;

import java.util.List;

import matti.eshop.model.User;

public interface UserDao {

	void persist(User user);

	User findByUserName(String userName);
	
	User getById(int id);
	
	List<User> getAll();
}
