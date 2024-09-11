package Organization;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrganization {
	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		
		//Login into vtiger application 
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//click on organization link 
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on lookup img
		driver.findElement(By.cssSelector("[alt=\"Create Organization...\"]")).click();
		
		//to avoid duplicates
		Random ran = new Random();
		int ranNum = ran.nextInt();
		
		//create organization data 
		driver.findElement(By.name("accountname")).sendKeys("Qspiders" + ranNum);
		driver.findElement(By.name("phone")).sendKeys("9876543211");
		driver.findElement(By.name("email1")).sendKeys("abc@gmail.com");
		
		//click on save button 
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		
		//to logout from application
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
	}
}
