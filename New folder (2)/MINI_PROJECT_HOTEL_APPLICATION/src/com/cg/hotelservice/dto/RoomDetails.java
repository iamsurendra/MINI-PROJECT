package com.cg.hotelservice.dto;

public class RoomDetails{
	private String hotelId;
	private String roomId;
	private String roomN0;
	private String roomType;
	private int perNightRate;
	private boolean availability ;
	
	
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getRoomN0() {
		return roomN0;
	}
	public void setRoomN0(String roomN0) {
		this.roomN0 = roomN0;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getPerNightRate() {
		return perNightRate;
	}
	public void setPerNightRate(int perNightRate) {
		this.perNightRate = perNightRate;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
}
