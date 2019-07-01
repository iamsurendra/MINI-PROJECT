package com.cg.hotelservice.pl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.cg.hotelservice.dto.AdminRegister;
import com.cg.hotelservice.dto.HotelDetails;
import com.cg.hotelservice.dto.UserRegister;
import com.cg.hotelservice.exception.HotelException;
import com.cg.hotelservice.service.HotelService;
import com.cg.hotelservice.service.HotelServiceImpl;
//main controller
public class MainClass {
	static Scanner sc = null;
	static UserRegister customer = null;
	static AdminRegister admin = null;
	static int choice;
	static String add;

	static HotelService service = new HotelServiceImpl();
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		service = new HotelServiceImpl();
		try {
			menuDriven();
		} catch (HotelException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	public static void menuDriven() throws HotelException, IOException
	{
		while(true)
		{
			System.out.println("------------------------*******************-----------------------------");
			System.out.println("------------------------THE TAJ MAHAL PALACE MUMBAI---------------------");
			System.out.println("------------------------*******************-----------------------------");
			System.out.println("1: Sign Up");
			System.out.println("2: Login");
			System.out.println("3: Exit");
			System.out.println("Enter choice::");

			choice = sc.nextInt();
			switch (choice) 
			{
			case 1:
				System.out.println("1-Register as a Admin");
				System.out.println("2-Register as a Customer");
				System.out.println("3- Exit");

				System.out.println("Enter choice::");
				choice = sc.nextInt();
				switch(choice) {
				case 1:

					AdminRegister admin = acceptAdminDetails(); 
					if(admin!=null)
					{	
						try
						{
							int id = service.addAdmin(admin);
							System.out.println("admmin user has been inserted and id = "+id);
						}
						catch(HotelException e)
						{
							System.out.println(e.getMessage());
						}
					}
					break;

				case 2:

					UserRegister admin1 = acceptCustomerDetails(); 
					if(admin1!=null)
					{	
						try
						{
							int id = service.addUser(admin1);
							System.out.println(" user has been inserted and id = "+id);
						}
						catch(HotelException e)
						{
							System.out.println(e.getMessage());
						}
					}
					break;

				case 3:
					System.out.println("THANK YOU FOR USING OUR SERVICES! PLEASE VISIT AGAIN");
					System.exit(0);

				default:
					System.out.println("INVALID CHOICE!"+"\n CHOOSE THE CORRECT OPTION");
					break;

				}

			case 2:
				System.out.println("1-Login as a Admin");
				System.out.println("2-Login as a User");
				System.out.println("3- Exit");

				System.out.println("Enter choice::");
				choice = sc.nextInt();
				switch(choice) 
				{
				case 1:hotelDetails();
				break;
				case 2:bookingRooms();
				break;
				case 3:
					System.out.println("THANK YOU FOR USING OUR SERVICES! PLEASE VISIT AGAIN");
					System.exit(0);
				default:
					System.out.println("INVALID CHOICE!"+"\n CHOOSE THE CORRECT OPTION");
					break;
				}

				break;

			case 3:
				System.out.println("THANK YOU FOR USING OUR SERVICES! PLEASE VISIT AGAIN");
				System.exit(0);

			default:
				System.out.println("INVALID CHOICE!"+"\n CHOOSE THE CORRECT OPTION");
				break;
			}


		}

	}
	private static void hotelDetails() throws HotelException
	{

		System.out.println("WELCOME TO LOGIN OPTION OF THE TAJ MAHAL PALACE MUMBAI In A ADMIN MODE");
		System.out.println("Enter the UserName:");
		String username= sc.next();
		System.out.println("Enter the Password:");
		String password= sc.next();

		ArrayList<AdminRegister> list = service.getAllAdmin();
		for(AdminRegister obj : list){

		}

		Iterator<AdminRegister> it = list.iterator();
		while(it.hasNext())
		{
			admin = it.next();
			String user = admin.getAdminUserName();
			String pw = admin.getPassword();
			if(user.equalsIgnoreCase(username)&& pw.equalsIgnoreCase(password))
			{
				while(true)
				{

					System.out.println("\n-------------------------****************************--------------------------");
					System.out.println("WELCOME TO THE TAJ MAHAL PALACE MUMBAI");
					System.out.println("--------------------------\n");
					System.out.println("1: Add HotelDetails ");
					System.out.println("2: Update HotelDetails");
					System.out.println("3: Delete HotelDetails");					
					System.out.println("4: Add RoomDetails");
					System.out.println("5: Update RoomDetails");
					System.out.println("6: Delete RoomDetails");
					System.out.println("7: LogOut");
					System.out.println(" Enter your choice:");
					choice = sc.nextInt();
					switch (choice) 
					{
					case 1:
						HotelDetails hotel=acceptHotelDetails();	
						if(hotel!=null){	
							try
							{
								String id = service.addHotel(hotel);
								System.out.println("Succuss fully added Hotel details with " + id + "" + hotel.toString());
							}
							catch(HotelException e)
							{
								System.out.println(e.getMessage());
							}}
						break;
					case 2:
						//Update HotelDetails
						System.out.println("Enter id::");
						String hotelid = sc.next();
						System.out.println("Enter your updated name");
						String name = sc.next();
						try{
							HotelDetails eObj = service.updateHotelDetails(hotelid, name);
							System.out.println("updated = "+eObj);
						}
						catch(HotelException e)
						{
							System.out.println(e.getMessage());
						}
						break;
					case 3:
						System.out.println("Enter to id to remove::");
						String hotelId = sc.next();
						try
						{
							HotelDetails hotel1 = service.removeHotel(hotelId);
							System.out.println("removed Employee "+hotel1);
						}
						catch(HotelException e)
						{
							System.out.println(e.getMessage());
						}
						break;
						
					case 4:
						//Add RoomDetails
						break;
					case 5:
						//Update RoomDetails
						break;
					case 6:
						//Delete RoomDetails
						break;
					case 7:
						System.out.println("THANK YOU FOR CHOOSING OUR SERVICES!");
						try {
							menuDriven();
						} catch (HotelException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

					default:
						System.out.println("INVALID CHOICE!"+"\n CHOOSE THE CORRECT OPTION");
						break;
					}

				}
			}
		}

	}

	private static void bookingRooms() throws HotelException
	{

		System.out.println("WELCOME TO LOGIN OPTION OF BOOKING ROOMS In A CUSTOMER MODE");
		System.out.println("Enter the UserName:");
		String username= sc.next();
		System.out.println("Enter the Password:");
		String password= sc.next();

		ArrayList<UserRegister> list = service.getAllUser();
		for(UserRegister obj : list){

		}

		Iterator<UserRegister> it = list.iterator();
		while(it.hasNext())
		{
			customer = it.next();
			String user = customer.getUserName();
			String pw = customer.getPassword();
			if(user.equalsIgnoreCase(username)&& pw.equalsIgnoreCase(password))
			{
				while(true)
				{

					System.out.println("\n------------------------");
					System.out.println("WELCOME TO THE TAJ MAHAL PALACE MUMBAI");
					System.out.println("--------------------------\n");
					System.out.println("1: Add BookingDetails ");
					System.out.println("2: Delete Booking");
					System.out.println("3: Update records of Customer");
					System.out.println("4: View Hoteldetails");
					System.out.println("5: View Room Details");	
					System.out.println("6: View of customer records");
					System.out.println("7: LogOut");
					System.out.println(" Enter your choice:");
					choice = sc.nextInt();
					switch (choice) 
					{
					case 1:
						acceptCustomerDetails();
						break;
					case 2:
						removeUser();
						break;
					case 3:
						//Update records of Customer
						break;
					case 4:
						//View Hoteldetails
						try{ArrayList<HotelDetails>hlist = 
						service.getAllHotels();
						for(HotelDetails obj : hlist)
						{
							System.out.println(obj);
						}
						}
						catch(HotelException e)
						{
							System.out.println(e.getMessage());
						}
						break;
						
					case 5:
						//View Room Details
						break;
					case 6:
						//View of customer records
						break;
					case 7:
						System.out.println("THANK YOU FOR CHOOSING OUR SERVICES!");
						try {
							menuDriven();
						} catch (HotelException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

					default:
						System.out.println("INVALID CHOICE!"+"\n CHOOSE THE CORRECT OPTION");
						break;
					}

				}
			}
		}

	}




	public static AdminRegister acceptAdminDetails()
	{
		AdminRegister admin = null;
		Scanner sc = new Scanner(System.in);

		while(true)
		{
			System.out.println("Enter admin user name to use in app:");
			String username = sc.next();
			if(!service.validateName(username))
			{
				continue;
			}
			else
			{
				System.out.println("Enter password of admin to use in app:");
				String password = sc.next();
				if(!service.validateName(password))
				{
					continue;
				}
				else
				{
					System.out.println("Enter Mobile number of admin :");
					String mobile = sc.next();
					if(!service.validatePhone(mobile))
					{
						continue;
					}
					else
					{
						System.out.println("Enter address of admin :");
						String address = sc.next();
						System.out.println("Enter email of admin :");
						String email = sc.next();


						if(email!=null)
						{
							admin = new AdminRegister();
							admin.setAdminUserName(username);
							admin.setPassword(password);
							admin.setMobile(mobile);
							admin.setAddress(address);
							admin.setEmail(email);
							break;
						}
					}
				}
			}

		}


		return admin;




	}

	public static UserRegister removeUser() {
		UserRegister user = null;
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter userId no of  user::");
			int  userId = sc.nextInt();
			if(!service.validateUserId(userId))
			{
				continue;
			}
			else
			{
				user = new UserRegister();

				break;
			}
		}

		return user;
	}
	public static UserRegister acceptCustomerDetails()
	{
		UserRegister user = null;
		Scanner sc = new Scanner(System.in);

		while(true)
		{
			System.out.println("Enter  username of user  to use in app:");
			String username = sc.next();
			if(!service.validateName(username))
			{
				continue;
			}
			else
			{
				System.out.println("Enter password of user to use in app:");
				String password = sc.next();
				if(!service.validateName(password))
				{
					continue;
				}
				else
				{
					System.out.println("Enter Mobile number of user :");
					String mobile = sc.next();
					if(!service.validatePhone(mobile))
					{
						continue;
					}
					else
					{
						System.out.println("Enter address of user  :");
						String address = sc.next();
						System.out.println("Enter Email of user  :");
						String email=sc.next();
						System.out.println("Enter Role of user  :");
						String role=sc.next();

						if(role!=null)
						{
							user = new UserRegister();

							user.setAddress(address);
							user.setMobile(mobile);
							user.setUserName(username);
							user.setPassword(password);
							user.setEmail(email);
							user.setRole(role);
							break;
						}
					}
				}
			}

		}


		return user;

	}

	public static HotelDetails acceptHotelDetails()
	{
		HotelDetails hotel = null;
		Scanner sc = new Scanner(System.in);

		while(true)
		{
			System.out.println("Enter  Hotel Name of hotel  to use in app:");
			String hotelname = sc.next();
			if(!service.validateName(hotelname))
			{
				continue;
			}
			else
			{
				System.out.println("Enter City of hotel to use in app:");
				String city = sc.next();
				if(!service.validateName(city))
				{
					continue;
				}
				else
				{
					System.out.println("Enter address  of hotel :");
					String address = sc.next();
					System.out.println("Enter description  of hotel :");
					String description = sc.next();
					System.out.println("Enter avg Rate Per Night  of hotel :");
					String avgRatePerNight = sc.next();
					System.out.println("Enter phone  of user :");
					String phone = sc.next();
					if(!service.validatePhone(phone))
					{
						continue;
					}
					else
					{
						System.out.println("Enter rating of hotel  :");
						String rating = sc.next();
						System.out.println("Enter Email of hotel  :");
						String email=sc.next();
						System.out.println("Enter Fax of hotel  :");
						String fax=sc.next();

						if(fax!=null)
						{
							hotel = new HotelDetails();
							hotel.setHotelName(hotelname);
							hotel.setCity(city);
							hotel.setAddress(address);
							hotel.setDescription(description);
							hotel.setAvgRatePerNight(avgRatePerNight);
							hotel.setPhone(phone);
							hotel.setRating(rating);
							hotel.setEmail(email);
							hotel.setFax(fax);
							break;
						}
					}
				}

			}

		}


		return hotel;

	}



}









