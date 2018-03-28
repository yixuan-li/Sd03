package sd03;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
	    int flag=0;
	    settings set=new settings(500);//Money you have is 500(initial)
	    while (flag==0) {
			System.out.println("Welcome to Settings page of 'King of Wars'");
			System.out.println("--1 Buy Items--");
			System.out.println("--2 Edit Squad Memebers--");
			System.out.println("--3 Check States--");
			System.out.println("--4 Exit--");
			System.out.println("");
		    System.out.print("Enter a number(1-4):"); 
		    Scanner sc = new Scanner(System.in); 
	        int number = sc.nextInt(); 
	    	if (number!=4) {  
	    		set.choices(number);
	    		flag=0;
		    }else{
		    	System.out.println("Exit the game!");
		    	flag=1;
		    }
	    }
	}

}
