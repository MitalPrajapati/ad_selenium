package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	 
	@FindBy(css = "[alt=\"Create Organization...\"]")
	private WebElement OrgPluseIcone;

	public WebElement getOrgPluseIcone() {
		return OrgPluseIcone;
	}
	
	public void ClickOrgPlus() {
		OrgPluseIcone.click();
	}
}
