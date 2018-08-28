package matti.eshop.service;

import java.util.ArrayList;
import java.util.List;

import matti.eshop.dao.ItemDao;
import matti.eshop.dao.OrderDao;
import matti.eshop.dao.UserDao;
import matti.eshop.model.Item;
import matti.eshop.model.Order;
import matti.eshop.model.User;

import org.springframework.transaction.annotation.Transactional;

public class OrderServiceImpl implements OrderService {
	
	private ItemDao itemDao;
	private UserDao userDao;
	private OrderDao orderDao;
	private SessionService sessionService;
	
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	public void setSessionService(SessionService sessionService) {
		this.sessionService = sessionService;
	}
	
	@Transactional
	@Override
	public void addOrder(int itemId, int sellerId) {
		Item item = itemDao.getById(itemId);
		User buyer = userDao.getById(sessionService.getCurrentUserId());
		User seller = userDao.getById(item.getSeller().getUserId());
		Order order = new Order(item, buyer, seller);
		
		buyer.addOrder(order, item, seller);
//		seller.getItems().remove(itemDao.getById(itemId));
//		item.setEndTime(new DateTime());
		
		
		orderDao.persist(order);
	}
	
	private List<OrderViewDto> toOrderViewDtos(List<Order> orders) {
		List<OrderViewDto> dtos = new ArrayList<OrderViewDto>();
		for(Order order : orders) {
			OrderViewDto dto = new OrderViewDto();
			
			dto.setItemTitle(order.getItem().getTitle());
			dto.setPrice(order.getItem().getPrice());
			dto.setDepartment(order.getItem().getDepartment().getTitle());
			dto.setOrderTime(order.getOrderTime());
			dto.setBuyerId(order.getBuyer().getUserId());
			dto.setBuyer(order.getBuyer().getUsername());
			dto.setSellerId(order.getItem().getSeller().getUserId());
			dto.setSeller(order.getItem().getSeller().getUsername());
			dto.setItemId(order.getItem().getItemId());
			
			dtos.add(dto);
		}
		return dtos;
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<OrderViewDto> getUsersOrders() {
		List<Order> orders = orderDao.getUsersOrders(sessionService.getCurrentUserId());
		return toOrderViewDtos(orders);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<OrderViewDto> getUsersSoldItems() {
		List<Order> soldItems = orderDao.getUsersSoldItems(sessionService.getCurrentUserId());
		return toOrderViewDtos(soldItems);
	}
	
}
