package com.cg.hotelservice.service;

import java.util.ArrayList;

import com.cg.hotelservice.dto.AdminRegister;
import com.cg.hotelservice.dto.HotelDetails;
import com.cg.hotelservice.dto.UserRegister;
import com.cg.hotelservice.exception.HotelException;


public interface HotelService {

	int addAdmin(AdminRegister emp)throws HotelException;
	AdminRegister getAdminById(int empId)throws HotelException;
	
	int addUser(UserRegister emp)throws HotelException;
	UserRegister getUserById(int empId)throws HotelException;
	
	ArrayList<AdminRegister>getAllAdmin()throws HotelException;
	ArrayList<UserRegister>getAllUser()throws HotelException;
	UserRegister removeUser(int accountnumber)throws HotelException;
//hotel
	String addHotel(HotelDetails hotel) throws HotelException;
	HotelDetails removeHotel(String hotelId)throws HotelException;
	HotelDetails getHotelById(String hotelId)throws HotelException;
	ArrayList<HotelDetails> getAllHotels()throws HotelException;
	HotelDetails updateHotelDetails(String hotelId,String name) throws HotelException;
	
	boolean validateUserId(int userId);
	boolean validateName(String name);
	boolean validatePhone(String mobile);	
}
