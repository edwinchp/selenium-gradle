Feature: 001 Navbar
  Validate the user can see options menu

  @Test @SwagLabs @SwagLabs_004 @Passed
  Scenario: Login is working
    Given I have the browser opened in "https://www.saucedemo.com/"

    When I enter the "standard_user" and password "secret_sauce"
    And I click Login button
    And I click menu button

    Then I should see all menu options