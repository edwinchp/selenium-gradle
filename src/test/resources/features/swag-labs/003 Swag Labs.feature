Feature: 003 Swag Labs
  Validate the user can add product to cart

  Background:
    Given I have the browser opened in "https://www.saucedemo.com/"

  @Test @SwagLabs @SwagLabs_003 @Failed
  Scenario: Login is working
    When I enter the "problem_user" and password "secret_sauce"
    And I click Login button
    And I add 4 products to cart
    And I click cart icon

    Then I should see 4 products added

  @Test @SwagLabs @SwagLabs_003 @Passed
  Scenario: Login is working
    When I enter the "standard_user" and password "secret_sauce"
    And I click Login button
    And I add 4 products to cart
    And I click cart icon

    Then I should see 4 products added