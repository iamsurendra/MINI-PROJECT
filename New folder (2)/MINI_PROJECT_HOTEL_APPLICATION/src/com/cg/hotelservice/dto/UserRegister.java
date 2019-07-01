package com.cg.hotelservice.dto;

public class UserRegister {

	private int userId;
	
	private String userName;
	private String password;
	private String mobile;
	private String address;
	private String email;
	private String role;

	public UserRegister(int userId, String userName, String password,
			String mobile, String address, String email, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		this.role = role;
	}

	public UserRegister() {
		super();
		
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRegister [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + ", mobile=" + mobile
				+ ", address=" + address + ", email=" + email + ", role="
				+ role + "]";
	}
	
	

}
