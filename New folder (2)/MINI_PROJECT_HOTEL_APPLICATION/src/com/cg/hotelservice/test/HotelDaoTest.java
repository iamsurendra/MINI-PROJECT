package com.cg.hotelservice.test;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.hotelservice.dao.HotelDAO;
import com.cg.hotelservice.dao.HotelDAOImpl;
import com.cg.hotelservice.dto.AdminRegister;
import com.cg.hotelservice.exception.HotelException;
import com.cg.hotelservice.service.HotelServiceImpl;



public class HotelDaoTest {

	HotelServiceImpl service;
	HotelDAO dao;

	@Before
	public void init()
	{
		dao = new HotelDAOImpl();
		service  = new HotelServiceImpl();
		service.setDao(dao);
	}

	@Test
	public void testAddAdmin() throws HotelException
	{
		AdminRegister admin = new AdminRegister();
		admin.setAdminId(105);
		admin.setAddress("Nellore");
		admin.setMobile("9440069705");
		admin.setAdminUserName("surendra888");
		admin.setPassword("suri@705");
		admin.setEmail("iamsurendra@gmail.com");

		int id = service.addAdmin(admin);
		assertNotSame(id,0);
	}

	@After
	public void destroy()
	{
		dao = null;
		service = null;
	}

}
