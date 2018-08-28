package matti.eshop.dao;

import java.util.List;

import matti.eshop.model.Location;

public interface LocationDao {

	List<Location> getAll();
	
	Location getById(int id);
}
