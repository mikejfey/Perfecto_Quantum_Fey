@IOS_expenseSignup
Feature: Bio Expense Tracker Feature
  #Sample Test Scenario Description


  Scenario: Signup Scenario
    Given I start application by id "io.perfecto.expense.tracker"
    Then I should see expense tracker Native login screen
    When I click the signup link
    Then I should see text "Confirm Password"




	