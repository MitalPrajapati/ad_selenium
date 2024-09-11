package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwitchToProduct {

	public SwitchToProduct(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "search_txt")
	private WebElement SearchTextField;
	
	@FindBy(name = "search")
	private WebElement SearchButton;
	
	public void ClickOnProduct(WebDriver driver, String product) {
		driver.findElement(By.xpath("//a[text()='"+product+"']")).click();

	}

	public WebElement getSearchTextField() {
		return SearchTextField;
	} 

	public WebElement getSearchButton() {
		return SearchButton;
	}
	
	
	
	
	}
