package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//initialization
	//create constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	 
	//Declaration
	@FindBy(name = "user_name")
	private WebElement USerTextField;
	
	@FindBy(css = "[name=\"user_password\"]")
	private WebElement PassWordTextField;
	
	@FindBy(xpath = "//input[@type=\"submit\"]")
	private WebElement LoginButton;

	public WebElement getUSerTextField() {
		return USerTextField;
	}

	public WebElement getPassWordTextField() {
		return PassWordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	//Business logic 
	public void loginToApp(String userName, String password) {
		USerTextField.sendKeys(userName);
		PassWordTextField.sendKeys(password);
		LoginButton.click();
	}
	
	
	
	
}
