package com.revature.pixott.handler;

import java.util.Scanner;

import com.revature.fsd.pixott.dao.SearchMovieDao;
import com.revature.fsd.pixott.dao.UserDao;
import com.revature.fsd.pixott.dao.WishListDao;

public class SearchMovieHandler {


    public static void display() {
    	//Scanner sc=new Scanner(System.in);
    	App.scanner.nextLine();
    	String name = App.scanner.nextLine();
    	SearchMovieDao.Search(name);
    	System.out.println("enter the movie id ");
    	int movieid= App.scanner.nextInt();
    	int userid= UserDao.id;
    System.out.println("enter the option");	
    System.out.println("1.add to wishlist");
    System.out.println("2.play the movie");
    System.out.println("3 back to menu");
    int option = App.scanner.nextInt();
    if(option==1) {
    	WishListDao.insertWishList(movieid, userid);
    }
    else  if(option==2) {
    	
    }else if(option==3) {
    	AdminMenu.display();
    }
	
}
}
