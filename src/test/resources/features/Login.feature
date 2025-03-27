Feature: Login Feature

  Scenario: Successful login with valid credentials
    Given I navigate to the login page
    When I enter a valid username and valid password
    Then I should see the homepage