@expenseTrackerHappy
Feature: Expense Tracker Feature
  #Sample Test Scenario Description


  Scenario: Expense Tracker Scenario
    Given I start application by id "io.perfecto.expense.tracker"
    Then I should see expense tracker Native login screen
    When I enter invalid credentials "test@perfecto.com" and "badPW" in native login screen
    Then I must see text "Email"
    When I enter "test@perfecto.com" and "test123" in native login screen
    Then I click the login button
    Then I must see text "Expenses"
    When I tap hamburger then 'About'



	