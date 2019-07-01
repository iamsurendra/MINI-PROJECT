package com.cg.hotelservice.dao;

import java.util.ArrayList;
import com.cg.hotelservice.dto.AdminRegister;
import com.cg.hotelservice.dto.HotelDetails;
import com.cg.hotelservice.dto.UserRegister;
import com.cg.hotelservice.exception.HotelException;

public interface HotelDAO {

	int addAdmin(AdminRegister emp)throws HotelException;

	AdminRegister getAdminById(int adminId)throws HotelException;

	int addUser(UserRegister emp)throws HotelException;

	UserRegister getUserById(int accountnumber)throws HotelException;

	ArrayList<AdminRegister>getAllAdmin()throws HotelException;

	ArrayList<UserRegister>getAllUser()throws HotelException;

	UserRegister removeUser(int empId)throws HotelException;

	AdminRegister removeAdmin(int empId) throws HotelException;
	//hotel curd
	String addHotel(HotelDetails hotel) throws HotelException;
	HotelDetails removeHotel(String hotelId)throws HotelException;
	HotelDetails getHotelById(String hotelId)throws HotelException;
	ArrayList<HotelDetails> getAllHotels()throws HotelException;
	HotelDetails updateHotelDetails(String hotelId,String name) throws HotelException;

	//room curd
	String addRoom(HotelDetails hotel) throws HotelException;
	HotelDetails removeRoom(String hotelId)throws HotelException;
	HotelDetails getRoomById(String hotelId)throws HotelException;
	ArrayList<HotelDetails> getAllRooms()throws HotelException;
	HotelDetails updateRoomDetails(String hotelId,String name) throws HotelException;

}







