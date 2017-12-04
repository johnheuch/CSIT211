//Author:				John Heuchan, Tyler Haigis, Rafay Khurram
//Program Name:			PackageGUI.java
//Program Description:	This GUI program include the main method for final project.
//						
//IDE used:				Eclipse IDE for Java Developers, Version: Oxygen Release (4.7.0)

import javax.swing.*;
import java.io.IOException;
import java.util.*;

public class PackageGUI
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		int PNumber =  0; 
		String FName = "";
		String LName = "";
		String Address = "";
		String city = "";
		String state = "";
		String zip = "";
		String date = "";
		String shipType = "";
		
		int choice = 0;
		String option = "";
		String output = "";
		Random rand = new Random();
		
		String pickUp = "";  // used to select which package to pick up
		String cancel = ""; // used to select which delivery to cancel
		
		Queue shippingQueue = new Queue();
		Queue pickupQueue = new Queue();
		Package temp;
		LinkedList AllQueue = new LinkedList();
		
		System.out.println(" Package Shipping Program. \n");
		System.out.println(" Transactions:");
		System.out.println(" -----------------");

		while (choice == 0)
		{
			option = JOptionPane.showInputDialog(null, "Choose Option\n\tShip\n\tPick Up\n\tCancel Shipment\n\tView\n\tExit");
			
			// Ship
			if (option.equalsIgnoreCase("Ship"))
			{
				PickUp pick = new PickUp();
				Delivery del = new Delivery(); // used to create and store deliveries
				PackageInfo packIn = new PackageInfo(PNumber, FName, LName, Address, city, state, zip, date);
				
				PNumber = rand.nextInt(300) + 1; // Random Package number for each package
				FName = JOptionPane.showInputDialog(null, "First Name");
				LName = JOptionPane.showInputDialog(null, "Last Name");
				Address = JOptionPane.showInputDialog(null, "Address");
				city = JOptionPane.showInputDialog(null, "City");
				state = JOptionPane.showInputDialog(null, "State");
				zip = JOptionPane.showInputDialog(null, "Zip");
				date = JOptionPane.showInputDialog(null, "Date (DD/MM/YY)");
				shipType = JOptionPane.showInputDialog(null,"Shipment Method [Pick Up/Delivery]");
				
				temp = new Package(PNumber, FName, LName, Address, city, state, zip, date, shipType);
				
				if (temp.packageCheck())
				{
					pickupQueue.enqueue(temp); // Queue for pickups
					//pick.addPickUp(packIn);
					pick.addPickUp(new PackageInfo(PNumber,FName, LName, Address, city, state, zip, date, shipType));
				}
				else
				{
					shippingQueue.enqueue(temp); // Queue for deliveries
					//del.addDelivery(packIn);
					//del.addDeliveryAfter(packIn, packIn);
					del.addPickUp(new PackageInfo(PNumber,FName, LName, Address, city, state, zip, date, shipType));
				}	
			}
			
			// Pick up
			else if (option.equalsIgnoreCase("Pick Up"))
			{
				PickUp pu = new PickUp();  // used to create and store pick ups
				
				if(!pickupQueue.isEmpty()) // Displays packages listed as pick ups
				{
					for(int i=0; i<pickupQueue.size(); i++)
					{
						temp = (Package) pickupQueue.front();
						output+=temp.toString();
					}
				}

				
				JOptionPane.showMessageDialog(null, "Pick Ups:\n"+output);
				output = "";
				
				pickUp = JOptionPane.showInputDialog(null, "Enter Package Number to Pickup");
				pu.find(PNumber);
				pu.CheckNumber(PNumber);
				pu.iterator();
				pu.save(pickUp);
				//pu.removePickUp(pickUp);
				
				if (pu.CheckNumber(PNumber) == true)
				{
					pickupQueue.dequeue();
					//pu.removePickUp(PNumber);
					System.out.println(" Package Number: " + PNumber + ", has been picked up. ");
				}
				
			}
			  
			
			// Cancel Shipment
			else if (option.equalsIgnoreCase("Cancel Shipment")) 
			{
				// View shipments before cancel
				Delivery canc = new Delivery();
			
				if(!shippingQueue.isEmpty()) // displays packages listed at delivery
				{
					for(int i = 0; i<shippingQueue.size(); i++)
					{
						temp = (Package) shippingQueue.front();
						output+=temp.toString();
					}
				}
				
				JOptionPane.showMessageDialog(null, "Select which shipment to cancel: \n" +output);
				output ="";
				
				cancel = JOptionPane.showInputDialog(null, "Enter Package Number to Cancel");
				canc.find(PNumber);
				canc.CheckNumber(PNumber);
				canc.iterator();
				canc.save(cancel);
				
				if(canc.CheckNumber(PNumber) == true)
				{
					shippingQueue.dequeue();
					System.out.println(" Package Number : " + PNumber + ", has been canceled.");
				}
			}

			
			
			// View
			else if (option.equalsIgnoreCase("View"))
			{
				if(!pickupQueue.isEmpty())  // displays packages listed as pick up
				{
					for(int i=0; i<pickupQueue.size(); i++)
					{
						temp = (Package) pickupQueue.front();
						output+=temp.toString();
					}
				}
				if(!shippingQueue.isEmpty()) // displays packages listed as delivery
				{
					for(int i=0; i<shippingQueue.size(); i++)
					{
						temp = (Package) shippingQueue.front();
						output+=temp.toString();
					}
				}
				JOptionPane.showMessageDialog(null, "Viewing:\n"+output);
				output = "";
			}
			
			
			// Exit
			else if(option.equalsIgnoreCase("Exit"))
				break;
			
			//Error input notification
			else
				JOptionPane.showMessageDialog(new JFrame(), "You have entered an invalid input. Please enter \"Ship\", \"Pick Up\", \"Cancel Shipment\", \"View\", or \"Exit\" ", "Wrong Input",JOptionPane.ERROR_MESSAGE);
			
			// Continue or not
			choice = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Continue?", JOptionPane.YES_NO_OPTION); // return 0 for yes option
		}
		System.exit(0);
	}
}

