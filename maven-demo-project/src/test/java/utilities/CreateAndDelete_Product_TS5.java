package utilities;

import java.util.Random;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_utility;
import Generic_Utilities.Java_utility;
import Generic_Utilities.WebDriver_Utility;

public class CreateAndDelete_Product_TS5 {

	public static void main(String[] args) throws Throwable {
		
		File_utility f = new File_utility();
		String url = f.getPropertiesData("url");
		String uName = f.getPropertiesData("username");
		String pass = f.getPropertiesData("pwd");
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		WebDriver_Utility w = new WebDriver_Utility();
		w.maximizeWindow(driver);
		w.waitPageToLoad(driver);
		
		driver.findElement(By.name("user_name")).sendKeys(uName);
		driver.findElement(By.name("user_password")).sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();
		
		Java_utility j = new Java_utility();
		int ranNum = j.getRandomNum();

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("[title='Create Product...']")).click();
		
		Excel_Utility e = new Excel_Utility();
		String pName = e.getExcelData("product", 0, 0) + ranNum; 
		System.out.println(pName);
		driver.findElement(By.name("productname")).sendKeys(pName);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']//tbody//td//a[text()='"+pName+"']/../..//td//input[@type=\"checkbox\"]")).click();
		driver.findElement(By.cssSelector("[class=\"crmbutton small delete\"]")).click();
		w.alertAccept(driver);
		
		//verification 
		
		
		driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
	}
}
