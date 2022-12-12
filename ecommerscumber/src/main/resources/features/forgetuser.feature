@regression
@Reset

Feature: User try to chance has password


  Scenario: User send valid email and make es successfully
    Given user open browser for forgetPassword
    And user navigates to forgetPassword page
    Then user asks to reset with email "islem754@gmail.com"
    And click button rest password
    Then "Email with instructions has been sent to you" is displayed

  Scenario: user resets password with invalid email
    When user asks to reset with email "islem754@g"
    Then "Wrong Email" is displayed


