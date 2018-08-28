package matti.eshop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import matti.eshop.service.UserDto;
import matti.eshop.service.UserNameInUseException;
import matti.eshop.service.UserService;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class RegisterUserController extends SimpleFormController {
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RegisterUserController() {
		setCommandClass(UserDto.class);
		setValidator(new UserDtoValidator());
	}
	
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception { 

		UserDto dto = (UserDto) command;
		
		try {
			userService.addUser(dto);
		}
		catch(UserNameInUseException e) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("addError", true);
			return showForm(request, response, errors, model);
		}
		ModelAndView mav = new ModelAndView("redirect:/login.action");
		mav.addObject("userAdded", true);
		return mav;

	}
		
}
