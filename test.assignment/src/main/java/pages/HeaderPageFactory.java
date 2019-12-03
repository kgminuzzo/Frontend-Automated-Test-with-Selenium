package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HeaderPageFactory extends BasePage{
	
	public HeaderPageFactory (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//Page Elements
	@FindBy(id="login_link")
	WebElement loginLink;
	
	@FindBy(id="status")
	WebElement status;

	@FindBy(id="signup_link")
	WebElement signupLink;

	//Actions	
	public void clickLogin() {
		click(loginLink);
	}
	
	public void clickSignUp() {
		click(signupLink);
	}
	
	public String statusText() {
		return getText(status);
	}

}
