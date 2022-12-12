@login

Feature: user should be able to login to the system



  #test scenairo 1

  Scenario: user login with valid username and password
    Given user open browser
    And user navigates to login page
    When user enter "islem754@gmail.com" and "01156231562"
   Then he gets redirected to home page as authenticated user
    Then he stays on the same page and error messeges for invalid login appear







    #test scenairo 2
  Scenario: user login with invalid username and password
    Given user open browser
    And user navigates to login page
    When user enter "islem754@gmail.com" and "06231562"

    Then he gets redirected to home page as authenticated user
    Then he stays on the same page and error messeges for invalid login appear

