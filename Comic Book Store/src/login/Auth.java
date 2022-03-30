package login;

import java.util.Scanner;

import util.Constants;

public class Auth implements AuthInterface
{
	@Override
	public void authenticate() 
	{
		Scanner sc=new Scanner(System.in);
		String username;
		String password;
		
		System.out.print("Username: ");
		username=sc.nextLine();
		
		System.out.print("Parola: ");
		password=sc.nextLine();	
		
		if(Constants.USERNAME.equals(username) && Constants.PASSWORD.equals(password))
		{
            System.out.println("Bun venit in cont!");
        }
		else 
		{
            System.out.println("Datele introduse nu sunt corecte!");
            authenticate();
        }
	}
}
