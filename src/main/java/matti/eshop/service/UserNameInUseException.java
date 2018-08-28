package matti.eshop.service;

public class UserNameInUseException extends RuntimeException {

	UserNameInUseException(String message) {
		super(message);
	}
	
}
