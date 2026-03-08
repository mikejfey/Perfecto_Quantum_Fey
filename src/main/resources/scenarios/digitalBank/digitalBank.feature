@digitalBank
Feature: bank flow

  @feyDigitalBankTest
  Scenario: Digital Bank E2E flow Fey
    Given I launch Digital Banking app on iOS or Android
    Then I should see the Digital Bank Login Screen
    When I click the sign up link
    When I register as a new user
    Then I should see text "Bank"

Feature: login flow

  @feySmokeTest
  Scenario: Digital Bank login flow Fey
    Given I launch Digital Banking app on iOS or Android
    Then I should see the Digital Bank Login Screen
    When I login into Digital Banking
    Then I should see text "Account"
    And I test the Savings flow
    Then I should see text "Savings"
    And I test the Checking flow
    Then The checking account should display
    And I logout of Digital Banking app

  @e2e
  Scenario: Digital Bank login flow Fey
    Given I launch Digital Banking app on iOS or Android
    Then I should see the Digital Bank Login Screen
    When I login into Digital Banking
    Then I should see text "Account"
    Then I test the Savings flow
    And I logout of Digital Banking app
    Then I should see text "LOGIN"
    When I test a search for the ATM
    Then I should see text "State"







  #Register a dummy user
  #Login with credentials   jsmith@demo.io / Demo123!
#  I Verify the checking flow
#  I verify the savings flow
#  Perform the Funds Transfer
#  I search for the ATM
#  Logout of the application

#    Then I Register a dummy user
#    Then I login to Digital Banking with username ".*" and password ".*"
#    When I verify the checking flow
#    When I verify the savings flow
#    When I perform the transfer funds
#    When I search for the ATM
#    Then I logout of the application