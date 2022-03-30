package beans;

public enum Artist {
	ChrisClaremont(1),
	PeterDavid(2),
	AlanMoore(3),
	GrantMorrison(4),
	Other(5);

	private int artistValue;
	Artist(int artistValue) 
	{
		this.artistValue=artistValue;
	}
	
	public int getArtistValue()
	{
		return artistValue;
	}
	
}
