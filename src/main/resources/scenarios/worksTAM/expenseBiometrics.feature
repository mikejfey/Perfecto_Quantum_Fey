@IOS_Bio_expenseTracker
Feature: Bio Expense Tracker Feature
  #Sample Test Scenario Description


  Scenario: Biometrics Scenario
    Given I start application by id "io.perfecto.expense.tracker"
    Then I should see expense tracker Native login screen
    When I enter "test@perfecto.com" and "test123" in native login screen
    Then I click the enable Biometrics
    Then I click the login button
    And I send success result for biometrics
    Then I should see expense tracker home screen



	