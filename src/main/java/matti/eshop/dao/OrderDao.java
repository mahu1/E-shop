package matti.eshop.dao;

import java.util.List;

import matti.eshop.model.Order;

public interface OrderDao {

	void persist(Order order);
	
	List<Order> getUsersOrders(int id);

	List<Order> getUsersSoldItems(int id);

}
