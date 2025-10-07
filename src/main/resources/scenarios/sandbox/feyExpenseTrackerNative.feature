@expenseTrackerFey
Feature: Expense Tracker Feature
  #Sample Test Scenario Description


  Scenario: Expense Tracker Scenario BDD
    Given I start application by id "io.perfecto.expense.tracker"
    Then I should see expense tracker Native login screen
    When I enter "<username>" and "<password>" in native login screen
    Then I click the login button
    Then I must see text "Expenses"
    When I tap hamburger then 'About'
    Then I must see text "Crash"
    When I tap 'Crash Me'

Examples:
   | username | password |
   | test@perfecto.com | test123 |
  |  test@perforce3.com | testxyz |
	