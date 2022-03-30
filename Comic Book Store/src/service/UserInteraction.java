package service;

import java.util.Scanner;

import beans.Artist;
import beans.ComicBook;
import beans.Genre;
import beans.Title;
import exception.InvalidUserInteractionException;
import menu.MenuAction;
import menu.MenuActionInterface;
import menu.MenuInterface;
import menu.MenuOptionsMethods;
import util.Constants;

public class UserInteraction implements UserInteractionInterface {
	private Scanner scanner = new Scanner(System.in);
	MenuInterface menuOptionsMethods=new MenuOptionsMethods();
	MenuActionInterface menuAction=new MenuAction();
	
	public void initInteraction(){
        switch (chooseInitialAction()) {
            case Constants.ACCESS_DATABASE:
                switch (chooseAccessDatabaseAction()) {
                    case Constants.LIST_COMICBOOKS:
                    	menuAction.listComicBooks();
                        break;
                    case Constants.ADD_COMICBOOKS:
                        ComicBook comicBook = menuOptionsMethods.addComicBook();
                        menuAction.addComicBook(comicBook);
                        break;
                    case Constants.DELETE_COMICBOOK:
                        int idToBeDeleted = menuOptionsMethods.deleteComicBook();
                        menuAction.deleteComicBook(idToBeDeleted);
                        break;
                    case Constants.UPDATE_COMICBOOK:
                        ComicBook comicBookToBeUpdated = menuOptionsMethods.updateComicBook();
                        menuAction.updateComicBook(comicBookToBeUpdated);
                        break;
                    case Constants.RETURN_TO_MENU:
                        initInteraction();
                        break;
                }
                break;
            case Constants.VIEW_REPORTS:
                switch (chooseViewReportsAction()) {
                    case Constants.NEW_YEAR_DISCOUNT:
                        Double primeCost = menuOptionsMethods.getPrimeCost();
                        Double newYearDiscount = menuAction.newYearDiscount(primeCost);
                        System.out.println("Reducerea de Anul Nou este "+newYearDiscount);
                        break;
                    case Constants.BLACK_FRIDAY_DISCOUNTS:
                        Double primeCostBF = menuOptionsMethods.getPrimeCost();
                        Double blackfridayDiscount = menuAction.blackFridayDiscount(primeCostBF);
                        System.out.println("Reducerea de Black Friday este "+blackfridayDiscount);
                        break;
                    case Constants.FILTER_BY_GENRE:
                        System.out.println("Sortare dupa gen ");
                        Genre genre=menuOptionsMethods.getGenre();
                        System.out.println(menuAction.filteredComicBooksByGenre(genre));
                        break;
                    case Constants.FILTER_BY_TITLE:
                        System.out.println("Sortare dupa titlu ");
                        Title title=menuOptionsMethods.getTitle();
                        System.out.println(menuAction.filteredComicBooksByTitle(title));
                        break;
                    case Constants.FILTER_BY_ARTIST:
                        System.out.println("Sortare dupa autor ");
                        Artist artist=menuOptionsMethods.getArtist();
                        System.out.println(menuAction.filteredComicBooksByArtist(artist));
                        break;
                    case Constants.RETURN_TO_MENU:
                        initInteraction();
                }
                break;
        }
        initInteraction();
    }
	
	private Integer chooseInitialAction() {
        System.out.println("Alege o optiune: ");
        System.out.println("Acces baza de date - " + Constants.ACCESS_DATABASE);
        System.out.println("Rapoarte " + Constants.VIEW_REPORTS);
        try {
            Integer action = Integer.parseInt(scanner.nextLine());
            if (action != Constants.ACCESS_DATABASE && action != Constants.VIEW_REPORTS) {
                throw new InvalidUserInteractionException();
            }
            return action;
        } catch (Exception ex) {
            System.out.println("Optiune invalida. " + Constants.ACCESS_DATABASE + " (acces baza de date)" +
                    " sau " + Constants.VIEW_REPORTS + " (rapoarte)!");
        }
        return chooseInitialAction();
    }
	private Integer chooseAccessDatabaseAction() {
        System.out.println("Lista comicbooks - " + Constants.LIST_COMICBOOKS);
        System.out.println("Adauga comicbooks - " + Constants.ADD_COMICBOOKS);
        System.out.println("Sterge comicbooks - " + Constants.DELETE_COMICBOOK);
        System.out.println("Actualizeaza comicbooks - " + Constants.UPDATE_COMICBOOK);
        System.out.println("Intoarce-te la meniul initial - " + Constants.RETURN_TO_MENU);
        try {
            int action = Integer.parseInt(scanner.nextLine());
            if (action != Constants.LIST_COMICBOOKS && action != Constants.ADD_COMICBOOKS &&
                    action != Constants.DELETE_COMICBOOK &&
                    action != Constants.UPDATE_COMICBOOK &&
                    action != Constants.RETURN_TO_MENU) {
                throw new InvalidUserInteractionException();
            }
            return action;
        } catch (Exception e) {
            System.out.println("Optiune invalida");
        }
        return chooseAccessDatabaseAction();
    }
	private Integer chooseViewReportsAction() {
        System.out.println("Reduceri de Anul Nou - " + Constants.NEW_YEAR_DISCOUNT);
        System.out.println("Reduceri de Black Friday - " + Constants.BLACK_FRIDAY_DISCOUNTS);
        System.out.println("Sortare dupa gen - " + Constants.FILTER_BY_GENRE);
        System.out.println("Sortare dupa titlu - " + Constants.FILTER_BY_TITLE);
        System.out.println("Sortare dupa artist - " + Constants.FILTER_BY_ARTIST);
        System.out.println("Intoarce-te la meniul initial - " + Constants.RETURN_TO_MENU);
        try {
            Integer action = Integer.parseInt(scanner.nextLine());
            if (action != Constants.NEW_YEAR_DISCOUNT &&
                    action != Constants.BLACK_FRIDAY_DISCOUNTS &&
                    action != Constants.FILTER_BY_GENRE &&
                    action != Constants.FILTER_BY_TITLE &&
                    action != Constants.FILTER_BY_ARTIST &&
                    action != Constants.RETURN_TO_MENU) {
                throw new InvalidUserInteractionException();
            }
            return action;
        } catch (Exception e) {
            System.out.println("Optiune invalida");
        }
        return chooseViewReportsAction();
    }


}
