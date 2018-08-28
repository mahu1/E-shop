package matti.eshop.service;

import java.util.List;

public interface ItemService {

	int addItem(ItemSaveDto dto);
	
	List<ItemViewDto> searchItems(ItemSearchDto dto);
	
	ItemViewDto getItemForViewing(int id);
	
	List<ItemViewDto> getUsersOpenItems();
	
	void editItem(ItemSaveDto dto, int id);
	
	boolean isItemInSell(int id);
	
	boolean isUsersUnsoldItem(int id);
	
	void removeItem(int id);

	List<ItemViewDto> getUsersUnsoldItems();

	void updateEndTime(int itemId);

	void removeOutdatedItems();
	
}
