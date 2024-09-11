package UseOf_BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_utility;
import Generic_Utilities.Java_utility;
import Generic_Utilities.WebDriver_Utility;
import objectRepository.CampaignPage;
import objectRepository.CreateCampPage;
import objectRepository.CreateProductPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.ProductPage;
import objectRepository.SwitchToProduct;
import objectRepository.delete_Product;

public class Product_CreateDelete_TS4Test extends BaseClass {

	@Test
	public void Product_CreateDelete_TS4Test() throws Throwable
	{
		Excel_Utility e = new Excel_Utility();
		Java_utility j = new Java_utility();
		WebDriver_Utility w = new WebDriver_Utility();
		
		HomePage h = new HomePage(driver);
		h.getProductLink().click();
		ProductPage p = new ProductPage(driver);
		p.getProductPlusSign().click();
		int ranNum = j.getRandomNum();
		String product = e.getExcelData("product", 0, 0) + ranNum;
		CreateProductPage prod = new CreateProductPage(driver);
		prod.CreateProduct(product);
		h.getProductLink().click();
		delete_Product dp = new delete_Product(driver);
		dp.ClickOnProduct(driver, product);
		dp.getDeleteButton().click();
		w.alertAccept(driver);
		dp.validatePrdDeleted(driver, product);
	}
}
