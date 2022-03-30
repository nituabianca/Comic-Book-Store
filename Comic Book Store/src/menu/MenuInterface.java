package menu;

import beans.ComicBook;
import beans.Genre;
import beans.Title;
import beans.Artist;

public interface MenuInterface {
	ComicBook addComicBook() ;
	Integer deleteComicBook();
	ComicBook updateComicBook();
	Double getPrimeCost();
	Genre getGenre();
	Artist getArtist();
	Title getTitle();
}
