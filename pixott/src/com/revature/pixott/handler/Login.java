package com.revature.pixott.handler;



import com.revature.fsd.pixott.dao.UserDao;
import com.revature.pixott.model.User.User;

public class Login {
	
public static void display(){
	
{	
	System.out.println("Login");
	System.out.println("-----------");
    System.out.println("mobile number:");
   	String mobile =App.scanner.nextLine();
   	App.scanner.nextLine();
	System.out.println("password:");
	String password= App.scanner.nextLine();
	User user = new User();
	UserDao dao = new UserDao();
	 user= dao.getLogin(password);
	 if(user.getPassword().equals(password))
		{
			System.err.println("Login Successful");
			System.out.print(user.getName());
			System.out.println(" welcome to ott platform");
			int userid = UserDao.id;
			System.out.println(userid);
		AdminMenu.display();
		
			
		} else {
			System.err.println("mobile number or password does not match ,please check and login again");
	     }	
   }
 }
}
