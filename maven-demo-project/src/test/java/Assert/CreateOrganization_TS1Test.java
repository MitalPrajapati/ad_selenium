package Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_utility;
import Generic_Utilities.Java_utility;
import Generic_Utilities.WebDriver_Utility;
import objectRepository.CreateOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationPage;
import objectRepository.ValidationPage;

public class CreateOrganization_TS1Test extends BaseClass{

	@Test(groups = "regressionTest")
	public void Organization_TS1Test() throws Throwable
	{
		Excel_Utility e = new Excel_Utility();
		Java_utility j = new Java_utility();
		
		HomePage h = new HomePage(driver);
		h.getOrgLink().click();
		OrganizationPage o = new OrganizationPage(driver);
		o.ClickOrgPlus();
		int ranNum = j.getRandomNum();
		String orgName = e.getExcelData("Organization", 0, 0) + ranNum;
		String phNo = e.getExcelDataUsingFormatter("Organization", 1, 0);
		String email = e.getExcelData("Organization", 2, 0);
		CreateOrganizationPage create = new CreateOrganizationPage(driver);
		create.CreateOrg(orgName, phNo, email);
		
		ValidationPage page = new ValidationPage(driver);
		String actOrgName = page.ValidateOrg(driver);
		Assert.assertEquals(actOrgName, orgName);
		
		Thread.sleep(3000);
	}
}
