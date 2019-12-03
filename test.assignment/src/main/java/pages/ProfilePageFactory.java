package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePageFactory extends BasePage{
	
	//Initializes the state of the driver
	public ProfilePageFactory(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//Page Elements
	@FindBy(css="p:nth-child(2)")
	WebElement profileBody;

	
	public String profileBodyText() {
		return getText(profileBody);
	}
	
	//TODO: Increment this class in order to be able to test user authorization
}
