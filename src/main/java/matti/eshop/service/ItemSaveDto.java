package matti.eshop.service;

import java.math.BigDecimal;

public class ItemSaveDto {

	private String title;
	private String description;
	private BigDecimal price;
	private int sellingTime;
	private int locationId;
	private int departmentId;

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
	public int getSellingTime() {
		return sellingTime;
	}
	public void setSellingTime(int sellingTime) {
		this.sellingTime = sellingTime;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	

}
