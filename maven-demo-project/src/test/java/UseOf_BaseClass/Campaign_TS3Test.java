package UseOf_BaseClass;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_utility;
import Generic_Utilities.Java_utility;
import Generic_Utilities.WebDriver_Utility;
import objectRepository.CampaignPage;
import objectRepository.CreateCampPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class Campaign_TS3Test extends BaseClass {

	@Test(groups = "regressionTest")
	public void Campaign_TS3Test() throws Throwable
	{
		Excel_Utility e = new Excel_Utility();
		Java_utility j = new Java_utility();
		HomePage h = new HomePage(driver);
		h.ClickOnCampaign();
		CampaignPage c = new CampaignPage(driver);
		c.getCamPlusSign().click();
		int ranNum = j.getRandomNum();
		String campaign = e.getExcelData("campaign", 0, 0) + ranNum;
		CreateCampPage camp = new CreateCampPage(driver);
		camp.CreateCampaign(campaign); 
	}
}
