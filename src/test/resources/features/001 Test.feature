Feature: 001 Test
  Validate the user can add product to cart

  @Test @SwagLabs @SwagLabs_003 @Failed
  Scenario: Login is working
    Given I have the browser opened in "https://www.saucedemo.com/"

    When I enter the "problem_user" and password "secret_sauce"
    And I click Login button
    And I add 4 products to cart
    And I click cart icon

    Then I should see 4 products added