//Author:				John Heuchan, Tyler Haigis, Rafay Khurram
//Program Name:			PickUp.java
//Program Description:	This is the linked list of the data with PackageInfo.java.
//						This handles this list and calls the Packageinfo methods.
//						****THIS FILE WILL NOT BE SUBMIITED FOR FINAL
//						This controls the Delivery information						
//IDE used:				Eclipse IDE for Java Developers, Version: Oxygen Release (4.7.0)

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class PickUp implements Iterable<PackageInfo>, Serializable
{
	private List<PackageInfo> list;
	public PickUp()
	{
		list = new LinkedList<PackageInfo>();
	}
	
	
	
// This adds PickUp package information to the end of the PickUp package list
	public void addPickUp(PackageInfo packageinfo) {
		if (packageinfo!= null)
			list.add(packageinfo);
	}
	
//	This adds PickUp package information after the specified package information
	public void addPickUpAfter(PackageInfo Package,PackageInfo newPackage)
	{
		if (Package == null || newPackage == null)
			return;
		int PackageLocation = list.indexOf(Package);
		if (PackageLocation != -1)
			list.add(PackageLocation+1, newPackage);
	}
	
//	This will change the target PickUp package with a new PickUppackage
	public void change(PackageInfo Package,PackageInfo newPackage)
	{
		if (Package == null || newPackage == null)
			return;
		int PackageLocation = list.indexOf(Package);
		if (PackageLocation != -1)
			list.add(PackageLocation, newPackage);
	}	
	
//  This finds and returns the Pickup information relating to the package
	public PackageInfo find(int number) 
	{
		for (PackageInfo packageinfo :list) 
			if (number == packageinfo.GetPNumber())
				return packageinfo;
		return null;	
	}
	
//	This returns if the PickUp number has been used in the list
//
//	This returns true if found and false if number not found 
	public boolean CheckNumber(int number)
	{
		for (PackageInfo packageinfo : list)
			if (number == packageinfo.GetPNumber())
				return true;
		return false;
	}
	
//This produces a list of the PickUp package information 	
	public String toString() {
	String results ="";
	for(PackageInfo packageinfo : list)
		results += packageinfo +"\n";
	return results;
	
}

//	This returns a iterator for PickUp	
public Iterator<PackageInfo> iterator(){
	return list.iterator();
}

//	This saves a serialized version for the PickUp Information to the filename
public void save (String filename, PickUp PU) throws IOException
{
	FileOutputStream fileOut= new FileOutputStream(filename);
	ObjectOutputStream oos = new ObjectOutputStream(fileOut);
	oos.writeObject(PU);
	oos.flush();
	oos.close();
}

//	This loads a serialized PickUp information from the filename
public PickUp load(String filename)throws IOException, ClassNotFoundException{
	FileInputStream fileIn = new FileInputStream(filename);
	ObjectInputStream ois = new ObjectInputStream(fileIn);
	PickUp PU =  (PickUp) ois.readObject();
	ois.close();
	return PU;
}
}
