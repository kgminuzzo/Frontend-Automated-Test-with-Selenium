package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePageFactory {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	//Initializes the state of the driver
	public ProfilePageFactory(WebDriver webDriver) {
		driver = webDriver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
	
	//Page Elements
	@FindBy(css="p:nth-child(2)")
	WebElement profileBody;

	
	public String profileBodyText() {
		return wait.until(ExpectedConditions.visibilityOf(profileBody)).getText();
	}
	
	//TODO: Increment this class in order to be able to test user authorization
}
