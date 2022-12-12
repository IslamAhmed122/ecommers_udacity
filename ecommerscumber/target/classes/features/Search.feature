@regression
@search

Feature: User try to search about any thing


  Scenario: i will send valid word and invalid word
    Given user open browser to search
    And user navigates to home page to search
    When send any valid word for search "تيشرت"
    And click or press enter to search
    Then product results appear
    Then "No products were found" message is displayed





  Scenario: i will send valid word and invalid word
    Given user open browser to search
    And user navigates to home page to search
    When send any valid word for search "ىنتىهناىاهخ"
    And click or press enter to search