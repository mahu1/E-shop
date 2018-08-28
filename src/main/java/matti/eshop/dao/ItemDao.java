package matti.eshop.dao;

import java.util.List;

import matti.eshop.model.Item;
import matti.eshop.service.ItemSearchDto;

import org.joda.time.DateTime;

public interface ItemDao {

	int persist(Item item);
	
	List<Item> search(ItemSearchDto dto);
	
	Item getById(int id);
	
	List<Item> getUsersOpenItems(int id);
	
	boolean isItemInSell(int id);
	
	boolean isUsersUnsoldItem(int userId, int itemId);

	List<Item> getUsersUnsoldItems(int id);

	void removeOutdatedItems(DateTime timeLimit);
}
