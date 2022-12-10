@regression

Feature: user should be able to login to the system



  #test scenairo 1

  Scenario: user login with valid username and password
    Given user open browser
    And user navigates to login page
    When user enter "islem754@gmail.com" and "01156231562"
    And user click in login button
# Expected result


    And user go to home page


    #test scenairo 2
  Scenario: user login with invalid username and password
    Given user open browser
    And user navigates to login page
    When user enter "islem754@gmail.com" and "06231562"
    And user click in login button
    Then user could login successfully
    And user go to home page

