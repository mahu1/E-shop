package matti.eshop.service;


public interface UserService {

	void addUser(UserDto dto);
	
	UserDto getUserForEditing();
	
	void editUser(UserDto dto);
	
	UserDto getUserForViewing(int userId);
}
