package beans;

public enum Genre {
	SF(1),
	Romance(2),
	Humor(3),
	Horror(4),
	Other(5);

	private int genreValue;
	Genre(int genreValue) {
		this.genreValue=genreValue;
	}
	
	public int getGenreValue() 
	{
		return genreValue;
	}
	
	
}
