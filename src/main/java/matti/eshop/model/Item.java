package matti.eshop.model;

import java.math.BigDecimal;

import org.joda.time.DateTime;

public class Item {

	private int itemId;
	private String title;
	private String description;
	private BigDecimal price;
	private DateTime createTime;
	private DateTime endTime;
	private User seller;
	private Location location;
	private Department department;
	private Order order;

	Item() {
		//for hibernate only
	}
	
	public Item(String title, String description, BigDecimal price, int sellingTime, Location location, Department department, User seller) {
		this.title = title;
		this.description = description;
		this.price = price;
		createTime = new DateTime();
		endTime = createTime.plusDays(sellingTime);
		this.location = location;
		this.department = department;
		this.seller = seller;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public DateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(DateTime createTime) {
		this.createTime = createTime;
	}

	public DateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getItemId() {
		return itemId;
	}

	public User getSeller() {
		return seller;
	}

	public Order getOrder() {
		return order;
	}

	void setOrder(Order order) {
		this.order = order;
	}
	
}
