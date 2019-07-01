package com.cg.hotelservice.dto;

public class AdminRegister {

	private int adminId;
	private String adminUserName;
	private String password;
	private String mobile;
	private String address;
	private String email;
	
	public AdminRegister()
	{

	}

	public AdminRegister(int adminId, String adminUserName, String password,
			String mobile, String address, String email) {
		super();
		this.adminId = adminId;
		this.adminUserName = adminUserName;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
	}



	//getters And setters
	public int getAdminId() {
		return adminId;
	}



	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}



	public String getAdminUserName() {
		return adminUserName;
	}



	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
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

	@Override
	public String toString() {
		return "AdminRegister [adminId=" + adminId + ", adminUserName="
				+ adminUserName + ", password=" + password + ", mobile="
				+ mobile + ", address=" + address + ", email=" + email + "]";
	}

	





}
