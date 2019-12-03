package stepDefinitions;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import com.google.common.base.Strings;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HeaderPageFactory;
import pages.ProfilePageFactory;
import pages.SignupPageFactory;
import utils.Driver;

public class SignupTest {
	private WebDriver driver;

	@Before("@Login")
	public void before() {
		driver = new Driver().getDriver();
		new SignupPageFactory(driver).navigateToHomePage();
	}
	
	@Given("^user is on the signup page$")
	public void user_is_on_signup_page() {
		new HeaderPageFactory(driver).clickSignUp();
	}

	@When("^user enters the data$")
	public void user_enters_the_data(DataTable userData) {
		List<Map<String, String>> data = userData.asMaps(String.class, String.class);
		SignupPageFactory signupPage = new SignupPageFactory(driver);
		signupPage.setUsername(Strings.nullToEmpty(data.get(0).get("username")));
		signupPage.setPassword(data.get(0).get("password"));
		signupPage.setName(data.get(0).get("name"));
		signupPage.setEmail(data.get(0).get("email"));
		signupPage.setDateOfBirth(data.get(0).get("date of birth"));
	}

	@When("^user enters the data (.*),(.*),(.*),(.*) and (.*)$")
	public void user_enters_the_data(String username, String password, String name, String email, String dateOfBirth) {
		SignupPageFactory signupPage = new SignupPageFactory(driver);
		signupPage.setUsername(Strings.nullToEmpty(username));
		signupPage.setPassword(Strings.nullToEmpty(password));
		signupPage.setName(Strings.nullToEmpty(name));
		signupPage.setEmail(Strings.nullToEmpty(email));
		signupPage.setDateOfBirth(dateOfBirth);
	}

	@And("^user clicks submit button$")
	public void user_clicks_submit_button() {
		new SignupPageFactory(driver).clickSubmitButton();
	}

	@Then("^user should see a welcome message (.*)$")
	public void user_should_see_a_welcome_message(String message) {
		String text = new ProfilePageFactory(driver).profileBodyText();
		System.out.println("Expected: " + message + " Found: " + text);
		assertTrue(text.startsWith(message));
	}

	@Then("^user should not see a welcome message (.*)$")
	public void user_should_not_see_a_welcome_message(String message) {
		assertThrows(TimeoutException.class, () -> new ProfilePageFactory(driver).profileBodyText());
	}

	@Then("^user should see a warning message (.*)")
	public void user_should_see_a_warning_message(String message) {
		String text = new HeaderPageFactory(driver).statusText();
		System.out.println("Expected: " + message + " Found: " + text);
		assertTrue(text.startsWith(message));
	}

	@Then("^user should see a hint informing that the field (.*) should be populated")
	public void user_should_see_a_hint(String fieldName) {
		String hint = new SignupPageFactory(driver).validationMessage(fieldName);
		System.out.println("Hint message: " + hint);
		assertTrue(hint != null && !hint.isEmpty());
	}

	@After("@Signup")
	public void tearDown() {
		driver.quit();
	}

}
