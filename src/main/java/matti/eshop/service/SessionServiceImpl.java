package matti.eshop.service;

import matti.eshop.model.User;

import org.springframework.security.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public class SessionServiceImpl implements SessionService {


	@Override
	public int getCurrentUserId() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user.getUserId();
	}

	
    private void setSessionAttribute(String name, Object value) {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        attributes.setAttribute(name, value, RequestAttributes.SCOPE_SESSION);
    }

    private Object getSessionAttribute(String name) {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return attributes.getAttribute(name, RequestAttributes.SCOPE_SESSION);
    }

    private Object getRequiredSessionAttribute(String name) {
        Object value = getSessionAttribute(name);
        if (value == null) {
            throw new RuntimeException("Required session attribute not found by name '" + name + "'");
        }
        return value;
    }
	
}
