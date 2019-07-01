package com.cg.hotelservice.dto;

public class HotelDetails {
	private String hotelId;
	private String hotelName;
	private String city;
	private String address;
	private String description ;
	private String avgRatePerNight;
	private String phone;
	private String rating;
	private String email;
	private String fax;
	
	
	public HotelDetails(String hotelId, String hotelName, String city, String address, String description,
			String avgRatePerNight, String phone, String rating, String email, String fax) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.city = city;
		this.address = address;
		this.description = description;
		this.avgRatePerNight = avgRatePerNight;
		this.phone = phone;
		this.rating = rating;
		this.email = email;
		this.fax = fax;
	}
	
	public HotelDetails() {
		super();
	}

	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAvgRatePerNight() {
		return avgRatePerNight;
	}
	public void setAvgRatePerNight(String avgRatePerNight) {
		this.avgRatePerNight = avgRatePerNight;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	@Override
	public String toString() {
		return "HotelDetails [hotelId=" + hotelId + ", hotelName=" + hotelName + ", city=" + city + ", address="
				+ address + ", description=" + description + ", avgRatePerNight=" + avgRatePerNight + ", phone=" + phone
				+ ", rating=" + rating + ", email=" + email + ", fax=" + fax + "]";
	}

	
	
}
