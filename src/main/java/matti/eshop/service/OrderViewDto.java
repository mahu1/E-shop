package matti.eshop.service;

import java.math.BigDecimal;

import org.joda.time.DateTime;

public class OrderViewDto {

	private String itemTitle;
	private BigDecimal price;
	private String department;
	private DateTime orderTime;
	private int buyerId;
	private String buyer;
	private int sellerId;
	private String seller;
	private int itemId;
	
	
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public DateTime getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(DateTime orderTime) {
		this.orderTime = orderTime;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
}
