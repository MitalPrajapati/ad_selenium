package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_utility;
import Generic_Utilities.Java_utility;
import Generic_Utilities.WebDriver_Utility;

public class CreateCampaignWith_Product_TS4 {

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
		
		//create product
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("[title='Create Product...']")).click();
		Excel_Utility e = new Excel_Utility();
		String pName = e.getExcelData("product", 0, 0) + ranNum; 
		System.out.println("product name : "+ pName);
		driver.findElement(By.name("productname")).sendKeys(pName);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		String cName = e.getExcelData("campaign", 0, 0) + ranNum; 
		System.out.println("campaign name : "+ cName);
		WebElement link = driver.findElement(By.cssSelector("[src=\"themes/softed/images/menuDnArrow.gif\"]"));
		w.moveToElement(driver, link);
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.cssSelector("[alt='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(cName);
		driver.findElement(By.cssSelector("[alt=\"Select\"]")).click();
		
		w.switchToPopup(driver, "Products&action");
		driver.findElement(By.id("search_txt")).sendKeys(pName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+pName+"']")).click();
		
		w.switchToPopup(driver, "Campaigns&action");
		driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
	}
}
