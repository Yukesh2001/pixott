package com.revature.pixott.handler;

import java.util.List;

import com.revature.fsd.pixott.dao.SearchMovieDao;
import com.revature.fsd.pixott.dao.Top5MoviesDao;

public class AdminMenu {
	public static void display() {
		System.out.println("Admin Menu");
		System.out.println("==========");
		System.out.println("1. Top-5 Movies");
		System.out.println("2. search movie");
		System.out.println("3. your watch list");
		System.out.println("4. view history");
		System.out.println("5. Logout");
		System.out.println("Select an option: ");
		int option = App.scanner.nextInt();
		if (option == 1) {
			Top5MoviesDao review = new Top5MoviesDao();
			List<Top5Movies> result = review.Top();
			result.forEach(System.out::println);
			AdminMenu.display();
		}/* else if (option == 2) {
			App.scanner.nextLine();
			String name = App.scanner.nextLine();
			SearchMovieDao.Search(name);
			AdminMenu.display();
		} */else if (option == 2) 
		{
			SearchMovieHandler.display();
		} 
		else 
		{
			System.out.println("Loging Out....!");
			System.out.println("Logout successfull....");
			System.err.println("Miss you Buddy");
			MainMenuHandler.display();
		}
	}
}
