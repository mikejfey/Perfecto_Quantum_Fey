@expenseTrackerDataDriven
Feature: Expense Tracker Feature
  #Sample Test Scenario Description

@invalidLogin
  Scenario: Expense Tracker invalid login Scenario
    Given I start application by id "io.perfecto.expense.tracker"
    Then I should see expense tracker Native login screen
    When I login with INVALID creds from datafile  "<username>" and "<password>"
    Then I must see text "Email"


#for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/invalidExpenseLogins.csv'}

  @validLogin
  Scenario: Expense Tracker VALID login Scenario
    Given I start application by id "io.perfecto.expense.tracker"
    Then I should see expense tracker Native login screen
    When I login with VALID creds from datafile  "<username>" and "<password>"
    Then I must see text "Expenses"
    When I tap hamburger then 'About'
    Then I must see text "Crash"
    When I tap 'Crash Me'


#for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/validExpenseLogins.csv'}