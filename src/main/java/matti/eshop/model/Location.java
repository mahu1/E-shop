package matti.eshop.model;

import java.util.HashSet;
import java.util.Set;

public class Location {
	
	private int locationId;
	private String district;
	Set<Item> items = new HashSet();

	
	Location () {
		//for hibernate only
	}

	public int getLocationId() {
		return locationId;
	}

	public String getDistrict() {
		return district;
	}
	
}
