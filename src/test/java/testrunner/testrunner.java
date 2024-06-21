package testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	@RunWith(Cucumber.class)
	@CucumberOptions(
			features ={"loginPage.feature"},
			glue = {"stepdefination.StepDefinitions.java"},
			dryRun = false,
			monochrome = true
			
			)

	public class testrunner {

	public static void main(String[] args) {

	}

}
