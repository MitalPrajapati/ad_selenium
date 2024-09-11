package TestNG_Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Ex2Test {

	@Test(dataProvider = "dataProvider_BookTickets")
	public void bookTickets(String src,String dest,int noOfPerson)
	{
		System.out.println("Book Tickets from "+ src +" to "+ dest + " , "+ noOfPerson);
	}
	
	@DataProvider
	public Object[][] dataProvider_BookTickets()
	{
		Object[][] objArr = new Object[3][3];
		
		objArr[0][0] = "Banglore";
		objArr[0][1] = "Goa";
		objArr[0][2] = 2;
		
		objArr[1][0] = "Banglore";
		objArr[1][1] = "Chennai";
		objArr[1][2] = 4;
		
		objArr[2][0] = "Banglore";
		objArr[2][1] = "Pune";
		objArr[2][2] = 6;
		
		return objArr;
		
	}
	
	
}
