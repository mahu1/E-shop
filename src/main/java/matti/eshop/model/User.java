package matti.eshop.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.UserDetails;


public class User implements UserDetails {

	private int userId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String zipCode;
	private String homeTown;
	private String areaCode;
	private String phoneNumber;
	private String mail;
	private Set<Item> items = new HashSet<Item>();
	private Set<Order> orders = new HashSet<Order>();
	
	User() {
		//for hibernate only
	}
	
	public User(String userName, String password, String firstName, String lastName, 
			String address, String zipCode, String homeTown, String areaCode, String phoneNumber, String mail) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.zipCode = zipCode;
		this.homeTown = homeTown;
		this.areaCode = areaCode;
		this.phoneNumber = phoneNumber;
		this.mail = mail;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getHomeTown() {
		return homeTown;
	}
	
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	
	public String getAreaCode() {
		return areaCode;
	}
	
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Set<Item> getItems() {
		return items;
	}

	@Override
	public GrantedAuthority[] getAuthorities() {
		GrantedAuthority[] authorities = new GrantedAuthority[1];
		authorities[0] = new GrantedAuthorityImpl("ROLE_USER");
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void addOrder(Order order, Item item, User seller) {
		orders.add(order);
		item.setOrder(order);
		seller.getItems().remove(item.getItemId());
	}
	
}
