Feature: 001 Login
  Login to saucedemo.com

  @Test @SwagLabs @SwagLabs_001 @Failed
  Scenario Outline: Login is working
    Given I have the browser opened in "https://www.saucedemo.com/"

    When I enter the "<username>" and password "<password>"
    And I click Login button

    Then I can see the Products section

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |