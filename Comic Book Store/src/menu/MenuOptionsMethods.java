package menu;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import beans.Artist;
import beans.ComicBook;
import beans.Genre;
import beans.Title;
import exception.InvalidUserInteractionException;
import util.Constants;

public class MenuOptionsMethods implements MenuInterface
{
	private Scanner sc = new Scanner(System.in);

	@Override
	public ComicBook addComicBook()
	{
		ComicBook comicBook=new ComicBook();
		comicBook.setId(comicBook.getId());
		comicBook.setTitle(comicBook.getTitle());
		comicBook.setArtist(comicBook.getArtist());
		try {
			comicBook.setPublisher(comicBook.getPublisher());
		} catch (Exception e) {
			e.printStackTrace();
		}
		comicBook.setNrOfPages(comicBook.getNrOfPages());
		comicBook.setGenre(comicBook.getGenre());
		comicBook.setYear(comicBook.getYear());
		comicBook.setPrimeCost(comicBook.getPrimeCost());
		try {
			comicBook.setPriceForSale(comicBook.getPriceForSale());
		} catch (Exception e) {
			e.printStackTrace();
		}
		comicBook.setSequel(comicBook.isSequel());
		return comicBook;
	}
	
	public Integer deleteComicBook()
	{
		return ComicBook.getId();
	}
	
	public ComicBook updateComicBook()
	{
		return addComicBook();
	}
	private Integer getId() {
        System.out.println("Id: ");
        try {
            Integer id = Integer.parseInt(sc.nextLine());
            return id;
        } catch (Exception ex) {
            System.out.println("Id invalid. Incearca din nou!");
        }
        return getId();
    }
	public Title getTitle() {
        System.out.println("Titlu:" + Title.XMen.getTitleValue() + " - XMen, " + 
        		Title.Hulk.getTitleValue() + " - Hulk, " + 
        		Title.Batman.getTitleValue() + " - Batman "+
        		Title.Superman.getTitleValue() + " - Superman, " + 
        		Title.Other.getTitleValue() + " - Other, "
        		);
        try {
            Integer titleId = Integer.parseInt(sc.nextLine());
            if (titleId != 1 && titleId != 2 && titleId != 3 && titleId != 4 && titleId != 5 ) {
                throw new InvalidUserInteractionException();
            }
            Title title = titleId == 1 ? Title.XMen : titleId == 2 ? Title.	Hulk : 
            	titleId == 3 ? Title.Batman : titleId == 4 ? Title.Superman :Title.Other ;
            return title;
        } catch (Exception ex) {
            System.out.println("Titlu gresit. Incearca din nou!");
        }
        return getTitle();
    }
	public Artist getArtist() {
        System.out.println("Artist:" + Artist.ChrisClaremont.getArtistValue() + " - ChrisClaremont, " + 
        		Artist.PeterDavid.getArtistValue() + " - PeterDavid, " + 
        		Artist.	AlanMoore.getArtistValue() + " - AlanMoore "+
        		Artist.GrantMorrison.getArtistValue() + " - GrantMorrison, " + 
        		Artist.Other.getArtistValue() + " - Other, "
        		);
        try {
            Integer artistId = Integer.parseInt(sc.nextLine());
            if (artistId != 1 && artistId != 2 && artistId != 3 && artistId != 4 && artistId != 5 ) {
                throw new InvalidUserInteractionException();
            }
            Artist title = artistId == 1 ? Artist.ChrisClaremont : artistId == 2 ? Artist.	PeterDavid : 
            	artistId == 3 ? Artist.AlanMoore : artistId == 4 ? Artist.GrantMorrison :Artist.Other ;
            return title;
        } catch (Exception ex) {
            System.out.println("Artist gresit. Incearca din nou!");
        }
        return getArtist();
    }
	public Genre getGenre() {
        System.out.println("Gen:" + Genre.SF.getGenreValue() + " - SF, " + 
        		Genre.Romance.getGenreValue() + " - Romance, " + 
        		Genre.Humor.getGenreValue() + " - Humor "+
        		Genre.Horror.getGenreValue() + " - Horror, " + 
        		Genre.Other.getGenreValue() + " - Other, "
        		);
        try {
            Integer genreId = Integer.parseInt(sc.nextLine());
            if (genreId != 1 && genreId != 2 && genreId != 3 && genreId != 4 && genreId != 5 ) {
                throw new InvalidUserInteractionException();
            }
            Genre genre = genreId == 1 ? Genre.SF : genreId == 2 ? Genre.	Romance : 
            	genreId == 3 ? Genre.Humor : genreId == 4 ? Genre.Horror :Genre.Other ;
            return genre;
        } catch (Exception ex) {
            System.out.println("Artist gresit. Incearca din nou!");
        }
        return getGenre();
    }
	private String getPublisher() {
        System.out.println("Editor: ");
        try {
            String publisher = sc.nextLine();
            return publisher;
        } catch (Exception ex) {
            System.out.println("Invalid. Incearca din nou!");
        }
        return getPublisher();
    }
	private Integer getNrOfPages() {
        System.out.println("Nr. pagini: ");
        try {
            Integer nrOfpages = Integer.parseInt(sc.nextLine());
            return nrOfpages;
        } catch (Exception ex) {
            System.out.println("Invalid. Incearca din nou!");
        }
        return getNrOfPages();
    }
	private Integer getYear() {
        System.out.println("An: ");
        try {
            Integer year = Integer.parseInt(sc.nextLine());
            return year;
        } catch (Exception ex) {
            System.out.println("Invalid. Incearca din nou!");
        }
        return getYear();
    }
	public Double getPrimeCost() {
        System.out.println("Pret initial: ");
        try {
            Double primeCost = Double.parseDouble(sc.nextLine());
            return primeCost;
        } catch (Exception ex) {
            System.out.println("Invalid. Incearca din nou!");
        }
        return getPrimeCost();
    }
	private Double getPriceForSale() {
        System.out.println("Pret redus: ");
        try {
            Double priceForsale = Double.parseDouble(sc.nextLine());
            return priceForsale;
        } catch (Exception ex) {
            System.out.println("Invalid. Incearca din nou!");
        }
        return getPriceForSale();
    }
	private Boolean isSequel() {
        System.out.println("Pret redus: ");
        try {
            Boolean sequel = Boolean.parseBoolean(sc.nextLine());
            return sequel;
        } catch (Exception ex) {
            System.out.println("Invalid. Incearca din nou!");
        }
        return isSequel();
    }	
	private LocalDate getDate() {
        System.out.println("Data(" + Constants.DATE_FORMAT + "):");
        try {
            return LocalDate.parse(sc.nextLine());
        } catch (Exception ex) {
            System.out.println("Format invalid. Incearca din nou!");
        }
        return getDate();
    }
	

}
