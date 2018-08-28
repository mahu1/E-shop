package matti.eshop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import matti.eshop.service.UserDto;
import matti.eshop.service.UserService;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class EditUserController extends SimpleFormController {

	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public EditUserController() {
		setCommandClass(UserDto.class);
		setValidator(new UserDtoValidator());
	}

	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map<String, Object> ref = new HashMap<String, Object>();
		ref.put("user", userService.getUserForEditing());
		return ref;
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		return userService.getUserForEditing();
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		UserDto dto = (UserDto) command;
		
		userService.editUser(dto);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("updateSucceed", true);
		return showForm(request, response, errors, model);

	}

}
