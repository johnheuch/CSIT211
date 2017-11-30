import javax.swing.*;
import java.io.IOException;
import java.util.*;

public class PackageGUI
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		String FName = "";
		String LName = "";
		//String contactNo="";
		String returnAddress = "";
		String Address = "";
		String priority = "";
		
		
		//=================== CODE FOR PICK UP PACKAGES================================================
		PickUp PU = new PickUp();
		PU.addPickUp(new PackageInfo(123,"Jim","Baker","123 AnyStreet","NewTown","DC","20000"));
		PU.addPickUp(new PackageInfo(120,"Tim","Jones","1203 That Street","NewTown","DC","20000"));
		PU.addPickUp(new PackageInfo(121,"Tony","Smith","1273 Lost Way","NewTown","DC","20000"));		
		PackageInfo tester = PU.find(120);
		tester.SetDate("3/1/18");
	
		PackageInfo tester2 = PU.find(123);
		PU.addPickUpAfter(tester2, new PackageInfo(122,"Jim","Jones","888 Easy Street","NoWork","DC","20000"));
		
		//=============================================================================================
		//PackageInfo = packInfo = new PackageInfo();
		// Need package info from John's code
		
		int choice = 0;
		String option = "";
		String output = "";
		
		Queue normalQueue = new Queue();
		Queue priorityQueue = new Queue();
		Package temp;
		LinkedList AllQueue = new LinkedList();
		
		while (choice == 0)
		{
			option = JOptionPane.showInputDialog(null, "Choose Option\n\tShip\n\tPick Up\n\tCancel Shipment\n\tView\n\tExit");
			
			// Ship
			if (option.equalsIgnoreCase("Ship"))
			{
				FName = JOptionPane.showInputDialog(null, "First Name");
				LName = JOptionPane.showInputDialog(null, "Last Name");
				//contactNo=JOptionPane.showInputDialog(null, "Contact Number");
				returnAddress = JOptionPane.showInputDialog(null, "Return Address");
				Address = JOptionPane.showInputDialog(null, "Address");
				priority = JOptionPane.showInputDialog(null,"Shipment Method [normal/priority]");
				
				temp = new Package(FName, LName, returnAddress, Address, priority);
				
				if (temp.priorityCheck())
				{
					priorityQueue.enqueue(temp); // Queue for Priority Shipping
				}
				else
				{
					normalQueue.enqueue(temp);  // Queue for Normal Shipping
				}
			}
			
			//======================== STILL NEED CODE FOR PICK UP=============================================
			else if (option.equalsIgnoreCase("Pick Up"))
			{
				
			}
			
			
			//=================================================================================================
			
			// Cancel Shipment
			else if (option.equalsIgnoreCase("Cancel Shipment"))
			{
				// View before cancel
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
					for(int i = 0; i<normalQueue.size(); i++)
					{
						temp = (Package) normalQueue.front();
						output+=temp.toString();
					}
				}
				JOptionPane.showMessageDialog(null, "Select which Package? \n" +output); // change to select PNumber? 
				output ="";
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
				JOptionPane.showMessageDialog(null, "Viewing\n"+output);
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
	protected String FName;
	protected String LName;
	protected String returnAddress;
	protected String Address;
	protected String priority;
	
	Package (String a, String b, String c, String d, String e)
	{
		FName = a;
		LName = b;
		returnAddress = c;
		Address = d;
		priority = e;
	}
	/*
	PackageInfo.GetFName();
	PackageInfo.GetLName();
	PackageInfo.GetReturnAddress();
	PackageInfo.GetAddress();
	PackageInfo.GetPriority();
	*/
	
	public String getFName(){return FName;}
	public String getLName(){return LName;}
	public String getReturnAddress(){return returnAddress;}
	public String getAddress(){return Address;}
	public String getPriority(){return priority;}
	
	public boolean priorityCheck()
	{
		if(getPriority().equalsIgnoreCase("priority"))
			return true;
		else
			return false;
	}
	
	public String toString()
	{
		return "First Name: " + getFName() + ", Last Name: " + getLName() + ", Return Address: " + getReturnAddress() + ", Destination: " +getAddress() + ", Shipping Method: " + getPriority() + "\n";
	}
}




















