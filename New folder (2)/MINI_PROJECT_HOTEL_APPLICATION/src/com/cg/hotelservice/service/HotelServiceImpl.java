package com.cg.hotelservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.cg.hotelservice.dao.HotelDAO;
import com.cg.hotelservice.dao.HotelDAOImpl;
import com.cg.hotelservice.dto.AdminRegister;
import com.cg.hotelservice.dto.HotelDetails;
import com.cg.hotelservice.dto.UserRegister;
import com.cg.hotelservice.exception.HotelException;



public class HotelServiceImpl implements HotelService
{
	HotelDAO dao;
	
	public void setDao(HotelDAO dao)
	{
		this.dao = dao;
	}
	
	public HotelServiceImpl()
	{
		dao = new HotelDAOImpl();
	}

	@Override
	public int addAdmin(AdminRegister admin) throws HotelException {
		
		return dao.addAdmin(admin);
	}

	
	@Override
	public AdminRegister getAdminById(int adminId) throws HotelException {
		
		return dao.getAdminById(adminId);
	}
	@Override
	public ArrayList<AdminRegister> getAllAdmin() throws HotelException {
		
		return dao.getAllAdmin();
	}
	
	@Override
	public int addUser(UserRegister user) throws HotelException {
		
		return dao.addUser(user);
	}

	
	@Override
	public UserRegister getUserById(int userId) throws HotelException {
		
		return dao.getUserById(userId);
	}
	@Override
	public ArrayList<UserRegister> getAllUser() throws HotelException {
		
		return dao.getAllUser();
	}
	@Override
	public UserRegister removeUser(int userId) throws HotelException {
		
		return dao.removeUser(userId);
	
	}

	public boolean validateName(String name)
	{
		String pattern = "[A-z]{1}[a-z]{2,}";
		if(Pattern.matches(pattern,name))
		{
			return true;
		}
		else
			return false;
	}
	public boolean validateUserId(int userId)
	{
		String pattern = "[0-9]{4,10}";
		String sal = ""+userId;
		if(Pattern.matches(pattern,sal))
		{
			return true;
		}
		else 
			return false;
	}
	public boolean validatePhone(int salary)
	{
		String pattern = "[0-9]{4,10}";
		String sal = ""+salary;
		if(Pattern.matches(pattern,sal))
		{
			return true;
		}
		else 
			return false;
	}

	@Override
	public boolean validatePhone(String mobile) {
		
		String pattern = "[0-9]{4,10}";
		String mob = ""+mobile;
		if(Pattern.matches(pattern,mob))
		{
			return true;
		}
		else 
			return false;
	}

	@Override
	public String addHotel(HotelDetails hotel) throws HotelException {
		
		return dao.addHotel(hotel);
	}

	@Override
	public HotelDetails removeHotel(String hotelId) throws HotelException {
		
		return dao.removeHotel(hotelId);
	}

	@Override
	public HotelDetails getHotelById(String hotelId) throws HotelException {
		
		return dao.getHotelById(hotelId);
	}

	@Override
	public ArrayList<HotelDetails> getAllHotels() throws HotelException {
		
		return dao.getAllHotels();
	}

	@Override
	public HotelDetails updateHotelDetails(String hotelId, String name) throws HotelException {
		
		return dao.updateHotelDetails(hotelId, name);
	}
	
}




