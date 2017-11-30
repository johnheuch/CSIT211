//Author:				John Heuchan
//Program Name:			PackageInfo.java
//Program Description:	This is the data structure.  We can add and subtract to this!!!
//						This handles this list and calls the PackageInfo methods.
//						****THIS FILE WILL NOT BE SUBMIITED FOR FINAL
//						The PU load is edited out I am working on the load function but wanted everone to see what I had
//						Open for suggestions  I will be adding comments
//IDE used:				Eclipse IDE for Java Developers, Version: Oxygen Release (4.7.0)
import java.io.Serializable;
public class PackageInfo implements Serializable
{
	private int PNumber;
	private String FName;
	private String LName;
	private String Address;
	private String City;
	private String State;
	private String Zip;
	private String Date;
	
	public PackageInfo(int PackageNumber,String FirstName,String LastName,String Address,String City,String State,String Zip, String Date) 
	{
		this.PNumber = PackageNumber;
		this.FName=FirstName;
		this.LName = LastName;
		this.Address = Address;
		this.City= City;
		this.State= State;
		this.Zip= Zip;
		this.Date=Date;
	
	}
	
	public PackageInfo(int PackageNumber,String FirstName,String LastName,String Address,String City,String State,String Zip) 
	{
		this(PackageNumber,FirstName,LastName,Address,City,State,Zip,"");
//		this.PNumber = PackageNumber;
	//	this.FName=FirstName;
	//	this.LName = LastName;
	//	this.Address = Address;
	//	this.City= City;
	//	this.State= State;
	//	this.Zip= Zip;
		
	}
	public int GetPNumber()
	{
		return PNumber;
	}
	public String GetFName()
	{
		return FName;
	}
	public String GetLName()
	{
		return LName;
	}
	public String GetAddress()
	{
		return Address;
	}
	public String City()
	{
		return City;
	}
	public String State()
	{
		return State;
	}
	public String GetZip()
	{
		return Zip;
	}
	public String GetDate()
	{
		return Date;
	}
	public void SetDate(String date)
	{
		this.Date= date;
	}

	// Returns true if date is entered(if a date has been entered for pickup or delivery)
	public boolean status() {
		return !Date.equals("");
	}


	public String toString()
	{
		String results = PNumber + " " + FName + " " + LName + "\n" + Address + "\n"+ City + " " + State + " " + Zip + "\n" + Date;
		return results;
	}
	
}
