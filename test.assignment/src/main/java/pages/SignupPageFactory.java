package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPageFactory {
	private WebDriver driver;
	private WebDriverWait wait;
	JavascriptExecutor js;

	public SignupPageFactory (WebDriver webDriver) {
		driver = webDriver;
		wait = new WebDriverWait(driver, 3);
		js = (JavascriptExecutor) driver;
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
		wait.until(ExpectedConditions.visibilityOf(this.username)).sendKeys(username);
	}

	public void setPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(this.password)).sendKeys(password);
	}

	public void setName(String name) {
		wait.until(ExpectedConditions.visibilityOf(this.name)).sendKeys(name);
	}

	public void setEmail(String email) {
		wait.until(ExpectedConditions.visibilityOf(this.email)).sendKeys(email);
	}

	public void setDayOfBirth(String day) {
		try {
			WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(this.dayOfBirth));
			dropdown.findElement(By.xpath("//option[. = '"+day+"']")).click();
		}catch(NoSuchElementException e) {
			System.out.println(day + " is not a valid day");
		}
	}

	public void setMonthOfBirth(String month) {
		try {
			WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(this.monthOfBirth));
			dropdown.findElement(By.xpath("//option[. = '"+month+"']")).click();
		}catch(NoSuchElementException e) {
			System.out.println(month + " is not a valid month");
		}
	}

	public void setYearOfBirth(String year) {
		try {
			WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(this.yearOfBirth));
			dropdown.findElement(By.xpath("//option[. = '"+year+"']")).click();
		}catch(NoSuchElementException e) {
			System.out.println(year + " is not a valid year");
		}
	}

	public void clickSubmitButton() {
		js.executeScript("arguments[0].click();", submitButton);
	}

	public void setDateOfBirth(String date) {
		String[] dateOfBirth = null;
		dateOfBirth = date.split("-");
		
		setDayOfBirth(dateOfBirth[0]);
		setDayOfBirth(dateOfBirth[1]);
		setDayOfBirth(dateOfBirth[2]);
	}

	public boolean isValidationMessageDisplayed(String fieldName) {  
		return wait.until(ExpectedConditions.attributeToBeNotEmpty(getFieldByName(fieldName), "validationMessage"));		
	}

	public String validationMessage(String fieldName) {
		return (isValidationMessageDisplayed(fieldName)? getFieldByName(fieldName).getAttribute("validationMessage") : "");
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
