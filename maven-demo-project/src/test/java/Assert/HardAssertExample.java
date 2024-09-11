package Assert;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertExample {

	@Test
	public void m1() 
	{
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals(false, true);
		System.out.println("Step3");
		System.out.println("Step4");
	}
	
	@Test
	public void m2()
	{
		String expData = "Qsp";
		String actData = "Qsp";
		Assert.assertEquals(actData, expData);
	}
}
