package matti.eshop.service;

import java.util.ArrayList;
import java.util.List;

import matti.eshop.dao.DepartmentDao;
import matti.eshop.dao.ItemDao;
import matti.eshop.dao.LocationDao;
import matti.eshop.dao.UserDao;
import matti.eshop.model.Department;
import matti.eshop.model.Item;
import matti.eshop.model.Location;
import matti.eshop.model.User;

import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

public class ItemServiceImpl implements ItemService {

	private ItemDao itemDao;
	private UserDao userDao;
	private SessionService sessionService;
	private LocationDao locationDao;
	private DepartmentDao departmentDao;
	
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}
	public void setSessionService(SessionService sessionService) {
		this.sessionService = sessionService;
	}
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	@Transactional
	@Override
	public int addItem(ItemSaveDto dto) {
		
		User seller = userDao.getById(sessionService.getCurrentUserId());
		Location location = locationDao.getById(dto.getLocationId());
		Department department = departmentDao.getById(dto.getDepartmentId());
		
		Item item = new Item(dto.getTitle(), dto.getDescription(), dto.getPrice(), dto.getSellingTime(), location, department, seller);

		seller.addItem(item);

		int itemId = itemDao.persist(item);
		return itemId;
	}
	
	private List<ItemViewDto> toItemViewDtos(List<Item> items) {
		List<ItemViewDto> dtos = new ArrayList<ItemViewDto>();
		for(Item item : items) {
			dtos.add(toItemViewDto(item));
		}
		return dtos;
	}
	
	private ItemViewDto toItemViewDto(Item item) {
		ItemViewDto dto = new ItemViewDto();
		dto.setItemId(item.getItemId());
		dto.setTitle(item.getTitle());
		dto.setDescription(item.getDescription());
		dto.setPrice(item.getPrice());
		dto.setSellerId(item.getSeller().getUserId());
		dto.setSeller(item.getSeller().getUsername());
		dto.setCreateTime(item.getCreateTime());
		dto.setEndTime(item.getEndTime());
		dto.setLocation(item.getLocation().getDistrict());
		dto.setDepartment(item.getDepartment().getTitle());	
		
		if(item.getOrder() != null) {
			dto.setBuyerId(item.getOrder().getBuyer().getUserId());
			dto.setBuyer(item.getOrder().getBuyer().getUsername());
		}
		
		return dto;
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<ItemViewDto> searchItems(ItemSearchDto dto) {
		return toItemViewDtos(itemDao.search(dto));
	}

	@Transactional(readOnly=true)
	@Override
	public ItemViewDto getItemForViewing(int id) {
		return toItemViewDto(itemDao.getById(id));
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<ItemViewDto> getUsersOpenItems() {
		int userId = sessionService.getCurrentUserId();
		return toItemViewDtos(itemDao.getUsersOpenItems(userId));
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<ItemViewDto> getUsersUnsoldItems() {
		int userId = sessionService.getCurrentUserId();
		return toItemViewDtos(itemDao.getUsersUnsoldItems(userId));
	}
	
	@Transactional
	@Override
	public void editItem(ItemSaveDto dto, int id) {
		Item item = itemDao.getById(id);
		item.setTitle(dto.getTitle());
		item.setDescription(dto.getDescription());
		item.setPrice(dto.getPrice());
		item.setLocation(locationDao.getById(dto.getLocationId()));
		item.setDepartment(departmentDao.getById(dto.getDepartmentId()));
		
		if(item.getEndTime().isBeforeNow()) {
			item.setCreateTime(new DateTime());
			item.setEndTime(item.getCreateTime().plusDays(dto.getSellingTime()));
		}
	}
	
	@Transactional(readOnly=true)
	@Override
	public boolean isItemInSell(int id) {
		return itemDao.isItemInSell(id);
	}
	
	@Transactional(readOnly=true)
	@Override
	public boolean isUsersUnsoldItem(int itemId) {
		int userId = sessionService.getCurrentUserId();
		return itemDao.isUsersUnsoldItem(userId, itemId);
	}
	
	@Transactional
	@Override
	public void removeItem(int id) {
		Item item = itemDao.getById(id);
		item.setEndTime(new DateTime());
	}
	
	@Transactional
	@Override
	public void updateEndTime(int itemId) {
		Item item = itemDao.getById(itemId);
		item.setEndTime(new DateTime());
	}
	
	@Transactional
	@Override
	public void removeOutdatedItems() {
		DateTime outdateTime = new DateTime().minusMonths(1);
		itemDao.removeOutdatedItems(outdateTime);
	}

}
