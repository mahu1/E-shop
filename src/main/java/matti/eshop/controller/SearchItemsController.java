package matti.eshop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import matti.eshop.service.DepartmentService;
import matti.eshop.service.ItemSearchDto;
import matti.eshop.service.ItemService;
import matti.eshop.service.LocationService;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.util.WebUtils;

public class SearchItemsController extends SimpleFormController {

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

	public SearchItemsController() {
		setCommandClass(ItemSearchDto.class);
	}
	
	@Override
	protected boolean isFormSubmission(HttpServletRequest request) {
		return WebUtils.hasSubmitParameter(request, "_search");
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
		
		ItemSearchDto dto = (ItemSearchDto) command;
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("searchResults", itemService.searchItems(dto));
		if(itemService.searchItems(dto).size() == 0) {
			model.put("emptyList", true);
		}
		return showForm(request, response, errors, model);
	}
	
}
