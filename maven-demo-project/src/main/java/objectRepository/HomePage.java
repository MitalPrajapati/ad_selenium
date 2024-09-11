package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	 
	@FindBy(linkText = "Organizations")
	private WebElement OrgLink;
	
	@FindBy(linkText = "Products")
	private WebElement ProductLink;
	
	@FindBy(linkText = "More")
	private WebElement MoreLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement CampaignLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminLink;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement SignOut;
	
	public WebElement getOrgLink() {
		return OrgLink;
	}

	public WebElement getProductLink() {
		return ProductLink;
	}

	public WebElement getMoreLink() {
		return MoreLink;
	}

	public WebElement getCampaignLink() {
		return CampaignLink;
	}

	public WebElement getAdminLink() {
		return AdminLink;
	}

	public WebElement getSignOut() {
		return SignOut;
	}
	
	//Business Logic
	public void ClickOnCampaign() {
		MoreLink.click();
		CampaignLink.click();
	}
	
	public void signOutApp(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(AdminLink).perform();
		SignOut.click();
		
	}
	
	 public void logOutFromApp()
	    {
		 AdminLink.click();
	     SignOut.click();
	    }
}
