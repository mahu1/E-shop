package matti.eshop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import matti.eshop.service.DepartmentService;
import matti.eshop.service.ItemSaveDto;
import matti.eshop.service.ItemService;
import matti.eshop.service.ItemViewDto;
import matti.eshop.service.LocationService;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class EditItemController extends SimpleFormController {

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

	public EditItemController() {
		setCommandClass(ItemViewDto.class);
		setValidator(new ItemDtoEditValidator());
	}
	
	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		int id = ServletRequestUtils.getRequiredIntParameter(request, "itemId");
		
		Map<String, Object> ref = new HashMap<String, Object>();
		ref.put("locations", locationService.getAllLocations());
		ref.put("departments", departmentService.getAllDepartments());
		ref.put("item", itemService.getItemForViewing(id));
		return ref;
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		int id = ServletRequestUtils.getRequiredIntParameter(request, "itemId");
		
		return itemService.getItemForViewing(id);
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		int id = ServletRequestUtils.getRequiredIntParameter(request, "itemId");
		ItemSaveDto dto = (ItemSaveDto) command;
		
		itemService.editItem(dto, id);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("updateSucceed", true);
		return showForm(request, response, errors, model);
	}
	
}
