package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_utility;
import Generic_Utilities.Java_utility;
import Generic_Utilities.WebDriver_Utility;
import io.opentelemetry.sdk.metrics.data.Data;

public class Create_Organization_TS1 {
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
		
        driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Organization...\"]")).click();
		
		Excel_Utility e = new Excel_Utility();
		String orgName = e.getExcelData("Organization", 0, 0) + ranNum;
		String phNo = e.getExcelDataUsingFormatter("Organization", 1, 0);
		String email = e.getExcelData("Organization", 2, 0);
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.name("phone")).sendKeys(phNo);
		driver.findElement(By.name("email1")).sendKeys(email);
		
		driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
		
     	Thread.sleep(2000);
		driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
}
}
