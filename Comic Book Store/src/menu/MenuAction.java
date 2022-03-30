package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import beans.Artist;
import beans.ComicBook;
import beans.Genre;
import beans.Title;
import db.actions.ComicBookMapper;
import repository.ComicBookRepository;
import repository.ComicBookRepositoryInterface;

public class MenuAction implements MenuActionInterface
{
	private Scanner sc=new Scanner(System.in);
	private ComicBookRepositoryInterface comicBookRepository=new ComicBookRepository();
	private ComicBookMapper comicBookMapper=new ComicBookMapper();
	
	public void listComicBooks()
	{
		List<String> csvLines = comicBookRepository.readCsv();
        for (String csvLine : csvLines) {
            ComicBook comicBook = comicBookMapper.getComicBookFromCsvLine(csvLine);
            if (comicBook != null) {
                System.out.println(comicBook.toString());
            }
        }
	}
	
	@Override
    public void addComicBook(ComicBook comicBook) {

        String comicBookString = comicBookMapper.getCsvLineFromComicBook(comicBook);
        comicBookRepository.insertLine(comicBookString);
    }

    @Override
    public void deleteComicBook(Integer id) {
    	comicBookRepository.deleteLine(id);
    }

    @Override
    public void updateComicBook(ComicBook comicBook) {
        String comicBookString = comicBookMapper.getCsvLineFromComicBook(comicBook);
        comicBookRepository.updateLine(comicBook.getId(), comicBookString);
    }

    @Override
    public Double newYearDiscount(double primeCost){
        List<ComicBook> comicBooks = comicBookMapper.getComicBookList(comicBookRepository.readCsv());
        return primeCost*(10/100) ;
    }
    
    @Override
    public Double blackFridayDiscount(double primeCost) {
        List<ComicBook> comicBooks = comicBookMapper.getComicBookList(comicBookRepository.readCsv());
        
        return primeCost*(50/100) ;
    }
    @Override
    public String filteredComicBooksByGenre(Genre genre){
        List<ComicBook> comicBooks = comicBookMapper.getComicBookList(comicBookRepository.readCsv());
        List<ComicBook> filteredComicBooks = new ArrayList<>();
        for (ComicBook comicBook : comicBooks) {
            if (comicBook.getGenre().equals(genre)) {
                filteredComicBooks.add(comicBook);
            }
        }
        return filteredComicBooksByGenre(ComicBook.getGenre());
    }
    
    @Override
    public String filteredComicBooksByTitle(Title title){
        List<ComicBook> comicBooks = comicBookMapper.getComicBookList(comicBookRepository.readCsv());
        List<ComicBook> filteredComicBooks = new ArrayList<>();
        for (ComicBook comicBook : comicBooks) {
            if (comicBook.getTitle().equals(title)) {
                filteredComicBooks.add(comicBook);
            }
        }
        return filteredComicBooksByTitle(ComicBook.getTitle());
    }
    
    @Override
    public String filteredComicBooksByArtist(Artist artist){
        List<ComicBook> comicBooks = comicBookMapper.getComicBookList(comicBookRepository.readCsv());
        List<ComicBook> filteredComicBooks = new ArrayList<>();
        for (ComicBook comicBook : comicBooks) {
            if (comicBook.getArtist().equals(artist)) {
                filteredComicBooks.add(comicBook);
            }
        }
        return filteredComicBooksByArtist(ComicBook.getArtist());
    }    

}