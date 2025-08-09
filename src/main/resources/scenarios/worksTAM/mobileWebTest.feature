@first
Feature: Validate Quantum Installation
  Scenario: open Wikipedia
    Given I open browser to webpage "https://www.wikipedia.org/"
    And I click no thanks button on chrome notification if it is displayed
    Then I must see text "Wikipedia"