@regression

Feature: User registers new account


  Scenario: User registers with valid email or valid password
    Given user open browser for register
    And user navigates to register page
    When user enter valid "islamAhmed" and "islamahmed2321152@gmail.com" and "01001043234" and "01001043234" and "01001043234"
    And user click in register button
    And user navigates to home page



  Scenario: User registers with Currently data valid data
    Given user open browser for register
    And user navigates to register page
    When user enter valid "islam" and "islem754@gmail.com" and "01156231562" and "01156231562" and "01156231562"
    And user click in register button
    Then user could login  unsuccessfully



