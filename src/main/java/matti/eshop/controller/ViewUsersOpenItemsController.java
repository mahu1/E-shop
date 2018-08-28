package matti.eshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import matti.eshop.service.ItemService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ViewUsersOpenItemsController extends AbstractController {

	private ItemService itemService;
	
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView();
		mav.addObject("searchResults", itemService.getUsersOpenItems());

		return mav;
	}

}
