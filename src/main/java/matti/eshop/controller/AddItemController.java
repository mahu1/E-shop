package matti.eshop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import matti.eshop.service.DepartmentService;
import matti.eshop.service.ItemSaveDto;
import matti.eshop.service.ItemService;
import matti.eshop.service.LocationService;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class AddItemController extends SimpleFormController {

	private ItemService itemService;
	private LocationService locationService;
	private DepartmentService departmentService;
	
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public AddItemController() {
		setCommandClass(ItemSaveDto.class);
		setValidator(new ItemDtoSaveValidator());
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		Integer id = ServletRequestUtils.getIntParameter(request, "itemId");
		if(id != null) {
			return itemService.getItemForViewing(id);
		}
		return new ItemSaveDto();
	}
	
	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map<String, Object> ref = new HashMap<String, Object>();
		ref.put("locations", locationService.getAllLocations());
		ref.put("departments", departmentService.getAllDepartments());
		return ref;
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		ItemSaveDto dto = (ItemSaveDto) command;
		Integer id = ServletRequestUtils.getIntParameter(request, "itemId");
		
		if(id == null) {
			id = itemService.addItem(dto);
		}
		else {
			itemService.editItem(dto, id);
		}
		
		ModelAndView mav = new ModelAndView("redirect:/view-unsold-item.action");
		mav.addObject("itemAdded", true);
		mav.addObject("itemId", id);
		return mav;
		
	}
}
