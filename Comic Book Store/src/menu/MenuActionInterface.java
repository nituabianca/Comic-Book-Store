package menu;

import beans.Artist;
import beans.ComicBook;
import beans.Genre;
import beans.Title;

public interface MenuActionInterface 
{
	void listComicBooks();

	void addComicBook(ComicBook comicBook);

	void deleteComicBook(Integer id);

	void updateComicBook(ComicBook comicBook);

	Double newYearDiscount(double primeCost);

	Double blackFridayDiscount(double primeCost);

	String filteredComicBooksByGenre(Genre genre);

	String filteredComicBooksByTitle(Title title);

	String filteredComicBooksByArtist(Artist artist);
	
}
