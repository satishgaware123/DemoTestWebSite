Feature: User Registration

  Scenario: Register a new user
    Given I navigate to the registration page
    When I fill in the registration form with "<email>" and "<password>"
    And I submit the registration form
    Then I should see "<expectedOutcome>" message

    Examples: 
      | email                     | password   | expectedOutcome               |
      | satishgaware998@gmail.com | Satish@123 | Registration successful       |
      | test2@example.com         | Password2  | Another expected outcome here |
      | test3@example.com         | Password3  | And another expected outcome  |
