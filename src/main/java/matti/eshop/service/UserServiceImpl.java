package matti.eshop.service;

import java.util.List;

import matti.eshop.dao.UserDao;
import matti.eshop.model.User;

import org.springframework.dao.DataAccessException;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class UserServiceImpl implements UserService, UserDetailsService {

	private UserDao userDao;
	private SessionService sessionService;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void setSessionService(SessionService sessionService) {
		this.sessionService = sessionService;
	}

	private boolean isUserNameInUse(List<User> users, String newUserName) {
		for(User user : users) {
			if(user.getUsername().equals(newUserName)) {
				return true;
			}
		}
		
		return false;
	}

	@Transactional
	@Override
	public void addUser(UserDto dto) {
		if(!isUserNameInUse(userDao.getAll(), dto.getUserName())) {
		
			User user = new User(dto.getUserName(), dto.getPassword(), dto.getFirstName(), 
					dto.getLastName(), dto.getAddress(), dto.getZipCode(), dto.getHomeTown(), 
					dto.getAreaCode(), dto.getPhoneNumber(), dto.getMail());

			userDao.persist(user);
		}
		else {
			throw new UserNameInUseException("Valittu käyttäjätunnus on jo käytössä.");
		}
	}

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException {
		UserDetails user = userDao.findByUserName(userName);
		if(user == null) {
			throw new UsernameNotFoundException("Cannot find user", userName);
		}
		
		return user;
	}
	
	private UserDto toUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setUserName(user.getUsername());
		userDto.setPassword(user.getPassword());
		userDto.setPassword2(user.getPassword());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setAddress(user.getAddress());
		userDto.setZipCode(user.getZipCode());
		userDto.setHomeTown(user.getHomeTown());
		userDto.setAreaCode(user.getAreaCode());
		userDto.setPhoneNumber(user.getPhoneNumber());
		userDto.setMail(user.getMail());
		
		return userDto;
	}
	
	
	@Transactional(readOnly=true)
	@Override
	public UserDto getUserForEditing() {
		return toUserDto(userDao.getById(sessionService.getCurrentUserId()));
	}

	@Transactional
	@Override
	public void editUser(UserDto dto) {
		User user = userDao.getById(sessionService.getCurrentUserId());
		
		user.setPassword(dto.getPassword());
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setAddress(dto.getAddress());
		user.setZipCode(dto.getZipCode());
		user.setHomeTown(dto.getHomeTown());
		user.setAreaCode(dto.getAreaCode());
		user.setPhoneNumber(dto.getPhoneNumber());
		user.setMail(dto.getMail());
	}

	@Transactional(readOnly=true)
	@Override
	public UserDto getUserForViewing(int userId) {
		return toUserDto(userDao.getById(userId));
	}

}