class Queue
{
	protected LinkedList list;
	
	// default constructor
	public Queue()
	{
		list = new LinkedList();
	}
	
	// method isEmpty
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	
	public int size()
	{
		return list.size();
	}
	
	public void enqueue(Object element)
	{
		list.addLast(element);
	}
	
	public Object dequeue()
	{
		return list.removeFirst();
	}
	
	public Object front()
	{
		return list.getFirst();
	}
	
	public Object rear()
	{
		return list.getLast();
	}
}

class Package
{
	protected int PNumber;
	protected String city;
	protected String state;
	protected String zip;
	protected String date;
	protected String FName;
	protected String LName;
	protected String Address;
	protected String shipType;
	
	Package (int a ,String b, String c, String d, String e, String f, String g, String h, String i) 
	{
		PNumber = a;
		FName = b;
		LName = c;
		Address = d;
		city = e;
		state = f;
		zip = g; 
		date = h;
		shipType = i;
	}

	public int getPNumber(){return PNumber;}
	public String getFName(){return FName;}
	public String getLName(){return LName;}
	public String getCity(){return city;}
	public String getState(){return state;}
	public String getZip(){return zip;}
	public String getDate(){return date;}
	public String getAddress(){return Address;}
	public String getShiptype(){return shipType;}
	
	public boolean packageCheck()
	{
		if(getShiptype().equalsIgnoreCase("pick up"))
			return true;
		else
			return false;
	}

	public String toString()
	{
		return "Package Number: " + getPNumber() +", First Name: " + getFName() + ", Last Name: " 
	+ getLName() + ", Destination: " +getAddress() + ", City: " + getCity() 
	+ ", State: " + getState() + ", Zip: " + getZip() + ", Date: " + getDate() + ", Shipping Method: " + getShiptype() + "\n";
	}
}
