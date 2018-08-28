package matti.eshop.model;

import java.util.HashSet;
import java.util.Set;

public class Department {

	private int departmentId;
	private String title;
	private String description;
	Set<Item> items = new HashSet();

	
	Department() {
		//for hibernate only
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}
	
}
