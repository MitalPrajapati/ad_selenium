package TestNG_Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Ex1Test {

	@Test(dataProvider = "dataProvider_BookTickets")
	public void bookTickets(String src,String dest)
	{
		System.out.println("Book Tickets from "+ src +" to "+ dest);
	}
	
	@DataProvider
	public Object[][] dataProvider_BookTickets()
	{
		Object[][] objArr = new Object[3][2];
		
		objArr[0][0] = "Banglore";
		objArr[0][1] = "Goa";
		
		objArr[1][0] = "Banglore";
		objArr[1][1] = "Chennai";
		
		objArr[2][0] = "Banglore";
		objArr[2][1] = "Pune";
		
		return objArr;
		
	}
	
	
}
