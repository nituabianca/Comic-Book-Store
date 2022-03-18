package beans;

public class ComicBook 
{
	public static final String SEPARATOR="\n";
	
	private String title;
	private String artist;
	private String publisher;
	protected int nrOfPages;
	protected String genre;
	protected int year;
	protected double primeCost;
	protected double priceForSale;
	protected boolean sequel;
	
	public ComicBook()
	{
		
	}
	
	public ComicBook(String title, String artist, String publisher, int nrOfPages, String genre, int year, 
			double primeCost, double priceForSale, boolean sequel) throws Exception
	{
		this.title=title;
		this.artist=artist;
		this.publisher=publisher;
		this.nrOfPages=nrOfPages;
		this.genre=genre;
		this.year=year;
		this.primeCost=primeCost;
		this.priceForSale=priceForSale;
		this.sequel=sequel;
	}
	
	@Override
	public String toString() 
	{
		StringBuilder sb=new StringBuilder();
		
		sb.append("Titlul: ").append(title).append(SEPARATOR);
		sb.append("Numele artistului: ").append(artist).append(SEPARATOR);
		sb.append("Editor: ").append(publisher).append(SEPARATOR);
		sb.append("Numarul de pagini: ").append(nrOfPages).append(SEPARATOR);
		sb.append("Gen: ").append(genre).append(SEPARATOR);
		sb.append("Anul publicarii: ").append(year).append(SEPARATOR);
		sb.append("Pret: ").append(primeCost).append(SEPARATOR);
		sb.append("Pret redus: ").append(priceForSale).append(SEPARATOR);
		sb.append("Acest volum este o continuare? ");
		if(sequel==false)
		{
			sb.append("Nu").append(SEPARATOR);
		}
		else
		{
			sb.append("Da").append(SEPARATOR);
		}
		return sb.toString();
	}

	//setters
	public void setTitle(String title) throws Exception 
	{
		if(title.indexOf(" ") == -1)
		{
			throw new Exception("Titlul trebuie sa contina cel putin un spatiu");
		}
		if(title.length() < 3)
		{
			throw new Exception("Titlul trebuie sa aiba cel putin 3 caractere");
		}
		
		if(title.length() > 50)
		{
			throw new Exception("Numarul maxim de careactere ale unui titlu este 50. Titlul introdus are  " + title.length() + "caractere");
		}
		
		this.title=title;
	}

	public void setArtist(String artist) throws Exception 
	{
		if(artist.indexOf(" ") == -1)
		{
			throw new Exception("Numele artistului trebuie sa contina cel putin un spatiu");
		}
		if(artist.length() < 5)
		{
			throw new Exception("Numele artistului trebuie sa aiba cel putin 5 caractere");
		}
		
		if(artist.length() > 50)
		{
			throw new Exception("Numarul maxim de careactere ale unui nume este 50. Numele introdus are  " + artist.length() + "caractere");
		}
		this.artist = artist;
	}

	public void setPublisher(String publisher) throws Exception 
	{
		if(publisher.indexOf(" ") == -1)
		{
			throw new Exception("Numele editorului trebuie sa contina cel putin un spatiu");
		}
		if(publisher.length() < 5)
		{
			throw new Exception("Numele editorului trebuie sa aiba cel putin 5 caractere");
		}
		
		if(publisher.length() > 50)
		{
			throw new Exception("Numarul maxim de careactere ale unui nume este 50. Numele introdus are  " + publisher.length() + "caractere");
		}
		this.publisher = publisher;
	}

	public void setNrOfPages(int nrOfPages) 
	{
		this.nrOfPages = nrOfPages;
	}

	public void setGenre(String genre) throws Exception 
	{
		if(genre.indexOf(" ") == -1)
		{
			throw new Exception("Genul trebuie sa contina cel putin un spatiu");
		}
		if(genre.length() < 5)
		{
			throw new Exception("Genul trebuie sa aiba cel putin 5 caractere");
		}
		
		if(genre.length() > 50)
		{
			throw new Exception("Numarul maxim de careactere ale unui gen este 50. Genul introdus are  " + genre.length() + "caractere");
		}
		this.genre = genre;
	}

	public void setYear(int year) 
	{
		this.year = year;
	}

	public void setPrimeCost(double primeCost) 
	{
		this.primeCost = primeCost;
	}

	public void setPriceForSale(double priceForSale) throws Exception 
	{
		if(priceForSale>primeCost)
		{
			throw new Exception("Pretul introdus nu este redus");
		}
		this.priceForSale = priceForSale;
	}
	
	//getters
	public void setSequel(boolean sequel) 
	{
		this.sequel = sequel;
	}
	
	public String getTitle() 
	{
		return title;
	}
	public String getArtist() 
	{
		return artist;
	}
	public String getPublisher() 
	{
		return publisher;
	}
}
