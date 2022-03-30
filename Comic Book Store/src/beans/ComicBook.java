package beans;

import java.time.LocalDate;

import util.Constants;

public class ComicBook 
{	
	private static int id;
	private static Title title;
	private static Artist artist;
	private static Genre genre;
	protected String publisher;
	protected int nrOfPages;
	protected int year;
	protected double primeCost;
	protected double priceForSale;
	protected boolean sequel;
//	LocalDate date;
	
	public ComicBook()
	{
		
	}
	
	public ComicBook(Title title, Artist artist, String publisher, int nrOfPages, Genre genre, int year, 
			double primeCost, double priceForSale, boolean sequel, LocalDate date) 
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
		//this.date=date;
	}
	
	@Override
	public String toString() 
	{
		StringBuilder sb=new StringBuilder();
		
		sb.append("ID: ").append(id).append(Constants.SEPARATOR);
		sb.append("Titlul: ").append(title).append(Constants.SEPARATOR);
		sb.append("Numele artistului: ").append(artist).append(Constants.SEPARATOR);
		sb.append("Editor: ").append(publisher).append(Constants.SEPARATOR);
		sb.append("Numarul de pagini: ").append(nrOfPages).append(Constants.SEPARATOR);
		sb.append("Gen: ").append(genre).append(Constants.SEPARATOR);
		sb.append("Anul publicarii: ").append(year).append(Constants.SEPARATOR);
		sb.append("Pret: ").append(primeCost).append(Constants.SEPARATOR);
		sb.append("Pret redus: ").append(priceForSale).append(Constants.SEPARATOR);
		if(sequel==false)
		{
			sb.append("Acest volum este stand alone").append(Constants.SEPARATOR);
		}
		else
		{
			sb.append("Acest volum are o continuare").append(Constants.SEPARATOR);
		}
		//sb.append("Data:").append(date).append(Constants.SEPARATOR);
		return sb.toString();
	}

	//setters
	public void setId(int id)
	{
		this.id=id;
	}
	public void setTitle(Title title)
	{		
		this.title=title;
	}

	public void setArtist(Artist artist) 
	{

		this.artist = artist;
	}

	public void setPublisher(String publisher) throws Exception 
	{
//		if(publisher.indexOf(" ") == -1)
//		{
//			throw new Exception("Numele editorului trebuie sa contina cel putin un spatiu");
//		}
//		if(publisher.length() < 5)
//		{
//			throw new Exception("Numele editorului trebuie sa aiba cel putin 5 caractere");
//		}
//		
//		if(publisher.length() > 50)
//		{
//			throw new Exception("Numarul maxim de careactere ale unui nume este 50. Numele introdus are  " + publisher.length() + "caractere");
//		}
		this.publisher = publisher;
	}

	public void setNrOfPages(int nrOfPages) 
	{
		this.nrOfPages = nrOfPages;
	}

	public void setGenre(Genre genre)
	{
		this.genre=genre;
	}
	public void setYear(int year) 
	{
		this.year = year;
	}

	public void setPrimeCost(double primeCost) 
	{
		this.primeCost = primeCost;
	}

	public void setPriceForSale(double priceForSale)
	{
		this.priceForSale = priceForSale;
	}
	
	public void setSequel(boolean sequel) 
	{
		this.sequel = sequel;
	}
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
	
	//getters
	public static int getId()
	{
		return id;
	}
	public static  Title getTitle() 
	{
		return title;
	}
	public static  Artist getArtist() 
	{
		return artist;
	}
	public String getPublisher() 
	{
		return publisher;
	}

	public int getNrOfPages() {
		return nrOfPages;
	}

	public static  Genre getGenre() {
		return genre;
	}

	public int getYear() {
		return year;
	}

	public double getPrimeCost() {
		return primeCost;
	}

	public double getPriceForSale() {
		return priceForSale;
	}

	public boolean isSequel() {
		return sequel;
	}
//    public LocalDate getDate() {
//        return date;
//    }



}
	
