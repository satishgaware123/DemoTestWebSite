package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ={"createnewUser.feature"},
		glue = {"stepdefination.CreateNewUsers.java"},
		dryRun = false,
		monochrome = true
		
		)



public class CreateNewUser {
	public static void main(String[] args) {

	}
}
