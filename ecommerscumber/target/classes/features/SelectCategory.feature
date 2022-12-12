@regression
@category

Feature: User try to search about any thing


  Scenario: i will send valid word and invalid word
    Given user open browser to select category
    And user navigates to home page to select category
    Then user click on category button
    And user click on category Sweatshirts button
    And user can select neu product to can show
    Then he is redirected to "تيشرت" page


  Scenario: user chooses a category without a sub category
        Then he is redirected to "t-sh" page
