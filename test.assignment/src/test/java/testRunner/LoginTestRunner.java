package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*This runner will trigger the tests from Login feature file
 * A json file will be generated with the testing results
 * A report will be created based on the json files created during teh execution
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src/test/resources/Login.feature", 
		glue="stepDefinitions",
		stepNotifications = true,		
		plugin = {"json:target/login.json"},
		monochrome = true
		)

public class LoginTestRunner {


}