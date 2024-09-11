package objectRepository;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class delete_Product {

	public delete_Product(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnProduct(WebDriver driver, String product) {
		driver.findElement(By.xpath("//table[@class='lvt small']//tbody//td//a[text()='"+product+"']/../..//td//input[@type=\"checkbox\"]")).click();
	}
	
	@FindBy(xpath = "//input[@class='crmbutton small delete']")
	private WebElement deleteButton;

	public WebElement getDeleteButton() {
		return deleteButton;
	}
	

	public void validatePrdDeleted(WebDriver driver,String prdName)
	{
		 java.util.List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
		
		 boolean flag=false;
			 
		 for(WebElement prdName1:productList)
		 {
			String actData = prdName1.getText();
			System.out.println(actData);
			if(actData.equalsIgnoreCase(prdName))
			{
				flag=true;
				break;
			}
		 }
		 System.out.println(flag);
		if(!flag)
		{
			System.out.println("product data is deleted");
		}else {
			System.out.println("product data is not deleted");
		}
	} 
}

	
	
	
	
	
	
	

