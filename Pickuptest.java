//Author:				John Heuchan
//Program Name:			Pickuptest.java
//Program Description:	This test the PackageInfo.java and Pickup.java classes
//						This will be used to handle the fusction test..  
//						****THIS FILE WILL NOT BE SUBMIITED FOR FINAL
//						The PU load is edited out I am workign on the load function but wanted everone to see what I had
//						Open for suggecstions  I will be adding comments
//IDE used:				Eclipse IDE for Java Developers, Version: Oxygen Release (4.7.0)

import java.io.IOException;

public class Pickuptest {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		// TODO Auto-generated method stub
		PickUp PU = new PickUp();

		PU.addPickUp(new PackageInfo(123,"Jim","Baker","123 AnyStreet","NewTown","DC","20000"));
		PU.addPickUp(new PackageInfo(120,"Tim","Jones","1203 That Street","NewTown","DC","20000"));
		PU.addPickUp(new PackageInfo(121,"Tony","Smith","1273 Lost Way","NewTown","DC","20000"));		
//		PU.load("c:/Users/johnh/Desktop/FinalsTest");
		PackageInfo tester = PU.find(120);
		tester.SetDate("3/1/18");
		
		System.out.println(PU);
		PackageInfo tester2 = PU.find(123);
		PU.addPickUpAfter(tester2, new PackageInfo(122,"Jim","Jones","888 Easy Street","NoWork","DC","20000"));
		System.out.println(PU);
		
		PU.save("c:/Users/johnh/Desktop/FinalsTest");
	}

}
