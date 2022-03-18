package main;

import java.util.Scanner;

import beans.ComicBook;

public class RunMe 
{

	public static void main(String[] args) throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		
		ComicBook cb=new ComicBook("W", "Lee JonSuk", "Park Hoon", 1039, "Drama", 2013, 20.06, 18.00, true);
		
		System.out.println(cb);
		
	}

}
