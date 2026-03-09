@digitalBank
Feature: bank flow

  @E2EfeyDigitalBankTes5t
  Scenario: Digital Bank E2E flow Fey
    Given I launch Digital Banking app on iOS or Android
    Then I should see the Digital Bank Login Screen
    When I click the sign up link
    When I register as a new user
    Then I should see text "Bank"

Feature: login flow

  @feySmokeTest
  Scenario: Digital Bank Checking and Savings flow
    Given I launch Digital Banking app on iOS or Android
    Then I should see the Digital Bank Login Screen
    When I login into Digital Banking
    Then I should see text "Account"
    And I test the Savings flow
    Then I should see text "Savings"
    And I test the Checking flow
    Then The checking account should display
    And I logout of Digital Banking app

  @ATM
  Scenario: Digital Bank Find ATM Flow
    Given I launch Digital Banking app on iOS or Android
    Then I should see the Digital Bank Login Screen
    When I login into Digital Banking
    Then I should see text "Account"
    When I Navigate to the ATM page
    And I find an ATM
    Then I should see text "State"
    And I logout of Digital Banking app

  @Transfer
  Scenario: Digital Bank Transfer Flow
    Given I launch Digital Banking app on iOS or Android
    Then I should see the Digital Bank Login Screen
    When I login into Digital Banking
    Then I should see text "Account"
    When I navigate to the Transfer page
    And I transfer to credit
    Then I should see text "Deposit"
    And I logout of Digital Banking app


  @DigitalBankingE2e
  Scenario: Digital Bank end to end flow - checking savings atm transfer
    Given I launch Digital Banking app on iOS or Android
    Then I should see the Digital Bank Login Screen
    When I login into Digital Banking
    Then I should see text "Account"
    And I test the Savings flow
    Then I should see text "Savings"
    And I test the Checking flow
    Then The checking account should display
    When I Navigate to the ATM page
    And I find an ATM
    Then I should see atm location
    When I navigate to the Transfer page
    And I transfer to credit
    Then I should see text "Deposit"
    And I logout of Digital Banking app






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