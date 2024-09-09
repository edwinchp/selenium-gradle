Feature: 002 Swag Labs
  Login to saucedemo.com

  @Test @SwagLabs @SwagLabs_002 @Failed
  Scenario: Login is working
    Given I have the browser opened in "https://www.saucedemo.com/"

    When I enter the "locked_out_user" and password "secret_sauce"
    And I click Login button

    Then I can see the Products section