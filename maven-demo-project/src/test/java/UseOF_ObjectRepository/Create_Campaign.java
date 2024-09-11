package UseOF_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

public class Create_Campaign {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver;
		Excel_Utility e = new Excel_Utility();
		File_utility f = new File_utility();
		Java_utility j = new Java_utility();
		WebDriver_Utility w = new WebDriver_Utility();
		
		String BROWSER = f.getPropertiesData("Browser");
		if(BROWSER.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		w.maximizeWindow(driver);
		w.waitPageToLoad(driver);
		
		String url = f.getPropertiesData("url");
		String username = f.getPropertiesData("username");
		String password = f.getPropertiesData("pwd");
		
		driver.get(url);
		LoginPage login = new LoginPage(driver);
		login.loginToApp(username, password);
		
		HomePage h = new HomePage(driver);
		h.ClickOnCampaign();
		
		CampaignPage c = new CampaignPage(driver);
		c.getCamPlusSign().click();
		
		int ranNum = j.getRandomNum();
		String campaign = e.getExcelData("campaign", 0, 0) + ranNum;
		
		CreateCampPage camp = new CreateCampPage(driver);
		camp.CreateCampaign(campaign);
		
		h.logOutFromApp();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
