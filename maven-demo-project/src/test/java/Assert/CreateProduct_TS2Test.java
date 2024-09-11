package Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_utility;
import Generic_Utilities.Java_utility;
import Generic_Utilities.WebDriver_Utility;
import objectRepository.CreateProductPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.ProductPage;
import objectRepository.ValidationPage;

public class CreateProduct_TS2Test extends BaseClass {

	@Test(groups = {"smockTest","regressionTest"})
	public void Product_TS2Test() throws Throwable
	{
		Excel_Utility e = new Excel_Utility();
		Java_utility j = new Java_utility();		
		HomePage h = new HomePage(driver);
		h.getProductLink().click();
		ProductPage p = new ProductPage(driver);
		p.getProductPlusSign().click();
		int ranNum = j.getRandomNum();
		String product = e.getExcelData("product", 0, 0) + ranNum;
		CreateProductPage prod = new CreateProductPage(driver);
		prod.CreateProduct(product);	
		
		ValidationPage page = new ValidationPage(driver);
		String actData = page.ValidateProd(driver);
		
		//Hard Assert
//		Assert.assertEquals(actData, product);//passed result
		Assert.assertEquals(actData, product+ranNum);// failed result
		
		//Soft Assert
		SoftAssert soft = new SoftAssert();
//		soft.assertEquals(actData, product);//pass result
//		soft.assertEquals(actData, product+ranNum);//failed result
		soft.assertAll();
		
	}
}
