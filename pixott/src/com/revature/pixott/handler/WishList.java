package com.revature.pixott.handler;

import com.revature.fsd.pixott.dao.UserDao;
import com.revature.fsd.pixott.dao.WishListDao;

public class WishList {
	
	public static void addWishList() {
		System.out.println("\nEnter Movie ID : ");
		int movieid = Integer.parseInt(App.scanner.next());
		int user_id = UserDao.id;
		System.out.println(user_id);
		WishListDao.insertWishList(movieid, user_id);
		System.out.println("Wish List Added ");
		AdminMenu.display();

	}
	
	
}


