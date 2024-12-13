@Web
Feature: Google Search

@WebDDcsv
  Scenario Outline: Search Keyword CSV Data
    Given I am on Google Search Page
    When I search for "<searchKey>"
    Then it should have "<searchResult>" in search results

    #for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/testData.csv'}

  @WebSearch @retry @TC-1
  Scenario: Search Quantum
    Given I am on Google Search Page
    When I search for "perfecto mobile quantum"
    Then it should have "perfecto" in search results
    Then I am on Google Search Page

  @WebResultsList
  Scenario: Search Quantum with results
    Given I am on Google Search Page
    When I search for "perfecto mobile quantum"
    Then it should have following search results:
      | perfecto |
      | Quantum |

  @WebDD
  Scenario Outline: Search Keyword Inline Data
    Given I am on Google Search Page
    When I search for "<searchKey>"
    Then it should have "<searchResult>" in search results
    Examples:
      | recId | recDescription 	| searchKey               | searchResult                  |
      | 1     | First Data Set	| perfecto mobile quantum       | Quantum |
      | 2     | Second Data Set 	|perfecto mobile quantum| perfecto |

  @WebDDxml
  Scenario Outline: Search Keyword from XML Data
    Given I am on Google Search Page
    When I search for "<searchKey>"
    Then it should have "<searchResult>" in search results

    #xml file must be in directory listed in env.resources property
    Examples: {'key' : 'demo.websearch.dataset'}

  
    

