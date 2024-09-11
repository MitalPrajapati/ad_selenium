package TestNG_Practice;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_utility;

public class DataProviderExcel_organizationTest {

	@Test(dataProvider = "readData")
	public void OrganizationModuleTest(String orgName, String phNo, String email) throws Throwable {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Organization...\"]")).click();
		
		Random ran = new Random();
		int ranNum = ran.nextInt();
		
		driver.findElement(By.name("accountname")).sendKeys(orgName + ranNum);
		driver.findElement(By.name("phone")).sendKeys(phNo);
		driver.findElement(By.name("email1")).sendKeys(email);
		
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		
		Thread.sleep(3000);
		Actions a = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		a.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
	
	@DataProvider
	public Object[][] readData() throws Throwable
	{
		Excel_Utility e = new Excel_Utility();
		Object[][] values = e.getDataProviderData("org");
		return values;
		
	}
	
}
