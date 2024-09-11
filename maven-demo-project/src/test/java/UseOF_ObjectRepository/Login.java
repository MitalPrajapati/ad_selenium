package UseOF_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_utility;
import Generic_Utilities.Java_utility;
import Generic_Utilities.WebDriver_Utility;
import objectRepository.LoginPage;

public class Login {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new ChromeDriver();
		Excel_Utility e = new Excel_Utility();
		File_utility f = new File_utility();
		Java_utility j = new Java_utility();
		WebDriver_Utility w = new WebDriver_Utility();
		
		w.maximizeWindow(driver);
		w.waitPageToLoad(driver);
		
		String url = f.getPropertiesData("url");
		String uName = f.getPropertiesData("username");
		String pass = f.getPropertiesData("pwd");
		
		driver.get(url);
		//using getter method
//		LoginPage login = new LoginPage(driver);
//		login.getUSerTextField().sendKeys(uName);
//		login.getPassWordTextField().sendKeys(uName);
//		login.getLoginButton().click();
		
		//Business logic
		LoginPage login = new LoginPage(driver);
		login.loginToApp(uName, pass);
		
		
	}
}
