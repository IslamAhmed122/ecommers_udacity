@regression

Feature: User registers new account


  Scenario: User registers with valid email or valid password
    Given user open browser for register
    And user navigates to register page
    When user enter valid "islamAhmed" and "islamahmed2321152@gmail.com" and "01001043234" and "01001043234" and "01001043234"
    And user click in register button
    And user navigates to home page
    Then he can register successfully and "Your registeration completed" messege appears



  Scenario: User registers with invalid email or invalid password or mismatch password
    When user enter valid "islamAhmed" and "islamahmed2321152@gmail.com" and "01001043234" and "01001043234" and "01001043234"
    Then error messeges for invalid fields appear

  Scenario: User registers with any empty data field
    When user enter valid "islamAhmed" and "islamahmed2321152@gmail.com" and "01001043234" and "01001043234" and "01001043234"
    Then error messeges for invalid fields appear

  Scenario: User registers with an existing email
    When user enter valid "islamAhmed" and "islamahmed2321152@gmail.com" and "01001043234" and "01001043234" and "01001043234"

    Then error messeges for existing account appear