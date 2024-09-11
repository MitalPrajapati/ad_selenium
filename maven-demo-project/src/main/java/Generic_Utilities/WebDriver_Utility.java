package Generic_Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class WebDriver_Utility {
	WebDriver driver;
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void manimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
 	}
	
	public void fullScreenWindow(WebDriver driver) {
		driver.manage().window().fullscreen();
 	}
	
	public void waitPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
 	}
	
//	public void explicitwait(WebDriver driver, WebElement ele) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
//		element.click();
//	}
	
	public void moveToElement(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).click().perform();
	}
	
	public void switchToPopup(WebDriver driver, String title) {
		Set<String> allWin = driver.getWindowHandles();
		Iterator<String> it = allWin.iterator(); 
		
		while (it.hasNext()) {
			String win = it.next();
			driver.switchTo().window(win);
			String currentTitle = driver.getTitle();
			
			if(currentTitle.contains(title))
			{
				break;
			}
		}
	}
	
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
}
