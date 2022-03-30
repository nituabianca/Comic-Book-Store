package beans;

public enum Title {
	XMen(1),
	Hulk(2),
	Batman(3),
	Superman(4),
	Other(5);

	private int titleValue;
	Title(int titleValue) 
	{
		this.titleValue=titleValue;
	}
	
	public int getTitleValue()
	{
		return titleValue;
	}
	
	
}
