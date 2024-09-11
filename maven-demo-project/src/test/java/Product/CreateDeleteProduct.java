package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateDeleteProduct {
	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/Vtiger data/CommonData.properties");
		Properties p = new Properties();
		p.load(fis1);
		String url = p.getProperty("url");
		String us_name = p.getProperty("username");
		String pass = p.getProperty("pwd");
		
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(us_name);
		driver.findElement(By.name("user_password")).sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();
		
		FileInputStream fis2 = new FileInputStream("C:\\Users\\Mitu\\Desktop\\Selenium\\Ad. selenium Qspi\\vtiger_data.xlsx");
		Workbook w = WorkbookFactory.create(fis2);
		String product = w.getSheet("Product").getRow(0).getCell(0).getStringCellValue() + ranNum;
		System.out.println(product);
		
		driver.findElement(By.name("productname")).sendKeys(product);
		driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']//tbody//td//a[text()='"+product+"']/../..//td//input[@type=\"checkbox\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();
		
		driver.switchTo().alert().accept();
		driver.close();
		
	}
}
