package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(name = "productname")
	private WebElement ProName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;
	
	public WebElement getProName() {
		return ProName;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}

	//business logic
	public void CreateProduct(String ProductName) {
		ProName.sendKeys(ProductName);
		SaveButton.click();
	}
	
}
