package UseOF_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

public class Create_CampaignWithProduct {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new ChromeDriver();
		Excel_Utility e = new Excel_Utility();
		File_utility f = new File_utility();
		Java_utility j = new Java_utility();
		WebDriver_Utility w = new WebDriver_Utility();
		
		w.maximizeWindow(driver);
		w.waitPageToLoad(driver);
		
		String url = f.getPropertiesData("url");
		String username = f.getPropertiesData("username");
		String password = f.getPropertiesData("pwd");
		
		driver.get(url);
		LoginPage login = new LoginPage(driver);
		login.loginToApp(username, password);
		
		HomePage h = new HomePage(driver);
		h.getProductLink().click();
		
		ProductPage p = new ProductPage(driver);
		p.getProductPlusSign().click();
		
		int ranNum = j.getRandomNum();
		String product = e.getExcelData("product", 0, 0) + ranNum;
		CreateProductPage prod = new CreateProductPage(driver);
		prod.CreateProduct(product);
		
		h.ClickOnCampaign();
		CampaignPage cp = new CampaignPage(driver);
		cp.getCamPlusSign().click();
		
		String campaign = e.getExcelData("campaign", 0, 0) + ranNum;
		CreateCampPage cc = new CreateCampPage(driver);
		cc.getCampName().sendKeys(campaign);
		cc.getAddProductIcone().click();
		w.switchToPopup(driver, "Products&action");
		
		SwitchToProduct sp = new SwitchToProduct(driver);
		sp.getSearchTextField().sendKeys(product);
		sp.getSearchButton().click();
		sp.ClickOnProduct(driver, product);
		
		w.switchToPopup(driver, "Campaigns&action");
		cc.getSaveCamp().click();
		h.logOutFromApp();
		
	}	
}
