package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HeaderPageFactory {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public HeaderPageFactory (WebDriver webDriver) {
		driver = webDriver;
		wait = new WebDriverWait(driver, 10);
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
		wait.until(ExpectedConditions.visibilityOf(loginLink)).click();
	}
	
	public void clickSignUp() {
		wait.until(ExpectedConditions.visibilityOf(signupLink)).click();
	}
	
	public String statusText() {
		return wait.until(ExpectedConditions.visibilityOf(status)).getText();
	}

}
