package Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {

	@Test
	public void m1()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		
		SoftAssert soft = new SoftAssert();
	//	soft.assertEquals(false, true);
		soft.assertEquals("A", "A", "AssertPass");
		
		System.out.println("Step3");
		System.out.println("Step4");
		soft.assertAll();
	}
}
