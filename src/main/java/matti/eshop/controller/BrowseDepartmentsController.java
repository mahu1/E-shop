package matti.eshop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import matti.eshop.service.ItemSearchDto;
import matti.eshop.service.ItemService;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.util.WebUtils;

public class BrowseDepartmentsController extends SimpleFormController {

	private ItemService itemService;
	
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public BrowseDepartmentsController() {
		setCommandClass(ItemSearchDto.class);
	}

	@Override
	protected boolean isFormSubmission(HttpServletRequest request) {
		return WebUtils.hasSubmitParameter(request, "_search");
	}
	
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		int departmentId = ServletRequestUtils.getRequiredIntParameter(request, "departmentId");
		
		ItemSearchDto dto = (ItemSearchDto) command;
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("searchResults", itemService.searchItems(dto));
		return showForm(request, response, errors, model);
	}
	
}
