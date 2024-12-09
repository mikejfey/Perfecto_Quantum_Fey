@biometrics
Feature: Bio Expense Tracker Feature
  #Sample Test Scenario Description


  Scenario: Biometrics Scenario
    Given I start application by id "io.perfecto.expense.tracker"
    Then I should see expense tracker Native login screen
    Then I click the enable Biometrics checkbox
    When I enter "test@perfecto.com" and "test123" in native login screen
    And I set fingerprint with success result to application by id "io.perfecto.expense.tracker"
    Then I must see text "Expenses"


	