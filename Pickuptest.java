//Author:				John Heuchan
//Program Name:			Pickuptest.java
//Program Description:	This test the PackageInfo.java and Pickup.java classes
//						This will be used to handle the fusction test..  
//						****THIS FILE WILL NOT BE SUBMIITED FOR FINAL
//						The PU load is edited out I am workign on the load function but wanted everone to see what I had
//						Open for suggestions  I will be adding comments
//IDE used:				Eclipse IDE for Java Developers, Version: Oxygen Release (4.7.0)

import java.io.IOException;

public class Pickuptest {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		// TODO Auto-generated method stub
		
		
		//To Load files use the following six lines  and two lines at bottom
		
		//This declares a blank Object field to load to
		PickUp PUF = new PickUp();
		Delivery DeliverF = new Delivery();

		//This calls the load methods from the correct fields
		PickUp PU = (PickUp) PUF.load("./src/PickUpInfo");
		Delivery Deliver = (Delivery) DeliverF.load("./src/DeliveryInfo");
		PackageInfo tester = PU.find(120);
		tester.SetDate("3/8/18");
		
		System.out.println(PU);
		PackageInfo tester2 = PU.find(123);
		PU.addPickUpAfter(tester2, new PackageInfo(122,"Jim","Jones","888 Easy Street","NoWork","DC","20000"));
		System.out.println(PU);
		System.out.println("Delivery Information");
		System.out.println(Deliver);
		
		//  This saves the object data
		PU.save("./src/PickupInfo",PU);
		Deliver.save("./src/DeliveryInfo");
	}

}
