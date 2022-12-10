@regression

Feature: User can add product to cart and chek out


  Scenario: member wil try to add product to cart
    Given user open browser to add to cart
    And user navigates to login page to make order
    Then user enter user and password to go to has account "islam754@gmail.com" and "01001043234"
    And user click in login button to has account
    And user navigates to home page to shopping
    And user click on category Sweatshirts button to add to cart
    And user can select neu product to add to cart
    And user can select neu product to can show to add to cart
    And user can select color to add to cart
    And user can select size to add to cart
    And user can select design to add to cart
    And  user can click on add to cart button to add to cart
    And user can click on add to cart button to add to cart