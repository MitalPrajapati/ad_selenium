package UseOF_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_utility;
import Generic_Utilities.Java_utility;
import Generic_Utilities.WebDriver_Utility;
import objectRepository.CreateOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationPage;

public class Create_Organization {

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
		h.getOrgLink().click();
		
		OrganizationPage o = new OrganizationPage(driver);
		o.ClickOrgPlus();
		
		int ranNum = j.getRandomNum();
		String orgName = e.getExcelData("Organization", 0, 0) + ranNum;
		String phNo = e.getExcelDataUsingFormatter("Organization", 1, 0);
		String email = e.getExcelData("Organization", 2, 0);
		
		CreateOrganizationPage create = new CreateOrganizationPage(driver);
		create.CreateOrg(orgName, phNo, email);
		
		Thread.sleep(3000);
//		h.signOutApp(driver);
		h.logOutFromApp();
		
	}
}
