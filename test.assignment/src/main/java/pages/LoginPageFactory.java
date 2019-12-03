package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage{
	
	//Initializes the state of the driver
	public LoginPageFactory(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
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
		setText(userNameField, userName);
	}

	public void setPassword(String password) {
		setText(passwordField, password);
	}

	public void clickLoginButton() {
		clickButton(loginButton);
	}
	
	public void login(String userName, String password) {
		setUserName(userName);
		setPassword(password);
		clickLoginButton();
	}
}
