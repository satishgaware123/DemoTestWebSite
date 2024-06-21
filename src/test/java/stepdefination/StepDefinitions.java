package stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	WebDriver driver;	
	
    @Before
    public void setup() {
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\hp\\Downloads\\msedgedriver.exe");
		driver =new EdgeDriver();
		driver.manage().window().maximize();
    }
	
	@Given("I navigate to the registration page")
	public void i_navigate_to_the_registration_page() {
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement signUp=	driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]"));
		signUp.click();
	}

	@When("I fill in the registration form with {string} and {string}")
	public void i_fill_in_the_registration_form_with_and(String email, String password) {

		WebElement email1=driver.findElement(By.id("email"));
		email1.sendKeys(email);	
		
		WebElement pass=driver.findElement(By.id("pass"));
		pass.sendKeys(password);	
	}

	@When("I submit the registration form")
	public void i_submit_the_registration_form() {
		WebElement signUp=driver.findElement(By.id("send2"));
		signUp.click();
	}

	@Then("I should see {string} message")
	public void i_should_see_message(String string) {
		try {
		WebElement title=driver.findElement(By.xpath("(//li//span[@class='logged-in'])[1]"));
		String actualtitle = title.getText();
		
		Assert.assertEquals(actualtitle,"Welcome, satish gaware!","login unsucessful");
		}catch(Exception e) {
			
		}
	}
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}