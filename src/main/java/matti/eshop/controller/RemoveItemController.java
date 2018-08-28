package matti.eshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import matti.eshop.service.ItemService;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class RemoveItemController extends AbstractController {

	private ItemService itemService;
	
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int id = ServletRequestUtils.getRequiredIntParameter(request, "itemId");
		
		itemService.removeItem(id);
		
		ModelAndView mav = new ModelAndView("redirect:/view-unsold-item.action");
		mav.addObject("itemRemoved", true);
		mav.addObject("itemId", id);
		return mav;
	}

}
