package db.actions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import beans.Artist;
import beans.ComicBook;
import beans.Genre;
import beans.Title;
import util.Constants;

public class ComicBookMapper {
	
	public ComicBook getComicBookFromCsvLine(String csvLine){
        if (csvLine != null && csvLine.length() > 0) {
            String[] values = csvLine.split(Constants.COMMA_DELIMITER);
            ComicBook comicBook = new ComicBook();
            comicBook.setId(Integer.parseInt(values[0]));
            if (values[1].equals("XMen")) {
            	comicBook.setTitle(Title.XMen);
            } else if (values[1].equals("Hulk")) {
            	comicBook.setTitle(Title.Hulk);
            } else if(values[1].equals("Batman")){
            	comicBook.setTitle(Title.Batman);
            }
            else if(values[1].equals("Superman")){
            	comicBook.setTitle(Title.Superman);
            }
            else {
            	comicBook.setTitle(Title.Other);
            }
            if (values[2].equals("ChrisClaremont")) {
            	comicBook.setArtist(Artist.ChrisClaremont);
            } else if (values[2].equals("PeterDavid")) {
            	comicBook.setArtist(Artist.PeterDavid);
            } else if(values[2].equals("AlanMoore")){
            	comicBook.setArtist(Artist.AlanMoore);
            }
            else if(values[2].equals("GrantMorrison")){
            	comicBook.setArtist(Artist.GrantMorrison);
            }
            else {
            	comicBook.setArtist(Artist.Other);
            }
            try {
				comicBook.setPublisher((values[3]));
			} catch (Exception e) {
				e.printStackTrace();
			}
            comicBook.setNrOfPages(Integer.parseInt(values[4]));
            if (values[5].equals("SF")) {
            	comicBook.setGenre(Genre.SF);
            } else if (values[5].equals("Romance")) {
            	comicBook.setGenre(Genre.Romance);
            } else if(values[5].equals("Humor")){
            	comicBook.setGenre(Genre.Humor);
            }
            else if(values[5].equals("Horror")){
            	comicBook.setGenre(Genre.Horror);
            }
            else {
            	comicBook.setGenre(Genre.Other);
            }            
            comicBook.setYear(Integer.parseInt(values[6]));
            comicBook.setPrimeCost(Double.parseDouble(values[7]));
			comicBook.setPriceForSale(Double.parseDouble(values[8]));
            comicBook.setSequel(Boolean.parseBoolean(values[9]));
         //   comicBook.setDate(LocalDate.parse(values[10]));
            
            return comicBook;
        } else {
            return new ComicBook();
        }
    }
	
	 public String getCsvLineFromComicBook(ComicBook comicBook) {
	        StringBuilder sb = new StringBuilder();
	        sb.append(comicBook.getId());
	        sb.append(Constants.COMMA_DELIMITER);
	        sb.append(comicBook.getTitle());
	        sb.append(Constants.COMMA_DELIMITER);
	        sb.append(comicBook.getArtist());
	        sb.append(Constants.COMMA_DELIMITER);
	        sb.append(comicBook.getPublisher());
	        sb.append(Constants.COMMA_DELIMITER);
	        sb.append(comicBook.getNrOfPages());
	        sb.append(Constants.COMMA_DELIMITER);
	        sb.append(comicBook.getGenre());
	        sb.append(Constants.COMMA_DELIMITER);
	        sb.append(comicBook.getYear());
	        sb.append(Constants.COMMA_DELIMITER);
	        sb.append(comicBook.getPrimeCost());
	        sb.append(Constants.COMMA_DELIMITER);
	        sb.append(comicBook.getPriceForSale());
	        sb.append(Constants.COMMA_DELIMITER);
	        sb.append(comicBook.isSequel());
	        return sb.toString();
	    }

	    public List<ComicBook> getComicBookList(List<String> stringComicBooks) {
	        List<ComicBook> comicBooks = new ArrayList<>();
	        for (String comicBookString : stringComicBooks) {
	            comicBooks.add(getComicBookFromCsvLine(comicBookString));
	        }
	        return comicBooks;
	    }
}
