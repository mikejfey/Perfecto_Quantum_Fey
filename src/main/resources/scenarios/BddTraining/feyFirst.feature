@expenseTracker
Feature: login functionality

  @feyValid
  Scenario: Login with valid credentials
    Given User navigates to login page
    When User enters valid email address "test@perfeto.com"
    And User enters valid password "test123"
    And User clicks login button
    Then User should login successful
  @feyInvalid
  Scenario: Login with invalid credentials
    Given User navigates to login page
    When User enters invalid email address "bad@perfecto.com"
    And User enters invalid password "xyz"
    Then User should get proper warning message

    @feyNew
    Scenario: login existing customer
      Given User navigates to login page
      Then User logs in with Valid credentials "my@email.com" and "pwd"
      And User enters invalid password "pwd"
      When I enter "test@perf.com" and "pwd" in native login screen

