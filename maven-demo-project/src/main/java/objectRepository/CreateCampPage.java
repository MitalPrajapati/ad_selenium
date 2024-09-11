package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampPage {

	public CreateCampPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(name = "campaignname")
	private WebElement CampName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveCamp;

	public WebElement getCampName() {
		return CampName;
	}

	public WebElement getSaveCamp() {
		return SaveCamp;
	}
	
	public void CreateCampaign(String CampaignName) {
		CampName.sendKeys(CampaignName);
		SaveCamp.click();
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement AddProductIcone;

	public WebElement getAddProductIcone() {
		return AddProductIcone;
	}
	
	
	
}
