Feature: Create New Customer Account
  
  As a potential customer
  I want to create a new customer account
  So that I can access exclusive features and purchase products

  Background: 
    Given I am on the registration page

  Scenario: Create Account with Valid Information
    When I enter a valid first name "satish"
    And I enter a valid last name "gaware"
    And I enter a valid email address "satishgaware9999@gmail.com"
    And I enter a strong password "Password123!"
    And I confirm the password "Password123!"
    And I click the "Create an Account" button
    Then I should see a success message confirming account creation

  Scenario: Create Account with Empty First Name
    When I enter an empty first name
    And I enter a valid last name "gaware"
    And I enter a valid email address "satishgaware9999@gmail.com"
    And I enter a strong password "Password123!"
    And I confirm the password "Password123!"
    And I click the "Create an Account" button
    Then I should see an error message indicating a missing first name

  Scenario: Create Account with Empty Last Name
    When I enter a valid first name "satish"
    And I enter an empty last name
    And I enter a valid email address "satishgaware9999@gmail.com"
    And I enter a strong password "Password123!"
    And I confirm the password "Password123!"
    And I click the "Create an Account" button
    Then I should see an error message indicating a missing last name

  Scenario: Create Account with Invalid Email Format
    When I enter a valid first name "satish"
    And I enter a valid last name "gaware"
    And I enter an invalid email address "satish.gaware"
    And I enter a strong password "Password123!"
    And I confirm the password "Password123!"
    And I click the "Create an Account" button
    Then I should see an error message indicating an invalid email format

  Scenario: Create Account with Weak Password
    When I enter a valid first name "satish"
    And I enter a valid last name "gaware"
    And I enter a valid email address "satishgaware9999@gmail.com"
    And I enter a weak password "weakPassword"
    And I confirm the password "password"
    And I click the "Create an Account" button
    Then I should see an error message indicating a weak password requirement

  Scenario: Create Account with Mismatched Passwords
    When I enter a valid first name "satish"
    And I enter a valid last name "gaware"
    And I enter a valid email address "satishgaware9999@gmail.com"
    And I enter a strong password "Password123!"
    And I confirm the password with a mismatch "Password1234"
    And I click the "Create an Account" button
    Then I should see an error message indicating password mismatch
