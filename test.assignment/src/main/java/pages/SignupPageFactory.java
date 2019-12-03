package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPageFactory extends BasePage{

	public SignupPageFactory (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	//Page Elements
	@FindBy(id="username_input")
	WebElement username;

	@FindBy(id="password_input")
	WebElement password;

	@FindBy(id="name_input")
	WebElement name;

	@FindBy(id="email_input")
	WebElement email;

	@FindBy(id="day_select")
	WebElement dayOfBirth;

	@FindBy(id="month_select")
	WebElement monthOfBirth;

	@FindBy(id="year_select")
	WebElement yearOfBirth;

	@FindBy(id="submit_button")
	WebElement submitButton;

	//Actions	
	public void setUsername(String username) {
		setText(this.username, username);
	}

	public void setPassword(String password) {
		setText(this.password, password);
	}

	public void setName(String name) {
		setText(this.name, name);
	}

	public void setEmail(String email) {
		setText(this.email, email);
	}

	public void setDayOfBirth(String day) {
		selectInDropdown(dayOfBirth, day);
	}

	public void setMonthOfBirth(String month) {
		selectInDropdown(monthOfBirth, month);
	}

	public void setYearOfBirth(String year) {
		selectInDropdown(yearOfBirth, year);
	}

	public void clickSubmitButton() {
		clickButton(submitButton);
	}

	public void setDateOfBirth(String date) {
		String[] dateOfBirth = null;
		dateOfBirth = date.split("-");
		
		setDayOfBirth(dateOfBirth[0]);
		setDayOfBirth(dateOfBirth[1]);
		setDayOfBirth(dateOfBirth[2]);
	}

	public String validationMessage(String fieldName) {
		return getAttribute(getFieldByName(fieldName),"validationMessage");
	}

	private WebElement getFieldByName(String fieldName) {
		WebElement element = null;
		switch (fieldName.toLowerCase()) {
		case "username":
			element = this.username;
			break;
		case "password":
			element = this.password;
			break;
		case "name":
			element = this.name;
			break;
		case "email":
			element = this.email;
			break;
		default:
			break;
		}
		return element;
	}
}
