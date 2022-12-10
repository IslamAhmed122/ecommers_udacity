@regression

Feature: User try to chance has password


  Scenario: User send valid email and make es successfully
    Given user open browser for forgetPassword
    And user navigates to forgetPassword page
    Then use email to change password "islem754@gmail.com"
    And click button rest password
    Then valid rest password
    Then invalid password



  Scenario: User registers with Currently data valid data
    Given user open browser for forgetPassword
    And user navigates to forgetPassword page
    Then use email to change password "islem754515484218541@gmail.com"
    Then valid rest password
    Then invalid password