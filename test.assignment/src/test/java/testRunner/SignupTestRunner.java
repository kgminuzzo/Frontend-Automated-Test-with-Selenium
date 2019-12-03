package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*This runner will trigger the tests from Signup feature file
 * A json file will be generated with the testing results
 * A report will be created based on the json files created during the execution
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src/test/resources/Signup.feature", 
		glue="stepDefinitions",
		stepNotifications = true,
		plugin = {"json:target/signup.json"},
		monochrome = true
		)
public class SignupTestRunner {

}
