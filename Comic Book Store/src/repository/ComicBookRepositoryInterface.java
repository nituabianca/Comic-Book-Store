package repository;

import java.util.List;

public interface ComicBookRepositoryInterface 
{
	List<String> readCsv();

	void insertLine(String comicBookString);

	void deleteLine(int comicId);

	void updateLine(int id, String comicBookString);



}
