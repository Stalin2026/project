Feature: Login functionality

  As a registered user
  I want to log in
  So that I can access my account

  Scenario: Login with valid credentials
    Given the user is on the login page
    When the user enters username "admin"
    And the user enters password "admin123"
    And the user clicks the login button
    Then the user should be logged in successfully

  Scenario: Login with invalid password
    Given the user is on the login page
    When the user enters username "admin"
    And the user enters password "wrong123"
    And the user clicks the login button
    Then the user should see an "Invalid username or password" error

  Scenario: Login with empty username
    Given the user is on the login page
    When the user enters username ""
    And the user enters password "admin123"
    And the user clicks the login button
    Then the user should see an "Username is required" error
