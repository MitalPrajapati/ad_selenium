package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {

	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	} 
	
	@FindAll({@FindBy(name = "accountname"),@FindBy(xpath = "//input[@name='accountname']")})
	private WebElement OrganizationName;
	
	@FindBy(id = "phone")
	private WebElement PhoneNo;
	
	@FindBy(id = "email1")
	private WebElement Email;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;

	public WebElement getOrganizationName() {
		return OrganizationName;
	}

	public WebElement getPhoneNo() {
		return PhoneNo;
	}

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}

	public void CreateOrg(String OrgName, String PhNo, String Mail) {
		OrganizationName.sendKeys(OrgName);
		PhoneNo.sendKeys(PhNo);
		Email.sendKeys(Mail);
		SaveButton.click();
	}
}
