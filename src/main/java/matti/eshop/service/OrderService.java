package matti.eshop.service;

import java.util.List;

public interface OrderService {

	void addOrder(int itemId, int sellerId);
	
	List<OrderViewDto> getUsersOrders();
	
	List<OrderViewDto> getUsersSoldItems();
	
}
