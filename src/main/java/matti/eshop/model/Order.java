package matti.eshop.model;

import org.joda.time.DateTime;

public class Order {

	private int orderId;
	private DateTime orderTime;
	private Item item;
	private User buyer;
	private User seller;
	
	Order() {
		//for hibernate only
	}
	
	public Order(Item item, User buyer, User seller) {
		this.orderId = orderId;
		this.orderTime = new DateTime();
		this.item = item;
		this.buyer = buyer;
		this.seller = seller;
	}

	public int getOrderId() {
		return orderId;
	}

	public DateTime getOrderTime() {
		return orderTime;
	}

	public Item getItem() {
		return item;
	}

	public User getBuyer() {
		return buyer;
	}

	public User getSeller() {
		return seller;
	}
	
}
