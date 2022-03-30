package main;


import java.io.FileReader;
import java.util.Scanner;


import login.Auth;
import login.AuthInterface;
import service.UserInteraction;
import service.UserInteractionInterface;
import beans.ComicBook;

public class RunMe 
{

	public static void main(String[] args) throws Exception 
	{
		AuthInterface auth = new Auth();
        auth.authenticate();
        UserInteractionInterface userInteractionService = new UserInteraction();
        userInteractionService.initInteraction();
	}

}
