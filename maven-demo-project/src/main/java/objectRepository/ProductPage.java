package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mysql.jdbc.Driver;

public class ProductPage {

	WebDriver driver;
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	 
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement ProductPlusSign;

	public WebElement getProductPlusSign() {
		return ProductPlusSign;
	}

}
