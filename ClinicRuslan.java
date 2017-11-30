
//Class Delivery
// Name: Tyler Haigis
// pseudo code for final project


import javax.swing.*;
import java.util.*;

 class ClinicRuslan
 {
	public static void main(String [] args)
	{
		String name="";
		//String weight="";		 package weight -- determine price?
		String contactNo="";	// Use string to get zero at the front e.g. 0134567890
		String returnAddress = "";
		String destination="";
		//String date="";		
		double time=0.0;		// package sent time
		String priority="";	    //normal or priority
		//
		int choice = 0;
		String option = "";
		String output = "";
		
		//Setting Queue
		Queue normalQueue = new Queue();
		Queue priorityQueue = new Queue();;
		Package temp;
		LinkedList AllQueue = new LinkedList();

		while (choice==0)
		{
			option=JOptionPane.showInputDialog(null,"Choose Option\n\tShip\n\tCancel Shipment\n\tView\n\tExit");
			// Ship
			if (option.equalsIgnoreCase("Ship"))
			{
				name=JOptionPane.showInputDialog(null,"Name");
				contactNo=JOptionPane.showInputDialog(null,"Contact No");
				returnAddress =JOptionPane.showInputDialog(null, "Return Address");
				destination=JOptionPane.showInputDialog(null,"Destination");
				time=Double.parseDouble(JOptionPane.showInputDialog(null,"Time[24hours system]")); // needs work
				priority=JOptionPane.showInputDialog(null,"Priority[normal/priority]");
				temp = new Package(name, contactNo, returnAddress ,destination, time,priority);
				if (temp.priorityCheck())
				{
					priorityQueue.enqueue(temp);  //Queue for Priority Condition
				}
				else
				{
					normalQueue.enqueue(temp);	  //Queue for Normal Packages
				}
			}
			
			
			
			// Cancel Shipment
			else if (option.equalsIgnoreCase("Cancel Shipment"))
			{
				//View before cancel 
				if(!priorityQueue.isEmpty())
                {
					for(int i=0; i<priorityQueue.size(); i++)
					{
					temp = (Package) priorityQueue.front();
					output+=temp.toString();
					}
				}
				if(!normalQueue.isEmpty())
                {
					for(int i=0; i<normalQueue.size(); i++)
					{
					temp = (Package) normalQueue.front();
					output+=temp.toString();
					}
				}
				JOptionPane.showMessageDialog(null,"Select which package? \n"+output);
				output="";
				
			}
			
			
			// View
			else if (option.equalsIgnoreCase("View"))
			{
				if(!priorityQueue.isEmpty())
                {
					for(int i=0; i<priorityQueue.size(); i++)
					{
					temp = (Package) priorityQueue.front();
					output+=temp.toString();
					}
				}
				if(!normalQueue.isEmpty())
                {
					for(int i=0; i<normalQueue.size(); i++)
					{
					temp = (Package) normalQueue.front();
					output+=temp.toString();
					}
				}
				JOptionPane.showMessageDialog(null,"VIEWING\n"+output);
				output="";
				
			}
			
			
			// Exit
			else if (option.equalsIgnoreCase("Exit"))
				break;
			// Error Input Notification
			else
				JOptionPane.showMessageDialog(new JFrame(), "You have entered invalid input. Please enter \"Ship\", \"Cancel Shipment\", \"View\", or \"Exit\" ", "Wrong Input",JOptionPane.ERROR_MESSAGE);
			/*==Choose to continue or not=============================================================*/
			choice=JOptionPane.showConfirmDialog(null,"Do you want to continue?","Continue?", JOptionPane.YES_NO_OPTION);//return 0 for yes option.
		}
		System.exit(0);
	}
}

// Class queue
class Queue 
{

	protected LinkedList list;

	public Queue() 
	{
		list = new LinkedList();
	} //default constructor

	public boolean isEmpty() 
	{
		return list.isEmpty();
	}//method isEmpty

	public int size() 
	{
		return list.size();
	}// method size

	public void enqueue(Object element) 
	{
		list.addLast(element);
	} //method enqueue

	public Object dequeue() 
	{
		return list.removeFirst();
	} //method dequeue

	public Object front() 
	{
		return list.getFirst();
	} //method front

	public Object rear()
	{
		return list.getLast();
	}
} // Queue class

//class Package
class Package
{
	protected String name;		
	protected String contactNo;
	protected String returnAddress;
	protected String destination;
	//protected String date;	//ship date?	
	protected double time;		//ship time
	protected String priority;	//normal or priority


	Package(String a, String b, String c, String d, double e, String f)
	{
		name = a;
		contactNo = b;
		returnAddress = c;
		destination = d;
		//date = g; ?? 
		time = e;
		priority = f;
		
	}

	public String getName(){return name;}
	public String getContact(){return contactNo;}
	public String getReturnAddress(){return returnAddress;}
	public String getDestination(){return destination;}
	//public String getDate(){return date;} ??
	public double getTime(){return time;}
	public String getPriority(){return priority;}

	public boolean priorityCheck()
	{
		if (getPriority().equalsIgnoreCase("priority"))
			return true;
		else
			return false;
	}

	public String toString(){
		return "Name: " + getName() + ", Contact no : " +  getContact() + ", Return Address " +getReturnAddress() 
		+ ", Destination : " +  getDestination() + ", Time : " + getTime() + ", Condition : " +  getPriority() + "\n";
	}
}