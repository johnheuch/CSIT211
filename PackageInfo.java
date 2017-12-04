//Author:		John Heuchan, Tyler Haigis, Rafay Khummar
//Program Name:		PackageInfo.java
//Program Description:	This is the data structure.  This is used by PickUo.java and Delivery.java.
//			This handles this list and calls the PackageInfo methods.
//IDE used:		Eclipse IDE for Java Developers, Version: Oxygen Release (4.7.0)


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
	private String DelType;
	
	public PackageInfo(int PackageNumber,String FirstName,String LastName,String Address,String City,String State,String Zip, String Date, String DType) 
	{
		this.PNumber = PackageNumber;
		this.FName=FirstName;
		this.LName = LastName;
		this.Address = Address;
		this.City= City;
		this.State= State;
		this.Zip= Zip;
		this.Date=Date;
		this.DelType= DType;
	
	}
	
	public PackageInfo(int PackageNumber,String FirstName,String LastName,String Address,String City,String State,String Zip) 
	{
		this(PackageNumber,FirstName,LastName,Address,City,State,Zip,"", "");
	}
	//  This section allows each element to be accessed.
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
	public String GetDelType()
	{
		return DelType;
	}
	//  This section allows the following fields to be updated indvidually.
	public void SetDate(String date)
	{
		this.Date= date;
	}
	public void SetDelType(String DType)
	{
		this.DelType= DType;
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
