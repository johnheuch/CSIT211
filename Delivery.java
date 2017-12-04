//Author:		John Heuchan, Tyler Haigis, Rafay Khurram
//Program Name:		Delivery.java
//Program Description:	This is the linked list of the data  with PackageInfo.java.
//			This handles this list and calls the PackageInfo methods.
//			This controls the Delivery information			
//IDE used:		Eclipse IDE for Java Developers, Version: Oxygen Release (4.7.0)

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Delivery implements Iterable<PackageInfo>, Serializable
{
	private List<PackageInfo> list;
	public Delivery()
	{
		list = new LinkedList<PackageInfo>();
	}
	
	
	
// This adds a package delivery information to the end of the package list
	public void addDelivery(PackageInfo packageinfo) {
		if (packageinfo!= null)
			list.add(packageinfo);
	}
// This removes a package delivery information to the end of the package list
	public void removeDelivery(PackageInfo packageinfo) {
		if (packageinfo!= null)
			list.remove(packageinfo);
	}
	
//  This adds a package delivery information after package specified
	public void addDeliveryAfter(PackageInfo Package,PackageInfo newPackage)
	{
		if (Package == null || newPackage == null)
			return;
		int PackageLocation = list.indexOf(Package);
		if (PackageLocation != -1)
			list.add(PackageLocation+1, newPackage);
	}
	
//  This will change the target package delivery information with new package delivery information.
	public void change(PackageInfo Package,PackageInfo newPackage)
	{
		if (Package == null || newPackage == null)
			return;
		int PackageLocation = list.indexOf(Package);
		if (PackageLocation != -1)
			list.add(PackageLocation, newPackage);
	}	
	
//  This finds and returns the delivery information relating to the package
	public PackageInfo find(int number) 
	{
		for (PackageInfo packageinfo :list) 
			if (number == packageinfo.GetPNumber())
				return packageinfo;
		return null;	
	}
	
//	This returns if the number has been used in the list
//
//	This returns true if found and false if number not found 
	public boolean CheckNumber(int number)
	{
		for (PackageInfo packageinfo : list)
			if (number == packageinfo.GetPNumber())
				return true;
		return false;
	}
	
//This produces a list of the Delivery information the package. 	
	public String toString() {
	String results ="";
	for(PackageInfo packageinfo : list)
		results += packageinfo +"\n";
	return results;
	
}

//	This returns a iterator for Delivery.	
public Iterator<PackageInfo> iterator(){
	return list.iterator();
}

//	This saves a serialized version for this delivery information to the filename
public void save (String filename) throws IOException
{
	FileOutputStream fos= new FileOutputStream(filename);
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(this);
	oos.flush();
	oos.close();
}

//	This loads a serialized delivery information from the filename
public Delivery load(String filename)throws IOException, ClassNotFoundException{
	FileInputStream fis= new FileInputStream(filename);
	ObjectInputStream ois = new ObjectInputStream(fis);
	Delivery Deliver = (Delivery) ois.readObject();
	ois.close();
	return Deliver;
}
}

