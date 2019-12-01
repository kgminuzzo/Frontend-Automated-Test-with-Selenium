package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageFactory {
	
	private WebDriver driver;
	private WebDriverWait wait;
	JavascriptExecutor js;
	
	//Initializes the state of the driver
	public LoginPageFactory(WebDriver webDriver) {
		driver = webDriver;
		wait = new WebDriverWait(driver, 10);
		js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	//Page Elements
	@FindBy(id="username_input")
	WebElement userNameField;
	
	@FindBy(id="password_input")
	WebElement passwordField;
	
	@FindBy(id="login_button")
	WebElement loginButton;

	//Actions
	public void setUserName(String userName) {
		wait.until(ExpectedConditions.visibilityOf(userNameField)).sendKeys(userName);
	}

	public void setPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
	}

	public void clickLoginButton() {
		js.executeScript("arguments[0].click();", loginButton);
	}
	
	public void login(String userName, String password) {
		setUserName(userName);
		setPassword(password);
		clickLoginButton();
	}
}
