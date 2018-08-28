package matti.eshop.service;

import java.math.BigDecimal;

public class ItemSearchDto extends ItemSaveDto {
	
	private BigDecimal minPrice;
	private BigDecimal maxPrice;
	private String seller;
	
	public BigDecimal getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}
	public BigDecimal getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	
}
