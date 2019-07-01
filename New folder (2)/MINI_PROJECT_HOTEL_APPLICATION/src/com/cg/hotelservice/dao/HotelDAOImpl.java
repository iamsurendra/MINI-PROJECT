package com.cg.hotelservice.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cg.hotelservice.dto.AdminRegister;
import com.cg.hotelservice.dto.HotelDetails;
import com.cg.hotelservice.dto.UserRegister;
import com.cg.hotelservice.exception.HotelException;
import com.cg.hotelservice.util.DBUtil;
import com.cg.logger.MyLogger;

public class HotelDAOImpl implements HotelDAO{

	Connection con;
	Logger logger;


	public HotelDAOImpl()
	{
		con = DBUtil.getConnect();
		logger = MyLogger.getLogger();
	}

	public int getAdminId()throws HotelException
	{
		logger.info("In getAdminId");
		int id = 0;
		String qry = "SELECT adminId_seq.CURRVAL FROM DUAL";
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			if(rs.next())
			{
				id = rs.getInt(1);
				logger.info("Got Admin User With Id"+id);
			}
		}
		catch(SQLException e)
		{
			logger.error("Error"+e.getMessage());
			throw new HotelException(e.getMessage());
		}
		logger.info("Completed getAdminId");
		return id;

	}
	@Override
	public int addAdmin(AdminRegister admin) throws HotelException {

		logger.info("In Add AdminRegister");
		logger.info("Input is "+admin);
		int id = 0;
		String qry = "INSERT INTO AdminRegister VALUES(adminId_seq.NEXTVAL,?,?,?,?,?)";

		String username = admin.getAdminUserName();
		String password = admin.getPassword();
		String mobile = admin.getMobile();
		String address = admin.getAddress();
		String email=admin.getEmail();

		try
		{
			PreparedStatement pstmt = con.prepareStatement(qry);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, mobile);
			pstmt.setString(4, address);
			pstmt.setString(5, email);

			int row = pstmt.executeUpdate();
			if(row > 0)
			{
				id = getAdminId();
				logger.info("Inserted successfully and Id is = "+id);
			}
			else
				throw new HotelException("unable to insert"+admin);

		}
		catch(SQLException e)
		{
			logger.error("Error in insert = "+e.getMessage());
			throw new HotelException(e.getMessage());
		}
		return id;

	}


	@Override
	public AdminRegister getAdminById(int adminId) throws HotelException {

		AdminRegister admin = null;
		String qry = "SELECT * FROM AdminRegister WHERE adminId=?";
		try
		{
			PreparedStatement pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, adminId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{

				int id = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String mobile = rs.getString(4);
				String address = rs.getString(5);
				String email=rs.getString(6);

				admin = new AdminRegister(id,username,password,mobile,address,email);
			}
			else
				throw new HotelException("Admin with id "+adminId+"not found");
		}
		catch(SQLException e)
		{
			throw new HotelException(e.getMessage());
		}
		return admin;
	}


	@Override
	public ArrayList<AdminRegister> getAllAdmin() throws HotelException {

		ArrayList<AdminRegister>list = new ArrayList<AdminRegister>();
		String qry = "SELECT * FROM AdminRegister";
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			while(rs.next())
			{
				int id = rs.getInt(1);

				String username=rs.getString(2);
				String password=rs.getString(3);
				String mobile= rs.getString(4);
				String address=rs.getString(5);
				String email=rs.getString(6);

				AdminRegister admin = new AdminRegister(id,username,password,mobile,address,email);
				list.add(admin);
			}
		}
		catch(SQLException e)
		{
			throw new HotelException(e.getMessage());
		}
		return list;
	}
	@Override
	public AdminRegister removeAdmin(int adminId) throws HotelException {

		AdminRegister admin = null;
		String qry = "DELETE FROM AdminRegister WHERE adminId=?";
		try
		{
			PreparedStatement pstmt = 
					con.prepareStatement(qry);
			pstmt.setInt(1, adminId);
			admin = getAdminById(adminId);
			int row = pstmt.executeUpdate();
			if(admin==null)
			{
				throw new HotelException("admin with id "+adminId+"not found");
			}
			else if(row > 0)
			{
				System.out.println("Deleted Admin with Id "+adminId);

			}

		}
		catch(SQLException e)
		{
			throw new HotelException(e.getMessage());
		}
		return admin;
	}

	public int getUserId()throws HotelException
	{
		logger.info("In getUserId");
		int id1 = 0;
		String qry = "SELECT userId_seq.CURRVAL FROM DUAL";
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			if(rs.next())
			{
				id1 = rs.getInt(1);
				logger.info("Got  User With account number"+id1);
			}
		}
		catch(SQLException e)
		{
			logger.error("Error"+e.getMessage());
			throw new HotelException(e.getMessage());
		}
		logger.info("Completed getUserId");
		return id1;

	}
	@Override
	public int addUser(UserRegister user) throws HotelException {

		logger.info("In Add UserRegister");
		logger.info("Input is "+user);
		int id1 = 0;
		String qry = "INSERT INTO UserRegister VALUES(userId_seq.NEXTVAL,?,?,?,?,?,?)";

		String username = user.getUserName();
		String password = user.getPassword();
		String mobile = user.getMobile();
		String address = user.getAddress();
		String email = user.getEmail();
		String role =user.getRole();
		try
		{
			PreparedStatement pstmt = con.prepareStatement(qry);

			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, mobile);
			pstmt.setString(4, address);
			pstmt.setString(5, email);
			pstmt.setString(6,role);

			int row = pstmt.executeUpdate();
			if(row > 0)
			{
				id1 = getUserId();
				logger.info("Inserted successfully and Customer Number  is = "+id1);
			}
			else
				throw new HotelException("unable to insert"+user);

		}
		catch(SQLException e)
		{
			logger.error("Error in insert = "+e.getMessage());
			throw new HotelException(e.getMessage());
		}
		return id1;


	}


	@Override
	public UserRegister getUserById(int userId) throws HotelException {

		UserRegister user = null;
		String qry = "SELECT * FROM UserRegister WHERE userId=?";
		try
		{
			PreparedStatement pstmt = 
					con.prepareStatement(qry);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				int id = rs.getInt(1);

				String username = rs.getString(2);
				String password = rs.getString(3);
				String mobile = rs.getString(4);
				String address = rs.getString(5);
				String email = rs.getString(6);
				String role = rs.getString(7);

				user = new UserRegister(id,username,password,mobile,address,email,role);
			}
			else
				throw new HotelException("User with id "+userId+"not found");
		}
		catch(SQLException e)
		{
			throw new HotelException(e.getMessage());
		}
		return user;
	}


	@Override
	public UserRegister removeUser(int userId) throws HotelException {

		UserRegister user = null;
		String qry = "DELETE FROM UserRegister WHERE userId=?";
		try
		{
			PreparedStatement pstmt = 
					con.prepareStatement(qry);
			pstmt.setInt(1, userId);
			user = getUserById(userId);
			int row = pstmt.executeUpdate();
			if(user==null)
			{
				throw new HotelException("user with id "+userId+"not found");
			}
			else if(row > 0)
			{
				System.out.println("Deleted User with Id "+userId);

			}

		}
		catch(SQLException e)
		{
			throw new HotelException(e.getMessage());
		}
		return user;
	}



	@Override
	public ArrayList<UserRegister> getAllUser() throws HotelException {

		ArrayList<UserRegister>list = new ArrayList<UserRegister>();
		String qry = "SELECT * FROM UserRegister";
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			while(rs.next())
			{
				int id = rs.getInt(1);

				String username=rs.getString(2);
				String password=rs.getString(3);
				String mobile= rs.getString(4);
				String address=rs.getString(5);
				String email=rs.getString(6);
				String role=rs.getString(7);

				UserRegister user = new UserRegister(id,username,password,mobile,address,email,role);
				list.add(user);
			}
		}
		catch(SQLException e)
		{
			throw new HotelException(e.getMessage());
		}
		return list;
	}
	/////////
	public String getHotelId()throws HotelException
	{
		logger.info("In getHotelId");
		String id = null;
		String qry = "SELECT hId_seq.CURRVAL FROM DUAL";
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			if(rs.next())
			{
				id = rs.getString(1);
				logger.info("Got Hotel with id"+id);
			}
		}
		catch(SQLException e)
		{
			logger.error("error"+e.getMessage());
			throw new HotelException(e.getMessage());
		}
		logger.info("Completed getHotelId");
		return id;

	}
	
	@Override
	public String addHotel(HotelDetails hotel) throws HotelException {

		logger.info("In add HotelDetails");
		logger.info("input is "+hotel);
		String id = null;
		String qry = "INSERT INTO hoteldetails VALUES(hId_seq.NEXTVAL,?,?,?,?,?,?,?,?,?)";
		String name = hotel.getHotelName();
		String city = hotel.getCity();
		String address = hotel.getAddress(); 
		String des=hotel.getDescription();
		String avgRate=hotel.getAvgRatePerNight();
		String phone=hotel.getPhone();
		String rating=hotel.getRating();
		String email=hotel.getEmail();
		String fax=hotel.getFax();
		try
		{
			PreparedStatement pstmt = con.prepareStatement(qry);
			pstmt.setString(1, name);
			pstmt.setString(2, city);
			pstmt.setString(3, address);
			pstmt.setString(4, des);
			pstmt.setString(5, avgRate);
			pstmt.setString(6, phone);
			pstmt.setString(7, rating);
			pstmt.setString(8, email);
			pstmt.setString(9, fax);


			int row = pstmt.executeUpdate();
			if(row > 0)
			{
				id = getHotelId();
				logger.info("inserted successfully and id is= "+id);
			}
			else
				throw new HotelException("unable to insert"+hotel);

		}
		catch(SQLException e)
		{
			logger.error("error in insert= "+e.getMessage());
			throw new HotelException(e.getMessage());
		}
		return id;
	}

	@Override
	public HotelDetails removeHotel(String hotelId) throws HotelException {
		// TODO Auto-generated method stub
		HotelDetails hotel = null;
		String qry = "DELETE FROM Hoteldetails WHERE hotelId=?";
		try
		{
			PreparedStatement pstmt = 
					con.prepareStatement(qry);
			pstmt.setString(1, hotelId);
			hotel = getHotelById(hotelId);
			int row = pstmt.executeUpdate();
			if(hotel==null)
			{
				throw new HotelException("hotel with id "+hotelId+"not found");
			}
			else if(row > 0)
			{
				System.out.println("Deleted hotel with Id "+hotelId);

			}

		}
		catch(SQLException e)
		{
			throw new HotelException(e.getMessage());
		}
		return hotel;
	}

	@Override
	public HotelDetails getHotelById(String hotelId)throws HotelException {

		HotelDetails hotel = null;
		String qry = "SELECT * FROM HotelDetails WHERE hotelId=?";
		try
		{
			PreparedStatement pstmt = 
					con.prepareStatement(qry);
			pstmt.setString(1, hotelId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				
				String id=rs.getString(1);				
				String name = rs.getString(2);
				String city = rs.getString(3);
				String address = rs.getString(4);
				String des=rs.getString(5);
				String avgRate=rs.getString(6);
				String phone=rs.getString(7);
				String rating=rs.getString(8);
				String email=rs.getString(9);
				String fax=rs.getString(10);
				hotel = new HotelDetails(id,name,city,address,des,avgRate,phone,rating,email,fax);
			}
			else
				throw new HotelException("Hotel with id "+hotelId+"not found");
		}
		catch(SQLException e)
		{
			throw new HotelException(e.getMessage());
		}
		return hotel;
	}

	@Override
	public ArrayList<HotelDetails> getAllHotels() throws HotelException {

		ArrayList<HotelDetails>list = new ArrayList<HotelDetails>();
		String qry = "SELECT * FROM HotelDetails";
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			while(rs.next())
			{
				String id=rs.getString(1);				
				String name = rs.getString(2);
				String city = rs.getString(3);
				String address = rs.getString(4);
				String des=rs.getString(5);
				String avgRate=rs.getString(6);
				String phone=rs.getString(7);
				String rating=rs.getString(8);
				String email=rs.getString(9);
				String fax=rs.getString(10);
				HotelDetails hotel = new HotelDetails(id,name,city,address,des,avgRate,phone,rating,email,fax);
				list.add(hotel);
			}
		}
		catch(SQLException e)
		{
			throw new HotelException(e.getMessage());
		}
		return list;
	}

	@Override
	public HotelDetails updateHotelDetails(String hotelId, String hName)
			throws HotelException {

		HotelDetails hotel = getHotelById(hotelId);
		if(hotel==null)
			throw new HotelException("Hotel with id "+hotelId+"Not found");
		else
		{
			String qry = "UPDATE HotelDetails SET hotelName=? WHERE hotelId=?";
			try{
				PreparedStatement pstmt = 
						con.prepareStatement(qry);
				pstmt.setString(1, hotel.getHotelName());
				pstmt.setString(2, hotelId);
				int row = pstmt.executeUpdate();
				if(row > 0)
				{
					System.out.println("updated successfully");
					hotel = getHotelById(hotelId);
				}      
			}
			catch(SQLException e)
			{
				throw new HotelException(e.getMessage());
			}

		}
		return hotel;
	}

}
