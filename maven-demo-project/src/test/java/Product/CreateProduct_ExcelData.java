package Product;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_utility;
import Generic_Utilities.Java_utility;
import Generic_Utilities.WebDriver_Utility;

public class CreateProduct_ExcelData {
	public static void main(String[] args) throws Throwable {
		
//				//1. fis object
//				FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger data/CommonData.properties");
//				//2.property object
//				Properties p = new Properties();
//				p.load(fis);
//				//3. call read()
//				String url = p.getProperty("url");
//				String u_name = p.getProperty("username");
//				String pass = p.getProperty("pwd");
				
		File_utility f = new File_utility();
		String url = f.getPropertiesData("url");
		String u_name = f.getPropertiesData("username");
		String pass = f.getPropertiesData("pwd");
				
				WebDriver driver = new ChromeDriver();
				driver.get(url);
				
				WebDriver_Utility w = new WebDriver_Utility();
				w.maximizeWindow(driver);
				w.waitPageToLoad(driver);
//				driver.manage().window().maximize();
				
				//Login into vtiger application 
				driver.findElement(By.name("user_name")).sendKeys(u_name);
				driver.findElement(By.name("user_password")).sendKeys(pass);
				driver.findElement(By.id("submitButton")).click();
		
		//click on organization link 
		driver.findElement(By.linkText("Products")).click();
				
		//click on lookup img
		driver.findElement(By.cssSelector("[title='Create Product...']")).click();
		
		//to avoid duplicates
//		Random ran = new Random();
//		int ranNum = ran.nextInt();
			
//		int ranNum = Java_utility.getRandomNum();-> static call
		Java_utility j = new Java_utility();
		int ranNum = j.getRandomNum();
		
		//to read data from excel file 
//		FileInputStream fis2 = new FileInputStream("C:\\Users\\Mitu\\Desktop\\Selenium\\Ad. selenium Qspi\\vtiger_data.xlsx");
//		Workbook w = WorkbookFactory.create(fis2);
//		Sheet sheet = w.getSheet("Product");
//		Row row = sheet.getRow(0);
//		Cell cel = row.getCell(0);
//		String productName = cel.getStringCellValue() + ranNum;
		
		Excel_Utility e = new Excel_Utility();
		String productName = e.getExcelData("Product", 0, 0) + ranNum;
		System.out.println(productName);
		
		//create product data
		driver.findElement(By.name("productname")).sendKeys(productName);
		
		//click on save button
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//To logout from application
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
	}
}
