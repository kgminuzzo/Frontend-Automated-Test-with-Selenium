package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HeaderPageFactory;
import pages.LoginPageFactory;
import utils.Driver;

public class LoginTest {

	private WebDriver driver;
	
	@Before("@Login")
	public void before() {
		driver = new Driver().getDriver();
		new LoginPageFactory(driver).navigateToHomePage();
	}
	
	@Given("^user is on the login page$")
	public void user_is_on_the_login_page() {
		new HeaderPageFactory(driver).clickLogin();
	}
	
	@When("^user enters username (.*)$")
	public void user_enters_username(String username) {
		new LoginPageFactory(driver).setUserName(username);
	}
	
	@And("^user enters password (.*)$")
	public void user_enters_password(String password) {
		new LoginPageFactory(driver).setPassword(password);
	}
	
	@And("^user clicks login button$")
	public void user_clicks_login_button() {
		new LoginPageFactory(driver).clickLoginButton();
	}
	
	@Then("^user should see a message (.*)$")
	public void user_should_see_a_message(String message) {
		String messageFound = new HeaderPageFactory(driver).statusText();
		System.out.println("Message found when logging in: "+messageFound);
		assertTrue(messageFound.startsWith(message));
	}
	
	@After("@Login")
	public void tearDown() {
		driver.quit();
	}
	
}
