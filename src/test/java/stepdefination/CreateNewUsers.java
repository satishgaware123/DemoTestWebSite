package stepdefination;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CreateNewUsers {
	WebDriver driver;	
	
    @Before
    public void setup() {
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\hp\\Downloads\\msedgedriver.exe");
		driver =new EdgeDriver();
		driver.manage().window().maximize();
    }

    @Given("I am on the registration page")
    public void i_am_on_the_registration_page() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
    }

    @When("I enter a valid first name {string}")
    public void i_enter_a_valid_first_name(String firstName) {
        WebElement fname = driver.findElement(By.xpath("//input[@id='firstname']"));
        fname.sendKeys(firstName);
    }

    @When("I enter a valid last name {string}")
    public void i_enter_a_valid_last_name(String lastName) {
        WebElement lname = driver.findElement(By.xpath("//input[@id='lastname']"));
        lname.sendKeys(lastName);
    }

    @When("I enter a valid email address {string}")
    public void i_enter_a_valid_email_address(String email) {
        WebElement emailField = driver.findElement(By.xpath("//input[@id='email_address']"));
        emailField.sendKeys(email);
    }

    @When("I enter a strong password {string}")
    public void i_enter_a_strong_password(String password) {
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys(password);
    }

    @When("I confirm the password {string}")
    public void i_confirm_the_password(String confirmPassword) {
        WebElement confirmPasswordField = driver.findElement(By.xpath("//input[@id='password-confirmation']"));
        confirmPasswordField.sendKeys(confirmPassword);
    }

    @When("I click the {string} button")
    public void i_click_the_button(String buttonName) {
        WebElement createAccountButton = driver.findElement(By.xpath("//button[@title='Create an Account']//span[contains(text(),'Create an Account')]"));
        createAccountButton.click();
    }

    @Then("I should see a success message confirming account creation")
    public void i_should_see_a_success_message_confirming_account_creation() {
        WebElement successMessage = driver.findElement(By.xpath("//li[@class='success-msg']//span"));
        try {
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertEquals("Thank you for registering with Magento.", successMessage.getText().trim());
    }catch(Exception e) {
    	System.out.println(e);
    }
        
    }

    @When("I enter an empty first name")
    public void i_enter_an_empty_first_name() {
        WebElement fname = driver.findElement(By.xpath("//input[@id='firstname']"));
        fname.sendKeys("");
    }

    @Then("I should see an error message indicating a missing first name")
    public void i_should_see_an_error_message_indicating_a_missing_first_name() {
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='firstname-error']"));
       try {
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals("This is a required field.", errorMessage.getText().trim());
    }catch(Exception e) {
    	System.out.println(e);
    }
    }
    @When("I enter an empty last name")
    public void i_enter_an_empty_last_name() {
        WebElement lname = driver.findElement(By.xpath("//input[@id='lastname']"));
        lname.sendKeys("");
    }

    @Then("I should see an error message indicating a missing last name")
    public void i_should_see_an_error_message_indicating_a_missing_last_name() {
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='lastname-error']"));
       try {
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals("This is a required field.", errorMessage.getText().trim());
    }catch(Exception e) {
    	System.out.println(e);
    }
    }
       
    @When("I enter an invalid email address {string}")
    public void i_enter_an_invalid_email_address(String invalidEmail) {
        WebElement emailField = driver.findElement(By.xpath("//input[@id='email_address']"));
        emailField.sendKeys(invalidEmail);
    }

    @Then("I should see an error message indicating an invalid email format")
    public void i_should_see_an_error_message_indicating_an_invalid_email_format() {
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='email_address-error']"));
        try {
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals("Please enter a valid email address. For example johndoe@domain.com.", errorMessage.getText().trim());
    }catch(Exception e) {
    	System.out.println(e);
    }
    }

    @When("I enter a weak password {string}")
    public void i_enter_a_weak_password(String weakPassword) {
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys(weakPassword);
    }

    @Then("I should see an error message indicating a weak password requirement")
    public void i_should_see_an_error_message_indicating_a_weak_password_requirement() {
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='password-error']"));
       try {
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals("Please enter 6 or more characters without leading or trailing spaces.", errorMessage.getText().trim());
    }catch(Exception e) {
    	System.out.println(e);
    }
    }
    

    @When("I confirm the password with a mismatch {string}")
    public void i_confirm_the_password_with_a_mismatch(String mismatchPassword) {
        WebElement confirmPasswordField = driver.findElement(By.xpath("//input[@id='password-confirmation']"));
        confirmPasswordField.sendKeys(mismatchPassword);
    }

    @Then("I should see an error message indicating password mismatch")
    public void i_should_see_an_error_message_indicating_password_mismatch() {
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='password-confirmation-error']"));
     try {
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals("Please make sure your passwords match.", errorMessage.getText().trim());
    }catch(Exception e) {
    	System.out.println(e);
    }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
