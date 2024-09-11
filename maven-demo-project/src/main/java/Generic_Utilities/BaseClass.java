package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	
	public static	WebDriver sdriver;
	public WebDriver driver;
//	public WebDriver driver;
	Excel_Utility e = new Excel_Utility();
	File_utility f = new File_utility();
	Java_utility j = new Java_utility();
	WebDriver_Utility w = new WebDriver_Utility();
	
	@BeforeSuite(groups = {"smockTest","regressionTest"})
	public void BSTest()
	{
		System.out.println("Database connection open");
	}
	
	@BeforeTest(groups = {"smockTest","regressionTest"})
	public void BT()
	{
		System.out.println("Parallel execution");
	}
	
//	@Parameters("BROWSER")
	@BeforeClass(groups = {"smockTest","regressionTest"})
	public void BC() throws Throwable
//	public void BC(String BROWSER) throws Throwable
	{
		String BROWSER = f.getPropertiesData("Browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		System.out.println("Browser launched");
		sdriver = driver;
	}
	
	@BeforeMethod(groups = {"smockTest","regressionTest"})
	public void BM() throws Throwable 
	{		
		w.maximizeWindow(driver);
		w.waitPageToLoad(driver);
		
		String url = f.getPropertiesData("url");
		String username = f.getPropertiesData("username");
		String password = f.getPropertiesData("pwd");
		
		driver.get(url);
		LoginPage login = new LoginPage(driver);
		login.loginToApp(username, password);
		System.out.println("Login to application");	
	}
	
	@AfterMethod(groups = {"smockTest","regressionTest"})
	public void AM()
	{
		HomePage h = new HomePage(driver);
		h.logOutFromApp();
		System.out.println("Logout from application");
	}
	
	@AfterClass(groups = {"smockTest","regressionTest"})
	public void AC()
	{
		driver.quit();
		System.out.println("close browser");
	}
	
	@AfterTest(groups = {"smockTest","regressionTest"})
	public void AT()
	{
		System.out.println("Parallel execution done");
	}
	
	@AfterSuite(groups = {"smockTest","regressionTest"})
	public void AS() 
	{
		System.out.println("Close database connection");
	}
}
