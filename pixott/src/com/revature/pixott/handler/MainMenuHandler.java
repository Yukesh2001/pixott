package com.revature.pixott.handler;
import java.util.Scanner;
public class MainMenuHandler {
	public static void display() {
		System.out.println("===================");
		System.out.println("Welcome to Pixott");
		System.out.println("===================");
		System.out.println("MainMenu");
		System.out.println("========");
		System.out.println("1.Signup");
		System.out.println("2.LogIn");
		System.out.println("3.Exit");
		System.out.println("Enter Option");
		Scanner sc=new Scanner(System.in);
		int option=sc.nextInt();
		{
		if(option==1) {
			 Signup.display();
			MainMenuHandler.display();
		}
		else if(option==2) {
			Login.display();
			
		}
		else {
			System.err.println("Miss you Buddy");
		}
		sc.close();
	}
}
}


	