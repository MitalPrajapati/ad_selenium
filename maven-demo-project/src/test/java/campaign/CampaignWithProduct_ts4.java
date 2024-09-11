package campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CampaignWithProduct_ts4 {
	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/Vtiger data/CommonData.properties");
		Properties p = new Properties();
		p.load(fis1);
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pass = p.getProperty("pwd");
		
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();
		
		//create product
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();
		
		FileInputStream fis2 = new FileInputStream("C:\\\\Users\\\\Mitu\\\\Desktop\\\\Selenium\\\\Ad. selenium Qspi\\\\vtiger_data.xlsx");
		Workbook w = WorkbookFactory.create(fis2);
		String product = w.getSheet("Product").getRow(0).getCell(0).getStringCellValue() + ranNum ;
		System.out.println(product);
		
		driver.findElement(By.name("productname")).sendKeys(product);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//create campaign
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		
		driver.findElement(By.cssSelector("[alt=\"Create Campaign...\"]")).click();
		
		FileInputStream fis3 = new FileInputStream("C:\\Users\\Mitu\\Desktop\\Selenium\\Ad. selenium Qspi\\vtiger_data.xlsx");
		Workbook w1 = WorkbookFactory.create(fis3);
		String camp = w1.getSheet("Campaign").getRow(0).getCell(0).getStringCellValue() + ranNum;
		
		driver.findElement(By.name("campaignname")).sendKeys(camp);
		driver.findElement(By.cssSelector("[alt=\"Select\"]")).click();
//		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		Set<String> allWin = driver.getWindowHandles();
		Iterator<String> it = allWin.iterator(); 
		
		while (it.hasNext()) {
			String win = it.next();
			driver.switchTo().window(win);
			String currentTitle = driver.getTitle();
			
			if(currentTitle.contains("Products&action"))
			{
				break;
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys(product);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+product+"']")).click();
		
		Set<String> allWin1 = driver.getWindowHandles();
		Iterator<String> it1 = allWin1.iterator();
		while (it1.hasNext()) {
			String win1 = it1.next();
			driver.switchTo().window(win1);
			String cur_title = driver.getTitle();
			if (cur_title.contains("Campaigns&action")) {
				break;
			}			
		}
		driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
		
		driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
	}
}
