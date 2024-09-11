package TestNG_Practice;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_organizationTest {

	@Test(dataProvider = "dataProvider_readData")
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
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.name("phone")).sendKeys(phNo);
		driver.findElement(By.name("email1")).sendKeys(email);
		
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
	
	@DataProvider
	public Object[][] dataProvider_readData()
	{
		
		Object[][] objArr = new Object[2][3];
		
		Random ranNum = new Random();
		int ranNums = ranNum.nextInt(1000);
		objArr[0][0]="AAA"+ranNums;
		objArr[0][1]="687654684";
		objArr[0][2]="mailto:abc@gmail.com";
		
		objArr[1][0]="BBB"+ranNums;
		objArr[1][1]="687654684";
		objArr[1][2]="mailto:abc@gmail.com";
		return objArr;
		
	}
}
