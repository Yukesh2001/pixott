package com.revature.pixott.handler;

import com.revature.fsd.pixott.dao.UserDao;
import com.revature.pixott.model.User.User;

public class Signup 
{
	public static void display() 
	{
		System.out.println("-----------");
		System.out.println("SignUP");
		System.out.println("-----------");
		System.out.println("name:");
		String name=App.scanner.next();
		System.out.println("mobile Number:");
		String mobile =App.scanner.next();
		System.out.println("password");
		String password=App.scanner.next();
	                                                                                               
		UserDao dao=new UserDao();
		User user=new User();
		user.setName(name);
		user.setMobile(mobile);
		user.setPassword(password);
		dao.signup(user);
	 }
}
			
	

