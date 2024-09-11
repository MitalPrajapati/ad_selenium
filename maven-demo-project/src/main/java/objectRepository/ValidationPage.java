package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class ValidationPage {

	public ValidationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ValidateProduct(WebDriver driver, String data) {
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		
		if(actData.contains(data)) {
			System.out.println("Product is created");
		}
		else {
			System.out.println("Product is not created");
		}
	}
	
	
	public String ValidateProd(WebDriver driver) {
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		return actData;
	}
	
	public String ValidateOrg(WebDriver driver) {
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		return actData;
	}
}
