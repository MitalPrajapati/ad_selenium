package Organization;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrganization_PropertyFile {
	public static void main(String[] args) throws Throwable {
		//1. fis object
		FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger data/data.properties");
		//2.property object
		Properties p = new Properties();
		p.load(fis);
		//3. call read()
		String url = p.getProperty("url");
		String u_name = p.getProperty("username");
		String pass = p.getProperty("pwd");
		
		String phno = p.getProperty("PhNo");
		String eid = p.getProperty("email");
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		//Login into vtiger application 
		driver.findElement(By.name("user_name")).sendKeys(u_name);
		driver.findElement(By.name("user_password")).sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();
		
		//click on organization link 
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on lookup img
		driver.findElement(By.cssSelector("[alt=\"Create Organization...\"]")).click();
		
		//to avoid duplicates
		Random ran = new Random();
		int ranNum = ran.nextInt();
		String org_name = p.getProperty("OrgName") + ranNum;
		
		//create organization data 
		driver.findElement(By.name("accountname")).sendKeys(org_name);
		driver.findElement(By.name("phone")).sendKeys(phno);
		driver.findElement(By.name("email1")).sendKeys(eid);
		
		//click on save button 
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		
		//to logout from application
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
	}
}
