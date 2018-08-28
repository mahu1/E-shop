package matti.eshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import matti.eshop.service.UserService;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ViewSellerController extends AbstractController {

	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int userId = ServletRequestUtils.getRequiredIntParameter(request, "sellerId");

		ModelAndView mav = new ModelAndView();
		mav.addObject("user", userService.getUserForViewing(userId));
		return mav;
	}

}